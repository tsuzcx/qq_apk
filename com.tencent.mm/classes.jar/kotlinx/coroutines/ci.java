package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.d;
import d.d.f;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.a.z;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"})
final class ci<T>
  extends z<T>
{
  static final AtomicIntegerFieldUpdater Kdg;
  volatile int _decision = 0;
  
  static
  {
    AppMethodBeat.i(202345);
    Kdg = AtomicIntegerFieldUpdater.newUpdater(ci.class, "_decision");
    AppMethodBeat.o(202345);
  }
  
  public ci(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  private final boolean fKI()
  {
    AppMethodBeat.i(202342);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(202342);
        throw localThrowable;
      }
    } while (!Kdg.compareAndSet(this, 0, 2));
    AppMethodBeat.o(202342);
    return true;
    AppMethodBeat.o(202342);
    return false;
  }
  
  public final void gg(Object paramObject)
  {
    AppMethodBeat.i(202344);
    if (fKI())
    {
      AppMethodBeat.o(202344);
      return;
    }
    aq.a(b.d(this.LEJ), r.b(paramObject, this.LEJ));
    AppMethodBeat.o(202344);
  }
  
  public final void gi(Object paramObject)
  {
    AppMethodBeat.i(202343);
    gg(paramObject);
    AppMethodBeat.o(202343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.ci
 * JD-Core Version:    0.7.0.1
 */