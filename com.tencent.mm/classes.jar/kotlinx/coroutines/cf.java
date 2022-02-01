package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/ResumeUndispatchedRunnable;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"})
final class cf
  implements Runnable
{
  private final k<z> OeF;
  private final ac Ofr;
  
  public cf(ac paramac, k<? super z> paramk)
  {
    this.Ofr = paramac;
    this.OeF = paramk;
  }
  
  public final void run()
  {
    AppMethodBeat.i(209349);
    this.OeF.a(this.Ofr, z.Nhr);
    AppMethodBeat.o(209349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.cf
 * JD-Core Version:    0.7.0.1
 */