package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/InvokeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class bl
  extends h
{
  private final b<Throwable, y> khg;
  
  public bl(b<? super Throwable, y> paramb)
  {
    AppMethodBeat.i(118164);
    this.khg = paramb;
    AppMethodBeat.o(118164);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118163);
    String str = "InvokeOnCancel[" + this.khg.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ']';
    AppMethodBeat.o(118163);
    return str;
  }
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118161);
    this.khg.ay(paramThrowable);
    AppMethodBeat.o(118161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bl
 * JD-Core Version:    0.7.0.1
 */