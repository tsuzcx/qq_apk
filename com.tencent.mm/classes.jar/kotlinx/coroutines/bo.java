package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/InvokeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class bo
  extends i
{
  private final b<Throwable, z> kFj;
  
  public bo(b<? super Throwable, z> paramb)
  {
    AppMethodBeat.i(118164);
    this.kFj = paramb;
    AppMethodBeat.o(118164);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118163);
    String str = "InvokeOnCancel[" + this.kFj.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ']';
    AppMethodBeat.o(118163);
    return str;
  }
  
  public final void x(Throwable paramThrowable)
  {
    AppMethodBeat.i(118161);
    this.kFj.invoke(paramThrowable);
    AppMethodBeat.o(118161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bo
 * JD-Core Version:    0.7.0.1
 */