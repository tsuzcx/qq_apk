package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import rx.j;

final class i$a
  implements j
{
  private final Future<?> Umx;
  
  i$a(Future<?> paramFuture)
  {
    Object localObject;
    this.Umx = localObject;
  }
  
  public final void hQA()
  {
    AppMethodBeat.i(90337);
    if (this.Umy.get() != Thread.currentThread())
    {
      this.Umx.cancel(true);
      AppMethodBeat.o(90337);
      return;
    }
    this.Umx.cancel(false);
    AppMethodBeat.o(90337);
  }
  
  public final boolean hQB()
  {
    AppMethodBeat.i(90338);
    boolean bool = this.Umx.isCancelled();
    AppMethodBeat.o(90338);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     rx.internal.c.i.a
 * JD-Core Version:    0.7.0.1
 */