package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.ttpic.gles.GlUtil;

@TargetApi(18)
class InputSurface
{
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  private static final String TAG = InputSurface.class.getSimpleName();
  private EGLContext mEGLContext = null;
  private EGLDisplay mEGLDisplay = null;
  private EGLSurface mEGLSurface = null;
  private Surface mSurface = null;
  
  public InputSurface(EGLContext paramEGLContext, Surface paramSurface)
  {
    if (paramSurface == null) {
      throw new NullPointerException();
    }
    this.mSurface = paramSurface;
    eglSetup(paramEGLContext);
  }
  
  private void eglSetup(EGLContext paramEGLContext)
  {
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    Object localObject;
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      localObject = new int[2];
      if (EGL14.eglInitialize(this.mEGLDisplay, (int[])localObject, 0, (int[])localObject, 1)) {
        break label42;
      }
      this.mEGLDisplay = null;
    }
    label42:
    EGLConfig[] arrayOfEGLConfig;
    do
    {
      do
      {
        return;
        arrayOfEGLConfig = new EGLConfig[1];
        localObject = new int[1];
      } while (!EGL14.eglChooseConfig(this.mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344 }, 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0));
      EGLDisplay localEGLDisplay = this.mEGLDisplay;
      EGLConfig localEGLConfig = arrayOfEGLConfig[0];
      localObject = paramEGLContext;
      if (paramEGLContext == null) {
        localObject = EGL14.EGL_NO_CONTEXT;
      }
      this.mEGLContext = EGL14.eglCreateContext(localEGLDisplay, localEGLConfig, (EGLContext)localObject, new int[] { 12440, 2, 12344 }, 0);
      GlUtil.checkEglError("eglCreateContext");
    } while (this.mEGLContext == null);
    this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, arrayOfEGLConfig[0], this.mSurface, new int[] { 12344 }, 0);
    GlUtil.checkEglError("eglCreateWindowSurface");
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public void makeCurrent()
  {
    EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
  }
  
  public void release()
  {
    EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
    EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
    EGL14.eglTerminate(this.mEGLDisplay);
    this.mSurface.release();
    this.mSurface = null;
    this.mEGLDisplay = null;
    this.mEGLContext = null;
    this.mEGLSurface = null;
  }
  
  public void setPresentationTime(long paramLong)
  {
    EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, this.mEGLSurface, paramLong);
  }
  
  public boolean swapBuffers()
  {
    return EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.recorder.InputSurface
 * JD-Core Version:    0.7.0.1
 */