package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/CancelFutureOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class j
  extends k
{
  private final Future<?> fuk;
  
  public j(Future<?> paramFuture)
  {
    this.fuk = paramFuture;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204903);
    String str = "CancelFutureOnCancel[" + this.fuk + ']';
    AppMethodBeat.o(204903);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(204900);
    this.fuk.cancel(false);
    AppMethodBeat.o(204900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.j
 * JD-Core Version:    0.7.0.1
 */