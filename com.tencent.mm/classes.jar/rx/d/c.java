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
  static volatile e<d.a, d.a> OaP;
  static volatile e<h.a, h.a> OaQ;
  static volatile e<b.a, b.a> OaR;
  static volatile f<rx.d, d.a, d.a> OaS;
  static volatile f<h, d.a, d.a> OaT;
  static volatile f<rx.b, b.a, b.a> OaU;
  static volatile e<g, g> OaV;
  static volatile e<g, g> OaW;
  static volatile e<g, g> OaX;
  static volatile e<a, a> OaY;
  static volatile e<j, j> OaZ;
  static volatile rx.b.b<Throwable> Oac;
  static volatile e<j, j> Oba;
  static volatile rx.b.d<? extends ScheduledExecutorService> Obb;
  static volatile e<Throwable, Throwable> Obc;
  static volatile e<Throwable, Throwable> Obd;
  static volatile e<Throwable, Throwable> Obe;
  static volatile e<d.b, d.b> Obf;
  static volatile e<d.b, d.b> Obg;
  static volatile e<b.b, b.b> Obh;
  
  static
  {
    AppMethodBeat.i(90486);
    Oac = new rx.b.b() {};
    OaS = new f() {};
    OaZ = new e() {};
    OaT = new f() {};
    Oba = new e() {};
    OaU = new f() {};
    OaY = new e() {};
    Obc = new e() {};
    Obf = new e() {};
    Obd = new e() {};
    Obg = new e() {};
    Obe = new e() {};
    Obh = new e() {};
    OaP = new e() {};
    OaQ = new e() {};
    OaR = new e() {};
    AppMethodBeat.o(90486);
  }
  
  private static void R(Throwable paramThrowable)
  {
    AppMethodBeat.i(90473);
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
    AppMethodBeat.o(90473);
  }
  
  public static Throwable S(Throwable paramThrowable)
  {
    AppMethodBeat.i(90482);
    e locale = Obc;
    if (locale != null)
    {
      paramThrowable = (Throwable)locale.call(paramThrowable);
      AppMethodBeat.o(90482);
      return paramThrowable;
    }
    AppMethodBeat.o(90482);
    return paramThrowable;
  }
  
  public static Throwable T(Throwable paramThrowable)
  {
    AppMethodBeat.i(90485);
    e locale = Obe;
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
    f localf = OaU;
    if (localf != null)
    {
      paramb = (b.a)localf.Z(paramb, parama);
      AppMethodBeat.o(90484);
      return paramb;
    }
    AppMethodBeat.o(90484);
    return parama;
  }
  
  public static <T> d.a<T> a(rx.d<T> paramd, d.a<T> parama)
  {
    AppMethodBeat.i(90480);
    f localf = OaS;
    if (localf != null)
    {
      paramd = (d.a)localf.Z(paramd, parama);
      AppMethodBeat.o(90480);
      return paramd;
    }
    AppMethodBeat.o(90480);
    return parama;
  }
  
  public static b.a b(b.a parama)
  {
    AppMethodBeat.i(90475);
    e locale = OaR;
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
    e locale = OaY;
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
    e locale = OaP;
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
    e locale = Obf;
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
    e locale = OaV;
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
    e locale = OaZ;
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
    e locale = OaW;
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
    e locale = OaX;
    if (locale != null)
    {
      paramg = (g)locale.call(paramg);
      AppMethodBeat.o(90478);
      return paramg;
    }
    AppMethodBeat.o(90478);
    return paramg;
  }
  
  public static rx.b.d<? extends ScheduledExecutorService> gzk()
  {
    return Obb;
  }
  
  public static void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90472);
    rx.b.b localb = Oac;
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
        R(localThrowable);
      }
    }
    R(paramThrowable);
    AppMethodBeat.o(90472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.d.c
 * JD-Core Version:    0.7.0.1
 */