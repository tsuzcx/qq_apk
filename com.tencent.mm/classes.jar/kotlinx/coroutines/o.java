package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"})
public final class o
  extends u
{
  private static final AtomicIntegerFieldUpdater NHF;
  private volatile int _resumed;
  
  static
  {
    AppMethodBeat.i(190775);
    NHF = AtomicIntegerFieldUpdater.newUpdater(o.class, "_resumed");
    AppMethodBeat.o(190775);
  }
  
  public o(d<?> paramd, Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean guU()
  {
    AppMethodBeat.i(190773);
    boolean bool = NHF.compareAndSet(this, 0, 1);
    AppMethodBeat.o(190773);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.o
 * JD-Core Version:    0.7.0.1
 */