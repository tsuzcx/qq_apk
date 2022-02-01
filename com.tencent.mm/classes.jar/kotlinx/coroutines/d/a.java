package kotlinx.coroutines.d;

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
import kotlinx.coroutines.ap;
import kotlinx.coroutines.internal.v;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"})
public final class a
  implements Closeable, Executor
{
  static final AtomicLongFieldUpdater abzN;
  static final AtomicLongFieldUpdater abzP;
  private static final AtomicIntegerFieldUpdater abzQ;
  public static final v abzT;
  public static final a.a abzU;
  public final int ZwT;
  volatile int _isTerminated;
  public final e abzL;
  public final e abzM;
  public final AtomicReferenceArray<b> abzO;
  public final long abzR;
  public final String abzS;
  volatile long controlState;
  public final int foy;
  volatile long parkedWorkersStack;
  
  static
  {
    AppMethodBeat.i(118011);
    abzU = new a.a((byte)0);
    abzT = new v("NOT_IN_STACK");
    abzN = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
    abzP = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    abzQ = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    AppMethodBeat.o(118011);
  }
  
  public a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(118005);
    this.foy = paramInt1;
    this.ZwT = paramInt2;
    this.abzR = paramLong;
    this.abzS = paramString;
    if (this.foy > 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Core pool size " + this.foy + " should be at least 1").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.ZwT >= this.foy) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.ZwT + " should be greater than or equals to core pool size " + this.foy).toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.ZwT <= 2097150) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.ZwT + " should not exceed maximal supported number of threads 2097150").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    if (this.abzR > 0L) {}
    for (paramInt1 = i; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Idle worker keep alive time " + this.abzR + " must be positive").toString());
      AppMethodBeat.o(118005);
      throw paramString;
    }
    this.abzL = new e();
    this.abzM = new e();
    this.parkedWorkersStack = 0L;
    this.abzO = new AtomicReferenceArray(this.ZwT + 1);
    this.controlState = (this.foy << 42);
    this._isTerminated = 0;
    AppMethodBeat.o(118005);
  }
  
  private final boolean XF(long paramLong)
  {
    AppMethodBeat.i(204681);
    if (kotlin.k.i.ov((int)(0x1FFFFF & paramLong) - (int)((0xFFE00000 & paramLong) >> 21), 0) < this.foy)
    {
      int i = iTe();
      if ((i == 1) && (this.foy > 1)) {
        iTe();
      }
      if (i > 0)
      {
        AppMethodBeat.o(204681);
        return true;
      }
    }
    AppMethodBeat.o(204681);
    return false;
  }
  
  private static int a(b paramb)
  {
    for (paramb = paramb.nextParkedWorker;; paramb = paramb.nextParkedWorker)
    {
      if (paramb == abzT) {
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
    long l = l.abAv.nanoTime();
    if ((paramRunnable instanceof i))
    {
      ((i)paramRunnable).abAq = l;
      ((i)paramRunnable).abAr = paramj;
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
  
  private final b iTb()
  {
    AppMethodBeat.i(117994);
    long l;
    int i;
    b localb;
    do
    {
      l = this.parkedWorkersStack;
      i = (int)(0x1FFFFF & l);
      localb = (b)this.abzO.get(i);
      if (localb == null)
      {
        AppMethodBeat.o(117994);
        return null;
      }
      i = a(localb);
    } while ((i < 0) || (!abzN.compareAndSet(this, l, 0xFFE00000 & 2097152L + l | i)));
    localb.nextParkedWorker = abzT;
    AppMethodBeat.o(117994);
    return localb;
  }
  
  private final boolean iTd()
  {
    AppMethodBeat.i(118001);
    b localb;
    do
    {
      localb = iTb();
      if (localb == null)
      {
        AppMethodBeat.o(118001);
        return false;
      }
    } while (!b.abzX.compareAndSet(localb, -1, 0));
    LockSupport.unpark((Thread)localb);
    AppMethodBeat.o(118001);
    return true;
  }
  
  private final int iTe()
  {
    int j = 0;
    AppMethodBeat.i(118002);
    int k;
    int m;
    for (;;)
    {
      synchronized (this.abzO)
      {
        i = this._isTerminated;
        if (i != 0)
        {
          AppMethodBeat.o(118002);
          return -1;
        }
        long l = this.controlState;
        i = (int)(l & 0x1FFFFF);
        k = kotlin.k.i.ov(i - (int)((l & 0xFFE00000) >> 21), 0);
        m = this.foy;
        if (k >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = this.ZwT;
        if (i >= m)
        {
          AppMethodBeat.o(118002);
          return 0;
        }
        m = (int)(this.controlState & 0x1FFFFF) + 1;
        if ((m > 0) && (this.abzO.get(m) == null))
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
    this.abzO.set(m, localObject2);
    int i = j;
    if (m == (int)(abzP.incrementAndGet(this) & 0x1FFFFF)) {
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
  
  private final b iTf()
  {
    AppMethodBeat.i(204691);
    Thread localThread = Thread.currentThread();
    Object localObject = localThread;
    if (!(localThread instanceof b)) {
      localObject = null;
    }
    localObject = (b)localObject;
    if (localObject != null)
    {
      if (p.h(((b)localObject).abAc, (a)this))
      {
        AppMethodBeat.o(204691);
        return localObject;
      }
      AppMethodBeat.o(204691);
      return null;
    }
    AppMethodBeat.o(204691);
    return null;
  }
  
  public final void a(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(117997);
    paramj = a(paramRunnable, paramj);
    b localb = iTf();
    int i;
    if (localb == null)
    {
      paramRunnable = paramj;
      if (paramRunnable == null) {
        break label193;
      }
      if (paramRunnable.abAr.iTl() != 1) {
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
    for (boolean bool = this.abzM.gy(paramRunnable);; bool = this.abzL.gy(paramRunnable))
    {
      if (bool) {
        break label193;
      }
      paramRunnable = (Throwable)new RejectedExecutionException(this.abzS + " was terminated");
      AppMethodBeat.o(117997);
      throw paramRunnable;
      if (localb.abzW == c.abAh)
      {
        paramRunnable = paramj;
        break;
      }
      if ((paramj.abAr.iTl() == 0) && (localb.abzW == c.abAe))
      {
        paramRunnable = paramj;
        break;
      }
      localb.abAb = true;
      paramRunnable = localb.abzV.a(paramj, paramBoolean);
      break;
      i = 0;
      break label48;
    }
    label193:
    if ((paramBoolean) && (localb != null)) {
      i = j;
    }
    while (paramj.abAr.iTl() == 0) {
      if (i != 0)
      {
        AppMethodBeat.o(117997);
        return;
        i = 0;
      }
      else
      {
        iTc();
        AppMethodBeat.o(117997);
        return;
      }
    }
    long l = abzP.addAndGet(this, 2097152L);
    if ((i == 0) && (!iTd()) && (!XF(l))) {
      iTd();
    }
    AppMethodBeat.o(117997);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204677);
    for (;;)
    {
      long l = this.parkedWorkersStack;
      int i = (int)(0x1FFFFF & l);
      if (i == paramInt1) {
        if (paramInt2 == 0) {
          i = a(paramb);
        }
      }
      while ((i >= 0) && (abzN.compareAndSet(this, l, 2097152L + l & 0xFFE00000 | i)))
      {
        AppMethodBeat.o(204677);
        return;
        i = paramInt2;
      }
    }
  }
  
  public final void close()
  {
    int k = 1;
    AppMethodBeat.i(117996);
    if (abzQ.compareAndSet(this, 0, 1))
    {
      b localb = iTf();
      for (;;)
      {
        int m;
        synchronized (this.abzO)
        {
          long l = this.controlState;
          m = (int)(l & 0x1FFFFF);
          if (m <= 0) {
            break;
          }
          i = 1;
          ??? = this.abzO.get(i);
          if (??? == null) {
            p.iCn();
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
        if (localObject3 == c.abAh) {}
        for (int j = 1; j == 0; j = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(117996);
          throw ((Throwable)???);
        }
        ((b)???).abzV.a(this.abzM);
        label198:
        if (i == m) {
          break;
        }
        i += 1;
      }
      this.abzM.close();
      this.abzL.close();
      if (localb != null)
      {
        localObject3 = localb.JH(true);
        ??? = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        ??? = (i)this.abzL.iSD();
      }
      Object localObject3 = ???;
      if (??? == null) {
        localObject3 = (i)this.abzM.iSD();
      }
      if (localObject3 == null)
      {
        if (localb != null) {
          localb.a(c.abAh);
        }
        if (!ap.iRg()) {
          break label364;
        }
        if ((int)((this.controlState & 0x0) >> 42) != this.foy) {
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
  
  public final void iTc()
  {
    AppMethodBeat.i(204680);
    if (iTd())
    {
      AppMethodBeat.o(204680);
      return;
    }
    if (a(this))
    {
      AppMethodBeat.o(204680);
      return;
    }
    iTd();
    AppMethodBeat.o(204680);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118003);
    Object localObject1 = new ArrayList();
    int i3 = this.abzO.length();
    int k = 1;
    int i = 0;
    int j = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    if (k < i3)
    {
      Object localObject2 = (b)this.abzO.get(k);
      if (localObject2 == null) {}
      for (;;)
      {
        k += 1;
        break;
        int i4 = ((b)localObject2).abzV.iTn();
        localObject2 = ((b)localObject2).abzW;
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
    localObject1 = this.abzS + '@' + Integer.toHexString(System.identityHashCode(this)) + '[' + "Pool Size {core = " + this.foy + ", max = " + this.ZwT + "}, Worker States {CPU = " + i1 + ", blocking = " + n + ", parked = " + m + ", dormant = " + j + ", terminated = " + i + "}, running workers queues = " + localObject1 + ", global CPU queue size = " + this.abzL.getSize() + ", global blocking queue size = " + this.abzM.getSize() + ", Control State {created workers= " + (int)(0x1FFFFF & l) + ", blocking tasks = " + (int)((0xFFE00000 & l) >> 21) + ", CPUs acquired = " + (this.foy - (int)((0x0 & l) >> 42)) + "}]";
    AppMethodBeat.o(118003);
    return localObject1;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"})
  public final class b
    extends Thread
  {
    static final AtomicIntegerFieldUpdater abzX;
    private int abAa;
    public boolean abAb;
    public final n abzV;
    public a.c abzW;
    private long abzY;
    private long abzZ;
    volatile int indexInArray;
    volatile Object nextParkedWorker;
    volatile int workerCtl;
    
    static
    {
      AppMethodBeat.i(118028);
      abzX = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");
      AppMethodBeat.o(118028);
    }
    
    private b()
    {
      AppMethodBeat.i(118026);
      setDaemon(true);
      this.abzV = new n();
      this.abzW = a.c.abAg;
      this.workerCtl = 0;
      this.nextParkedWorker = a.abzT;
      this$1 = c.aaBL;
      this.abAa = c.iCt().zD();
      AppMethodBeat.o(118026);
    }
    
    public b()
    {
      this();
      AppMethodBeat.i(118027);
      int i;
      aFU(i);
      AppMethodBeat.o(118027);
    }
    
    private final i JI(boolean paramBoolean)
    {
      AppMethodBeat.i(204743);
      if (paramBoolean)
      {
        if (aFV(this.abAc.foy * 2) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          locali = iTj();
          if (locali == null) {
            break;
          }
          AppMethodBeat.o(204743);
          return locali;
        }
        locali = this.abzV.iTo();
        if (locali != null)
        {
          AppMethodBeat.o(204743);
          return locali;
        }
        if (i == 0)
        {
          locali = iTj();
          if (locali != null)
          {
            AppMethodBeat.o(204743);
            return locali;
          }
        }
      }
      else
      {
        locali = iTj();
        if (locali != null)
        {
          AppMethodBeat.o(204743);
          return locali;
        }
      }
      i locali = JJ(false);
      AppMethodBeat.o(204743);
      return locali;
    }
    
    private final i JJ(boolean paramBoolean)
    {
      AppMethodBeat.i(204745);
      Object localObject;
      if (ap.iRg())
      {
        if (this.abzV.iTn() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          localObject = (Throwable)new AssertionError();
          AppMethodBeat.o(204745);
          throw ((Throwable)localObject);
        }
      }
      int m = a.b(this.abAc);
      if (m < 2)
      {
        AppMethodBeat.o(204745);
        return null;
      }
      int i = aFV(m);
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
        localObject = (b)this.abAc.abzO.get(i);
        if ((localObject != null) && (localObject != (b)this))
        {
          if (ap.iRg())
          {
            if (this.abzV.iTn() == 0) {}
            for (int k = 1; k == 0; k = 0)
            {
              localObject = (Throwable)new AssertionError();
              AppMethodBeat.o(204745);
              throw ((Throwable)localObject);
            }
          }
          if (paramBoolean) {}
          for (long l2 = this.abzV.b(((b)localObject).abzV); l2 == -1L; l2 = this.abzV.a(((b)localObject).abzV))
          {
            localObject = this.abzV.iTo();
            AppMethodBeat.o(204745);
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
            this.abzZ = l1;
            AppMethodBeat.o(204745);
            return null;
            l1 = 0L;
          }
        }
      }
    }
    
    private void aFU(int paramInt)
    {
      AppMethodBeat.i(118015);
      StringBuilder localStringBuilder = new StringBuilder().append(this.abAc.abzS).append("-worker-");
      if (paramInt == 0) {}
      for (String str = "TERMINATED";; str = String.valueOf(paramInt))
      {
        setName(str);
        this.indexInArray = paramInt;
        AppMethodBeat.o(118015);
        return;
      }
    }
    
    private int aFV(int paramInt)
    {
      int i = this.abAa;
      i ^= i << 13;
      i ^= i >> 17;
      i ^= i << 5;
      this.abAa = i;
      int j = paramInt - 1;
      if ((j & paramInt) == 0) {
        return i & j;
      }
      return (i & 0x7FFFFFFF) % paramInt;
    }
    
    private final boolean iTg()
    {
      AppMethodBeat.i(118017);
      if (this.abzW == a.c.abAd)
      {
        AppMethodBeat.o(118017);
        return true;
      }
      a locala = this.abAc;
      long l = locala.controlState;
      if ((int)((0x0 & l) >> 42) == 0) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label91;
        }
        this.abzW = a.c.abAd;
        AppMethodBeat.o(118017);
        return true;
        if (!a.abzP.compareAndSet(locala, l, l - 4398046511104L)) {
          break;
        }
      }
      label91:
      AppMethodBeat.o(118017);
      return false;
    }
    
    private final void iTh()
    {
      AppMethodBeat.i(204741);
      int j;
      int i;
      if (!iTi())
      {
        ??? = this.abAc;
        if (this.nextParkedWorker == a.abzT)
        {
          long l;
          int k;
          do
          {
            l = ((a)???).parkedWorkersStack;
            j = (int)(0x1FFFFF & l);
            k = this.indexInArray;
            if (ap.iRg())
            {
              if (k != 0) {}
              for (i = 1; i == 0; i = 0)
              {
                ??? = (Throwable)new AssertionError();
                AppMethodBeat.o(204741);
                throw ((Throwable)???);
              }
            }
            this.nextParkedWorker = ((a)???).abzO.get(j);
          } while (!a.abzN.compareAndSet(???, l, k | 2097152L + l & 0xFFE00000));
        }
        AppMethodBeat.o(204741);
        return;
      }
      if (ap.iRg())
      {
        if (this.abzV.iTn() == 0) {}
        for (i = 1; i == 0; i = 0)
        {
          ??? = (Throwable)new AssertionError();
          AppMethodBeat.o(204741);
          throw ((Throwable)???);
        }
      }
      this.workerCtl = -1;
      while ((iTi()) && (this.abAc._isTerminated == 0) && (this.abzW != a.c.abAh))
      {
        a(a.c.abAf);
        Thread.interrupted();
        if (this.abzY == 0L) {
          this.abzY = (System.nanoTime() + this.abAc.abzR);
        }
        LockSupport.parkNanos(this.abAc.abzR);
        if (System.nanoTime() - this.abzY >= 0L)
        {
          this.abzY = 0L;
          synchronized (this.abAc.abzO)
          {
            i = this.abAc._isTerminated;
            if (i == 0)
            {
              i = a.b(this.abAc);
              j = this.abAc.foy;
              if (i > j)
              {
                boolean bool = abzX.compareAndSet(this, -1, 1);
                if (bool)
                {
                  i = this.indexInArray;
                  aFU(0);
                  this.abAc.a(this, i, 0);
                  Object localObject2 = this.abAc;
                  j = (int)(a.abzP.getAndDecrement(localObject2) & 0x1FFFFF);
                  if (j != i)
                  {
                    localObject2 = this.abAc.abzO.get(j);
                    if (localObject2 == null) {
                      p.iCn();
                    }
                    localObject2 = (b)localObject2;
                    this.abAc.abzO.set(i, localObject2);
                    ((b)localObject2).aFU(i);
                    this.abAc.a((b)localObject2, j, i);
                  }
                  this.abAc.abzO.set(j, null);
                  localObject2 = x.aazN;
                  this.abzW = a.c.abAh;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(204741);
    }
    
    private final boolean iTi()
    {
      return this.nextParkedWorker != a.abzT;
    }
    
    private final i iTj()
    {
      AppMethodBeat.i(204744);
      if (aFV(2) == 0)
      {
        locali = (i)this.abAc.abzL.iSD();
        if (locali != null)
        {
          AppMethodBeat.o(204744);
          return locali;
        }
        locali = (i)this.abAc.abzM.iSD();
        AppMethodBeat.o(204744);
        return locali;
      }
      i locali = (i)this.abAc.abzM.iSD();
      if (locali != null)
      {
        AppMethodBeat.o(204744);
        return locali;
      }
      locali = (i)this.abAc.abzL.iSD();
      AppMethodBeat.o(204744);
      return locali;
    }
    
    public final i JH(boolean paramBoolean)
    {
      AppMethodBeat.i(204742);
      Object localObject1;
      if (iTg())
      {
        localObject1 = JI(paramBoolean);
        AppMethodBeat.o(204742);
        return localObject1;
      }
      if (paramBoolean)
      {
        localObject2 = this.abzV.iTo();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = (i)this.abAc.abzM.iSD();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = JJ(true);
      }
      AppMethodBeat.o(204742);
      return localObject2;
    }
    
    public final boolean a(a.c paramc)
    {
      AppMethodBeat.i(118018);
      a.c localc = this.abzW;
      if (localc == a.c.abAd) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool)
        {
          a locala = this.abAc;
          a.abzP.addAndGet(locala, 4398046511104L);
        }
        if (localc != paramc) {
          this.abzW = paramc;
        }
        AppMethodBeat.o(118018);
        return bool;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(118019);
      int i = 0;
      while ((this.abAc._isTerminated == 0) && (this.abzW != a.c.abAh))
      {
        Object localObject = JH(this.abAb);
        if (localObject != null)
        {
          this.abzZ = 0L;
          int j = ((i)localObject).abAr.iTl();
          this.abzY = 0L;
          if (this.abzW == a.c.abAf)
          {
            if (ap.iRg())
            {
              if (j == 1) {}
              for (i = 1; i == 0; i = 0)
              {
                localObject = (Throwable)new AssertionError();
                AppMethodBeat.o(118019);
                throw ((Throwable)localObject);
              }
            }
            this.abzW = a.c.abAe;
          }
          if ((j != 0) && (a(a.c.abAe))) {
            this.abAc.iTc();
          }
          a.a((i)localObject);
          if (j != 0)
          {
            localObject = this.abAc;
            a.abzP.addAndGet(localObject, -2097152L);
            localObject = this.abzW;
            if (localObject != a.c.abAh)
            {
              if (ap.iRg())
              {
                if (localObject == a.c.abAe) {}
                for (i = 1; i == 0; i = 0)
                {
                  localObject = (Throwable)new AssertionError();
                  AppMethodBeat.o(118019);
                  throw ((Throwable)localObject);
                }
              }
              this.abzW = a.c.abAg;
            }
          }
          i = 0;
        }
        else
        {
          this.abAb = false;
          if (this.abzZ != 0L)
          {
            if (i == 0)
            {
              i = 1;
            }
            else
            {
              a(a.c.abAf);
              Thread.interrupted();
              LockSupport.parkNanos(this.abzZ);
              this.abzZ = 0L;
              i = 0;
            }
          }
          else {
            iTh();
          }
        }
      }
      a(a.c.abAh);
      AppMethodBeat.o(118019);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(118012);
      c localc1 = new c("CPU_ACQUIRED", 0);
      abAd = localc1;
      c localc2 = new c("BLOCKING", 1);
      abAe = localc2;
      c localc3 = new c("PARKING", 2);
      abAf = localc3;
      c localc4 = new c("DORMANT", 3);
      abAg = localc4;
      c localc5 = new c("TERMINATED", 4);
      abAh = localc5;
      abAi = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(118012);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.d.a
 * JD-Core Version:    0.7.0.1
 */