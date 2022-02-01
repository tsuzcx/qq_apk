package kotlinx.coroutines.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.au;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  private final AtomicReferenceArray<i> ajBN;
  
  static
  {
    AppMethodBeat.i(117989);
    ajBO = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");
    ajBP = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");
    ajBQ = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");
    ajBR = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");
    AppMethodBeat.o(117989);
  }
  
  public m()
  {
    AppMethodBeat.i(117988);
    this.ajBN = new AtomicReferenceArray(128);
    this.lastScheduledTask = null;
    this.producerIndex = 0;
    this.consumerIndex = 0;
    this.blockingTasksInBuffer = 0;
    AppMethodBeat.o(117988);
  }
  
  private final long a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(189484);
    i locali;
    do
    {
      locali = (i)paramm.lastScheduledTask;
      if (locali == null)
      {
        AppMethodBeat.o(189484);
        return -2L;
      }
      if (paramBoolean)
      {
        if (locali.ajBI.kEC() == 1) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(189484);
          return -2L;
        }
      }
      long l1 = l.ajBM.nanoTime() - locali.ajBH;
      if (l1 < l.ajBJ)
      {
        long l2 = l.ajBJ;
        AppMethodBeat.o(189484);
        return l2 - l1;
      }
    } while (!ajBO.compareAndSet(paramm, locali, null));
    a(locali, false);
    AppMethodBeat.o(189484);
    return -1L;
  }
  
  private final i b(i parami)
  {
    int i = 1;
    AppMethodBeat.i(189476);
    if (parami.ajBI.kEC() == 1) {}
    for (;;)
    {
      if (i != 0) {
        ajBR.incrementAndGet(this);
      }
      if (kEE() != 127) {
        break;
      }
      AppMethodBeat.o(189476);
      return parami;
      i = 0;
    }
    i = this.producerIndex & 0x7F;
    while (this.ajBN.get(i) != null) {
      Thread.yield();
    }
    this.ajBN.lazySet(i, parami);
    ajBP.incrementAndGet(this);
    AppMethodBeat.o(189476);
    return null;
  }
  
  private final void c(i parami)
  {
    int j = 1;
    AppMethodBeat.i(189503);
    if (parami != null)
    {
      if (parami.ajBI.kEC() == 1)
      {
        i = 1;
        if (i == 0) {
          break label79;
        }
        i = ajBR.decrementAndGet(this);
        if (!au.ASSERTIONS_ENABLED) {
          break label79;
        }
        if (i < 0) {
          break label74;
        }
      }
      label74:
      for (int i = j;; i = 0)
      {
        if (i != 0) {
          break label79;
        }
        parami = new AssertionError();
        AppMethodBeat.o(189503);
        throw parami;
        i = 0;
        break;
      }
    }
    label79:
    AppMethodBeat.o(189503);
  }
  
  private int kEE()
  {
    return this.producerIndex - this.consumerIndex;
  }
  
  private final i kEH()
  {
    AppMethodBeat.i(189493);
    i locali;
    do
    {
      int i;
      do
      {
        i = this.consumerIndex;
        if (i - this.producerIndex == 0)
        {
          AppMethodBeat.o(189493);
          return null;
        }
      } while (!ajBQ.compareAndSet(this, i, i + 1));
      locali = (i)this.ajBN.getAndSet(i & 0x7F, null);
    } while (locali == null);
    c(locali);
    AppMethodBeat.o(189493);
    return locali;
  }
  
  public final long a(m paramm)
  {
    int j = 1;
    AppMethodBeat.i(189552);
    int i;
    if (au.ASSERTIONS_ENABLED)
    {
      if (kEE() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramm = new AssertionError();
        AppMethodBeat.o(189552);
        throw paramm;
      }
    }
    i locali = paramm.kEH();
    if (locali != null)
    {
      paramm = a(this, locali);
      if (au.ASSERTIONS_ENABLED)
      {
        if (paramm == null) {}
        for (i = j; i == 0; i = 0)
        {
          paramm = new AssertionError();
          AppMethodBeat.o(189552);
          throw paramm;
        }
      }
      AppMethodBeat.o(189552);
      return -1L;
    }
    long l = a(paramm, false);
    AppMethodBeat.o(189552);
    return l;
  }
  
  public final i a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(189542);
    if (paramBoolean)
    {
      parami = b(parami);
      AppMethodBeat.o(189542);
      return parami;
    }
    parami = (i)ajBO.getAndSet(this, parami);
    if (parami == null)
    {
      AppMethodBeat.o(189542);
      return null;
    }
    parami = b(parami);
    AppMethodBeat.o(189542);
    return parami;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(189569);
    i locali = (i)ajBO.getAndSet(this, null);
    if (locali != null) {
      paramd.jl(locali);
    }
    for (;;)
    {
      locali = kEH();
      if (locali == null) {}
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(189569);
        return;
        paramd.jl(locali);
      }
    }
  }
  
  public final long b(m paramm)
  {
    AppMethodBeat.i(189562);
    if (au.ASSERTIONS_ENABLED)
    {
      if (kEE() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        paramm = new AssertionError();
        AppMethodBeat.o(189562);
        throw paramm;
      }
    }
    int i = paramm.consumerIndex;
    int k = paramm.producerIndex;
    AtomicReferenceArray localAtomicReferenceArray = paramm.ajBN;
    while (i != k)
    {
      int m = i & 0x7F;
      if (paramm.blockingTasksInBuffer == 0) {
        break;
      }
      i locali = (i)localAtomicReferenceArray.get(m);
      if (locali != null)
      {
        if (locali.ajBI.kEC() == 1) {}
        for (int j = 1; (j != 0) && (localAtomicReferenceArray.compareAndSet(m, locali, null)); j = 0)
        {
          ajBR.decrementAndGet(paramm);
          a(this, locali);
          AppMethodBeat.o(189562);
          return -1L;
        }
      }
      i += 1;
    }
    long l = a(paramm, true);
    AppMethodBeat.o(189562);
    return l;
  }
  
  public final int kEF()
  {
    AppMethodBeat.i(189521);
    if (this.lastScheduledTask != null)
    {
      i = kEE();
      AppMethodBeat.o(189521);
      return i + 1;
    }
    int i = kEE();
    AppMethodBeat.o(189521);
    return i;
  }
  
  public final i kEG()
  {
    AppMethodBeat.i(117979);
    i locali = (i)ajBO.getAndSet(this, null);
    if (locali == null)
    {
      locali = kEH();
      AppMethodBeat.o(117979);
      return locali;
    }
    AppMethodBeat.o(117979);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.d.m
 * JD-Core Version:    0.7.0.1
 */