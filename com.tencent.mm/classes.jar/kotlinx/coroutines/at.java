package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/Delay;", "", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"})
public abstract interface at
{
  public abstract void a(long paramLong, k<? super x> paramk);
  
  public abstract bc d(long paramLong, Runnable paramRunnable);
  
  @l(hxD={1, 1, 16})
  public static final class a
  {
    public static bc e(long paramLong, Runnable paramRunnable)
    {
      AppMethodBeat.i(192329);
      paramRunnable = aq.hMR().d(paramLong, paramRunnable);
      AppMethodBeat.o(192329);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.at
 * JD-Core Version:    0.7.0.1
 */