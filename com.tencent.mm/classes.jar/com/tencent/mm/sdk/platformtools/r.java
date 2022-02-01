package com.tencent.mm.sdk.platformtools;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r
{
  int GqU;
  EGLSurface GqV;
  EGLContext GqW;
  EGLDisplay fZZ;
  
  private r()
  {
    AppMethodBeat.i(157557);
    this.GqU = 2048;
    ac.i("MicroMsg.GPU_TAG", "pennqin, init Help30Impl.");
    AppMethodBeat.o(157557);
  }
  
  final void release()
  {
    AppMethodBeat.i(185117);
    if (EGL14.EGL_NO_DISPLAY != this.fZZ)
    {
      EGLDisplay localEGLDisplay = this.fZZ;
      EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.fZZ, this.GqV);
      EGL14.eglDestroyContext(this.fZZ, this.GqW);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.fZZ);
    }
    this.fZZ = EGL14.EGL_NO_DISPLAY;
    this.GqW = EGL14.EGL_NO_CONTEXT;
    this.GqV = EGL14.EGL_NO_SURFACE;
    AppMethodBeat.o(185117);
  }
  
  static final class a
  {
    static r GqX;
    
    static
    {
      AppMethodBeat.i(157556);
      GqX = new r((byte)0);
      AppMethodBeat.o(157556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.r
 * JD-Core Version:    0.7.0.1
 */