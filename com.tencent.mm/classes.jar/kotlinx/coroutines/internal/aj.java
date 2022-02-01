package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlinx.coroutines.cy;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/ThreadState;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "n", "", "(Lkotlin/coroutines/CoroutineContext;I)V", "elements", "", "Lkotlinx/coroutines/ThreadContextElement;", "[Lkotlinx/coroutines/ThreadContextElement;", "i", "values", "[Ljava/lang/Object;", "append", "", "element", "value", "restore", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class aj
{
  public final f aMa;
  final cy<Object>[] ajBb;
  final Object[] aqm;
  int i;
  
  public aj(f paramf, int paramInt)
  {
    AppMethodBeat.i(118108);
    this.aMa = paramf;
    this.aqm = new Object[paramInt];
    this.ajBb = new cy[paramInt];
    AppMethodBeat.o(118108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.aj
 * JD-Core Version:    0.7.0.1
 */