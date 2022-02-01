package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.j.c;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"})
public final class a
  implements Closeable, Executor
{
  static final AtomicLongFieldUpdater OhB;
  private static final AtomicIntegerFieldUpdater OhC;
  public static final t OhF;
  public static final a OhG;
  static final AtomicLongFieldUpdater Ohz;
  public final int MrV;
  public final AtomicReferenceArray<b> OhA;
  public final long OhD;
  public final String OhE;
  public final e Ohx;
  public final e Ohy;
  volatile int _isTerminated;
  volatile long controlState;
  public final int deN;
  volatile long parkedWorkersStack;
  
  static
  {
    AppMethodBeat.i(118011);
    OhG = new a((byte)0);
    OhF = new t("NOT_IN_STACK");
    Ohz = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
    OhB = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    OhC = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    AppMethodBeat.o(118011);
  }
  
  public a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(118005);
    this.deN = paramInt1;
    this.MrV = paramInt2;
    this.OhD = paramLong;
    this.OhE = paramString;
    if (this.deN > 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Core pool size " + this.deN + " should be at least 1").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.MrV >= this.deN) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.MrV + " should be greater than or equals to core pool size " + this.deN).toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.MrV <= 2097150) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.MrV + " should not exceed maximal supported number of threads 2097150").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.OhD > 0L) {}
    for (paramInt1 = i; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Idle worker keep alive time " + this.OhD + " must be positive").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    this.Ohx = new e();
    this.Ohy = new e();
    this.parkedWorkersStack = 0L;
    this.OhA = new AtomicReferenceArray(this.MrV + 1);
    this.controlState = (this.deN << 42);
    this._isTerminated = 0;
    AppMethodBeat.o(118005);
  }
  
  private final boolean Gj(long paramLong)
  {
    AppMethodBeat.i(209231);
    if (d.k.j.lw((int)(0x1FFFFF & paramLong) - (int)((0xFFE00000 & paramLong) >> 21), 0) < this.deN)
    {
      int i = gAR();
      if ((i == 1) && (this.deN > 1)) {
        gAR();
      }
      if (i > 0)
      {
        AppMethodBeat.o(209231);
        return true;
      }
    }
    AppMethodBeat.o(209231);
    return false;
  }
  
  private static int a(b paramb)
  {
    for (paramb = paramb.nextParkedWorker;; paramb = paramb.nextParkedWorker)
    {
      if (paramb == OhF) {
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
    long l = l.Oii.nanoTime();
    if ((paramRunnable instanceof i))
    {
      ((i)paramRunnable).Oic = l;
      ((i)paramRunnable).Oid = paramj;
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
  
  private final b gAO()
  {
    AppMethodBeat.i(117994);
    long l;
    int i;
    b localb;
    do
    {
      l = this.parkedWorkersStack;
      i = (int)(0x1FFFFF & l);
      localb = (b)this.OhA.get(i);
      if (localb == null)
      {
        AppMethodBeat.o(117994);
        return null;
      }
      i = a(localb);
    } while ((i < 0) || (!Ohz.compareAndSet(this, l, 0xFFE00000 & 2097152L + l | i)));
    localb.nextParkedWorker = OhF;
    AppMethodBeat.o(117994);
    return localb;
  }
  
  private final boolean gAQ()
  {
    AppMethodBeat.i(118001);
    b localb;
    do
    {
      localb = gAO();
      if (localb == null)
      {
        AppMethodBeat.o(118001);
        return false;
      }
    } while (!b.OhJ.compareAndSet(localb, -1, 0));
    LockSupport.unpark((Thread)localb);
    AppMethodBeat.o(118001);
    return true;
  }
  
  private final int gAR()
  {
    int j = 0;
    AppMethodBeat.i(118002);
    int k;
    int m;
    for (;;)
    {
      synchronized (this.OhA)
      {
        i = this._isTerminated;
        if (i != 0)
        {
          AppMethodBeat.o(118002);
          return -1;
        }
        long l = this.controlState;
        i = (int)(l & 0x1FFFFF);
        k = d.k.j.lw(i - (int)((l & 0xFFE00000) >> 21), 0);
        m = this.deN;
        if (k >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = this.MrV;
        if (i >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = (int)(this.controlState & 0x1FFFFF) + 1;
        if ((m > 0) && (this.OhA.get(m) == null))
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
    this.OhA.set(m, localObject2);
    int i = j;
    if (m == (int)(OhB.incrementAndGet(this) & 0x1FFFFF)) {
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
  
  private final b gAS()
  {
    AppMethodBeat.i(209233);
    Thread localThread = Thread.currentThread();
    Object localObject = localThread;
    if (!(localThread instanceof b)) {
      localObject = null;
    }
    localObject = (b)localObject;
    if (localObject != null)
    {
      if (p.i(((b)localObject).OhO, (a)this))
      {
        AppMethodBeat.o(209233);
        return localObject;
      }
      AppMethodBeat.o(209233);
      return null;
    }
    AppMethodBeat.o(209233);
    return null;
  }
  
  public final void a(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(117997);
    paramj = a(paramRunnable, paramj);
    b localb = gAS();
    int i;
    if (localb == null)
    {
      paramRunnable = paramj;
      if (paramRunnable == null) {
        break label193;
      }
      if (paramRunnable.Oid.gAY() != 1) {
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
    for (boolean bool = this.Ohy.gb(paramRunnable);; bool = this.Ohx.gb(paramRunnable))
    {
      if (bool) {
        break label193;
      }
      paramRunnable = (Throwable)new RejectedExecutionException(this.OhE + " was terminated");
      AppMethodBeat.o(117997);
      throw paramRunnable;
      if (localb.OhI == c.OhT)
      {
        paramRunnable = paramj;
        break;
      }
      if ((paramj.Oid.gAY() == 0) && (localb.OhI == c.OhQ))
      {
        paramRunnable = paramj;
        break;
      }
      localb.OhN = true;
      paramRunnable = localb.OhH.a(paramj, paramBoolean);
      break;
      i = 0;
      break label48;
    }
    label193:
    if ((paramBoolean) && (localb != null)) {
      i = j;
    }
    while (paramj.Oid.gAY() == 0) {
      if (i != 0)
      {
        AppMethodBeat.o(117997);
        return;
        i = 0;
      }
      else
      {
        gAP();
        AppMethodBeat.o(117997);
        return;
      }
    }
    long l = OhB.addAndGet(this, 2097152L);
    if ((i == 0) && (!gAQ()) && (!Gj(l))) {
      gAQ();
    }
    AppMethodBeat.o(117997);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209229);
    for (;;)
    {
      long l = this.parkedWorkersStack;
      int i = (int)(0x1FFFFF & l);
      if (i == paramInt1) {
        if (paramInt2 == 0) {
          i = a(paramb);
        }
      }
      while ((i >= 0) && (Ohz.compareAndSet(this, l, 2097152L + l & 0xFFE00000 | i)))
      {
        AppMethodBeat.o(209229);
        return;
        i = paramInt2;
      }
    }
  }
  
  public final void close()
  {
    int k = 1;
    AppMethodBeat.i(117996);
    if (OhC.compareAndSet(this, 0, 1))
    {
      b localb = gAS();
      for (;;)
      {
        int m;
        synchronized (this.OhA)
        {
          long l = this.controlState;
          m = (int)(l & 0x1FFFFF);
          if (m <= 0) {
            break;
          }
          i = 1;
          ??? = this.OhA.get(i);
          if (??? == null) {
            p.gkB();
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
        if (localObject3 == c.OhT) {}
        for (int j = 1; j == 0; j = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(117996);
          throw ((Throwable)???);
        }
        ((b)???).OhH.a(this.Ohy);
        label198:
        if (i == m) {
          break;
        }
        i += 1;
      }
      this.Ohy.close();
      this.Ohx.close();
      if (localb != null)
      {
        localObject3 = localb.AI(true);
        ??? = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        ??? = (i)this.Ohx.gAv();
      }
      Object localObject3 = ???;
      if (??? == null) {
        localObject3 = (i)this.Ohy.gAv();
      }
      if (localObject3 == null)
      {
        if (localb != null) {
          localb.a(c.OhT);
        }
        if (!am.gzF()) {
          break label364;
        }
        if ((int)((this.controlState & 0x0) >> 42) != this.deN) {
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
  
  public final void gAP()
  {
    AppMethodBeat.i(209230);
    if (gAQ())
    {
      AppMethodBeat.o(209230);
      return;
    }
    if (a(this))
    {
      AppMethodBeat.o(209230);
      return;
    }
    gAQ();
    AppMethodBeat.o(209230);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118003);
    Object localObject1 = new ArrayList();
    int i3 = this.OhA.length();
    int k = 1;
    int i = 0;
    int j = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    if (k < i3)
    {
      Object localObject2 = (b)this.OhA.get(k);
      if (localObject2 == null) {}
      for (;;)
      {
        k += 1;
        break;
        int i4 = ((b)localObject2).OhH.gBa();
        localObject2 = ((b)localObject2).OhI;
        switch (b.cqt[localObject2.ordinal()])
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
    localObject1 = this.OhE + '@' + Integer.toHexString(System.identityHashCode(this)) + '[' + "Pool Size {core = " + this.deN + ", max = " + this.MrV + "}, Worker States {CPU = " + i1 + ", blocking = " + n + ", parked = " + m + ", dormant = " + j + ", terminated = " + i + "}, running workers queues = " + localObject1 + ", global CPU queue size = " + this.Ohx.getSize() + ", global blocking queue size = " + this.Ohy.getSize() + ", Control State {created workers= " + (int)(0x1FFFFF & l) + ", blocking tasks = " + (int)((0xFFE00000 & l) >> 21) + ", CPUs acquired = " + (this.deN - (int)((0x0 & l) >> 42)) + "}]";
    AppMethodBeat.o(118003);
    return localObject1;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"})
  public static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"})
  public final class b
    extends Thread
  {
    static final AtomicIntegerFieldUpdater OhJ;
    public final n OhH;
    public a.c OhI;
    private long OhK;
    private long OhL;
    private int OhM;
    public boolean OhN;
    volatile int indexInArray;
    volatile Object nextParkedWorker;
    volatile int workerCtl;
    
    static
    {
      AppMethodBeat.i(118028);
      OhJ = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");
      AppMethodBeat.o(118028);
    }
    
    private b()
    {
      AppMethodBeat.i(118026);
      setDaemon(true);
      this.OhH = new n();
      this.OhI = a.c.OhS;
      this.workerCtl = 0;
      this.nextParkedWorker = a.OhF;
      this$1 = c.Njh;
      this.OhM = c.Njf.nextInt();
      AppMethodBeat.o(118026);
    }
    
    public b()
    {
      this();
      AppMethodBeat.i(118027);
      int i;
      amq(i);
      AppMethodBeat.o(118027);
    }
    
    private final i AJ(boolean paramBoolean)
    {
      AppMethodBeat.i(209236);
      if (paramBoolean)
      {
        if (amr(this.OhO.deN * 2) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          locali = gAW();
          if (locali == null) {
            break;
          }
          AppMethodBeat.o(209236);
          return locali;
        }
        locali = this.OhH.gBb();
        if (locali != null)
        {
          AppMethodBeat.o(209236);
          return locali;
        }
        if (i == 0)
        {
          locali = gAW();
          if (locali != null)
          {
            AppMethodBeat.o(209236);
            return locali;
          }
        }
      }
      else
      {
        locali = gAW();
        if (locali != null)
        {
          AppMethodBeat.o(209236);
          return locali;
        }
      }
      i locali = AK(false);
      AppMethodBeat.o(209236);
      return locali;
    }
    
    private final i AK(boolean paramBoolean)
    {
      AppMethodBeat.i(209238);
      Object localObject;
      if (am.gzF())
      {
        if (this.OhH.gBa() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          localObject = (Throwable)new AssertionError();
          AppMethodBeat.o(209238);
          throw ((Throwable)localObject);
        }
      }
      int m = a.b(this.OhO);
      if (m < 2)
      {
        AppMethodBeat.o(209238);
        return null;
      }
      int i = amr(m);
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
        localObject = (b)this.OhO.OhA.get(i);
        if ((localObject != null) && (localObject != (b)this))
        {
          if (am.gzF())
          {
            if (this.OhH.gBa() == 0) {}
            for (int k = 1; k == 0; k = 0)
            {
              localObject = (Throwable)new AssertionError();
              AppMethodBeat.o(209238);
              throw ((Throwable)localObject);
            }
          }
          if (paramBoolean) {}
          for (long l2 = this.OhH.b(((b)localObject).OhH); l2 == -1L; l2 = this.OhH.a(((b)localObject).OhH))
          {
            localObject = this.OhH.gBb();
            AppMethodBeat.o(209238);
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
            this.OhL = l1;
            AppMethodBeat.o(209238);
            return null;
            l1 = 0L;
          }
        }
      }
    }
    
    private void amq(int paramInt)
    {
      AppMethodBeat.i(118015);
      StringBuilder localStringBuilder = new StringBuilder().append(this.OhO.OhE).append("-worker-");
      if (paramInt == 0) {}
      for (String str = "TERMINATED";; str = String.valueOf(paramInt))
      {
        setName(str);
        this.indexInArray = paramInt;
        AppMethodBeat.o(118015);
        return;
      }
    }
    
    private int amr(int paramInt)
    {
      int i = this.OhM;
      i ^= i << 13;
      i ^= i >> 17;
      i ^= i << 5;
      this.OhM = i;
      int j = paramInt - 1;
      if ((j & paramInt) == 0) {
        return i & j;
      }
      return (i & 0x7FFFFFFF) % paramInt;
    }
    
    private final boolean gAT()
    {
      AppMethodBeat.i(118017);
      if (this.OhI == a.c.OhP)
      {
        AppMethodBeat.o(118017);
        return true;
      }
      a locala = this.OhO;
      long l = locala.controlState;
      if ((int)((0x0 & l) >> 42) == 0) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label91;
        }
        this.OhI = a.c.OhP;
        AppMethodBeat.o(118017);
        return true;
        if (!a.OhB.compareAndSet(locala, l, l - 4398046511104L)) {
          break;
        }
      }
      label91:
      AppMethodBeat.o(118017);
      return false;
    }
    
    private final void gAU()
    {
      AppMethodBeat.i(209234);
      int j;
      int i;
      if (!gAV())
      {
        ??? = this.OhO;
        if (this.nextParkedWorker == a.OhF)
        {
          long l;
          int k;
          do
          {
            l = ((a)???).parkedWorkersStack;
            j = (int)(0x1FFFFF & l);
            k = this.indexInArray;
            if (am.gzF())
            {
              if (k != 0) {}
              for (i = 1; i == 0; i = 0)
              {
                ??? = (Throwable)new AssertionError();
                AppMethodBeat.o(209234);
                throw ((Throwable)???);
              }
            }
            this.nextParkedWorker = ((a)???).OhA.get(j);
          } while (!a.Ohz.compareAndSet(???, l, k | 2097152L + l & 0xFFE00000));
        }
        AppMethodBeat.o(209234);
        return;
      }
      if (am.gzF())
      {
        if (this.OhH.gBa() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(209234);
          throw ((Throwable)???);
        }
      }
      this.workerCtl = -1;
      while ((gAV()) && (this.OhO._isTerminated == 0) && (this.OhI != a.c.OhT))
      {
        a(a.c.OhR);
        Thread.interrupted();
        if (this.OhK == 0L) {
          this.OhK = (System.nanoTime() + this.OhO.OhD);
        }
        LockSupport.parkNanos(this.OhO.OhD);
        if (System.nanoTime() - this.OhK >= 0L)
        {
          this.OhK = 0L;
          synchronized (this.OhO.OhA)
          {
            i = this.OhO._isTerminated;
            if (i == 0)
            {
              i = a.b(this.OhO);
              j = this.OhO.deN;
              if (i > j)
              {
                boolean bool = OhJ.compareAndSet(this, -1, 1);
                if (bool)
                {
                  i = this.indexInArray;
                  amq(0);
                  this.OhO.a(this, i, 0);
                  Object localObject2 = this.OhO;
                  j = (int)(a.OhB.getAndDecrement(localObject2) & 0x1FFFFF);
                  if (j != i)
                  {
                    localObject2 = this.OhO.OhA.get(j);
                    if (localObject2 == null) {
                      p.gkB();
                    }
                    localObject2 = (b)localObject2;
                    this.OhO.OhA.set(i, localObject2);
                    ((b)localObject2).amq(i);
                    this.OhO.a((b)localObject2, j, i);
                  }
                  this.OhO.OhA.set(j, null);
                  localObject2 = z.Nhr;
                  this.OhI = a.c.OhT;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(209234);
    }
    
    private final boolean gAV()
    {
      return this.nextParkedWorker != a.OhF;
    }
    
    private final i gAW()
    {
      AppMethodBeat.i(209237);
      if (amr(2) == 0)
      {
        locali = (i)this.OhO.Ohx.gAv();
        if (locali != null)
        {
          AppMethodBeat.o(209237);
          return locali;
        }
        locali = (i)this.OhO.Ohy.gAv();
        AppMethodBeat.o(209237);
        return locali;
      }
      i locali = (i)this.OhO.Ohy.gAv();
      if (locali != null)
      {
        AppMethodBeat.o(209237);
        return locali;
      }
      locali = (i)this.OhO.Ohx.gAv();
      AppMethodBeat.o(209237);
      return locali;
    }
    
    public final i AI(boolean paramBoolean)
    {
      AppMethodBeat.i(209235);
      Object localObject1;
      if (gAT())
      {
        localObject1 = AJ(paramBoolean);
        AppMethodBeat.o(209235);
        return localObject1;
      }
      if (paramBoolean)
      {
        localObject2 = this.OhH.gBb();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = (i)this.OhO.Ohy.gAv();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = AK(true);
      }
      AppMethodBeat.o(209235);
      return localObject2;
    }
    
    public final boolean a(a.c paramc)
    {
      AppMethodBeat.i(118018);
      a.c localc = this.OhI;
      if (localc == a.c.OhP) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool)
        {
          a locala = this.OhO;
          a.OhB.addAndGet(locala, 4398046511104L);
        }
        if (localc != paramc) {
          this.OhI = paramc;
        }
        AppMethodBeat.o(118018);
        return bool;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(118019);
      int i = 0;
      while ((this.OhO._isTerminated == 0) && (this.OhI != a.c.OhT))
      {
        Object localObject = AI(this.OhN);
        if (localObject != null)
        {
          this.OhL = 0L;
          int j = ((i)localObject).Oid.gAY();
          this.OhK = 0L;
          if (this.OhI == a.c.OhR)
          {
            if (am.gzF())
            {
              if (j == 1) {}
              for (i = 1; i == 0; i = 0)
              {
                localObject = (Throwable)new AssertionError();
                AppMethodBeat.o(118019);
                throw ((Throwable)localObject);
              }
            }
            this.OhI = a.c.OhQ;
          }
          if ((j != 0) && (a(a.c.OhQ))) {
            this.OhO.gAP();
          }
          a.a((i)localObject);
          if (j != 0)
          {
            localObject = this.OhO;
            a.OhB.addAndGet(localObject, -2097152L);
            localObject = this.OhI;
            if (localObject != a.c.OhT)
            {
              if (am.gzF())
              {
                if (localObject == a.c.OhQ) {}
                for (i = 1; i == 0; i = 0)
                {
                  localObject = (Throwable)new AssertionError();
                  AppMethodBeat.o(118019);
                  throw ((Throwable)localObject);
                }
              }
              this.OhI = a.c.OhS;
            }
          }
          i = 0;
        }
        else
        {
          this.OhN = false;
          if (this.OhL != 0L)
          {
            if (i == 0)
            {
              i = 1;
            }
            else
            {
              a(a.c.OhR);
              Thread.interrupted();
              LockSupport.parkNanos(this.OhL);
              this.OhL = 0L;
              i = 0;
            }
          }
          else {
            gAU();
          }
        }
      }
      a(a.c.OhT);
      AppMethodBeat.o(118019);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(118012);
      c localc1 = new c("CPU_ACQUIRED", 0);
      OhP = localc1;
      c localc2 = new c("BLOCKING", 1);
      OhQ = localc2;
      c localc3 = new c("PARKING", 2);
      OhR = localc3;
      c localc4 = new c("DORMANT", 3);
      OhS = localc4;
      c localc5 = new c("TERMINATED", 4);
      OhT = localc5;
      OhU = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(118012);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.a
 * JD-Core Version:    0.7.0.1
 */