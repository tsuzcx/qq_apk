package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"})
public final class o
  extends u
{
  private static final AtomicIntegerFieldUpdater OeL;
  private volatile int _resumed;
  
  static
  {
    AppMethodBeat.i(209266);
    OeL = AtomicIntegerFieldUpdater.newUpdater(o.class, "_resumed");
    AppMethodBeat.o(209266);
  }
  
  public o(d<?> paramd, Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean gzw()
  {
    AppMethodBeat.i(209264);
    boolean bool = OeL.compareAndSet(this, 0, 1);
    AppMethodBeat.o(209264);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.o
 * JD-Core Version:    0.7.0.1
 */