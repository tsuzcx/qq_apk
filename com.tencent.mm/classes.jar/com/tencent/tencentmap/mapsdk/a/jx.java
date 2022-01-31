package com.tencent.tencentmap.mapsdk.a;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class jx
  extends Thread
{
  private EGLContext a;
  private EGL10 b;
  private EGLConfig c;
  private EGLDisplay d;
  private jh e;
  private boolean f = false;
  private boolean g = false;
  private boolean h;
  private byte[] i = null;
  
  public jx(EGL10 paramEGL10, EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, jh paramjh, boolean paramBoolean)
  {
    this.b = paramEGL10;
    this.d = paramEGLDisplay;
    this.c = paramEGLConfig;
    this.e = paramjh;
    this.h = paramBoolean;
    if (paramBoolean) {
      this.a = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, new int[] { 12440, 2, 12344 });
    }
  }
  
  private boolean d()
  {
    if (this.e != null) {
      return this.e.j();
    }
    return false;
  }
  
  public void a()
  {
    this.g = true;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.i = paramArrayOfByte;
    this.f = true;
    interrupt();
  }
  
  public void b()
  {
    this.g = false;
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  public void c()
  {
    if (this.h) {
      this.b.eglDestroyContext(this.d, this.a);
    }
  }
  
  public void run()
  {
    if (this.h)
    {
      EGLSurface localEGLSurface = this.b.eglCreatePbufferSurface(this.d, this.c, new int[] { 12375, 1, 12374, 1, 12417, 12380, 12416, 12380, 12344 });
      this.b.eglMakeCurrent(this.d, localEGLSurface, localEGLSurface, this.a);
    }
    for (;;)
    {
      if (!this.f)
      {
        if (!this.g)
        {
          if (d()) {
            continue;
          }
          try
          {
            sleep(160L);
          }
          catch (InterruptedException localInterruptedException1) {}
          continue;
        }
        try
        {
          try
          {
            wait();
          }
          finally {}
        }
        catch (InterruptedException localInterruptedException2) {}
      }
    }
    c();
    if (this.i != null) {
      synchronized (this.i)
      {
        this.i.notify();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jx
 * JD-Core Version:    0.7.0.1
 */