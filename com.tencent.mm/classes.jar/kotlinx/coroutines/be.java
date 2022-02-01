package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.g.b.p;
import d.k.h;
import d.v;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.y;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"})
public abstract class be
  extends bf
  implements as
{
  private static final AtomicReferenceFieldUpdater NIx = AtomicReferenceFieldUpdater.newUpdater(be.class, Object.class, "_queue");
  private static final AtomicReferenceFieldUpdater NIy = AtomicReferenceFieldUpdater.newUpdater(be.class, Object.class, "_delayed");
  volatile Object _delayed = null;
  private volatile int _isCompleted = 0;
  volatile Object _queue = null;
  
  private final boolean a(b paramb)
  {
    Object localObject = (c)this._delayed;
    if (localObject != null) {}
    for (localObject = (b)((c)localObject).gwj(); localObject == paramb; localObject = null) {
      return true;
    }
    return false;
  }
  
  private final boolean aX(Runnable paramRunnable)
  {
    Object localObject;
    kotlinx.coroutines.internal.l locall;
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
          if (NIx.compareAndSet(this, null, paramRunnable)) {
            return true;
          }
        }
        else
        {
          if (!(localObject instanceof kotlinx.coroutines.internal.l)) {
            break;
          }
          if (localObject == null) {
            throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
          }
          switch (((kotlinx.coroutines.internal.l)localObject).fZ(paramRunnable))
          {
          default: 
            break;
          case 0: 
            return true;
          case 2: 
            return false;
          }
          NIx.compareAndSet(this, localObject, ((kotlinx.coroutines.internal.l)localObject).gwd());
        }
      }
      if (localObject == bg.gvB()) {
        return false;
      }
      locall = new kotlinx.coroutines.internal.l(8, true);
      if (localObject == null) {
        throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
      }
      locall.fZ((Runnable)localObject);
      locall.fZ(paramRunnable);
    } while (!NIx.compareAndSet(this, localObject, locall));
    return true;
  }
  
  private final int b(long paramLong, b paramb)
  {
    if (this._isCompleted != 0) {
      return 1;
    }
    c localc = (c)this._delayed;
    Object localObject = localc;
    if (localc == null)
    {
      localObject = (be)this;
      NIy.compareAndSet(localObject, null, new c(paramLong));
      localObject = ((be)localObject)._delayed;
      if (localObject == null) {
        p.gfZ();
      }
      localObject = (c)localObject;
    }
    return paramb.a(paramLong, (c)localObject, this);
  }
  
  private final void gvx()
  {
    Object localObject = ck.NJi;
    long l;
    if (localObject != null) {
      l = ((cj)localObject).nanoTime();
    }
    for (;;)
    {
      localObject = (c)this._delayed;
      if (localObject != null)
      {
        localObject = (b)((c)localObject).gwk();
        if (localObject != null) {}
      }
      else
      {
        return;
        l = System.nanoTime();
        continue;
      }
      c(l, (b)localObject);
    }
  }
  
  public final void a(long paramLong, b paramb)
  {
    switch (b(paramLong, paramb))
    {
    default: 
      throw ((Throwable)new IllegalStateException("unexpected result".toString()));
    case 0: 
      if (a(paramb)) {
        gvz();
      }
    case 2: 
      return;
    }
    c(paramLong, paramb);
  }
  
  public final void a(long paramLong, k<? super d.z> paramk)
  {
    long l = bg.FD(paramLong);
    Object localObject;
    if (l < 4611686018427387903L)
    {
      localObject = ck.NJi;
      if (localObject == null) {
        break label68;
      }
    }
    label68:
    for (paramLong = ((cj)localObject).nanoTime();; paramLong = System.nanoTime())
    {
      localObject = new a(l + paramLong, paramk);
      n.a(paramk, (ba)localObject);
      a(paramLong, (b)localObject);
      return;
    }
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    aW(paramRunnable);
  }
  
  public final void aW(Runnable paramRunnable)
  {
    for (Object localObject = this;; localObject = ao.NIf) {
      if (((be)localObject).aX(paramRunnable))
      {
        ((be)localObject).gvz();
        return;
      }
    }
  }
  
  public final long gvr()
  {
    Object localObject4 = null;
    if (gvt()) {
      return gvs();
    }
    Object localObject5 = (c)this._delayed;
    Object localObject1;
    long l;
    if ((localObject5 != null) && (!((c)localObject5).isEmpty()))
    {
      localObject1 = ck.NJi;
      if (localObject1 == null) {
        break label123;
      }
      l = ((cj)localObject1).nanoTime();
    }
    for (;;)
    {
      synchronized ((y)localObject5)
      {
        localObject1 = ???.gwl();
        if (localObject1 == null)
        {
          localObject1 = null;
          if ((b)localObject1 != null) {
            continue;
          }
          localObject5 = this._queue;
          if (localObject5 == null)
          {
            localObject1 = localObject4;
            if (localObject1 != null) {
              ((Runnable)localObject1).run();
            }
            return gvs();
            label123:
            l = System.nanoTime();
          }
        }
        else
        {
          localObject1 = (b)localObject1;
          int i;
          if (l - ((b)localObject1).nanoTime >= 0L)
          {
            i = 1;
            if (i != 0)
            {
              bool = aX((Runnable)localObject1);
              if (!bool) {
                continue;
              }
              localObject1 = ???.alD(0);
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
      if ((localObject5 instanceof kotlinx.coroutines.internal.l))
      {
        if (localObject5 == null) {
          throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
        }
        localObject3 = ((kotlinx.coroutines.internal.l)localObject5).gvT();
        if (localObject3 != kotlinx.coroutines.internal.l.NJT) {
          localObject3 = (Runnable)localObject3;
        } else {
          NIx.compareAndSet(this, localObject5, ((kotlinx.coroutines.internal.l)localObject5).gwd());
        }
      }
      else
      {
        localObject3 = localObject4;
        if (localObject5 != bg.gvB()) {
          if (NIx.compareAndSet(this, localObject5, null))
          {
            if (localObject5 == null) {
              throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
            }
            localObject3 = (Runnable)localObject5;
          }
        }
      }
    }
  }
  
  protected final long gvs()
  {
    if (super.gvs() == 0L) {
      return 0L;
    }
    Object localObject = this._queue;
    if (localObject != null) {
      if ((localObject instanceof kotlinx.coroutines.internal.l))
      {
        if (!((kotlinx.coroutines.internal.l)localObject).isEmpty()) {
          return 0L;
        }
      }
      else
      {
        if (localObject == bg.gvB()) {
          return 9223372036854775807L;
        }
        return 0L;
      }
    }
    localObject = (c)this._delayed;
    if (localObject != null)
    {
      localObject = (b)((c)localObject).gwj();
      if (localObject != null) {}
    }
    else
    {
      return 9223372036854775807L;
    }
    long l2 = ((b)localObject).nanoTime;
    localObject = ck.NJi;
    if (localObject != null) {}
    for (long l1 = ((cj)localObject).nanoTime();; l1 = System.nanoTime()) {
      return h.aH(l2 - l1, 0L);
    }
  }
  
  protected final boolean isEmpty()
  {
    if (!gvv()) {
      return false;
    }
    Object localObject = (c)this._delayed;
    if ((localObject != null) && (!((c)localObject).isEmpty())) {
      return false;
    }
    localObject = this._queue;
    if (localObject == null) {
      return true;
    }
    if ((localObject instanceof kotlinx.coroutines.internal.l)) {
      return ((kotlinx.coroutines.internal.l)localObject).isEmpty();
    }
    return localObject == bg.gvB();
  }
  
  protected final void shutdown()
  {
    Object localObject1 = ci.NJh;
    ci.gvR();
    this._isCompleted = 1;
    if ((am.gvd()) && (this._isCompleted == 0)) {
      throw ((Throwable)new AssertionError());
    }
    label94:
    do
    {
      ((kotlinx.coroutines.internal.l)localObject2).fZ((Runnable)localObject1);
      if (!NIx.compareAndSet(this, localObject1, localObject2)) {
        do
        {
          localObject1 = this._queue;
          if (localObject1 != null) {
            break label94;
          }
          break;
        } while (!NIx.compareAndSet(this, null, bg.gvB()));
      }
      do
      {
        for (;;)
        {
          if (gvr() > 0L)
          {
            gvx();
            return;
            if (!(localObject1 instanceof kotlinx.coroutines.internal.l)) {
              break;
            }
            ((kotlinx.coroutines.internal.l)localObject1).close();
          }
        }
      } while (localObject1 == bg.gvB());
      Object localObject2 = new kotlinx.coroutines.internal.l(8, true);
    } while (localObject1 != null);
    throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"})
  final class a
    extends be.b
  {
    private final k<d.z> NIz;
    
    public a(k<? super d.z> paramk)
    {
      super();
      Object localObject;
      this.NIz = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(190700);
      this.NIz.a(be.this, d.z.MKo);
      AppMethodBeat.o(190700);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(190701);
      String str = super.toString() + this.NIz.toString();
      AppMethodBeat.o(190701);
      return str;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"})
  public static abstract class b
    implements Comparable<b>, Runnable, ba, kotlinx.coroutines.internal.z
  {
    private Object NIB;
    private int index;
    public long nanoTime;
    
    public b(long paramLong)
    {
      this.nanoTime = paramLong;
      this.index = -1;
    }
    
    public final int a(long paramLong, be.c paramc, be parambe)
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
          localObject1 = this.NIB;
          localObject2 = bg.gvA();
          if (localObject1 == localObject2)
          {
            i = 2;
            return i;
          }
          localObject1 = (y)paramc;
          localObject2 = (kotlinx.coroutines.internal.z)this;
          b localb;
          try
          {
            localb = (b)((y)localObject1).gwl();
            boolean bool = be.a(parambe);
            if (bool)
            {
              i = 1;
              continue;
            }
            if (localb == null)
            {
              paramc.NIC = paramLong;
              if (this.nanoTime - paramc.NIC < 0L) {
                this.nanoTime = paramc.NIC;
              }
              if (!am.gvd()) {
                break;
              }
              if (((kotlinx.coroutines.internal.z)localObject2).gvy() != null) {
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
          l = localb.nanoTime;
        }
        finally {}
        if (l - paramLong < 0L) {
          break label322;
        }
        label168:
        if (paramLong - paramc.NIC <= 0L) {
          break label326;
        }
        paramc.NIC = paramLong;
      }
      ((kotlinx.coroutines.internal.z)localObject2).a((y)localObject1);
      parambe = ((y)localObject1).NKp;
      if (parambe == null)
      {
        paramc = new kotlinx.coroutines.internal.z[4];
        ((y)localObject1).NKp = paramc;
      }
      for (;;)
      {
        i = ((y)localObject1)._size;
        ((y)localObject1)._size = (i + 1);
        paramc[i] = localObject2;
        ((kotlinx.coroutines.internal.z)localObject2).setIndex(i);
        ((y)localObject1).alE(i);
        i = 0;
        break;
        paramc = parambe;
        if (((y)localObject1)._size >= parambe.length)
        {
          paramc = Arrays.copyOf(parambe, ((y)localObject1)._size * 2);
          p.g(paramc, "java.util.Arrays.copyOf(this, newSize)");
          ((y)localObject1).NKp = ((kotlinx.coroutines.internal.z[])paramc);
          paramc = (kotlinx.coroutines.internal.z[])paramc;
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
    
    public final void a(y<?> paramy)
    {
      if (this.NIB != bg.gvA()) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
      }
      this.NIB = paramy;
    }
    
    /* Error */
    public final void dispose()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 73	kotlinx/coroutines/be$b:NIB	Ljava/lang/Object;
      //   6: astore_2
      //   7: invokestatic 79	kotlinx/coroutines/bg:gvA	()Lkotlinx/coroutines/internal/t;
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
      //   22: instanceof 90
      //   25: ifne +5 -> 30
      //   28: aconst_null
      //   29: astore_1
      //   30: aload_1
      //   31: checkcast 90	kotlinx/coroutines/be$c
      //   34: astore_1
      //   35: aload_1
      //   36: ifnull +12 -> 48
      //   39: aload_1
      //   40: aload_0
      //   41: checkcast 13	kotlinx/coroutines/internal/z
      //   44: invokevirtual 154	kotlinx/coroutines/be$c:a	(Lkotlinx/coroutines/internal/z;)Z
      //   47: pop
      //   48: aload_0
      //   49: invokestatic 79	kotlinx/coroutines/bg:gvA	()Lkotlinx/coroutines/internal/t;
      //   52: putfield 73	kotlinx/coroutines/be$b:NIB	Ljava/lang/Object;
      //   55: goto -39 -> 16
      //   58: astore_1
      //   59: aload_0
      //   60: monitorexit
      //   61: aload_1
      //   62: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	b
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
    
    public final y<?> gvy()
    {
      Object localObject2 = this.NIB;
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof y)) {
        localObject1 = null;
      }
      return (y)localObject1;
    }
    
    public final void setIndex(int paramInt)
    {
      this.index = paramInt;
    }
    
    public String toString()
    {
      return "Delayed[nanos=" + this.nanoTime + ']';
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"})
  public static final class c
    extends y<be.b>
  {
    public long NIC;
    
    public c(long paramLong)
    {
      this.NIC = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.be
 * JD-Core Version:    0.7.0.1
 */