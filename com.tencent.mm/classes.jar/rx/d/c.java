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
  static volatile rx.b.b<Throwable> UmV;
  static volatile e<d.a, d.a> UnI;
  static volatile e<h.a, h.a> UnJ;
  static volatile e<b.a, b.a> UnK;
  static volatile f<rx.d, d.a, d.a> UnL;
  static volatile f<h, d.a, d.a> UnM;
  static volatile f<rx.b, b.a, b.a> UnN;
  static volatile e<g, g> UnO;
  static volatile e<g, g> UnP;
  static volatile e<g, g> UnQ;
  static volatile e<a, a> UnR;
  static volatile e<j, j> UnS;
  static volatile e<j, j> UnT;
  static volatile rx.b.d<? extends ScheduledExecutorService> UnU;
  static volatile e<Throwable, Throwable> UnV;
  static volatile e<Throwable, Throwable> UnW;
  static volatile e<Throwable, Throwable> UnX;
  static volatile e<d.b, d.b> UnY;
  static volatile e<d.b, d.b> UnZ;
  static volatile e<b.b, b.b> Uoa;
  
  static
  {
    AppMethodBeat.i(90486);
    UmV = new rx.b.b() {};
    UnL = new f() {};
    UnS = new e() {};
    UnM = new f() {};
    UnT = new e() {};
    UnN = new f() {};
    UnR = new e() {};
    UnV = new e() {};
    UnY = new e() {};
    UnW = new e() {};
    UnZ = new e() {};
    UnX = new e() {};
    Uoa = new e() {};
    UnI = new e() {};
    UnJ = new e() {};
    UnK = new e() {};
    AppMethodBeat.o(90486);
  }
  
  private static void U(Throwable paramThrowable)
  {
    AppMethodBeat.i(90473);
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
    AppMethodBeat.o(90473);
  }
  
  public static Throwable V(Throwable paramThrowable)
  {
    AppMethodBeat.i(90482);
    e locale = UnV;
    if (locale != null)
    {
      paramThrowable = (Throwable)locale.call(paramThrowable);
      AppMethodBeat.o(90482);
      return paramThrowable;
    }
    AppMethodBeat.o(90482);
    return paramThrowable;
  }
  
  public static Throwable W(Throwable paramThrowable)
  {
    AppMethodBeat.i(90485);
    e locale = UnX;
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
    f localf = UnN;
    if (localf != null)
    {
      paramb = (b.a)localf.ab(paramb, parama);
      AppMethodBeat.o(90484);
      return paramb;
    }
    AppMethodBeat.o(90484);
    return parama;
  }
  
  public static <T> d.a<T> a(rx.d<T> paramd, d.a<T> parama)
  {
    AppMethodBeat.i(90480);
    f localf = UnL;
    if (localf != null)
    {
      paramd = (d.a)localf.ab(paramd, parama);
      AppMethodBeat.o(90480);
      return paramd;
    }
    AppMethodBeat.o(90480);
    return parama;
  }
  
  public static b.a b(b.a parama)
  {
    AppMethodBeat.i(90475);
    e locale = UnK;
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
    e locale = UnR;
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
    e locale = UnI;
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
    e locale = UnY;
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
    e locale = UnO;
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
    e locale = UnS;
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
    e locale = UnP;
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
    e locale = UnQ;
    if (locale != null)
    {
      paramg = (g)locale.call(paramg);
      AppMethodBeat.o(90478);
      return paramg;
    }
    AppMethodBeat.o(90478);
    return paramg;
  }
  
  public static rx.b.d<? extends ScheduledExecutorService> hQU()
  {
    return UnU;
  }
  
  public static void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90472);
    rx.b.b localb = UmV;
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
        U(localThrowable);
      }
    }
    U(paramThrowable);
    AppMethodBeat.o(90472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.d.c
 * JD-Core Version:    0.7.0.1
 */