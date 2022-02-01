package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""}, k=1, mv={1, 5, 1}, xi=48)
public class ae
{
  public final Throwable cause;
  
  static
  {
    AppMethodBeat.i(188881);
    ajvC = AtomicIntegerFieldUpdater.newUpdater(ae.class, "_handled");
    AppMethodBeat.o(188881);
  }
  
  public ae(Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean kBV()
  {
    AppMethodBeat.i(188889);
    boolean bool = ajvC.compareAndSet(this, 0, 1);
    AppMethodBeat.o(188889);
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
 * Qualified Name:     kotlinx.coroutines.ae
 * JD-Core Version:    0.7.0.1
 */