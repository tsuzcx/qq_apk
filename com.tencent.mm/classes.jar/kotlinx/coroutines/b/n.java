package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.al;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""})
public final class n
{
  private static final AtomicReferenceFieldUpdater LUj;
  private static final AtomicIntegerFieldUpdater LUk;
  private static final AtomicIntegerFieldUpdater LUl;
  private static final AtomicIntegerFieldUpdater LUm;
  private final AtomicReferenceArray<i> LUi;
  private volatile int blockingTasksInBuffer;
  private volatile int consumerIndex;
  private volatile Object lastScheduledTask;
  private volatile int producerIndex;
  
  static
  {
    AppMethodBeat.i(117989);
    LUj = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");
    LUk = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");
    LUl = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");
    LUm = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");
    AppMethodBeat.o(117989);
  }
  
  public n()
  {
    AppMethodBeat.i(117988);
    this.LUi = new AtomicReferenceArray(128);
    this.lastScheduledTask = null;
    this.producerIndex = 0;
    this.consumerIndex = 0;
    this.blockingTasksInBuffer = 0;
    AppMethodBeat.o(117988);
  }
  
  private final long a(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(191124);
    i locali;
    do
    {
      locali = (i)paramn.lastScheduledTask;
      if (locali == null)
      {
        AppMethodBeat.o(191124);
        return -2L;
      }
      if (paramBoolean)
      {
        if (locali.LUc.geX() == 1) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(191124);
          return -2L;
        }
      }
      long l1 = l.LUh.nanoTime() - locali.LUb;
      if (l1 < l.LUe)
      {
        long l2 = l.LUe;
        AppMethodBeat.o(191124);
        return l2 - l1;
      }
    } while (!LUj.compareAndSet(paramn, locali, null));
    a(locali, false);
    AppMethodBeat.o(191124);
    return -1L;
  }
  
  private final i b(i parami)
  {
    int i = 1;
    AppMethodBeat.i(191120);
    if (parami.LUc.geX() == 1) {}
    for (;;)
    {
      if (i != 0) {
        LUm.incrementAndGet(this);
      }
      if (geY() != 127) {
        break;
      }
      AppMethodBeat.o(191120);
      return parami;
      i = 0;
    }
    i = this.producerIndex & 0x7F;
    while (this.LUi.get(i) != null) {
      Thread.yield();
    }
    this.LUi.lazySet(i, parami);
    LUk.incrementAndGet(this);
    AppMethodBeat.o(191120);
    return null;
  }
  
  private final void c(i parami)
  {
    int j = 1;
    AppMethodBeat.i(191126);
    if (parami != null)
    {
      if (parami.LUc.geX() == 1)
      {
        i = 1;
        if (i == 0) {
          break label82;
        }
        i = LUm.decrementAndGet(this);
        if (!al.gdD()) {
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
        AppMethodBeat.o(191126);
        throw parami;
        i = 0;
        break;
      }
    }
    label82:
    AppMethodBeat.o(191126);
  }
  
  private int geY()
  {
    return this.producerIndex - this.consumerIndex;
  }
  
  private final i gfb()
  {
    AppMethodBeat.i(191125);
    i locali;
    do
    {
      int i;
      do
      {
        i = this.consumerIndex;
        if (i - this.producerIndex == 0)
        {
          AppMethodBeat.o(191125);
          return null;
        }
      } while (!LUl.compareAndSet(this, i, i + 1));
      locali = (i)this.LUi.getAndSet(i & 0x7F, null);
    } while (locali == null);
    c(locali);
    AppMethodBeat.o(191125);
    return locali;
  }
  
  public final long a(n paramn)
  {
    int j = 1;
    AppMethodBeat.i(191121);
    int i;
    if (al.gdD())
    {
      if (geY() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(191121);
        throw paramn;
      }
    }
    i locali = paramn.gfb();
    if (locali != null)
    {
      paramn = a(this, locali);
      if (al.gdD())
      {
        if (paramn == null) {}
        for (i = j; i == 0; i = 0)
        {
          paramn = (Throwable)new AssertionError();
          AppMethodBeat.o(191121);
          throw paramn;
        }
      }
      AppMethodBeat.o(191121);
      return -1L;
    }
    long l = a(paramn, false);
    AppMethodBeat.o(191121);
    return l;
  }
  
  public final i a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(191118);
    if (paramBoolean)
    {
      parami = b(parami);
      AppMethodBeat.o(191118);
      return parami;
    }
    parami = (i)LUj.getAndSet(this, parami);
    if (parami == null)
    {
      AppMethodBeat.o(191118);
      return null;
    }
    parami = b(parami);
    AppMethodBeat.o(191118);
    return parami;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(191123);
    i locali = (i)LUj.getAndSet(this, null);
    if (locali != null) {
      parame.fV(locali);
    }
    for (;;)
    {
      locali = gfb();
      if (locali == null) {}
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(191123);
        return;
        parame.fV(locali);
      }
    }
  }
  
  public final long b(n paramn)
  {
    AppMethodBeat.i(191122);
    if (al.gdD())
    {
      if (geY() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramn = (Throwable)new AssertionError();
        AppMethodBeat.o(191122);
        throw paramn;
      }
    }
    int i = paramn.consumerIndex;
    int k = paramn.producerIndex;
    AtomicReferenceArray localAtomicReferenceArray = paramn.LUi;
    while (i != k)
    {
      int m = i & 0x7F;
      if (paramn.blockingTasksInBuffer == 0) {
        break;
      }
      i locali = (i)localAtomicReferenceArray.get(m);
      if (locali != null)
      {
        if (locali.LUc.geX() == 1) {}
        for (int j = 1; (j != 0) && (localAtomicReferenceArray.compareAndSet(m, locali, null)); j = 0)
        {
          LUm.decrementAndGet(paramn);
          a(this, locali);
          AppMethodBeat.o(191122);
          return -1L;
        }
      }
      i += 1;
    }
    long l = a(paramn, true);
    AppMethodBeat.o(191122);
    return l;
  }
  
  public final int geZ()
  {
    AppMethodBeat.i(191117);
    if (this.lastScheduledTask != null)
    {
      i = geY();
      AppMethodBeat.o(191117);
      return i + 1;
    }
    int i = geY();
    AppMethodBeat.o(191117);
    return i;
  }
  
  public final i gfa()
  {
    AppMethodBeat.i(117979);
    i locali2 = (i)LUj.getAndSet(this, null);
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = gfb();
    }
    AppMethodBeat.o(117979);
    return locali1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.b.n
 * JD-Core Version:    0.7.0.1
 */