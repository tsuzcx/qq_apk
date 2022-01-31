package kotlinx.coroutines;

import a.f.a.b;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/InvokeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class az
  extends g
{
  private final b<Throwable, y> CIh;
  
  public az(b<? super Throwable, y> paramb)
  {
    AppMethodBeat.i(118481);
    this.CIh = paramb;
    AppMethodBeat.o(118481);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118480);
    String str = "InvokeOnCancel[" + af.ea(this.CIh) + '@' + af.dZ(this) + ']';
    AppMethodBeat.o(118480);
    return str;
  }
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118478);
    this.CIh.S(paramThrowable);
    AppMethodBeat.o(118478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.az
 * JD-Core Version:    0.7.0.1
 */