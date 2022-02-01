package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.d.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"})
public final class o
  extends v
{
  private static final AtomicIntegerFieldUpdater TTF;
  private volatile int _resumed;
  
  static
  {
    AppMethodBeat.i(192408);
    TTF = AtomicIntegerFieldUpdater.newUpdater(o.class, "_resumed");
    AppMethodBeat.o(192408);
  }
  
  public o(d<?> paramd, Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean hMA()
  {
    AppMethodBeat.i(192406);
    boolean bool = TTF.compareAndSet(this, 0, 1);
    AppMethodBeat.o(192406);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.o
 * JD-Core Version:    0.7.0.1
 */