package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CancelFutureOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class m
  extends n
{
  private final Future<?> dBj;
  
  public m(Future<?> paramFuture)
  {
    this.dBj = paramFuture;
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(188793);
    if (paramThrowable != null) {
      this.dBj.cancel(false);
    }
    AppMethodBeat.o(188793);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188801);
    String str = "CancelFutureOnCancel[" + this.dBj + ']';
    AppMethodBeat.o(188801);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.m
 * JD-Core Version:    0.7.0.1
 */