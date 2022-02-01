package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.b;
import rx.i;

public final class a<T>
  extends i<T>
{
  final b<? super T> Krq;
  final b<Throwable> Krr;
  final rx.b.a Krs;
  
  public a(b<? super T> paramb, b<Throwable> paramb1, rx.b.a parama)
  {
    this.Krq = paramb;
    this.Krr = paramb1;
    this.Krs = parama;
  }
  
  public final void fNs()
  {
    AppMethodBeat.i(90210);
    this.Krs.call();
    AppMethodBeat.o(90210);
  }
  
  public final void fV(T paramT)
  {
    AppMethodBeat.i(90208);
    this.Krq.cq(paramT);
    AppMethodBeat.o(90208);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90209);
    this.Krr.cq(paramThrowable);
    AppMethodBeat.o(90209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.util.a
 * JD-Core Version:    0.7.0.1
 */