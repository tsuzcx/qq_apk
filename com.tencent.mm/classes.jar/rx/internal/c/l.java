package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.a;
import rx.g.a;

final class l
  implements a
{
  private final long BHK;
  private final a abQj;
  private final g.a abQk;
  
  public l(a parama, g.a parama1, long paramLong)
  {
    this.abQj = parama;
    this.abQk = parama1;
    this.BHK = paramLong;
  }
  
  public final void call()
  {
    AppMethodBeat.i(90400);
    if (this.abQk.iVK())
    {
      AppMethodBeat.o(90400);
      return;
    }
    long l = this.BHK - this.abQk.now();
    if (l > 0L) {}
    try
    {
      Thread.sleep(l);
      if (this.abQk.iVK())
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
    this.abQj.call();
    AppMethodBeat.o(90400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.c.l
 * JD-Core Version:    0.7.0.1
 */