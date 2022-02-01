package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""})
public class q
{
  private static final AtomicIntegerFieldUpdater Kdq;
  private volatile int _handled;
  public final Throwable cause;
  
  static
  {
    AppMethodBeat.i(190028);
    Kdq = AtomicIntegerFieldUpdater.newUpdater(q.class, "_handled");
    AppMethodBeat.o(190028);
  }
  
  public q(Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean fKR()
  {
    AppMethodBeat.i(190027);
    boolean bool = Kdq.compareAndSet(this, 0, 1);
    AppMethodBeat.o(190027);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(118157);
    String str = getClass().getSimpleName() + '[' + this.cause + ']';
    AppMethodBeat.o(118157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.q
 * JD-Core Version:    0.7.0.1
 */