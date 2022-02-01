package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"CONDITION_FALSE", "", "CONDITION_FALSE$annotations", "()V", "getCONDITION_FALSE", "()Ljava/lang/Object;", "FAILURE", "", "FAILURE$annotations", "LIST_EMPTY", "LIST_EMPTY$annotations", "getLIST_EMPTY", "SUCCESS", "SUCCESS$annotations", "UNDECIDED", "UNDECIDED$annotations", "unwrap", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "AbstractAtomicDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AddLastDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Node", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "RemoveFirstDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "kotlinx-coroutines-core"})
public final class i
{
  private static final Object OgO;
  private static final Object OgP;
  
  static
  {
    AppMethodBeat.i(118116);
    OgO = new t("CONDITION_FALSE");
    OgP = new t("LIST_EMPTY");
    AppMethodBeat.o(118116);
  }
  
  public static final Object gAA()
  {
    return OgO;
  }
  
  public static final j ga(Object paramObject)
  {
    AppMethodBeat.i(118115);
    if (!(paramObject instanceof q)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (q)localObject;
      if (localObject != null)
      {
        localObject = ((q)localObject).Ohg;
        if (localObject != null) {}
      }
      else if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(118115);
        throw paramObject;
      }
      for (paramObject = (j)paramObject;; paramObject = localObject)
      {
        AppMethodBeat.o(118115);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.i
 * JD-Core Version:    0.7.0.1
 */