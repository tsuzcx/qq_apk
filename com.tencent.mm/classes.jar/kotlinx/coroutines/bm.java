package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/Job;", "job", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"})
final class bm
  extends bq<bo>
{
  private static final AtomicIntegerFieldUpdater LRP;
  private volatile int _invoked;
  private final b<Throwable, y> khg;
  
  static
  {
    AppMethodBeat.i(118220);
    LRP = AtomicIntegerFieldUpdater.newUpdater(bm.class, "_invoked");
    AppMethodBeat.o(118220);
  }
  
  public bm(bo parambo, b<? super Throwable, y> paramb)
  {
    super(parambo);
    AppMethodBeat.i(118219);
    this.khg = paramb;
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
    if (LRP.compareAndSet(this, 0, 1)) {
      this.khg.ay(paramThrowable);
    }
    AppMethodBeat.o(118216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bm
 * JD-Core Version:    0.7.0.1
 */