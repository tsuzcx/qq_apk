package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import rx.internal.a.k;
import rx.internal.a.m;
import rx.internal.util.f;
import rx.internal.util.h;

public class d<T>
{
  final d.a<T> abNr;
  
  protected d(d.a<T> parama)
  {
    this.abNr = parama;
  }
  
  public static d<Long> a(TimeUnit paramTimeUnit, g paramg)
  {
    AppMethodBeat.i(90058);
    paramTimeUnit = a(new rx.internal.a.g(0L, 1000L, paramTimeUnit, paramg));
    AppMethodBeat.o(90058);
    return paramTimeUnit;
  }
  
  public static <T> d<T> a(d.a<T> parama)
  {
    AppMethodBeat.i(90055);
    parama = new d(rx.d.c.b(parama));
    AppMethodBeat.o(90055);
    return parama;
  }
  
  private d<T> a(g paramg, int paramInt)
  {
    AppMethodBeat.i(90061);
    if ((this instanceof h))
    {
      AppMethodBeat.o(90061);
      throw null;
    }
    paramg = a(new rx.internal.a.j(paramg, paramInt));
    AppMethodBeat.o(90061);
    return paramg;
  }
  
  public static <T> j a(i<? super T> parami, d<T> paramd)
  {
    AppMethodBeat.i(90066);
    if (paramd.abNr == null)
    {
      parami = new IllegalStateException("onSubscribe function can not be null.");
      AppMethodBeat.o(90066);
      throw parami;
    }
    parami.onStart();
    parami = new rx.c.a(parami);
    try
    {
      rx.d.c.a(paramd, paramd.abNr).cA(parami);
      paramd = rx.d.c.c(parami);
      AppMethodBeat.o(90066);
      return paramd;
    }
    catch (Throwable paramd)
    {
      rx.a.b.R(paramd);
      if (parami.abNB.abQP) {
        rx.d.c.c(rx.d.c.Z(paramd));
      }
      for (;;)
      {
        parami = rx.f.d.iWx();
        AppMethodBeat.o(90066);
        return parami;
        try
        {
          parami.c(rx.d.c.Z(paramd));
        }
        catch (Throwable parami)
        {
          rx.a.b.R(parami);
          parami = new rx.a.e("Error occurred attempting to subscribe [" + paramd.getMessage() + "] and then again while trying to pass to onError.", parami);
          rx.d.c.Z(parami);
          AppMethodBeat.o(90066);
          throw parami;
        }
      }
    }
  }
  
  public final <R> d<R> a(rx.b.e<? super T, ? extends R> parame)
  {
    AppMethodBeat.i(90059);
    parame = a(new rx.internal.a.e(this, parame));
    AppMethodBeat.o(90059);
    return parame;
  }
  
  public final <R> d<R> a(d.b<? extends R, ? super T> paramb)
  {
    AppMethodBeat.i(90056);
    paramb = a(new rx.internal.a.d(this.abNr, paramb));
    AppMethodBeat.o(90056);
    return paramb;
  }
  
  public final <R> d<R> a(c<? super T, ? extends R> paramc)
  {
    AppMethodBeat.i(90057);
    paramc = (d)paramc.call(this);
    AppMethodBeat.o(90057);
    return paramc;
  }
  
  public final d<T> a(g paramg)
  {
    AppMethodBeat.i(90060);
    paramg = a(paramg, f.abQJ);
    AppMethodBeat.o(90060);
    return paramg;
  }
  
  public final j a(rx.b.b<? super T> paramb)
  {
    AppMethodBeat.i(90063);
    paramb = a(new rx.internal.util.a(paramb, rx.internal.util.c.abQA, rx.b.c.iVM()), this);
    AppMethodBeat.o(90063);
    return paramb;
  }
  
  public final j a(rx.b.b<? super T> paramb, rx.b.b<Throwable> paramb1)
  {
    AppMethodBeat.i(90064);
    paramb = a(new rx.internal.util.a(paramb, paramb1, rx.b.c.iVM()), this);
    AppMethodBeat.o(90064);
    return paramb;
  }
  
  public final j a(i<? super T> parami)
  {
    AppMethodBeat.i(90065);
    try
    {
      parami.onStart();
      rx.d.c.a(this, this.abNr).cA(parami);
      j localj = rx.d.c.c(parami);
      AppMethodBeat.o(90065);
      return localj;
    }
    catch (Throwable localThrowable)
    {
      rx.a.b.R(localThrowable);
      try
      {
        parami.c(rx.d.c.Z(localThrowable));
        parami = rx.f.d.iWx();
        AppMethodBeat.o(90065);
        return parami;
      }
      catch (Throwable parami)
      {
        rx.a.b.R(parami);
        parami = new rx.a.e("Error occurred attempting to subscribe [" + localThrowable.getMessage() + "] and then again while trying to pass to onError.", parami);
        rx.d.c.Z(parami);
        AppMethodBeat.o(90065);
        throw parami;
      }
    }
  }
  
  public final d<T> iVH()
  {
    AppMethodBeat.i(90062);
    d locald = a(k.iVR());
    AppMethodBeat.o(90062);
    return locald;
  }
  
  public final d<T> iVI()
  {
    AppMethodBeat.i(90067);
    d locald = a(new m());
    AppMethodBeat.o(90067);
    return locald;
  }
  
  public static abstract interface c<T, R>
    extends rx.b.e<d<T>, d<R>>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.d
 * JD-Core Version:    0.7.0.1
 */