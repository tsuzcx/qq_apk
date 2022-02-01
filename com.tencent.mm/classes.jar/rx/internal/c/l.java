package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.a;
import rx.g.a;

final class l
  implements a
{
  private final a UmN;
  private final g.a UmO;
  private final long wVP;
  
  public l(a parama, g.a parama1, long paramLong)
  {
    this.UmN = parama;
    this.UmO = parama1;
    this.wVP = paramLong;
  }
  
  public final void call()
  {
    AppMethodBeat.i(90400);
    if (this.UmO.hQB())
    {
      AppMethodBeat.o(90400);
      return;
    }
    long l = this.wVP - this.UmO.now();
    if (l > 0L) {}
    try
    {
      Thread.sleep(l);
      if (this.UmO.hQB())
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
    this.UmN.call();
    AppMethodBeat.o(90400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.l
 * JD-Core Version:    0.7.0.1
 */