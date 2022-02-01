package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.f;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.internal.aa;
import kotlinx.coroutines.internal.ab;
import kotlinx.coroutines.internal.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"})
public abstract class bj
  extends bk
  implements av
{
  private static final AtomicReferenceFieldUpdater abxb = AtomicReferenceFieldUpdater.newUpdater(bj.class, Object.class, "_queue");
  private static final AtomicReferenceFieldUpdater abxc = AtomicReferenceFieldUpdater.newUpdater(bj.class, Object.class, "_delayed");
  private volatile Object _delayed = null;
  private volatile int _isCompleted = 0;
  private volatile Object _queue = null;
  
  private final boolean a(c paramc)
  {
    Object localObject = (d)this._delayed;
    if (localObject != null) {}
    for (localObject = (c)((d)localObject).iSY(); localObject == paramc; localObject = null) {
      return true;
    }
    return false;
  }
  
  private final int b(long paramLong, c paramc)
  {
    if (this._isCompleted != 0) {
      return 1;
    }
    d locald = (d)this._delayed;
    Object localObject = locald;
    if (locald == null)
    {
      localObject = (bj)this;
      abxc.compareAndSet(localObject, null, new d(paramLong));
      localObject = ((bj)localObject)._delayed;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      localObject = (d)localObject;
    }
    return paramc.a(paramLong, (d)localObject, this);
  }
  
  private final boolean bm(Runnable paramRunnable)
  {
    Object localObject;
    n localn;
    do
    {
      for (;;)
      {
        localObject = this._queue;
        if (this._isCompleted != 0) {
          return false;
        }
        if (localObject == null)
        {
          if (abxb.compareAndSet(this, null, paramRunnable)) {
            return true;
          }
        }
        else
        {
          if (!(localObject instanceof n)) {
            break;
          }
          if (localObject == null) {
            throw new t("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
          }
          switch (((n)localObject).gz(paramRunnable))
          {
          default: 
            break;
          case 0: 
            return true;
          case 2: 
            return false;
          }
          abxb.compareAndSet(this, localObject, ((n)localObject).iSS());
        }
      }
      if (localObject == bl.iRD()) {
        return false;
      }
      localn = new n(8, true);
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
      }
      localn.gz((Runnable)localObject);
      localn.gz(paramRunnable);
    } while (!abxb.compareAndSet(this, localObject, localn));
    return true;
  }
  
  private final void iRz()
  {
    Object localObject = cx.abxP;
    long l;
    if (localObject != null) {
      l = ((cw)localObject).nanoTime();
    }
    for (;;)
    {
      localObject = (d)this._delayed;
      if (localObject != null)
      {
        localObject = (c)((d)localObject).iSZ();
        if (localObject != null) {}
      }
      else
      {
        return;
        l = System.nanoTime();
        continue;
      }
      c(l, (c)localObject);
    }
  }
  
  public final void a(long paramLong, c paramc)
  {
    switch (b(paramLong, paramc))
    {
    default: 
      throw ((Throwable)new IllegalStateException("unexpected result".toString()));
    case 0: 
      if (a(paramc)) {
        iRB();
      }
    case 2: 
      return;
    }
    c(paramLong, paramc);
  }
  
  public final void a(long paramLong, m<? super x> paramm)
  {
    long l = bl.XB(paramLong);
    Object localObject;
    if (l < 4611686018427387903L)
    {
      localObject = cx.abxP;
      if (localObject == null) {
        break label68;
      }
    }
    label68:
    for (paramLong = ((cw)localObject).nanoTime();; paramLong = System.nanoTime())
    {
      localObject = new a(l + paramLong, paramm);
      p.a(paramm, (be)localObject);
      a(paramLong, (c)localObject);
      return;
    }
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    bl(paramRunnable);
  }
  
  public final void bl(Runnable paramRunnable)
  {
    for (Object localObject = this;; localObject = ar.abwJ) {
      if (((bj)localObject).bm(paramRunnable))
      {
        ((bj)localObject).iRB();
        return;
      }
    }
  }
  
  public be d(long paramLong, Runnable paramRunnable)
  {
    return av.a.e(paramLong, paramRunnable);
  }
  
  protected final long dMN()
  {
    if (super.dMN() == 0L) {
      return 0L;
    }
    Object localObject = this._queue;
    if (localObject != null) {
      if ((localObject instanceof n))
      {
        if (!((n)localObject).isEmpty()) {
          return 0L;
        }
      }
      else
      {
        if (localObject == bl.iRD()) {
          return 9223372036854775807L;
        }
        return 0L;
      }
    }
    localObject = (d)this._delayed;
    if (localObject != null)
    {
      localObject = (c)((d)localObject).iSY();
      if (localObject != null) {}
    }
    else
    {
      return 9223372036854775807L;
    }
    long l2 = ((c)localObject).abxh;
    localObject = cx.abxP;
    if (localObject != null) {}
    for (long l1 = ((cw)localObject).nanoTime();; l1 = System.nanoTime()) {
      return i.be(l2 - l1, 0L);
    }
  }
  
  public final long iRu()
  {
    Object localObject4 = null;
    if (iRv()) {
      return 0L;
    }
    Object localObject5 = (d)this._delayed;
    Object localObject1;
    long l;
    if ((localObject5 != null) && (!((d)localObject5).isEmpty()))
    {
      localObject1 = cx.abxP;
      if (localObject1 == null) {
        break label117;
      }
      l = ((cw)localObject1).nanoTime();
    }
    for (;;)
    {
      synchronized ((aa)localObject5)
      {
        localObject1 = ???.iTa();
        if (localObject1 == null)
        {
          localObject1 = null;
          if ((c)localObject1 != null) {
            continue;
          }
          localObject5 = this._queue;
          if (localObject5 == null)
          {
            localObject1 = localObject4;
            if (localObject1 == null) {
              break;
            }
            ((Runnable)localObject1).run();
            return 0L;
            label117:
            l = System.nanoTime();
          }
        }
        else
        {
          localObject1 = (c)localObject1;
          int i;
          if (l - ((c)localObject1).abxh >= 0L)
          {
            i = 1;
            if (i != 0)
            {
              bool = bm((Runnable)localObject1);
              if (!bool) {
                continue;
              }
              localObject1 = ???.aFR(0);
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
        }
      }
      Object localObject3;
      if ((localObject5 instanceof n))
      {
        if (localObject5 == null) {
          throw new t("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
        }
        localObject3 = ((n)localObject5).iSD();
        if (localObject3 != n.abzo) {
          localObject3 = (Runnable)localObject3;
        } else {
          abxb.compareAndSet(this, localObject5, ((n)localObject5).iSS());
        }
      }
      else
      {
        localObject3 = localObject4;
        if (localObject5 != bl.iRD()) {
          if (abxb.compareAndSet(this, localObject5, null))
          {
            if (localObject5 == null) {
              throw new t("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
            }
            localObject3 = (Runnable)localObject5;
          }
        }
      }
    }
    return dMN();
  }
  
  protected final void iRy()
  {
    this._queue = null;
    this._delayed = null;
  }
  
  protected final boolean isEmpty()
  {
    if (!iRx()) {
      return false;
    }
    Object localObject = (d)this._delayed;
    if ((localObject != null) && (!((d)localObject).isEmpty())) {
      return false;
    }
    localObject = this._queue;
    if (localObject == null) {
      return true;
    }
    if ((localObject instanceof n)) {
      return ((n)localObject).isEmpty();
    }
    return localObject == bl.iRD();
  }
  
  protected final void shutdown()
  {
    Object localObject1 = cv.abxO;
    cv.iRZ();
    this._isCompleted = 1;
    if ((ap.iRg()) && (this._isCompleted == 0)) {
      throw ((Throwable)new AssertionError());
    }
    label94:
    do
    {
      ((n)localObject2).gz((Runnable)localObject1);
      if (!abxb.compareAndSet(this, localObject1, localObject2)) {
        do
        {
          localObject1 = this._queue;
          if (localObject1 != null) {
            break label94;
          }
          break;
        } while (!abxb.compareAndSet(this, null, bl.iRD()));
      }
      do
      {
        for (;;)
        {
          if (iRu() > 0L)
          {
            iRz();
            return;
            if (!(localObject1 instanceof n)) {
              break;
            }
            ((n)localObject1).close();
          }
        }
      } while (localObject1 == bl.iRD());
      Object localObject2 = new n(8, true);
    } while (localObject1 != null);
    throw new t("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"})
  final class a
    extends bj.c
  {
    private final m<x> abxd;
    
    public a(m<? super x> paramm)
    {
      super();
      Object localObject;
      this.abxd = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(204805);
      this.abxd.a(bj.this, x.aazN);
      AppMethodBeat.o(204805);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204806);
      String str = super.toString() + this.abxd.toString();
      AppMethodBeat.o(204806);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"})
  static final class b
    extends bj.c
  {
    private final Runnable abxf;
    
    public b(long paramLong, Runnable paramRunnable)
    {
      super();
      this.abxf = paramRunnable;
    }
    
    public final void run()
    {
      AppMethodBeat.i(204645);
      this.abxf.run();
      AppMethodBeat.o(204645);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204647);
      String str = super.toString() + this.abxf.toString();
      AppMethodBeat.o(204647);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"})
  public static abstract class c
    implements Comparable<c>, Runnable, be, ab
  {
    private Object abxg;
    public long abxh;
    private int index;
    
    public c(long paramLong)
    {
      this.abxh = paramLong;
      this.index = -1;
    }
    
    public final int a(long paramLong, bj.d paramd, bj parambj)
    {
      Object localObject1;
      Object localObject2;
      int i;
      label84:
      label125:
      long l;
      for (;;)
      {
        try
        {
          localObject1 = this.abxg;
          localObject2 = bl.iRC();
          if (localObject1 == localObject2)
          {
            i = 2;
            return i;
          }
          localObject1 = (aa)paramd;
          localObject2 = (ab)this;
          c localc;
          try
          {
            localc = (c)((aa)localObject1).iTa();
            boolean bool = bj.a(parambj);
            if (bool)
            {
              i = 1;
              continue;
            }
            if (localc == null)
            {
              paramd.abxi = paramLong;
              if (this.abxh - paramd.abxi < 0L) {
                this.abxh = paramd.abxi;
              }
              if (!ap.iRg()) {
                break;
              }
              if (((ab)localObject2).iRA() != null) {
                break label328;
              }
              i = 1;
              if (i != 0) {
                break;
              }
              throw ((Throwable)new AssertionError());
            }
          }
          finally {}
          l = localc.abxh;
        }
        finally {}
        if (l - paramLong < 0L) {
          break label322;
        }
        label168:
        if (paramLong - paramd.abxi <= 0L) {
          break label326;
        }
        paramd.abxi = paramLong;
      }
      ((ab)localObject2).a((aa)localObject1);
      parambj = ((aa)localObject1).abzJ;
      if (parambj == null)
      {
        paramd = new ab[4];
        ((aa)localObject1).abzJ = paramd;
      }
      for (;;)
      {
        i = ((aa)localObject1)._size;
        ((aa)localObject1)._size = (i + 1);
        paramd[i] = localObject2;
        ((ab)localObject2).setIndex(i);
        ((aa)localObject1).aFS(i);
        i = 0;
        break;
        paramd = parambj;
        if (((aa)localObject1)._size >= parambj.length)
        {
          paramd = Arrays.copyOf(parambj, ((aa)localObject1)._size * 2);
          kotlin.g.b.p.j(paramd, "java.util.Arrays.copyOf(this, newSize)");
          ((aa)localObject1).abzJ = ((ab[])paramd);
          paramd = (ab[])paramd;
          continue;
          label322:
          paramLong = l;
          break label168;
          label326:
          break label84;
          label328:
          i = 0;
          break label125;
        }
      }
    }
    
    public final void a(aa<?> paramaa)
    {
      if (this.abxg != bl.iRC()) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
      }
      this.abxg = paramaa;
    }
    
    /* Error */
    public final void dispose()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 74	kotlinx/coroutines/bj$c:abxg	Ljava/lang/Object;
      //   6: astore_2
      //   7: invokestatic 80	kotlinx/coroutines/bl:iRC	()Lkotlinx/coroutines/internal/v;
      //   10: astore_1
      //   11: aload_2
      //   12: aload_1
      //   13: if_acmpne +6 -> 19
      //   16: aload_0
      //   17: monitorexit
      //   18: return
      //   19: aload_2
      //   20: astore_1
      //   21: aload_2
      //   22: instanceof 91
      //   25: ifne +5 -> 30
      //   28: aconst_null
      //   29: astore_1
      //   30: aload_1
      //   31: checkcast 91	kotlinx/coroutines/bj$d
      //   34: astore_1
      //   35: aload_1
      //   36: ifnull +12 -> 48
      //   39: aload_1
      //   40: aload_0
      //   41: checkcast 13	kotlinx/coroutines/internal/ab
      //   44: invokevirtual 155	kotlinx/coroutines/bj$d:a	(Lkotlinx/coroutines/internal/ab;)Z
      //   47: pop
      //   48: aload_0
      //   49: invokestatic 80	kotlinx/coroutines/bl:iRC	()Lkotlinx/coroutines/internal/v;
      //   52: putfield 74	kotlinx/coroutines/bj$c:abxg	Ljava/lang/Object;
      //   55: goto -39 -> 16
      //   58: astore_1
      //   59: aload_0
      //   60: monitorexit
      //   61: aload_1
      //   62: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	c
      //   10	30	1	localObject1	Object
      //   58	4	1	localObject2	Object
      //   6	16	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   2	11	58	finally
      //   21	28	58	finally
      //   30	35	58	finally
      //   39	48	58	finally
      //   48	55	58	finally
    }
    
    public final int getIndex()
    {
      return this.index;
    }
    
    public final aa<?> iRA()
    {
      Object localObject2 = this.abxg;
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof aa)) {
        localObject1 = null;
      }
      return (aa)localObject1;
    }
    
    public final void setIndex(int paramInt)
    {
      this.index = paramInt;
    }
    
    public String toString()
    {
      return "Delayed[nanos=" + this.abxh + ']';
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"})
  public static final class d
    extends aa<bj.c>
  {
    public long abxi;
    
    public d(long paramLong)
    {
      this.abxi = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.bj
 * JD-Core Version:    0.7.0.1
 */