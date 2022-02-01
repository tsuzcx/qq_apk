package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"CONDITION_FALSE", "", "CONDITION_FALSE$annotations", "()V", "getCONDITION_FALSE", "()Ljava/lang/Object;", "FAILURE", "", "FAILURE$annotations", "LIST_EMPTY", "LIST_EMPTY$annotations", "getLIST_EMPTY", "SUCCESS", "SUCCESS$annotations", "UNDECIDED", "UNDECIDED$annotations", "unwrap", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "AbstractAtomicDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AddLastDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Node", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "RemoveFirstDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "kotlinx-coroutines-core"})
public final class f
{
  private static final Object Kfj;
  private static final Object Kfk;
  
  static
  {
    AppMethodBeat.i(118116);
    Kfj = new m("CONDITION_FALSE");
    Kfk = new m("LIST_EMPTY");
    AppMethodBeat.o(118116);
  }
  
  public static final Object fLM()
  {
    return Kfj;
  }
  
  public static final g fM(Object paramObject)
  {
    AppMethodBeat.i(118115);
    if (!(paramObject instanceof k)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (k)localObject;
      if (localObject != null)
      {
        localObject = ((k)localObject).Kfw;
        if (localObject != null) {}
      }
      else if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(118115);
        throw paramObject;
      }
      for (paramObject = (g)paramObject;; paramObject = localObject)
      {
        AppMethodBeat.o(118115);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.f
 * JD-Core Version:    0.7.0.1
 */