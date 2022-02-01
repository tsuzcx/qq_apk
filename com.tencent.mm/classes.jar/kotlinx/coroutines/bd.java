package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/DisposableFutureHandle;", "Lkotlinx/coroutines/DisposableHandle;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "dispose", "", "toString", "", "kotlinx-coroutines-core"})
final class bd
  implements be
{
  private final Future<?> fuk;
  
  public bd(Future<?> paramFuture)
  {
    this.fuk = paramFuture;
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(204761);
    this.fuk.cancel(false);
    AppMethodBeat.o(204761);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204764);
    String str = "DisposableFutureHandle[" + this.fuk + ']';
    AppMethodBeat.o(204764);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.bd
 * JD-Core Version:    0.7.0.1
 */