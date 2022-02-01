package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.d;
import d.d.f;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.r;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"})
final class aw<T>
  extends r<T>
{
  static final AtomicIntegerFieldUpdater NHC;
  volatile int _decision = 0;
  
  static
  {
    AppMethodBeat.i(190802);
    NHC = AtomicIntegerFieldUpdater.newUpdater(aw.class, "_decision");
    AppMethodBeat.o(190802);
  }
  
  public aw(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  private final boolean guP()
  {
    AppMethodBeat.i(190799);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(190799);
        throw localThrowable;
      }
    } while (!NHC.compareAndSet(this, 0, 2));
    AppMethodBeat.o(190799);
    return true;
    AppMethodBeat.o(190799);
    return false;
  }
  
  public final void fF(Object paramObject)
  {
    AppMethodBeat.i(190801);
    if (guP())
    {
      AppMethodBeat.o(190801);
      return;
    }
    av.a(b.d(this.NKb), v.b(paramObject, this.NKb));
    AppMethodBeat.o(190801);
  }
  
  public final void fL(Object paramObject)
  {
    AppMethodBeat.i(190800);
    fF(paramObject);
    AppMethodBeat.o(190800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.aw
 * JD-Core Version:    0.7.0.1
 */