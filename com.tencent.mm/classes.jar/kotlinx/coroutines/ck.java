package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/ResumeUndispatchedRunnable;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"})
final class ck
  implements Runnable
{
  private final k<x> TTz;
  private final ad TUm;
  
  public ck(ad paramad, k<? super x> paramk)
  {
    this.TUm = paramad;
    this.TTz = paramk;
  }
  
  public final void run()
  {
    AppMethodBeat.i(192493);
    this.TTz.a(this.TUm, x.SXb);
    AppMethodBeat.o(192493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.ck
 * JD-Core Version:    0.7.0.1
 */