package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.g.b.p;
import kotlin.j.c;
import kotlin.x;
import kotlinx.coroutines.an;
import kotlinx.coroutines.internal.u;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"})
public final class a
  implements Closeable, Executor
{
  public static final u TWC;
  public static final a.a TWD;
  static final AtomicLongFieldUpdater TWw;
  static final AtomicLongFieldUpdater TWy;
  private static final AtomicIntegerFieldUpdater TWz;
  public final int RUr;
  public final long TWA;
  public final String TWB;
  public final e TWu;
  public final e TWv;
  public final AtomicReferenceArray<b> TWx;
  volatile int _isTerminated;
  volatile long controlState;
  public final int dvP;
  volatile long parkedWorkersStack;
  
  static
  {
    AppMethodBeat.i(118011);
    TWD = new a.a((byte)0);
    TWC = new u("NOT_IN_STACK");
    TWw = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
    TWy = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    TWz = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    AppMethodBeat.o(118011);
  }
  
  public a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(118005);
    this.dvP = paramInt1;
    this.RUr = paramInt2;
    this.TWA = paramLong;
    this.TWB = paramString;
    if (this.dvP > 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Core pool size " + this.dvP + " should be at least 1").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.RUr >= this.dvP) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.RUr + " should be greater than or equals to core pool size " + this.dvP).toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.RUr <= 2097150) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.RUr + " should not exceed maximal supported number of threads 2097150").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.TWA > 0L) {}
    for (paramInt1 = i; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Idle worker keep alive time " + this.TWA + " must be positive").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    this.TWu = new e();
    this.TWv = new e();
    this.parkedWorkersStack = 0L;
    this.TWx = new AtomicReferenceArray(this.RUr + 1);
    this.controlState = (this.dvP << 42);
    this._isTerminated = 0;
    AppMethodBeat.o(118005);
  }
  
  private final boolean Pp(long paramLong)
  {
    AppMethodBeat.i(192366);
    if (kotlin.k.j.mZ((int)(0x1FFFFF & paramLong) - (int)((0xFFE00000 & paramLong) >> 21), 0) < this.dvP)
    {
      int i = hNY();
      if ((i == 1) && (this.dvP > 1)) {
        hNY();
      }
      if (i > 0)
      {
        AppMethodBeat.o(192366);
        return true;
      }
    }
    AppMethodBeat.o(192366);
    return false;
  }
  
  private static int a(b paramb)
  {
    for (paramb = paramb.nextParkedWorker;; paramb = paramb.nextParkedWorker)
    {
      if (paramb == TWC) {
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
    long l = l.TXe.nanoTime();
    if ((paramRunnable instanceof i))
    {
      ((i)paramRunnable).TWZ = l;
      ((i)paramRunnable).TXa = paramj;
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
  
  private final b hNV()
  {
    AppMethodBeat.i(117994);
    long l;
    int i;
    b localb;
    do
    {
      l = this.parkedWorkersStack;
      i = (int)(0x1FFFFF & l);
      localb = (b)this.TWx.get(i);
      if (localb == null)
      {
        AppMethodBeat.o(117994);
        return null;
      }
      i = a(localb);
    } while ((i < 0) || (!TWw.compareAndSet(this, l, 0xFFE00000 & 2097152L + l | i)));
    localb.nextParkedWorker = TWC;
    AppMethodBeat.o(117994);
    return localb;
  }
  
  private final boolean hNX()
  {
    AppMethodBeat.i(118001);
    b localb;
    do
    {
      localb = hNV();
      if (localb == null)
      {
        AppMethodBeat.o(118001);
        return false;
      }
    } while (!b.TWG.compareAndSet(localb, -1, 0));
    LockSupport.unpark((Thread)localb);
    AppMethodBeat.o(118001);
    return true;
  }
  
  private final int hNY()
  {
    int j = 0;
    AppMethodBeat.i(118002);
    int k;
    int m;
    for (;;)
    {
      synchronized (this.TWx)
      {
        i = this._isTerminated;
        if (i != 0)
        {
          AppMethodBeat.o(118002);
          return -1;
        }
        long l = this.controlState;
        i = (int)(l & 0x1FFFFF);
        k = kotlin.k.j.mZ(i - (int)((l & 0xFFE00000) >> 21), 0);
        m = this.dvP;
        if (k >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = this.RUr;
        if (i >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = (int)(this.controlState & 0x1FFFFF) + 1;
        if ((m > 0) && (this.TWx.get(m) == null))
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
    this.TWx.set(m, localObject2);
    int i = j;
    if (m == (int)(TWy.incrementAndGet(this) & 0x1FFFFF)) {
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
  
  private final b hNZ()
  {
    AppMethodBeat.i(192368);
    Thread localThread = Thread.currentThread();
    Object localObject = localThread;
    if (!(localThread instanceof b)) {
      localObject = null;
    }
    localObject = (b)localObject;
    if (localObject != null)
    {
      if (p.j(((b)localObject).TWL, (a)this))
      {
        AppMethodBeat.o(192368);
        return localObject;
      }
      AppMethodBeat.o(192368);
      return null;
    }
    AppMethodBeat.o(192368);
    return null;
  }
  
  public final void a(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(117997);
    paramj = a(paramRunnable, paramj);
    b localb = hNZ();
    int i;
    if (localb == null)
    {
      paramRunnable = paramj;
      if (paramRunnable == null) {
        break label193;
      }
      if (paramRunnable.TXa.hOf() != 1) {
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
    for (boolean bool = this.TWv.gg(paramRunnable);; bool = this.TWu.gg(paramRunnable))
    {
      if (bool) {
        break label193;
      }
      paramRunnable = (Throwable)new RejectedExecutionException(this.TWB + " was terminated");
      AppMethodBeat.o(117997);
      throw paramRunnable;
      if (localb.TWF == c.TWQ)
      {
        paramRunnable = paramj;
        break;
      }
      if ((paramj.TXa.hOf() == 0) && (localb.TWF == c.TWN))
      {
        paramRunnable = paramj;
        break;
      }
      localb.TWK = true;
      paramRunnable = localb.TWE.a(paramj, paramBoolean);
      break;
      i = 0;
      break label48;
    }
    label193:
    if ((paramBoolean) && (localb != null)) {
      i = j;
    }
    while (paramj.TXa.hOf() == 0) {
      if (i != 0)
      {
        AppMethodBeat.o(117997);
        return;
        i = 0;
      }
      else
      {
        hNW();
        AppMethodBeat.o(117997);
        return;
      }
    }
    long l = TWy.addAndGet(this, 2097152L);
    if ((i == 0) && (!hNX()) && (!Pp(l))) {
      hNX();
    }
    AppMethodBeat.o(117997);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192364);
    for (;;)
    {
      long l = this.parkedWorkersStack;
      int i = (int)(0x1FFFFF & l);
      if (i == paramInt1) {
        if (paramInt2 == 0) {
          i = a(paramb);
        }
      }
      while ((i >= 0) && (TWw.compareAndSet(this, l, 2097152L + l & 0xFFE00000 | i)))
      {
        AppMethodBeat.o(192364);
        return;
        i = paramInt2;
      }
    }
  }
  
  public final void close()
  {
    int k = 1;
    AppMethodBeat.i(117996);
    if (TWz.compareAndSet(this, 0, 1))
    {
      b localb = hNZ();
      for (;;)
      {
        int m;
        synchronized (this.TWx)
        {
          long l = this.controlState;
          m = (int)(l & 0x1FFFFF);
          if (m <= 0) {
            break;
          }
          i = 1;
          ??? = this.TWx.get(i);
          if (??? == null) {
            p.hyc();
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
        if (localObject3 == c.TWQ) {}
        for (int j = 1; j == 0; j = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(117996);
          throw ((Throwable)???);
        }
        ((b)???).TWE.a(this.TWv);
        label198:
        if (i == m) {
          break;
        }
        i += 1;
      }
      this.TWv.close();
      this.TWu.close();
      if (localb != null)
      {
        localObject3 = localb.EY(true);
        ??? = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        ??? = (i)this.TWu.hNC();
      }
      Object localObject3 = ???;
      if (??? == null) {
        localObject3 = (i)this.TWv.hNC();
      }
      if (localObject3 == null)
      {
        if (localb != null) {
          localb.a(c.TWQ);
        }
        if (!an.hMK()) {
          break label364;
        }
        if ((int)((this.controlState & 0x0) >> 42) != this.dvP) {
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
  
  public final void hNW()
  {
    AppMethodBeat.i(192365);
    if (hNX())
    {
      AppMethodBeat.o(192365);
      return;
    }
    if (a(this))
    {
      AppMethodBeat.o(192365);
      return;
    }
    hNX();
    AppMethodBeat.o(192365);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118003);
    Object localObject1 = new ArrayList();
    int i3 = this.TWx.length();
    int k = 1;
    int i = 0;
    int j = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    if (k < i3)
    {
      Object localObject2 = (b)this.TWx.get(k);
      if (localObject2 == null) {}
      for (;;)
      {
        k += 1;
        break;
        int i4 = ((b)localObject2).TWE.hOh();
        localObject2 = ((b)localObject2).TWF;
        switch (b.$EnumSwitchMapping$0[localObject2.ordinal()])
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
    localObject1 = this.TWB + '@' + Integer.toHexString(System.identityHashCode(this)) + '[' + "Pool Size {core = " + this.dvP + ", max = " + this.RUr + "}, Worker States {CPU = " + i1 + ", blocking = " + n + ", parked = " + m + ", dormant = " + j + ", terminated = " + i + "}, running workers queues = " + localObject1 + ", global CPU queue size = " + this.TWu.getSize() + ", global blocking queue size = " + this.TWv.getSize() + ", Control State {created workers= " + (int)(0x1FFFFF & l) + ", blocking tasks = " + (int)((0xFFE00000 & l) >> 21) + ", CPUs acquired = " + (this.dvP - (int)((0x0 & l) >> 42)) + "}]";
    AppMethodBeat.o(118003);
    return localObject1;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"})
  public final class b
    extends Thread
  {
    static final AtomicIntegerFieldUpdater TWG;
    public final n TWE;
    public a.c TWF;
    private long TWH;
    private long TWI;
    private int TWJ;
    public boolean TWK;
    volatile int indexInArray;
    volatile Object nextParkedWorker;
    volatile int workerCtl;
    
    static
    {
      AppMethodBeat.i(118028);
      TWG = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");
      AppMethodBeat.o(118028);
    }
    
    private b()
    {
      AppMethodBeat.i(118026);
      setDaemon(true);
      this.TWE = new n();
      this.TWF = a.c.TWP;
      this.workerCtl = 0;
      this.nextParkedWorker = a.TWC;
      this$1 = c.SYP;
      this.TWJ = c.SYN.nextInt();
      AppMethodBeat.o(118026);
    }
    
    public b()
    {
      this();
      AppMethodBeat.i(118027);
      int i;
      avZ(i);
      AppMethodBeat.o(118027);
    }
    
    private final i EZ(boolean paramBoolean)
    {
      AppMethodBeat.i(192371);
      if (paramBoolean)
      {
        if (awa(this.TWL.dvP * 2) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          locali = hOd();
          if (locali == null) {
            break;
          }
          AppMethodBeat.o(192371);
          return locali;
        }
        locali = this.TWE.hOi();
        if (locali != null)
        {
          AppMethodBeat.o(192371);
          return locali;
        }
        if (i == 0)
        {
          locali = hOd();
          if (locali != null)
          {
            AppMethodBeat.o(192371);
            return locali;
          }
        }
      }
      else
      {
        locali = hOd();
        if (locali != null)
        {
          AppMethodBeat.o(192371);
          return locali;
        }
      }
      i locali = Fa(false);
      AppMethodBeat.o(192371);
      return locali;
    }
    
    private final i Fa(boolean paramBoolean)
    {
      AppMethodBeat.i(192373);
      Object localObject;
      if (an.hMK())
      {
        if (this.TWE.hOh() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          localObject = (Throwable)new AssertionError();
          AppMethodBeat.o(192373);
          throw ((Throwable)localObject);
        }
      }
      int m = a.b(this.TWL);
      if (m < 2)
      {
        AppMethodBeat.o(192373);
        return null;
      }
      int i = awa(m);
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
        localObject = (b)this.TWL.TWx.get(i);
        if ((localObject != null) && (localObject != (b)this))
        {
          if (an.hMK())
          {
            if (this.TWE.hOh() == 0) {}
            for (int k = 1; k == 0; k = 0)
            {
              localObject = (Throwable)new AssertionError();
              AppMethodBeat.o(192373);
              throw ((Throwable)localObject);
            }
          }
          if (paramBoolean) {}
          for (long l2 = this.TWE.b(((b)localObject).TWE); l2 == -1L; l2 = this.TWE.a(((b)localObject).TWE))
          {
            localObject = this.TWE.hOi();
            AppMethodBeat.o(192373);
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
            this.TWI = l1;
            AppMethodBeat.o(192373);
            return null;
            l1 = 0L;
          }
        }
      }
    }
    
    private void avZ(int paramInt)
    {
      AppMethodBeat.i(118015);
      StringBuilder localStringBuilder = new StringBuilder().append(this.TWL.TWB).append("-worker-");
      if (paramInt == 0) {}
      for (String str = "TERMINATED";; str = String.valueOf(paramInt))
      {
        setName(str);
        this.indexInArray = paramInt;
        AppMethodBeat.o(118015);
        return;
      }
    }
    
    private int awa(int paramInt)
    {
      int i = this.TWJ;
      i ^= i << 13;
      i ^= i >> 17;
      i ^= i << 5;
      this.TWJ = i;
      int j = paramInt - 1;
      if ((j & paramInt) == 0) {
        return i & j;
      }
      return (i & 0x7FFFFFFF) % paramInt;
    }
    
    private final boolean hOa()
    {
      AppMethodBeat.i(118017);
      if (this.TWF == a.c.TWM)
      {
        AppMethodBeat.o(118017);
        return true;
      }
      a locala = this.TWL;
      long l = locala.controlState;
      if ((int)((0x0 & l) >> 42) == 0) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label91;
        }
        this.TWF = a.c.TWM;
        AppMethodBeat.o(118017);
        return true;
        if (!a.TWy.compareAndSet(locala, l, l - 4398046511104L)) {
          break;
        }
      }
      label91:
      AppMethodBeat.o(118017);
      return false;
    }
    
    private final void hOb()
    {
      AppMethodBeat.i(192369);
      int j;
      int i;
      if (!hOc())
      {
        ??? = this.TWL;
        if (this.nextParkedWorker == a.TWC)
        {
          long l;
          int k;
          do
          {
            l = ((a)???).parkedWorkersStack;
            j = (int)(0x1FFFFF & l);
            k = this.indexInArray;
            if (an.hMK())
            {
              if (k != 0) {}
              for (i = 1; i == 0; i = 0)
              {
                ??? = (Throwable)new AssertionError();
                AppMethodBeat.o(192369);
                throw ((Throwable)???);
              }
            }
            this.nextParkedWorker = ((a)???).TWx.get(j);
          } while (!a.TWw.compareAndSet(???, l, k | 2097152L + l & 0xFFE00000));
        }
        AppMethodBeat.o(192369);
        return;
      }
      if (an.hMK())
      {
        if (this.TWE.hOh() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(192369);
          throw ((Throwable)???);
        }
      }
      this.workerCtl = -1;
      while ((hOc()) && (this.TWL._isTerminated == 0) && (this.TWF != a.c.TWQ))
      {
        a(a.c.TWO);
        Thread.interrupted();
        if (this.TWH == 0L) {
          this.TWH = (System.nanoTime() + this.TWL.TWA);
        }
        LockSupport.parkNanos(this.TWL.TWA);
        if (System.nanoTime() - this.TWH >= 0L)
        {
          this.TWH = 0L;
          synchronized (this.TWL.TWx)
          {
            i = this.TWL._isTerminated;
            if (i == 0)
            {
              i = a.b(this.TWL);
              j = this.TWL.dvP;
              if (i > j)
              {
                boolean bool = TWG.compareAndSet(this, -1, 1);
                if (bool)
                {
                  i = this.indexInArray;
                  avZ(0);
                  this.TWL.a(this, i, 0);
                  Object localObject2 = this.TWL;
                  j = (int)(a.TWy.getAndDecrement(localObject2) & 0x1FFFFF);
                  if (j != i)
                  {
                    localObject2 = this.TWL.TWx.get(j);
                    if (localObject2 == null) {
                      p.hyc();
                    }
                    localObject2 = (b)localObject2;
                    this.TWL.TWx.set(i, localObject2);
                    ((b)localObject2).avZ(i);
                    this.TWL.a((b)localObject2, j, i);
                  }
                  this.TWL.TWx.set(j, null);
                  localObject2 = x.SXb;
                  this.TWF = a.c.TWQ;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(192369);
    }
    
    private final boolean hOc()
    {
      return this.nextParkedWorker != a.TWC;
    }
    
    private final i hOd()
    {
      AppMethodBeat.i(192372);
      if (awa(2) == 0)
      {
        locali = (i)this.TWL.TWu.hNC();
        if (locali != null)
        {
          AppMethodBeat.o(192372);
          return locali;
        }
        locali = (i)this.TWL.TWv.hNC();
        AppMethodBeat.o(192372);
        return locali;
      }
      i locali = (i)this.TWL.TWv.hNC();
      if (locali != null)
      {
        AppMethodBeat.o(192372);
        return locali;
      }
      locali = (i)this.TWL.TWu.hNC();
      AppMethodBeat.o(192372);
      return locali;
    }
    
    public final i EY(boolean paramBoolean)
    {
      AppMethodBeat.i(192370);
      Object localObject1;
      if (hOa())
      {
        localObject1 = EZ(paramBoolean);
        AppMethodBeat.o(192370);
        return localObject1;
      }
      if (paramBoolean)
      {
        localObject2 = this.TWE.hOi();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = (i)this.TWL.TWv.hNC();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = Fa(true);
      }
      AppMethodBeat.o(192370);
      return localObject2;
    }
    
    public final boolean a(a.c paramc)
    {
      AppMethodBeat.i(118018);
      a.c localc = this.TWF;
      if (localc == a.c.TWM) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool)
        {
          a locala = this.TWL;
          a.TWy.addAndGet(locala, 4398046511104L);
        }
        if (localc != paramc) {
          this.TWF = paramc;
        }
        AppMethodBeat.o(118018);
        return bool;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(118019);
      int i = 0;
      while ((this.TWL._isTerminated == 0) && (this.TWF != a.c.TWQ))
      {
        Object localObject = EY(this.TWK);
        if (localObject != null)
        {
          this.TWI = 0L;
          int j = ((i)localObject).TXa.hOf();
          this.TWH = 0L;
          if (this.TWF == a.c.TWO)
          {
            if (an.hMK())
            {
              if (j == 1) {}
              for (i = 1; i == 0; i = 0)
              {
                localObject = (Throwable)new AssertionError();
                AppMethodBeat.o(118019);
                throw ((Throwable)localObject);
              }
            }
            this.TWF = a.c.TWN;
          }
          if ((j != 0) && (a(a.c.TWN))) {
            this.TWL.hNW();
          }
          a.a((i)localObject);
          if (j != 0)
          {
            localObject = this.TWL;
            a.TWy.addAndGet(localObject, -2097152L);
            localObject = this.TWF;
            if (localObject != a.c.TWQ)
            {
              if (an.hMK())
              {
                if (localObject == a.c.TWN) {}
                for (i = 1; i == 0; i = 0)
                {
                  localObject = (Throwable)new AssertionError();
                  AppMethodBeat.o(118019);
                  throw ((Throwable)localObject);
                }
              }
              this.TWF = a.c.TWP;
            }
          }
          i = 0;
        }
        else
        {
          this.TWK = false;
          if (this.TWI != 0L)
          {
            if (i == 0)
            {
              i = 1;
            }
            else
            {
              a(a.c.TWO);
              Thread.interrupted();
              LockSupport.parkNanos(this.TWI);
              this.TWI = 0L;
              i = 0;
            }
          }
          else {
            hOb();
          }
        }
      }
      a(a.c.TWQ);
      AppMethodBeat.o(118019);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(118012);
      c localc1 = new c("CPU_ACQUIRED", 0);
      TWM = localc1;
      c localc2 = new c("BLOCKING", 1);
      TWN = localc2;
      c localc3 = new c("PARKING", 2);
      TWO = localc3;
      c localc4 = new c("DORMANT", 3);
      TWP = localc4;
      c localc5 = new c("TERMINATED", 4);
      TWQ = localc5;
      TWR = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(118012);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.b.a
 * JD-Core Version:    0.7.0.1
 */