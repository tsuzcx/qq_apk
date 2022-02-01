package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.v;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"})
public class g
{
  static final AtomicReferenceFieldUpdater Kfl;
  static final AtomicReferenceFieldUpdater Kfm;
  private static final AtomicReferenceFieldUpdater Kfn;
  volatile Object _next;
  volatile Object _prev;
  private volatile Object _removedRef;
  
  static
  {
    AppMethodBeat.i(118104);
    Kfl = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_next");
    Kfm = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_prev");
    Kfn = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_removedRef");
    AppMethodBeat.o(118104);
  }
  
  public g()
  {
    AppMethodBeat.i(118102);
    this._next = this;
    this._prev = this;
    this._removedRef = null;
    AppMethodBeat.o(118102);
  }
  
  private static g b(g paramg)
  {
    AppMethodBeat.i(190075);
    for (;;)
    {
      if (!paramg.isRemoved())
      {
        AppMethodBeat.o(190075);
        return paramg;
      }
      paramg = (g)paramg._prev;
    }
  }
  
  private final void d(g paramg)
  {
    AppMethodBeat.i(118097);
    g localg;
    do
    {
      localg = (g)paramg._prev;
      if (fLN() != paramg)
      {
        AppMethodBeat.o(118097);
        return;
      }
    } while (!Kfm.compareAndSet(paramg, localg, this));
    if (isRemoved()) {
      paramg.fLQ();
    }
    AppMethodBeat.o(118097);
  }
  
  private final g fLQ()
  {
    AppMethodBeat.i(190076);
    g localg = (g)this._prev;
    Object localObject1 = null;
    Object localObject2 = localg;
    Object localObject3;
    for (;;)
    {
      localObject3 = ((g)localObject2)._next;
      if (localObject3 == (g)this)
      {
        if (localg == localObject2)
        {
          AppMethodBeat.o(190076);
          return localObject2;
        }
        if (!Kfm.compareAndSet(this, localg, localObject2)) {
          break;
        }
        AppMethodBeat.o(190076);
        return localObject2;
      }
      if (isRemoved())
      {
        AppMethodBeat.o(190076);
        return null;
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(190076);
        return localObject2;
      }
      if ((localObject3 instanceof j))
      {
        ((j)localObject3).fL(localObject2);
        break;
      }
      if (!(localObject3 instanceof k)) {
        break label158;
      }
      if (localObject1 == null) {
        break label145;
      }
      if (!Kfl.compareAndSet(localObject1, localObject2, ((k)localObject3).Kfw)) {
        break;
      }
      localObject2 = localObject1;
      localObject1 = null;
    }
    label145:
    localObject2 = ((g)localObject2)._prev;
    for (;;)
    {
      localObject2 = (g)localObject2;
      break;
      label158:
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(190076);
        throw ((Throwable)localObject1);
      }
      localObject1 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public final int a(g paramg1, g paramg2, a parama)
  {
    AppMethodBeat.i(118095);
    Kfm.lazySet(paramg1, this);
    Kfl.lazySet(paramg1, paramg2);
    parama.Kfo = paramg2;
    if (!Kfl.compareAndSet(this, paramg2, parama))
    {
      AppMethodBeat.o(118095);
      return 0;
    }
    if (parama.fL(this) == null)
    {
      AppMethodBeat.o(118095);
      return 1;
    }
    AppMethodBeat.o(118095);
    return 2;
  }
  
  public boolean bsN()
  {
    AppMethodBeat.i(118096);
    Object localObject2 = fLN();
    Object localObject1;
    if ((localObject2 instanceof k)) {
      localObject1 = ((k)localObject2).Kfw;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label138;
      }
      AppMethodBeat.o(118096);
      return true;
      if (localObject2 == (g)this)
      {
        localObject1 = (g)localObject2;
      }
      else
      {
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
          AppMethodBeat.o(118096);
          throw ((Throwable)localObject1);
        }
        g localg = (g)localObject2;
        k localk = (k)localg._removedRef;
        localObject1 = localk;
        if (localk == null)
        {
          localObject1 = new k(localg);
          Kfn.lazySet(localg, localObject1);
        }
        if (!Kfl.compareAndSet(this, localObject2, localObject1)) {
          break;
        }
        ((g)localObject2).fLQ();
        localObject1 = null;
      }
    }
    label138:
    AppMethodBeat.o(118096);
    return false;
  }
  
  public final boolean c(g paramg)
  {
    AppMethodBeat.i(118094);
    Kfm.lazySet(paramg, this);
    Kfl.lazySet(paramg, this);
    do
    {
      if (fLN() != (g)this)
      {
        AppMethodBeat.o(118094);
        return false;
      }
    } while (!Kfl.compareAndSet(this, this, paramg));
    paramg.d(this);
    AppMethodBeat.o(118094);
    return true;
  }
  
  public final Object fLN()
  {
    AppMethodBeat.i(118091);
    for (;;)
    {
      Object localObject = this._next;
      if (!(localObject instanceof j))
      {
        AppMethodBeat.o(118091);
        return localObject;
      }
      ((j)localObject).fL(this);
    }
  }
  
  public final g fLO()
  {
    AppMethodBeat.i(202361);
    g localg = f.fM(fLN());
    AppMethodBeat.o(202361);
    return localg;
  }
  
  public final g fLP()
  {
    AppMethodBeat.i(190074);
    g localg2 = fLQ();
    g localg1 = localg2;
    if (localg2 == null) {
      localg1 = b((g)this._prev);
    }
    AppMethodBeat.o(190074);
    return localg1;
  }
  
  public boolean isRemoved()
  {
    AppMethodBeat.i(190072);
    boolean bool = fLN() instanceof k;
    AppMethodBeat.o(190072);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(118101);
    String str = getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(118101);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"})
  public static abstract class a
    extends c<g>
  {
    public g Kfo;
    public final g Kfp;
    
    public a(g paramg)
    {
      this.Kfp = paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.g
 * JD-Core Version:    0.7.0.1
 */