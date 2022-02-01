package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.a;
import rx.g.a;

final class l
  implements a
{
  private final a NZU;
  private final g.a NZV;
  private final long ttZ;
  
  public l(a parama, g.a parama1, long paramLong)
  {
    this.NZU = parama;
    this.NZV = parama1;
    this.ttZ = paramLong;
  }
  
  public final void call()
  {
    AppMethodBeat.i(90400);
    if (this.NZV.gyR())
    {
      AppMethodBeat.o(90400);
      return;
    }
    long l = this.ttZ - this.NZV.now();
    if (l > 0L) {}
    try
    {
      Thread.sleep(l);
      if (this.NZV.gyR())
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
    this.NZU.call();
    AppMethodBeat.o(90400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.l
 * JD-Core Version:    0.7.0.1
 */