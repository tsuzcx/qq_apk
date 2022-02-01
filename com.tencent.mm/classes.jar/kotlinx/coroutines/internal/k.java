package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"CONDITION_FALSE", "", "CONDITION_FALSE$annotations", "()V", "getCONDITION_FALSE", "()Ljava/lang/Object;", "FAILURE", "", "FAILURE$annotations", "LIST_EMPTY", "LIST_EMPTY$annotations", "getLIST_EMPTY", "SUCCESS", "SUCCESS$annotations", "UNDECIDED", "UNDECIDED$annotations", "unwrap", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "AbstractAtomicDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AddLastDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Node", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "RemoveFirstDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "kotlinx-coroutines-core"})
public final class k
{
  private static final Object abzd;
  private static final Object abze;
  
  static
  {
    AppMethodBeat.i(118116);
    abzd = new v("CONDITION_FALSE");
    abze = new v("LIST_EMPTY");
    AppMethodBeat.o(118116);
  }
  
  public static final l gx(Object paramObject)
  {
    AppMethodBeat.i(118115);
    if (!(paramObject instanceof s)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (s)localObject;
      if (localObject != null)
      {
        localObject = ((s)localObject).abzv;
        if (localObject != null) {}
      }
      else if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(118115);
        throw paramObject;
      }
      for (paramObject = (l)paramObject;; paramObject = localObject)
      {
        AppMethodBeat.o(118115);
        return paramObject;
      }
    }
  }
  
  public static final Object iSJ()
  {
    return abzd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.k
 * JD-Core Version:    0.7.0.1
 */