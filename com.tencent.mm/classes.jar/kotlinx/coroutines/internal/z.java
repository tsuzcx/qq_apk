package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/Segment;", "S", "", "id", "prev", "", "pointers", "<init>", "(JLkotlinx/coroutines/internal/Segment;I)V", "", "decPointers$kotlinx_coroutines_core", "()Z", "decPointers", "", "onSlotCleaned", "()V", "tryIncPointers$kotlinx_coroutines_core", "tryIncPointers", "J", "getId", "()J", "getMaxSlots", "()I", "maxSlots", "getRemoved", "removed", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class z<S extends z<S>>
  extends f<S>
{
  public final long id;
  
  public z(long paramLong, S paramS, int paramInt)
  {
    super((f)paramS);
    this.id = paramLong;
    this.cleanedAndPointers = (paramInt << 16);
  }
  
  public final boolean kDS()
  {
    return (this.cleanedAndPointers == kEm()) && (!kDR());
  }
  
  public abstract int kEm();
  
  public final boolean kEn()
  {
    int j;
    do
    {
      j = this.cleanedAndPointers;
      if ((j != kEm()) || (kDR())) {}
      for (int i = 1; i == 0; i = 0) {
        return false;
      }
    } while (!ajAP.compareAndSet(this, j, 65536 + j));
    return true;
  }
  
  public final boolean kEo()
  {
    return (ajAP.addAndGet(this, -65536) == kEm()) && (!kDR());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.z
 * JD-Core Version:    0.7.0.1
 */