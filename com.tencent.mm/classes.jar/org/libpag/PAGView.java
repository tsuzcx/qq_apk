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
    AppMethodBeat.i(220286);
    g_HandlerLock = new Object();
    g_PAGRendererHandler = null;
    g_PAGRendererThread = null;
    g_HandlerThreadCount = 0;
    Object localObject = a.gyo();
    if (((a)localObject).NVV == null)
    {
      ((a)localObject).NVV = new ScreenBroadcastReceiver((ScreenBroadcastReceiver.a)localObject);
      localObject = ((a)localObject).NVV;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      try
      {
        Context localContext = ScreenBroadcastReceiver.getApplicationContext();
        if (localContext != null) {
          localContext.registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
        }
        AppMethodBeat.o(220286);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(220286);
  }
  
  public PAGView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(220228);
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
        AppMethodBeat.i(220212);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(220212);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(220215);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(220215);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(220214);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(220214);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(220216);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(220216);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(220213);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(220213);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(220217);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(220217);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(220218);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(220218);
      }
    };
    setupSurfaceTexture();
    AppMethodBeat.o(220228);
  }
  
  public PAGView(Context paramContext, EGLContext paramEGLContext)
  {
    super(paramContext);
    AppMethodBeat.i(220229);
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
        AppMethodBeat.i(220212);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(220212);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(220215);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(220215);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(220214);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(220214);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(220216);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(220216);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(220213);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(220213);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(220217);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(220217);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(220218);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(220218);
      }
    };
    this.sharedContext = paramEGLContext;
    setupSurfaceTexture();
    AppMethodBeat.o(220229);
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220230);
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
        AppMethodBeat.i(220212);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(220212);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(220215);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(220215);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(220214);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(220214);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(220216);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(220216);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(220213);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(220213);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(220217);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(220217);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(220218);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(220218);
      }
    };
    setupSurfaceTexture();
    AppMethodBeat.o(220230);
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220231);
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
        AppMethodBeat.i(220212);
        PAGView.access$202(PAGView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        PAGView.access$300(PAGView.this);
        AppMethodBeat.o(220212);
      }
    };
    this.mAnimatorListenerAdapter = new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator arg1)
      {
        AppMethodBeat.i(220215);
        super.onAnimationCancel(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(PAGView.this);
          }
        }
        AppMethodBeat.o(220215);
      }
      
      public void onAnimationEnd(Animator arg1)
      {
        AppMethodBeat.i(220214);
        super.onAnimationEnd(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(PAGView.this);
          }
        }
        AppMethodBeat.o(220214);
      }
      
      public void onAnimationRepeat(Animator arg1)
      {
        AppMethodBeat.i(220216);
        super.onAnimationRepeat(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(PAGView.this);
          }
        }
        AppMethodBeat.o(220216);
      }
      
      public void onAnimationStart(Animator arg1)
      {
        AppMethodBeat.i(220213);
        super.onAnimationStart(???);
        synchronized (PAGView.this)
        {
          Iterator localIterator = PAGView.this.mViewListeners.iterator();
          if (localIterator.hasNext()) {
            ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(PAGView.this);
          }
        }
        AppMethodBeat.o(220213);
      }
    };
    this.mAnimatorStartRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(220217);
        if (PAGView.this.isAttachedToWindow) {
          PAGView.this.animator.start();
        }
        AppMethodBeat.o(220217);
      }
    };
    this.mAnimatorCancelRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(220218);
        PAGView.this.animator.cancel();
        AppMethodBeat.o(220218);
      }
    };
    setupSurfaceTexture();
    AppMethodBeat.o(220231);
  }
  
  private static void DestroyHandlerThread()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(220224);
        int i = g_HandlerThreadCount - 1;
        g_HandlerThreadCount = i;
        if (i != 0)
        {
          AppMethodBeat.o(220224);
          return;
        }
        if ((g_PAGRendererHandler == null) || (g_PAGRendererThread == null))
        {
          AppMethodBeat.o(220224);
          continue;
        }
        if (g_PAGRendererThread.isAlive()) {
          break label74;
        }
      }
      finally {}
      AppMethodBeat.o(220224);
      continue;
      label74:
      SendMessage(2, null);
      AppMethodBeat.o(220224);
    }
  }
  
  private static void HandlerThreadQuit()
  {
    AppMethodBeat.i(220227);
    if (g_HandlerThreadCount != 0)
    {
      AppMethodBeat.o(220227);
      return;
    }
    if ((g_PAGRendererHandler == null) || (g_PAGRendererThread == null))
    {
      AppMethodBeat.o(220227);
      return;
    }
    if (!g_PAGRendererThread.isAlive())
    {
      AppMethodBeat.o(220227);
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
      AppMethodBeat.o(220227);
      return;
      g_PAGRendererThread.quit();
    }
  }
  
  private static void NeedsUpdateView(PAGView paramPAGView)
  {
    AppMethodBeat.i(220226);
    if (g_PAGRendererHandler == null)
    {
      AppMethodBeat.o(220226);
      return;
    }
    g_PAGRendererHandler.needsUpdateView(paramPAGView);
    AppMethodBeat.o(220226);
  }
  
  private static void SendMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(220225);
    if (g_PAGRendererHandler == null)
    {
      AppMethodBeat.o(220225);
      return;
    }
    Message localMessage = g_PAGRendererHandler.obtainMessage();
    localMessage.arg1 = paramInt;
    if (paramObject != null) {
      localMessage.obj = paramObject;
    }
    g_PAGRendererHandler.sendMessage(localMessage);
    AppMethodBeat.o(220225);
  }
  
  private static void StartHandlerThread()
  {
    try
    {
      AppMethodBeat.i(220223);
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
      AppMethodBeat.o(220223);
      return;
    }
    finally {}
  }
  
  private void applyReplacements()
  {
    int j = 0;
    AppMethodBeat.i(220279);
    PAGFile localPAGFile = (PAGFile)this.pagPlayer.getComposition();
    if (localPAGFile == null)
    {
      AppMethodBeat.o(220279);
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
    AppMethodBeat.o(220279);
  }
  
  private void cancelAnimator()
  {
    AppMethodBeat.i(220247);
    if (isMainThread())
    {
      this.animator.cancel();
      AppMethodBeat.o(220247);
      return;
    }
    removeCallbacks(this.mAnimatorStartRunnable);
    post(this.mAnimatorCancelRunnable);
    AppMethodBeat.o(220247);
  }
  
  private void doPlay()
  {
    AppMethodBeat.i(220243);
    if (!this.isAttachedToWindow)
    {
      AppMethodBeat.o(220243);
      return;
    }
    double d = this.pagPlayer.getProgress();
    this.animator.setCurrentPlayTime((d * this.animator.getDuration()));
    startAnimator();
    AppMethodBeat.o(220243);
  }
  
  private boolean isMainThread()
  {
    AppMethodBeat.i(220245);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(220245);
      return true;
    }
    AppMethodBeat.o(220245);
    return false;
  }
  
  private void setupSurfaceTexture()
  {
    AppMethodBeat.i(220232);
    setOpaque(false);
    this.pagPlayer = new PAGPlayer();
    setSurfaceTextureListener(this);
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.animator.setRepeatCount(0);
    this.animator.setInterpolator(new LinearInterpolator());
    AppMethodBeat.o(220232);
  }
  
  private void startAnimator()
  {
    AppMethodBeat.i(220246);
    if (isMainThread())
    {
      this.animator.start();
      AppMethodBeat.o(220246);
      return;
    }
    removeCallbacks(this.mAnimatorCancelRunnable);
    post(this.mAnimatorStartRunnable);
    AppMethodBeat.o(220246);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(220233);
    if (!this.isAttachedToWindow)
    {
      AppMethodBeat.o(220233);
      return;
    }
    setProgress(this.animatorProgress);
    flush();
    AppMethodBeat.o(220233);
  }
  
  @Deprecated
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(220251);
    this.animator.addListener(paramAnimatorListener);
    AppMethodBeat.o(220251);
  }
  
  public void addListener(PAGViewListener paramPAGViewListener)
  {
    AppMethodBeat.i(220249);
    try
    {
      this.mViewListeners.add(paramPAGViewListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(220249);
    }
  }
  
  public boolean cacheEnabled()
  {
    AppMethodBeat.i(220258);
    boolean bool = this.pagPlayer.cacheEnabled();
    AppMethodBeat.o(220258);
    return bool;
  }
  
  public float cacheScale()
  {
    AppMethodBeat.i(220260);
    float f = this.pagPlayer.cacheScale();
    AppMethodBeat.o(220260);
    return f;
  }
  
  public long duration()
  {
    AppMethodBeat.i(220268);
    long l = this.pagPlayer.duration();
    AppMethodBeat.o(220268);
    return l;
  }
  
  public boolean flush()
  {
    AppMethodBeat.i(220271);
    boolean bool = this.pagPlayer.flush();
    AppMethodBeat.o(220271);
    return bool;
  }
  
  public boolean flush(boolean paramBoolean)
  {
    AppMethodBeat.i(220276);
    paramBoolean = flush();
    AppMethodBeat.o(220276);
    return paramBoolean;
  }
  
  public void freeCache()
  {
    AppMethodBeat.i(220273);
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
    AppMethodBeat.o(220273);
  }
  
  public PAGComposition getComposition()
  {
    AppMethodBeat.i(220254);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    AppMethodBeat.o(220254);
    return localPAGComposition;
  }
  
  public PAGFile getFile()
  {
    return this.pagFile;
  }
  
  public PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(220272);
    PAGLayer[] arrayOfPAGLayer = this.pagPlayer.getLayersUnderPoint(paramFloat1, paramFloat2);
    AppMethodBeat.o(220272);
    return arrayOfPAGLayer;
  }
  
  public String getPath()
  {
    return this.filePath;
  }
  
  public double getProgress()
  {
    AppMethodBeat.i(220269);
    double d = this.pagPlayer.getProgress();
    AppMethodBeat.o(220269);
    return d;
  }
  
  public PAGComposition getRootComposition()
  {
    AppMethodBeat.i(220275);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    AppMethodBeat.o(220275);
    return localPAGComposition;
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(220241);
    if (this.animator != null)
    {
      boolean bool = this.animator.isRunning();
      AppMethodBeat.o(220241);
      return bool;
    }
    AppMethodBeat.o(220241);
    return false;
  }
  
  public Matrix matrix()
  {
    AppMethodBeat.i(220266);
    Matrix localMatrix = this.pagPlayer.matrix();
    AppMethodBeat.o(220266);
    return localMatrix;
  }
  
  public float maxFrameRate()
  {
    AppMethodBeat.i(220262);
    float f = this.pagPlayer.maxFrameRate();
    AppMethodBeat.o(220262);
    return f;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(220238);
    this.isAttachedToWindow = true;
    super.onAttachedToWindow();
    ??? = a.gyo();
    Object localObject2;
    if (((a)???).NVV != null)
    {
      ((a)???).gyp();
      synchronized (((a)???).NVU)
      {
        localObject2 = a.mYL.iterator();
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
        AppMethodBeat.o(220238);
        return;
        localObject2 = new WeakReference(this);
        a.mYL.add(localObject2);
      }
      localObject3 = finally;
      AppMethodBeat.o(220238);
      throw localObject3;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(220239);
    this.isAttachedToWindow = false;
    super.onDetachedFromWindow();
    ??? = a.gyo();
    if (((a)???).NVV != null) {
      ((a)???).gyp();
    }
    label203:
    label210:
    for (;;)
    {
      boolean bool;
      synchronized (((a)???).NVU)
      {
        Iterator localIterator = a.mYL.iterator();
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
          a.mYL.remove(???);
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
        AppMethodBeat.o(220239);
        return;
        localObject2 = finally;
        AppMethodBeat.o(220239);
        throw localObject2;
        bool = false;
      }
      AppMethodBeat.o(220239);
      return;
    }
  }
  
  public void onScreenOff()
  {
    AppMethodBeat.i(220280);
    if (getVisibility() == 0) {
      this.mSaveVisibleState = true;
    }
    AppMethodBeat.o(220280);
  }
  
  public void onScreenOn()
  {
    AppMethodBeat.i(220281);
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
      AppMethodBeat.o(220281);
      return;
      label41:
      setVisibility(0);
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220235);
    if (this.pagSurface != null)
    {
      this.pagSurface.release();
      this.pagSurface = null;
    }
    this.pagSurface = PAGSurface.FromSurfaceTexture(paramSurfaceTexture, this.sharedContext);
    this.pagPlayer.setSurface(this.pagSurface);
    if (this.pagSurface == null)
    {
      AppMethodBeat.o(220235);
      return;
    }
    this.animator.addUpdateListener(this.mAnimatorUpdateListener);
    this.animator.addListener(this.mAnimatorListenerAdapter);
    this.pagPlayer.flush();
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(220235);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    boolean bool2 = true;
    AppMethodBeat.i(220237);
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
      AppMethodBeat.o(220237);
      return bool1;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220236);
    if (this.pagSurface != null)
    {
      this.pagSurface.updateSize();
      this.pagPlayer.flush();
    }
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(220236);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(220240);
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureUpdated(paramSurfaceTexture);
    }
    AppMethodBeat.o(220240);
  }
  
  public void play()
  {
    AppMethodBeat.i(220242);
    this._isPlaying = true;
    doPlay();
    AppMethodBeat.o(220242);
  }
  
  @Deprecated
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(220252);
    this.animator.removeListener(paramAnimatorListener);
    AppMethodBeat.o(220252);
  }
  
  public void removeListener(PAGViewListener paramPAGViewListener)
  {
    AppMethodBeat.i(220250);
    try
    {
      this.mViewListeners.remove(paramPAGViewListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(220250);
    }
  }
  
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    AppMethodBeat.i(220278);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null))
    {
      AppMethodBeat.o(220278);
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceImage(paramInt, paramPAGImage);
      AppMethodBeat.o(220278);
      return;
    }
    this.imageReplacementMap.put(paramInt, paramPAGImage);
    AppMethodBeat.o(220278);
  }
  
  public int scaleMode()
  {
    AppMethodBeat.i(220264);
    int i = this.pagPlayer.scaleMode();
    AppMethodBeat.o(220264);
    return i;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(220282);
    if ((Build.VERSION.SDK_INT < 24) && (paramDrawable != null)) {
      super.setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(220282);
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(220259);
    this.pagPlayer.setCacheEnabled(paramBoolean);
    AppMethodBeat.o(220259);
  }
  
  public void setCacheScale(float paramFloat)
  {
    AppMethodBeat.i(220261);
    this.pagPlayer.setCacheScale(paramFloat);
    AppMethodBeat.o(220261);
  }
  
  public void setComposition(PAGComposition paramPAGComposition)
  {
    AppMethodBeat.i(220255);
    this.filePath = null;
    this.pagFile = null;
    this.pagPlayer.setComposition(paramPAGComposition);
    long l = this.pagPlayer.duration();
    this.animator.setDuration(l / 1000L);
    AppMethodBeat.o(220255);
  }
  
  public void setFile(PAGFile paramPAGFile)
  {
    AppMethodBeat.i(220274);
    if (paramPAGFile != null) {}
    for (PAGFile localPAGFile = paramPAGFile.copyOriginal();; localPAGFile = null)
    {
      setComposition(localPAGFile);
      this.pagFile = paramPAGFile;
      if (this.pagFile != null) {
        applyReplacements();
      }
      AppMethodBeat.o(220274);
      return;
    }
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(220267);
    this.pagPlayer.setMatrix(paramMatrix);
    AppMethodBeat.o(220267);
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    AppMethodBeat.i(220263);
    this.pagPlayer.setMaxFrameRate(paramFloat);
    AppMethodBeat.o(220263);
  }
  
  public boolean setPath(String paramString)
  {
    AppMethodBeat.i(220253);
    if ((paramString != null) && (paramString.startsWith("assets://"))) {}
    for (PAGFile localPAGFile = PAGFile.Load(getContext().getAssets(), paramString.substring(9));; localPAGFile = PAGFile.Load(paramString))
    {
      setComposition(localPAGFile);
      this.filePath = paramString;
      if (localPAGFile == null) {
        break;
      }
      AppMethodBeat.o(220253);
      return true;
    }
    AppMethodBeat.o(220253);
    return false;
  }
  
  public void setProgress(double paramDouble)
  {
    AppMethodBeat.i(220270);
    this.pagPlayer.setProgress(paramDouble);
    AppMethodBeat.o(220270);
  }
  
  public void setRepeatCount(int paramInt)
  {
    AppMethodBeat.i(220248);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.animator.setRepeatCount(i - 1);
    AppMethodBeat.o(220248);
  }
  
  public void setScaleMode(int paramInt)
  {
    AppMethodBeat.i(220265);
    this.pagPlayer.setScaleMode(paramInt);
    AppMethodBeat.o(220265);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(220234);
    if (paramSurfaceTextureListener == this)
    {
      super.setSurfaceTextureListener(paramSurfaceTextureListener);
      AppMethodBeat.o(220234);
      return;
    }
    this.mListener = paramSurfaceTextureListener;
    AppMethodBeat.o(220234);
  }
  
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    AppMethodBeat.i(220277);
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null))
    {
      AppMethodBeat.o(220277);
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceText(paramInt, paramPAGText);
      AppMethodBeat.o(220277);
      return;
    }
    this.textReplacementMap.put(paramInt, paramPAGText);
    AppMethodBeat.o(220277);
  }
  
  public void setVideoEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(220257);
    this.pagPlayer.setVideoEnabled(paramBoolean);
    AppMethodBeat.o(220257);
  }
  
  public void stop()
  {
    AppMethodBeat.i(220244);
    this._isPlaying = false;
    cancelAnimator();
    AppMethodBeat.o(220244);
  }
  
  public boolean videoEnabled()
  {
    AppMethodBeat.i(220256);
    boolean bool = this.pagPlayer.videoEnabled();
    AppMethodBeat.o(220256);
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
      AppMethodBeat.i(220220);
      this.lock = new Object();
      this.needsUpdateViews = new ArrayList();
      AppMethodBeat.o(220220);
    }
    
    public void handleMessage(Message arg1)
    {
      AppMethodBeat.i(220222);
      super.handleMessage(???);
      switch (???.arg1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(220222);
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
        AppMethodBeat.o(220222);
        return;
        if (!(???.obj instanceof SurfaceTexture))
        {
          AppMethodBeat.o(220222);
          return;
        }
        ((SurfaceTexture)???.obj).release();
        AppMethodBeat.o(220222);
        return;
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(220219);
            PAGView.access$100();
            AppMethodBeat.o(220219);
          }
        });
      }
    }
    
    void needsUpdateView(PAGView paramPAGView)
    {
      AppMethodBeat.i(220221);
      synchronized (this.lock)
      {
        if (this.needsUpdateViews.isEmpty())
        {
          Message localMessage = obtainMessage();
          localMessage.arg1 = 0;
          sendMessage(localMessage);
        }
        this.needsUpdateViews.add(paramPAGView);
        AppMethodBeat.o(220221);
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