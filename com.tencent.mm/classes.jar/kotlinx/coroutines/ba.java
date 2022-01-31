package kotlinx.coroutines;

import a.f.a.b;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "job", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "_invoked", "Lkotlinx/atomicfu/AtomicInt;", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class ba
  extends be<bc>
{
  private static final AtomicIntegerFieldUpdater CIj;
  private final b<Throwable, y> CIh;
  private volatile int CIi;
  
  static
  {
    AppMethodBeat.i(118533);
    CIj = AtomicIntegerFieldUpdater.newUpdater(ba.class, "CIi");
    AppMethodBeat.o(118533);
  }
  
  public ba(bc parambc, b<? super Throwable, y> paramb)
  {
    super(parambc);
    AppMethodBeat.i(118532);
    this.CIh = paramb;
    this.CIi = 0;
    AppMethodBeat.o(118532);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118531);
    String str = "InvokeOnCancelling[" + af.ea(this) + '@' + af.dZ(this) + ']';
    AppMethodBeat.o(118531);
    return str;
  }
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118529);
    if (CIj.compareAndSet(this, 0, 1)) {
      this.CIh.S(paramThrowable);
    }
    AppMethodBeat.o(118529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.coroutines.ba
 * JD-Core Version:    0.7.0.1
 */