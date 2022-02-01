package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.d;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "job", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class cj<T>
  extends bz<ca>
{
  private final l<T> TVi;
  
  public cj(ca paramca, l<? super T> paraml)
  {
    super((bu)paramca);
    AppMethodBeat.i(192403);
    this.TVi = paraml;
    AppMethodBeat.o(192403);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118268);
    String str = "ResumeAwaitOnCompletion[" + this.TVi + ']';
    AppMethodBeat.o(118268);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118266);
    Object localObject = ((ca)this.TUQ).hNm();
    if (an.hMK())
    {
      if (!(localObject instanceof bp)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramThrowable = (Throwable)new AssertionError();
        AppMethodBeat.o(118266);
        throw paramThrowable;
      }
    }
    if ((localObject instanceof v))
    {
      paramThrowable = (d)this.TVi;
      localObject = ((v)localObject).cause;
      localCompanion = Result.Companion;
      paramThrowable.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject)));
      AppMethodBeat.o(118266);
      return;
    }
    paramThrowable = (d)this.TVi;
    localObject = cb.gd(localObject);
    Result.Companion localCompanion = Result.Companion;
    paramThrowable.resumeWith(Result.constructor-impl(localObject));
    AppMethodBeat.o(118266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.cj
 * JD-Core Version:    0.7.0.1
 */