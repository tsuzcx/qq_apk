package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.d.f.c;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "toString", "", "kotlinx-coroutines-core"})
public final class ci
  extends ab
{
  public static final ci LSo;
  
  static
  {
    AppMethodBeat.i(118172);
    LSo = new ci();
    AppMethodBeat.o(118172);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(118171);
    paramf = (ck)paramf.get((f.c)ck.LSq);
    if (paramf != null)
    {
      paramf.LSp = true;
      AppMethodBeat.o(118171);
      return;
    }
    paramf = (Throwable)new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    AppMethodBeat.o(118171);
    throw paramf;
  }
  
  public final boolean gdB()
  {
    return false;
  }
  
  public final String toString()
  {
    return "Unconfined";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ci
 * JD-Core Version:    0.7.0.1
 */