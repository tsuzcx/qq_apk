package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.b;
import rx.i;

public final class a<T>
  extends i<T>
{
  final b<? super T> abQq;
  final b<Throwable> abQr;
  final rx.b.a abQs;
  
  public a(b<? super T> paramb, b<Throwable> paramb1, rx.b.a parama)
  {
    this.abQq = paramb;
    this.abQr = paramb1;
    this.abQs = parama;
  }
  
  public final void c(Throwable paramThrowable)
  {
    AppMethodBeat.i(90209);
    this.abQr.cA(paramThrowable);
    AppMethodBeat.o(90209);
  }
  
  public final void fUB()
  {
    AppMethodBeat.i(90210);
    this.abQs.call();
    AppMethodBeat.o(90210);
  }
  
  public final void he(T paramT)
  {
    AppMethodBeat.i(90208);
    this.abQq.cA(paramT);
    AppMethodBeat.o(90208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.util.a
 * JD-Core Version:    0.7.0.1
 */