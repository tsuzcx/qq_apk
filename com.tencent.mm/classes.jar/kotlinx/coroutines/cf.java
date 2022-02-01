package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/ResumeUndispatchedRunnable;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"})
final class cf
  implements Runnable
{
  private final k<z> NHz;
  private final ac NIl;
  
  public cf(ac paramac, k<? super z> paramk)
  {
    this.NIl = paramac;
    this.NHz = paramk;
  }
  
  public final void run()
  {
    AppMethodBeat.i(190858);
    this.NHz.a(this.NIl, z.MKo);
    AppMethodBeat.o(190858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.cf
 * JD-Core Version:    0.7.0.1
 */