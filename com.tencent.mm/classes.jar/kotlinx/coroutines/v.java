package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""})
public class v
{
  private static final AtomicIntegerFieldUpdater TTN;
  private volatile int _handled;
  public final Throwable cause;
  
  static
  {
    AppMethodBeat.i(192376);
    TTN = AtomicIntegerFieldUpdater.newUpdater(v.class, "_handled");
    AppMethodBeat.o(192376);
  }
  
  public v(Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean hME()
  {
    AppMethodBeat.i(192375);
    boolean bool = TTN.compareAndSet(this, 0, 1);
    AppMethodBeat.o(192375);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.v
 * JD-Core Version:    0.7.0.1
 */