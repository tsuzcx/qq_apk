package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/Job;", "job", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"})
final class bw
  extends ca<by>
{
  private static final AtomicIntegerFieldUpdater abxr;
  private volatile int _invoked;
  private final b<Throwable, x> oFZ;
  
  static
  {
    AppMethodBeat.i(118220);
    abxr = AtomicIntegerFieldUpdater.newUpdater(bw.class, "_invoked");
    AppMethodBeat.o(118220);
  }
  
  public bw(by paramby, b<? super Throwable, x> paramb)
  {
    super(paramby);
    AppMethodBeat.i(118219);
    this.oFZ = paramb;
    this._invoked = 0;
    AppMethodBeat.o(118219);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118218);
    String str = "InvokeOnCancelling[" + getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ']';
    AppMethodBeat.o(118218);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118216);
    if (abxr.compareAndSet(this, 0, 1)) {
      this.oFZ.invoke(paramThrowable);
    }
    AppMethodBeat.o(118216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.bw
 * JD-Core Version:    0.7.0.1
 */