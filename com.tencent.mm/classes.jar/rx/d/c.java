package rx.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
import rx.b.a;
import rx.b.b;
import rx.b.a;
import rx.b.e;
import rx.b.f;
import rx.d.a;
import rx.d.b;
import rx.g;
import rx.h;
import rx.h.a;
import rx.j;

public final class c
{
  static volatile e<d.a, d.a> abQW;
  static volatile e<h.a, h.a> abQX;
  static volatile e<b.a, b.a> abQY;
  static volatile f<rx.d, d.a, d.a> abQZ;
  static volatile rx.b.b<Throwable> abQr;
  static volatile f<h, d.a, d.a> abRa;
  static volatile f<rx.b, b.a, b.a> abRb;
  static volatile e<g, g> abRc;
  static volatile e<g, g> abRd;
  static volatile e<g, g> abRe;
  static volatile e<a, a> abRf;
  static volatile e<j, j> abRg;
  static volatile e<j, j> abRh;
  static volatile rx.b.d<? extends ScheduledExecutorService> abRi;
  static volatile e<Throwable, Throwable> abRj;
  static volatile e<Throwable, Throwable> abRk;
  static volatile e<Throwable, Throwable> abRl;
  static volatile e<d.b, d.b> abRm;
  static volatile e<d.b, d.b> abRn;
  static volatile e<b.b, b.b> abRo;
  
  static
  {
    AppMethodBeat.i(90486);
    abQr = new rx.b.b() {};
    abQZ = new f() {};
    abRg = new e() {};
    abRa = new f() {};
    abRh = new e() {};
    abRb = new f() {};
    abRf = new e() {};
    abRj = new e() {};
    abRm = new e() {};
    abRk = new e() {};
    abRn = new e() {};
    abRl = new e() {};
    abRo = new e() {};
    abQW = new e() {};
    abQX = new e() {};
    abQY = new e() {};
    AppMethodBeat.o(90486);
  }
  
  private static void Y(Throwable paramThrowable)
  {
    AppMethodBeat.i(90473);
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
    AppMethodBeat.o(90473);
  }
  
  public static Throwable Z(Throwable paramThrowable)
  {
    AppMethodBeat.i(90482);
    e locale = abRj;
    if (locale != null)
    {
      paramThrowable = (Throwable)locale.call(paramThrowable);
      AppMethodBeat.o(90482);
      return paramThrowable;
    }
    AppMethodBeat.o(90482);
    return paramThrowable;
  }
  
  public static <T> b.a a(rx.b paramb, b.a parama)
  {
    AppMethodBeat.i(90484);
    f localf = abRb;
    if (localf != null)
    {
      paramb = (b.a)localf.U(paramb, parama);
      AppMethodBeat.o(90484);
      return paramb;
    }
    AppMethodBeat.o(90484);
    return parama;
  }
  
  public static <T> d.a<T> a(rx.d<T> paramd, d.a<T> parama)
  {
    AppMethodBeat.i(90480);
    f localf = abQZ;
    if (localf != null)
    {
      paramd = (d.a)localf.U(paramd, parama);
      AppMethodBeat.o(90480);
      return paramd;
    }
    AppMethodBeat.o(90480);
    return parama;
  }
  
  public static Throwable aa(Throwable paramThrowable)
  {
    AppMethodBeat.i(90485);
    e locale = abRl;
    if (locale != null)
    {
      paramThrowable = (Throwable)locale.call(paramThrowable);
      AppMethodBeat.o(90485);
      return paramThrowable;
    }
    AppMethodBeat.o(90485);
    return paramThrowable;
  }
  
  public static b.a b(b.a parama)
  {
    AppMethodBeat.i(90475);
    e locale = abQY;
    if (locale != null)
    {
      parama = (b.a)locale.call(parama);
      AppMethodBeat.o(90475);
      return parama;
    }
    AppMethodBeat.o(90475);
    return parama;
  }
  
  public static a b(a parama)
  {
    AppMethodBeat.i(90479);
    e locale = abRf;
    if (locale != null)
    {
      parama = (a)locale.call(parama);
      AppMethodBeat.o(90479);
      return parama;
    }
    AppMethodBeat.o(90479);
    return parama;
  }
  
  public static <T> d.a<T> b(d.a<T> parama)
  {
    AppMethodBeat.i(90474);
    e locale = abQW;
    if (locale != null)
    {
      parama = (d.a)locale.call(parama);
      AppMethodBeat.o(90474);
      return parama;
    }
    AppMethodBeat.o(90474);
    return parama;
  }
  
  public static <T, R> d.b<R, T> b(d.b<R, T> paramb)
  {
    AppMethodBeat.i(90483);
    e locale = abRm;
    if (locale != null)
    {
      paramb = (d.b)locale.call(paramb);
      AppMethodBeat.o(90483);
      return paramb;
    }
    AppMethodBeat.o(90483);
    return paramb;
  }
  
  public static g b(g paramg)
  {
    AppMethodBeat.i(90476);
    e locale = abRc;
    if (locale != null)
    {
      paramg = (g)locale.call(paramg);
      AppMethodBeat.o(90476);
      return paramg;
    }
    AppMethodBeat.o(90476);
    return paramg;
  }
  
  public static g c(g paramg)
  {
    AppMethodBeat.i(90477);
    e locale = abRd;
    if (locale != null)
    {
      paramg = (g)locale.call(paramg);
      AppMethodBeat.o(90477);
      return paramg;
    }
    AppMethodBeat.o(90477);
    return paramg;
  }
  
  public static j c(j paramj)
  {
    AppMethodBeat.i(90481);
    e locale = abRg;
    if (locale != null)
    {
      paramj = (j)locale.call(paramj);
      AppMethodBeat.o(90481);
      return paramj;
    }
    AppMethodBeat.o(90481);
    return paramj;
  }
  
  public static void c(Throwable paramThrowable)
  {
    AppMethodBeat.i(90472);
    rx.b.b localb = abQr;
    if (localb != null) {
      try
      {
        localb.cA(paramThrowable);
        AppMethodBeat.o(90472);
        return;
      }
      catch (Throwable localThrowable)
      {
        System.err.println("The onError handler threw an Exception. It shouldn't. => " + localThrowable.getMessage());
        Y(localThrowable);
      }
    }
    Y(paramThrowable);
    AppMethodBeat.o(90472);
  }
  
  public static g d(g paramg)
  {
    AppMethodBeat.i(90478);
    e locale = abRe;
    if (locale != null)
    {
      paramg = (g)locale.call(paramg);
      AppMethodBeat.o(90478);
      return paramg;
    }
    AppMethodBeat.o(90478);
    return paramg;
  }
  
  public static rx.b.d<? extends ScheduledExecutorService> iWe()
  {
    return abRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.d.c
 * JD-Core Version:    0.7.0.1
 */