package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.an;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""})
public final class n
{
  private static final AtomicReferenceFieldUpdater TXg;
  private static final AtomicIntegerFieldUpdater TXh;
  private static final AtomicIntegerFieldUpdater TXi;
  private static final AtomicIntegerFieldUpdater TXj;
  private final AtomicReferenceArray<i> TXf;
  private volatile int blockingTasksInBuffer;
  private volatile int consumerIndex;
  private volatile Object lastScheduledTask;
  private volatile int producerIndex;
  
  static
  {
    AppMethodBeat.i(117989);
    TXg = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");
    TXh = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");
    TXi = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");
    TXj = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");
    AppMethodBeat.o(117989);
  }
  
  public n()
  {
    AppMethodBeat.i(117988);
    this.TXf = new AtomicReferenceArray(128);
    this.lastScheduledTask = null;
    this.producerIndex = 0;
    this.consumerIndex = 0;
    this.blockingTasksInBuffer = 0;
    AppMethodBeat.o(117988);
  }
  
  private final long a(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(192360);
    i locali;
    do
    {
      locali = (i)paramn.lastScheduledTask;
      if (locali == null)
      {
        AppMethodBeat.o(192360);
        return -2L;
      }
      if (paramBoolean)
      {
        if (locali.TXa.hOf() == 1) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(192360);
          return -2L;
        }
      }
      long l1 = l.TXe.nanoTime() - locali.TWZ;
      if (l1 < l.TXb)
      {
        long l2 = l.TXb;
        AppMethodBeat.o(192360);
        return l2 - l1;
      }
    } while (!TXg.compareAndSet(paramn, locali, null));
    a(locali, false);
    AppMethodBeat.o(192360);
    return -1L;
  }
  
  private final i b(i parami)
  {
    int i = 1;
    AppMethodBeat.i(192356);
    if (parami.TXa.hOf() == 1) {}
    for (;;)
    {
      if (i != 0) {
        TXj.incrementAndGet(this);
      }
      if (hOg() != 127) {
        break;
      }
      AppMethodBeat.o(192356);
      return parami;
      i = 0;
    }
    i = this.producerIndex & 0x7F;
    while (this.TXf.get(i) != null) {
      Thread.yield();
    }
    this.TXf.lazySet(i, parami);
    TXh.incrementAndGet(this);
    AppMethodBeat.o(192356);
    return null;
  }
  
  private final void c(i parami)
  {
    int j = 1;
    AppMethodBeat.i(192362);
    if (parami != null)
    {
      if (parami.TXa.hOf() == 1)
      {
        i = 1;
        if (i == 0) {
          break label82;
        }
        i = TXj.decrementAndGet(this);
        if (!an.hMK()) {
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
        AppMethodBeat.o(192362);
        throw parami;
        i = 0;
        break;
      }
    }
    label82:
    AppMethodBeat.o(192362);
  }
  
  private int hOg()
  {
    return this.producerIndex - this.consumerIndex;
  }
  
  private final i hOj()
  {
    AppMethodBeat.i(192361);
    i locali;
    do
    {
      int i;
      do
      {
        i = this.consumerIndex;
        if (i - this.producerIndex == 0)
        {
          AppMethodBeat.o(192361);
          return null;
        }
      } while (!TXi.compareAndSet(this, i, i + 1));
      locali = (i)this.TXf.getAndSet(i & 0x7F, null);
    } while (locali == null);
    c(locali);
    AppMethodBeat.o(192361);
    return locali;
  }
  
  public final long a(n paramn)
  {
    int j = 1;
    AppMethodBeat.i(192357);
    int i;
    if (an.hMK())
    {
      if (hOg() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(192357);
        throw paramn;
      }
    }
    i locali = paramn.hOj();
    if (locali != null)
    {
      paramn = a(this, locali);
      if (an.hMK())
      {
        if (paramn == null) {}
        for (i = j; i == 0; i = 0)
        {
          paramn = (Throwable)new AssertionError();
          AppMethodBeat.o(192357);
          throw paramn;
        }
      }
      AppMethodBeat.o(192357);
      return -1L;
    }
    long l = a(paramn, false);
    AppMethodBeat.o(192357);
    return l;
  }
  
  public final i a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(192354);
    if (paramBoolean)
    {
      parami = b(parami);
      AppMethodBeat.o(192354);
      return parami;
    }
    parami = (i)TXg.getAndSet(this, parami);
    if (parami == null)
    {
      AppMethodBeat.o(192354);
      return null;
    }
    parami = b(parami);
    AppMethodBeat.o(192354);
    return parami;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(192359);
    i locali = (i)TXg.getAndSet(this, null);
    if (locali != null) {
      parame.gg(locali);
    }
    for (;;)
    {
      locali = hOj();
      if (locali == null) {}
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(192359);
        return;
        parame.gg(locali);
      }
    }
  }
  
  public final long b(n paramn)
  {
    AppMethodBeat.i(192358);
    if (an.hMK())
    {
      if (hOg() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(192358);
        throw paramn;
      }
    }
    int i = paramn.consumerIndex;
    int k = paramn.producerIndex;
    AtomicReferenceArray localAtomicReferenceArray = paramn.TXf;
    while (i != k)
    {
      int m = i & 0x7F;
      if (paramn.blockingTasksInBuffer == 0) {
        break;
      }
      i locali = (i)localAtomicReferenceArray.get(m);
      if (locali != null)
      {
        if (locali.TXa.hOf() == 1) {}
        for (int j = 1; (j != 0) && (localAtomicReferenceArray.compareAndSet(m, locali, null)); j = 0)
        {
          TXj.decrementAndGet(paramn);
          a(this, locali);
          AppMethodBeat.o(192358);
          return -1L;
        }
      }
      i += 1;
    }
    long l = a(paramn, true);
    AppMethodBeat.o(192358);
    return l;
  }
  
  public final int hOh()
  {
    AppMethodBeat.i(192353);
    if (this.lastScheduledTask != null)
    {
      i = hOg();
      AppMethodBeat.o(192353);
      return i + 1;
    }
    int i = hOg();
    AppMethodBeat.o(192353);
    return i;
  }
  
  public final i hOi()
  {
    AppMethodBeat.i(117979);
    i locali2 = (i)TXg.getAndSet(this, null);
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = hOj();
    }
    AppMethodBeat.o(117979);
    return locali1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.b.n
 * JD-Core Version:    0.7.0.1
 */