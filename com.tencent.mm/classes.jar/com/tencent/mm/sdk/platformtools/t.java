package com.tencent.mm.sdk.platformtools;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t
{
  int IwT;
  EGLSurface IwU;
  EGLContext IwV;
  EGLDisplay gwe;
  
  private t()
  {
    AppMethodBeat.i(157557);
    this.IwT = 2048;
    ae.i("MicroMsg.GPU_TAG", "pennqin, init Help30Impl.");
    AppMethodBeat.o(157557);
  }
  
  final void release()
  {
    AppMethodBeat.i(185117);
    if (EGL14.EGL_NO_DISPLAY != this.gwe)
    {
      EGLDisplay localEGLDisplay = this.gwe;
      EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.gwe, this.IwU);
      EGL14.eglDestroyContext(this.gwe, this.IwV);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.gwe);
    }
    this.gwe = EGL14.EGL_NO_DISPLAY;
    this.IwV = EGL14.EGL_NO_CONTEXT;
    this.IwU = EGL14.EGL_NO_SURFACE;
    AppMethodBeat.o(185117);
  }
  
  static final class a
  {
    static t IwW;
    
    static
    {
      AppMethodBeat.i(157556);
      IwW = new t((byte)0);
      AppMethodBeat.o(157556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.t
 * JD-Core Version:    0.7.0.1
 */