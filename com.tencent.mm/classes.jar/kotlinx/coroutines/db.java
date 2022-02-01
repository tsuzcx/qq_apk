package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlinx.coroutines.internal.y;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/TimeoutCoroutine;", "U", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "time", "", "uCont", "Lkotlin/coroutines/Continuation;", "(JLkotlin/coroutines/Continuation;)V", "nameString", "", "nameString$kotlinx_coroutines_core", "run", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class db<U, T extends U>
  extends y<T>
  implements Runnable
{
  public final long time;
  
  public db(long paramLong, d<? super U> paramd)
  {
    super(paramd.getContext(), paramd);
    AppMethodBeat.i(188993);
    this.time = paramLong;
    AppMethodBeat.o(188993);
  }
  
  public final String kBu()
  {
    AppMethodBeat.i(189008);
    String str = super.kBu() + "(timeMillis=" + this.time + ')';
    AppMethodBeat.o(189008);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(188999);
    long l = this.time;
    cb localcb = (cb)this;
    U((Throwable)new da("Timed out waiting for " + l + " ms", localcb));
    AppMethodBeat.o(188999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.db
 * JD-Core Version:    0.7.0.1
 */