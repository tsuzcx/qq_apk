package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "()V", "isEmpty", "", "()Z", "isRemoved", "forEach", "", "T", "Lkotlinx/coroutines/internal/Node;", "block", "Lkotlin/Function1;", "nextIfRemoved", "remove", "validate", "validate$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public class i
  extends k
{
  public final boolean isRemoved()
  {
    return false;
  }
  
  public final boolean remove()
  {
    AppMethodBeat.i(118107);
    Throwable localThrowable = (Throwable)new IllegalStateException("head cannot be removed".toString());
    AppMethodBeat.o(118107);
    throw localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.i
 * JD-Core Version:    0.7.0.1
 */