package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.v;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"})
public class i
{
  static final AtomicReferenceFieldUpdater LSN;
  static final AtomicReferenceFieldUpdater LSO;
  private static final AtomicReferenceFieldUpdater LSP;
  volatile Object _next;
  volatile Object _prev;
  private volatile Object _removedRef;
  
  static
  {
    AppMethodBeat.i(118104);
    LSN = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_next");
    LSO = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_prev");
    LSP = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_removedRef");
    AppMethodBeat.o(118104);
  }
  
  public i()
  {
    AppMethodBeat.i(118102);
    this._next = this;
    this._prev = this;
    this._removedRef = null;
    AppMethodBeat.o(118102);
  }
  
  private static i b(i parami)
  {
    AppMethodBeat.i(191219);
    for (;;)
    {
      if (!parami.isRemoved())
      {
        AppMethodBeat.o(191219);
        return parami;
      }
      parami = (i)parami._prev;
    }
  }
  
  private final void d(i parami)
  {
    AppMethodBeat.i(118097);
    i locali;
    do
    {
      locali = (i)parami._prev;
      if (geA() != parami)
      {
        AppMethodBeat.o(118097);
        return;
      }
    } while (!LSO.compareAndSet(parami, locali, this));
    if (isRemoved()) {
      parami.geD();
    }
    AppMethodBeat.o(118097);
  }
  
  private final i geD()
  {
    AppMethodBeat.i(191220);
    i locali = (i)this._prev;
    Object localObject1 = null;
    Object localObject2 = locali;
    Object localObject3;
    for (;;)
    {
      localObject3 = ((i)localObject2)._next;
      if (localObject3 == (i)this)
      {
        if (locali == localObject2)
        {
          AppMethodBeat.o(191220);
          return localObject2;
        }
        if (!LSO.compareAndSet(this, locali, localObject2)) {
          break;
        }
        AppMethodBeat.o(191220);
        return localObject2;
      }
      if (isRemoved())
      {
        AppMethodBeat.o(191220);
        return null;
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(191220);
        return localObject2;
      }
      if ((localObject3 instanceof o))
      {
        ((o)localObject3).fT(localObject2);
        break;
      }
      if (!(localObject3 instanceof p)) {
        break label158;
      }
      if (localObject1 == null) {
        break label145;
      }
      if (!LSN.compareAndSet(localObject1, localObject2, ((p)localObject3).LTd)) {
        break;
      }
      localObject2 = localObject1;
      localObject1 = null;
    }
    label145:
    localObject2 = ((i)localObject2)._prev;
    for (;;)
    {
      localObject2 = (i)localObject2;
      break;
      label158:
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(191220);
        throw ((Throwable)localObject1);
      }
      localObject1 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public final int a(i parami1, i parami2, a parama)
  {
    AppMethodBeat.i(118095);
    LSO.lazySet(parami1, this);
    LSN.lazySet(parami1, parami2);
    parama.LSQ = parami2;
    if (!LSN.compareAndSet(this, parami2, parama))
    {
      AppMethodBeat.o(118095);
      return 0;
    }
    if (parama.fT(this) == null)
    {
      AppMethodBeat.o(118095);
      return 1;
    }
    AppMethodBeat.o(118095);
    return 2;
  }
  
  public boolean bzN()
  {
    AppMethodBeat.i(118096);
    Object localObject2 = geA();
    Object localObject1;
    if ((localObject2 instanceof p)) {
      localObject1 = ((p)localObject2).LTd;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label138;
      }
      AppMethodBeat.o(118096);
      return true;
      if (localObject2 == (i)this)
      {
        localObject1 = (i)localObject2;
      }
      else
      {
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
          AppMethodBeat.o(118096);
          throw ((Throwable)localObject1);
        }
        i locali = (i)localObject2;
        p localp = (p)locali._removedRef;
        localObject1 = localp;
        if (localp == null)
        {
          localObject1 = new p(locali);
          LSP.lazySet(locali, localObject1);
        }
        if (!LSN.compareAndSet(this, localObject2, localObject1)) {
          break;
        }
        ((i)localObject2).geD();
        localObject1 = null;
      }
    }
    label138:
    AppMethodBeat.o(118096);
    return false;
  }
  
  public final boolean c(i parami)
  {
    AppMethodBeat.i(118094);
    LSO.lazySet(parami, this);
    LSN.lazySet(parami, this);
    do
    {
      if (geA() != (i)this)
      {
        AppMethodBeat.o(118094);
        return false;
      }
    } while (!LSN.compareAndSet(this, this, parami));
    parami.d(this);
    AppMethodBeat.o(118094);
    return true;
  }
  
  public final Object geA()
  {
    AppMethodBeat.i(118091);
    for (;;)
    {
      Object localObject = this._next;
      if (!(localObject instanceof o))
      {
        AppMethodBeat.o(118091);
        return localObject;
      }
      ((o)localObject).fT(this);
    }
  }
  
  public final i geB()
  {
    AppMethodBeat.i(210003);
    i locali = h.fU(geA());
    AppMethodBeat.o(210003);
    return locali;
  }
  
  public final i geC()
  {
    AppMethodBeat.i(191218);
    i locali2 = geD();
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = b((i)this._prev);
    }
    AppMethodBeat.o(191218);
    return locali1;
  }
  
  public boolean isRemoved()
  {
    AppMethodBeat.i(191216);
    boolean bool = geA() instanceof p;
    AppMethodBeat.o(191216);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(118101);
    String str = getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(118101);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"})
  public static abstract class a
    extends c<i>
  {
    public i LSQ;
    public final i LSR;
    
    public a(i parami)
    {
      this.LSR = parami;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.i
 * JD-Core Version:    0.7.0.1
 */