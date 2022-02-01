package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends ae
{
  static
  {
    AppMethodBeat.i(188762);
    ajvs = AtomicIntegerFieldUpdater.newUpdater(t.class, "_resumed");
    AppMethodBeat.o(188762);
  }
  
  public t(d<?> paramd, Throwable paramThrowable, boolean paramBoolean) {}
  
  public final boolean kBK()
  {
    AppMethodBeat.i(188768);
    boolean bool = ajvs.compareAndSet(this, 0, 1);
    AppMethodBeat.o(188768);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.t
 * JD-Core Version:    0.7.0.1
 */