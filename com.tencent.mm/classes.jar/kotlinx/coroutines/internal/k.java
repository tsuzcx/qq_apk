package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"})
public class k
{
  static final AtomicReferenceFieldUpdater TVO;
  static final AtomicReferenceFieldUpdater TVP;
  private static final AtomicReferenceFieldUpdater TVQ;
  volatile Object _next;
  volatile Object _prev;
  private volatile Object _removedRef;
  
  static
  {
    AppMethodBeat.i(118104);
    TVO = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");
    TVP = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_prev");
    TVQ = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_removedRef");
    AppMethodBeat.o(118104);
  }
  
  public k()
  {
    AppMethodBeat.i(118102);
    this._next = this;
    this._prev = this;
    this._removedRef = null;
    AppMethodBeat.o(118102);
  }
  
  private static k b(k paramk)
  {
    AppMethodBeat.i(192465);
    for (;;)
    {
      if (!paramk.isRemoved())
      {
        AppMethodBeat.o(192465);
        return paramk;
      }
      paramk = (k)paramk._prev;
    }
  }
  
  private final void d(k paramk)
  {
    AppMethodBeat.i(118097);
    k localk;
    do
    {
      localk = (k)paramk._prev;
      if (hNI() != paramk)
      {
        AppMethodBeat.o(118097);
        return;
      }
    } while (!TVP.compareAndSet(paramk, localk, this));
    if (isRemoved()) {
      paramk.hNL();
    }
    AppMethodBeat.o(118097);
  }
  
  private final k hNL()
  {
    AppMethodBeat.i(192466);
    k localk = (k)this._prev;
    Object localObject1 = null;
    Object localObject2 = localk;
    Object localObject3;
    for (;;)
    {
      localObject3 = ((k)localObject2)._next;
      if (localObject3 == (k)this)
      {
        if (localk == localObject2)
        {
          AppMethodBeat.o(192466);
          return localObject2;
        }
        if (!TVP.compareAndSet(this, localk, localObject2)) {
          break;
        }
        AppMethodBeat.o(192466);
        return localObject2;
      }
      if (isRemoved())
      {
        AppMethodBeat.o(192466);
        return null;
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(192466);
        return localObject2;
      }
      if ((localObject3 instanceof q))
      {
        ((q)localObject3).ge(localObject2);
        break;
      }
      if (!(localObject3 instanceof r)) {
        break label158;
      }
      if (localObject1 == null) {
        break label145;
      }
      if (!TVO.compareAndSet(localObject1, localObject2, ((r)localObject3).TWe)) {
        break;
      }
      localObject2 = localObject1;
      localObject1 = null;
    }
    label145:
    localObject2 = ((k)localObject2)._prev;
    for (;;)
    {
      localObject2 = (k)localObject2;
      break;
      label158:
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(192466);
        throw ((Throwable)localObject1);
      }
      localObject1 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public final int a(k paramk1, k paramk2, a parama)
  {
    AppMethodBeat.i(118095);
    TVP.lazySet(paramk1, this);
    TVO.lazySet(paramk1, paramk2);
    parama.TVR = paramk2;
    if (!TVO.compareAndSet(this, paramk2, parama))
    {
      AppMethodBeat.o(118095);
      return 0;
    }
    if (parama.ge(this) == null)
    {
      AppMethodBeat.o(118095);
      return 1;
    }
    AppMethodBeat.o(118095);
    return 2;
  }
  
  public final boolean c(k paramk)
  {
    AppMethodBeat.i(118094);
    TVP.lazySet(paramk, this);
    TVO.lazySet(paramk, this);
    do
    {
      if (hNI() != (k)this)
      {
        AppMethodBeat.o(118094);
        return false;
      }
    } while (!TVO.compareAndSet(this, this, paramk));
    paramk.d(this);
    AppMethodBeat.o(118094);
    return true;
  }
  
  public final Object hNI()
  {
    AppMethodBeat.i(118091);
    for (;;)
    {
      Object localObject = this._next;
      if (!(localObject instanceof q))
      {
        AppMethodBeat.o(118091);
        return localObject;
      }
      ((q)localObject).ge(this);
    }
  }
  
  public final k hNJ()
  {
    AppMethodBeat.i(258588);
    k localk = j.gf(hNI());
    AppMethodBeat.o(258588);
    return localk;
  }
  
  public final k hNK()
  {
    AppMethodBeat.i(192464);
    k localk2 = hNL();
    k localk1 = localk2;
    if (localk2 == null) {
      localk1 = b((k)this._prev);
    }
    AppMethodBeat.o(192464);
    return localk1;
  }
  
  public boolean isRemoved()
  {
    AppMethodBeat.i(192462);
    boolean bool = hNI() instanceof r;
    AppMethodBeat.o(192462);
    return bool;
  }
  
  public boolean remove()
  {
    AppMethodBeat.i(118096);
    Object localObject2 = hNI();
    Object localObject1;
    if ((localObject2 instanceof r)) {
      localObject1 = ((r)localObject2).TWe;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label138;
      }
      AppMethodBeat.o(118096);
      return true;
      if (localObject2 == (k)this)
      {
        localObject1 = (k)localObject2;
      }
      else
      {
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
          AppMethodBeat.o(118096);
          throw ((Throwable)localObject1);
        }
        k localk = (k)localObject2;
        r localr = (r)localk._removedRef;
        localObject1 = localr;
        if (localr == null)
        {
          localObject1 = new r(localk);
          TVQ.lazySet(localk, localObject1);
        }
        if (!TVO.compareAndSet(this, localObject2, localObject1)) {
          break;
        }
        ((k)localObject2).hNL();
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"})
  public static abstract class a
    extends c<k>
  {
    public k TVR;
    public final k TVS;
    
    public a(k paramk)
    {
      this.TVS = paramk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.k
 * JD-Core Version:    0.7.0.1
 */