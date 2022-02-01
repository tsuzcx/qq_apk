package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.d.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"})
public final class q
  extends x
{
  private static final AtomicIntegerFieldUpdater abwk;
  private volatile int _resumed;
  
  static
  {
    AppMethodBeat.i(204814);
    abwk = AtomicIntegerFieldUpdater.newUpdater(q.class, "_resumed");
    AppMethodBeat.o(204814);
  }
  
  public q(d<?> paramd, Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean iQV()
  {
    AppMethodBeat.i(204811);
    boolean bool = abwk.compareAndSet(this, 0, 1);
    AppMethodBeat.o(204811);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.q
 * JD-Core Version:    0.7.0.1
 */