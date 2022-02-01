package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/Removed;", "", "ref", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "toString", "", "kotlinx-coroutines-core"})
final class p
{
  public final i LTd;
  
  public p(i parami)
  {
    AppMethodBeat.i(118077);
    this.LTd = parami;
    AppMethodBeat.o(118077);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118076);
    String str = "Removed[" + this.LTd + ']';
    AppMethodBeat.o(118076);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.p
 * JD-Core Version:    0.7.0.1
 */