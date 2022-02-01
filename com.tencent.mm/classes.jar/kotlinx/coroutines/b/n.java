package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.am;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""})
public final class n
{
  private static final AtomicReferenceFieldUpdater Oik;
  private static final AtomicIntegerFieldUpdater Oil;
  private static final AtomicIntegerFieldUpdater Oim;
  private static final AtomicIntegerFieldUpdater Oin;
  private final AtomicReferenceArray<i> Oij;
  private volatile int blockingTasksInBuffer;
  private volatile int consumerIndex;
  private volatile Object lastScheduledTask;
  private volatile int producerIndex;
  
  static
  {
    AppMethodBeat.i(117989);
    Oik = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");
    Oil = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");
    Oim = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");
    Oin = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");
    AppMethodBeat.o(117989);
  }
  
  public n()
  {
    AppMethodBeat.i(117988);
    this.Oij = new AtomicReferenceArray(128);
    this.lastScheduledTask = null;
    this.producerIndex = 0;
    this.consumerIndex = 0;
    this.blockingTasksInBuffer = 0;
    AppMethodBeat.o(117988);
  }
  
  private final long a(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(209225);
    i locali;
    do
    {
      locali = (i)paramn.lastScheduledTask;
      if (locali == null)
      {
        AppMethodBeat.o(209225);
        return -2L;
      }
      if (paramBoolean)
      {
        if (locali.Oid.gAY() == 1) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(209225);
          return -2L;
        }
      }
      long l1 = l.Oii.nanoTime() - locali.Oic;
      if (l1 < l.Oif)
      {
        long l2 = l.Oif;
        AppMethodBeat.o(209225);
        return l2 - l1;
      }
    } while (!Oik.compareAndSet(paramn, locali, null));
    a(locali, false);
    AppMethodBeat.o(209225);
    return -1L;
  }
  
  private final i b(i parami)
  {
    int i = 1;
    AppMethodBeat.i(209221);
    if (parami.Oid.gAY() == 1) {}
    for (;;)
    {
      if (i != 0) {
        Oin.incrementAndGet(this);
      }
      if (gAZ() != 127) {
        break;
      }
      AppMethodBeat.o(209221);
      return parami;
      i = 0;
    }
    i = this.producerIndex & 0x7F;
    while (this.Oij.get(i) != null) {
      Thread.yield();
    }
    this.Oij.lazySet(i, parami);
    Oil.incrementAndGet(this);
    AppMethodBeat.o(209221);
    return null;
  }
  
  private final void c(i parami)
  {
    int j = 1;
    AppMethodBeat.i(209227);
    if (parami != null)
    {
      if (parami.Oid.gAY() == 1)
      {
        i = 1;
        if (i == 0) {
          break label82;
        }
        i = Oin.decrementAndGet(this);
        if (!am.gzF()) {
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
        AppMethodBeat.o(209227);
        throw parami;
        i = 0;
        break;
      }
    }
    label82:
    AppMethodBeat.o(209227);
  }
  
  private int gAZ()
  {
    return this.producerIndex - this.consumerIndex;
  }
  
  private final i gBc()
  {
    AppMethodBeat.i(209226);
    i locali;
    do
    {
      int i;
      do
      {
        i = this.consumerIndex;
        if (i - this.producerIndex == 0)
        {
          AppMethodBeat.o(209226);
          return null;
        }
      } while (!Oim.compareAndSet(this, i, i + 1));
      locali = (i)this.Oij.getAndSet(i & 0x7F, null);
    } while (locali == null);
    c(locali);
    AppMethodBeat.o(209226);
    return locali;
  }
  
  public final long a(n paramn)
  {
    int j = 1;
    AppMethodBeat.i(209222);
    int i;
    if (am.gzF())
    {
      if (gAZ() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(209222);
        throw paramn;
      }
    }
    i locali = paramn.gBc();
    if (locali != null)
    {
      paramn = a(this, locali);
      if (am.gzF())
      {
        if (paramn == null) {}
        for (i = j; i == 0; i = 0)
        {
          paramn = (Throwable)new AssertionError();
          AppMethodBeat.o(209222);
          throw paramn;
        }
      }
      AppMethodBeat.o(209222);
      return -1L;
    }
    long l = a(paramn, false);
    AppMethodBeat.o(209222);
    return l;
  }
  
  public final i a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(209219);
    if (paramBoolean)
    {
      parami = b(parami);
      AppMethodBeat.o(209219);
      return parami;
    }
    parami = (i)Oik.getAndSet(this, parami);
    if (parami == null)
    {
      AppMethodBeat.o(209219);
      return null;
    }
    parami = b(parami);
    AppMethodBeat.o(209219);
    return parami;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(209224);
    i locali = (i)Oik.getAndSet(this, null);
    if (locali != null) {
      parame.gb(locali);
    }
    for (;;)
    {
      locali = gBc();
      if (locali == null) {}
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(209224);
        return;
        parame.gb(locali);
      }
    }
  }
  
  public final long b(n paramn)
  {
    AppMethodBeat.i(209223);
    if (am.gzF())
    {
      if (gAZ() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(209223);
        throw paramn;
      }
    }
    int i = paramn.consumerIndex;
    int k = paramn.producerIndex;
    AtomicReferenceArray localAtomicReferenceArray = paramn.Oij;
    while (i != k)
    {
      int m = i & 0x7F;
      if (paramn.blockingTasksInBuffer == 0) {
        break;
      }
      i locali = (i)localAtomicReferenceArray.get(m);
      if (locali != null)
      {
        if (locali.Oid.gAY() == 1) {}
        for (int j = 1; (j != 0) && (localAtomicReferenceArray.compareAndSet(m, locali, null)); j = 0)
        {
          Oin.decrementAndGet(paramn);
          a(this, locali);
          AppMethodBeat.o(209223);
          return -1L;
        }
      }
      i += 1;
    }
    long l = a(paramn, true);
    AppMethodBeat.o(209223);
    return l;
  }
  
  public final int gBa()
  {
    AppMethodBeat.i(209218);
    if (this.lastScheduledTask != null)
    {
      i = gAZ();
      AppMethodBeat.o(209218);
      return i + 1;
    }
    int i = gAZ();
    AppMethodBeat.o(209218);
    return i;
  }
  
  public final i gBb()
  {
    AppMethodBeat.i(117979);
    i locali2 = (i)Oik.getAndSet(this, null);
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = gBc();
    }
    AppMethodBeat.o(117979);
    return locali1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.n
 * JD-Core Version:    0.7.0.1
 */