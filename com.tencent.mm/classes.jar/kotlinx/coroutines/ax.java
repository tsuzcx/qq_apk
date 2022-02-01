package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.internal.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"})
final class ax<T>
  extends s<T>
{
  static final AtomicIntegerFieldUpdater TTC;
  volatile int _decision = 0;
  
  static
  {
    AppMethodBeat.i(192435);
    TTC = AtomicIntegerFieldUpdater.newUpdater(ax.class, "_decision");
    AppMethodBeat.o(192435);
  }
  
  public ax(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  private final boolean hMv()
  {
    AppMethodBeat.i(192432);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(192432);
        throw localThrowable;
      }
    } while (!TTC.compareAndSet(this, 0, 2));
    AppMethodBeat.o(192432);
    return true;
    AppMethodBeat.o(192432);
    return false;
  }
  
  public final void fM(Object paramObject)
  {
    AppMethodBeat.i(192434);
    if (hMv())
    {
      AppMethodBeat.o(192434);
      return;
    }
    aw.a(b.e(this.TWf), w.a(paramObject, this.TWf));
    AppMethodBeat.o(192434);
  }
  
  public final void fS(Object paramObject)
  {
    AppMethodBeat.i(192433);
    fM(paramObject);
    AppMethodBeat.o(192433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.ax
 * JD-Core Version:    0.7.0.1
 */