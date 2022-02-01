package com.tencent.thumbplayer.core.postprocessor;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DisplaySurface
{
  private static final int EGL_OPENGL_ES2_BIT = 4;
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  private static final String TAG = "sifeng: DisplaySurface";
  private static final boolean VERBOSE = false;
  private EGLContext mEGLContext;
  private EGLDisplay mEGLDisplay;
  private EGLSurface mEGLSurface;
  public int mHeight;
  private Surface mSurface;
  public int mWidth;
  
  public DisplaySurface(Surface paramSurface)
  {
    AppMethodBeat.i(227388);
    if (paramSurface == null)
    {
      paramSurface = new NullPointerException();
      AppMethodBeat.o(227388);
      throw paramSurface;
    }
    this.mSurface = paramSurface;
    eglSetup();
    AppMethodBeat.o(227388);
  }
  
  private void checkEglError(String paramString)
  {
    AppMethodBeat.i(227426);
    for (int i = 0;; i = 1)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      new StringBuilder().append(paramString).append(": EGL error: 0x").append(Integer.toHexString(j));
    }
    if (i != 0)
    {
      paramString = new RuntimeException("EGL error encountered (see log)");
      AppMethodBeat.o(227426);
      throw paramString;
    }
    AppMethodBeat.o(227426);
  }
  
  private void eglSetup()
  {
    AppMethodBeat.i(227415);
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY)
    {
      localObject = new RuntimeException("unable to get EGL14 display");
      AppMethodBeat.o(227415);
      throw ((Throwable)localObject);
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.mEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
    {
      this.mEGLDisplay = null;
      localObject = new RuntimeException("unable to initialize EGL14");
      AppMethodBeat.o(227415);
      throw ((Throwable)localObject);
    }
    localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (!EGL14.eglChooseConfig(this.mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344 }, 0, (EGLConfig[])localObject, 0, 1, arrayOfInt, 0))
    {
      localObject = new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
      AppMethodBeat.o(227415);
      throw ((Throwable)localObject);
    }
    this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, localObject[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    checkEglError("eglCreateContext");
    if (this.mEGLContext == null)
    {
      localObject = new RuntimeException("null context");
      AppMethodBeat.o(227415);
      throw ((Throwable)localObject);
    }
    this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, localObject[0], this.mSurface, new int[] { 12344 }, 0);
    checkEglError("eglCreateWindowSurface");
    if (this.mEGLSurface == null)
    {
      localObject = new RuntimeException("surface was null");
      AppMethodBeat.o(227415);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(227415);
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public int getmHeight()
  {
    return this.mHeight;
  }
  
  public int getmWidth()
  {
    return this.mWidth;
  }
  
  public void makeCurrent()
  {
    AppMethodBeat.i(227456);
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext))
    {
      RuntimeException localRuntimeException = new RuntimeException("eglMakeCurrent failed");
      AppMethodBeat.o(227456);
      throw localRuntimeException;
    }
    AppMethodBeat.o(227456);
  }
  
  public void querySurface()
  {
    AppMethodBeat.i(227470);
    this.mWidth = 0;
    this.mHeight = 0;
    if ((this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) || (Build.VERSION.SDK_INT < 17))
    {
      localObject = new RuntimeException("querySurface failed");
      AppMethodBeat.o(227470);
      throw ((Throwable)localObject);
    }
    Object localObject = new int[1];
    if (EGL14.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12375, (int[])localObject, 0)) {
      this.mWidth = localObject[0];
    }
    if (EGL14.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12374, (int[])localObject, 0)) {
      this.mHeight = localObject[0];
    }
    AppMethodBeat.o(227470);
  }
  
  public void release()
  {
    AppMethodBeat.i(227444);
    if (EGL14.eglGetCurrentContext().equals(this.mEGLContext))
    {
      EGLDisplay localEGLDisplay = this.mEGLDisplay;
      EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
    }
    EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
    EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
    this.mEGLDisplay = null;
    this.mEGLContext = null;
    this.mEGLSurface = null;
    this.mSurface = null;
    AppMethodBeat.o(227444);
  }
  
  public boolean swapBuffers()
  {
    AppMethodBeat.i(227503);
    boolean bool = EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface);
    AppMethodBeat.o(227503);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.postprocessor.DisplaySurface
 * JD-Core Version:    0.7.0.1
 */