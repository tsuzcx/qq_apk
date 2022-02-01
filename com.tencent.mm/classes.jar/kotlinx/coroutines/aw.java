package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.d;
import d.d.f;
import d.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.r;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"})
final class aw<T>
  extends r<T>
{
  static final AtomicIntegerFieldUpdater OeI;
  volatile int _decision = 0;
  
  static
  {
    AppMethodBeat.i(209293);
    OeI = AtomicIntegerFieldUpdater.newUpdater(aw.class, "_decision");
    AppMethodBeat.o(209293);
  }
  
  public aw(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  private final boolean gzr()
  {
    AppMethodBeat.i(209290);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(209290);
        throw localThrowable;
      }
    } while (!OeI.compareAndSet(this, 0, 2));
    AppMethodBeat.o(209290);
    return true;
    AppMethodBeat.o(209290);
    return false;
  }
  
  public final void fI(Object paramObject)
  {
    AppMethodBeat.i(209292);
    if (gzr())
    {
      AppMethodBeat.o(209292);
      return;
    }
    av.a(b.d(this.Ohh), v.b(paramObject, this.Ohh));
    AppMethodBeat.o(209292);
  }
  
  public final void fO(Object paramObject)
  {
    AppMethodBeat.i(209291);
    fI(paramObject);
    AppMethodBeat.o(209291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.aw
 * JD-Core Version:    0.7.0.1
 */