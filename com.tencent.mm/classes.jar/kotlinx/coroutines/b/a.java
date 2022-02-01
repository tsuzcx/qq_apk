package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.j.c;
import d.k.h;
import d.z;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.am;
import kotlinx.coroutines.internal.t;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"})
public final class a
  implements Closeable, Executor
{
  public static final a NKA;
  static final AtomicLongFieldUpdater NKt;
  static final AtomicLongFieldUpdater NKv;
  private static final AtomicIntegerFieldUpdater NKw;
  public static final t NKz;
  public final int LVa;
  public final e NKr;
  public final e NKs;
  public final AtomicReferenceArray<b> NKu;
  public final long NKx;
  public final String NKy;
  volatile int _isTerminated;
  volatile long controlState;
  public final int ddL;
  volatile long parkedWorkersStack;
  
  static
  {
    AppMethodBeat.i(118011);
    NKA = new a((byte)0);
    NKz = new t("NOT_IN_STACK");
    NKt = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
    NKv = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    NKw = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    AppMethodBeat.o(118011);
  }
  
  public a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(118005);
    this.ddL = paramInt1;
    this.LVa = paramInt2;
    this.NKx = paramLong;
    this.NKy = paramString;
    if (this.ddL > 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Core pool size " + this.ddL + " should be at least 1").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.LVa >= this.ddL) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.LVa + " should be greater than or equals to core pool size " + this.ddL).toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.LVa <= 2097150) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.LVa + " should not exceed maximal supported number of threads 2097150").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.NKx > 0L) {}
    for (paramInt1 = i; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Idle worker keep alive time " + this.NKx + " must be positive").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    this.NKr = new e();
    this.NKs = new e();
    this.parkedWorkersStack = 0L;
    this.NKu = new AtomicReferenceArray(this.LVa + 1);
    this.controlState = (this.ddL << 42);
    this._isTerminated = 0;
    AppMethodBeat.o(118005);
  }
  
  private final boolean FH(long paramLong)
  {
    AppMethodBeat.i(190740);
    if (h.lp((int)(0x1FFFFF & paramLong) - (int)((0xFFE00000 & paramLong) >> 21), 0) < this.ddL)
    {
      int i = gwp();
      if ((i == 1) && (this.ddL > 1)) {
        gwp();
      }
      if (i > 0)
      {
        AppMethodBeat.o(190740);
        return true;
      }
    }
    AppMethodBeat.o(190740);
    return false;
  }
  
  private static int a(b paramb)
  {
    for (paramb = paramb.nextParkedWorker;; paramb = paramb.nextParkedWorker)
    {
      if (paramb == NKz) {
        return -1;
      }
      if (paramb == null) {
        return 0;
      }
      paramb = (b)paramb;
      int i = paramb.indexInArray;
      if (i != 0) {
        return i;
      }
    }
  }
  
  public static i a(Runnable paramRunnable, j paramj)
  {
    AppMethodBeat.i(117999);
    long l = l.NLc.nanoTime();
    if ((paramRunnable instanceof i))
    {
      ((i)paramRunnable).NKW = l;
      ((i)paramRunnable).NKX = paramj;
      paramRunnable = (i)paramRunnable;
      AppMethodBeat.o(117999);
      return paramRunnable;
    }
    paramRunnable = (i)new k(paramRunnable, l, paramj);
    AppMethodBeat.o(117999);
    return paramRunnable;
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(118004);
    try
    {
      parami.run();
      return;
    }
    catch (Throwable parami)
    {
      Thread localThread = Thread.currentThread();
      localThread.getUncaughtExceptionHandler().uncaughtException(localThread, parami);
      return;
    }
    finally
    {
      AppMethodBeat.o(118004);
    }
  }
  
  private final b gwm()
  {
    AppMethodBeat.i(117994);
    long l;
    int i;
    b localb;
    do
    {
      l = this.parkedWorkersStack;
      i = (int)(0x1FFFFF & l);
      localb = (b)this.NKu.get(i);
      if (localb == null)
      {
        AppMethodBeat.o(117994);
        return null;
      }
      i = a(localb);
    } while ((i < 0) || (!NKt.compareAndSet(this, l, 0xFFE00000 & 2097152L + l | i)));
    localb.nextParkedWorker = NKz;
    AppMethodBeat.o(117994);
    return localb;
  }
  
  private final boolean gwo()
  {
    AppMethodBeat.i(118001);
    b localb;
    do
    {
      localb = gwm();
      if (localb == null)
      {
        AppMethodBeat.o(118001);
        return false;
      }
    } while (!b.NKD.compareAndSet(localb, -1, 0));
    LockSupport.unpark((Thread)localb);
    AppMethodBeat.o(118001);
    return true;
  }
  
  private final int gwp()
  {
    int j = 0;
    AppMethodBeat.i(118002);
    int k;
    int m;
    for (;;)
    {
      synchronized (this.NKu)
      {
        i = this._isTerminated;
        if (i != 0)
        {
          AppMethodBeat.o(118002);
          return -1;
        }
        long l = this.controlState;
        i = (int)(l & 0x1FFFFF);
        k = h.lp(i - (int)((l & 0xFFE00000) >> 21), 0);
        m = this.ddL;
        if (k >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = this.LVa;
        if (i >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = (int)(this.controlState & 0x1FFFFF) + 1;
        if ((m > 0) && (this.NKu.get(m) == null))
        {
          i = 1;
          if (i != 0) {
            break;
          }
          Throwable localThrowable = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
          AppMethodBeat.o(118002);
          throw localThrowable;
        }
      }
      i = 0;
    }
    Object localObject2 = new b(m);
    this.NKu.set(m, localObject2);
    int i = j;
    if (m == (int)(NKv.incrementAndGet(this) & 0x1FFFFF)) {
      i = 1;
    }
    if (i == 0)
    {
      localObject2 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(118002);
      throw ((Throwable)localObject2);
    }
    ((b)localObject2).start();
    AppMethodBeat.o(118002);
    return k + 1;
  }
  
  private final b gwq()
  {
    AppMethodBeat.i(190742);
    Thread localThread = Thread.currentThread();
    Object localObject = localThread;
    if (!(localThread instanceof b)) {
      localObject = null;
    }
    localObject = (b)localObject;
    if (localObject != null)
    {
      if (p.i(((b)localObject).NKI, (a)this))
      {
        AppMethodBeat.o(190742);
        return localObject;
      }
      AppMethodBeat.o(190742);
      return null;
    }
    AppMethodBeat.o(190742);
    return null;
  }
  
  public final void a(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(117997);
    paramj = a(paramRunnable, paramj);
    b localb = gwq();
    int i;
    if (localb == null)
    {
      paramRunnable = paramj;
      if (paramRunnable == null) {
        break label193;
      }
      if (paramRunnable.NKX.gww() != 1) {
        break label174;
      }
      i = 1;
      label48:
      if (i == 0) {
        break label180;
      }
    }
    label174:
    label180:
    for (boolean bool = this.NKs.fY(paramRunnable);; bool = this.NKr.fY(paramRunnable))
    {
      if (bool) {
        break label193;
      }
      paramRunnable = (Throwable)new RejectedExecutionException(this.NKy + " was terminated");
      AppMethodBeat.o(117997);
      throw paramRunnable;
      if (localb.NKC == c.NKN)
      {
        paramRunnable = paramj;
        break;
      }
      if ((paramj.NKX.gww() == 0) && (localb.NKC == c.NKK))
      {
        paramRunnable = paramj;
        break;
      }
      localb.NKH = true;
      paramRunnable = localb.NKB.a(paramj, paramBoolean);
      break;
      i = 0;
      break label48;
    }
    label193:
    if ((paramBoolean) && (localb != null)) {
      i = j;
    }
    while (paramj.NKX.gww() == 0) {
      if (i != 0)
      {
        AppMethodBeat.o(117997);
        return;
        i = 0;
      }
      else
      {
        gwn();
        AppMethodBeat.o(117997);
        return;
      }
    }
    long l = NKv.addAndGet(this, 2097152L);
    if ((i == 0) && (!gwo()) && (!FH(l))) {
      gwo();
    }
    AppMethodBeat.o(117997);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190738);
    for (;;)
    {
      long l = this.parkedWorkersStack;
      int i = (int)(0x1FFFFF & l);
      if (i == paramInt1) {
        if (paramInt2 == 0) {
          i = a(paramb);
        }
      }
      while ((i >= 0) && (NKt.compareAndSet(this, l, 2097152L + l & 0xFFE00000 | i)))
      {
        AppMethodBeat.o(190738);
        return;
        i = paramInt2;
      }
    }
  }
  
  public final void close()
  {
    int k = 1;
    AppMethodBeat.i(117996);
    if (NKw.compareAndSet(this, 0, 1))
    {
      b localb = gwq();
      for (;;)
      {
        int m;
        synchronized (this.NKu)
        {
          long l = this.controlState;
          m = (int)(l & 0x1FFFFF);
          if (m <= 0) {
            break;
          }
          i = 1;
          ??? = this.NKu.get(i);
          if (??? == null) {
            p.gfZ();
          }
          ??? = (b)???;
          if (??? == localb) {
            break label198;
          }
          if (((b)???).isAlive())
          {
            LockSupport.unpark((Thread)???);
            ((b)???).join(10000L);
          }
        }
        if (localObject3 == c.NKN) {}
        for (int j = 1; j == 0; j = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(117996);
          throw ((Throwable)???);
        }
        ((b)???).NKB.a(this.NKs);
        label198:
        if (i == m) {
          break;
        }
        i += 1;
      }
      this.NKs.close();
      this.NKr.close();
      if (localb != null)
      {
        localObject3 = localb.Av(true);
        ??? = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        ??? = (i)this.NKr.gvT();
      }
      Object localObject3 = ???;
      if (??? == null) {
        localObject3 = (i)this.NKs.gvT();
      }
      if (localObject3 == null)
      {
        if (localb != null) {
          localb.a(c.NKN);
        }
        if (!am.gvd()) {
          break label364;
        }
        if ((int)((this.controlState & 0x0) >> 42) != this.ddL) {
          break label359;
        }
      }
      label359:
      for (int i = k;; i = 0)
      {
        if (i != 0) {
          break label364;
        }
        ??? = (Throwable)new AssertionError();
        AppMethodBeat.o(117996);
        throw ((Throwable)???);
        a((i)localObject3);
        break;
      }
      label364:
      this.parkedWorkersStack = 0L;
      this.controlState = 0L;
    }
    AppMethodBeat.o(117996);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(117995);
    a(this, paramRunnable);
    AppMethodBeat.o(117995);
  }
  
  public final void gwn()
  {
    AppMethodBeat.i(190739);
    if (gwo())
    {
      AppMethodBeat.o(190739);
      return;
    }
    if (a(this))
    {
      AppMethodBeat.o(190739);
      return;
    }
    gwo();
    AppMethodBeat.o(190739);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118003);
    Object localObject1 = new ArrayList();
    int i3 = this.NKu.length();
    int k = 1;
    int i = 0;
    int j = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    if (k < i3)
    {
      Object localObject2 = (b)this.NKu.get(k);
      if (localObject2 == null) {}
      for (;;)
      {
        k += 1;
        break;
        int i4 = ((b)localObject2).NKB.gwy();
        localObject2 = ((b)localObject2).NKC;
        switch (b.cpQ[localObject2.ordinal()])
        {
        default: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
          int i2;
          do
          {
            break;
            m += 1;
            break;
            n += 1;
            ((Collection)localObject1).add(String.valueOf(i4) + "b");
            break;
            i1 += 1;
            ((Collection)localObject1).add(String.valueOf(i4) + "c");
            break;
            i2 = j + 1;
            j = i2;
          } while (i4 <= 0);
          ((Collection)localObject1).add(String.valueOf(i4) + "d");
          j = i2;
          break;
        case 5: 
          i += 1;
        }
      }
    }
    long l = this.controlState;
    localObject1 = this.NKy + '@' + Integer.toHexString(System.identityHashCode(this)) + '[' + "Pool Size {core = " + this.ddL + ", max = " + this.LVa + "}, Worker States {CPU = " + i1 + ", blocking = " + n + ", parked = " + m + ", dormant = " + j + ", terminated = " + i + "}, running workers queues = " + localObject1 + ", global CPU queue size = " + this.NKr.getSize() + ", global blocking queue size = " + this.NKs.getSize() + ", Control State {created workers= " + (int)(0x1FFFFF & l) + ", blocking tasks = " + (int)((0xFFE00000 & l) >> 21) + ", CPUs acquired = " + (this.ddL - (int)((0x0 & l) >> 42)) + "}]";
    AppMethodBeat.o(118003);
    return localObject1;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"})
  public final class b
    extends Thread
  {
    static final AtomicIntegerFieldUpdater NKD;
    public final n NKB;
    public a.c NKC;
    private long NKE;
    private long NKF;
    private int NKG;
    public boolean NKH;
    volatile int indexInArray;
    volatile Object nextParkedWorker;
    volatile int workerCtl;
    
    static
    {
      AppMethodBeat.i(118028);
      NKD = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");
      AppMethodBeat.o(118028);
    }
    
    private b()
    {
      AppMethodBeat.i(118026);
      setDaemon(true);
      this.NKB = new n();
      this.NKC = a.c.NKM;
      this.workerCtl = 0;
      this.nextParkedWorker = a.NKz;
      this$1 = c.MMe;
      this.NKG = c.MMc.nextInt();
      AppMethodBeat.o(118026);
    }
    
    public b()
    {
      this();
      AppMethodBeat.i(118027);
      int i;
      alG(i);
      AppMethodBeat.o(118027);
    }
    
    private final i Aw(boolean paramBoolean)
    {
      AppMethodBeat.i(190745);
      if (paramBoolean)
      {
        if (alH(this.NKI.ddL * 2) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          locali = gwu();
          if (locali == null) {
            break;
          }
          AppMethodBeat.o(190745);
          return locali;
        }
        locali = this.NKB.gwz();
        if (locali != null)
        {
          AppMethodBeat.o(190745);
          return locali;
        }
        if (i == 0)
        {
          locali = gwu();
          if (locali != null)
          {
            AppMethodBeat.o(190745);
            return locali;
          }
        }
      }
      else
      {
        locali = gwu();
        if (locali != null)
        {
          AppMethodBeat.o(190745);
          return locali;
        }
      }
      i locali = Ax(false);
      AppMethodBeat.o(190745);
      return locali;
    }
    
    private final i Ax(boolean paramBoolean)
    {
      AppMethodBeat.i(190747);
      Object localObject;
      if (am.gvd())
      {
        if (this.NKB.gwy() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          localObject = (Throwable)new AssertionError();
          AppMethodBeat.o(190747);
          throw ((Throwable)localObject);
        }
      }
      int m = a.b(this.NKI);
      if (m < 2)
      {
        AppMethodBeat.o(190747);
        return null;
      }
      int i = alH(m);
      long l1 = 9223372036854775807L;
      int j = 0;
      if (j < m)
      {
        i += 1;
        if (i <= m) {
          break label301;
        }
        i = 1;
      }
      label301:
      for (;;)
      {
        localObject = (b)this.NKI.NKu.get(i);
        if ((localObject != null) && (localObject != (b)this))
        {
          if (am.gvd())
          {
            if (this.NKB.gwy() == 0) {}
            for (int k = 1; k == 0; k = 0)
            {
              localObject = (Throwable)new AssertionError();
              AppMethodBeat.o(190747);
              throw ((Throwable)localObject);
            }
          }
          if (paramBoolean) {}
          for (long l2 = this.NKB.b(((b)localObject).NKB); l2 == -1L; l2 = this.NKB.a(((b)localObject).NKB))
          {
            localObject = this.NKB.gwz();
            AppMethodBeat.o(190747);
            return localObject;
          }
          if (l2 > 0L) {
            l1 = Math.min(l1, l2);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (l1 != 9223372036854775807L) {}
          for (;;)
          {
            this.NKF = l1;
            AppMethodBeat.o(190747);
            return null;
            l1 = 0L;
          }
        }
      }
    }
    
    private void alG(int paramInt)
    {
      AppMethodBeat.i(118015);
      StringBuilder localStringBuilder = new StringBuilder().append(this.NKI.NKy).append("-worker-");
      if (paramInt == 0) {}
      for (String str = "TERMINATED";; str = String.valueOf(paramInt))
      {
        setName(str);
        this.indexInArray = paramInt;
        AppMethodBeat.o(118015);
        return;
      }
    }
    
    private int alH(int paramInt)
    {
      int i = this.NKG;
      i ^= i << 13;
      i ^= i >> 17;
      i ^= i << 5;
      this.NKG = i;
      int j = paramInt - 1;
      if ((j & paramInt) == 0) {
        return i & j;
      }
      return (i & 0x7FFFFFFF) % paramInt;
    }
    
    private final boolean gwr()
    {
      AppMethodBeat.i(118017);
      if (this.NKC == a.c.NKJ)
      {
        AppMethodBeat.o(118017);
        return true;
      }
      a locala = this.NKI;
      long l = locala.controlState;
      if ((int)((0x0 & l) >> 42) == 0) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label91;
        }
        this.NKC = a.c.NKJ;
        AppMethodBeat.o(118017);
        return true;
        if (!a.NKv.compareAndSet(locala, l, l - 4398046511104L)) {
          break;
        }
      }
      label91:
      AppMethodBeat.o(118017);
      return false;
    }
    
    private final void gws()
    {
      AppMethodBeat.i(190743);
      int j;
      int i;
      if (!gwt())
      {
        ??? = this.NKI;
        if (this.nextParkedWorker == a.NKz)
        {
          long l;
          int k;
          do
          {
            l = ((a)???).parkedWorkersStack;
            j = (int)(0x1FFFFF & l);
            k = this.indexInArray;
            if (am.gvd())
            {
              if (k != 0) {}
              for (i = 1; i == 0; i = 0)
              {
                ??? = (Throwable)new AssertionError();
                AppMethodBeat.o(190743);
                throw ((Throwable)???);
              }
            }
            this.nextParkedWorker = ((a)???).NKu.get(j);
          } while (!a.NKt.compareAndSet(???, l, k | 2097152L + l & 0xFFE00000));
        }
        AppMethodBeat.o(190743);
        return;
      }
      if (am.gvd())
      {
        if (this.NKB.gwy() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(190743);
          throw ((Throwable)???);
        }
      }
      this.workerCtl = -1;
      while ((gwt()) && (this.NKI._isTerminated == 0) && (this.NKC != a.c.NKN))
      {
        a(a.c.NKL);
        Thread.interrupted();
        if (this.NKE == 0L) {
          this.NKE = (System.nanoTime() + this.NKI.NKx);
        }
        LockSupport.parkNanos(this.NKI.NKx);
        if (System.nanoTime() - this.NKE >= 0L)
        {
          this.NKE = 0L;
          synchronized (this.NKI.NKu)
          {
            i = this.NKI._isTerminated;
            if (i == 0)
            {
              i = a.b(this.NKI);
              j = this.NKI.ddL;
              if (i > j)
              {
                boolean bool = NKD.compareAndSet(this, -1, 1);
                if (bool)
                {
                  i = this.indexInArray;
                  alG(0);
                  this.NKI.a(this, i, 0);
                  Object localObject2 = this.NKI;
                  j = (int)(a.NKv.getAndDecrement(localObject2) & 0x1FFFFF);
                  if (j != i)
                  {
                    localObject2 = this.NKI.NKu.get(j);
                    if (localObject2 == null) {
                      p.gfZ();
                    }
                    localObject2 = (b)localObject2;
                    this.NKI.NKu.set(i, localObject2);
                    ((b)localObject2).alG(i);
                    this.NKI.a((b)localObject2, j, i);
                  }
                  this.NKI.NKu.set(j, null);
                  localObject2 = z.MKo;
                  this.NKC = a.c.NKN;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(190743);
    }
    
    private final boolean gwt()
    {
      return this.nextParkedWorker != a.NKz;
    }
    
    private final i gwu()
    {
      AppMethodBeat.i(190746);
      if (alH(2) == 0)
      {
        locali = (i)this.NKI.NKr.gvT();
        if (locali != null)
        {
          AppMethodBeat.o(190746);
          return locali;
        }
        locali = (i)this.NKI.NKs.gvT();
        AppMethodBeat.o(190746);
        return locali;
      }
      i locali = (i)this.NKI.NKs.gvT();
      if (locali != null)
      {
        AppMethodBeat.o(190746);
        return locali;
      }
      locali = (i)this.NKI.NKr.gvT();
      AppMethodBeat.o(190746);
      return locali;
    }
    
    public final i Av(boolean paramBoolean)
    {
      AppMethodBeat.i(190744);
      Object localObject1;
      if (gwr())
      {
        localObject1 = Aw(paramBoolean);
        AppMethodBeat.o(190744);
        return localObject1;
      }
      if (paramBoolean)
      {
        localObject2 = this.NKB.gwz();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = (i)this.NKI.NKs.gvT();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = Ax(true);
      }
      AppMethodBeat.o(190744);
      return localObject2;
    }
    
    public final boolean a(a.c paramc)
    {
      AppMethodBeat.i(118018);
      a.c localc = this.NKC;
      if (localc == a.c.NKJ) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool)
        {
          a locala = this.NKI;
          a.NKv.addAndGet(locala, 4398046511104L);
        }
        if (localc != paramc) {
          this.NKC = paramc;
        }
        AppMethodBeat.o(118018);
        return bool;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(118019);
      int i = 0;
      while ((this.NKI._isTerminated == 0) && (this.NKC != a.c.NKN))
      {
        Object localObject = Av(this.NKH);
        if (localObject != null)
        {
          this.NKF = 0L;
          int j = ((i)localObject).NKX.gww();
          this.NKE = 0L;
          if (this.NKC == a.c.NKL)
          {
            if (am.gvd())
            {
              if (j == 1) {}
              for (i = 1; i == 0; i = 0)
              {
                localObject = (Throwable)new AssertionError();
                AppMethodBeat.o(118019);
                throw ((Throwable)localObject);
              }
            }
            this.NKC = a.c.NKK;
          }
          if ((j != 0) && (a(a.c.NKK))) {
            this.NKI.gwn();
          }
          a.a((i)localObject);
          if (j != 0)
          {
            localObject = this.NKI;
            a.NKv.addAndGet(localObject, -2097152L);
            localObject = this.NKC;
            if (localObject != a.c.NKN)
            {
              if (am.gvd())
              {
                if (localObject == a.c.NKK) {}
                for (i = 1; i == 0; i = 0)
                {
                  localObject = (Throwable)new AssertionError();
                  AppMethodBeat.o(118019);
                  throw ((Throwable)localObject);
                }
              }
              this.NKC = a.c.NKM;
            }
          }
          i = 0;
        }
        else
        {
          this.NKH = false;
          if (this.NKF != 0L)
          {
            if (i == 0)
            {
              i = 1;
            }
            else
            {
              a(a.c.NKL);
              Thread.interrupted();
              LockSupport.parkNanos(this.NKF);
              this.NKF = 0L;
              i = 0;
            }
          }
          else {
            gws();
          }
        }
      }
      a(a.c.NKN);
      AppMethodBeat.o(118019);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(118012);
      c localc1 = new c("CPU_ACQUIRED", 0);
      NKJ = localc1;
      c localc2 = new c("BLOCKING", 1);
      NKK = localc2;
      c localc3 = new c("PARKING", 2);
      NKL = localc3;
      c localc4 = new c("DORMANT", 3);
      NKM = localc4;
      c localc5 = new c("TERMINATED", 4);
      NKN = localc5;
      NKO = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(118012);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.a
 * JD-Core Version:    0.7.0.1
 */