package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.y;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"}, k=1, mv={1, 5, 1}, xi=48)
public final class bc<T>
  extends y<T>
{
  static
  {
    AppMethodBeat.i(188841);
    ajvo = AtomicIntegerFieldUpdater.newUpdater(bc.class, "_decision");
    AppMethodBeat.o(188841);
  }
  
  public bc(f paramf, d<? super T> paramd)
  {
    super(paramf, paramd);
  }
  
  private final boolean kBE()
  {
    AppMethodBeat.i(188835);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(188835);
        throw localThrowable;
      }
    } while (!ajvo.compareAndSet(this, 0, 2));
    AppMethodBeat.o(188835);
    return true;
    AppMethodBeat.o(188835);
    return false;
  }
  
  public final void iv(Object paramObject)
  {
    AppMethodBeat.i(188855);
    if (kBE())
    {
      AppMethodBeat.o(188855);
      return;
    }
    i.a(b.au(this.ajzY), ai.e(paramObject, this.ajzY));
    AppMethodBeat.o(188855);
  }
  
  public final void iw(Object paramObject)
  {
    AppMethodBeat.i(188848);
    iv(paramObject);
    AppMethodBeat.o(188848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bc
 * JD-Core Version:    0.7.0.1
 */