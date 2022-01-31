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

@TargetApi(17)
public final class EglCore
{
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  public static final int FLAG_RECORDABLE = 1;
  public static final int FLAG_TRY_GLES3 = 2;
  private static final String TAG = GlUtil.TAG;
  private EGLConfig mEGLConfig = null;
  private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
  private int mGlVersion = -1;
  
  public EglCore()
  {
    this(null, 0);
  }
  
  public EglCore(EGLContext paramEGLContext, int paramInt)
  {
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("EGL already set up");
    }
    EGLContext localEGLContext1 = paramEGLContext;
    if (paramEGLContext == null) {
      localEGLContext1 = EGL14.EGL_NO_CONTEXT;
    }
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    paramEGLContext = new int[2];
    if (!EGL14.eglInitialize(this.mEGLDisplay, paramEGLContext, 0, paramEGLContext, 1))
    {
      this.mEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
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
      if (paramEGLContext == null) {
        throw new RuntimeException("Unable to find a suitable EGLConfig");
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
  }
  
  private void checkEglError(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288) {
      new StringBuilder().append(paramString).append(": EGL error: 0x").append(Integer.toHexString(i));
    }
  }
  
  private EGLConfig getConfig(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 3) {}
    for (int i = 68;; i = 4)
    {
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
        return null;
      }
      return arrayOfEGLConfig[0];
    }
  }
  
  public static void logCurrent(String paramString)
  {
    EGLDisplay localEGLDisplay = EGL14.eglGetCurrentDisplay();
    EGLContext localEGLContext = EGL14.eglGetCurrentContext();
    EGLSurface localEGLSurface = EGL14.eglGetCurrentSurface(12377);
    new StringBuilder("Current EGL (").append(paramString).append("): display=").append(localEGLDisplay).append(", context=").append(localEGLContext).append(", surface=").append(localEGLSurface);
  }
  
  public final EGLSurface createOffscreenSurface(int paramInt1, int paramInt2)
  {
    EGLSurface localEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    checkEglError("eglCreatePbufferSurface");
    if (localEGLSurface == null) {
      throw new RuntimeException("surface was null");
    }
    return localEGLSurface;
  }
  
  public final EGLSurface createWindowSurface(Object paramObject)
  {
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture))) {
      throw new RuntimeException("invalid surface: " + paramObject);
    }
    paramObject = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, paramObject, new int[] { 12344 }, 0);
    checkEglError("eglCreateWindowSurface");
    if (paramObject == null) {
      throw new RuntimeException("surface was null");
    }
    return paramObject;
  }
  
  protected final void finalize()
  {
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
    }
  }
  
  public final int getGlVersion()
  {
    return this.mGlVersion;
  }
  
  public final boolean isCurrent(EGLSurface paramEGLSurface)
  {
    return (this.mEGLContext.equals(EGL14.eglGetCurrentContext())) && (paramEGLSurface.equals(EGL14.eglGetCurrentSurface(12377)));
  }
  
  public final void makeCurrent(EGLSurface paramEGLSurface)
  {
    EGLDisplay localEGLDisplay = EGL14.EGL_NO_DISPLAY;
    EGL14.eglMakeCurrent(this.mEGLDisplay, paramEGLSurface, paramEGLSurface, this.mEGLContext);
  }
  
  public final void makeCurrent(EGLSurface paramEGLSurface1, EGLSurface paramEGLSurface2)
  {
    EGLDisplay localEGLDisplay = EGL14.EGL_NO_DISPLAY;
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, paramEGLSurface1, paramEGLSurface2, this.mEGLContext)) {
      throw new RuntimeException("eglMakeCurrent(draw,read) failed");
    }
  }
  
  public final void makeNothingCurrent()
  {
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public final String queryString(int paramInt)
  {
    return EGL14.eglQueryString(this.mEGLDisplay, paramInt);
  }
  
  public final int querySurface(EGLSurface paramEGLSurface, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    EGL14.eglQuerySurface(this.mEGLDisplay, paramEGLSurface, paramInt, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public final void release()
  {
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.mEGLDisplay);
    }
    this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.mEGLContext = EGL14.EGL_NO_CONTEXT;
    this.mEGLConfig = null;
  }
  
  public final void releaseSurface(EGLSurface paramEGLSurface)
  {
    EGL14.eglDestroySurface(this.mEGLDisplay, paramEGLSurface);
  }
  
  @TargetApi(18)
  public final void setPresentationTime(EGLSurface paramEGLSurface, long paramLong)
  {
    EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, paramEGLSurface, paramLong);
  }
  
  public final boolean swapBuffers(EGLSurface paramEGLSurface)
  {
    return EGL14.eglSwapBuffers(this.mEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.gles.EglCore
 * JD-Core Version:    0.7.0.1
 */