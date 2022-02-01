package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/ResumeUndispatchedRunnable;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"})
final class cq
  implements Runnable
{
  private final af abwP;
  private final m<x> abwc;
  
  public cq(af paramaf, m<? super x> paramm)
  {
    this.abwP = paramaf;
    this.abwc = paramm;
  }
  
  public final void run()
  {
    AppMethodBeat.i(204220);
    this.abwc.a(this.abwP, x.aazN);
    AppMethodBeat.o(204220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.cq
 * JD-Core Version:    0.7.0.1
 */