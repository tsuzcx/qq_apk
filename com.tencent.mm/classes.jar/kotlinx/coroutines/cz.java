package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.d;
import kotlin.l;
import kotlinx.coroutines.internal.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/TimeoutCoroutine;", "U", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "time", "", "uCont", "Lkotlin/coroutines/Continuation;", "(JLkotlin/coroutines/Continuation;)V", "nameString", "", "nameString$kotlinx_coroutines_core", "run", "", "kotlinx-coroutines-core"})
final class cz<U, T extends U>
  extends t<T>
  implements Runnable
{
  public final long time;
  
  public cz(long paramLong, d<? super U> paramd)
  {
    super(paramd.getContext(), paramd);
    AppMethodBeat.i(204907);
    this.time = paramLong;
    AppMethodBeat.o(204907);
  }
  
  public final String iQG()
  {
    AppMethodBeat.i(204906);
    String str = super.iQG() + "(timeMillis=" + this.time + ')';
    AppMethodBeat.o(204906);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(204905);
    long l = this.time;
    by localby = (by)this;
    E((Throwable)new cy("Timed out waiting for " + l + " ms", localby));
    AppMethodBeat.o(204905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.cz
 * JD-Core Version:    0.7.0.1
 */