package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.a;
import rx.g.a;

final class l
  implements a
{
  private final a Krj;
  private final g.a Krk;
  private final long roF;
  
  public l(a parama, g.a parama1, long paramLong)
  {
    this.Krj = parama;
    this.Krk = parama1;
    this.roF = paramLong;
  }
  
  public final void call()
  {
    AppMethodBeat.i(90400);
    if (this.Krk.fNx())
    {
      AppMethodBeat.o(90400);
      return;
    }
    long l = this.roF - this.Krk.now();
    if (l > 0L) {}
    try
    {
      Thread.sleep(l);
      if (this.Krk.fNx())
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
    this.Krj.call();
    AppMethodBeat.o(90400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.c.l
 * JD-Core Version:    0.7.0.1
 */