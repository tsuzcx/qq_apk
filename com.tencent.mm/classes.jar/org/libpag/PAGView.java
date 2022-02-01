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
  private static String TAG;
  private static final Object g_HandlerLock;
  private static volatile int g_HandlerThreadCount;
  private static PAGRendererHandler g_PAGRendererHandler;
  private static HandlerThread g_PAGRendererThread;
  private boolean _isPlaying;
  private ValueAnimator animator;
  private volatile float animatorProgress;
  private String filePath;
  private SparseArray<PAGImage> imageReplacementMap;
  private boolean isAttachedToWindow;
  private Runnable mAnimatorCancelRunnable;
  private AnimatorListenerAdapter mAnimatorListenerAdapter;
  private Runnable mAnimatorStartRunnable;
  private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
  private TextureView.SurfaceTextureListener mListener;
  private ArrayList<PAGFlushListener> mPAGFlushListeners;
  private boolean mSaveVisibleState;
  private ArrayList<PAGViewListener> mViewListeners;
  private PAGFile pagFile;
  private PAGPlayer pagPlayer;
  private PAGSurface pagSurface;
  private EGLContext sharedContext;
  private SparseArray<PAGText> textReplacementMap;
  
  static
  {
    AppMethodBeat.i(237014);
    TAG = "PAGView";
    g_HandlerLock = new Object();
    g_PAGRendererHandler = null;
    g_PAGRendererThread = null;
    g_HandlerThreadCount = 0;
    Object localObject = a.hPU();
    if (((a)localObject).UhY == null)
    {
      ((a)localObject).UhY = new ScreenBroadcastReceiver((ScreenBroadcastReceiver.a)localObject);
      localObject = ((a)localObject).UhY;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      try
      {
        Context localContext = ScreenBroadcastReceiver.getApplicationContext();
        if (localContext != null) {
          localContext.registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
        }
        AppMethodBeat.o(237014);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(237014);
  }
  
  public PAGView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(236954);
    this._isPlaying = false;
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
        AppMethodBeat.i(236937);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(236937);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(236940);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(236940);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(236939);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(236939);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(236941);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(236941);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(236938);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(236938);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(236943);
        if (PAGView.this.isAttachedToWindow)
        {
          PAGView.this.animator.start();
          AppMethodBeat.o(236943);
          return;
        }
        AppMethodBeat.o(236943);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(236944);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(236944);
      }
    };
    setupSurfaceTexture();
    AppMethodBeat.o(236954);
  }
  
  public PAGView(Context paramContext, EGLContext paramEGLContext)
  {
    super(paramContext);
    AppMethodBeat.i(236955);
    this._isPlaying = false;
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
        AppMethodBeat.i(236937);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(236937);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(236940);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(236940);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(236939);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(236939);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(236941);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(236941);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(236938);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(236938);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(236943);
        if (PAGView.this.isAttachedToWindow)
        {
          PAGView.this.animator.start();
          AppMethodBeat.o(236943);
          return;
        }
        AppMethodBeat.o(236943);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(236944);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(236944);
      }
    };
    this.sharedContext = paramEGLContext;
    setupSurfaceTexture();
    AppMethodBeat.o(236955);
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236956);
    this._isPlaying = false;
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
        AppMethodBeat.i(236937);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(236937);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(236940);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(236940);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(236939);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(236939);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(236941);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(236941);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(236938);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(236938);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(236943);
        if (PAGView.this.isAttachedToWindow)
        {
          PAGView.this.animator.start();
          AppMethodBeat.o(236943);
          return;
        }
        AppMethodBeat.o(236943);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(236944);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(236944);
      }
    };
    setupSurfaceTexture();
    AppMethodBeat.o(236956);
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236957);
    this._isPlaying = false;
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
        AppMethodBeat.i(236937);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(236937);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(236940);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(236940);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(236939);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(236939);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(236941);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(236941);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(236938);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(236938);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(236943);
        if (PAGView.this.isAttachedToWindow)
        {
          PAGView.this.animator.start();
          AppMethodBeat.o(236943);
          return;
        }
        AppMethodBeat.o(236943);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(236944);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(236944);
      }
    };
    setupSurfaceTexture();
    AppMethodBeat.o(236957);
  }
  
  private static void DestroyHandlerThread()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(236950);
        int i = g_HandlerThreadCount - 1;
        g_HandlerThreadCount = i;
        if (i != 0)
        {
          AppMethodBeat.o(236950);
          return;
        }
        if ((g_PAGRendererHandler == null) || (g_PAGRendererThread == null))
        {
          AppMethodBeat.o(236950);
          continue;
        }
        if (g_PAGRendererThread.isAlive()) {
          break label74;
        }
      }
      finally {}
      AppMethodBeat.o(236950);
      continue;
      label74:
      SendMessage(2, null);
      AppMethodBeat.o(236950);
    }
  }
  
  private static void HandlerThreadQuit()
  {
    AppMethodBeat.i(236953);
    if (g_HandlerThreadCount != 0)
    {
      AppMethodBeat.o(236953);
      return;
    }
    if ((g_PAGRendererHandler == null) || (g_PAGRendererThread == null))
    {
      AppMethodBeat.o(236953);
      return;
    }
    if (!g_PAGRendererThread.isAlive())
    {
      AppMethodBeat.o(236953);
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
      AppMethodBeat.o(236953);
      return;
      g_PAGRendererThread.quit();
    }
  }
  
  private static void NeedsUpdateView(PAGView paramPAGView)
  {
    AppMethodBeat.i(236952);
    if (g_PAGRendererHandler == null)
    {
      AppMethodBeat.o(236952);
      return;
    }
    g_PAGRendererHandler.needsUpdateView(paramPAGView);
    AppMethodBeat.o(236952);
  }
  
  private static void SendMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(236951);
    if (g_PAGRendererHandler == null)
    {
      AppMethodBeat.o(236951);
      return;
    }
    Message localMessage = g_PAGRendererHandler.obtainMessage();
    localMessage.arg1 = paramInt;
    if (paramObject != null) {
      localMessage.obj = paramObject;
    }
    g_PAGRendererHandler.sendMessage(localMessage);
    AppMethodBeat.o(236951);
  }
  
  private static void StartHandlerThread()
  {
    try
    {
      AppMethodBeat.i(236949);
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
      AppMethodBeat.o(236949);
      return;
    }
    finally {}
  }
  
  private void applyReplacements()
  {
    int j = 0;
    AppMethodBeat.i(237007);
    PAGFile localPAGFile = (PAGFile)this.pagPlayer.getComposition();
    if (localPAGFile == null)
    {
      AppMethodBeat.o(237007);
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
    AppMethodBeat.o(237007);
  }
  
  private void cancelAnimator()
  {
    AppMethodBeat.i(236973);
    if (isMainThread())
    {
      this.animator.cancel();
      AppMethodBeat.o(236973);
      return;
    }
    removeCallbacks(this.mAnimatorStartRunnable);
    post(this.mAnimatorCancelRunnable);
    AppMethodBeat.o(236973);
  }
  
  private void doPlay()
  {
    AppMethodBeat.i(236969);
    if (!this.isAttachedToWindow)
    {
      AppMethodBeat.o(236969);
      return;
    }
    double d = this.pagPlayer.getProgress();
    this.animator.setCurrentPlayTime((d * this.animator.getDuration()));
    startAnimator();
    AppMethodBeat.o(236969);
  }
  
  private boolean isMainThread()
  {
    AppMethodBeat.i(236971);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(236971);
      return true;
    }
    AppMethodBeat.o(236971);
    return false;
  }
  
  private void setupSurfaceTexture()
  {
    AppMethodBeat.i(236958);
    setOpaque(false);
    this.pagPlayer = new PAGPlayer();
    setSurfaceTextureListener(this);
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.animator.setRepeatCount(0);
    this.animator.setInterpolator(new LinearInterpolator());
    AppMethodBeat.o(236958);
  }
  
  private void startAnimator()
  {
    AppMethodBeat.i(236972);
    if (isMainThread())
    {
      this.animator.start();
      AppMethodBeat.o(236972);
      return;
    }
    removeCallbacks(this.mAnimatorCancelRunnable);
    post(this.mAnimatorStartRunnable);
    AppMethodBeat.o(236972);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(236959);
    if (!this.isAttachedToWindow)
    {
      AppMethodBeat.o(236959);
      return;
    }
    setProgress(this.animatorProgress);
    flush();
    if (!this.mPAGFlushListeners.isEmpty()) {
      post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(236942);
          Iterator localIterator = PAGView.this.mPAGFlushListeners.iterator();
          while (localIterator.hasNext()) {
            ((PAGView.PAGFlushListener)localIterator.next()).onFlush();
          }
          AppMethodBeat.o(236942);
        }
      });
    }
    AppMethodBeat.o(236959);
  }
  
  @Deprecated
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(236979);
    this.animator.addListener(paramAnimatorListener);
    AppMethodBeat.o(236979);
  }
  
  public void addListener(PAGViewListener paramPAGViewListener)
  {
    AppMethodBeat.i(236975);
    try
    {
      this.mViewListeners.add(paramPAGViewListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(236975);
    }
  }
  
  public void addPAGFlushListener(PAGFlushListener paramPAGFlushListener)
  {
    AppMethodBeat.i(236977);
    try
    {
      this.mPAGFlushListeners.add(paramPAGFlushListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(236977);
    }
  }
  
  public boolean cacheEnabled()
  {
    AppMethodBeat.i(236986);
    boolean bool = this.pagPlayer.cacheEnabled();
    AppMethodBeat.o(236986);
    return bool;
  }
  
  public float cacheScale()
  {
    AppMethodBeat.i(236988);
    float f = this.pagPlayer.cacheScale();
    AppMethodBeat.o(236988);
    return f;
  }
  
  public long duration()
  {
    AppMethodBeat.i(236996);
    long l = this.pagPlayer.duration();
    AppMethodBeat.o(236996);
    return l;
  }
  
  public boolean flush()
  {
    AppMethodBeat.i(236999);
    boolean bool = this.pagPlayer.flush();
    AppMethodBeat.o(236999);
    return bool;
  }
  
  @Deprecated
  public boolean flush(boolean paramBoolean)
  {
    AppMethodBeat.i(237004);
    paramBoolean = flush();
    AppMethodBeat.o(237004);
    return paramBoolean;
  }
  
  public void freeCache()
  {
    AppMethodBeat.i(237001);
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
    AppMethodBeat.o(237001);
  }
  
  public PAGComposition getComposition()
  {
    AppMethodBeat.i(236982);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    AppMethodBeat.o(236982);
    return localPAGComposition;
  }
  
  @Deprecated
  public PAGFile getFile()
  {
    return this.pagFile;
  }
  
  public PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237000);
    PAGLayer[] arrayOfPAGLayer = this.pagPlayer.getLayersUnderPoint(paramFloat1, paramFloat2);
    AppMethodBeat.o(237000);
    return arrayOfPAGLayer;
  }
  
  public String getPath()
  {
    return this.filePath;
  }
  
  public double getProgress()
  {
    AppMethodBeat.i(236997);
    double d = this.pagPlayer.getProgress();
    AppMethodBeat.o(236997);
    return d;
  }
  
  @Deprecated
  public PAGComposition getRootComposition()
  {
    AppMethodBeat.i(237003);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    AppMethodBeat.o(237003);
    return localPAGComposition;
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(236967);
    if (this.animator != null)
    {
      boolean bool = this.animator.isRunning();
      AppMethodBeat.o(236967);
      return bool;
    }
    AppMethodBeat.o(236967);
    return false;
  }
  
  public Matrix matrix()
  {
    AppMethodBeat.i(236994);
    Matrix localMatrix = this.pagPlayer.matrix();
    AppMethodBeat.o(236994);
    return localMatrix;
  }
  
  public float maxFrameRate()
  {
    AppMethodBeat.i(236990);
    float f = this.pagPlayer.maxFrameRate();
    AppMethodBeat.o(236990);
    return f;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(236964);
    this.isAttachedToWindow = true;
    super.onAttachedToWindow();
    this.animator.addListener(this.mAnimatorListenerAdapter);
    ??? = a.hPU();
    Object localObject2;
    if (((a)???).UhY != null)
    {
      ((a)???).hPV();
      synchronized (((a)???).UhX)
      {
        localObject2 = a.opg.iterator();
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
        if (this._isPlaying) {
          doPlay();
        }
        AppMethodBeat.o(236964);
        return;
        localObject2 = new WeakReference(this);
        a.opg.add(localObject2);
      }
      localObject3 = finally;
      AppMethodBeat.o(236964);
      throw localObject3;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(236965);
    this.isAttachedToWindow = false;
    super.onDetachedFromWindow();
    ??? = a.hPU();
    if (((a)???).UhY != null) {
      ((a)???).hPV();
    }
    label214:
    for (;;)
    {
      boolean bool;
      synchronized (((a)???).UhX)
      {
        Iterator localIterator = a.opg.iterator();
        ??? = null;
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if (this != localWeakReference.get()) {
            break label214;
          }
          ??? = localWeakReference;
          break label214;
        }
        if (??? != null) {
          a.opg.remove(???);
        }
        if (this.pagSurface != null)
        {
          this.pagSurface.release();
          this.pagSurface = null;
        }
        if ((this._isPlaying) && (this.animator.isRunning()))
        {
          bool = true;
          this._isPlaying = bool;
          cancelAnimator();
          if (Build.VERSION.SDK_INT >= 26) {}
        }
      }
      synchronized (g_HandlerLock)
      {
        DestroyHandlerThread();
        this.animator.removeListener(this.mAnimatorListenerAdapter);
        AppMethodBeat.o(236965);
        return;
        localObject2 = finally;
        AppMethodBeat.o(236965);
        throw localObject2;
        bool = false;
      }
    }
  }
  
  public void onScreenOff()
  {
    AppMethodBeat.i(237008);
    if (getVisibility() == 0)
    {
      this.mSaveVisibleState = true;
      setVisibility(4);
    }
    AppMethodBeat.o(237008);
  }
  
  public void onScreenOn()
  {
    AppMethodBeat.i(237009);
    if (this.mSaveVisibleState) {
      setVisibility(0);
    }
    this.mSaveVisibleState = false;
    AppMethodBeat.o(237009);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236961);
    if (this.pagSurface != null)
    {
      this.pagSurface.release();
      this.pagSurface = null;
    }
    this.pagSurface = PAGSurface.FromSurfaceTexture(paramSurfaceTexture, this.sharedContext);
    this.pagPlayer.setSurface(this.pagSurface);
    if (this.pagSurface == null)
    {
      AppMethodBeat.o(236961);
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
      AppMethodBeat.o(236961);
      return;
      flush();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    boolean bool2 = true;
    AppMethodBeat.i(236963);
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
      AppMethodBeat.o(236963);
      return bool1;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236962);
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
      AppMethodBeat.o(236962);
      return;
      label68:
      flush();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(236966);
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureUpdated(paramSurfaceTexture);
    }
    AppMethodBeat.o(236966);
  }
  
  public void play()
  {
    AppMethodBeat.i(236968);
    this._isPlaying = true;
    doPlay();
    AppMethodBeat.o(236968);
  }
  
  @Deprecated
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(236980);
    this.animator.removeListener(paramAnimatorListener);
    AppMethodBeat.o(236980);
  }
  
  public void removeListener(PAGViewListener paramPAGViewListener)
  {
    AppMethodBeat.i(236976);
    try
    {
      this.mViewListeners.remove(paramPAGViewListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(236976);
    }
  }
  
  public void removePAGFlushListener(PAGFlushListener paramPAGFlushListener)
  {
    AppMethodBeat.i(236978);
    try
    {
      this.mPAGFlushListeners.remove(paramPAGFlushListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(236978);
    }
  }
  
  @Deprecated
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    AppMethodBeat.i(237006);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null))
    {
      AppMethodBeat.o(237006);
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceImage(paramInt, paramPAGImage);
      AppMethodBeat.o(237006);
      return;
    }
    this.imageReplacementMap.put(paramInt, paramPAGImage);
    AppMethodBeat.o(237006);
  }
  
  public int scaleMode()
  {
    AppMethodBeat.i(236992);
    int i = this.pagPlayer.scaleMode();
    AppMethodBeat.o(236992);
    return i;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(237010);
    if ((Build.VERSION.SDK_INT < 24) && (paramDrawable != null)) {
      super.setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(237010);
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(236987);
    this.pagPlayer.setCacheEnabled(paramBoolean);
    AppMethodBeat.o(236987);
  }
  
  public void setCacheScale(float paramFloat)
  {
    AppMethodBeat.i(236989);
    this.pagPlayer.setCacheScale(paramFloat);
    AppMethodBeat.o(236989);
  }
  
  public void setComposition(PAGComposition paramPAGComposition)
  {
    AppMethodBeat.i(236983);
    this.filePath = null;
    this.pagFile = null;
    this.pagPlayer.setComposition(paramPAGComposition);
    long l = this.pagPlayer.duration();
    this.animator.setDuration(l / 1000L);
    AppMethodBeat.o(236983);
  }
  
  @Deprecated
  public void setFile(PAGFile paramPAGFile)
  {
    AppMethodBeat.i(237002);
    if (paramPAGFile != null) {}
    for (PAGFile localPAGFile = paramPAGFile.copyOriginal();; localPAGFile = null)
    {
      setComposition(localPAGFile);
      this.pagFile = paramPAGFile;
      if (this.pagFile != null) {
        applyReplacements();
      }
      AppMethodBeat.o(237002);
      return;
    }
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(236995);
    this.pagPlayer.setMatrix(paramMatrix);
    AppMethodBeat.o(236995);
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    AppMethodBeat.i(236991);
    this.pagPlayer.setMaxFrameRate(paramFloat);
    AppMethodBeat.o(236991);
  }
  
  public boolean setPath(String paramString)
  {
    AppMethodBeat.i(236981);
    if ((paramString != null) && (paramString.startsWith("assets://"))) {}
    for (PAGFile localPAGFile = PAGFile.Load(getContext().getAssets(), paramString.substring(9));; localPAGFile = PAGFile.Load(paramString))
    {
      setComposition(localPAGFile);
      this.filePath = paramString;
      if (localPAGFile == null) {
        break;
      }
      AppMethodBeat.o(236981);
      return true;
    }
    AppMethodBeat.o(236981);
    return false;
  }
  
  public void setProgress(double paramDouble)
  {
    AppMethodBeat.i(236998);
    if (this.animatorProgress != (float)paramDouble)
    {
      this.animatorProgress = ((float)paramDouble);
      if (Build.VERSION.SDK_INT >= 22) {
        this.animator.setCurrentFraction(this.animatorProgress);
      }
    }
    this.pagPlayer.setProgress(paramDouble);
    AppMethodBeat.o(236998);
  }
  
  public void setRepeatCount(int paramInt)
  {
    AppMethodBeat.i(236974);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.animator.setRepeatCount(i - 1);
    AppMethodBeat.o(236974);
  }
  
  public void setScaleMode(int paramInt)
  {
    AppMethodBeat.i(236993);
    this.pagPlayer.setScaleMode(paramInt);
    AppMethodBeat.o(236993);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(236960);
    if (paramSurfaceTextureListener == this)
    {
      super.setSurfaceTextureListener(paramSurfaceTextureListener);
      AppMethodBeat.o(236960);
      return;
    }
    this.mListener = paramSurfaceTextureListener;
    AppMethodBeat.o(236960);
  }
  
  @Deprecated
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    AppMethodBeat.i(237005);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null))
    {
      AppMethodBeat.o(237005);
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceText(paramInt, paramPAGText);
      AppMethodBeat.o(237005);
      return;
    }
    this.textReplacementMap.put(paramInt, paramPAGText);
    AppMethodBeat.o(237005);
  }
  
  public void setVideoEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(236985);
    this.pagPlayer.setVideoEnabled(paramBoolean);
    AppMethodBeat.o(236985);
  }
  
  public void stop()
  {
    AppMethodBeat.i(236970);
    this._isPlaying = false;
    cancelAnimator();
    AppMethodBeat.o(236970);
  }
  
  public boolean videoEnabled()
  {
    AppMethodBeat.i(236984);
    boolean bool = this.pagPlayer.videoEnabled();
    AppMethodBeat.o(236984);
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
      AppMethodBeat.i(236946);
      this.lock = new Object();
      this.needsUpdateViews = new ArrayList();
      AppMethodBeat.o(236946);
    }
    
    public void handleMessage(Message arg1)
    {
      AppMethodBeat.i(236948);
      super.handleMessage(???);
      switch (???.arg1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(236948);
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
        AppMethodBeat.o(236948);
        return;
        if (!(???.obj instanceof SurfaceTexture))
        {
          AppMethodBeat.o(236948);
          return;
        }
        ((SurfaceTexture)???.obj).release();
        AppMethodBeat.o(236948);
        return;
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(236945);
            PAGView.access$100();
            AppMethodBeat.o(236945);
          }
        });
      }
    }
    
    void needsUpdateView(PAGView paramPAGView)
    {
      AppMethodBeat.i(236947);
      synchronized (this.lock)
      {
        if (this.needsUpdateViews.isEmpty())
        {
          Message localMessage = obtainMessage();
          localMessage.arg1 = 0;
          sendMessage(localMessage);
        }
        this.needsUpdateViews.add(paramPAGView);
        AppMethodBeat.o(236947);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.libpag.PAGView
 * JD-Core Version:    0.7.0.1
 */