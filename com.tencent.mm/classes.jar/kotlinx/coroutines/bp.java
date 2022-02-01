package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/Job;", "job", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"})
final class bp
  extends bt<br>
{
  private static final AtomicIntegerFieldUpdater NIL;
  private volatile int _invoked;
  private final b<Throwable, z> kBU;
  
  static
  {
    AppMethodBeat.i(118220);
    NIL = AtomicIntegerFieldUpdater.newUpdater(bp.class, "_invoked");
    AppMethodBeat.o(118220);
  }
  
  public bp(br parambr, b<? super Throwable, z> paramb)
  {
    super(parambr);
    AppMethodBeat.i(118219);
    this.kBU = paramb;
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
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118216);
    if (NIL.compareAndSet(this, 0, 1)) {
      this.kBU.invoke(paramThrowable);
    }
    AppMethodBeat.o(118216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bp
 * JD-Core Version:    0.7.0.1
 */