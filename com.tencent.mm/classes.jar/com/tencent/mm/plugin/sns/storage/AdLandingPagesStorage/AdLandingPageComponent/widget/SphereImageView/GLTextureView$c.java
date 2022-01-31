package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

final class GLTextureView$c
  implements GLTextureView.f
{
  private int EGL_CONTEXT_CLIENT_VERSION = 12440;
  
  private GLTextureView$c(GLTextureView paramGLTextureView) {}
  
  public final EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(145337);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.EGL_CONTEXT_CLIENT_VERSION;
    arrayOfInt[1] = GLTextureView.a(this.rAh);
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
    if (GLTextureView.a(this.rAh) != 0) {}
    for (;;)
    {
      paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
      AppMethodBeat.o(145337);
      return paramEGL10;
      arrayOfInt = null;
    }
  }
  
  public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(145338);
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      new StringBuilder("display:").append(paramEGLDisplay).append(" context: ").append(paramEGLContext);
      GLTextureView.h.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
    }
    AppMethodBeat.o(145338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.c
 * JD-Core Version:    0.7.0.1
 */