package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.b;
import rx.i;

public final class a<T>
  extends i<T>
{
  final b<? super T> akdi;
  final b<Throwable> akdj;
  final rx.b.a akdk;
  
  public a(b<? super T> paramb, b<Throwable> paramb1, rx.b.a parama)
  {
    this.akdi = paramb;
    this.akdj = paramb1;
    this.akdk = parama;
  }
  
  public final void fvq()
  {
    AppMethodBeat.i(90210);
    this.akdk.call();
    AppMethodBeat.o(90210);
  }
  
  public final void jV(T paramT)
  {
    AppMethodBeat.i(90208);
    this.akdi.call(paramT);
    AppMethodBeat.o(90208);
  }
  
  public final void l(Throwable paramThrowable)
  {
    AppMethodBeat.i(90209);
    this.akdj.call(paramThrowable);
    AppMethodBeat.o(90209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.util.a
 * JD-Core Version:    0.7.0.1
 */