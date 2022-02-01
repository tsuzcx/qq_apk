package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class SurfaceTextureRender
{
  private static final String LOG_TAG = "SurfaceTextureRender";
  private EGL10 egl;
  private EGLConfig eglConfig;
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface;
  private int mHeight;
  private boolean mInited;
  private int mWidth;
  private SurfaceTexture surfaceTexture;
  
  SurfaceTextureRender(SurfaceTexture paramSurfaceTexture)
  {
    this.surfaceTexture = paramSurfaceTexture;
  }
  
  private void initEGLSurface()
  {
    AppMethodBeat.i(4334);
    this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, this.surfaceTexture, null);
    if ((this.eglSurface == null) || (this.eglSurface == EGL10.EGL_NO_SURFACE))
    {
      localObject = new RuntimeException("GL Error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()) + " with surface " + this.surfaceTexture);
      AppMethodBeat.o(4334);
      throw ((Throwable)localObject);
    }
    if (!this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext))
    {
      localObject = new RuntimeException("GL Make current error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
      AppMethodBeat.o(4334);
      throw ((Throwable)localObject);
    }
    Object localObject = new int[1];
    this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, (int[])localObject);
    this.mWidth = localObject[0];
    this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, (int[])localObject);
    this.mHeight = localObject[0];
    new StringBuilder("query w/h is ").append(this.mWidth).append(" / ").append(this.mHeight).append(" from ").append(this.surfaceTexture);
    AppMethodBeat.o(4334);
  }
  
  void adjustViewPort()
  {
    AppMethodBeat.i(4332);
    GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
    AppMethodBeat.o(4332);
  }
  
  void deinitGL()
  {
    AppMethodBeat.i(4335);
    if (this.mInited)
    {
      EGL10 localEGL10 = this.egl;
      EGLDisplay localEGLDisplay = this.eglDisplay;
      EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
      localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
      this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
    }
    AppMethodBeat.o(4335);
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public SurfaceTexture getSurface()
  {
    return this.surfaceTexture;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  void init(EGL10 paramEGL10, EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(4330);
    if (!this.mInited)
    {
      this.egl = paramEGL10;
      this.eglContext = paramEGLContext;
      this.eglDisplay = paramEGLDisplay;
      this.eglConfig = paramEGLConfig;
      initEGLSurface();
      this.mInited = true;
    }
    AppMethodBeat.o(4330);
  }
  
  void makeCurrent()
  {
    AppMethodBeat.i(4331);
    this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext);
    AppMethodBeat.o(4331);
  }
  
  void swapBuffer()
  {
    AppMethodBeat.i(4333);
    this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
    AppMethodBeat.o(4333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SurfaceTextureRender
 * JD-Core Version:    0.7.0.1
 */