package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class bn
  extends br<bo>
{
  private final b<Throwable, y> khg;
  
  public bn(bo parambo, b<? super Throwable, y> paramb)
  {
    super(parambo);
    AppMethodBeat.i(118058);
    this.khg = paramb;
    AppMethodBeat.o(118058);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118057);
    String str = "InvokeOnCompletion[" + getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ']';
    AppMethodBeat.o(118057);
    return str;
  }
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118055);
    this.khg.ay(paramThrowable);
    AppMethodBeat.o(118055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bn
 * JD-Core Version:    0.7.0.1
 */