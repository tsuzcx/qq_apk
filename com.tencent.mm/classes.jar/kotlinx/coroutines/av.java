package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/Delay;", "", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"})
public abstract interface av
{
  public abstract void a(long paramLong, m<? super x> paramm);
  
  public abstract be d(long paramLong, Runnable paramRunnable);
  
  @l(iBK={1, 1, 16})
  public static final class a
  {
    public static be e(long paramLong, Runnable paramRunnable)
    {
      AppMethodBeat.i(204145);
      paramRunnable = as.iRn().d(paramLong, paramRunnable);
      AppMethodBeat.o(204145);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.av
 * JD-Core Version:    0.7.0.1
 */