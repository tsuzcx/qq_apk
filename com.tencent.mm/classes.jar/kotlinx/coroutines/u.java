package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""})
public class u
{
  private static final AtomicIntegerFieldUpdater NHN;
  private volatile int _handled;
  public final Throwable cause;
  
  static
  {
    AppMethodBeat.i(190750);
    NHN = AtomicIntegerFieldUpdater.newUpdater(u.class, "_handled");
    AppMethodBeat.o(190750);
  }
  
  public u(Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean guY()
  {
    AppMethodBeat.i(190749);
    boolean bool = NHN.compareAndSet(this, 0, 1);
    AppMethodBeat.o(190749);
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
 * Qualified Name:     kotlinx.coroutines.u
 * JD-Core Version:    0.7.0.1
 */