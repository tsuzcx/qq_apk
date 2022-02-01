package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class bt
  extends bz<bu>
{
  private final b<Throwable, x> lJK;
  
  public bt(bu parambu, b<? super Throwable, x> paramb)
  {
    super(parambu);
    AppMethodBeat.i(118058);
    this.lJK = paramb;
    AppMethodBeat.o(118058);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118057);
    String str = "InvokeOnCompletion[" + getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ']';
    AppMethodBeat.o(118057);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118055);
    this.lJK.invoke(paramThrowable);
    AppMethodBeat.o(118055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bt
 * JD-Core Version:    0.7.0.1
 */