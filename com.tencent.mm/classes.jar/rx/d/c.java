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
  static volatile e<d.a, d.a> OxU;
  static volatile e<h.a, h.a> OxV;
  static volatile e<b.a, b.a> OxW;
  static volatile f<rx.d, d.a, d.a> OxX;
  static volatile f<h, d.a, d.a> OxY;
  static volatile f<rx.b, b.a, b.a> OxZ;
  static volatile rx.b.b<Throwable> Oxh;
  static volatile e<g, g> Oya;
  static volatile e<g, g> Oyb;
  static volatile e<g, g> Oyc;
  static volatile e<a, a> Oyd;
  static volatile e<j, j> Oye;
  static volatile e<j, j> Oyf;
  static volatile rx.b.d<? extends ScheduledExecutorService> Oyg;
  static volatile e<Throwable, Throwable> Oyh;
  static volatile e<Throwable, Throwable> Oyi;
  static volatile e<Throwable, Throwable> Oyj;
  static volatile e<d.b, d.b> Oyk;
  static volatile e<d.b, d.b> Oyl;
  static volatile e<b.b, b.b> Oym;
  
  static
  {
    AppMethodBeat.i(90486);
    Oxh = new rx.b.b() {};
    OxX = new f() {};
    Oye = new e() {};
    OxY = new f() {};
    Oyf = new e() {};
    OxZ = new f() {};
    Oyd = new e() {};
    Oyh = new e() {};
    Oyk = new e() {};
    Oyi = new e() {};
    Oyl = new e() {};
    Oyj = new e() {};
    Oym = new e() {};
    OxU = new e() {};
    OxV = new e() {};
    OxW = new e() {};
    AppMethodBeat.o(90486);
  }
  
  private static void S(Throwable paramThrowable)
  {
    AppMethodBeat.i(90473);
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
    AppMethodBeat.o(90473);
  }
  
  public static Throwable T(Throwable paramThrowable)
  {
    AppMethodBeat.i(90482);
    e locale = Oyh;
    if (locale != null)
    {
      paramThrowable = (Throwable)locale.call(paramThrowable);
      AppMethodBeat.o(90482);
      return paramThrowable;
    }
    AppMethodBeat.o(90482);
    return paramThrowable;
  }
  
  public static Throwable U(Throwable paramThrowable)
  {
    AppMethodBeat.i(90485);
    e locale = Oyj;
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
    f localf = OxZ;
    if (localf != null)
    {
      paramb = (b.a)localf.Y(paramb, parama);
      AppMethodBeat.o(90484);
      return paramb;
    }
    AppMethodBeat.o(90484);
    return parama;
  }
  
  public static <T> d.a<T> a(rx.d<T> paramd, d.a<T> parama)
  {
    AppMethodBeat.i(90480);
    f localf = OxX;
    if (localf != null)
    {
      paramd = (d.a)localf.Y(paramd, parama);
      AppMethodBeat.o(90480);
      return paramd;
    }
    AppMethodBeat.o(90480);
    return parama;
  }
  
  public static b.a b(b.a parama)
  {
    AppMethodBeat.i(90475);
    e locale = OxW;
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
    e locale = Oyd;
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
    e locale = OxU;
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
    e locale = Oyk;
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
    e locale = Oya;
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
    e locale = Oye;
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
    e locale = Oyb;
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
    e locale = Oyc;
    if (locale != null)
    {
      paramg = (g)locale.call(paramg);
      AppMethodBeat.o(90478);
      return paramg;
    }
    AppMethodBeat.o(90478);
    return paramg;
  }
  
  public static rx.b.d<? extends ScheduledExecutorService> gDM()
  {
    return Oyg;
  }
  
  public static void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90472);
    rx.b.b localb = Oxh;
    if (localb != null) {
      try
      {
        localb.cr(paramThrowable);
        AppMethodBeat.o(90472);
        return;
      }
      catch (Throwable localThrowable)
      {
        System.err.println("The onError handler threw an Exception. It shouldn't. => " + localThrowable.getMessage());
        S(localThrowable);
      }
    }
    S(paramThrowable);
    AppMethodBeat.o(90472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.d.c
 * JD-Core Version:    0.7.0.1
 */