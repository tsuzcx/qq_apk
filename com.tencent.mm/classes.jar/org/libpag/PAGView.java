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
    AppMethodBeat.i(187523);
    g_HandlerLock = new Object();
    g_PAGRendererHandler = null;
    g_PAGRendererThread = null;
    g_HandlerThreadCount = 0;
    Object localObject = a.kJB();
    if (((a)localObject).ajYm == null)
    {
      ((a)localObject).ajYm = new ScreenBroadcastReceiver((ScreenBroadcastReceiver.a)localObject);
      localObject = ((a)localObject).ajYm;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      try
      {
        Context localContext = ScreenBroadcastReceiver.getApplicationContext();
        if (localContext != null) {
          localContext.registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
        }
        AppMethodBeat.o(187523);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(187523);
  }
  
  public PAGView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(187375);
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
        AppMethodBeat.i(187328);
        PAGView.access$202(PAGView.this, paramAnonymousValueAnimator.getCurrentPlayTime());
        PAGView.access$400(PAGView.this, ((Float)PAGView.this.animator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(187328);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(187497);
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
        AppMethodBeat.i(187491);
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
        AppMethodBeat.i(187504);
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
        AppMethodBeat.i(187485);
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
        AppMethodBeat.i(187472);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(187472);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187470);
        PAGView.access$202(PAGView.this, PAGView.this.animator.getCurrentPlayTime());
        PAGView.this.animator.cancel();
        AppMethodBeat.o(187470);
      }
    };
    this.preAggregatedVisible = true;
    setupSurfaceTexture();
    AppMethodBeat.o(187375);
  }
  
  public PAGView(Context paramContext, EGLContext paramEGLContext)
  {
    super(paramContext);
    AppMethodBeat.i(187383);
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
        AppMethodBeat.i(187328);
        PAGView.access$202(PAGView.this, paramAnonymousValueAnimator.getCurrentPlayTime());
        PAGView.access$400(PAGView.this, ((Float)PAGView.this.animator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(187328);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(187497);
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
        AppMethodBeat.i(187491);
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
        AppMethodBeat.i(187504);
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
        AppMethodBeat.i(187485);
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
        AppMethodBeat.i(187472);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(187472);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187470);
        PAGView.access$202(PAGView.this, PAGView.this.animator.getCurrentPlayTime());
        PAGView.this.animator.cancel();
        AppMethodBeat.o(187470);
      }
    };
    this.preAggregatedVisible = true;
    this.sharedContext = paramEGLContext;
    setupSurfaceTexture();
    AppMethodBeat.o(187383);
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(187390);
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
        AppMethodBeat.i(187328);
        PAGView.access$202(PAGView.this, paramAnonymousValueAnimator.getCurrentPlayTime());
        PAGView.access$400(PAGView.this, ((Float)PAGView.this.animator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(187328);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(187497);
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
        AppMethodBeat.i(187491);
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
        AppMethodBeat.i(187504);
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
        AppMethodBeat.i(187485);
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
        AppMethodBeat.i(187472);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(187472);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187470);
        PAGView.access$202(PAGView.this, PAGView.this.animator.getCurrentPlayTime());
        PAGView.this.animator.cancel();
        AppMethodBeat.o(187470);
      }
    };
    this.preAggregatedVisible = true;
    setupSurfaceTexture();
    AppMethodBeat.o(187390);
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187397);
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
        AppMethodBeat.i(187328);
        PAGView.access$202(PAGView.this, paramAnonymousValueAnimator.getCurrentPlayTime());
        PAGView.access$400(PAGView.this, ((Float)PAGView.this.animator.getAnimatedValue()).floatValue());
        AppMethodBeat.o(187328);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(187497);
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
        AppMethodBeat.i(187491);
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
        AppMethodBeat.i(187504);
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
        AppMethodBeat.i(187485);
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
        AppMethodBeat.i(187472);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(187472);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187470);
        PAGView.access$202(PAGView.this, PAGView.this.animator.getCurrentPlayTime());
        PAGView.this.animator.cancel();
        AppMethodBeat.o(187470);
      }
    };
    this.preAggregatedVisible = true;
    setupSurfaceTexture();
    AppMethodBeat.o(187397);
  }
  
  private static void DestroyHandlerThread()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187327);
        int i = g_HandlerThreadCount - 1;
        g_HandlerThreadCount = i;
        if (i != 0)
        {
          AppMethodBeat.o(187327);
          return;
        }
        if ((g_PAGRendererHandler == null) || (g_PAGRendererThread == null))
        {
          AppMethodBeat.o(187327);
          continue;
        }
        if (g_PAGRendererThread.isAlive()) {
          break label74;
        }
      }
      finally {}
      AppMethodBeat.o(187327);
      continue;
      label74:
      SendMessage(2, null);
      AppMethodBeat.o(187327);
    }
  }
  
  private static void HandlerThreadQuit()
  {
    AppMethodBeat.i(187368);
    if (g_HandlerThreadCount != 0)
    {
      AppMethodBeat.o(187368);
      return;
    }
    if ((g_PAGRendererHandler == null) || (g_PAGRendererThread == null))
    {
      AppMethodBeat.o(187368);
      return;
    }
    if (!g_PAGRendererThread.isAlive())
    {
      AppMethodBeat.o(187368);
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
      AppMethodBeat.o(187368);
      return;
      g_PAGRendererThread.quit();
    }
  }
  
  private static void NeedsUpdateView(PAGView paramPAGView)
  {
    AppMethodBeat.i(187361);
    if (g_PAGRendererHandler == null)
    {
      AppMethodBeat.o(187361);
      return;
    }
    g_PAGRendererHandler.needsUpdateView(paramPAGView);
    AppMethodBeat.o(187361);
  }
  
  private static void SendMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(187338);
    if (g_PAGRendererHandler == null)
    {
      AppMethodBeat.o(187338);
      return;
    }
    Message localMessage = g_PAGRendererHandler.obtainMessage();
    localMessage.arg1 = paramInt;
    if (paramObject != null) {
      localMessage.obj = paramObject;
    }
    g_PAGRendererHandler.sendMessage(localMessage);
    AppMethodBeat.o(187338);
  }
  
  private static void StartHandlerThread()
  {
    try
    {
      AppMethodBeat.i(187317);
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
      AppMethodBeat.o(187317);
      return;
    }
    finally {}
  }
  
  private void applyReplacements()
  {
    int j = 0;
    AppMethodBeat.i(187462);
    PAGFile localPAGFile = (PAGFile)this.pagPlayer.getComposition();
    if (localPAGFile == null)
    {
      AppMethodBeat.o(187462);
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
    AppMethodBeat.o(187462);
  }
  
  private void cancelAnimator()
  {
    AppMethodBeat.i(187448);
    if (isMainThread())
    {
      this.currentPlayTime = this.animator.getCurrentPlayTime();
      this.animator.cancel();
      AppMethodBeat.o(187448);
      return;
    }
    removeCallbacks(this.mAnimatorStartRunnable);
    post(this.mAnimatorCancelRunnable);
    AppMethodBeat.o(187448);
  }
  
  private void doPlay()
  {
    AppMethodBeat.i(187422);
    if (!this.isAttachedToWindow)
    {
      AppMethodBeat.o(187422);
      return;
    }
    this.animator.setCurrentPlayTime(this.currentPlayTime);
    startAnimator();
    AppMethodBeat.o(187422);
  }
  
  private boolean isMainThread()
  {
    AppMethodBeat.i(187429);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(187429);
      return true;
    }
    AppMethodBeat.o(187429);
    return false;
  }
  
  private void onAnimationUpdate(double paramDouble)
  {
    AppMethodBeat.i(187404);
    this.animatorProgress = paramDouble;
    NeedsUpdateView(this);
    AppMethodBeat.o(187404);
  }
  
  private void pauseAnimator()
  {
    AppMethodBeat.i(187469);
    if (this._isAnimatorPreRunning == null) {
      this._isAnimatorPreRunning = Boolean.valueOf(this.animator.isRunning());
    }
    if (this.animator.isRunning()) {
      cancelAnimator();
    }
    AppMethodBeat.o(187469);
  }
  
  private void resumeAnimator()
  {
    AppMethodBeat.i(187477);
    if ((!this._isPlaying) || (this.animator.isRunning()) || ((this._isAnimatorPreRunning != null) && (!this._isAnimatorPreRunning.booleanValue())))
    {
      this._isAnimatorPreRunning = null;
      AppMethodBeat.o(187477);
      return;
    }
    this._isAnimatorPreRunning = null;
    doPlay();
    AppMethodBeat.o(187477);
  }
  
  private void setupSurfaceTexture()
  {
    AppMethodBeat.i(187406);
    setOpaque(false);
    this.pagPlayer = new PAGPlayer();
    setSurfaceTextureListener(this);
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.animator.setRepeatCount(0);
    this.animator.setInterpolator(new LinearInterpolator());
    AppMethodBeat.o(187406);
  }
  
  private void startAnimator()
  {
    AppMethodBeat.i(187440);
    if (isMainThread())
    {
      this.animator.start();
      AppMethodBeat.o(187440);
      return;
    }
    removeCallbacks(this.mAnimatorCancelRunnable);
    post(this.mAnimatorStartRunnable);
    AppMethodBeat.o(187440);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(187415);
    if (!this.isAttachedToWindow)
    {
      AppMethodBeat.o(187415);
      return;
    }
    this.pagPlayer.setProgress(this.animatorProgress);
    flush();
    if (!this.mPAGFlushListeners.isEmpty()) {
      post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(187486);
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
    AppMethodBeat.o(187415);
  }
  
  @Deprecated
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(187595);
    this.animator.addListener(paramAnimatorListener);
    AppMethodBeat.o(187595);
  }
  
  public void addListener(PAGViewListener paramPAGViewListener)
  {
    AppMethodBeat.i(187582);
    try
    {
      this.mViewListeners.add(paramPAGViewListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(187582);
    }
  }
  
  public void addPAGFlushListener(PAGFlushListener paramPAGFlushListener)
  {
    AppMethodBeat.i(187589);
    try
    {
      this.mPAGFlushListeners.add(paramPAGFlushListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(187589);
    }
  }
  
  public boolean cacheEnabled()
  {
    AppMethodBeat.i(187620);
    boolean bool = this.pagPlayer.cacheEnabled();
    AppMethodBeat.o(187620);
    return bool;
  }
  
  public float cacheScale()
  {
    AppMethodBeat.i(187627);
    float f = this.pagPlayer.cacheScale();
    AppMethodBeat.o(187627);
    return f;
  }
  
  public long duration()
  {
    AppMethodBeat.i(187652);
    long l = this.pagPlayer.duration();
    AppMethodBeat.o(187652);
    return l;
  }
  
  public boolean flush()
  {
    AppMethodBeat.i(187665);
    boolean bool = this.pagPlayer.flush();
    AppMethodBeat.o(187665);
    return bool;
  }
  
  @Deprecated
  public boolean flush(boolean paramBoolean)
  {
    AppMethodBeat.i(187691);
    paramBoolean = flush();
    AppMethodBeat.o(187691);
    return paramBoolean;
  }
  
  public void freeCache()
  {
    AppMethodBeat.i(187674);
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
    AppMethodBeat.o(187674);
  }
  
  public PAGComposition getComposition()
  {
    AppMethodBeat.i(187608);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    AppMethodBeat.o(187608);
    return localPAGComposition;
  }
  
  @Deprecated
  public PAGFile getFile()
  {
    return this.pagFile;
  }
  
  public PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(187670);
    PAGLayer[] arrayOfPAGLayer = this.pagPlayer.getLayersUnderPoint(paramFloat1, paramFloat2);
    AppMethodBeat.o(187670);
    return arrayOfPAGLayer;
  }
  
  public String getPath()
  {
    return this.filePath;
  }
  
  public double getProgress()
  {
    AppMethodBeat.i(187654);
    double d = this.pagPlayer.getProgress();
    AppMethodBeat.o(187654);
    return d;
  }
  
  @Deprecated
  public PAGComposition getRootComposition()
  {
    AppMethodBeat.i(187686);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    AppMethodBeat.o(187686);
    return localPAGComposition;
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(187565);
    if (this.animator != null)
    {
      boolean bool = this.animator.isRunning();
      AppMethodBeat.o(187565);
      return bool;
    }
    AppMethodBeat.o(187565);
    return false;
  }
  
  public Matrix matrix()
  {
    AppMethodBeat.i(187646);
    Matrix localMatrix = this.pagPlayer.matrix();
    AppMethodBeat.o(187646);
    return localMatrix;
  }
  
  public float maxFrameRate()
  {
    AppMethodBeat.i(187633);
    float f = this.pagPlayer.maxFrameRate();
    AppMethodBeat.o(187633);
    return f;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(187552);
    this.isAttachedToWindow = true;
    super.onAttachedToWindow();
    this.animator.addListener(this.mAnimatorListenerAdapter);
    ??? = a.kJB();
    Object localObject2;
    if (((a)???).ajYm != null)
    {
      ((a)???).kJC();
      synchronized (((a)???).ajYl)
      {
        localObject2 = a.uQh.iterator();
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
        AppMethodBeat.o(187552);
        return;
        localObject2 = new WeakReference(this);
        a.uQh.add(localObject2);
      }
      localObject3 = finally;
      AppMethodBeat.o(187552);
      throw localObject3;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(187558);
    this.isAttachedToWindow = false;
    super.onDetachedFromWindow();
    ??? = a.kJB();
    if (((a)???).ajYm != null) {
      ((a)???).kJC();
    }
    label181:
    for (;;)
    {
      synchronized (((a)???).ajYl)
      {
        Iterator localIterator = a.uQh.iterator();
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
          a.uQh.remove(???);
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
        AppMethodBeat.o(187558);
        return;
        localObject2 = finally;
        AppMethodBeat.o(187558);
        throw localObject2;
      }
    }
  }
  
  public void onScreenOff()
  {
    AppMethodBeat.i(187705);
    if (getVisibility() == 0)
    {
      this.mSaveVisibleState = true;
      setVisibility(4);
    }
    AppMethodBeat.o(187705);
  }
  
  public void onScreenOn()
  {
    AppMethodBeat.i(187709);
    if (this.mSaveVisibleState) {
      setVisibility(0);
    }
    this.mSaveVisibleState = false;
    AppMethodBeat.o(187709);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187535);
    if (this.pagSurface != null)
    {
      this.pagSurface.release();
      this.pagSurface = null;
    }
    this.pagSurface = PAGSurface.FromSurfaceTexture(paramSurfaceTexture, this.sharedContext);
    this.pagPlayer.setSurface(this.pagSurface);
    if (this.pagSurface == null)
    {
      AppMethodBeat.o(187535);
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
      AppMethodBeat.o(187535);
      return;
      flush();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    boolean bool2 = true;
    AppMethodBeat.i(187544);
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
      AppMethodBeat.o(187544);
      return bool1;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187538);
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
      AppMethodBeat.o(187538);
      return;
      label68:
      flush();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(187561);
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureUpdated(paramSurfaceTexture);
    }
    AppMethodBeat.o(187561);
  }
  
  public void onVisibilityAggregated(boolean paramBoolean)
  {
    AppMethodBeat.i(187724);
    super.onVisibilityAggregated(paramBoolean);
    if (this.preAggregatedVisible == paramBoolean)
    {
      AppMethodBeat.o(187724);
      return;
    }
    this.preAggregatedVisible = paramBoolean;
    if (paramBoolean)
    {
      resumeAnimator();
      AppMethodBeat.o(187724);
      return;
    }
    pauseAnimator();
    AppMethodBeat.o(187724);
  }
  
  public void play()
  {
    AppMethodBeat.i(187570);
    this._isPlaying = true;
    this._isAnimatorPreRunning = null;
    doPlay();
    AppMethodBeat.o(187570);
  }
  
  @Deprecated
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(187597);
    this.animator.removeListener(paramAnimatorListener);
    AppMethodBeat.o(187597);
  }
  
  public void removeListener(PAGViewListener paramPAGViewListener)
  {
    AppMethodBeat.i(187585);
    try
    {
      this.mViewListeners.remove(paramPAGViewListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(187585);
    }
  }
  
  public void removePAGFlushListener(PAGFlushListener paramPAGFlushListener)
  {
    AppMethodBeat.i(187592);
    try
    {
      this.mPAGFlushListeners.remove(paramPAGFlushListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(187592);
    }
  }
  
  @Deprecated
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    AppMethodBeat.i(187701);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null))
    {
      AppMethodBeat.o(187701);
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceImage(paramInt, paramPAGImage);
      AppMethodBeat.o(187701);
      return;
    }
    this.imageReplacementMap.put(paramInt, paramPAGImage);
    AppMethodBeat.o(187701);
  }
  
  public int scaleMode()
  {
    AppMethodBeat.i(187639);
    int i = this.pagPlayer.scaleMode();
    AppMethodBeat.o(187639);
    return i;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(187716);
    if ((Build.VERSION.SDK_INT < 24) && (paramDrawable != null)) {
      super.setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(187716);
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(187624);
    this.pagPlayer.setCacheEnabled(paramBoolean);
    AppMethodBeat.o(187624);
  }
  
  public void setCacheScale(float paramFloat)
  {
    AppMethodBeat.i(187630);
    this.pagPlayer.setCacheScale(paramFloat);
    AppMethodBeat.o(187630);
  }
  
  public void setComposition(PAGComposition paramPAGComposition)
  {
    AppMethodBeat.i(187611);
    this.filePath = null;
    this.pagFile = null;
    this.pagPlayer.setComposition(paramPAGComposition);
    long l = this.pagPlayer.duration();
    this.animator.setDuration(l / 1000L);
    AppMethodBeat.o(187611);
  }
  
  @Deprecated
  public void setFile(PAGFile paramPAGFile)
  {
    AppMethodBeat.i(187680);
    if (paramPAGFile != null) {}
    for (PAGFile localPAGFile = paramPAGFile.copyOriginal();; localPAGFile = null)
    {
      setComposition(localPAGFile);
      this.pagFile = paramPAGFile;
      if (this.pagFile != null) {
        applyReplacements();
      }
      AppMethodBeat.o(187680);
      return;
    }
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(187648);
    this.pagPlayer.setMatrix(paramMatrix);
    AppMethodBeat.o(187648);
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    AppMethodBeat.i(187636);
    this.pagPlayer.setMaxFrameRate(paramFloat);
    AppMethodBeat.o(187636);
  }
  
  public boolean setPath(String paramString)
  {
    AppMethodBeat.i(187606);
    if ((paramString != null) && (paramString.startsWith("assets://"))) {}
    for (PAGFile localPAGFile = PAGFile.Load(getContext().getAssets(), paramString.substring(9));; localPAGFile = PAGFile.Load(paramString))
    {
      setComposition(localPAGFile);
      this.filePath = paramString;
      if (localPAGFile == null) {
        break;
      }
      AppMethodBeat.o(187606);
      return true;
    }
    AppMethodBeat.o(187606);
    return false;
  }
  
  public void setProgress(double paramDouble)
  {
    AppMethodBeat.i(187659);
    paramDouble = Math.max(0.0D, Math.min(paramDouble, 1.0D));
    this.currentPlayTime = ((this.animator.getDuration() * paramDouble));
    this.animator.setCurrentPlayTime(this.currentPlayTime);
    onAnimationUpdate(paramDouble);
    AppMethodBeat.o(187659);
  }
  
  public void setRepeatCount(int paramInt)
  {
    AppMethodBeat.i(187579);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.animator.setRepeatCount(i - 1);
    AppMethodBeat.o(187579);
  }
  
  public void setScaleMode(int paramInt)
  {
    AppMethodBeat.i(187642);
    this.pagPlayer.setScaleMode(paramInt);
    AppMethodBeat.o(187642);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(187529);
    if (paramSurfaceTextureListener == this)
    {
      super.setSurfaceTextureListener(paramSurfaceTextureListener);
      AppMethodBeat.o(187529);
      return;
    }
    this.mListener = paramSurfaceTextureListener;
    AppMethodBeat.o(187529);
  }
  
  @Deprecated
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    AppMethodBeat.i(187695);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null))
    {
      AppMethodBeat.o(187695);
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceText(paramInt, paramPAGText);
      AppMethodBeat.o(187695);
      return;
    }
    this.textReplacementMap.put(paramInt, paramPAGText);
    AppMethodBeat.o(187695);
  }
  
  public void setVideoEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(187616);
    this.pagPlayer.setVideoEnabled(paramBoolean);
    AppMethodBeat.o(187616);
  }
  
  public void stop()
  {
    AppMethodBeat.i(187574);
    this._isPlaying = false;
    this._isAnimatorPreRunning = null;
    cancelAnimator();
    AppMethodBeat.o(187574);
  }
  
  public boolean videoEnabled()
  {
    AppMethodBeat.i(187614);
    boolean bool = this.pagPlayer.videoEnabled();
    AppMethodBeat.o(187614);
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
      AppMethodBeat.i(187384);
      this.lock = new Object();
      this.needsUpdateViews = new ArrayList();
      AppMethodBeat.o(187384);
    }
    
    public void handleMessage(Message arg1)
    {
      AppMethodBeat.i(187399);
      super.handleMessage(???);
      switch (???.arg1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(187399);
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
          AppMethodBeat.o(187399);
          return;
        }
        ((SurfaceTexture)???.obj).release();
        AppMethodBeat.o(187399);
        return;
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(187354);
            PAGView.access$100();
            AppMethodBeat.o(187354);
          }
        });
      }
    }
    
    void needsUpdateView(PAGView paramPAGView)
    {
      AppMethodBeat.i(187389);
      synchronized (this.lock)
      {
        if (this.needsUpdateViews.isEmpty())
        {
          Message localMessage = obtainMessage();
          localMessage.arg1 = 0;
          sendMessage(localMessage);
        }
        this.needsUpdateViews.add(paramPAGView);
        AppMethodBeat.o(187389);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     org.libpag.PAGView
 * JD-Core Version:    0.7.0.1
 */