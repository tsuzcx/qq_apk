package rx.internal.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import rx.a.b;
import rx.f;

public final class a<T>
  extends AtomicInteger
  implements f
{
  final rx.i<? super T> Ovj;
  T value;
  
  public a(rx.i<? super T> parami)
  {
    this.Ovj = parami;
  }
  
  private static <T> void a(rx.i<? super T> parami, T paramT)
  {
    AppMethodBeat.i(90309);
    if (parami.Ous.OxN)
    {
      AppMethodBeat.o(90309);
      return;
    }
    try
    {
      parami.gC(paramT);
      if (parami.Ous.OxN)
      {
        AppMethodBeat.o(90309);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      b.a(localThrowable, parami, paramT);
      AppMethodBeat.o(90309);
      return;
    }
    parami.gDo();
    AppMethodBeat.o(90309);
  }
  
  public final void Gq(long paramLong)
  {
    AppMethodBeat.i(90307);
    if (paramLong < 0L)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("n >= 0 required");
      AppMethodBeat.o(90307);
      throw localIllegalArgumentException;
    }
    if (paramLong == 0L)
    {
      AppMethodBeat.o(90307);
      return;
    }
    int i;
    do
    {
      i = get();
      if (i != 0) {
        break;
      }
    } while (!compareAndSet(0, 2));
    for (;;)
    {
      AppMethodBeat.o(90307);
      return;
      if ((i == 1) && (compareAndSet(1, 3))) {
        a(this.Ovj, this.value);
      }
    }
  }
  
  public final void setValue(T paramT)
  {
    AppMethodBeat.i(90308);
    int i;
    do
    {
      i = get();
      if (i != 0) {
        break;
      }
      this.value = paramT;
    } while (!compareAndSet(0, 1));
    for (;;)
    {
      AppMethodBeat.o(90308);
      return;
      if ((i == 2) && (compareAndSet(2, 3))) {
        a(this.Ovj, paramT);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.b.a
 * JD-Core Version:    0.7.0.1
 */