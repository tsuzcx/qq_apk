package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/CancelFutureOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class h
  extends i
{
  private final Future<?> dBz;
  
  public h(Future<?> paramFuture)
  {
    this.dBz = paramFuture;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192316);
    String str = "CancelFutureOnCancel[" + this.dBz + ']';
    AppMethodBeat.o(192316);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(192314);
    this.dBz.cancel(false);
    AppMethodBeat.o(192314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.h
 * JD-Core Version:    0.7.0.1
 */