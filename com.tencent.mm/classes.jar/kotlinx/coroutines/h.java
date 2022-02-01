package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.Future;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/CancelFutureOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class h
  extends i
{
  private final Future<?> dkp;
  
  public h(Future<?> paramFuture)
  {
    this.dkp = paramFuture;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209188);
    String str = "CancelFutureOnCancel[" + this.dkp + ']';
    AppMethodBeat.o(209188);
    return str;
  }
  
  public final void x(Throwable paramThrowable)
  {
    AppMethodBeat.i(209186);
    this.dkp.cancel(false);
    AppMethodBeat.o(209186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.h
 * JD-Core Version:    0.7.0.1
 */