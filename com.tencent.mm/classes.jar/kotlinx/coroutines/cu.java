package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.a.b;
import kotlinx.coroutines.internal.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "kotlinx-coroutines-core"})
public final class cu
{
  public static final <T> Object a(long paramLong, m<? super ai, ? super d<? super T>, ? extends Object> paramm, d<? super T> paramd)
  {
    AppMethodBeat.i(192501);
    if (paramLong <= 0L)
    {
      paramm = (Throwable)new cs("Timed out immediately");
      AppMethodBeat.o(192501);
      throw paramm;
    }
    paramm = a(new ct(paramLong, paramd), paramm);
    if (paramm == a.SXO) {
      p.h(paramd, "frame");
    }
    AppMethodBeat.o(192501);
    return paramm;
  }
  
  private static final <U, T extends U> Object a(ct<U, ? super T> paramct, m<? super ai, ? super d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(192502);
    f localf = paramct.TWf.getContext();
    by.a((bu)paramct, au.c(localf).d(paramct.time, (Runnable)paramct));
    paramct = b.b((s)paramct, paramct, paramm);
    AppMethodBeat.o(192502);
    return paramct;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.cu
 * JD-Core Version:    0.7.0.1
 */