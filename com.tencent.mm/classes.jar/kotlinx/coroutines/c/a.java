package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.internal.i;

@Metadata(d1={""}, d2={"dispatcherFailure", "", "completion", "Lkotlin/coroutines/Continuation;", "e", "", "runSafely", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "onCancellation", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final void a(d<?> paramd, Throwable paramThrowable)
  {
    AppMethodBeat.i(369483);
    Result.Companion localCompanion = Result.Companion;
    paramd.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramThrowable)));
    AppMethodBeat.o(369483);
    throw paramThrowable;
  }
  
  public static final void a(d<? super ah> paramd, d<?> paramd1)
  {
    AppMethodBeat.i(188875);
    try
    {
      paramd = b.au(paramd);
      Result.Companion localCompanion = Result.Companion;
      i.a(paramd, Result.constructor-impl(ah.aiuX));
      AppMethodBeat.o(188875);
      return;
    }
    finally
    {
      a(paramd1, paramd);
      AppMethodBeat.o(188875);
    }
  }
  
  public static final <R, T> void b(m<? super R, ? super d<? super T>, ? extends Object> paramm, R paramR, d<? super T> paramd)
  {
    AppMethodBeat.i(188869);
    try
    {
      paramm = b.au(b.a(paramm, paramR, paramd));
      paramR = Result.Companion;
      i.a(paramm, Result.constructor-impl(ah.aiuX), null);
      AppMethodBeat.o(188869);
      return;
    }
    finally
    {
      a(paramd, paramm);
      AppMethodBeat.o(188869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.a
 * JD-Core Version:    0.7.0.1
 */