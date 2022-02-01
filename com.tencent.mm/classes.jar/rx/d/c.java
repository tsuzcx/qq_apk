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
  static volatile e<d.a, d.a> MfN;
  static volatile e<h.a, h.a> MfO;
  static volatile e<b.a, b.a> MfP;
  static volatile f<rx.d, d.a, d.a> MfQ;
  static volatile f<h, d.a, d.a> MfR;
  static volatile f<rx.b, b.a, b.a> MfS;
  static volatile e<g, g> MfT;
  static volatile e<g, g> MfU;
  static volatile e<g, g> MfV;
  static volatile e<a, a> MfW;
  static volatile e<j, j> MfX;
  static volatile e<j, j> MfY;
  static volatile rx.b.d<? extends ScheduledExecutorService> MfZ;
  static volatile rx.b.b<Throwable> Mfa;
  static volatile e<Throwable, Throwable> Mga;
  static volatile e<Throwable, Throwable> Mgb;
  static volatile e<Throwable, Throwable> Mgc;
  static volatile e<d.b, d.b> Mgd;
  static volatile e<d.b, d.b> Mge;
  static volatile e<b.b, b.b> Mgf;
  
  static
  {
    AppMethodBeat.i(90486);
    Mfa = new rx.b.b() {};
    MfQ = new f() {};
    MfX = new e() {};
    MfR = new f() {};
    MfY = new e() {};
    MfS = new f() {};
    MfW = new e() {};
    Mga = new e() {};
    Mgd = new e() {};
    Mgb = new e() {};
    Mge = new e() {};
    Mgc = new e() {};
    Mgf = new e() {};
    MfN = new e() {};
    MfO = new e() {};
    MfP = new e() {};
    AppMethodBeat.o(90486);
  }
  
  private static void Q(Throwable paramThrowable)
  {
    AppMethodBeat.i(90473);
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
    AppMethodBeat.o(90473);
  }
  
  public static Throwable R(Throwable paramThrowable)
  {
    AppMethodBeat.i(90482);
    e locale = Mga;
    if (locale != null)
    {
      paramThrowable = (Throwable)locale.call(paramThrowable);
      AppMethodBeat.o(90482);
      return paramThrowable;
    }
    AppMethodBeat.o(90482);
    return paramThrowable;
  }
  
  public static Throwable S(Throwable paramThrowable)
  {
    AppMethodBeat.i(90485);
    e locale = Mgc;
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
    f localf = MfS;
    if (localf != null)
    {
      paramb = (b.a)localf.W(paramb, parama);
      AppMethodBeat.o(90484);
      return paramb;
    }
    AppMethodBeat.o(90484);
    return parama;
  }
  
  public static <T> d.a<T> a(rx.d<T> paramd, d.a<T> parama)
  {
    AppMethodBeat.i(90480);
    f localf = MfQ;
    if (localf != null)
    {
      paramd = (d.a)localf.W(paramd, parama);
      AppMethodBeat.o(90480);
      return paramd;
    }
    AppMethodBeat.o(90480);
    return parama;
  }
  
  public static b.a b(b.a parama)
  {
    AppMethodBeat.i(90475);
    e locale = MfP;
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
    e locale = MfW;
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
    e locale = MfN;
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
    e locale = Mgd;
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
    e locale = MfT;
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
    e locale = MfX;
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
    e locale = MfU;
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
    e locale = MfV;
    if (locale != null)
    {
      paramg = (g)locale.call(paramg);
      AppMethodBeat.o(90478);
      return paramg;
    }
    AppMethodBeat.o(90478);
    return paramg;
  }
  
  public static rx.b.d<? extends ScheduledExecutorService> ggG()
  {
    return MfZ;
  }
  
  public static void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90472);
    rx.b.b localb = Mfa;
    if (localb != null) {
      try
      {
        localb.co(paramThrowable);
        AppMethodBeat.o(90472);
        return;
      }
      catch (Throwable localThrowable)
      {
        System.err.println("The onError handler threw an Exception. It shouldn't. => " + localThrowable.getMessage());
        Q(localThrowable);
      }
    }
    Q(paramThrowable);
    AppMethodBeat.o(90472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.d.c
 * JD-Core Version:    0.7.0.1
 */