package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.b;
import rx.i;

public final class a<T>
  extends i<T>
{
  final b<? super T> Oxg;
  final b<Throwable> Oxh;
  final rx.b.a Oxi;
  
  public a(b<? super T> paramb, b<Throwable> paramb1, rx.b.a parama)
  {
    this.Oxg = paramb;
    this.Oxh = paramb1;
    this.Oxi = parama;
  }
  
  public final void gC(T paramT)
  {
    AppMethodBeat.i(90208);
    this.Oxg.cr(paramT);
    AppMethodBeat.o(90208);
  }
  
  public final void gDo()
  {
    AppMethodBeat.i(90210);
    this.Oxi.call();
    AppMethodBeat.o(90210);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90209);
    this.Oxh.cr(paramThrowable);
    AppMethodBeat.o(90209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.util.a
 * JD-Core Version:    0.7.0.1
 */