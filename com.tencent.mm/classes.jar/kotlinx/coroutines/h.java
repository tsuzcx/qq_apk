package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class h<T>
  extends a<T>
{
  private final Thread ajvm;
  private final bm ajvn;
  
  public h(f paramf, Thread paramThread, bm parambm)
  {
    super(paramf, true);
    this.ajvm = paramThread;
    this.ajvn = parambm;
  }
  
  protected final void iw(Object paramObject)
  {
    AppMethodBeat.i(188807);
    if (!s.p(Thread.currentThread(), this.ajvm))
    {
      paramObject = this.ajvm;
      if (c.ajvf == null) {
        LockSupport.unpark(paramObject);
      }
    }
    AppMethodBeat.o(188807);
  }
  
  protected final boolean kBx()
  {
    return true;
  }
  
  public final T kBy()
  {
    AppMethodBeat.i(188817);
    try
    {
      Object localObject1 = this.ajvn;
      if (localObject1 != null) {
        bm.a((bm)localObject1);
      }
      try
      {
        if (Thread.interrupted())
        {
          localObject1 = new InterruptedException();
          U((Throwable)localObject1);
          localObject1 = (Throwable)localObject1;
          throw ((Throwable)localObject1);
        }
      }
      finally
      {
        localObject5 = this.ajvn;
        if (localObject5 != null) {
          bm.b((bm)localObject5);
        }
      }
      localObject4 = this.ajvn;
    }
    finally
    {
      AppMethodBeat.o(188817);
    }
    if (localObject4 == null) {}
    for (long l = 9223372036854775807L;; l = ((bm)localObject4).kCk())
    {
      if (isCompleted()) {
        break label127;
      }
      if (c.ajvf != null) {
        break;
      }
      LockSupport.parkNanos(this, l);
      break;
    }
    label127:
    Object localObject4 = this.ajvn;
    if (localObject4 != null) {
      bm.b((bm)localObject4);
    }
    Object localObject5 = cj.iN(kCy());
    if ((localObject5 instanceof ae)) {}
    for (localObject4 = (ae)localObject5; localObject4 != null; localObject4 = null)
    {
      localObject4 = ((ae)localObject4).cause;
      AppMethodBeat.o(188817);
      throw ((Throwable)localObject4);
    }
    AppMethodBeat.o(188817);
    return localObject5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.h
 * JD-Core Version:    0.7.0.1
 */