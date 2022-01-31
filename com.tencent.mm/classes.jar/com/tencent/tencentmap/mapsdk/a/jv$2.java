package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.gl.e.g;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class jv$2
  implements e.g
{
  jv$2(jv paramjv) {}
  
  public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    try
    {
      paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, jv.d(this.a), null);
      return paramEGL10;
    }
    catch (OutOfMemoryError paramEGL10)
    {
      return null;
    }
    catch (IllegalArgumentException paramEGL10) {}
    return null;
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jv.2
 * JD-Core Version:    0.7.0.1
 */