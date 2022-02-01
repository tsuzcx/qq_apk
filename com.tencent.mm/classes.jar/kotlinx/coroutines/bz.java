package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"}, k=1, mv={1, 5, 1}, xi=48)
final class bz
  extends cd
{
  private final b<Throwable, ah> rIX;
  
  static
  {
    AppMethodBeat.i(118220);
    ajwr = AtomicIntegerFieldUpdater.newUpdater(bz.class, "_invoked");
    AppMethodBeat.o(118220);
  }
  
  public bz(b<? super Throwable, ah> paramb)
  {
    this.rIX = paramb;
    this._invoked = 0;
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(118216);
    if (ajwr.compareAndSet(this, 0, 1)) {
      this.rIX.invoke(paramThrowable);
    }
    AppMethodBeat.o(118216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bz
 * JD-Core Version:    0.7.0.1
 */