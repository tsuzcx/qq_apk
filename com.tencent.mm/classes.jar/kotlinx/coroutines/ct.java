package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.d;
import kotlin.l;
import kotlinx.coroutines.internal.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/TimeoutCoroutine;", "U", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "time", "", "uCont", "Lkotlin/coroutines/Continuation;", "(JLkotlin/coroutines/Continuation;)V", "nameString", "", "nameString$kotlinx_coroutines_core", "run", "", "kotlinx-coroutines-core"})
final class ct<U, T extends U>
  extends s<T>
  implements Runnable
{
  public final long time;
  
  public ct(long paramLong, d<? super U> paramd)
  {
    super(paramd.getContext(), paramd);
    AppMethodBeat.i(192509);
    this.time = paramLong;
    AppMethodBeat.o(192509);
  }
  
  public final String hMo()
  {
    AppMethodBeat.i(192508);
    String str = super.hMo() + "(timeMillis=" + this.time + ')';
    AppMethodBeat.o(192508);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(192507);
    long l = this.time;
    bu localbu = (bu)this;
    D((Throwable)new cs("Timed out waiting for " + l + " ms", localbu));
    AppMethodBeat.o(192507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.ct
 * JD-Core Version:    0.7.0.1
 */