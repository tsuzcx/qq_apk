package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.a;
import rx.g.a;

final class l
  implements a
{
  private final long Hss;
  private final a akdb;
  private final g.a akdc;
  
  public l(a parama, g.a parama1, long paramLong)
  {
    this.akdb = parama;
    this.akdc = parama1;
    this.Hss = paramLong;
  }
  
  public final void call()
  {
    AppMethodBeat.i(90400);
    if (this.akdc.kKi())
    {
      AppMethodBeat.o(90400);
      return;
    }
    long l = this.Hss - this.akdc.now();
    if (l > 0L) {}
    try
    {
      Thread.sleep(l);
      if (this.akdc.kKi())
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
    this.akdb.call();
    AppMethodBeat.o(90400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.c.l
 * JD-Core Version:    0.7.0.1
 */