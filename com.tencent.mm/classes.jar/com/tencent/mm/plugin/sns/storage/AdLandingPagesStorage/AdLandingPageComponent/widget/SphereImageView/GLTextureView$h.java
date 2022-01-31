package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class GLTextureView$h
{
  WeakReference<GLTextureView> rAo;
  EGL10 rAp;
  EGLDisplay rAq;
  EGLSurface rAr;
  EGLConfig rAs;
  EGLContext rAt;
  
  public GLTextureView$h(WeakReference<GLTextureView> paramWeakReference)
  {
    this.rAo = paramWeakReference;
  }
  
  public static String formatEglError(String paramString, int paramInt)
  {
    AppMethodBeat.i(145344);
    paramString = paramString + " failed: " + paramInt;
    AppMethodBeat.o(145344);
    return paramString;
  }
  
  public static void throwEglException(String paramString, int paramInt)
  {
    AppMethodBeat.i(145343);
    paramString = new RuntimeException(formatEglError(paramString, paramInt));
    AppMethodBeat.o(145343);
    throw paramString;
  }
  
  final void destroySurfaceImp()
  {
    AppMethodBeat.i(145341);
    if ((this.rAr != null) && (this.rAr != EGL10.EGL_NO_SURFACE))
    {
      Object localObject = this.rAp;
      EGLDisplay localEGLDisplay = this.rAq;
      EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
      ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
      localObject = (GLTextureView)this.rAo.get();
      if (localObject != null) {
        GLTextureView.d((GLTextureView)localObject).destroySurface(this.rAp, this.rAq, this.rAr);
      }
      this.rAr = null;
    }
    AppMethodBeat.o(145341);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(145342);
    if (this.rAt != null)
    {
      GLTextureView localGLTextureView = (GLTextureView)this.rAo.get();
      if (localGLTextureView != null) {
        GLTextureView.c(localGLTextureView).destroyContext(this.rAp, this.rAq, this.rAt);
      }
      this.rAt = null;
    }
    if (this.rAq != null)
    {
      this.rAp.eglTerminate(this.rAq);
      this.rAq = null;
    }
    AppMethodBeat.o(145342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.h
 * JD-Core Version:    0.7.0.1
 */