package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.v;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"})
public class j
{
  static final AtomicReferenceFieldUpdater NJK;
  static final AtomicReferenceFieldUpdater NJL;
  private static final AtomicReferenceFieldUpdater NJM;
  volatile Object _next;
  volatile Object _prev;
  private volatile Object _removedRef;
  
  static
  {
    AppMethodBeat.i(118104);
    NJK = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_next");
    NJL = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_prev");
    NJM = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_removedRef");
    AppMethodBeat.o(118104);
  }
  
  public j()
  {
    AppMethodBeat.i(118102);
    this._next = this;
    this._prev = this;
    this._removedRef = null;
    AppMethodBeat.o(118102);
  }
  
  private static j b(j paramj)
  {
    AppMethodBeat.i(190830);
    for (;;)
    {
      if (!paramj.isRemoved())
      {
        AppMethodBeat.o(190830);
        return paramj;
      }
      paramj = (j)paramj._prev;
    }
  }
  
  private final void d(j paramj)
  {
    AppMethodBeat.i(118097);
    j localj;
    do
    {
      localj = (j)paramj._prev;
      if (gvZ() != paramj)
      {
        AppMethodBeat.o(118097);
        return;
      }
    } while (!NJL.compareAndSet(paramj, localj, this));
    if (isRemoved()) {
      paramj.gwc();
    }
    AppMethodBeat.o(118097);
  }
  
  private final j gwc()
  {
    AppMethodBeat.i(190831);
    j localj = (j)this._prev;
    Object localObject1 = null;
    Object localObject2 = localj;
    Object localObject3;
    for (;;)
    {
      localObject3 = ((j)localObject2)._next;
      if (localObject3 == (j)this)
      {
        if (localj == localObject2)
        {
          AppMethodBeat.o(190831);
          return localObject2;
        }
        if (!NJL.compareAndSet(this, localj, localObject2)) {
          break;
        }
        AppMethodBeat.o(190831);
        return localObject2;
      }
      if (isRemoved())
      {
        AppMethodBeat.o(190831);
        return null;
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(190831);
        return localObject2;
      }
      if ((localObject3 instanceof p))
      {
        ((p)localObject3).fW(localObject2);
        break;
      }
      if (!(localObject3 instanceof q)) {
        break label158;
      }
      if (localObject1 == null) {
        break label145;
      }
      if (!NJK.compareAndSet(localObject1, localObject2, ((q)localObject3).NKa)) {
        break;
      }
      localObject2 = localObject1;
      localObject1 = null;
    }
    label145:
    localObject2 = ((j)localObject2)._prev;
    for (;;)
    {
      localObject2 = (j)localObject2;
      break;
      label158:
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(190831);
        throw ((Throwable)localObject1);
      }
      localObject1 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public final int a(j paramj1, j paramj2, a parama)
  {
    AppMethodBeat.i(118095);
    NJL.lazySet(paramj1, this);
    NJK.lazySet(paramj1, paramj2);
    parama.NJN = paramj2;
    if (!NJK.compareAndSet(this, paramj2, parama))
    {
      AppMethodBeat.o(118095);
      return 0;
    }
    if (parama.fW(this) == null)
    {
      AppMethodBeat.o(118095);
      return 1;
    }
    AppMethodBeat.o(118095);
    return 2;
  }
  
  public final boolean c(j paramj)
  {
    AppMethodBeat.i(118094);
    NJL.lazySet(paramj, this);
    NJK.lazySet(paramj, this);
    do
    {
      if (gvZ() != (j)this)
      {
        AppMethodBeat.o(118094);
        return false;
      }
    } while (!NJK.compareAndSet(this, this, paramj));
    paramj.d(this);
    AppMethodBeat.o(118094);
    return true;
  }
  
  public final Object gvZ()
  {
    AppMethodBeat.i(118091);
    for (;;)
    {
      Object localObject = this._next;
      if (!(localObject instanceof p))
      {
        AppMethodBeat.o(118091);
        return localObject;
      }
      ((p)localObject).fW(this);
    }
  }
  
  public final j gwa()
  {
    AppMethodBeat.i(221176);
    j localj = i.fX(gvZ());
    AppMethodBeat.o(221176);
    return localj;
  }
  
  public final j gwb()
  {
    AppMethodBeat.i(190829);
    j localj2 = gwc();
    j localj1 = localj2;
    if (localj2 == null) {
      localj1 = b((j)this._prev);
    }
    AppMethodBeat.o(190829);
    return localj1;
  }
  
  public boolean isRemoved()
  {
    AppMethodBeat.i(190827);
    boolean bool = gvZ() instanceof q;
    AppMethodBeat.o(190827);
    return bool;
  }
  
  public boolean remove()
  {
    AppMethodBeat.i(118096);
    Object localObject2 = gvZ();
    Object localObject1;
    if ((localObject2 instanceof q)) {
      localObject1 = ((q)localObject2).NKa;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label138;
      }
      AppMethodBeat.o(118096);
      return true;
      if (localObject2 == (j)this)
      {
        localObject1 = (j)localObject2;
      }
      else
      {
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
          AppMethodBeat.o(118096);
          throw ((Throwable)localObject1);
        }
        j localj = (j)localObject2;
        q localq = (q)localj._removedRef;
        localObject1 = localq;
        if (localq == null)
        {
          localObject1 = new q(localj);
          NJM.lazySet(localj, localObject1);
        }
        if (!NJK.compareAndSet(this, localObject2, localObject1)) {
          break;
        }
        ((j)localObject2).gwc();
        localObject1 = null;
      }
    }
    label138:
    AppMethodBeat.o(118096);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(118101);
    String str = getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(118101);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"})
  public static abstract class a
    extends c<j>
  {
    public j NJN;
    public final j NJO;
    
    public a(j paramj)
    {
      this.NJO = paramj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.j
 * JD-Core Version:    0.7.0.1
 */