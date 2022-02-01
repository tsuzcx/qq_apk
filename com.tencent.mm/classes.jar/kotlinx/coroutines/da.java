package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.c.b;
import kotlinx.coroutines.internal.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "Lkotlin/time/Duration;", "withTimeout-lwyi7ZQ", "(DLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "withTimeoutOrNull-lwyi7ZQ", "kotlinx-coroutines-core"})
public final class da
{
  public static final <T> Object a(long paramLong, m<? super ak, ? super d<? super T>, ? extends Object> paramm, d<? super T> paramd)
  {
    AppMethodBeat.i(204774);
    if (paramLong <= 0L)
    {
      paramm = (Throwable)new cy("Timed out immediately");
      AppMethodBeat.o(204774);
      throw paramm;
    }
    paramm = a(new cz(paramLong, paramd), paramm);
    if (paramm == a.aaAA) {
      p.k(paramd, "frame");
    }
    AppMethodBeat.o(204774);
    return paramm;
  }
  
  private static final <U, T extends U> Object a(cz<U, ? super T> paramcz, m<? super ak, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(204775);
    f localf = paramcz.abzw.getContext();
    cc.a((by)paramcz, aw.d(localf).d(paramcz.time, (Runnable)paramcz));
    paramcz = b.b((t)paramcz, paramcz, paramm);
    AppMethodBeat.o(204775);
    return paramcz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.da
 * JD-Core Version:    0.7.0.1
 */