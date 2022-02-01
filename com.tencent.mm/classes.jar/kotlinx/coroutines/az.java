package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.internal.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"})
final class az<T>
  extends t<T>
{
  static final AtomicIntegerFieldUpdater abwh;
  volatile int _decision = 0;
  
  static
  {
    AppMethodBeat.i(204755);
    abwh = AtomicIntegerFieldUpdater.newUpdater(az.class, "_decision");
    AppMethodBeat.o(204755);
  }
  
  public az(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  private final boolean iQQ()
  {
    AppMethodBeat.i(204752);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(204752);
        throw localThrowable;
      }
    } while (!abwh.compareAndSet(this, 0, 2));
    AppMethodBeat.o(204752);
    return true;
    AppMethodBeat.o(204752);
    return false;
  }
  
  public final void fT(Object paramObject)
  {
    AppMethodBeat.i(204754);
    if (iQQ())
    {
      AppMethodBeat.o(204754);
      return;
    }
    ay.a(b.k(this.abzw), y.b(paramObject, this.abzw));
    AppMethodBeat.o(204754);
  }
  
  public final void fU(Object paramObject)
  {
    AppMethodBeat.i(204753);
    fT(paramObject);
    AppMethodBeat.o(204753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.az
 * JD-Core Version:    0.7.0.1
 */