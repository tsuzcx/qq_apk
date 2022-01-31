package com.tencent.ttpic.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class GLSurfaceView$DefaultContextFactory
  implements GLSurfaceView.EGLContextFactory
{
  private int EGL_CONTEXT_CLIENT_VERSION = 12440;
  
  private GLSurfaceView$DefaultContextFactory(GLSurfaceView paramGLSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(84431);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.EGL_CONTEXT_CLIENT_VERSION;
    arrayOfInt[1] = GLSurfaceView.access$200(this.this$0);
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
    if (GLSurfaceView.access$200(this.this$0) != 0) {}
    for (;;)
    {
      paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
      AppMethodBeat.o(84431);
      return paramEGL10;
      arrayOfInt = null;
    }
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(84432);
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      new StringBuilder("display:").append(paramEGLDisplay).append(" context: ").append(paramEGLContext);
      GLSurfaceView.EglHelper.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
    }
    AppMethodBeat.o(84432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.view.GLSurfaceView.DefaultContextFactory
 * JD-Core Version:    0.7.0.1
 */