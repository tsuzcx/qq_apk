package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"})
public final class n
  extends t
{
  private static final AtomicIntegerFieldUpdater LQK;
  private volatile int _resumed;
  
  static
  {
    AppMethodBeat.i(191164);
    LQK = AtomicIntegerFieldUpdater.newUpdater(n.class, "_resumed");
    AppMethodBeat.o(191164);
  }
  
  public n(d<?> paramd, Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean gdu()
  {
    AppMethodBeat.i(191162);
    boolean bool = LQK.compareAndSet(this, 0, 1);
    AppMethodBeat.o(191162);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.n
 * JD-Core Version:    0.7.0.1
 */