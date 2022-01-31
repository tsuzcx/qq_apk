package kotlinx.coroutines.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "()V", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Lkotlinx/coroutines/scheduling/Task;", "bufferSize", "", "getBufferSize$kotlinx_coroutines_core", "()I", "consumerIndex", "Lkotlinx/atomicfu/AtomicInt;", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicRef;", "producerIndex", "add", "", "task", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "addLast", "addToGlobalQueue", "", "offloadAllWork", "offloadAllWork$kotlinx_coroutines_core", "offloadWork", "poll", "pollExternal", "predicate", "Lkotlin/Function1;", "size", "size$kotlinx_coroutines_core", "tryAddLast", "trySteal", "victim", "tryStealLastScheduled", "time", "", "kotlinx-coroutines-core"})
public final class o
{
  private static final AtomicReferenceFieldUpdater CKN;
  static final AtomicIntegerFieldUpdater CKP;
  static final AtomicIntegerFieldUpdater CKR;
  private final AtomicReferenceArray<i> CKL;
  volatile Object CKM;
  volatile int CKO;
  volatile int CKQ;
  
  static
  {
    AppMethodBeat.i(118313);
    CKN = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "CKM");
    CKP = AtomicIntegerFieldUpdater.newUpdater(o.class, "CKO");
    CKR = AtomicIntegerFieldUpdater.newUpdater(o.class, "CKQ");
    AppMethodBeat.o(118313);
  }
  
  public o()
  {
    AppMethodBeat.i(118312);
    this.CKL = new AtomicReferenceArray(128);
    this.CKM = null;
    this.CKO = 0;
    this.CKQ = 0;
    AppMethodBeat.o(118312);
  }
  
  private final void a(e parame)
  {
    AppMethodBeat.i(118308);
    int j = a.i.e.iE(eqK() / 2, 1);
    int i = 0;
    while (i < j)
    {
      int k = this.CKQ;
      if (k - this.CKO == 0) {}
      int m;
      for (i locali = null;; locali = (i)this.CKL.getAndSet(m, null))
      {
        if (locali != null) {
          break label109;
        }
        AppMethodBeat.o(118308);
        return;
        m = k & 0x7F;
        if (((i)this.CKL.get(m) == null) || (!CKR.compareAndSet(this, k, k + 1))) {
          break;
        }
      }
      label109:
      a(parame, locali);
      i += 1;
    }
    AppMethodBeat.o(118308);
  }
  
  private static void a(e parame, i parami)
  {
    AppMethodBeat.i(118309);
    if (!parame.ei(parami))
    {
      parame = (Throwable)new IllegalStateException("GlobalQueue could not be closed yet".toString());
      AppMethodBeat.o(118309);
      throw parame;
    }
    AppMethodBeat.o(118309);
  }
  
  private final boolean a(long paramLong, o paramo, e parame)
  {
    AppMethodBeat.i(118307);
    i locali = (i)paramo.CKM;
    if (locali == null)
    {
      AppMethodBeat.o(118307);
      return false;
    }
    if (paramLong - locali.CKz < m.CKF)
    {
      AppMethodBeat.o(118307);
      return false;
    }
    if (CKN.compareAndSet(paramo, locali, null))
    {
      a(locali, parame);
      AppMethodBeat.o(118307);
      return true;
    }
    AppMethodBeat.o(118307);
    return false;
  }
  
  private final boolean c(i parami)
  {
    AppMethodBeat.i(118311);
    if (eqK() == 127)
    {
      AppMethodBeat.o(118311);
      return false;
    }
    int i = this.CKO & 0x7F;
    if (this.CKL.get(i) != null)
    {
      AppMethodBeat.o(118311);
      return false;
    }
    this.CKL.lazySet(i, parami);
    CKP.incrementAndGet(this);
    AppMethodBeat.o(118311);
    return true;
  }
  
  public final boolean a(i parami, e parame)
  {
    AppMethodBeat.i(118304);
    j.q(parami, "task");
    j.q(parame, "globalQueue");
    parami = (i)CKN.getAndSet(this, parami);
    if (parami == null)
    {
      AppMethodBeat.o(118304);
      return true;
    }
    boolean bool = b(parami, parame);
    AppMethodBeat.o(118304);
    return bool;
  }
  
  public final boolean a(o paramo, e parame)
  {
    AppMethodBeat.i(118306);
    j.q(paramo, "victim");
    j.q(parame, "globalQueue");
    long l = m.CKK.nanoTime();
    int i = paramo.eqK();
    if (i == 0)
    {
      bool = a(l, paramo, parame);
      AppMethodBeat.o(118306);
      return bool;
    }
    boolean bool = false;
    int k = a.i.e.iE(i / 2, 1);
    i = 0;
    while (i < k)
    {
      int m = paramo.CKQ;
      i locali;
      if (m - paramo.CKO == 0) {
        locali = null;
      }
      for (;;)
      {
        if (locali != null) {
          break label209;
        }
        AppMethodBeat.o(118306);
        return bool;
        int n = m & 0x7F;
        locali = (i)paramo.CKL.get(n);
        if (locali == null) {
          break;
        }
        if ((l - locali.CKz >= m.CKF) || (paramo.eqK() > m.CKG)) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            break label175;
          }
          locali = null;
          break;
        }
        label175:
        if (!CKR.compareAndSet(paramo, m, m + 1)) {
          break;
        }
        locali = (i)paramo.CKL.getAndSet(n, null);
      }
      label209:
      bool = true;
      a(locali, parame);
      i += 1;
    }
    AppMethodBeat.o(118306);
    return bool;
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(118310);
    j.q(parame, "globalQueue");
    i locali = (i)CKN.getAndSet(this, null);
    if (locali != null) {
      a(parame, locali);
    }
    for (;;)
    {
      int i = this.CKQ;
      if (i - this.CKO == 0) {}
      int j;
      for (locali = null;; locali = (i)this.CKL.getAndSet(j, null))
      {
        if (locali != null) {
          break label113;
        }
        AppMethodBeat.o(118310);
        return;
        j = i & 0x7F;
        if (((i)this.CKL.get(j) == null) || (!CKR.compareAndSet(this, i, i + 1))) {
          break;
        }
      }
      label113:
      a(parame, locali);
    }
  }
  
  public final boolean b(i parami, e parame)
  {
    AppMethodBeat.i(118305);
    j.q(parami, "task");
    j.q(parame, "globalQueue");
    for (boolean bool = true; !c(parami); bool = false) {
      a(parame);
    }
    AppMethodBeat.o(118305);
    return bool;
  }
  
  public final int eqK()
  {
    return this.CKO - this.CKQ;
  }
  
  public final i eqL()
  {
    AppMethodBeat.i(118303);
    i locali = (i)CKN.getAndSet(this, null);
    if (locali == null)
    {
      int i;
      int j;
      do
      {
        i = this.CKQ;
        if (i - this.CKO == 0)
        {
          AppMethodBeat.o(118303);
          return null;
        }
        j = i & 0x7F;
      } while (((i)this.CKL.get(j) == null) || (!CKR.compareAndSet(this, i, i + 1)));
      locali = (i)this.CKL.getAndSet(j, null);
      AppMethodBeat.o(118303);
      return locali;
    }
    AppMethodBeat.o(118303);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.c.o
 * JD-Core Version:    0.7.0.1
 */