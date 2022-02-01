package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/Job;", "job", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"})
final class bh
  extends bl<bj>
{
  private static final AtomicIntegerFieldUpdater Kep;
  private volatile int _invoked;
  private final b<Throwable, y> jGI;
  
  static
  {
    AppMethodBeat.i(118220);
    Kep = AtomicIntegerFieldUpdater.newUpdater(bh.class, "_invoked");
    AppMethodBeat.o(118220);
  }
  
  public bh(bj parambj, b<? super Throwable, y> paramb)
  {
    super(parambj);
    AppMethodBeat.i(118219);
    this.jGI = paramb;
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
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118216);
    if (Kep.compareAndSet(this, 0, 1)) {
      this.jGI.aA(paramThrowable);
    }
    AppMethodBeat.o(118216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bh
 * JD-Core Version:    0.7.0.1
 */