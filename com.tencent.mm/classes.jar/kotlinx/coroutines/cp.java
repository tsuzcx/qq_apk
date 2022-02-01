package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.d.d;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/ResumeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "continuation", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)V", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class cp
  extends cd<by>
{
  private final d<x> abwQ;
  
  public cp(by paramby, d<? super x> paramd)
  {
    super(paramby);
    this.abwQ = paramd;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204618);
    String str = "ResumeOnCompletion[" + this.abwQ + ']';
    AppMethodBeat.o(204618);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(204615);
    paramThrowable = this.abwQ;
    x localx = x.aazN;
    Result.Companion localCompanion = Result.Companion;
    paramThrowable.resumeWith(Result.constructor-impl(localx));
    AppMethodBeat.o(204615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.cp
 * JD-Core Version:    0.7.0.1
 */