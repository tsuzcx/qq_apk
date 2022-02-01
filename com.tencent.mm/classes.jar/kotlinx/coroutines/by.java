package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/InvokeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class by
  extends n
{
  private final b<Throwable, ah> rIX;
  
  public by(b<? super Throwable, ah> paramb)
  {
    AppMethodBeat.i(118164);
    this.rIX = paramb;
    AppMethodBeat.o(118164);
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(118161);
    this.rIX.invoke(paramThrowable);
    AppMethodBeat.o(118161);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118163);
    String str = "InvokeOnCancel[" + this.rIX.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ']';
    AppMethodBeat.o(118163);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.by
 * JD-Core Version:    0.7.0.1
 */