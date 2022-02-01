package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "()V", "isEmpty", "", "()Z", "isRemoved", "forEach", "", "T", "Lkotlinx/coroutines/internal/Node;", "block", "Lkotlin/Function1;", "nextIfRemoved", "remove", "validate", "validate$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public class g
  extends i
{
  public final boolean bzN()
  {
    AppMethodBeat.i(118107);
    Throwable localThrowable = (Throwable)new IllegalStateException("head cannot be removed".toString());
    AppMethodBeat.o(118107);
    throw localThrowable;
  }
  
  public final boolean isRemoved()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.g
 * JD-Core Version:    0.7.0.1
 */