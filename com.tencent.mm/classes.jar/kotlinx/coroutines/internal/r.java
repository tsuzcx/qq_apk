package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/Removed;", "", "ref", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "toString", "", "kotlinx-coroutines-core"})
final class r
{
  public final k TWe;
  
  public r(k paramk)
  {
    AppMethodBeat.i(118077);
    this.TWe = paramk;
    AppMethodBeat.o(118077);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118076);
    String str = "Removed[" + this.TWe + ']';
    AppMethodBeat.o(118076);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.r
 * JD-Core Version:    0.7.0.1
 */