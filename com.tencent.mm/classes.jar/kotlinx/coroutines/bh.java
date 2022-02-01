package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.f;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.internal.aa;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.z;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"})
public abstract class bh
  extends bi
  implements at
{
  private static final AtomicReferenceFieldUpdater TUy = AtomicReferenceFieldUpdater.newUpdater(bh.class, Object.class, "_queue");
  private static final AtomicReferenceFieldUpdater TUz = AtomicReferenceFieldUpdater.newUpdater(bh.class, Object.class, "_delayed");
  volatile Object _delayed = null;
  private volatile int _isCompleted = 0;
  volatile Object _queue = null;
  
  private final boolean a(c paramc)
  {
    Object localObject = (d)this._delayed;
    if (localObject != null) {}
    for (localObject = (c)((d)localObject).hNS(); localObject == paramc; localObject = null) {
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
      localObject = (bh)this;
      TUz.compareAndSet(localObject, null, new d(paramLong));
      localObject = ((bh)localObject)._delayed;
      if (localObject == null) {
        p.hyc();
      }
      localObject = (d)localObject;
    }
    return paramc.a(paramLong, (d)localObject, this);
  }
  
  private final boolean be(Runnable paramRunnable)
  {
    Object localObject;
    m localm;
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
          if (TUy.compareAndSet(this, null, paramRunnable)) {
            return true;
          }
        }
        else
        {
          if (!(localObject instanceof m)) {
            break;
          }
          if (localObject == null) {
            throw new t("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
          }
          switch (((m)localObject).gh(paramRunnable))
          {
          default: 
            break;
          case 0: 
            return true;
          case 2: 
            return false;
          }
          TUy.compareAndSet(this, localObject, ((m)localObject).hNM());
        }
      }
      if (localObject == bj.hNi()) {
        return false;
      }
      localm = new m(8, true);
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
      }
      localm.gh((Runnable)localObject);
      localm.gh(paramRunnable);
    } while (!TUy.compareAndSet(this, localObject, localm));
    return true;
  }
  
  private final void hNe()
  {
    Object localObject = cr.TVl;
    long l;
    if (localObject != null) {
      l = ((cq)localObject).nanoTime();
    }
    for (;;)
    {
      localObject = (d)this._delayed;
      if (localObject != null)
      {
        localObject = (c)((d)localObject).hNT();
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
        hNg();
      }
    case 2: 
      return;
    }
    c(paramLong, paramc);
  }
  
  public final void a(long paramLong, k<? super x> paramk)
  {
    long l = bj.Pl(paramLong);
    Object localObject;
    if (l < 4611686018427387903L)
    {
      localObject = cr.TVl;
      if (localObject == null) {
        break label68;
      }
    }
    label68:
    for (paramLong = ((cq)localObject).nanoTime();; paramLong = System.nanoTime())
    {
      localObject = new a(l + paramLong, paramk);
      n.a(paramk, (bc)localObject);
      a(paramLong, (c)localObject);
      return;
    }
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    bd(paramRunnable);
  }
  
  public final void bd(Runnable paramRunnable)
  {
    for (Object localObject = this;; localObject = ap.TUg) {
      if (((bh)localObject).be(paramRunnable))
      {
        ((bh)localObject).hNg();
        return;
      }
    }
  }
  
  public bc d(long paramLong, Runnable paramRunnable)
  {
    return at.a.e(paramLong, paramRunnable);
  }
  
  public final long hMY()
  {
    Object localObject4 = null;
    if (hNa()) {
      return hMZ();
    }
    Object localObject5 = (d)this._delayed;
    Object localObject1;
    long l;
    if ((localObject5 != null) && (!((d)localObject5).isEmpty()))
    {
      localObject1 = cr.TVl;
      if (localObject1 == null) {
        break label123;
      }
      l = ((cq)localObject1).nanoTime();
    }
    for (;;)
    {
      synchronized ((z)localObject5)
      {
        localObject1 = ???.hNU();
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
            if (localObject1 != null) {
              ((Runnable)localObject1).run();
            }
            return hMZ();
            label123:
            l = System.nanoTime();
          }
        }
        else
        {
          localObject1 = (c)localObject1;
          int i;
          if (l - ((c)localObject1).nanoTime >= 0L)
          {
            i = 1;
            if (i != 0)
            {
              bool = be((Runnable)localObject1);
              if (!bool) {
                continue;
              }
              localObject1 = ???.avW(0);
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
      if ((localObject5 instanceof m))
      {
        if (localObject5 == null) {
          throw new t("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
        }
        localObject3 = ((m)localObject5).hNC();
        if (localObject3 != m.TVX) {
          localObject3 = (Runnable)localObject3;
        } else {
          TUy.compareAndSet(this, localObject5, ((m)localObject5).hNM());
        }
      }
      else
      {
        localObject3 = localObject4;
        if (localObject5 != bj.hNi()) {
          if (TUy.compareAndSet(this, localObject5, null))
          {
            if (localObject5 == null) {
              throw new t("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
            }
            localObject3 = (Runnable)localObject5;
          }
        }
      }
    }
  }
  
  protected final long hMZ()
  {
    if (super.hMZ() == 0L) {
      return 0L;
    }
    Object localObject = this._queue;
    if (localObject != null) {
      if ((localObject instanceof m))
      {
        if (!((m)localObject).isEmpty()) {
          return 0L;
        }
      }
      else
      {
        if (localObject == bj.hNi()) {
          return 9223372036854775807L;
        }
        return 0L;
      }
    }
    localObject = (d)this._delayed;
    if (localObject != null)
    {
      localObject = (c)((d)localObject).hNS();
      if (localObject != null) {}
    }
    else
    {
      return 9223372036854775807L;
    }
    long l2 = ((c)localObject).nanoTime;
    localObject = cr.TVl;
    if (localObject != null) {}
    for (long l1 = ((cq)localObject).nanoTime();; l1 = System.nanoTime()) {
      return j.aM(l2 - l1, 0L);
    }
  }
  
  protected final boolean isEmpty()
  {
    if (!hNc()) {
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
    if ((localObject instanceof m)) {
      return ((m)localObject).isEmpty();
    }
    return localObject == bj.hNi();
  }
  
  protected final void shutdown()
  {
    Object localObject1 = cp.TVk;
    cp.hNA();
    this._isCompleted = 1;
    if ((an.hMK()) && (this._isCompleted == 0)) {
      throw ((Throwable)new AssertionError());
    }
    label94:
    do
    {
      ((m)localObject2).gh((Runnable)localObject1);
      if (!TUy.compareAndSet(this, localObject1, localObject2)) {
        do
        {
          localObject1 = this._queue;
          if (localObject1 != null) {
            break label94;
          }
          break;
        } while (!TUy.compareAndSet(this, null, bj.hNi()));
      }
      do
      {
        for (;;)
        {
          if (hMY() > 0L)
          {
            hNe();
            return;
            if (!(localObject1 instanceof m)) {
              break;
            }
            ((m)localObject1).close();
          }
        }
      } while (localObject1 == bj.hNi());
      Object localObject2 = new m(8, true);
    } while (localObject1 != null);
    throw new t("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"})
  final class a
    extends bh.c
  {
    private final k<x> TUA;
    
    public a(k<? super x> paramk)
    {
      super();
      Object localObject;
      this.TUA = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(192319);
      this.TUA.a(bh.this, x.SXb);
      AppMethodBeat.o(192319);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(192320);
      String str = super.toString() + this.TUA.toString();
      AppMethodBeat.o(192320);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"})
  static final class b
    extends bh.c
  {
    private final Runnable TUC;
    
    public b(long paramLong, Runnable paramRunnable)
    {
      super();
      this.TUC = paramRunnable;
    }
    
    public final void run()
    {
      AppMethodBeat.i(192505);
      this.TUC.run();
      AppMethodBeat.o(192505);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(192506);
      String str = super.toString() + this.TUC.toString();
      AppMethodBeat.o(192506);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"})
  public static abstract class c
    implements Comparable<c>, Runnable, bc, aa
  {
    private Object TUD;
    private int index;
    public long nanoTime;
    
    public c(long paramLong)
    {
      this.nanoTime = paramLong;
      this.index = -1;
    }
    
    public final int a(long paramLong, bh.d paramd, bh parambh)
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
          localObject1 = this.TUD;
          localObject2 = bj.hNh();
          if (localObject1 == localObject2)
          {
            i = 2;
            return i;
          }
          localObject1 = (z)paramd;
          localObject2 = (aa)this;
          c localc;
          try
          {
            localc = (c)((z)localObject1).hNU();
            boolean bool = bh.a(parambh);
            if (bool)
            {
              i = 1;
              continue;
            }
            if (localc == null)
            {
              paramd.TUE = paramLong;
              if (this.nanoTime - paramd.TUE < 0L) {
                this.nanoTime = paramd.TUE;
              }
              if (!an.hMK()) {
                break;
              }
              if (((aa)localObject2).hNf() != null) {
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
          l = localc.nanoTime;
        }
        finally {}
        if (l - paramLong < 0L) {
          break label322;
        }
        label168:
        if (paramLong - paramd.TUE <= 0L) {
          break label326;
        }
        paramd.TUE = paramLong;
      }
      ((aa)localObject2).a((z)localObject1);
      parambh = ((z)localObject1).TWs;
      if (parambh == null)
      {
        paramd = new aa[4];
        ((z)localObject1).TWs = paramd;
      }
      for (;;)
      {
        i = ((z)localObject1)._size;
        ((z)localObject1)._size = (i + 1);
        paramd[i] = localObject2;
        ((aa)localObject2).setIndex(i);
        ((z)localObject1).avX(i);
        i = 0;
        break;
        paramd = parambh;
        if (((z)localObject1)._size >= parambh.length)
        {
          paramd = Arrays.copyOf(parambh, ((z)localObject1)._size * 2);
          p.g(paramd, "java.util.Arrays.copyOf(this, newSize)");
          ((z)localObject1).TWs = ((aa[])paramd);
          paramd = (aa[])paramd;
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
    
    public final void a(z<?> paramz)
    {
      if (this.TUD != bj.hNh()) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
      }
      this.TUD = paramz;
    }
    
    /* Error */
    public final void dispose()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 73	kotlinx/coroutines/bh$c:TUD	Ljava/lang/Object;
      //   6: astore_2
      //   7: invokestatic 79	kotlinx/coroutines/bj:hNh	()Lkotlinx/coroutines/internal/u;
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
      //   31: checkcast 90	kotlinx/coroutines/bh$d
      //   34: astore_1
      //   35: aload_1
      //   36: ifnull +12 -> 48
      //   39: aload_1
      //   40: aload_0
      //   41: checkcast 13	kotlinx/coroutines/internal/aa
      //   44: invokevirtual 154	kotlinx/coroutines/bh$d:a	(Lkotlinx/coroutines/internal/aa;)Z
      //   47: pop
      //   48: aload_0
      //   49: invokestatic 79	kotlinx/coroutines/bj:hNh	()Lkotlinx/coroutines/internal/u;
      //   52: putfield 73	kotlinx/coroutines/bh$c:TUD	Ljava/lang/Object;
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
    
    public final z<?> hNf()
    {
      Object localObject2 = this.TUD;
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof z)) {
        localObject1 = null;
      }
      return (z)localObject1;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"})
  public static final class d
    extends z<bh.c>
  {
    public long TUE;
    
    public d(long paramLong)
    {
      this.TUE = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bh
 * JD-Core Version:    0.7.0.1
 */