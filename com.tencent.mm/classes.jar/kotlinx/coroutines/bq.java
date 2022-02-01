package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class bq
  extends bu<br>
{
  private final b<Throwable, z> kBU;
  
  public bq(br parambr, b<? super Throwable, z> paramb)
  {
    super(parambr);
    AppMethodBeat.i(118058);
    this.kBU = paramb;
    AppMethodBeat.o(118058);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118057);
    String str = "InvokeOnCompletion[" + getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ']';
    AppMethodBeat.o(118057);
    return str;
  }
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118055);
    this.kBU.invoke(paramThrowable);
    AppMethodBeat.o(118055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bq
 * JD-Core Version:    0.7.0.1
 */