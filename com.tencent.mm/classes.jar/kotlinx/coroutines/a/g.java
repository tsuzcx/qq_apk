package kotlinx.coroutines.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"ALREADY_REMOVED", "", "ALREADY_REMOVED$annotations", "()V", "getALREADY_REMOVED", "()Ljava/lang/Object;", "CONDITION_FALSE", "CONDITION_FALSE$annotations", "getCONDITION_FALSE", "FAILURE", "", "FAILURE$annotations", "LIST_EMPTY", "LIST_EMPTY$annotations", "getLIST_EMPTY", "REMOVE_PREPARED", "SUCCESS", "SUCCESS$annotations", "UNDECIDED", "UNDECIDED$annotations", "unwrap", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "AbstractAtomicDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AddLastDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Node", "RemoveFirstDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "kotlinx-coroutines-core"})
public final class g
{
  private static final Object CIY;
  private static final Object CIZ;
  private static final Object CJa;
  private static final Object CJb;
  
  static
  {
    AppMethodBeat.i(118436);
    CIY = new m("CONDITION_FALSE");
    CIZ = new m("ALREADY_REMOVED");
    CJa = new m("LIST_EMPTY");
    CJb = new m("REMOVE_PREPARED");
    AppMethodBeat.o(118436);
  }
  
  public static final h eh(Object paramObject)
  {
    AppMethodBeat.i(118435);
    j.q(paramObject, "receiver$0");
    if (!(paramObject instanceof l)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (l)localObject;
      if (localObject != null)
      {
        localObject = ((l)localObject).CJs;
        if (localObject != null) {
          break label50;
        }
      }
      label50:
      for (paramObject = (h)paramObject;; paramObject = localObject)
      {
        AppMethodBeat.o(118435);
        return paramObject;
      }
    }
  }
  
  public static final Object eqf()
  {
    return CIY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.g
 * JD-Core Version:    0.7.0.1
 */