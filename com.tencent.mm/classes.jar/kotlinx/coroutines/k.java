package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"})
public final class k
  extends q
{
  private static final AtomicIntegerFieldUpdater Kdi;
  private volatile int _resumed;
  
  static
  {
    AppMethodBeat.i(190043);
    Kdi = AtomicIntegerFieldUpdater.newUpdater(k.class, "_resumed");
    AppMethodBeat.o(190043);
  }
  
  public k(d<?> paramd, Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean fKN()
  {
    AppMethodBeat.i(190041);
    boolean bool = Kdi.compareAndSet(this, 0, 1);
    AppMethodBeat.o(190041);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.k
 * JD-Core Version:    0.7.0.1
 */