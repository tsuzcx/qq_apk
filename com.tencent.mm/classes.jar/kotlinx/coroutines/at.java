package kotlinx.coroutines;

import a.f.a.b;
import a.l;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.a.j.a;
import kotlinx.coroutines.a.j.b;
import kotlinx.coroutines.a.q;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/EventLoopBase;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlinx/coroutines/EventLoop;", "()V", "_delayed", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopBase$DelayedTask;", "_queue", "", "isCompleted", "", "()Z", "isDelayedEmpty", "isEmpty", "isQueueEmpty", "nextTime", "", "getNextTime", "()J", "closeQueue", "", "dequeue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "enqueueImpl", "task", "execute", "execute$kotlinx_coroutines_core", "isCorrectThread", "processNextEvent", "removeDelayedImpl", "delayedTask", "removeDelayedImpl$kotlinx_coroutines_core", "rescheduleAllDelayed", "resetAll", "schedule", "schedule$kotlinx_coroutines_core", "scheduleImpl", "", "scheduleResumeAfterDelay", "timeMillis", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldUnpark", "unpark", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "kotlinx-coroutines-core"})
public abstract class at
  extends w
  implements aj, as
{
  private static final AtomicReferenceFieldUpdater CHX = AtomicReferenceFieldUpdater.newUpdater(at.class, Object.class, "CHW");
  private static final AtomicReferenceFieldUpdater CHZ = AtomicReferenceFieldUpdater.newUpdater(at.class, Object.class, "CHY");
  volatile Object CHW = null;
  volatile Object CHY = null;
  
  private final boolean aD(Runnable paramRunnable)
  {
    Object localObject;
    kotlinx.coroutines.a.j localj;
    do
    {
      for (;;)
      {
        localObject = this.CHW;
        if (localObject == null)
        {
          if (CHX.compareAndSet(this, null, paramRunnable)) {
            return true;
          }
        }
        else
        {
          if (!(localObject instanceof kotlinx.coroutines.a.j)) {
            break;
          }
          if (localObject == null) {
            throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
          }
          switch (((kotlinx.coroutines.a.j)localObject).ej(paramRunnable))
          {
          default: 
            break;
          case 0: 
            return true;
          case 2: 
            return false;
          }
          CHX.compareAndSet(this, localObject, ((kotlinx.coroutines.a.j)localObject).eqm());
        }
      }
      if (localObject == au.epP()) {
        return false;
      }
      localj = new kotlinx.coroutines.a.j(8, true);
      if (localObject == null) {
        throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
      }
      localj.ej((Runnable)localObject);
      localj.ej(paramRunnable);
    } while (!CHX.compareAndSet(this, localObject, localj));
    return true;
  }
  
  private final boolean epK()
  {
    Object localObject = this.CHW;
    if (localObject == null) {
      return true;
    }
    if ((localObject instanceof kotlinx.coroutines.a.j)) {
      return ((kotlinx.coroutines.a.j)localObject).isEmpty();
    }
    return localObject == au.epP();
  }
  
  private final boolean epL()
  {
    q localq = (q)this.CHY;
    return (localq == null) || (localq.isEmpty());
  }
  
  public final void a(a.c.e parame, Runnable paramRunnable)
  {
    a.f.b.j.q(parame, "context");
    a.f.b.j.q(paramRunnable, "block");
    aC(paramRunnable);
  }
  
  public final void a(i<? super y> parami)
  {
    a.f.b.j.q(parami, "continuation");
    at.b localb = (at.b)new a(parami);
    for (parami = this;; parami = ag.CHJ)
    {
      a.f.b.j.q(localb, "delayedTask");
      q localq = (q)parami.CHY;
      Object localObject = localq;
      if (localq == null)
      {
        localObject = (at)parami;
        CHZ.compareAndSet(localObject, null, new q());
        localObject = ((at)localObject).CHY;
        if (localObject == null) {
          a.f.b.j.ebi();
        }
        localObject = (q)localObject;
      }
      switch (localb.a((q)localObject, parami))
      {
      default: 
        throw ((Throwable)new IllegalStateException("unexpected result".toString()));
      case 0: 
        localObject = (q)parami.CHY;
        if (localObject != null)
        {
          localObject = (at.b)((q)localObject).eqp();
          if (localObject != localb) {
            break label174;
          }
        }
      case 2: 
        label174:
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            parami.epC();
          }
          return;
          localObject = null;
          break;
        }
      }
    }
  }
  
  public final void aC(Runnable paramRunnable)
  {
    for (Object localObject = this;; localObject = ag.CHJ)
    {
      a.f.b.j.q(paramRunnable, "task");
      if (((at)localObject).aD(paramRunnable))
      {
        ((at)localObject).epC();
        return;
      }
    }
  }
  
  protected abstract void epC();
  
  public final long epM()
  {
    Object localObject4 = (q)this.CHY;
    long l;
    if ((localObject4 != null) && (!((q)localObject4).isEmpty())) {
      l = bs.eqa().nanoTime();
    }
    for (;;)
    {
      Object localObject6;
      int i;
      try
      {
        Object localObject1 = ((q)localObject4).eqq();
        if (localObject1 == null)
        {
          localObject1 = null;
          if ((at.b)localObject1 != null) {
            break;
          }
          localObject6 = this.CHW;
          if (localObject6 != null) {
            break label198;
          }
          localObject1 = null;
          if (localObject1 != null) {
            ((Runnable)localObject1).run();
          }
          localObject1 = this.CHW;
          if (localObject1 == null) {
            break label533;
          }
          if (!(localObject1 instanceof kotlinx.coroutines.a.j)) {
            break label519;
          }
          if (((kotlinx.coroutines.a.j)localObject1).isEmpty()) {
            break label533;
          }
          return 0L;
        }
        localObject1 = (at.b)localObject1;
        if (l - ((at.b)localObject1).nanoTime >= 0L)
        {
          i = 1;
          if (i != 0)
          {
            bool = aD((Runnable)localObject1);
            if (!bool) {
              continue;
            }
            localObject1 = ((q)localObject4).Wi(0);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        boolean bool = false;
        continue;
        localObject1 = null;
        continue;
        if (!(localObject6 instanceof kotlinx.coroutines.a.j)) {
          break label467;
        }
      }
      finally {}
      label198:
      if (localObject6 == null) {
        throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
      }
      localObject4 = (kotlinx.coroutines.a.j)localObject6;
      label228:
      l = ((kotlinx.coroutines.a.j)localObject4).CJm;
      if ((0x0 & l) != 0L) {
        localObject3 = kotlinx.coroutines.a.j.CJq;
      }
      for (;;)
      {
        if (localObject3 == kotlinx.coroutines.a.j.CJq) {
          break label446;
        }
        localObject3 = (Runnable)localObject3;
        break;
        i = (int)((0x3FFFFFFF & l) >> 0);
        if (((int)((0xC0000000 & l) >> 30) & kotlinx.coroutines.a.j.a((kotlinx.coroutines.a.j)localObject4)) == (kotlinx.coroutines.a.j.a((kotlinx.coroutines.a.j)localObject4) & i))
        {
          localObject3 = null;
        }
        else
        {
          localObject3 = kotlinx.coroutines.a.j.b((kotlinx.coroutines.a.j)localObject4).get(kotlinx.coroutines.a.j.a((kotlinx.coroutines.a.j)localObject4) & i);
          if (localObject3 == null)
          {
            if (!kotlinx.coroutines.a.j.c((kotlinx.coroutines.a.j)localObject4)) {
              break label228;
            }
            localObject3 = null;
            continue;
          }
          if ((localObject3 instanceof j.b))
          {
            localObject3 = null;
          }
          else
          {
            int j = i + 1 & 0x3FFFFFFF;
            Object localObject5 = kotlinx.coroutines.a.j.CJn;
            j.a locala = kotlinx.coroutines.a.j.CJr;
            if (((AtomicLongFieldUpdater)localObject5).compareAndSet(localObject4, l, j.a.N(l, j)))
            {
              kotlinx.coroutines.a.j.b((kotlinx.coroutines.a.j)localObject4).set(kotlinx.coroutines.a.j.a((kotlinx.coroutines.a.j)localObject4) & i, null);
            }
            else
            {
              if (!kotlinx.coroutines.a.j.c((kotlinx.coroutines.a.j)localObject4)) {
                break label228;
              }
              localObject4 = (kotlinx.coroutines.a.j)localObject4;
              do
              {
                localObject5 = kotlinx.coroutines.a.j.a((kotlinx.coroutines.a.j)localObject4, i, j);
                localObject4 = localObject5;
              } while (localObject5 != null);
            }
          }
        }
      }
      label446:
      CHX.compareAndSet(this, localObject6, ((kotlinx.coroutines.a.j)localObject6).eqm());
      continue;
      label467:
      if (localObject6 == au.epP())
      {
        localObject3 = null;
      }
      else if (CHX.compareAndSet(this, localObject6, null))
      {
        if (localObject6 == null) {
          throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
        }
        localObject3 = (Runnable)localObject6;
      }
    }
    label519:
    if (localObject3 == au.epP()) {
      return 9223372036854775807L;
    }
    return 0L;
    label533:
    Object localObject3 = (q)this.CHY;
    if (localObject3 == null) {
      return 9223372036854775807L;
    }
    localObject3 = (at.b)((q)localObject3).eqp();
    if (localObject3 == null) {
      return 9223372036854775807L;
    }
    return a.i.e.ak(((at.b)localObject3).nanoTime - bs.eqa().nanoTime(), 0L);
  }
  
  protected final boolean isEmpty()
  {
    return (epK()) && (epL());
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/EventLoopBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopBase$DelayedTask;", "timeMillis", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"})
  final class a
    extends at.b
  {
    private final i<y> CIa;
    
    public a()
    {
      AppMethodBeat.i(118575);
      this.CIa = ((i)localObject);
      this$1 = this.CIa;
      Object localObject = (ap)this;
      a.f.b.j.q(at.this, "receiver$0");
      a.f.b.j.q(localObject, "handle");
      at.this.k((b)new aq((ap)localObject));
      AppMethodBeat.o(118575);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118574);
      this.CIa.a(at.this, y.BMg);
      AppMethodBeat.o(118574);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.at
 * JD-Core Version:    0.7.0.1
 */