package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""})
public class x
{
  private static final AtomicIntegerFieldUpdater abws;
  volatile int _handled;
  public final Throwable cause;
  
  static
  {
    AppMethodBeat.i(204124);
    abws = AtomicIntegerFieldUpdater.newUpdater(x.class, "_handled");
    AppMethodBeat.o(204124);
  }
  
  public x(Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean iRa()
  {
    AppMethodBeat.i(204123);
    boolean bool = abws.compareAndSet(this, 0, 1);
    AppMethodBeat.o(204123);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.x
 * JD-Core Version:    0.7.0.1
 */