package com.tencent.mm.sdk.platformtools;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class s
{
  int IcI;
  EGLSurface IcJ;
  EGLContext IcK;
  EGLDisplay gtx;
  
  private s()
  {
    AppMethodBeat.i(157557);
    this.IcI = 2048;
    ad.i("MicroMsg.GPU_TAG", "pennqin, init Help30Impl.");
    AppMethodBeat.o(157557);
  }
  
  final void release()
  {
    AppMethodBeat.i(185117);
    if (EGL14.EGL_NO_DISPLAY != this.gtx)
    {
      EGLDisplay localEGLDisplay = this.gtx;
      EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.gtx, this.IcJ);
      EGL14.eglDestroyContext(this.gtx, this.IcK);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.gtx);
    }
    this.gtx = EGL14.EGL_NO_DISPLAY;
    this.IcK = EGL14.EGL_NO_CONTEXT;
    this.IcJ = EGL14.EGL_NO_SURFACE;
    AppMethodBeat.o(185117);
  }
  
  static final class a
  {
    static s IcL;
    
    static
    {
      AppMethodBeat.i(157556);
      IcL = new s((byte)0);
      AppMethodBeat.o(157556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.s
 * JD-Core Version:    0.7.0.1
 */