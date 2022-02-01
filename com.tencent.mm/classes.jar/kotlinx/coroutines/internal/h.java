package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"CONDITION_FALSE", "", "CONDITION_FALSE$annotations", "()V", "getCONDITION_FALSE", "()Ljava/lang/Object;", "FAILURE", "", "FAILURE$annotations", "LIST_EMPTY", "LIST_EMPTY$annotations", "getLIST_EMPTY", "SUCCESS", "SUCCESS$annotations", "UNDECIDED", "UNDECIDED$annotations", "unwrap", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "AbstractAtomicDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AddLastDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Node", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "RemoveFirstDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "kotlinx-coroutines-core"})
public final class h
{
  private static final Object LSL;
  private static final Object LSM;
  
  static
  {
    AppMethodBeat.i(118116);
    LSL = new s("CONDITION_FALSE");
    LSM = new s("LIST_EMPTY");
    AppMethodBeat.o(118116);
  }
  
  public static final i fU(Object paramObject)
  {
    AppMethodBeat.i(118115);
    if (!(paramObject instanceof p)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (p)localObject;
      if (localObject != null)
      {
        localObject = ((p)localObject).LTd;
        if (localObject != null) {}
      }
      else if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(118115);
        throw paramObject;
      }
      for (paramObject = (i)paramObject;; paramObject = localObject)
      {
        AppMethodBeat.o(118115);
        return paramObject;
      }
    }
  }
  
  public static final Object gez()
  {
    return LSL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.h
 * JD-Core Version:    0.7.0.1
 */