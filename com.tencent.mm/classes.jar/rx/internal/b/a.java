package rx.internal.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import rx.a.b;
import rx.f;

public final class a<T>
  extends AtomicInteger
  implements f
{
  final rx.i<? super T> akbm;
  T value;
  
  public a(rx.i<? super T> parami)
  {
    this.akbm = parami;
  }
  
  private static <T> void a(rx.i<? super T> parami, T paramT)
  {
    AppMethodBeat.i(90309);
    if (parami.akau.akdH)
    {
      AppMethodBeat.o(90309);
      return;
    }
    try
    {
      parami.jV(paramT);
      if (parami.akau.akdH)
      {
        AppMethodBeat.o(90309);
        return;
      }
    }
    finally
    {
      b.a(localThrowable, parami, paramT);
      AppMethodBeat.o(90309);
      return;
    }
    parami.fvq();
    AppMethodBeat.o(90309);
  }
  
  public final void Cp(long paramLong)
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
        a(this.akbm, this.value);
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
        a(this.akbm, paramT);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.b.a
 * JD-Core Version:    0.7.0.1
 */