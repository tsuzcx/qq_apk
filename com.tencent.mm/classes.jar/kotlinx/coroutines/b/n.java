package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.am;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""})
public final class n
{
  private static final AtomicReferenceFieldUpdater NLe;
  private static final AtomicIntegerFieldUpdater NLf;
  private static final AtomicIntegerFieldUpdater NLg;
  private static final AtomicIntegerFieldUpdater NLh;
  private final AtomicReferenceArray<i> NLd;
  private volatile int blockingTasksInBuffer;
  private volatile int consumerIndex;
  private volatile Object lastScheduledTask;
  private volatile int producerIndex;
  
  static
  {
    AppMethodBeat.i(117989);
    NLe = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");
    NLf = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");
    NLg = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");
    NLh = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");
    AppMethodBeat.o(117989);
  }
  
  public n()
  {
    AppMethodBeat.i(117988);
    this.NLd = new AtomicReferenceArray(128);
    this.lastScheduledTask = null;
    this.producerIndex = 0;
    this.consumerIndex = 0;
    this.blockingTasksInBuffer = 0;
    AppMethodBeat.o(117988);
  }
  
  private final long a(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(190734);
    i locali;
    do
    {
      locali = (i)paramn.lastScheduledTask;
      if (locali == null)
      {
        AppMethodBeat.o(190734);
        return -2L;
      }
      if (paramBoolean)
      {
        if (locali.NKX.gww() == 1) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(190734);
          return -2L;
        }
      }
      long l1 = l.NLc.nanoTime() - locali.NKW;
      if (l1 < l.NKZ)
      {
        long l2 = l.NKZ;
        AppMethodBeat.o(190734);
        return l2 - l1;
      }
    } while (!NLe.compareAndSet(paramn, locali, null));
    a(locali, false);
    AppMethodBeat.o(190734);
    return -1L;
  }
  
  private final i b(i parami)
  {
    int i = 1;
    AppMethodBeat.i(190730);
    if (parami.NKX.gww() == 1) {}
    for (;;)
    {
      if (i != 0) {
        NLh.incrementAndGet(this);
      }
      if (gwx() != 127) {
        break;
      }
      AppMethodBeat.o(190730);
      return parami;
      i = 0;
    }
    i = this.producerIndex & 0x7F;
    while (this.NLd.get(i) != null) {
      Thread.yield();
    }
    this.NLd.lazySet(i, parami);
    NLf.incrementAndGet(this);
    AppMethodBeat.o(190730);
    return null;
  }
  
  private final void c(i parami)
  {
    int j = 1;
    AppMethodBeat.i(190736);
    if (parami != null)
    {
      if (parami.NKX.gww() == 1)
      {
        i = 1;
        if (i == 0) {
          break label82;
        }
        i = NLh.decrementAndGet(this);
        if (!am.gvd()) {
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
        AppMethodBeat.o(190736);
        throw parami;
        i = 0;
        break;
      }
    }
    label82:
    AppMethodBeat.o(190736);
  }
  
  private final i gwA()
  {
    AppMethodBeat.i(190735);
    i locali;
    do
    {
      int i;
      do
      {
        i = this.consumerIndex;
        if (i - this.producerIndex == 0)
        {
          AppMethodBeat.o(190735);
          return null;
        }
      } while (!NLg.compareAndSet(this, i, i + 1));
      locali = (i)this.NLd.getAndSet(i & 0x7F, null);
    } while (locali == null);
    c(locali);
    AppMethodBeat.o(190735);
    return locali;
  }
  
  private int gwx()
  {
    return this.producerIndex - this.consumerIndex;
  }
  
  public final long a(n paramn)
  {
    int j = 1;
    AppMethodBeat.i(190731);
    int i;
    if (am.gvd())
    {
      if (gwx() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(190731);
        throw paramn;
      }
    }
    i locali = paramn.gwA();
    if (locali != null)
    {
      paramn = a(this, locali);
      if (am.gvd())
      {
        if (paramn == null) {}
        for (i = j; i == 0; i = 0)
        {
          paramn = (Throwable)new AssertionError();
          AppMethodBeat.o(190731);
          throw paramn;
        }
      }
      AppMethodBeat.o(190731);
      return -1L;
    }
    long l = a(paramn, false);
    AppMethodBeat.o(190731);
    return l;
  }
  
  public final i a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(190728);
    if (paramBoolean)
    {
      parami = b(parami);
      AppMethodBeat.o(190728);
      return parami;
    }
    parami = (i)NLe.getAndSet(this, parami);
    if (parami == null)
    {
      AppMethodBeat.o(190728);
      return null;
    }
    parami = b(parami);
    AppMethodBeat.o(190728);
    return parami;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(190733);
    i locali = (i)NLe.getAndSet(this, null);
    if (locali != null) {
      parame.fY(locali);
    }
    for (;;)
    {
      locali = gwA();
      if (locali == null) {}
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(190733);
        return;
        parame.fY(locali);
      }
    }
  }
  
  public final long b(n paramn)
  {
    AppMethodBeat.i(190732);
    if (am.gvd())
    {
      if (gwx() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(190732);
        throw paramn;
      }
    }
    int i = paramn.consumerIndex;
    int k = paramn.producerIndex;
    AtomicReferenceArray localAtomicReferenceArray = paramn.NLd;
    while (i != k)
    {
      int m = i & 0x7F;
      if (paramn.blockingTasksInBuffer == 0) {
        break;
      }
      i locali = (i)localAtomicReferenceArray.get(m);
      if (locali != null)
      {
        if (locali.NKX.gww() == 1) {}
        for (int j = 1; (j != 0) && (localAtomicReferenceArray.compareAndSet(m, locali, null)); j = 0)
        {
          NLh.decrementAndGet(paramn);
          a(this, locali);
          AppMethodBeat.o(190732);
          return -1L;
        }
      }
      i += 1;
    }
    long l = a(paramn, true);
    AppMethodBeat.o(190732);
    return l;
  }
  
  public final int gwy()
  {
    AppMethodBeat.i(190727);
    if (this.lastScheduledTask != null)
    {
      i = gwx();
      AppMethodBeat.o(190727);
      return i + 1;
    }
    int i = gwx();
    AppMethodBeat.o(190727);
    return i;
  }
  
  public final i gwz()
  {
    AppMethodBeat.i(117979);
    i locali2 = (i)NLe.getAndSet(this, null);
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = gwA();
    }
    AppMethodBeat.o(117979);
    return locali1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.n
 * JD-Core Version:    0.7.0.1
 */