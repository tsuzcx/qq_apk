package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import rx.j;

final class i$a
  implements j
{
  private final Future<?> NZE;
  
  i$a(Future<?> paramFuture)
  {
    Object localObject;
    this.NZE = localObject;
  }
  
  public final void gyQ()
  {
    AppMethodBeat.i(90337);
    if (this.NZF.get() != Thread.currentThread())
    {
      this.NZE.cancel(true);
      AppMethodBeat.o(90337);
      return;
    }
    this.NZE.cancel(false);
    AppMethodBeat.o(90337);
  }
  
  public final boolean gyR()
  {
    AppMethodBeat.i(90338);
    boolean bool = this.NZE.isCancelled();
    AppMethodBeat.o(90338);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.c.i.a
 * JD-Core Version:    0.7.0.1
 */