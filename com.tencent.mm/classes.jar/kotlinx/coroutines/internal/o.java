package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"CONDITION_FALSE", "", "getCONDITION_FALSE$annotations", "()V", "getCONDITION_FALSE", "()Ljava/lang/Object;", "FAILURE", "", "getFAILURE$annotations", "LIST_EMPTY", "getLIST_EMPTY$annotations", "getLIST_EMPTY", "SUCCESS", "getSUCCESS$annotations", "UNDECIDED", "getUNDECIDED$annotations", "unwrap", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "AbstractAtomicDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AddLastDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Node", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "RemoveFirstDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  private static final Object ajAw;
  private static final Object ajAx;
  
  static
  {
    AppMethodBeat.i(118116);
    ajAw = new ac("CONDITION_FALSE");
    ajAx = new ac("LIST_EMPTY");
    AppMethodBeat.o(118116);
  }
  
  public static final p jk(Object paramObject)
  {
    AppMethodBeat.i(118115);
    if ((paramObject instanceof x)) {}
    for (x localx = (x)paramObject; localx == null; localx = null)
    {
      paramObject = (p)paramObject;
      AppMethodBeat.o(118115);
      return paramObject;
    }
    paramObject = localx.ajAO;
    AppMethodBeat.o(118115);
    return paramObject;
  }
  
  public static final Object kDX()
  {
    return ajAw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.o
 * JD-Core Version:    0.7.0.1
 */