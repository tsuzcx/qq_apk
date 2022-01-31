package com.tencent.ttpic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class GLSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback2
{
  public static final int DEBUG_CHECK_GL_ERROR = 1;
  public static final int DEBUG_LOG_GL_CALLS = 2;
  private static final boolean LOG_ATTACH_DETACH = false;
  private static final boolean LOG_EGL = false;
  private static final boolean LOG_PAUSE_RESUME = false;
  private static final boolean LOG_RENDERER = false;
  private static final boolean LOG_RENDERER_DRAW_FRAME = false;
  private static final boolean LOG_SURFACE = false;
  private static final boolean LOG_THREADS = false;
  public static final int RENDERMODE_CONTINUOUSLY = 1;
  public static final int RENDERMODE_WHEN_DIRTY = 0;
  private static final String TAG = "GLSurfaceView";
  private static final GLSurfaceView.GLThreadManager sGLThreadManager;
  private int mDebugFlags;
  private boolean mDetached;
  private EGLConfigChooser mEGLConfigChooser;
  private int mEGLContextClientVersion;
  private GLSurfaceView.EGLContextFactory mEGLContextFactory;
  private GLSurfaceView.EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
  private GLSurfaceView.GLThread mGLThread;
  private GLSurfaceView.GLWrapper mGLWrapper;
  private boolean mPreserveEGLContextOnPause;
  private Renderer mRenderer;
  private final WeakReference<GLSurfaceView> mThisWeakRef;
  
  static
  {
    AppMethodBeat.i(84496);
    sGLThreadManager = new GLSurfaceView.GLThreadManager(null);
    AppMethodBeat.o(84496);
  }
  
  public GLSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(84472);
    this.mThisWeakRef = new WeakReference(this);
    init();
    AppMethodBeat.o(84472);
  }
  
  public GLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(84473);
    this.mThisWeakRef = new WeakReference(this);
    init();
    AppMethodBeat.o(84473);
  }
  
  private void checkRenderThreadState()
  {
    AppMethodBeat.i(84495);
    if (this.mGLThread != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(84495);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(84495);
  }
  
  private void init()
  {
    AppMethodBeat.i(84475);
    getHolder().addCallback(this);
    AppMethodBeat.o(84475);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(84474);
    try
    {
      if (this.mGLThread != null) {
        this.mGLThread.requestExitAndWait();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(84474);
    }
  }
  
  public int getDebugFlags()
  {
    return this.mDebugFlags;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.mPreserveEGLContextOnPause;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(84484);
    int i = this.mGLThread.getRenderMode();
    AppMethodBeat.o(84484);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(84493);
    super.onAttachedToWindow();
    if ((this.mDetached) && (this.mRenderer != null)) {
      if (this.mGLThread == null) {
        break label84;
      }
    }
    label84:
    for (int i = this.mGLThread.getRenderMode();; i = 1)
    {
      this.mGLThread = new GLSurfaceView.GLThread(this.mThisWeakRef);
      if (i != 1) {
        this.mGLThread.setRenderMode(i);
      }
      this.mGLThread.start();
      this.mDetached = false;
      AppMethodBeat.o(84493);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(84494);
    if (this.mGLThread != null) {
      this.mGLThread.requestExitAndWait();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(84494);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(84490);
    this.mGLThread.onPause();
    AppMethodBeat.o(84490);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(84491);
    this.mGLThread.onResume();
    AppMethodBeat.o(84491);
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    AppMethodBeat.i(84492);
    this.mGLThread.queueEvent(paramRunnable);
    AppMethodBeat.o(84492);
  }
  
  public void requestRender()
  {
    AppMethodBeat.i(84485);
    this.mGLThread.requestRender();
    AppMethodBeat.o(84485);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.mDebugFlags = paramInt;
  }
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(84481);
    setEGLConfigChooser(new GLSurfaceView.ComponentSizeChooser(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
    AppMethodBeat.o(84481);
  }
  
  public void setEGLConfigChooser(EGLConfigChooser paramEGLConfigChooser)
  {
    AppMethodBeat.i(84479);
    checkRenderThreadState();
    this.mEGLConfigChooser = paramEGLConfigChooser;
    AppMethodBeat.o(84479);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(84480);
    setEGLConfigChooser(new GLSurfaceView.SimpleEGLConfigChooser(this, paramBoolean));
    AppMethodBeat.o(84480);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(84482);
    checkRenderThreadState();
    this.mEGLContextClientVersion = paramInt;
    AppMethodBeat.o(84482);
  }
  
  public void setEGLContextFactory(GLSurfaceView.EGLContextFactory paramEGLContextFactory)
  {
    AppMethodBeat.i(84477);
    checkRenderThreadState();
    this.mEGLContextFactory = paramEGLContextFactory;
    AppMethodBeat.o(84477);
  }
  
  public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory)
  {
    AppMethodBeat.i(84478);
    checkRenderThreadState();
    this.mEGLWindowSurfaceFactory = paramEGLWindowSurfaceFactory;
    AppMethodBeat.o(84478);
  }
  
  public void setGLWrapper(GLSurfaceView.GLWrapper paramGLWrapper)
  {
    this.mGLWrapper = paramGLWrapper;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mPreserveEGLContextOnPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(84483);
    this.mGLThread.setRenderMode(paramInt);
    AppMethodBeat.o(84483);
  }
  
  public void setRenderer(Renderer paramRenderer)
  {
    AppMethodBeat.i(84476);
    checkRenderThreadState();
    if (this.mEGLConfigChooser == null) {
      this.mEGLConfigChooser = new GLSurfaceView.SimpleEGLConfigChooser(this, true);
    }
    if (this.mEGLContextFactory == null) {
      this.mEGLContextFactory = new GLSurfaceView.DefaultContextFactory(this, null);
    }
    if (this.mEGLWindowSurfaceFactory == null) {
      this.mEGLWindowSurfaceFactory = new GLSurfaceView.DefaultWindowSurfaceFactory(null);
    }
    this.mRenderer = paramRenderer;
    this.mGLThread = new GLSurfaceView.GLThread(this.mThisWeakRef);
    this.mGLThread.start();
    AppMethodBeat.o(84476);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(84488);
    this.mGLThread.onWindowResize(paramInt2, paramInt3);
    AppMethodBeat.o(84488);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(84486);
    this.mGLThread.surfaceCreated();
    AppMethodBeat.o(84486);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(84487);
    this.mGLThread.surfaceDestroyed();
    AppMethodBeat.o(84487);
  }
  
  @Deprecated
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceRedrawNeededAsync(SurfaceHolder paramSurfaceHolder, Runnable paramRunnable)
  {
    AppMethodBeat.i(84489);
    if (this.mGLThread != null) {
      this.mGLThread.requestRenderAndNotify(paramRunnable);
    }
    AppMethodBeat.o(84489);
  }
  
  public static abstract interface EGLConfigChooser
  {
    public abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
  }
  
  public static abstract interface Renderer
  {
    public abstract void onDrawFrame(GL10 paramGL10);
    
    public abstract void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2);
    
    public abstract void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.view.GLSurfaceView
 * JD-Core Version:    0.7.0.1
 */