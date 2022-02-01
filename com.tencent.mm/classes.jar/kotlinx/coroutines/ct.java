package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ah;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/ResumeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "invoke", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class ct
  extends ch
{
  private final d<ah> alw;
  
  public ct(d<? super ah> paramd)
  {
    this.alw = paramd;
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(188980);
    paramThrowable = this.alw;
    ah localah = ah.aiuX;
    Result.Companion localCompanion = Result.Companion;
    paramThrowable.resumeWith(Result.constructor-impl(localah));
    AppMethodBeat.o(188980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ct
 * JD-Core Version:    0.7.0.1
 */