package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.a;
import rx.g.a;

final class l
  implements a
{
  private final a MeS;
  private final g.a MeT;
  private final long sxy;
  
  public l(a parama, g.a parama1, long paramLong)
  {
    this.MeS = parama;
    this.MeT = parama1;
    this.sxy = paramLong;
  }
  
  public final void call()
  {
    AppMethodBeat.i(90400);
    if (this.MeT.ggn())
    {
      AppMethodBeat.o(90400);
      return;
    }
    long l = this.sxy - this.MeT.now();
    if (l > 0L) {}
    try
    {
      Thread.sleep(l);
      if (this.MeT.ggn())
      {
        AppMethodBeat.o(90400);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      RuntimeException localRuntimeException = new RuntimeException(localInterruptedException);
      AppMethodBeat.o(90400);
      throw localRuntimeException;
    }
    this.MeS.call();
    AppMethodBeat.o(90400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.l
 * JD-Core Version:    0.7.0.1
 */