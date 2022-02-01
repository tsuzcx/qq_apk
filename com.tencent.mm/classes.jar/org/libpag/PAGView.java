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
  private static final Object g_HandlerLock;
  private static volatile int g_HandlerThreadCount;
  private static PAGRendererHandler g_PAGRendererHandler;
  private static HandlerThread g_PAGRendererThread;
  private boolean _isPlaying;
  private ValueAnimator animator;
  private float animatorProgress;
  private String filePath;
  private SparseArray<PAGImage> imageReplacementMap;
  private boolean isAttachedToWindow;
  private Runnable mAnimatorCancelRunnable;
  private AnimatorListenerAdapter mAnimatorListenerAdapter;
  private Runnable mAnimatorStartRunnable;
  private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
  private TextureView.SurfaceTextureListener mListener;
  private boolean mSaveVisibleState;
  private ArrayList<PAGViewListener> mViewListeners;
  private PAGFile pagFile;
  private PAGPlayer pagPlayer;
  private PAGSurface pagSurface;
  private EGLContext sharedContext;
  private SparseArray<PAGText> textReplacementMap;
  
  static
  {
    AppMethodBeat.i(217040);
    g_HandlerLock = new Object();
    g_PAGRendererHandler = null;
    g_PAGRendererThread = null;
    g_HandlerThreadCount = 0;
    Object localObject = a.gCQ();
    if (((a)localObject).Ota == null)
    {
      ((a)localObject).Ota = new ScreenBroadcastReceiver((ScreenBroadcastReceiver.a)localObject);
      localObject = ((a)localObject).Ota;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      try
      {
        Context localContext = ScreenBroadcastReceiver.getApplicationContext();
        if (localContext != null) {
          localContext.registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
        }
        AppMethodBeat.o(217040);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(217040);
  }
  
  public PAGView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(216982);
    this._isPlaying = false;
    this.filePath = "";
    this.isAttachedToWindow = false;
    this.sharedContext = null;
    this.textReplacementMap = new SparseArray();
    this.imageReplacementMap = new SparseArray();
    this.mViewListeners = new ArrayList();
    this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(216966);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(216966);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(216969);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(216969);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(216968);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(216968);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(216970);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(216970);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(216967);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(216967);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(216971);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(216971);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(216972);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(216972);
      }
    };
    setupSurfaceTexture();
    AppMethodBeat.o(216982);
  }
  
  public PAGView(Context paramContext, EGLContext paramEGLContext)
  {
    super(paramContext);
    AppMethodBeat.i(216983);
    this._isPlaying = false;
    this.filePath = "";
    this.isAttachedToWindow = false;
    this.sharedContext = null;
    this.textReplacementMap = new SparseArray();
    this.imageReplacementMap = new SparseArray();
    this.mViewListeners = new ArrayList();
    this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(216966);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(216966);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(216969);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(216969);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(216968);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(216968);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(216970);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(216970);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(216967);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(216967);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(216971);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(216971);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(216972);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(216972);
      }
    };
    this.sharedContext = paramEGLContext;
    setupSurfaceTexture();
    AppMethodBeat.o(216983);
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216984);
    this._isPlaying = false;
    this.filePath = "";
    this.isAttachedToWindow = false;
    this.sharedContext = null;
    this.textReplacementMap = new SparseArray();
    this.imageReplacementMap = new SparseArray();
    this.mViewListeners = new ArrayList();
    this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(216966);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(216966);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(216969);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(216969);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(216968);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(216968);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(216970);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(216970);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(216967);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(216967);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(216971);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(216971);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(216972);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(216972);
      }
    };
    setupSurfaceTexture();
    AppMethodBeat.o(216984);
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216985);
    this._isPlaying = false;
    this.filePath = "";
    this.isAttachedToWindow = false;
    this.sharedContext = null;
    this.textReplacementMap = new SparseArray();
    this.imageReplacementMap = new SparseArray();
    this.mViewListeners = new ArrayList();
    this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(216966);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(216966);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(216969);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(216969);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(216968);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(216968);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(216970);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(216970);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(216967);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(216967);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(216971);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(216971);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(216972);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(216972);
      }
    };
    setupSurfaceTexture();
    AppMethodBeat.o(216985);
  }
  
  private static void DestroyHandlerThread()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(216978);
        int i = g_HandlerThreadCount - 1;
        g_HandlerThreadCount = i;
        if (i != 0)
        {
          AppMethodBeat.o(216978);
          return;
        }
        if ((g_PAGRendererHandler == null) || (g_PAGRendererThread == null))
        {
          AppMethodBeat.o(216978);
          continue;
        }
        if (g_PAGRendererThread.isAlive()) {
          break label74;
        }
      }
      finally {}
      AppMethodBeat.o(216978);
      continue;
      label74:
      SendMessage(2, null);
      AppMethodBeat.o(216978);
    }
  }
  
  private static void HandlerThreadQuit()
  {
    AppMethodBeat.i(216981);
    if (g_HandlerThreadCount != 0)
    {
      AppMethodBeat.o(216981);
      return;
    }
    if ((g_PAGRendererHandler == null) || (g_PAGRendererThread == null))
    {
      AppMethodBeat.o(216981);
      return;
    }
    if (!g_PAGRendererThread.isAlive())
    {
      AppMethodBeat.o(216981);
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
      AppMethodBeat.o(216981);
      return;
      g_PAGRendererThread.quit();
    }
  }
  
  private static void NeedsUpdateView(PAGView paramPAGView)
  {
    AppMethodBeat.i(216980);
    if (g_PAGRendererHandler == null)
    {
      AppMethodBeat.o(216980);
      return;
    }
    g_PAGRendererHandler.needsUpdateView(paramPAGView);
    AppMethodBeat.o(216980);
  }
  
  private static void SendMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(216979);
    if (g_PAGRendererHandler == null)
    {
      AppMethodBeat.o(216979);
      return;
    }
    Message localMessage = g_PAGRendererHandler.obtainMessage();
    localMessage.arg1 = paramInt;
    if (paramObject != null) {
      localMessage.obj = paramObject;
    }
    g_PAGRendererHandler.sendMessage(localMessage);
    AppMethodBeat.o(216979);
  }
  
  private static void StartHandlerThread()
  {
    try
    {
      AppMethodBeat.i(216977);
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
      AppMethodBeat.o(216977);
      return;
    }
    finally {}
  }
  
  private void applyReplacements()
  {
    int j = 0;
    AppMethodBeat.i(217033);
    PAGFile localPAGFile = (PAGFile)this.pagPlayer.getComposition();
    if (localPAGFile == null)
    {
      AppMethodBeat.o(217033);
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
    AppMethodBeat.o(217033);
  }
  
  private void cancelAnimator()
  {
    AppMethodBeat.i(217001);
    if (isMainThread())
    {
      this.animator.cancel();
      AppMethodBeat.o(217001);
      return;
    }
    removeCallbacks(this.mAnimatorStartRunnable);
    post(this.mAnimatorCancelRunnable);
    AppMethodBeat.o(217001);
  }
  
  private void doPlay()
  {
    AppMethodBeat.i(216997);
    if (!this.isAttachedToWindow)
    {
      AppMethodBeat.o(216997);
      return;
    }
    double d = this.pagPlayer.getProgress();
    this.animator.setCurrentPlayTime((d * this.animator.getDuration()));
    startAnimator();
    AppMethodBeat.o(216997);
  }
  
  private boolean isMainThread()
  {
    AppMethodBeat.i(216999);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(216999);
      return true;
    }
    AppMethodBeat.o(216999);
    return false;
  }
  
  private void setupSurfaceTexture()
  {
    AppMethodBeat.i(216986);
    setOpaque(false);
    this.pagPlayer = new PAGPlayer();
    setSurfaceTextureListener(this);
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.animator.setRepeatCount(0);
    this.animator.setInterpolator(new LinearInterpolator());
    AppMethodBeat.o(216986);
  }
  
  private void startAnimator()
  {
    AppMethodBeat.i(217000);
    if (isMainThread())
    {
      this.animator.start();
      AppMethodBeat.o(217000);
      return;
    }
    removeCallbacks(this.mAnimatorCancelRunnable);
    post(this.mAnimatorStartRunnable);
    AppMethodBeat.o(217000);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(216987);
    if (!this.isAttachedToWindow)
    {
      AppMethodBeat.o(216987);
      return;
    }
    setProgress(this.animatorProgress);
    flush();
    AppMethodBeat.o(216987);
  }
  
  @Deprecated
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(217005);
    this.animator.addListener(paramAnimatorListener);
    AppMethodBeat.o(217005);
  }
  
  public void addListener(PAGViewListener paramPAGViewListener)
  {
    AppMethodBeat.i(217003);
    try
    {
      this.mViewListeners.add(paramPAGViewListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(217003);
    }
  }
  
  public boolean cacheEnabled()
  {
    AppMethodBeat.i(217012);
    boolean bool = this.pagPlayer.cacheEnabled();
    AppMethodBeat.o(217012);
    return bool;
  }
  
  public float cacheScale()
  {
    AppMethodBeat.i(217014);
    float f = this.pagPlayer.cacheScale();
    AppMethodBeat.o(217014);
    return f;
  }
  
  public long duration()
  {
    AppMethodBeat.i(217022);
    long l = this.pagPlayer.duration();
    AppMethodBeat.o(217022);
    return l;
  }
  
  public boolean flush()
  {
    AppMethodBeat.i(217025);
    boolean bool = this.pagPlayer.flush();
    AppMethodBeat.o(217025);
    return bool;
  }
  
  public boolean flush(boolean paramBoolean)
  {
    AppMethodBeat.i(217030);
    paramBoolean = flush();
    AppMethodBeat.o(217030);
    return paramBoolean;
  }
  
  public void freeCache()
  {
    AppMethodBeat.i(217027);
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
    AppMethodBeat.o(217027);
  }
  
  public PAGComposition getComposition()
  {
    AppMethodBeat.i(217008);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    AppMethodBeat.o(217008);
    return localPAGComposition;
  }
  
  public PAGFile getFile()
  {
    return this.pagFile;
  }
  
  public PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(217026);
    PAGLayer[] arrayOfPAGLayer = this.pagPlayer.getLayersUnderPoint(paramFloat1, paramFloat2);
    AppMethodBeat.o(217026);
    return arrayOfPAGLayer;
  }
  
  public String getPath()
  {
    return this.filePath;
  }
  
  public double getProgress()
  {
    AppMethodBeat.i(217023);
    double d = this.pagPlayer.getProgress();
    AppMethodBeat.o(217023);
    return d;
  }
  
  public PAGComposition getRootComposition()
  {
    AppMethodBeat.i(217029);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    AppMethodBeat.o(217029);
    return localPAGComposition;
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(216995);
    if (this.animator != null)
    {
      boolean bool = this.animator.isRunning();
      AppMethodBeat.o(216995);
      return bool;
    }
    AppMethodBeat.o(216995);
    return false;
  }
  
  public Matrix matrix()
  {
    AppMethodBeat.i(217020);
    Matrix localMatrix = this.pagPlayer.matrix();
    AppMethodBeat.o(217020);
    return localMatrix;
  }
  
  public float maxFrameRate()
  {
    AppMethodBeat.i(217016);
    float f = this.pagPlayer.maxFrameRate();
    AppMethodBeat.o(217016);
    return f;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(216992);
    this.isAttachedToWindow = true;
    super.onAttachedToWindow();
    ??? = a.gCQ();
    Object localObject2;
    if (((a)???).Ota != null)
    {
      ((a)???).gCR();
      synchronized (((a)???).OsZ)
      {
        localObject2 = a.ndS.iterator();
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
        AppMethodBeat.o(216992);
        return;
        localObject2 = new WeakReference(this);
        a.ndS.add(localObject2);
      }
      localObject3 = finally;
      AppMethodBeat.o(216992);
      throw localObject3;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(216993);
    this.isAttachedToWindow = false;
    super.onDetachedFromWindow();
    ??? = a.gCQ();
    if (((a)???).Ota != null) {
      ((a)???).gCR();
    }
    label203:
    label210:
    for (;;)
    {
      boolean bool;
      synchronized (((a)???).OsZ)
      {
        Iterator localIterator = a.ndS.iterator();
        ??? = null;
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if (this != localWeakReference.get()) {
            break label210;
          }
          ??? = localWeakReference;
          break label210;
        }
        if (??? != null) {
          a.ndS.remove(???);
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
          if (Build.VERSION.SDK_INT >= 26) {
            break label203;
          }
        }
      }
      synchronized (g_HandlerLock)
      {
        DestroyHandlerThread();
        AppMethodBeat.o(216993);
        return;
        localObject2 = finally;
        AppMethodBeat.o(216993);
        throw localObject2;
        bool = false;
      }
      AppMethodBeat.o(216993);
      return;
    }
  }
  
  public void onScreenOff()
  {
    AppMethodBeat.i(217034);
    if (getVisibility() == 0) {
      this.mSaveVisibleState = true;
    }
    AppMethodBeat.o(217034);
  }
  
  public void onScreenOn()
  {
    AppMethodBeat.i(217035);
    if (this.mSaveVisibleState)
    {
      if (getVisibility() != 0) {
        break label41;
      }
      dispatchVisibilityChanged(this, getVisibility());
    }
    for (;;)
    {
      this.mSaveVisibleState = false;
      AppMethodBeat.o(217035);
      return;
      label41:
      setVisibility(0);
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216989);
    if (this.pagSurface != null)
    {
      this.pagSurface.release();
      this.pagSurface = null;
    }
    this.pagSurface = PAGSurface.FromSurfaceTexture(paramSurfaceTexture, this.sharedContext);
    this.pagPlayer.setSurface(this.pagSurface);
    if (this.pagSurface == null)
    {
      AppMethodBeat.o(216989);
      return;
    }
    this.animator.addUpdateListener(this.mAnimatorUpdateListener);
    this.animator.addListener(this.mAnimatorListenerAdapter);
    this.pagPlayer.flush();
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(216989);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    boolean bool2 = true;
    AppMethodBeat.i(216991);
    this.pagPlayer.setSurface(null);
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureDestroyed(???);
    }
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
    this.animator.removeUpdateListener(this.mAnimatorUpdateListener);
    this.animator.removeListener(this.mAnimatorListenerAdapter);
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
      AppMethodBeat.o(216991);
      return bool1;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216990);
    if (this.pagSurface != null)
    {
      this.pagSurface.updateSize();
      this.pagPlayer.flush();
    }
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(216990);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(216994);
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureUpdated(paramSurfaceTexture);
    }
    AppMethodBeat.o(216994);
  }
  
  public void play()
  {
    AppMethodBeat.i(216996);
    this._isPlaying = true;
    doPlay();
    AppMethodBeat.o(216996);
  }
  
  @Deprecated
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(217006);
    this.animator.removeListener(paramAnimatorListener);
    AppMethodBeat.o(217006);
  }
  
  public void removeListener(PAGViewListener paramPAGViewListener)
  {
    AppMethodBeat.i(217004);
    try
    {
      this.mViewListeners.remove(paramPAGViewListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(217004);
    }
  }
  
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    AppMethodBeat.i(217032);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null))
    {
      AppMethodBeat.o(217032);
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceImage(paramInt, paramPAGImage);
      AppMethodBeat.o(217032);
      return;
    }
    this.imageReplacementMap.put(paramInt, paramPAGImage);
    AppMethodBeat.o(217032);
  }
  
  public int scaleMode()
  {
    AppMethodBeat.i(217018);
    int i = this.pagPlayer.scaleMode();
    AppMethodBeat.o(217018);
    return i;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(217036);
    if ((Build.VERSION.SDK_INT < 24) && (paramDrawable != null)) {
      super.setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(217036);
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217013);
    this.pagPlayer.setCacheEnabled(paramBoolean);
    AppMethodBeat.o(217013);
  }
  
  public void setCacheScale(float paramFloat)
  {
    AppMethodBeat.i(217015);
    this.pagPlayer.setCacheScale(paramFloat);
    AppMethodBeat.o(217015);
  }
  
  public void setComposition(PAGComposition paramPAGComposition)
  {
    AppMethodBeat.i(217009);
    this.filePath = null;
    this.pagFile = null;
    this.pagPlayer.setComposition(paramPAGComposition);
    long l = this.pagPlayer.duration();
    this.animator.setDuration(l / 1000L);
    AppMethodBeat.o(217009);
  }
  
  public void setFile(PAGFile paramPAGFile)
  {
    AppMethodBeat.i(217028);
    if (paramPAGFile != null) {}
    for (PAGFile localPAGFile = paramPAGFile.copyOriginal();; localPAGFile = null)
    {
      setComposition(localPAGFile);
      this.pagFile = paramPAGFile;
      if (this.pagFile != null) {
        applyReplacements();
      }
      AppMethodBeat.o(217028);
      return;
    }
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(217021);
    this.pagPlayer.setMatrix(paramMatrix);
    AppMethodBeat.o(217021);
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    AppMethodBeat.i(217017);
    this.pagPlayer.setMaxFrameRate(paramFloat);
    AppMethodBeat.o(217017);
  }
  
  public boolean setPath(String paramString)
  {
    AppMethodBeat.i(217007);
    if ((paramString != null) && (paramString.startsWith("assets://"))) {}
    for (PAGFile localPAGFile = PAGFile.Load(getContext().getAssets(), paramString.substring(9));; localPAGFile = PAGFile.Load(paramString))
    {
      setComposition(localPAGFile);
      this.filePath = paramString;
      if (localPAGFile == null) {
        break;
      }
      AppMethodBeat.o(217007);
      return true;
    }
    AppMethodBeat.o(217007);
    return false;
  }
  
  public void setProgress(double paramDouble)
  {
    AppMethodBeat.i(217024);
    this.pagPlayer.setProgress(paramDouble);
    AppMethodBeat.o(217024);
  }
  
  public void setRepeatCount(int paramInt)
  {
    AppMethodBeat.i(217002);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.animator.setRepeatCount(i - 1);
    AppMethodBeat.o(217002);
  }
  
  public void setScaleMode(int paramInt)
  {
    AppMethodBeat.i(217019);
    this.pagPlayer.setScaleMode(paramInt);
    AppMethodBeat.o(217019);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(216988);
    if (paramSurfaceTextureListener == this)
    {
      super.setSurfaceTextureListener(paramSurfaceTextureListener);
      AppMethodBeat.o(216988);
      return;
    }
    this.mListener = paramSurfaceTextureListener;
    AppMethodBeat.o(216988);
  }
  
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    AppMethodBeat.i(217031);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null))
    {
      AppMethodBeat.o(217031);
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceText(paramInt, paramPAGText);
      AppMethodBeat.o(217031);
      return;
    }
    this.textReplacementMap.put(paramInt, paramPAGText);
    AppMethodBeat.o(217031);
  }
  
  public void setVideoEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217011);
    this.pagPlayer.setVideoEnabled(paramBoolean);
    AppMethodBeat.o(217011);
  }
  
  public void stop()
  {
    AppMethodBeat.i(216998);
    this._isPlaying = false;
    cancelAnimator();
    AppMethodBeat.o(216998);
  }
  
  public boolean videoEnabled()
  {
    AppMethodBeat.i(217010);
    boolean bool = this.pagPlayer.videoEnabled();
    AppMethodBeat.o(217010);
    return bool;
  }
  
  static class PAGRendererHandler
    extends Handler
  {
    private final Object lock;
    private List<PAGView> needsUpdateViews;
    
    PAGRendererHandler(Looper paramLooper)
    {
      super();
      AppMethodBeat.i(216974);
      this.lock = new Object();
      this.needsUpdateViews = new ArrayList();
      AppMethodBeat.o(216974);
    }
    
    public void handleMessage(Message arg1)
    {
      AppMethodBeat.i(216976);
      super.handleMessage(???);
      switch (???.arg1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(216976);
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
        AppMethodBeat.o(216976);
        return;
        if (!(???.obj instanceof SurfaceTexture))
        {
          AppMethodBeat.o(216976);
          return;
        }
        ((SurfaceTexture)???.obj).release();
        AppMethodBeat.o(216976);
        return;
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(216973);
            PAGView.access$100();
            AppMethodBeat.o(216973);
          }
        });
      }
    }
    
    void needsUpdateView(PAGView paramPAGView)
    {
      AppMethodBeat.i(216975);
      synchronized (this.lock)
      {
        if (this.needsUpdateViews.isEmpty())
        {
          Message localMessage = obtainMessage();
          localMessage.arg1 = 0;
          sendMessage(localMessage);
        }
        this.needsUpdateViews.add(paramPAGView);
        AppMethodBeat.o(216975);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.PAGView
 * JD-Core Version:    0.7.0.1
 */