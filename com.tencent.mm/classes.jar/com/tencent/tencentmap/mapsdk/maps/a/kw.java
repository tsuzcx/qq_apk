package com.tencent.tencentmap.mapsdk.maps.a;

import android.annotation.TargetApi;
import android.opengl.GLUtils;
import android.util.Log;
import com.tencent.map.lib.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class kw
  extends Thread
{
  private static int d = 60;
  private static long p = 1500L;
  private WeakReference<kx> a;
  private AtomicBoolean b;
  private AtomicBoolean c;
  private byte[] e;
  private WeakReference<Object> f;
  private volatile boolean g;
  private EGLConfig h;
  private EGL10 i;
  private EGLDisplay j;
  private EGLContext k;
  private EGLSurface l;
  private GL m;
  private volatile long n;
  private boolean o;
  
  public kw(Object paramObject, kx paramkx)
  {
    AppMethodBeat.i(149009);
    this.b = new AtomicBoolean(true);
    this.c = new AtomicBoolean(false);
    this.e = new byte[0];
    this.g = false;
    this.h = null;
    this.j = EGL10.EGL_NO_DISPLAY;
    this.k = EGL10.EGL_NO_CONTEXT;
    this.l = EGL10.EGL_NO_SURFACE;
    this.n = 0L;
    this.o = false;
    this.f = new WeakReference(paramObject);
    this.a = new WeakReference(paramkx);
    AppMethodBeat.o(149009);
  }
  
  @TargetApi(14)
  private void e()
  {
    AppMethodBeat.i(149014);
    while (this.b.get())
    {
      try
      {
        if (this.f != null)
        {
          localObject = this.f.get();
          if (localObject != null) {}
        }
        else
        {
          AppMethodBeat.o(149014);
          return;
        }
        Object localObject = this.f.get();
        this.i = ((EGL10)EGLContext.getEGL());
        this.j = this.i.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.j != EGL10.EGL_NO_DISPLAY) {
          break label133;
        }
        new StringBuilder("eglGetdisplay failed,mEglDisplay == EGL10.EGL_NO_DISPLAY,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
      }
      catch (Throwable localThrowable)
      {
        new StringBuilder("initializeGLContext failed,errorDetail:").append(Log.getStackTraceString(localThrowable));
      }
      continue;
      label133:
      int[] arrayOfInt = new int[2];
      if (!this.i.eglInitialize(this.j, arrayOfInt))
      {
        new StringBuilder("eglInitialize failed,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
      }
      else
      {
        arrayOfInt = new int[1];
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
        if (!this.i.eglChooseConfig(this.j, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12352, 4, 12344 }, arrayOfEGLConfig, 1, arrayOfInt))
        {
          new StringBuilder("eglChooseConfig failed,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
        }
        else
        {
          this.h = arrayOfEGLConfig[0];
          this.l = this.i.eglCreateWindowSurface(this.j, this.h, localThrowable, null);
          if (this.l == EGL10.EGL_NO_SURFACE)
          {
            new StringBuilder("eglCreateWindowSurface failed,mEglSurface == EGL10.EGL_NO_SURFACE,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
          }
          else
          {
            this.k = this.i.eglCreateContext(this.j, arrayOfEGLConfig[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            if (this.k == EGL10.EGL_NO_CONTEXT)
            {
              new StringBuilder("eglCreateContext failed,mEglContext == EGL10.EGL_NO_CONTEXT,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
            }
            else if (!this.i.eglMakeCurrent(this.j, this.l, this.l, this.k))
            {
              new StringBuilder("eglMakeCurrent failed,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
            }
            else
            {
              this.m = this.k.getGL();
              AppMethodBeat.o(149014);
              return;
            }
          }
        }
      }
    }
    AppMethodBeat.o(149014);
  }
  
  @TargetApi(14)
  private void f()
  {
    AppMethodBeat.i(149017);
    while (this.b.get())
    {
      try
      {
        if (this.f != null)
        {
          Object localObject = this.f.get();
          if (localObject != null) {}
        }
        else
        {
          AppMethodBeat.o(149017);
          return;
        }
        this.l = this.i.eglCreateWindowSurface(this.j, this.h, this.f.get(), null);
        if (this.l != EGL10.EGL_NO_SURFACE) {
          break label128;
        }
        new StringBuilder("eglCreateWindowSurface failed,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
      }
      catch (Throwable localThrowable)
      {
        new StringBuilder("updateSurface failed,errorDetail:").append(Log.getStackTraceString(localThrowable));
      }
      continue;
      label128:
      if (!this.i.eglMakeCurrent(this.j, this.l, this.l, this.k))
      {
        new StringBuilder("eglMakeCurrent failed,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
      }
      else
      {
        AppMethodBeat.o(149017);
        return;
      }
    }
    AppMethodBeat.o(149017);
  }
  
  private void g()
  {
    AppMethodBeat.i(149018);
    kx localkx;
    byte[] arrayOfByte;
    if ((this.a != null) && (this.a.get() != null))
    {
      localkx = (kx)this.a.get();
      arrayOfByte = new byte[1];
      localkx.a(arrayOfByte);
    }
    try
    {
      arrayOfByte.wait(1000L);
      localkx.d();
      h();
      AppMethodBeat.o(149018);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        d.b(Log.getStackTraceString(localInterruptedException));
        Thread.currentThread().interrupt();
      }
    }
    finally
    {
      AppMethodBeat.o(149018);
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(149019);
    if ((this.l != null) && (this.l != EGL10.EGL_NO_SURFACE))
    {
      EGL10 localEGL10 = this.i;
      EGLDisplay localEGLDisplay = this.j;
      EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
      localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
      this.i.eglDestroySurface(this.j, this.l);
    }
    if ((this.k != null) && (this.k != EGL10.EGL_NO_CONTEXT)) {
      this.i.eglDestroyContext(this.j, this.k);
    }
    if ((this.j != null) && (this.j != EGL10.EGL_NO_DISPLAY)) {
      this.i.eglTerminate(this.j);
    }
    this.k = EGL10.EGL_NO_CONTEXT;
    this.l = EGL10.EGL_NO_SURFACE;
    this.j = EGL10.EGL_NO_DISPLAY;
    this.a = null;
    AppMethodBeat.o(149019);
  }
  
  public void a()
  {
    AppMethodBeat.i(149011);
    this.c.set(true);
    synchronized (this.e)
    {
      this.e.notify();
      AppMethodBeat.o(149011);
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    AppMethodBeat.i(149015);
    this.f = new WeakReference(paramObject);
    this.g = true;
    AppMethodBeat.o(149015);
  }
  
  public void b()
  {
    AppMethodBeat.i(149012);
    this.c.set(false);
    synchronized (this.e)
    {
      this.e.notify();
      AppMethodBeat.o(149012);
      return;
    }
  }
  
  public void c()
  {
    AppMethodBeat.i(149013);
    this.b.set(false);
    this.c.set(false);
    synchronized (this.e)
    {
      this.e.notify();
      interrupt();
      AppMethodBeat.o(149013);
      return;
    }
  }
  
  public void d()
  {
    AppMethodBeat.i(149016);
    this.o = true;
    this.n = System.currentTimeMillis();
    AppMethodBeat.o(149016);
  }
  
  public void run()
  {
    AppMethodBeat.i(149010);
    super.run();
    e();
    while (this.b.get())
    {
      try
      {
        synchronized (this.e)
        {
          if (!this.c.get()) {
            break label101;
          }
          this.e.wait();
        }
        if (this.b.get()) {
          break label80;
        }
      }
      catch (Throwable localThrowable) {}
      if (!(localThrowable instanceof InterruptedException))
      {
        label80:
        new StringBuilder("TextureGLRenderThread Render Exception:").append(Log.getStackTraceString(localThrowable));
        continue;
        label101:
        if (this.g)
        {
          f();
          this.o = true;
          this.g = false;
          d();
        }
        if ((this.a != null) && (this.a.get() != null))
        {
          kx localkx = (kx)this.a.get();
          if ((this.o) && (System.currentTimeMillis() - this.n < p)) {
            if (localkx != null) {
              localkx.l();
            }
          }
          for (;;)
          {
            for (;;)
            {
              if ((localkx != null) && (localkx.a((GL10)this.m))) {
                this.i.eglSwapBuffers(this.j, this.l);
              }
              try
              {
                wait(1000 / d);
                break;
              }
              finally
              {
                AppMethodBeat.o(149010);
              }
            }
            this.o = false;
            this.n = 0L;
          }
        }
      }
    }
    g();
    AppMethodBeat.o(149010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kw
 * JD-Core Version:    0.7.0.1
 */