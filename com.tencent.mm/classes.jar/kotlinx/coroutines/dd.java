package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.d.f.c;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class dd
  extends al
{
  public static final dd ajwQ;
  
  static
  {
    AppMethodBeat.i(118172);
    ajwQ = new dd();
    AppMethodBeat.o(118172);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(118171);
    paramf = (dg)paramf.get((f.c)dg.ajwU);
    if (paramf != null)
    {
      paramf.ajwV = true;
      AppMethodBeat.o(118171);
      return;
    }
    paramf = new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    AppMethodBeat.o(118171);
    throw paramf;
  }
  
  public final boolean kBY()
  {
    return false;
  }
  
  public final String toString()
  {
    return "Dispatchers.Unconfined";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.dd
 * JD-Core Version:    0.7.0.1
 */