package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/InvokeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class bg
  extends f
{
  private final b<Throwable, y> jGI;
  
  public bg(b<? super Throwable, y> paramb)
  {
    AppMethodBeat.i(118164);
    this.jGI = paramb;
    AppMethodBeat.o(118164);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118163);
    String str = "InvokeOnCancel[" + this.jGI.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ']';
    AppMethodBeat.o(118163);
    return str;
  }
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118161);
    this.jGI.aA(paramThrowable);
    AppMethodBeat.o(118161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bg
 * JD-Core Version:    0.7.0.1
 */