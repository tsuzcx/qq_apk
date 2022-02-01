package com.tencent.threadpool.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/threadpool/coroutines/ThreadPoolCoroutineRunnable;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "runnable", "(Ljava/lang/Runnable;)V", "run", "", "toString", "", "threadpool-coroutines_release"}, k=1, mv={1, 1, 16})
final class d
  implements Runnable
{
  private final Runnable hPJ;
  
  public d(Runnable paramRunnable)
  {
    AppMethodBeat.i(226870);
    this.hPJ = paramRunnable;
    AppMethodBeat.o(226870);
  }
  
  public final void run()
  {
    AppMethodBeat.i(226875);
    this.hPJ.run();
    AppMethodBeat.o(226875);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(226872);
    String str = "thread-pool-coroutine-runnable-" + this.hPJ;
    AppMethodBeat.o(226872);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.threadpool.coroutines.d
 * JD-Core Version:    0.7.0.1
 */