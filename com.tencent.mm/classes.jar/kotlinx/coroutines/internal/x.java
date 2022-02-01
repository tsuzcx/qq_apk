package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/Removed;", "", "ref", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class x
{
  public final p ajAO;
  
  public x(p paramp)
  {
    AppMethodBeat.i(118077);
    this.ajAO = paramp;
    AppMethodBeat.o(118077);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118076);
    String str = "Removed[" + this.ajAO + ']';
    AppMethodBeat.o(118076);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.x
 * JD-Core Version:    0.7.0.1
 */