package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.LockSupport;
import kotlin.d.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
final class e<T>
  extends a<T>
{
  private final Thread abwf;
  private final bi abwg;
  
  public e(f paramf, Thread paramThread, bi parambi)
  {
    super(paramf, true);
    this.abwf = paramThread;
    this.abwg = parambi;
  }
  
  protected final void fU(Object paramObject)
  {
    AppMethodBeat.i(204797);
    if ((p.h(Thread.currentThread(), this.abwf) ^ true)) {
      LockSupport.unpark(this.abwf);
    }
    AppMethodBeat.o(204797);
  }
  
  protected final boolean iQJ()
  {
    return true;
  }
  
  public final T iQK()
  {
    AppMethodBeat.i(204798);
    try
    {
      Object localObject1 = this.abwg;
      if (localObject1 != null) {
        bi.a((bi)localObject1);
      }
      try
      {
        if (Thread.interrupted())
        {
          localObject1 = new InterruptedException();
          E((Throwable)localObject1);
          localObject1 = (Throwable)localObject1;
          throw ((Throwable)localObject1);
        }
      }
      finally
      {
        localObject5 = this.abwg;
        if (localObject5 != null) {
          bi.b((bi)localObject5);
        }
      }
      localObject4 = this.abwg;
    }
    finally
    {
      AppMethodBeat.o(204798);
    }
    if (localObject4 != null) {}
    for (long l = ((bi)localObject4).iRu();; l = 9223372036854775807L)
    {
      if (isCompleted()) {
        break label127;
      }
      if (cx.abxP != null) {
        break;
      }
      LockSupport.parkNanos(this, l);
      break;
    }
    label127:
    Object localObject4 = this.abwg;
    if (localObject4 != null) {
      bi.b((bi)localObject4);
    }
    Object localObject5 = cf.gl(iRJ());
    if (!(localObject5 instanceof x)) {}
    for (localObject4 = null;; localObject4 = localObject5)
    {
      localObject4 = (x)localObject4;
      if (localObject4 != null)
      {
        localObject4 = ((x)localObject4).cause;
        AppMethodBeat.o(204798);
        throw ((Throwable)localObject4);
      }
      AppMethodBeat.o(204798);
      return localObject5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.e
 * JD-Core Version:    0.7.0.1
 */