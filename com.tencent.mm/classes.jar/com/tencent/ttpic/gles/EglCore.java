package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(17)
public final class EglCore
{
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  public static final int FLAG_RECORDABLE = 1;
  public static final int FLAG_TRY_GLES3 = 2;
  private static final String TAG = GlUtil.TAG;
  private EGLConfig mEGLConfig;
  private EGLContext mEGLContext;
  private EGLDisplay mEGLDisplay;
  private int mGlVersion;
  
  public EglCore()
  {
    this(null, 0);
  }
  
  public EglCore(EGLContext paramEGLContext, int paramInt)
  {
    AppMethodBeat.i(49955);
    this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.mEGLContext = EGL14.EGL_NO_CONTEXT;
    this.mEGLConfig = null;
    this.mGlVersion = -1;
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      paramEGLContext = new RuntimeException("EGL already set up");
      AppMethodBeat.o(49955);
      throw paramEGLContext;
    }
    EGLContext localEGLContext1 = paramEGLContext;
    if (paramEGLContext == null) {
      localEGLContext1 = EGL14.EGL_NO_CONTEXT;
    }
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY)
    {
      paramEGLContext = new RuntimeException("unable to get EGL14 display");
      AppMethodBeat.o(49955);
      throw paramEGLContext;
    }
    paramEGLContext = new int[2];
    if (!EGL14.eglInitialize(this.mEGLDisplay, paramEGLContext, 0, paramEGLContext, 1))
    {
      this.mEGLDisplay = null;
      paramEGLContext = new RuntimeException("unable to initialize EGL14");
      AppMethodBeat.o(49955);
      throw paramEGLContext;
    }
    if ((paramInt & 0x2) != 0)
    {
      paramEGLContext = getConfig(paramInt, 3);
      if (paramEGLContext != null)
      {
        EGLContext localEGLContext2 = EGL14.eglCreateContext(this.mEGLDisplay, paramEGLContext, localEGLContext1, new int[] { 12440, 3, 12344 }, 0);
        if (EGL14.eglGetError() == 12288)
        {
          this.mEGLConfig = paramEGLContext;
          this.mEGLContext = localEGLContext2;
          this.mGlVersion = 3;
        }
      }
    }
    if (this.mEGLContext == EGL14.EGL_NO_CONTEXT)
    {
      paramEGLContext = getConfig(paramInt, 2);
      if (paramEGLContext == null)
      {
        paramEGLContext = new RuntimeException("Unable to find a suitable EGLConfig");
        AppMethodBeat.o(49955);
        throw paramEGLContext;
      }
      localEGLContext1 = EGL14.eglCreateContext(this.mEGLDisplay, paramEGLContext, localEGLContext1, new int[] { 12440, 2, 12344 }, 0);
      checkEglError("eglCreateContext");
      this.mEGLConfig = paramEGLContext;
      this.mEGLContext = localEGLContext1;
      this.mGlVersion = 2;
    }
    paramEGLContext = new int[1];
    EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, 12440, paramEGLContext, 0);
    new StringBuilder("EGLContext created, client version ").append(paramEGLContext[0]);
    AppMethodBeat.o(49955);
  }
  
  private void checkEglError(String paramString)
  {
    AppMethodBeat.i(49971);
    int i = EGL14.eglGetError();
    if (i != 12288) {
      new StringBuilder().append(paramString).append(": EGL error: 0x").append(Integer.toHexString(i));
    }
    AppMethodBeat.o(49971);
  }
  
  private EGLConfig getConfig(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49956);
    int i = 4;
    if (paramInt2 >= 3) {
      i = 68;
    }
    int[] arrayOfInt1 = new int[13];
    arrayOfInt1[0] = 12324;
    arrayOfInt1[1] = 8;
    arrayOfInt1[2] = 12323;
    arrayOfInt1[3] = 8;
    arrayOfInt1[4] = 12322;
    arrayOfInt1[5] = 8;
    arrayOfInt1[6] = 12321;
    arrayOfInt1[7] = 8;
    arrayOfInt1[8] = 12352;
    arrayOfInt1[9] = i;
    arrayOfInt1[10] = 12344;
    arrayOfInt1[11] = 0;
    arrayOfInt1[12] = 12344;
    if ((paramInt1 & 0x1) != 0)
    {
      arrayOfInt1[10] = 12610;
      arrayOfInt1[11] = 1;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = new int[1];
    if (!EGL14.eglChooseConfig(this.mEGLDisplay, arrayOfInt1, 0, arrayOfEGLConfig, 0, 1, arrayOfInt2, 0))
    {
      new StringBuilder("unable to find RGB8888 / ").append(paramInt2).append(" EGLConfig");
      AppMethodBeat.o(49956);
      return null;
    }
    arrayOfInt1 = arrayOfEGLConfig[0];
    AppMethodBeat.o(49956);
    return arrayOfInt1;
  }
  
  public static void logCurrent(String paramString)
  {
    AppMethodBeat.i(49970);
    EGLDisplay localEGLDisplay = EGL14.eglGetCurrentDisplay();
    EGLContext localEGLContext = EGL14.eglGetCurrentContext();
    EGLSurface localEGLSurface = EGL14.eglGetCurrentSurface(12377);
    new StringBuilder("Current EGL (").append(paramString).append("): display=").append(localEGLDisplay).append(", context=").append(localEGLContext).append(", surface=").append(localEGLSurface);
    AppMethodBeat.o(49970);
  }
  
  public final EGLSurface createOffscreenSurface(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49961);
    Object localObject = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    checkEglError("eglCreatePbufferSurface");
    if (localObject == null)
    {
      localObject = new RuntimeException("surface was null");
      AppMethodBeat.o(49961);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(49961);
    return localObject;
  }
  
  public final EGLSurface createWindowSurface(Object paramObject)
  {
    AppMethodBeat.i(49960);
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)))
    {
      paramObject = new RuntimeException("invalid surface: ".concat(String.valueOf(paramObject)));
      AppMethodBeat.o(49960);
      throw paramObject;
    }
    paramObject = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, paramObject, new int[] { 12344 }, 0);
    checkEglError("eglCreateWindowSurface");
    if (paramObject == null)
    {
      paramObject = new RuntimeException("surface was null");
      AppMethodBeat.o(49960);
      throw paramObject;
    }
    AppMethodBeat.o(49960);
    return paramObject;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(49958);
    try
    {
      if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
        release();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(49958);
    }
  }
  
  public final int getGlVersion()
  {
    return this.mGlVersion;
  }
  
  public final boolean isCurrent(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(49967);
    if ((this.mEGLContext.equals(EGL14.eglGetCurrentContext())) && (paramEGLSurface.equals(EGL14.eglGetCurrentSurface(12377))))
    {
      AppMethodBeat.o(49967);
      return true;
    }
    AppMethodBeat.o(49967);
    return false;
  }
  
  public final void makeCurrent(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(49962);
    EGLDisplay localEGLDisplay = EGL14.EGL_NO_DISPLAY;
    EGL14.eglMakeCurrent(this.mEGLDisplay, paramEGLSurface, paramEGLSurface, this.mEGLContext);
    AppMethodBeat.o(49962);
  }
  
  public final void makeCurrent(EGLSurface paramEGLSurface1, EGLSurface paramEGLSurface2)
  {
    AppMethodBeat.i(49963);
    EGLDisplay localEGLDisplay = EGL14.EGL_NO_DISPLAY;
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, paramEGLSurface1, paramEGLSurface2, this.mEGLContext))
    {
      paramEGLSurface1 = new RuntimeException("eglMakeCurrent(draw,read) failed");
      AppMethodBeat.o(49963);
      throw paramEGLSurface1;
    }
    AppMethodBeat.o(49963);
  }
  
  public final void makeNothingCurrent()
  {
    AppMethodBeat.i(49964);
    Object localObject = this.mEGLDisplay;
    EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
    if (!EGL14.eglMakeCurrent((EGLDisplay)localObject, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT))
    {
      localObject = new RuntimeException("eglMakeCurrent failed");
      AppMethodBeat.o(49964);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(49964);
  }
  
  public final String queryString(int paramInt)
  {
    AppMethodBeat.i(49969);
    String str = EGL14.eglQueryString(this.mEGLDisplay, paramInt);
    AppMethodBeat.o(49969);
    return str;
  }
  
  public final int querySurface(EGLSurface paramEGLSurface, int paramInt)
  {
    AppMethodBeat.i(49968);
    int[] arrayOfInt = new int[1];
    EGL14.eglQuerySurface(this.mEGLDisplay, paramEGLSurface, paramInt, arrayOfInt, 0);
    paramInt = arrayOfInt[0];
    AppMethodBeat.o(49968);
    return paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(49957);
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGLDisplay localEGLDisplay = this.mEGLDisplay;
      EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.mEGLDisplay);
    }
    this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.mEGLContext = EGL14.EGL_NO_CONTEXT;
    this.mEGLConfig = null;
    AppMethodBeat.o(49957);
  }
  
  public final void releaseSurface(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(49959);
    EGL14.eglDestroySurface(this.mEGLDisplay, paramEGLSurface);
    AppMethodBeat.o(49959);
  }
  
  @TargetApi(18)
  public final void setPresentationTime(EGLSurface paramEGLSurface, long paramLong)
  {
    AppMethodBeat.i(49966);
    EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, paramEGLSurface, paramLong);
    AppMethodBeat.o(49966);
  }
  
  public final boolean swapBuffers(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(49965);
    boolean bool = EGL14.eglSwapBuffers(this.mEGLDisplay, paramEGLSurface);
    AppMethodBeat.o(49965);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.gles.EglCore
 * JD-Core Version:    0.7.0.1
 */