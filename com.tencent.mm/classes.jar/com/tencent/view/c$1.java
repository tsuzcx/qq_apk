package com.tencent.view;

import javax.microedition.khronos.egl.EGL10;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    c.a(this.xdj, new a());
    a locala = c.a(this.xdj);
    if (locala.mEGLConfig != null) {
      locala.mEGL.eglMakeCurrent(locala.mEGLDisplay, locala.mEGLSurface, locala.mEGLSurface, locala.mEGLContext);
    }
    this.xdj.xdi = Thread.currentThread().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.view.c.1
 * JD-Core Version:    0.7.0.1
 */