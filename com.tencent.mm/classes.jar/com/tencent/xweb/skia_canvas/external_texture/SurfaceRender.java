package com.tencent.xweb.skia_canvas.external_texture;

import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class SurfaceRender
{
  private static final String LOG_TAG = "SurfaceRender";
  private EGL10 egl;
  private EGLConfig eglConfig;
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface;
  private int mHeight;
  private boolean mInited;
  private int mWidth;
  private Surface surface;
  
  SurfaceRender(Surface paramSurface)
  {
    this.surface = paramSurface;
  }
  
  private void initEGLSurface()
  {
    AppMethodBeat.i(213915);
    this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, this.surface, null);
    if ((this.eglSurface == null) || (this.eglSurface == EGL10.EGL_NO_SURFACE))
    {
      localObject = new RuntimeException("GL Error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()) + " with surface " + this.surface);
      AppMethodBeat.o(213915);
      throw ((Throwable)localObject);
    }
    if (!this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext))
    {
      localObject = new RuntimeException("GL Make current error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
      AppMethodBeat.o(213915);
      throw ((Throwable)localObject);
    }
    Object localObject = new int[1];
    this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, (int[])localObject);
    this.mWidth = localObject[0];
    this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, (int[])localObject);
    this.mHeight = localObject[0];
    new StringBuilder("query w/h is ").append(this.mWidth).append(" / ").append(this.mHeight).append(" from ").append(this.surface);
    AppMethodBeat.o(213915);
  }
  
  void adjustViewPort()
  {
    AppMethodBeat.i(213962);
    GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
    AppMethodBeat.o(213962);
  }
  
  void deinitGL()
  {
    AppMethodBeat.i(214008);
    if (this.mInited)
    {
      EGL10 localEGL10 = this.egl;
      EGLDisplay localEGLDisplay = this.eglDisplay;
      EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
      localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
      this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
    }
    AppMethodBeat.o(214008);
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public Surface getSurface()
  {
    return this.surface;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  void init(EGL10 paramEGL10, EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(213927);
    if (!this.mInited)
    {
      this.egl = paramEGL10;
      this.eglContext = paramEGLContext;
      this.eglDisplay = paramEGLDisplay;
      this.eglConfig = paramEGLConfig;
      initEGLSurface();
      this.mInited = true;
    }
    AppMethodBeat.o(213927);
  }
  
  void makeCurrent()
  {
    AppMethodBeat.i(213942);
    this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext);
    AppMethodBeat.o(213942);
  }
  
  void swapBuffer()
  {
    AppMethodBeat.i(213975);
    this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
    AppMethodBeat.o(213975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SurfaceRender
 * JD-Core Version:    0.7.0.1
 */