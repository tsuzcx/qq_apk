package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/Removed;", "", "ref", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "toString", "", "kotlinx-coroutines-core"})
final class s
{
  public final l abzv;
  
  public s(l paraml)
  {
    AppMethodBeat.i(118077);
    this.abzv = paraml;
    AppMethodBeat.o(118077);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118076);
    String str = "Removed[" + this.abzv + ']';
    AppMethodBeat.o(118076);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.internal.s
 * JD-Core Version:    0.7.0.1
 */