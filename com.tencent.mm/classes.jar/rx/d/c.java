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
  static volatile e<d.a, d.a> akdO;
  static volatile e<h.a, h.a> akdP;
  static volatile e<b.a, b.a> akdQ;
  static volatile f<rx.d, d.a, d.a> akdR;
  static volatile f<h, d.a, d.a> akdS;
  static volatile f<rx.b, b.a, b.a> akdT;
  static volatile e<g, g> akdU;
  static volatile e<g, g> akdV;
  static volatile e<g, g> akdW;
  static volatile e<a, a> akdX;
  static volatile e<j, j> akdY;
  static volatile e<j, j> akdZ;
  static volatile rx.b.b<Throwable> akdj;
  static volatile rx.b.d<? extends ScheduledExecutorService> akea;
  static volatile e<Throwable, Throwable> akeb;
  static volatile e<Throwable, Throwable> akec;
  static volatile e<Throwable, Throwable> aked;
  static volatile e<d.b, d.b> akee;
  static volatile e<d.b, d.b> akef;
  static volatile e<b.b, b.b> akeg;
  
  static
  {
    AppMethodBeat.i(90486);
    akdj = new rx.b.b() {};
    akdR = new f() {};
    akdY = new e() {};
    akdS = new f() {};
    akdZ = new e() {};
    akdT = new f() {};
    akdX = new e() {};
    akeb = new e() {};
    akee = new e() {};
    akec = new e() {};
    akef = new e() {};
    aked = new e() {};
    akeg = new e() {};
    akdO = new e() {};
    akdP = new e() {};
    akdQ = new e() {};
    AppMethodBeat.o(90486);
  }
  
  public static <T> b.a a(rx.b paramb, b.a parama)
  {
    AppMethodBeat.i(90484);
    f localf = akdT;
    if (localf != null)
    {
      paramb = (b.a)localf.ai(paramb, parama);
      AppMethodBeat.o(90484);
      return paramb;
    }
    AppMethodBeat.o(90484);
    return parama;
  }
  
  public static <T> d.a<T> a(rx.d<T> paramd, d.a<T> parama)
  {
    AppMethodBeat.i(90480);
    f localf = akdR;
    if (localf != null)
    {
      paramd = (d.a)localf.ai(paramd, parama);
      AppMethodBeat.o(90480);
      return paramd;
    }
    AppMethodBeat.o(90480);
    return parama;
  }
  
  private static void ap(Throwable paramThrowable)
  {
    AppMethodBeat.i(90473);
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
    AppMethodBeat.o(90473);
  }
  
  public static Throwable aq(Throwable paramThrowable)
  {
    AppMethodBeat.i(90482);
    e locale = akeb;
    if (locale != null)
    {
      paramThrowable = (Throwable)locale.call(paramThrowable);
      AppMethodBeat.o(90482);
      return paramThrowable;
    }
    AppMethodBeat.o(90482);
    return paramThrowable;
  }
  
  public static Throwable ar(Throwable paramThrowable)
  {
    AppMethodBeat.i(90485);
    e locale = aked;
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
    e locale = akdQ;
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
    e locale = akdX;
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
    e locale = akdO;
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
    e locale = akee;
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
    e locale = akdU;
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
    e locale = akdV;
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
    e locale = akdY;
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
    AppMethodBeat.i(90478);
    e locale = akdW;
    if (locale != null)
    {
      paramg = (g)locale.call(paramg);
      AppMethodBeat.o(90478);
      return paramg;
    }
    AppMethodBeat.o(90478);
    return paramg;
  }
  
  public static rx.b.d<? extends ScheduledExecutorService> kKC()
  {
    return akea;
  }
  
  public static void l(Throwable paramThrowable)
  {
    AppMethodBeat.i(90472);
    rx.b.b localb = akdj;
    if (localb != null) {
      try
      {
        localb.call(paramThrowable);
        AppMethodBeat.o(90472);
        return;
      }
      finally
      {
        System.err.println("The onError handler threw an Exception. It shouldn't. => " + localThrowable.getMessage());
        ap(localThrowable);
      }
    }
    ap(paramThrowable);
    AppMethodBeat.o(90472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.d.c
 * JD-Core Version:    0.7.0.1
 */