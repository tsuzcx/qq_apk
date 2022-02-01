package kotlinx.coroutines.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.ac;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.n;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/sync/CancelSemaphoreAcquisitionHandler;", "Lkotlinx/coroutines/CancelHandler;", "segment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "index", "", "(Lkotlinx/coroutines/sync/SemaphoreSegment;I)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class a
  extends n
{
  private final i ajBS;
  private final int index;
  
  public a(i parami, int paramInt)
  {
    this.ajBS = parami;
    this.index = paramInt;
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(188936);
    paramThrowable = this.ajBS;
    int i = this.index;
    ac localac = h.kEY();
    paramThrowable.ajCu.set(i, localac);
    if ((z.ajAP.incrementAndGet(paramThrowable) == paramThrowable.kEm()) && (!paramThrowable.kDR())) {
      paramThrowable.remove();
    }
    AppMethodBeat.o(188936);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188946);
    String str = "CancelSemaphoreAcquisitionHandler[" + this.ajBS + ", " + this.index + ']';
    AppMethodBeat.o(188946);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.e.a
 * JD-Core Version:    0.7.0.1
 */