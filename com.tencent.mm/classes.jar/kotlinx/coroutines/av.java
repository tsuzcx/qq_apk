package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.d;
import d.d.f;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.q;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"})
final class av<T>
  extends q<T>
{
  static final AtomicIntegerFieldUpdater LQH;
  volatile int _decision = 0;
  
  static
  {
    AppMethodBeat.i(191191);
    LQH = AtomicIntegerFieldUpdater.newUpdater(av.class, "_decision");
    AppMethodBeat.o(191191);
  }
  
  public av(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  private final boolean gdp()
  {
    AppMethodBeat.i(191188);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(191188);
        throw localThrowable;
      }
    } while (!LQH.compareAndSet(this, 0, 2));
    AppMethodBeat.o(191188);
    return true;
    AppMethodBeat.o(191188);
    return false;
  }
  
  public final void fC(Object paramObject)
  {
    AppMethodBeat.i(191190);
    if (gdp())
    {
      AppMethodBeat.o(191190);
      return;
    }
    au.a(b.d(this.LTe), u.b(paramObject, this.LTe));
    AppMethodBeat.o(191190);
  }
  
  public final void fI(Object paramObject)
  {
    AppMethodBeat.i(191189);
    fC(paramObject);
    AppMethodBeat.o(191189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.av
 * JD-Core Version:    0.7.0.1
 */