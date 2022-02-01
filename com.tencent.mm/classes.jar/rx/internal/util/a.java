package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.b;
import rx.i;

public final class a<T>
  extends i<T>
{
  final b<? super T> MeZ;
  final b<Throwable> Mfa;
  final rx.b.a Mfb;
  
  public a(b<? super T> paramb, b<Throwable> paramb1, rx.b.a parama)
  {
    this.MeZ = paramb;
    this.Mfa = paramb1;
    this.Mfb = parama;
  }
  
  public final void gd(T paramT)
  {
    AppMethodBeat.i(90208);
    this.MeZ.co(paramT);
    AppMethodBeat.o(90208);
  }
  
  public final void ggi()
  {
    AppMethodBeat.i(90210);
    this.Mfb.call();
    AppMethodBeat.o(90210);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90209);
    this.Mfa.co(paramThrowable);
    AppMethodBeat.o(90209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.util.a
 * JD-Core Version:    0.7.0.1
 */