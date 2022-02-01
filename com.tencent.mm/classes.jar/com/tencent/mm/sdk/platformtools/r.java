package com.tencent.mm.sdk.platformtools;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r
{
  int ETH;
  EGLDisplay ETI;
  EGLSurface ETJ;
  EGLContext ETK;
  
  private r()
  {
    AppMethodBeat.i(157557);
    this.ETH = 2048;
    ad.i("MicroMsg.GPU_TAG", "pennqin, init Help30Impl.");
    AppMethodBeat.o(157557);
  }
  
  final void release()
  {
    AppMethodBeat.i(185117);
    if (EGL14.EGL_NO_DISPLAY != this.ETI)
    {
      EGLDisplay localEGLDisplay = this.ETI;
      EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.ETI, this.ETJ);
      EGL14.eglDestroyContext(this.ETI, this.ETK);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.ETI);
    }
    this.ETI = EGL14.EGL_NO_DISPLAY;
    this.ETK = EGL14.EGL_NO_CONTEXT;
    this.ETJ = EGL14.EGL_NO_SURFACE;
    AppMethodBeat.o(185117);
  }
  
  static final class a
  {
    static r ETL;
    
    static
    {
      AppMethodBeat.i(157556);
      ETL = new r((byte)0);
      AppMethodBeat.o(157556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.r
 * JD-Core Version:    0.7.0.1
 */