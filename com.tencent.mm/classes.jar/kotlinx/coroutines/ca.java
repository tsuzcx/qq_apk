package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class ca
  extends ch
{
  private final b<Throwable, ah> rIX;
  
  public ca(b<? super Throwable, ah> paramb)
  {
    this.rIX = paramb;
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(118055);
    this.rIX.invoke(paramThrowable);
    AppMethodBeat.o(118055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ca
 * JD-Core Version:    0.7.0.1
 */