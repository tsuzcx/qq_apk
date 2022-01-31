package com.tencent.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(86631);
    c.a(this.BzR, new a());
    a locala = c.a(this.BzR);
    if (locala.mEGLConfig != null) {
      locala.mEGL.eglMakeCurrent(locala.mEGLDisplay, locala.mEGLSurface, locala.mEGLSurface, locala.mEGLContext);
    }
    this.BzR.BzQ = Thread.currentThread().getName();
    AppMethodBeat.o(86631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.view.c.1
 * JD-Core Version:    0.7.0.1
 */