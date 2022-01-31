package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;

@TargetApi(18)
class InputSurface
{
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  private static final String TAG;
  private EGLContext mEGLContext;
  private EGLDisplay mEGLDisplay;
  private EGLSurface mEGLSurface;
  private Surface mSurface;
  
  static
  {
    AppMethodBeat.i(83699);
    TAG = InputSurface.class.getSimpleName();
    AppMethodBeat.o(83699);
  }
  
  public InputSurface(EGLContext paramEGLContext, Surface paramSurface)
  {
    AppMethodBeat.i(83693);
    this.mSurface = null;
    this.mEGLDisplay = null;
    this.mEGLContext = null;
    this.mEGLSurface = null;
    if (paramSurface == null)
    {
      paramEGLContext = new NullPointerException();
      AppMethodBeat.o(83693);
      throw paramEGLContext;
    }
    this.mSurface = paramSurface;
    eglSetup(paramEGLContext);
    AppMethodBeat.o(83693);
  }
  
  private void eglSetup(EGLContext paramEGLContext)
  {
    AppMethodBeat.i(83698);
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      Object localObject = new int[2];
      if (!EGL14.eglInitialize(this.mEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
      {
        this.mEGLDisplay = null;
        AppMethodBeat.o(83698);
        return;
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      localObject = new int[1];
      if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344 }, 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0))
      {
        EGLDisplay localEGLDisplay = this.mEGLDisplay;
        EGLConfig localEGLConfig = arrayOfEGLConfig[0];
        localObject = paramEGLContext;
        if (paramEGLContext == null) {
          localObject = EGL14.EGL_NO_CONTEXT;
        }
        this.mEGLContext = EGL14.eglCreateContext(localEGLDisplay, localEGLConfig, (EGLContext)localObject, new int[] { 12440, 2, 12344 }, 0);
        GlUtil.checkEglError("eglCreateContext");
        if (this.mEGLContext != null)
        {
          this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, arrayOfEGLConfig[0], this.mSurface, new int[] { 12344 }, 0);
          GlUtil.checkEglError("eglCreateWindowSurface");
        }
      }
    }
    AppMethodBeat.o(83698);
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public void makeCurrent()
  {
    AppMethodBeat.i(83695);
    EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
    AppMethodBeat.o(83695);
  }
  
  public void release()
  {
    AppMethodBeat.i(83694);
    EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
    EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
    EGL14.eglTerminate(this.mEGLDisplay);
    this.mSurface.release();
    this.mSurface = null;
    this.mEGLDisplay = null;
    this.mEGLContext = null;
    this.mEGLSurface = null;
    AppMethodBeat.o(83694);
  }
  
  public void setPresentationTime(long paramLong)
  {
    AppMethodBeat.i(83697);
    EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, this.mEGLSurface, paramLong);
    AppMethodBeat.o(83697);
  }
  
  public boolean swapBuffers()
  {
    AppMethodBeat.i(83696);
    boolean bool = EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface);
    AppMethodBeat.o(83696);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.recorder.InputSurface
 * JD-Core Version:    0.7.0.1
 */