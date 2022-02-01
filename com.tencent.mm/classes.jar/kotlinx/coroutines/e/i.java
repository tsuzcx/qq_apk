package kotlinx.coroutines.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.z;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/sync/SemaphoreSegment;", "", "id", "prev", "", "pointers", "<init>", "(JLkotlinx/coroutines/sync/SemaphoreSegment;I)V", "index", "", "cancel", "(I)V", "", "expected", "value", "", "cas", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "get", "(I)Ljava/lang/Object;", "getAndSet", "(ILjava/lang/Object;)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "getMaxSlots", "()I", "maxSlots", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/Segment;"}, k=1, mv={1, 5, 1}, xi=48)
final class i
  extends z<i>
{
  public i(long paramLong, i parami, int paramInt)
  {
    super(paramLong, (z)parami, paramInt);
    AppMethodBeat.i(188931);
    this.ajCu = new AtomicReferenceArray(h.kET());
    AppMethodBeat.o(188931);
  }
  
  public final int kEm()
  {
    AppMethodBeat.i(188941);
    int i = h.kET();
    AppMethodBeat.o(188941);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188947);
    String str = "SemaphoreSegment[id=" + this.id + ", hashCode=" + hashCode() + ']';
    AppMethodBeat.o(188947);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.e.i
 * JD-Core Version:    0.7.0.1
 */