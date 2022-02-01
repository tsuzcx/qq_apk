package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.b;
import rx.i;

public final class a<T>
  extends i<T>
{
  final b<? super T> Oab;
  final b<Throwable> Oac;
  final rx.b.a Oad;
  
  public a(b<? super T> paramb, b<Throwable> paramb1, rx.b.a parama)
  {
    this.Oab = paramb;
    this.Oac = paramb1;
    this.Oad = parama;
  }
  
  public final void gyM()
  {
    AppMethodBeat.i(90210);
    this.Oad.call();
    AppMethodBeat.o(90210);
  }
  
  public final void gz(T paramT)
  {
    AppMethodBeat.i(90208);
    this.Oab.cq(paramT);
    AppMethodBeat.o(90208);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90209);
    this.Oac.cq(paramThrowable);
    AppMethodBeat.o(90209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.util.a
 * JD-Core Version:    0.7.0.1
 */