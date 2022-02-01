package org.libpag;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.opengl.EGLContext;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.extra.tools.ScreenBroadcastReceiver;
import org.extra.tools.ScreenBroadcastReceiver.a;
import org.extra.tools.a;

public class PAGView
  extends TextureView
  implements TextureView.SurfaceTextureListener, ScreenBroadcastReceiver.a
{
  private static final int ANDROID_SDK_VERSION_O = 26;
  private static final int MSG_FLUSH = 0;
  private static final int MSG_HANDLER_THREAD_QUITE = 2;
  private static final int MSG_SURFACE_DESTROY = 1;
  private static final String TAG = "PAGView";
  private static final Object g_HandlerLock;
  private static volatile int g_HandlerThreadCount;
  private static PAGRendererHandler g_PAGRendererHandler;
  private static HandlerThread g_PAGRendererThread;
  private Boolean _isAnimatorPreRunning;
  private boolean _isPlaying;
  private ValueAnimator animator;
  private volatile double animatorProgress;
  private volatile long currentPlayTime;
  private String filePath;
  private SparseArray<PAGImage> imageReplacementMap;
  private boolean isAttachedToWindow;
  private Runnable mAnimatorCancelRunnable;
  private final AnimatorListenerAdapter mAnimatorListenerAdapter;
  private Runnable mAnimatorStartRunnable;
  private final ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
  private TextureView.SurfaceTextureListener mListener;
  private ArrayList<PAGFlushListener> mPAGFlushListeners;
  private boolean mSaveVisibleState;
  private ArrayList<PAGViewListener> mViewListeners;
  private PAGFile pagFile;
  private PAGPlayer pagPlayer;
  private PAGSurface pagSurface;
  private boolean preAggregatedVisible;
  private EGLContext sharedContext;
  private SparseArray<PAGText> textReplacementMap;
  
  static
  {
    AppMethodBeat.i(195508);
    g_HandlerLock = new Object();
    g_PAGRendererHandler = null;
    g_PAGRendererThread = null;
    g_HandlerThreadCount = 0;
    Object localObject = a.iVd();
    if (((a)localObject).abLt == null)
    {
      ((a)localObject).abLt = new ScreenBroadcastReceiver((ScreenBroadcastReceiver.a)localObject);
      localObject = ((a)localObject).abLt;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      try
      {
        Context localContext = ScreenBroadcastReceiver.getApplicationContext();
        if (localContext != null) {
          localContext.registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
        }
        AppMethodBeat.o(195508);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(195508);
  }
  
  public PAGView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(195345);
    this._isPlaying = false;
    this._isAnimatorPreRunning = null;
    this.filePath = "";
    this.isAttachedToWindow = false;
    this.sharedContext = null;
    this.textReplacementMap = new SparseArray();
    this.imageReplacementMap = new SparseArray();
    this.mViewListeners = new ArrayList();
    this.mPAGFlushListeners = new ArrayList();
    this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(195304);
        PAGView.access$202(PAGView.this, paramAnonymousValueAnimator.getCurrentPlayTime());
        PAGView.access$400(PAGView.this, ((Float)PAGView.this.animator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(195304);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(195317);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationCancel(PAGView.this);
          }
        }
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(195316);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationEnd(PAGView.this);
          }
        }
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(195319);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationRepeat(PAGView.this);
          }
        }
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(195311);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationStart(PAGView.this);
          }
        }
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(195325);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(195325);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(195327);
        PAGView.access$202(PAGView.this, PAGView.this.animator.getCurrentPlayTime());
        PAGView.this.animator.cancel();
        AppMethodBeat.o(195327);
      }
    };
    this.preAggregatedVisible = true;
    setupSurfaceTexture();
    AppMethodBeat.o(195345);
  }
  
  public PAGView(Context paramContext, EGLContext paramEGLContext)
  {
    super(paramContext);
    AppMethodBeat.i(195346);
    this._isPlaying = false;
    this._isAnimatorPreRunning = null;
    this.filePath = "";
    this.isAttachedToWindow = false;
    this.sharedContext = null;
    this.textReplacementMap = new SparseArray();
    this.imageReplacementMap = new SparseArray();
    this.mViewListeners = new ArrayList();
    this.mPAGFlushListeners = new ArrayList();
    this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(195304);
        PAGView.access$202(PAGView.this, paramAnonymousValueAnimator.getCurrentPlayTime());
        PAGView.access$400(PAGView.this, ((Float)PAGView.this.animator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(195304);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(195317);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationCancel(PAGView.this);
          }
        }
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(195316);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationEnd(PAGView.this);
          }
        }
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(195319);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationRepeat(PAGView.this);
          }
        }
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(195311);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationStart(PAGView.this);
          }
        }
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(195325);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(195325);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(195327);
        PAGView.access$202(PAGView.this, PAGView.this.animator.getCurrentPlayTime());
        PAGView.this.animator.cancel();
        AppMethodBeat.o(195327);
      }
    };
    this.preAggregatedVisible = true;
    this.sharedContext = paramEGLContext;
    setupSurfaceTexture();
    AppMethodBeat.o(195346);
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(195348);
    this._isPlaying = false;
    this._isAnimatorPreRunning = null;
    this.filePath = "";
    this.isAttachedToWindow = false;
    this.sharedContext = null;
    this.textReplacementMap = new SparseArray();
    this.imageReplacementMap = new SparseArray();
    this.mViewListeners = new ArrayList();
    this.mPAGFlushListeners = new ArrayList();
    this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(195304);
        PAGView.access$202(PAGView.this, paramAnonymousValueAnimator.getCurrentPlayTime());
        PAGView.access$400(PAGView.this, ((Float)PAGView.this.animator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(195304);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(195317);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationCancel(PAGView.this);
          }
        }
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(195316);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationEnd(PAGView.this);
          }
        }
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(195319);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationRepeat(PAGView.this);
          }
        }
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(195311);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationStart(PAGView.this);
          }
        }
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(195325);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(195325);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(195327);
        PAGView.access$202(PAGView.this, PAGView.this.animator.getCurrentPlayTime());
        PAGView.this.animator.cancel();
        AppMethodBeat.o(195327);
      }
    };
    this.preAggregatedVisible = true;
    setupSurfaceTexture();
    AppMethodBeat.o(195348);
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195349);
    this._isPlaying = false;
    this._isAnimatorPreRunning = null;
    this.filePath = "";
    this.isAttachedToWindow = false;
    this.sharedContext = null;
    this.textReplacementMap = new SparseArray();
    this.imageReplacementMap = new SparseArray();
    this.mViewListeners = new ArrayList();
    this.mPAGFlushListeners = new ArrayList();
    this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(195304);
        PAGView.access$202(PAGView.this, paramAnonymousValueAnimator.getCurrentPlayTime());
        PAGView.access$400(PAGView.this, ((Float)PAGView.this.animator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(195304);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(195317);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationCancel(PAGView.this);
          }
        }
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(195316);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationEnd(PAGView.this);
          }
        }
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(195319);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationRepeat(PAGView.this);
          }
        }
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(195311);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          ArrayList localArrayList = new ArrayList(PAGView.this.mViewListeners);
          ??? = localArrayList.iterator();
          if (???.hasNext()) {
            ((PAGView.PAGViewListener)???.next()).onAnimationStart(PAGView.this);
          }
        }
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(195325);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(195325);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(195327);
        PAGView.access$202(PAGView.this, PAGView.this.animator.getCurrentPlayTime());
        PAGView.this.animator.cancel();
        AppMethodBeat.o(195327);
      }
    };
    this.preAggregatedVisible = true;
    setupSurfaceTexture();
    AppMethodBeat.o(195349);
  }
  
  private static void DestroyHandlerThread()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(195338);
        int i = g_HandlerThreadCount - 1;
        g_HandlerThreadCount = i;
        if (i != 0)
        {
          AppMethodBeat.o(195338);
          return;
        }
        if ((g_PAGRendererHandler == null) || (g_PAGRendererThread == null))
        {
          AppMethodBeat.o(195338);
          continue;
        }
        if (g_PAGRendererThread.isAlive()) {
          break label74;
        }
      }
      finally {}
      AppMethodBeat.o(195338);
      continue;
      label74:
      SendMessage(2, null);
      AppMethodBeat.o(195338);
    }
  }
  
  private static void HandlerThreadQuit()
  {
    AppMethodBeat.i(195344);
    if (g_HandlerThreadCount != 0)
    {
      AppMethodBeat.o(195344);
      return;
    }
    if ((g_PAGRendererHandler == null) || (g_PAGRendererThread == null))
    {
      AppMethodBeat.o(195344);
      return;
    }
    if (!g_PAGRendererThread.isAlive())
    {
      AppMethodBeat.o(195344);
      return;
    }
    g_PAGRendererHandler.removeCallbacksAndMessages(null);
    if (Build.VERSION.SDK_INT > 18) {
      g_PAGRendererThread.quitSafely();
    }
    for (;;)
    {
      g_PAGRendererThread = null;
      g_PAGRendererHandler = null;
      AppMethodBeat.o(195344);
      return;
      g_PAGRendererThread.quit();
    }
  }
  
  private static void NeedsUpdateView(PAGView paramPAGView)
  {
    AppMethodBeat.i(195343);
    if (g_PAGRendererHandler == null)
    {
      AppMethodBeat.o(195343);
      return;
    }
    g_PAGRendererHandler.needsUpdateView(paramPAGView);
    AppMethodBeat.o(195343);
  }
  
  private static void SendMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(195341);
    if (g_PAGRendererHandler == null)
    {
      AppMethodBeat.o(195341);
      return;
    }
    Message localMessage = g_PAGRendererHandler.obtainMessage();
    localMessage.arg1 = paramInt;
    if (paramObject != null) {
      localMessage.obj = paramObject;
    }
    g_PAGRendererHandler.sendMessage(localMessage);
    AppMethodBeat.o(195341);
  }
  
  private static void StartHandlerThread()
  {
    try
    {
      AppMethodBeat.i(195337);
      g_HandlerThreadCount += 1;
      if (g_PAGRendererThread == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("pag-renderer");
        g_PAGRendererThread = localHandlerThread;
        localHandlerThread.start();
      }
      if (g_PAGRendererHandler == null) {
        g_PAGRendererHandler = new PAGRendererHandler(g_PAGRendererThread.getLooper());
      }
      AppMethodBeat.o(195337);
      return;
    }
    finally {}
  }
  
  private void applyReplacements()
  {
    int j = 0;
    AppMethodBeat.i(195478);
    PAGFile localPAGFile = (PAGFile)this.pagPlayer.getComposition();
    if (localPAGFile == null)
    {
      AppMethodBeat.o(195478);
      return;
    }
    int i = 0;
    while (i < this.textReplacementMap.size())
    {
      localPAGFile.replaceText(this.textReplacementMap.keyAt(i), (PAGText)this.textReplacementMap.valueAt(i));
      i += 1;
    }
    this.textReplacementMap.clear();
    i = j;
    while (i < this.imageReplacementMap.size())
    {
      localPAGFile.replaceImage(this.imageReplacementMap.keyAt(i), (PAGImage)this.imageReplacementMap.valueAt(i));
      i += 1;
    }
    this.imageReplacementMap.clear();
    AppMethodBeat.o(195478);
  }
  
  private void cancelAnimator()
  {
    AppMethodBeat.i(195400);
    if (isMainThread())
    {
      this.currentPlayTime = this.animator.getCurrentPlayTime();
      this.animator.cancel();
      AppMethodBeat.o(195400);
      return;
    }
    removeCallbacks(this.mAnimatorStartRunnable);
    post(this.mAnimatorCancelRunnable);
    AppMethodBeat.o(195400);
  }
  
  private void doPlay()
  {
    AppMethodBeat.i(195392);
    if (!this.isAttachedToWindow)
    {
      AppMethodBeat.o(195392);
      return;
    }
    this.animator.setCurrentPlayTime(this.currentPlayTime);
    startAnimator();
    AppMethodBeat.o(195392);
  }
  
  private boolean isMainThread()
  {
    AppMethodBeat.i(195395);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(195395);
      return true;
    }
    AppMethodBeat.o(195395);
    return false;
  }
  
  private void onAnimationUpdate(double paramDouble)
  {
    AppMethodBeat.i(195351);
    this.animatorProgress = paramDouble;
    NeedsUpdateView(this);
    AppMethodBeat.o(195351);
  }
  
  private void pauseAnimator()
  {
    AppMethodBeat.i(195493);
    if (this._isAnimatorPreRunning == null) {
      this._isAnimatorPreRunning = Boolean.valueOf(this.animator.isRunning());
    }
    if (this.animator.isRunning()) {
      cancelAnimator();
    }
    AppMethodBeat.o(195493);
  }
  
  private void resumeAnimator()
  {
    AppMethodBeat.i(195495);
    if ((!this._isPlaying) || (this.animator.isRunning()) || ((this._isAnimatorPreRunning != null) && (!this._isAnimatorPreRunning.booleanValue())))
    {
      this._isAnimatorPreRunning = null;
      AppMethodBeat.o(195495);
      return;
    }
    this._isAnimatorPreRunning = null;
    doPlay();
    AppMethodBeat.o(195495);
  }
  
  private void setupSurfaceTexture()
  {
    AppMethodBeat.i(195353);
    setOpaque(false);
    this.pagPlayer = new PAGPlayer();
    setSurfaceTextureListener(this);
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.animator.setRepeatCount(0);
    this.animator.setInterpolator(new LinearInterpolator());
    AppMethodBeat.o(195353);
  }
  
  private void startAnimator()
  {
    AppMethodBeat.i(195396);
    if (isMainThread())
    {
      this.animator.start();
      AppMethodBeat.o(195396);
      return;
    }
    removeCallbacks(this.mAnimatorCancelRunnable);
    post(this.mAnimatorStartRunnable);
    AppMethodBeat.o(195396);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(195355);
    if (!this.isAttachedToWindow)
    {
      AppMethodBeat.o(195355);
      return;
    }
    this.pagPlayer.setProgress(this.animatorProgress);
    flush();
    if (!this.mPAGFlushListeners.isEmpty()) {
      post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(195322);
          synchronized (PAGView.this)
          {
            ArrayList localArrayList = new ArrayList(PAGView.this.mPAGFlushListeners);
            ??? = localArrayList.iterator();
            if (((Iterator)???).hasNext()) {
              ((PAGView.PAGFlushListener)((Iterator)???).next()).onFlush();
            }
          }
        }
      });
    }
    AppMethodBeat.o(195355);
  }
  
  @Deprecated
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(195411);
    this.animator.addListener(paramAnimatorListener);
    AppMethodBeat.o(195411);
  }
  
  public void addListener(PAGViewListener paramPAGViewListener)
  {
    AppMethodBeat.i(195405);
    try
    {
      this.mViewListeners.add(paramPAGViewListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(195405);
    }
  }
  
  public void addPAGFlushListener(PAGFlushListener paramPAGFlushListener)
  {
    AppMethodBeat.i(195408);
    try
    {
      this.mPAGFlushListeners.add(paramPAGFlushListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(195408);
    }
  }
  
  public boolean cacheEnabled()
  {
    AppMethodBeat.i(195433);
    boolean bool = this.pagPlayer.cacheEnabled();
    AppMethodBeat.o(195433);
    return bool;
  }
  
  public float cacheScale()
  {
    AppMethodBeat.i(195436);
    float f = this.pagPlayer.cacheScale();
    AppMethodBeat.o(195436);
    return f;
  }
  
  public long duration()
  {
    AppMethodBeat.i(195451);
    long l = this.pagPlayer.duration();
    AppMethodBeat.o(195451);
    return l;
  }
  
  public boolean flush()
  {
    AppMethodBeat.i(195456);
    boolean bool = this.pagPlayer.flush();
    AppMethodBeat.o(195456);
    return bool;
  }
  
  @Deprecated
  public boolean flush(boolean paramBoolean)
  {
    AppMethodBeat.i(195466);
    paramBoolean = flush();
    AppMethodBeat.o(195466);
    return paramBoolean;
  }
  
  public void freeCache()
  {
    AppMethodBeat.i(195459);
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
    AppMethodBeat.o(195459);
  }
  
  public PAGComposition getComposition()
  {
    AppMethodBeat.i(195423);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    AppMethodBeat.o(195423);
    return localPAGComposition;
  }
  
  @Deprecated
  public PAGFile getFile()
  {
    return this.pagFile;
  }
  
  public PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(195458);
    PAGLayer[] arrayOfPAGLayer = this.pagPlayer.getLayersUnderPoint(paramFloat1, paramFloat2);
    AppMethodBeat.o(195458);
    return arrayOfPAGLayer;
  }
  
  public String getPath()
  {
    return this.filePath;
  }
  
  public double getProgress()
  {
    AppMethodBeat.i(195452);
    double d = this.pagPlayer.getProgress();
    AppMethodBeat.o(195452);
    return d;
  }
  
  @Deprecated
  public PAGComposition getRootComposition()
  {
    AppMethodBeat.i(195465);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    AppMethodBeat.o(195465);
    return localPAGComposition;
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(195386);
    if (this.animator != null)
    {
      boolean bool = this.animator.isRunning();
      AppMethodBeat.o(195386);
      return bool;
    }
    AppMethodBeat.o(195386);
    return false;
  }
  
  public Matrix matrix()
  {
    AppMethodBeat.i(195448);
    Matrix localMatrix = this.pagPlayer.matrix();
    AppMethodBeat.o(195448);
    return localMatrix;
  }
  
  public float maxFrameRate()
  {
    AppMethodBeat.i(195438);
    float f = this.pagPlayer.maxFrameRate();
    AppMethodBeat.o(195438);
    return f;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(195375);
    this.isAttachedToWindow = true;
    super.onAttachedToWindow();
    this.animator.addListener(this.mAnimatorListenerAdapter);
    ??? = a.iVd();
    Object localObject2;
    if (((a)???).abLt != null)
    {
      ((a)???).iVe();
      synchronized (((a)???).abLs)
      {
        localObject2 = a.rEV.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (this != ((WeakReference)((Iterator)localObject2).next()).get());
      }
    }
    synchronized (g_HandlerLock)
    {
      for (;;)
      {
        StartHandlerThread();
        resumeAnimator();
        AppMethodBeat.o(195375);
        return;
        localObject2 = new WeakReference(this);
        a.rEV.add(localObject2);
      }
      localObject3 = finally;
      AppMethodBeat.o(195375);
      throw localObject3;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(195381);
    this.isAttachedToWindow = false;
    super.onDetachedFromWindow();
    ??? = a.iVd();
    if (((a)???).abLt != null) {
      ((a)???).iVe();
    }
    label181:
    for (;;)
    {
      synchronized (((a)???).abLs)
      {
        Iterator localIterator = a.rEV.iterator();
        ??? = null;
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if (this != localWeakReference.get()) {
            break label181;
          }
          ??? = localWeakReference;
          break label181;
        }
        if (??? != null) {
          a.rEV.remove(???);
        }
        if (this.pagSurface != null)
        {
          this.pagSurface.release();
          this.pagSurface = null;
        }
        pauseAnimator();
        if (Build.VERSION.SDK_INT >= 26) {}
      }
      synchronized (g_HandlerLock)
      {
        DestroyHandlerThread();
        this.animator.removeListener(this.mAnimatorListenerAdapter);
        AppMethodBeat.o(195381);
        return;
        localObject2 = finally;
        AppMethodBeat.o(195381);
        throw localObject2;
      }
    }
  }
  
  public void onScreenOff()
  {
    AppMethodBeat.i(195481);
    if (getVisibility() == 0)
    {
      this.mSaveVisibleState = true;
      setVisibility(4);
    }
    AppMethodBeat.o(195481);
  }
  
  public void onScreenOn()
  {
    AppMethodBeat.i(195485);
    if (this.mSaveVisibleState) {
      setVisibility(0);
    }
    this.mSaveVisibleState = false;
    AppMethodBeat.o(195485);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195362);
    if (this.pagSurface != null)
    {
      this.pagSurface.release();
      this.pagSurface = null;
    }
    this.pagSurface = PAGSurface.FromSurfaceTexture(paramSurfaceTexture, this.sharedContext);
    this.pagPlayer.setSurface(this.pagSurface);
    if (this.pagSurface == null)
    {
      AppMethodBeat.o(195362);
      return;
    }
    this.animator.addUpdateListener(this.mAnimatorUpdateListener);
    if (!this.mPAGFlushListeners.isEmpty())
    {
      this.pagSurface.clearAll();
      NeedsUpdateView(this);
    }
    for (;;)
    {
      if (this.mListener != null) {
        this.mListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
      }
      AppMethodBeat.o(195362);
      return;
      flush();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    boolean bool2 = true;
    AppMethodBeat.i(195373);
    this.pagPlayer.setSurface(null);
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureDestroyed(???);
    }
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
    this.animator.removeUpdateListener(this.mAnimatorUpdateListener);
    boolean bool1 = bool2;
    if (g_PAGRendererHandler != null)
    {
      bool1 = bool2;
      if (??? != null)
      {
        SendMessage(1, ???);
        bool1 = false;
      }
    }
    if (Build.VERSION.SDK_INT >= 26) {}
    synchronized (g_HandlerLock)
    {
      DestroyHandlerThread();
      AppMethodBeat.o(195373);
      return bool1;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195367);
    if (this.pagSurface != null)
    {
      this.pagSurface.updateSize();
      if (this.mPAGFlushListeners.isEmpty()) {
        break label68;
      }
      this.pagSurface.clearAll();
      NeedsUpdateView(this);
    }
    for (;;)
    {
      if (this.mListener != null) {
        this.mListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
      }
      AppMethodBeat.o(195367);
      return;
      label68:
      flush();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(195382);
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureUpdated(paramSurfaceTexture);
    }
    AppMethodBeat.o(195382);
  }
  
  public void onVisibilityAggregated(boolean paramBoolean)
  {
    AppMethodBeat.i(195491);
    super.onVisibilityAggregated(paramBoolean);
    if (this.preAggregatedVisible == paramBoolean)
    {
      AppMethodBeat.o(195491);
      return;
    }
    this.preAggregatedVisible = paramBoolean;
    if (paramBoolean)
    {
      resumeAnimator();
      AppMethodBeat.o(195491);
      return;
    }
    pauseAnimator();
    AppMethodBeat.o(195491);
  }
  
  public void play()
  {
    AppMethodBeat.i(195388);
    this._isPlaying = true;
    this._isAnimatorPreRunning = null;
    doPlay();
    AppMethodBeat.o(195388);
  }
  
  @Deprecated
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(195414);
    this.animator.removeListener(paramAnimatorListener);
    AppMethodBeat.o(195414);
  }
  
  public void removeListener(PAGViewListener paramPAGViewListener)
  {
    AppMethodBeat.i(195407);
    try
    {
      this.mViewListeners.remove(paramPAGViewListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(195407);
    }
  }
  
  public void removePAGFlushListener(PAGFlushListener paramPAGFlushListener)
  {
    AppMethodBeat.i(195410);
    try
    {
      this.mPAGFlushListeners.remove(paramPAGFlushListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(195410);
    }
  }
  
  @Deprecated
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    AppMethodBeat.i(195474);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null))
    {
      AppMethodBeat.o(195474);
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceImage(paramInt, paramPAGImage);
      AppMethodBeat.o(195474);
      return;
    }
    this.imageReplacementMap.put(paramInt, paramPAGImage);
    AppMethodBeat.o(195474);
  }
  
  public int scaleMode()
  {
    AppMethodBeat.i(195443);
    int i = this.pagPlayer.scaleMode();
    AppMethodBeat.o(195443);
    return i;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(195489);
    if ((Build.VERSION.SDK_INT < 24) && (paramDrawable != null)) {
      super.setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(195489);
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(195435);
    this.pagPlayer.setCacheEnabled(paramBoolean);
    AppMethodBeat.o(195435);
  }
  
  public void setCacheScale(float paramFloat)
  {
    AppMethodBeat.i(195437);
    this.pagPlayer.setCacheScale(paramFloat);
    AppMethodBeat.o(195437);
  }
  
  public void setComposition(PAGComposition paramPAGComposition)
  {
    AppMethodBeat.i(195426);
    this.filePath = null;
    this.pagFile = null;
    this.pagPlayer.setComposition(paramPAGComposition);
    long l = this.pagPlayer.duration();
    this.animator.setDuration(l / 1000L);
    AppMethodBeat.o(195426);
  }
  
  @Deprecated
  public void setFile(PAGFile paramPAGFile)
  {
    AppMethodBeat.i(195462);
    if (paramPAGFile != null) {}
    for (PAGFile localPAGFile = paramPAGFile.copyOriginal();; localPAGFile = null)
    {
      setComposition(localPAGFile);
      this.pagFile = paramPAGFile;
      if (this.pagFile != null) {
        applyReplacements();
      }
      AppMethodBeat.o(195462);
      return;
    }
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(195450);
    this.pagPlayer.setMatrix(paramMatrix);
    AppMethodBeat.o(195450);
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    AppMethodBeat.i(195441);
    this.pagPlayer.setMaxFrameRate(paramFloat);
    AppMethodBeat.o(195441);
  }
  
  public boolean setPath(String paramString)
  {
    AppMethodBeat.i(195417);
    if ((paramString != null) && (paramString.startsWith("assets://"))) {}
    for (PAGFile localPAGFile = PAGFile.Load(getContext().getAssets(), paramString.substring(9));; localPAGFile = PAGFile.Load(paramString))
    {
      setComposition(localPAGFile);
      this.filePath = paramString;
      if (localPAGFile == null) {
        break;
      }
      AppMethodBeat.o(195417);
      return true;
    }
    AppMethodBeat.o(195417);
    return false;
  }
  
  public void setProgress(double paramDouble)
  {
    AppMethodBeat.i(195455);
    paramDouble = Math.max(0.0D, Math.min(paramDouble, 1.0D));
    this.currentPlayTime = ((this.animator.getDuration() * paramDouble));
    this.animator.setCurrentPlayTime(this.currentPlayTime);
    onAnimationUpdate(paramDouble);
    AppMethodBeat.o(195455);
  }
  
  public void setRepeatCount(int paramInt)
  {
    AppMethodBeat.i(195403);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.animator.setRepeatCount(i - 1);
    AppMethodBeat.o(195403);
  }
  
  public void setScaleMode(int paramInt)
  {
    AppMethodBeat.i(195445);
    this.pagPlayer.setScaleMode(paramInt);
    AppMethodBeat.o(195445);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(195356);
    if (paramSurfaceTextureListener == this)
    {
      super.setSurfaceTextureListener(paramSurfaceTextureListener);
      AppMethodBeat.o(195356);
      return;
    }
    this.mListener = paramSurfaceTextureListener;
    AppMethodBeat.o(195356);
  }
  
  @Deprecated
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    AppMethodBeat.i(195470);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null))
    {
      AppMethodBeat.o(195470);
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceText(paramInt, paramPAGText);
      AppMethodBeat.o(195470);
      return;
    }
    this.textReplacementMap.put(paramInt, paramPAGText);
    AppMethodBeat.o(195470);
  }
  
  public void setVideoEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(195431);
    this.pagPlayer.setVideoEnabled(paramBoolean);
    AppMethodBeat.o(195431);
  }
  
  public void stop()
  {
    AppMethodBeat.i(195393);
    this._isPlaying = false;
    this._isAnimatorPreRunning = null;
    cancelAnimator();
    AppMethodBeat.o(195393);
  }
  
  public boolean videoEnabled()
  {
    AppMethodBeat.i(195428);
    boolean bool = this.pagPlayer.videoEnabled();
    AppMethodBeat.o(195428);
    return bool;
  }
  
  public static abstract interface PAGFlushListener
  {
    public abstract void onFlush();
  }
  
  static class PAGRendererHandler
    extends Handler
  {
    private final Object lock;
    private List<PAGView> needsUpdateViews;
    
    PAGRendererHandler(Looper paramLooper)
    {
      super();
      AppMethodBeat.i(195329);
      this.lock = new Object();
      this.needsUpdateViews = new ArrayList();
      AppMethodBeat.o(195329);
    }
    
    public void handleMessage(Message arg1)
    {
      AppMethodBeat.i(195332);
      super.handleMessage(???);
      switch (???.arg1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(195332);
        return;
        synchronized (this.lock)
        {
          Object localObject1 = new ArrayList(this.needsUpdateViews);
          this.needsUpdateViews.clear();
          ??? = new ArrayList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = ((Iterator)localObject1).next();
            if ((localObject3 instanceof PAGView))
            {
              localObject3 = (PAGView)localObject3;
              if (!???.contains(localObject3))
              {
                PAGView.access$000((PAGView)localObject3);
                ???.add(localObject3);
              }
            }
          }
        }
        if (!(???.obj instanceof SurfaceTexture))
        {
          AppMethodBeat.o(195332);
          return;
        }
        ((SurfaceTexture)???.obj).release();
        AppMethodBeat.o(195332);
        return;
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(195328);
            PAGView.access$100();
            AppMethodBeat.o(195328);
          }
        });
      }
    }
    
    void needsUpdateView(PAGView paramPAGView)
    {
      AppMethodBeat.i(195330);
      synchronized (this.lock)
      {
        if (this.needsUpdateViews.isEmpty())
        {
          Message localMessage = obtainMessage();
          localMessage.arg1 = 0;
          sendMessage(localMessage);
        }
        this.needsUpdateViews.add(paramPAGView);
        AppMethodBeat.o(195330);
        return;
      }
    }
  }
  
  public static abstract interface PAGViewListener
  {
    public abstract void onAnimationCancel(PAGView paramPAGView);
    
    public abstract void onAnimationEnd(PAGView paramPAGView);
    
    public abstract void onAnimationRepeat(PAGView paramPAGView);
    
    public abstract void onAnimationStart(PAGView paramPAGView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.libpag.PAGView
 * JD-Core Version:    0.7.0.1
 */