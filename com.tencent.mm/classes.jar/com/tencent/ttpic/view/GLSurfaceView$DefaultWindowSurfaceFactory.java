package com.tencent.ttpic.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class GLSurfaceView$DefaultWindowSurfaceFactory
  implements GLSurfaceView.EGLWindowSurfaceFactory
{
  public EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(84433);
    try
    {
      paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
      AppMethodBeat.o(84433);
      return paramEGL10;
    }
    catch (IllegalArgumentException paramEGL10)
    {
      for (;;)
      {
        paramEGL10 = localObject;
      }
    }
  }
  
  public void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(84434);
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    AppMethodBeat.o(84434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.view.GLSurfaceView.DefaultWindowSurfaceFactory
 * JD-Core Version:    0.7.0.1
 */