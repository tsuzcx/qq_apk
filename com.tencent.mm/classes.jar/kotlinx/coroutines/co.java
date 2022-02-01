package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "job", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class co<T>
  extends cd<ce>
{
  private final n<T> abxM;
  
  public co(ce paramce, n<? super T> paramn)
  {
    super((by)paramce);
    AppMethodBeat.i(204144);
    this.abxM = paramn;
    AppMethodBeat.o(204144);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118268);
    String str = "ResumeAwaitOnCompletion[" + this.abxM + ']';
    AppMethodBeat.o(118268);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118266);
    Object localObject = ((ce)this.Gib).iRJ();
    if (ap.iRg())
    {
      if (!(localObject instanceof bt)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramThrowable = (Throwable)new AssertionError();
        AppMethodBeat.o(118266);
        throw paramThrowable;
      }
    }
    if ((localObject instanceof x))
    {
      paramThrowable = (d)this.abxM;
      localObject = ((x)localObject).cause;
      localCompanion = Result.Companion;
      paramThrowable.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject)));
      AppMethodBeat.o(118266);
      return;
    }
    paramThrowable = (d)this.abxM;
    localObject = cf.gl(localObject);
    Result.Companion localCompanion = Result.Companion;
    paramThrowable.resumeWith(Result.constructor-impl(localObject));
    AppMethodBeat.o(118266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.co
 * JD-Core Version:    0.7.0.1
 */