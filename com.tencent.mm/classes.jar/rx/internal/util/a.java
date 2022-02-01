package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.b;
import rx.i;

public final class a<T>
  extends i<T>
{
  final b<? super T> UmU;
  final b<Throwable> UmV;
  final rx.b.a UmW;
  
  public a(b<? super T> paramb, b<Throwable> paramb1, rx.b.a parama)
  {
    this.UmU = paramb;
    this.UmV = paramb1;
    this.UmW = parama;
  }
  
  public final void gL(T paramT)
  {
    AppMethodBeat.i(90208);
    this.UmU.cA(paramT);
    AppMethodBeat.o(90208);
  }
  
  public final void hQw()
  {
    AppMethodBeat.i(90210);
    this.UmW.call();
    AppMethodBeat.o(90210);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90209);
    this.UmV.cA(paramThrowable);
    AppMethodBeat.o(90209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.util.a
 * JD-Core Version:    0.7.0.1
 */