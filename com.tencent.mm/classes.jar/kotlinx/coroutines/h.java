package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.Future;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/CancelFutureOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class h
  extends i
{
  private final Future<?> djn;
  
  public h(Future<?> paramFuture)
  {
    this.djn = paramFuture;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190697);
    String str = "CancelFutureOnCancel[" + this.djn + ']';
    AppMethodBeat.o(190697);
    return str;
  }
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(190695);
    this.djn.cancel(false);
    AppMethodBeat.o(190695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.h
 * JD-Core Version:    0.7.0.1
 */