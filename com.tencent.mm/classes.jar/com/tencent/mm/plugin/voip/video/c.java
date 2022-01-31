package com.tencent.mm.plugin.voip.video;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

final class c
  implements GLSurfaceView.EGLContextFactory
{
  private static int EGL_CONTEXT_CLIENT_VERSION = 12440;
  
  public final EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(5050);
    int i = EGL_CONTEXT_CLIENT_VERSION;
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    AppMethodBeat.o(5050);
    return paramEGL10;
  }
  
  public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(5051);
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    AppMethodBeat.o(5051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c
 * JD-Core Version:    0.7.0.1
 */