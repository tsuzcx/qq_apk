package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.internal.a.k;
import rx.internal.util.f;
import rx.internal.util.h;

public class d<T>
{
  final d.a<T> akak;
  
  protected d(d.a<T> parama)
  {
    this.akak = parama;
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
    if (paramd.akak == null)
    {
      parami = new IllegalStateException("onSubscribe function can not be null.");
      AppMethodBeat.o(90066);
      throw parami;
    }
    parami.onStart();
    parami = new rx.c.a(parami);
    try
    {
      rx.d.c.a(paramd, paramd.akak).call(parami);
      paramd = rx.d.c.c(parami);
      AppMethodBeat.o(90066);
      return paramd;
    }
    finally
    {
      rx.a.b.ai(paramd);
      if (parami.akau.akdH) {
        rx.d.c.l(rx.d.c.aq(paramd));
      }
      for (;;)
      {
        parami = rx.f.d.kKY();
        AppMethodBeat.o(90066);
        return parami;
        try
        {
          parami.l(rx.d.c.aq(paramd));
        }
        finally
        {
          rx.a.b.ai(parami);
          parami = new rx.a.e("Error occurred attempting to subscribe [" + paramd.getMessage() + "] and then again while trying to pass to onError.", parami);
          rx.d.c.aq(parami);
          AppMethodBeat.o(90066);
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
    paramb = a(new rx.internal.a.d(this.akak, paramb));
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
    paramg = a(paramg, f.akdB);
    AppMethodBeat.o(90060);
    return paramg;
  }
  
  public final j a(rx.b.b<? super T> paramb)
  {
    AppMethodBeat.i(90063);
    if (paramb == null)
    {
      paramb = new IllegalArgumentException("onNext can not be null");
      AppMethodBeat.o(90063);
      throw paramb;
    }
    paramb = a(new rx.internal.util.a(paramb, rx.internal.util.c.akds, rx.b.c.kKk()), this);
    AppMethodBeat.o(90063);
    return paramb;
  }
  
  public final j a(rx.b.b<? super T> paramb, rx.b.b<Throwable> paramb1)
  {
    AppMethodBeat.i(90064);
    paramb = a(new rx.internal.util.a(paramb, paramb1, rx.b.c.kKk()), this);
    AppMethodBeat.o(90064);
    return paramb;
  }
  
  public final j a(i<? super T> parami)
  {
    AppMethodBeat.i(369478);
    try
    {
      parami.onStart();
      rx.d.c.a(this, this.akak).call(parami);
      j localj = rx.d.c.c(parami);
      AppMethodBeat.o(369478);
      return localj;
    }
    finally
    {
      rx.a.b.ai(localThrowable);
      try
      {
        parami.l(rx.d.c.aq(localThrowable));
        parami = rx.f.d.kKY();
        AppMethodBeat.o(369478);
        return parami;
      }
      finally
      {
        rx.a.b.ai(parami);
        parami = new rx.a.e("Error occurred attempting to subscribe [" + localThrowable.getMessage() + "] and then again while trying to pass to onError.", parami);
        rx.d.c.aq(parami);
        AppMethodBeat.o(369478);
      }
    }
  }
  
  public final d<T> kKg()
  {
    AppMethodBeat.i(90062);
    d locald = a(k.kKp());
    AppMethodBeat.o(90062);
    return locald;
  }
  
  public static abstract interface c<T, R>
    extends rx.b.e<d<T>, d<R>>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.d
 * JD-Core Version:    0.7.0.1
 */