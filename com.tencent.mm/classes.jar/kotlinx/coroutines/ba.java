package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/Delay;", "", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "context", "Lkotlin/coroutines/CoroutineContext;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ba
{
  public abstract bi a(long paramLong, Runnable paramRunnable, f paramf);
  
  public abstract void a(long paramLong, p<? super ah> paramp);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static bi b(long paramLong, Runnable paramRunnable, f paramf)
    {
      AppMethodBeat.i(188923);
      paramRunnable = ax.kCf().a(paramLong, paramRunnable, paramf);
      AppMethodBeat.o(188923);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ba
 * JD-Core Version:    0.7.0.1
 */