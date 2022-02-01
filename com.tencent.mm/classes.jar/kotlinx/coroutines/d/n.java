package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ap;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""})
public final class n
{
  private static final AtomicIntegerFieldUpdater abAA;
  private static final AtomicReferenceFieldUpdater abAx;
  private static final AtomicIntegerFieldUpdater abAy;
  private static final AtomicIntegerFieldUpdater abAz;
  private final AtomicReferenceArray<i> abAw;
  private volatile int blockingTasksInBuffer;
  private volatile int consumerIndex;
  private volatile Object lastScheduledTask;
  private volatile int producerIndex;
  
  static
  {
    AppMethodBeat.i(117989);
    abAx = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");
    abAy = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");
    abAz = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");
    abAA = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");
    AppMethodBeat.o(117989);
  }
  
  public n()
  {
    AppMethodBeat.i(117988);
    this.abAw = new AtomicReferenceArray(128);
    this.lastScheduledTask = null;
    this.producerIndex = 0;
    this.consumerIndex = 0;
    this.blockingTasksInBuffer = 0;
    AppMethodBeat.o(117988);
  }
  
  private final long a(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(204733);
    i locali;
    do
    {
      locali = (i)paramn.lastScheduledTask;
      if (locali == null)
      {
        AppMethodBeat.o(204733);
        return -2L;
      }
      if (paramBoolean)
      {
        if (locali.abAr.iTl() == 1) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(204733);
          return -2L;
        }
      }
      long l1 = l.abAv.nanoTime() - locali.abAq;
      if (l1 < l.abAs)
      {
        long l2 = l.abAs;
        AppMethodBeat.o(204733);
        return l2 - l1;
      }
    } while (!abAx.compareAndSet(paramn, locali, null));
    a(locali, false);
    AppMethodBeat.o(204733);
    return -1L;
  }
  
  private final i b(i parami)
  {
    int i = 1;
    AppMethodBeat.i(204728);
    if (parami.abAr.iTl() == 1) {}
    for (;;)
    {
      if (i != 0) {
        abAA.incrementAndGet(this);
      }
      if (iTm() != 127) {
        break;
      }
      AppMethodBeat.o(204728);
      return parami;
      i = 0;
    }
    i = this.producerIndex & 0x7F;
    while (this.abAw.get(i) != null) {
      Thread.yield();
    }
    this.abAw.lazySet(i, parami);
    abAy.incrementAndGet(this);
    AppMethodBeat.o(204728);
    return null;
  }
  
  private final void c(i parami)
  {
    int j = 1;
    AppMethodBeat.i(204735);
    if (parami != null)
    {
      if (parami.abAr.iTl() == 1)
      {
        i = 1;
        if (i == 0) {
          break label82;
        }
        i = abAA.decrementAndGet(this);
        if (!ap.iRg()) {
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
        AppMethodBeat.o(204735);
        throw parami;
        i = 0;
        break;
      }
    }
    label82:
    AppMethodBeat.o(204735);
  }
  
  private int iTm()
  {
    return this.producerIndex - this.consumerIndex;
  }
  
  private final i iTp()
  {
    AppMethodBeat.i(204734);
    i locali;
    do
    {
      int i;
      do
      {
        i = this.consumerIndex;
        if (i - this.producerIndex == 0)
        {
          AppMethodBeat.o(204734);
          return null;
        }
      } while (!abAz.compareAndSet(this, i, i + 1));
      locali = (i)this.abAw.getAndSet(i & 0x7F, null);
    } while (locali == null);
    c(locali);
    AppMethodBeat.o(204734);
    return locali;
  }
  
  public final long a(n paramn)
  {
    int j = 1;
    AppMethodBeat.i(204729);
    int i;
    if (ap.iRg())
    {
      if (iTm() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(204729);
        throw paramn;
      }
    }
    i locali = paramn.iTp();
    if (locali != null)
    {
      paramn = a(this, locali);
      if (ap.iRg())
      {
        if (paramn == null) {}
        for (i = j; i == 0; i = 0)
        {
          paramn = (Throwable)new AssertionError();
          AppMethodBeat.o(204729);
          throw paramn;
        }
      }
      AppMethodBeat.o(204729);
      return -1L;
    }
    long l = a(paramn, false);
    AppMethodBeat.o(204729);
    return l;
  }
  
  public final i a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(204726);
    if (paramBoolean)
    {
      parami = b(parami);
      AppMethodBeat.o(204726);
      return parami;
    }
    parami = (i)abAx.getAndSet(this, parami);
    if (parami == null)
    {
      AppMethodBeat.o(204726);
      return null;
    }
    parami = b(parami);
    AppMethodBeat.o(204726);
    return parami;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(204732);
    i locali = (i)abAx.getAndSet(this, null);
    if (locali != null) {
      parame.gy(locali);
    }
    for (;;)
    {
      locali = iTp();
      if (locali == null) {}
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(204732);
        return;
        parame.gy(locali);
      }
    }
  }
  
  public final long b(n paramn)
  {
    AppMethodBeat.i(204731);
    if (ap.iRg())
    {
      if (iTm() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(204731);
        throw paramn;
      }
    }
    int i = paramn.consumerIndex;
    int k = paramn.producerIndex;
    AtomicReferenceArray localAtomicReferenceArray = paramn.abAw;
    while (i != k)
    {
      int m = i & 0x7F;
      if (paramn.blockingTasksInBuffer == 0) {
        break;
      }
      i locali = (i)localAtomicReferenceArray.get(m);
      if (locali != null)
      {
        if (locali.abAr.iTl() == 1) {}
        for (int j = 1; (j != 0) && (localAtomicReferenceArray.compareAndSet(m, locali, null)); j = 0)
        {
          abAA.decrementAndGet(paramn);
          a(this, locali);
          AppMethodBeat.o(204731);
          return -1L;
        }
      }
      i += 1;
    }
    long l = a(paramn, true);
    AppMethodBeat.o(204731);
    return l;
  }
  
  public final int iTn()
  {
    AppMethodBeat.i(204725);
    if (this.lastScheduledTask != null)
    {
      i = iTm();
      AppMethodBeat.o(204725);
      return i + 1;
    }
    int i = iTm();
    AppMethodBeat.o(204725);
    return i;
  }
  
  public final i iTo()
  {
    AppMethodBeat.i(117979);
    i locali2 = (i)abAx.getAndSet(this, null);
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = iTp();
    }
    AppMethodBeat.o(117979);
    return locali1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.d.n
 * JD-Core Version:    0.7.0.1
 */