package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.b.a;
import rx.b.e;
import rx.d;
import rx.d.a;
import rx.f;
import rx.g;
import rx.g.a;
import rx.j;

public final class h<T>
  extends d<T>
{
  static final boolean OxE;
  final T OxD;
  
  static
  {
    AppMethodBeat.i(90227);
    OxE = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    AppMethodBeat.o(90227);
  }
  
  public final d<T> b(final g paramg)
  {
    AppMethodBeat.i(90226);
    if ((paramg instanceof rx.internal.c.b)) {}
    for (paramg = new e() {};; paramg = new e() {})
    {
      paramg = a(new a(this.OxD, paramg));
      AppMethodBeat.o(90226);
      return paramg;
    }
  }
  
  static final class a<T>
    implements d.a<T>
  {
    final e<a, j> OxL;
    final T value;
    
    a(T paramT, e<a, j> parame)
    {
      this.value = paramT;
      this.OxL = parame;
    }
  }
  
  static final class b<T>
    extends AtomicBoolean
    implements a, f
  {
    final rx.i<? super T> OuS;
    final e<a, j> OxL;
    final T value;
    
    public b(rx.i<? super T> parami, T paramT, e<a, j> parame)
    {
      this.OuS = parami;
      this.value = paramT;
      this.OxL = parame;
    }
    
    public final void Gq(long paramLong)
    {
      AppMethodBeat.i(90223);
      if (paramLong < 0L)
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("n >= 0 required but it was ".concat(String.valueOf(paramLong)));
        AppMethodBeat.o(90223);
        throw localIllegalArgumentException;
      }
      if ((paramLong != 0L) && (compareAndSet(false, true))) {
        this.OuS.b((j)this.OxL.call(this));
      }
      AppMethodBeat.o(90223);
    }
    
    public final void call()
    {
      AppMethodBeat.i(90224);
      rx.i locali = this.OuS;
      if (locali.Ous.OxN)
      {
        AppMethodBeat.o(90224);
        return;
      }
      Object localObject = this.value;
      try
      {
        locali.gC(localObject);
        if (locali.Ous.OxN)
        {
          AppMethodBeat.o(90224);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        rx.a.b.a(localThrowable, locali, localObject);
        AppMethodBeat.o(90224);
        return;
      }
      locali.gDo();
      AppMethodBeat.o(90224);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(90225);
      String str = "ScalarAsyncProducer[" + this.value + ", " + get() + "]";
      AppMethodBeat.o(90225);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.util.h
 * JD-Core Version:    0.7.0.1
 */