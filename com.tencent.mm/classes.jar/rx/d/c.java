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
  static volatile rx.b.b<Throwable> Krr;
  static volatile e<d.a, d.a> Kse;
  static volatile e<h.a, h.a> Ksf;
  static volatile e<b.a, b.a> Ksg;
  static volatile f<rx.d, d.a, d.a> Ksh;
  static volatile f<h, d.a, d.a> Ksi;
  static volatile f<rx.b, b.a, b.a> Ksj;
  static volatile e<g, g> Ksk;
  static volatile e<g, g> Ksl;
  static volatile e<g, g> Ksm;
  static volatile e<a, a> Ksn;
  static volatile e<j, j> Kso;
  static volatile e<j, j> Ksp;
  static volatile rx.b.d<? extends ScheduledExecutorService> Ksq;
  static volatile e<Throwable, Throwable> Ksr;
  static volatile e<Throwable, Throwable> Kss;
  static volatile e<Throwable, Throwable> Kst;
  static volatile e<d.b, d.b> Ksu;
  static volatile e<d.b, d.b> Ksv;
  static volatile e<b.b, b.b> Ksw;
  
  static
  {
    AppMethodBeat.i(90486);
    Krr = new rx.b.b() {};
    Ksh = new f() {};
    Kso = new e() {};
    Ksi = new f() {};
    Ksp = new e() {};
    Ksj = new f() {};
    Ksn = new e() {};
    Ksr = new e() {};
    Ksu = new e() {};
    Kss = new e() {};
    Ksv = new e() {};
    Kst = new e() {};
    Ksw = new e() {};
    Kse = new e() {};
    Ksf = new e() {};
    Ksg = new e() {};
    AppMethodBeat.o(90486);
  }
  
  private static void P(Throwable paramThrowable)
  {
    AppMethodBeat.i(90473);
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
    AppMethodBeat.o(90473);
  }
  
  public static Throwable Q(Throwable paramThrowable)
  {
    AppMethodBeat.i(90482);
    e locale = Ksr;
    if (locale != null)
    {
      paramThrowable = (Throwable)locale.call(paramThrowable);
      AppMethodBeat.o(90482);
      return paramThrowable;
    }
    AppMethodBeat.o(90482);
    return paramThrowable;
  }
  
  public static Throwable R(Throwable paramThrowable)
  {
    AppMethodBeat.i(90485);
    e locale = Kst;
    if (locale != null)
    {
      paramThrowable = (Throwable)locale.call(paramThrowable);
      AppMethodBeat.o(90485);
      return paramThrowable;
    }
    AppMethodBeat.o(90485);
    return paramThrowable;
  }
  
  public static <T> b.a a(rx.b paramb, b.a parama)
  {
    AppMethodBeat.i(90484);
    f localf = Ksj;
    if (localf != null)
    {
      paramb = (b.a)localf.V(paramb, parama);
      AppMethodBeat.o(90484);
      return paramb;
    }
    AppMethodBeat.o(90484);
    return parama;
  }
  
  public static <T> d.a<T> a(rx.d<T> paramd, d.a<T> parama)
  {
    AppMethodBeat.i(90480);
    f localf = Ksh;
    if (localf != null)
    {
      paramd = (d.a)localf.V(paramd, parama);
      AppMethodBeat.o(90480);
      return paramd;
    }
    AppMethodBeat.o(90480);
    return parama;
  }
  
  public static b.a b(b.a parama)
  {
    AppMethodBeat.i(90475);
    e locale = Ksg;
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
    e locale = Ksn;
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
    e locale = Kse;
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
    e locale = Ksu;
    if (locale != null)
    {
      paramb = (d.b)locale.call(paramb);
      AppMethodBeat.o(90483);
      return paramb;
    }
    AppMethodBeat.o(90483);
    return paramb;
  }
  
  public static g c(g paramg)
  {
    AppMethodBeat.i(90476);
    e locale = Ksk;
    if (locale != null)
    {
      paramg = (g)locale.call(paramg);
      AppMethodBeat.o(90476);
      return paramg;
    }
    AppMethodBeat.o(90476);
    return paramg;
  }
  
  public static j c(j paramj)
  {
    AppMethodBeat.i(90481);
    e locale = Kso;
    if (locale != null)
    {
      paramj = (j)locale.call(paramj);
      AppMethodBeat.o(90481);
      return paramj;
    }
    AppMethodBeat.o(90481);
    return paramj;
  }
  
  public static g d(g paramg)
  {
    AppMethodBeat.i(90477);
    e locale = Ksl;
    if (locale != null)
    {
      paramg = (g)locale.call(paramg);
      AppMethodBeat.o(90477);
      return paramg;
    }
    AppMethodBeat.o(90477);
    return paramg;
  }
  
  public static g e(g paramg)
  {
    AppMethodBeat.i(90478);
    e locale = Ksm;
    if (locale != null)
    {
      paramg = (g)locale.call(paramg);
      AppMethodBeat.o(90478);
      return paramg;
    }
    AppMethodBeat.o(90478);
    return paramg;
  }
  
  public static rx.b.d<? extends ScheduledExecutorService> fNQ()
  {
    return Ksq;
  }
  
  public static void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90472);
    rx.b.b localb = Krr;
    if (localb != null) {
      try
      {
        localb.cq(paramThrowable);
        AppMethodBeat.o(90472);
        return;
      }
      catch (Throwable localThrowable)
      {
        System.err.println("The onError handler threw an Exception. It shouldn't. => " + localThrowable.getMessage());
        P(localThrowable);
      }
    }
    P(paramThrowable);
    AppMethodBeat.o(90472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.d.c
 * JD-Core Version:    0.7.0.1
 */