package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""})
public class t
{
  private static final AtomicIntegerFieldUpdater LQS;
  private volatile int _handled;
  public final Throwable cause;
  
  static
  {
    AppMethodBeat.i(191140);
    LQS = AtomicIntegerFieldUpdater.newUpdater(t.class, "_handled");
    AppMethodBeat.o(191140);
  }
  
  public t(Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean gdy()
  {
    AppMethodBeat.i(191139);
    boolean bool = LQS.compareAndSet(this, 0, 1);
    AppMethodBeat.o(191139);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.t
 * JD-Core Version:    0.7.0.1
 */