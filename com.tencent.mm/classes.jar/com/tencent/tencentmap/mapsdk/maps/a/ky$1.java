package com.tencent.tencentmap.mapsdk.maps.a;

import android.util.Log;
import com.tencent.map.lib.d;
import com.tencent.map.lib.gl.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class ky$1
  implements e.f
{
  ky$1(ky paramky) {}
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(149092);
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    AppMethodBeat.o(149092);
    return paramEGL10;
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(149091);
    Object localObject = new byte[1];
    ky.a(this.a, (byte[])localObject);
    try
    {
      localObject.wait(1000L);
      ky.a(this.a);
      localObject = EGL10.EGL_NO_SURFACE;
      paramEGL10.eglMakeCurrent(paramEGLDisplay, (EGLSurface)localObject, (EGLSurface)localObject, EGL10.EGL_NO_CONTEXT);
      paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
      AppMethodBeat.o(149091);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        d.b(Log.getStackTraceString(localInterruptedException));
        Thread.currentThread().interrupt();
      }
    }
    finally
    {
      AppMethodBeat.o(149091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ky.1
 * JD-Core Version:    0.7.0.1
 */