package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class bi
  extends bm<bj>
{
  private final b<Throwable, y> jGI;
  
  public bi(bj parambj, b<? super Throwable, y> paramb)
  {
    super(parambj);
    AppMethodBeat.i(118058);
    this.jGI = paramb;
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
    this.jGI.aA(paramThrowable);
    AppMethodBeat.o(118055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bi
 * JD-Core Version:    0.7.0.1
 */