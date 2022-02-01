package com.tencent.threadpool.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.i.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class e<P>
{
  static g ahBo;
  static g ahBp;
  static g ahBq;
  private static final a ahBr;
  P ahBs;
  g ahBt;
  volatile a ahBu;
  a<Throwable, ?> ahBv;
  volatile e ahBw;
  volatile e ahBx;
  private volatile boolean ahBy;
  private final Object lock;
  AtomicBoolean vSL;
  
  static
  {
    AppMethodBeat.i(183301);
    ahBo = new c();
    ahBp = new b();
    ahBq = new i();
    ahBr = new a();
    AppMethodBeat.o(183301);
  }
  
  e()
  {
    AppMethodBeat.i(183293);
    this.lock = new Object();
    this.ahBy = false;
    this.vSL = new AtomicBoolean(false);
    AppMethodBeat.o(183293);
  }
  
  e(P paramP)
  {
    AppMethodBeat.i(183294);
    this.lock = new Object();
    this.ahBy = false;
    this.vSL = new AtomicBoolean(false);
    this.ahBs = paramP;
    AppMethodBeat.o(183294);
  }
  
  public static <T> e<T> hh(T paramT)
  {
    AppMethodBeat.i(183290);
    paramT = new e(paramT);
    AppMethodBeat.o(183290);
    return paramT;
  }
  
  public static e<a> jZg()
  {
    AppMethodBeat.i(183291);
    e locale = new e(ahBr);
    AppMethodBeat.o(183291);
    return locale;
  }
  
  public static f<a> jZh()
  {
    AppMethodBeat.i(183292);
    f localf = new f(ahBr);
    AppMethodBeat.o(183292);
    return localf;
  }
  
  private void jZj()
  {
    AppMethodBeat.i(183297);
    if (this.ahBy) {
      synchronized (this.lock)
      {
        if (this.ahBy) {
          this.lock.notifyAll();
        }
        AppMethodBeat.o(183297);
        return;
      }
    }
    AppMethodBeat.o(183297);
  }
  
  public <R> e<R> a(a<P, R> parama)
  {
    AppMethodBeat.i(183295);
    Objects.requireNonNull(parama);
    e locale = new e();
    locale.ahBt = jZm();
    locale.ahBw = null;
    this.ahBx = locale;
    this.ahBu = parama;
    this.vSL.compareAndSet(false, true);
    b(parama);
    AppMethodBeat.o(183295);
    return locale;
  }
  
  final void b(final a parama)
  {
    AppMethodBeat.i(183296);
    if (parama == null)
    {
      jZj();
      AppMethodBeat.o(183296);
      return;
    }
    parama = new h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(183288);
        String str = parama.toString();
        AppMethodBeat.o(183288);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(183289);
        try
        {
          e.this.ahBx.ahBs = parama.input(e.this.ahBs);
          e.this.ahBx.b(e.this.ahBx.ahBu);
          e.a(e.this);
          e.this.ahBx = null;
          e.this.ahBw = null;
          e.this.ahBu = null;
          e.this.ahBv = null;
          AppMethodBeat.o(183289);
          return;
        }
        finally
        {
          try
          {
            a locala = e.this.jZi();
            if (locala != null) {
              break label167;
            }
            AppMethodBeat.o(183289);
            throw localObject2;
          }
          finally
          {
            if (localObject2 != null) {
              break label245;
            }
          }
          e.a(e.this);
        }
        for (;;)
        {
          e.this.ahBx = null;
          e.this.ahBw = null;
          e.this.ahBu = null;
          e.this.ahBv = null;
          AppMethodBeat.o(183289);
          throw localObject1;
          label167:
          Object localObject3 = localObject1.input(localObject2);
          for (e locale = e.this; locale.ahBx != null; locale = locale.ahBx) {}
          locale.ahBs = localObject3;
          e.b(e.this);
          e.this.ahBx = null;
          e.this.ahBw = null;
          e.this.ahBu = null;
          e.this.ahBv = null;
          AppMethodBeat.o(183289);
          return;
          label245:
          e.b(e.this);
        }
      }
    };
    if (this.ahBs != null)
    {
      if (this.ahBt == null)
      {
        parama.run();
        AppMethodBeat.o(183296);
        return;
      }
      this.ahBt.execute(parama);
    }
    AppMethodBeat.o(183296);
  }
  
  a<Throwable, ?> jZi()
  {
    return null;
  }
  
  public P jZk()
  {
    AppMethodBeat.i(183298);
    for (;;)
    {
      try
      {
        if (this.ahBs != null) {}
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
      }
      synchronized (this.lock)
      {
        if (this.ahBs == null)
        {
          this.ahBy = true;
          this.lock.wait();
          this.ahBy = false;
        }
        ??? = this.ahBs;
        AppMethodBeat.o(183298);
        return ???;
      }
    }
  }
  
  public e<P> jZl()
  {
    this.ahBt = ahBq;
    return this;
  }
  
  public g jZm()
  {
    return this.ahBt;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.e.e
 * JD-Core Version:    0.7.0.1
 */