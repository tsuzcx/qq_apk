package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "toString", "", "kotlinx-coroutines-core"})
public final class cv
  extends ad
{
  public static final cv TVn;
  
  static
  {
    AppMethodBeat.i(118172);
    TVn = new cv();
    AppMethodBeat.o(118172);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(118171);
    paramf = (cx)paramf.get((f.c)cx.TVp);
    if (paramf != null)
    {
      paramf.TVo = true;
      AppMethodBeat.o(118171);
      return;
    }
    paramf = (Throwable)new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    AppMethodBeat.o(118171);
    throw paramf;
  }
  
  public final boolean hMH()
  {
    return false;
  }
  
  public final String toString()
  {
    return "Unconfined";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.cv
 * JD-Core Version:    0.7.0.1
 */