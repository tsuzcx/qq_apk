package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.aw;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"runSafely", "", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"})
public final class a
{
  public static final void a(d<? super x> paramd, d<?> paramd1)
  {
    AppMethodBeat.i(192392);
    try
    {
      paramd = b.e(paramd);
      localCompanion = Result.Companion;
      aw.a(paramd, Result.constructor-impl(x.SXb));
      AppMethodBeat.o(192392);
      return;
    }
    catch (Throwable paramd)
    {
      Result.Companion localCompanion = Result.Companion;
      paramd1.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramd)));
      AppMethodBeat.o(192392);
    }
  }
  
  public static final <R, T> void b(m<? super R, ? super d<? super T>, ? extends Object> paramm, R paramR, d<? super T> paramd)
  {
    AppMethodBeat.i(118134);
    try
    {
      paramm = b.e(b.a(paramm, paramR, paramd));
      paramR = Result.Companion;
      aw.a(paramm, Result.constructor-impl(x.SXb));
      AppMethodBeat.o(118134);
      return;
    }
    catch (Throwable paramm)
    {
      paramR = Result.Companion;
      paramd.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramm)));
      AppMethodBeat.o(118134);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.a.a
 * JD-Core Version:    0.7.0.1
 */