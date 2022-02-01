package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"CONDITION_FALSE", "", "CONDITION_FALSE$annotations", "()V", "getCONDITION_FALSE", "()Ljava/lang/Object;", "FAILURE", "", "FAILURE$annotations", "LIST_EMPTY", "LIST_EMPTY$annotations", "getLIST_EMPTY", "SUCCESS", "SUCCESS$annotations", "UNDECIDED", "UNDECIDED$annotations", "unwrap", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "AbstractAtomicDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AddLastDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Node", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "RemoveFirstDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "kotlinx-coroutines-core"})
public final class j
{
  private static final Object TVM;
  private static final Object TVN;
  
  static
  {
    AppMethodBeat.i(118116);
    TVM = new u("CONDITION_FALSE");
    TVN = new u("LIST_EMPTY");
    AppMethodBeat.o(118116);
  }
  
  public static final k gf(Object paramObject)
  {
    AppMethodBeat.i(118115);
    if (!(paramObject instanceof r)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (r)localObject;
      if (localObject != null)
      {
        localObject = ((r)localObject).TWe;
        if (localObject != null) {}
      }
      else if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(118115);
        throw paramObject;
      }
      for (paramObject = (k)paramObject;; paramObject = localObject)
      {
        AppMethodBeat.o(118115);
        return paramObject;
      }
    }
  }
  
  public static final Object hNH()
  {
    return TVM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.j
 * JD-Core Version:    0.7.0.1
 */