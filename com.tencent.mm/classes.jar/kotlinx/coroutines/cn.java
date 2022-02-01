package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/RemoveOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class cn
  extends k
{
  private final kotlinx.coroutines.internal.l abxL;
  
  public cn(kotlinx.coroutines.internal.l paraml)
  {
    this.abxL = paraml;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204241);
    String str = "RemoveOnCancel[" + this.abxL + ']';
    AppMethodBeat.o(204241);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(204237);
    this.abxL.remove();
    AppMethodBeat.o(204237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.cn
 * JD-Core Version:    0.7.0.1
 */