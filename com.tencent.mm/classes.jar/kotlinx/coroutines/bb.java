package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/DisposableFutureHandle;", "Lkotlinx/coroutines/DisposableHandle;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "dispose", "", "toString", "", "kotlinx-coroutines-core"})
final class bb
  implements bc
{
  private final Future<?> dBz;
  
  public bb(Future<?> paramFuture)
  {
    this.dBz = paramFuture;
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(192396);
    this.dBz.cancel(false);
    AppMethodBeat.o(192396);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192397);
    String str = "DisposableFutureHandle[" + this.dBz + ']';
    AppMethodBeat.o(192397);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bb
 * JD-Core Version:    0.7.0.1
 */