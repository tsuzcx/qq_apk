package com.tencent.mm.plugin.sns.ad.widget.alphavideo;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class f
  implements Runnable
{
  protected final SurfaceTexture PJG;
  a Qfl;
  protected volatile boolean mIsPause = false;
  private final Object mLock = new Object();
  private EGL10 mcJ;
  private EGLDisplay mcK;
  private EGLSurface mcL;
  private EGLContext mcN;
  private volatile boolean running;
  protected int surfaceHeight;
  protected int surfaceWidth;
  
  public f(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.PJG = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    this.running = true;
  }
  
  private boolean hcP()
  {
    try
    {
      hcM();
      if (this.Qfl != null) {
        this.Qfl.hcH();
      }
      return false;
    }
    finally
    {
      c.e("TextureSurfaceRenderer", "initGLComponents failed", localThrowable);
      if (this.Qfl != null) {
        this.Qfl.hcI();
      }
    }
    return true;
  }
  
  private boolean hcQ()
  {
    EGLConfig[] arrayOfEGLConfig;
    try
    {
      this.mcJ = ((EGL10)EGLContext.getEGL());
      this.mcK = this.mcJ.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      int[] arrayOfInt = new int[2];
      this.mcJ.eglInitialize(this.mcK, arrayOfInt);
      arrayOfInt = new int[1];
      arrayOfEGLConfig = new EGLConfig[1];
      if (!this.mcJ.eglChooseConfig(this.mcK, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 }, arrayOfEGLConfig, 1, arrayOfInt)) {
        throw new IllegalArgumentException("Failed to choose config: " + GLUtils.getEGLErrorString(this.mcJ.eglGetError()));
      }
    }
    finally
    {
      c.e("TextureSurfaceRenderer", "initGL failed", localThrowable);
      if (this.Qfl != null) {
        this.Qfl.hcG();
      }
      return true;
    }
    if (localThrowable[0] > 0) {}
    for (EGLConfig localEGLConfig = arrayOfEGLConfig[0];; localEGLConfig = null)
    {
      this.mcN = this.mcJ.eglCreateContext(this.mcK, localEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
      this.mcL = this.mcJ.eglCreateWindowSurface(this.mcK, localEGLConfig, this.PJG, null);
      if ((this.mcL == null) || (this.mcL == EGL10.EGL_NO_SURFACE)) {
        throw new RuntimeException("GL Error: " + GLUtils.getEGLErrorString(this.mcJ.eglGetError()));
      }
      if (!this.mcJ.eglMakeCurrent(this.mcK, this.mcL, this.mcL, this.mcN)) {
        throw new RuntimeException("GL Make current error: " + GLUtils.getEGLErrorString(this.mcJ.eglGetError()));
      }
      if (this.Qfl != null) {
        this.Qfl.hcF();
      }
      return false;
    }
  }
  
  protected abstract boolean hcL();
  
  protected abstract void hcM();
  
  protected abstract void hcN();
  
  public final void onDestroy()
  {
    this.running = false;
    this.mIsPause = false;
    synchronized (this.mLock)
    {
      this.mLock.notifyAll();
      return;
    }
  }
  
  public final void onPause()
  {
    this.mIsPause = true;
  }
  
  public final void onResume()
  {
    this.mIsPause = false;
    synchronized (this.mLock)
    {
      this.mLock.notifyAll();
      return;
    }
  }
  
  public void run()
  {
    if (hcQ()) {}
    while (hcP()) {
      return;
    }
    c.d("TextureSurfaceRenderer", "OpenGL init OK.");
    for (;;)
    {
      long l1;
      synchronized (this.mLock)
      {
        if (!this.running) {
          break;
        }
        l1 = System.currentTimeMillis();
        if (hcL()) {
          this.mcJ.eglSwapBuffers(this.mcK, this.mcL);
        }
        long l2 = System.currentTimeMillis();
        l1 = 32L - (l2 - l1);
        if (l1 <= 0L) {
          continue;
        }
        try
        {
          if (this.mIsPause) {
            this.mLock.wait(300L);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          c.e("TextureSurfaceRenderer", localInterruptedException);
        }
      }
      this.mLock.wait(l1);
    }
    hcN();
    if (this.Qfl != null) {
      this.Qfl.hcJ();
    }
    ??? = this.mcJ;
    EGLDisplay localEGLDisplay = this.mcK;
    EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
    ((EGL10)???).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
    this.mcJ.eglDestroySurface(this.mcK, this.mcL);
    this.mcJ.eglDestroyContext(this.mcK, this.mcN);
    this.mcJ.eglTerminate(this.mcK);
    c.d("TextureSurfaceRenderer", "OpenGL deinit OK.");
    if (this.Qfl != null) {
      this.Qfl.hcK();
    }
    c.d("TextureSurfaceRenderer", "OpenGL loop end.");
  }
  
  public static abstract interface a
  {
    public abstract void hcF();
    
    public abstract void hcG();
    
    public abstract void hcH();
    
    public abstract void hcI();
    
    public abstract void hcJ();
    
    public abstract void hcK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.alphavideo.f
 * JD-Core Version:    0.7.0.1
 */