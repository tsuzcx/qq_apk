package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.gl.e.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class ky$2
  implements e.g
{
  ky$2(ky paramky) {}
  
  public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    paramObject = null;
    AppMethodBeat.i(149093);
    try
    {
      paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, ky.b(this.a), null);
      AppMethodBeat.o(149093);
      return paramEGL10;
    }
    catch (OutOfMemoryError paramEGL10)
    {
      for (;;)
      {
        paramEGL10 = paramObject;
      }
    }
    catch (IllegalArgumentException paramEGL10)
    {
      for (;;)
      {
        paramEGL10 = paramObject;
      }
    }
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(149094);
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    AppMethodBeat.o(149094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ky.2
 * JD-Core Version:    0.7.0.1
 */