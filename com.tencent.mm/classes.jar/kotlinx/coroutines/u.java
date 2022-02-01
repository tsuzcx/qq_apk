package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""})
public class u
{
  private static final AtomicIntegerFieldUpdater OeT;
  private volatile int _handled;
  public final Throwable cause;
  
  static
  {
    AppMethodBeat.i(209241);
    OeT = AtomicIntegerFieldUpdater.newUpdater(u.class, "_handled");
    AppMethodBeat.o(209241);
  }
  
  public u(Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean gzA()
  {
    AppMethodBeat.i(209240);
    boolean bool = OeT.compareAndSet(this, 0, 1);
    AppMethodBeat.o(209240);
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