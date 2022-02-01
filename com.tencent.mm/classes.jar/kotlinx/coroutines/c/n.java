package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ah;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""})
public final class n
{
  private static final AtomicIntegerFieldUpdater KgA;
  private static final AtomicIntegerFieldUpdater KgB;
  private static final AtomicIntegerFieldUpdater KgC;
  private static final AtomicReferenceFieldUpdater Kgz;
  private final AtomicReferenceArray<i> Kgy;
  private volatile int blockingTasksInBuffer;
  private volatile int consumerIndex;
  private volatile Object lastScheduledTask;
  private volatile int producerIndex;
  
  static
  {
    AppMethodBeat.i(117989);
    Kgz = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");
    KgA = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");
    KgB = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");
    KgC = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");
    AppMethodBeat.o(117989);
  }
  
  public n()
  {
    AppMethodBeat.i(117988);
    this.Kgy = new AtomicReferenceArray(128);
    this.lastScheduledTask = null;
    this.producerIndex = 0;
    this.consumerIndex = 0;
    this.blockingTasksInBuffer = 0;
    AppMethodBeat.o(117988);
  }
  
  private final long a(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(190012);
    i locali;
    do
    {
      locali = (i)paramn.lastScheduledTask;
      if (locali == null)
      {
        AppMethodBeat.o(190012);
        return -2L;
      }
      if (paramBoolean)
      {
        if (locali.Kgs.fMh() == 1) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(190012);
          return -2L;
        }
      }
      long l1 = l.Kgx.nanoTime() - locali.Kgr;
      if (l1 < l.Kgu)
      {
        long l2 = l.Kgu;
        AppMethodBeat.o(190012);
        return l2 - l1;
      }
    } while (!Kgz.compareAndSet(paramn, locali, null));
    a(locali, false);
    AppMethodBeat.o(190012);
    return -1L;
  }
  
  private final i b(i parami)
  {
    int i = 1;
    AppMethodBeat.i(190008);
    if (parami.Kgs.fMh() == 1) {}
    for (;;)
    {
      if (i != 0) {
        KgC.incrementAndGet(this);
      }
      if (fMi() != 127) {
        break;
      }
      AppMethodBeat.o(190008);
      return parami;
      i = 0;
    }
    i = this.producerIndex & 0x7F;
    while (this.Kgy.get(i) != null) {
      Thread.yield();
    }
    this.Kgy.lazySet(i, parami);
    KgA.incrementAndGet(this);
    AppMethodBeat.o(190008);
    return null;
  }
  
  private final void c(i parami)
  {
    int j = 1;
    AppMethodBeat.i(190014);
    if (parami != null)
    {
      if (parami.Kgs.fMh() == 1)
      {
        i = 1;
        if (i == 0) {
          break label82;
        }
        i = KgC.decrementAndGet(this);
        if (!ah.fKW()) {
          break label82;
        }
        if (i < 0) {
          break label77;
        }
      }
      label77:
      for (int i = j;; i = 0)
      {
        if (i != 0) {
          break label82;
        }
        parami = (Throwable)new AssertionError();
        AppMethodBeat.o(190014);
        throw parami;
        i = 0;
        break;
      }
    }
    label82:
    AppMethodBeat.o(190014);
  }
  
  private int fMi()
  {
    return this.producerIndex - this.consumerIndex;
  }
  
  private final i fMl()
  {
    AppMethodBeat.i(190013);
    i locali;
    do
    {
      int i;
      do
      {
        i = this.consumerIndex;
        if (i - this.producerIndex == 0)
        {
          AppMethodBeat.o(190013);
          return null;
        }
      } while (!KgB.compareAndSet(this, i, i + 1));
      locali = (i)this.Kgy.getAndSet(i & 0x7F, null);
    } while (locali == null);
    c(locali);
    AppMethodBeat.o(190013);
    return locali;
  }
  
  public final long a(n paramn)
  {
    int j = 1;
    AppMethodBeat.i(190009);
    int i;
    if (ah.fKW())
    {
      if (fMi() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(190009);
        throw paramn;
      }
    }
    i locali = paramn.fMl();
    if (locali != null)
    {
      paramn = a(this, locali);
      if (ah.fKW())
      {
        if (paramn == null) {}
        for (i = j; i == 0; i = 0)
        {
          paramn = (Throwable)new AssertionError();
          AppMethodBeat.o(190009);
          throw paramn;
        }
      }
      AppMethodBeat.o(190009);
      return -1L;
    }
    long l = a(paramn, false);
    AppMethodBeat.o(190009);
    return l;
  }
  
  public final i a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(190006);
    if (paramBoolean)
    {
      parami = b(parami);
      AppMethodBeat.o(190006);
      return parami;
    }
    parami = (i)Kgz.getAndSet(this, parami);
    if (parami == null)
    {
      AppMethodBeat.o(190006);
      return null;
    }
    parami = b(parami);
    AppMethodBeat.o(190006);
    return parami;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(190011);
    i locali = (i)Kgz.getAndSet(this, null);
    if (locali != null) {
      parame.fN(locali);
    }
    for (;;)
    {
      locali = fMl();
      if (locali == null) {}
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(190011);
        return;
        parame.fN(locali);
      }
    }
  }
  
  public final long b(n paramn)
  {
    AppMethodBeat.i(190010);
    if (ah.fKW())
    {
      if (fMi() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(190010);
        throw paramn;
      }
    }
    int i = paramn.consumerIndex;
    int k = paramn.producerIndex;
    AtomicReferenceArray localAtomicReferenceArray = paramn.Kgy;
    while (i != k)
    {
      int m = i & 0x7F;
      if (paramn.blockingTasksInBuffer == 0) {
        break;
      }
      i locali = (i)localAtomicReferenceArray.get(m);
      if (locali != null)
      {
        if (locali.Kgs.fMh() == 1) {}
        for (int j = 1; (j != 0) && (localAtomicReferenceArray.compareAndSet(m, locali, null)); j = 0)
        {
          KgC.decrementAndGet(paramn);
          a(this, locali);
          AppMethodBeat.o(190010);
          return -1L;
        }
      }
      i += 1;
    }
    long l = a(paramn, true);
    AppMethodBeat.o(190010);
    return l;
  }
  
  public final int fMj()
  {
    AppMethodBeat.i(190005);
    if (this.lastScheduledTask != null)
    {
      i = fMi();
      AppMethodBeat.o(190005);
      return i + 1;
    }
    int i = fMi();
    AppMethodBeat.o(190005);
    return i;
  }
  
  public final i fMk()
  {
    AppMethodBeat.i(117979);
    i locali2 = (i)Kgz.getAndSet(this, null);
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = fMl();
    }
    AppMethodBeat.o(117979);
    return locali1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.n
 * JD-Core Version:    0.7.0.1
 */