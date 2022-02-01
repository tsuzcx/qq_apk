package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class cs<T>
  extends ch
{
  private final q<T> ajwM;
  
  public cs(q<? super T> paramq)
  {
    this.ajwM = paramq;
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(118266);
    Object localObject = kCx().kCy();
    if (au.ASSERTIONS_ENABLED)
    {
      if (!(localObject instanceof bw)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramThrowable = new AssertionError();
        AppMethodBeat.o(118266);
        throw paramThrowable;
      }
    }
    if ((localObject instanceof ae))
    {
      paramThrowable = (d)this.ajwM;
      localObject = ((ae)localObject).cause;
      localCompanion = Result.Companion;
      paramThrowable.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject)));
      AppMethodBeat.o(118266);
      return;
    }
    paramThrowable = (d)this.ajwM;
    localObject = cj.iN(localObject);
    Result.Companion localCompanion = Result.Companion;
    paramThrowable.resumeWith(Result.constructor-impl(localObject));
    AppMethodBeat.o(118266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.cs
 * JD-Core Version:    0.7.0.1
 */