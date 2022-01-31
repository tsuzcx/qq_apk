package kotlinx.coroutines.c;

import a.aa;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.af;
import kotlinx.coroutines.bs;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "_isTerminated", "Lkotlinx/atomicfu/AtomicInt;", "blockingWorkers", "getBlockingWorkers", "()I", "controlState", "Lkotlinx/atomicfu/AtomicLong;", "cpuPermits", "Ljava/util/concurrent/Semaphore;", "createdWorkers", "getCreatedWorkers", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "isTerminated", "", "()Z", "parkedWorkersStack", "random", "Ljava/util/Random;", "workers", "", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "[Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "state", "close", "", "createNewWorker", "createTask", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "createTask$kotlinx_coroutines_core", "decrementBlockingWorkers", "decrementCreatedWorkers", "dispatch", "fair", "execute", "command", "incrementBlockingWorkers", "incrementCreatedWorkers", "parkedWorkersStackNextIndex", "worker", "parkedWorkersStackPop", "parkedWorkersStackPush", "parkedWorkersStackTopUpdate", "oldIndex", "newIndex", "requestCpuWorker", "runSafely", "task", "shutdown", "timeout", "submitToLocalQueue", "toString", "tryUnpark", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"})
public final class a
  implements Closeable, Executor
{
  private static final AtomicLongFieldUpdater CJJ;
  static final AtomicLongFieldUpdater CJM;
  private static final AtomicIntegerFieldUpdater CJO;
  private static final int CJS;
  private static final int CJT;
  private static final kotlinx.coroutines.a.m CJU;
  public static final a.a CJV;
  private final e CJG;
  private final Semaphore CJH;
  private volatile long CJI;
  private final a.b[] CJK;
  volatile long CJL;
  private volatile int CJN;
  private final int CJP;
  private final long CJQ;
  private final String CJR;
  private final int cgb;
  private final Random random;
  
  static
  {
    AppMethodBeat.i(118335);
    CJV = new a.a((byte)0);
    CJS = (int)TimeUnit.SECONDS.toNanos(1L);
    CJT = (int)a.i.e.al(a.i.e.ak(m.CKF / 4L, 10L), CJS);
    CJU = new kotlinx.coroutines.a.m("NOT_IN_STACK");
    CJJ = AtomicLongFieldUpdater.newUpdater(a.class, "CJI");
    CJM = AtomicLongFieldUpdater.newUpdater(a.class, "CJL");
    CJO = AtomicIntegerFieldUpdater.newUpdater(a.class, "CJN");
    AppMethodBeat.o(118335);
  }
  
  public a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    AppMethodBeat.i(118329);
    this.cgb = paramInt1;
    this.CJP = paramInt2;
    this.CJQ = paramLong;
    this.CJR = paramString;
    if (this.cgb > 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Core pool size " + this.cgb + " should be at least 1").toString());
      AppMethodBeat.o(118329);
      throw paramString;
    }
    if (this.CJP >= this.cgb) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.CJP + " should be greater than or equals to core pool size " + this.cgb).toString());
      AppMethodBeat.o(118329);
      throw paramString;
    }
    if (this.CJP <= 2097150) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Max pool size " + this.CJP + " should not exceed maximal supported number of threads 2097150").toString());
      AppMethodBeat.o(118329);
      throw paramString;
    }
    if (this.CJQ > 0L) {}
    for (paramInt1 = i; paramInt1 == 0; paramInt1 = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Idle worker keep alive time " + this.CJQ + " must be positive").toString());
      AppMethodBeat.o(118329);
      throw paramString;
    }
    this.CJG = new e();
    this.CJH = new Semaphore(this.cgb, false);
    this.CJI = 0L;
    this.CJK = new a.b[this.CJP + 1];
    this.CJL = 0L;
    this.random = new Random();
    this.CJN = 0;
    AppMethodBeat.o(118329);
  }
  
  private static int a(a.b paramb)
  {
    for (paramb = paramb.CKc;; paramb = paramb.CKc)
    {
      if (paramb == CJU) {
        return -1;
      }
      if (paramb == null) {
        return 0;
      }
      paramb = (a.b)paramb;
      int i = paramb.CJW;
      if (i != 0) {
        return i;
      }
    }
  }
  
  public static i a(Runnable paramRunnable, j paramj)
  {
    AppMethodBeat.i(118323);
    a.f.b.j.q(paramRunnable, "block");
    a.f.b.j.q(paramj, "taskContext");
    long l = m.CKK.nanoTime();
    if ((paramRunnable instanceof i))
    {
      ((i)paramRunnable).CKz = l;
      ((i)paramRunnable).CKA = paramj;
      paramRunnable = (i)paramRunnable;
      AppMethodBeat.o(118323);
      return paramRunnable;
    }
    paramRunnable = (i)new k(paramRunnable, l, paramj);
    AppMethodBeat.o(118323);
    return paramRunnable;
  }
  
  private static void a(i parami)
  {
    AppMethodBeat.i(118328);
    try
    {
      parami.run();
      return;
    }
    catch (Throwable parami)
    {
      Thread localThread = Thread.currentThread();
      a.f.b.j.p(localThread, "thread");
      localThread.getUncaughtExceptionHandler().uncaughtException(localThread, parami);
      return;
    }
    finally
    {
      bs.eqa();
      AppMethodBeat.o(118328);
    }
  }
  
  private final a.b eqr()
  {
    AppMethodBeat.i(118318);
    long l;
    int i;
    a.b localb;
    do
    {
      l = this.CJI;
      i = (int)(0x1FFFFF & l);
      localb = this.CJK[i];
      if (localb == null)
      {
        AppMethodBeat.o(118318);
        return null;
      }
      i = a(localb);
    } while ((i < 0) || (!CJJ.compareAndSet(this, l, 0xFFE00000 & 2097152L + l | i)));
    localb.CKc = CJU;
    AppMethodBeat.o(118318);
    return localb;
  }
  
  private final void eqs()
  {
    AppMethodBeat.i(118324);
    if (this.CJH.availablePermits() == 0)
    {
      eqt();
      AppMethodBeat.o(118324);
      return;
    }
    if (eqt())
    {
      AppMethodBeat.o(118324);
      return;
    }
    long l = this.CJL;
    if ((int)(0x1FFFFF & l) - (int)((l & 0xFFE00000) >> 21) < this.cgb)
    {
      int i = equ();
      if ((i == 1) && (this.cgb > 1)) {
        equ();
      }
      if (i > 0)
      {
        AppMethodBeat.o(118324);
        return;
      }
    }
    eqt();
    AppMethodBeat.o(118324);
  }
  
  private final boolean eqt()
  {
    AppMethodBeat.i(118325);
    a.b localb;
    boolean bool;
    do
    {
      localb = eqr();
      if (localb == null)
      {
        AppMethodBeat.o(118325);
        return false;
      }
      localb.eqC();
      bool = localb.eqy();
      LockSupport.unpark((Thread)localb);
    } while ((!bool) || (!localb.eqz()));
    AppMethodBeat.o(118325);
    return true;
  }
  
  private final int equ()
  {
    int j = 0;
    AppMethodBeat.i(118326);
    int k;
    int m;
    for (;;)
    {
      synchronized (this.CJK)
      {
        boolean bool = isTerminated();
        if (bool)
        {
          AppMethodBeat.o(118326);
          return -1;
        }
        long l = this.CJL;
        i = (int)(l & 0x1FFFFF);
        k = i - (int)((l & 0xFFE00000) >> 21);
        m = this.cgb;
        if (k >= m)
        {
          AppMethodBeat.o(118326);
          return 0;
        }
        if (i < this.CJP)
        {
          i = this.CJH.availablePermits();
          if (i != 0) {}
        }
        else
        {
          AppMethodBeat.o(118326);
          return 0;
        }
        m = (int)(this.CJL & 0x1FFFFF) + 1;
        if ((m > 0) && (this.CJK[m] == null))
        {
          i = 1;
          if (i != 0) {
            break;
          }
          Throwable localThrowable = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
          AppMethodBeat.o(118326);
          throw localThrowable;
        }
      }
      i = 0;
    }
    Object localObject2 = new a.b(this, m);
    ((a.b)localObject2).start();
    int i = j;
    if (m == (int)(CJM.incrementAndGet(this) & 0x1FFFFF)) {
      i = 1;
    }
    if (i == 0)
    {
      localObject2 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(118326);
      throw ((Throwable)localObject2);
    }
    this.CJK[m] = localObject2;
    AppMethodBeat.o(118326);
    return k + 1;
  }
  
  private final boolean isTerminated()
  {
    return this.CJN != 0;
  }
  
  public final void a(Runnable paramRunnable, j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(118321);
    a.f.b.j.q(paramRunnable, "block");
    a.f.b.j.q(paramj, "taskContext");
    bs.eqa();
    i locali = a(paramRunnable, paramj);
    paramj = Thread.currentThread();
    paramRunnable = paramj;
    if (!(paramj instanceof a.b)) {
      paramRunnable = null;
    }
    paramRunnable = (a.b)paramRunnable;
    int i;
    if (paramRunnable == null) {
      i = 1;
    }
    for (;;)
    {
      switch (i)
      {
      case 0: 
      default: 
        eqs();
        AppMethodBeat.o(118321);
        return;
        if (paramRunnable.CKi != (a)this)
        {
          i = 1;
        }
        else if (paramRunnable.CJY == a.c.CKn)
        {
          i = 1;
        }
        else
        {
          int j = -1;
          i = j;
          if (locali.eqJ() == l.CKC)
          {
            if (paramRunnable.CJY == a.c.CKk)
            {
              i = 1;
              label163:
              if (i == 0) {
                break label215;
              }
              i = 0;
            }
          }
          else {
            label171:
            if (!paramBoolean) {
              break label232;
            }
          }
          label215:
          label232:
          for (paramBoolean = paramRunnable.CJX.b(locali, this.CJG);; paramBoolean = paramRunnable.CJX.a(locali, this.CJG))
          {
            if ((!paramBoolean) || (paramRunnable.CJX.eqK() > m.CKG)) {
              break label249;
            }
            break;
            i = 0;
            break label163;
            i = j;
            if (paramRunnable.eqA()) {
              break label171;
            }
            i = 1;
            break;
          }
          label249:
          i = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(118321);
    return;
    if (!this.CJG.ei(locali))
    {
      paramRunnable = (Throwable)new RejectedExecutionException(this.CJR + " was terminated");
      AppMethodBeat.o(118321);
      throw paramRunnable;
    }
    eqs();
    AppMethodBeat.o(118321);
  }
  
  public final void close()
  {
    int k = 1;
    AppMethodBeat.i(118320);
    if (CJO.compareAndSet(this, 0, 1))
    {
      Thread localThread = Thread.currentThread();
      ??? = localThread;
      if (!(localThread instanceof a.b)) {
        ??? = null;
      }
      a.b localb = (a.b)???;
      Object localObject3;
      for (;;)
      {
        int m;
        synchronized (this.CJK)
        {
          long l = this.CJL;
          m = (int)(l & 0x1FFFFF);
          if (m <= 0) {
            break;
          }
          i = 1;
          ??? = this.CJK[i];
          if (??? == null) {
            a.f.b.j.ebi();
          }
          if (??? == localb) {
            break label218;
          }
          if (((a.b)???).isAlive())
          {
            LockSupport.unpark((Thread)???);
            ((a.b)???).join(10000L);
          }
        }
        for (int j = 1; j == 0; j = 0)
        {
          ??? = (Throwable)new IllegalStateException("Expected TERMINATED state, but found ".concat(String.valueOf(localObject3)).toString());
          AppMethodBeat.o(118320);
          throw ((Throwable)???);
        }
        ((a.b)???).CJX.b(this.CJG);
        label218:
        if (i == m) {
          break;
        }
        i += 1;
      }
      this.CJG.close();
      if (localb != null)
      {
        localObject3 = localb.eqD();
        ??? = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        ??? = (i)this.CJG.eqc();
      }
      if (??? == null)
      {
        if (localb != null) {
          localb.a(a.c.CKn);
        }
        if (this.CJH.availablePermits() != this.cgb) {
          break label348;
        }
      }
      label348:
      for (int i = k;; i = 0)
      {
        if ((!aa.BMh) || (i != 0)) {
          break label353;
        }
        ??? = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(118320);
        throw ((Throwable)???);
        a((i)???);
        break;
      }
      label353:
      this.CJI = 0L;
      this.CJL = 0L;
    }
    AppMethodBeat.o(118320);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(118319);
    a.f.b.j.q(paramRunnable, "command");
    a(this, paramRunnable);
    AppMethodBeat.o(118319);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118327);
    Object localObject1 = new ArrayList();
    a.b[] arrayOfb = this.CJK;
    int i4 = arrayOfb.length;
    int m = 0;
    int j = 0;
    int i = 0;
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    if (m < i4)
    {
      Object localObject2 = arrayOfb[m];
      int k = i;
      o localo;
      int i3;
      if (localObject2 != null)
      {
        localo = ((a.b)localObject2).CJX;
        if (localo.CKM != null)
        {
          i3 = localo.eqK() + 1;
          label87:
          localObject2 = ((a.b)localObject2).CJY;
        }
      }
      else
      {
        switch (b.bLo[localObject2.ordinal()])
        {
        default: 
          k = i;
          label138:
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        m += 1;
        k = j;
        j = i;
        i = k;
        break;
        i3 = localo.eqK();
        break label87;
        n += 1;
        k = i;
        i = j;
        j = k;
        continue;
        i1 += 1;
        ((Collection)localObject1).add(String.valueOf(i3) + "b");
        k = i;
        i = j;
        j = k;
        continue;
        i2 += 1;
        ((Collection)localObject1).add(String.valueOf(i3) + "c");
        k = i;
        i = j;
        j = k;
        continue;
        i += 1;
        k = i;
        if (i3 <= 0) {
          break label138;
        }
        ((Collection)localObject1).add(String.valueOf(i3) + "r");
        k = i;
        i = j;
        j = k;
        continue;
        k = j + 1;
        j = i;
        i = k;
      }
    }
    long l1 = this.CJL;
    localObject1 = new StringBuilder().append(this.CJR).append('@').append(af.dZ(this)).append('[').append("Pool Size {core = ").append(this.cgb).append(", max = ").append(this.CJP).append("}, Worker States {CPU = ").append(i2).append(", blocking = ").append(i1).append(", parked = ").append(n).append(", retired = ").append(i).append(", terminated = ").append(j).append("}, running workers queues = ").append(localObject1).append(", global queue size = ");
    long l2 = ((kotlinx.coroutines.a.j)this.CJG.CJk).CJm;
    i = (int)((0x3FFFFFFF & l2) >> 0);
    localObject1 = ((int)((l2 & 0xC0000000) >> 30) - i & 0x3FFFFFFF) + ", Control State Workers {created = " + (int)(0x1FFFFF & l1) + ", blocking = " + (int)((0xFFE00000 & l1) >> 21) + '}' + "]";
    AppMethodBeat.o(118327);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.c.a
 * JD-Core Version:    0.7.0.1
 */