package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/DisposableFutureHandle;", "Lkotlinx/coroutines/DisposableHandle;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "dispose", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class bh
  implements bi
{
  private final Future<?> dBj;
  
  public bh(Future<?> paramFuture)
  {
    this.dBj = paramFuture;
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(188837);
    this.dBj.cancel(false);
    AppMethodBeat.o(188837);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188844);
    String str = "DisposableFutureHandle[" + this.dBj + ']';
    AppMethodBeat.o(188844);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.bh
 * JD-Core Version:    0.7.0.1
 */