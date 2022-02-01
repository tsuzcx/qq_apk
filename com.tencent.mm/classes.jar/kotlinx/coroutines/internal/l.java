package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"})
public class l
{
  static final AtomicReferenceFieldUpdater abzf;
  static final AtomicReferenceFieldUpdater abzg;
  private static final AtomicReferenceFieldUpdater abzh;
  volatile Object _next;
  volatile Object _prev;
  private volatile Object _removedRef;
  
  static
  {
    AppMethodBeat.i(118104);
    abzf = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_next");
    abzg = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_prev");
    abzh = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_removedRef");
    AppMethodBeat.o(118104);
  }
  
  public l()
  {
    AppMethodBeat.i(118102);
    this._next = this;
    this._prev = this;
    this._removedRef = null;
    AppMethodBeat.o(118102);
  }
  
  private static l b(l paraml)
  {
    AppMethodBeat.i(205078);
    for (;;)
    {
      if (!paraml.isRemoved())
      {
        AppMethodBeat.o(205078);
        return paraml;
      }
      paraml = (l)paraml._prev;
    }
  }
  
  private final void d(l paraml)
  {
    AppMethodBeat.i(118097);
    l locall;
    do
    {
      locall = (l)paraml._prev;
      if (iSL() != paraml)
      {
        AppMethodBeat.o(118097);
        return;
      }
    } while (!abzg.compareAndSet(paraml, locall, this));
    if (isRemoved()) {
      paraml.iSR();
    }
    AppMethodBeat.o(118097);
  }
  
  private final s iSK()
  {
    AppMethodBeat.i(118090);
    s locals2 = (s)this._removedRef;
    s locals1 = locals2;
    if (locals2 == null)
    {
      locals1 = new s(this);
      abzh.lazySet(this, locals1);
    }
    AppMethodBeat.o(118090);
    return locals1;
  }
  
  private final l iSR()
  {
    AppMethodBeat.i(205083);
    l locall = (l)this._prev;
    Object localObject1 = null;
    Object localObject2 = locall;
    Object localObject3;
    for (;;)
    {
      localObject3 = ((l)localObject2)._next;
      if (localObject3 == (l)this)
      {
        if (locall == localObject2)
        {
          AppMethodBeat.o(205083);
          return localObject2;
        }
        if (!abzg.compareAndSet(this, locall, localObject2)) {
          break;
        }
        AppMethodBeat.o(205083);
        return localObject2;
      }
      if (isRemoved())
      {
        AppMethodBeat.o(205083);
        return null;
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(205083);
        return localObject2;
      }
      if ((localObject3 instanceof r))
      {
        ((r)localObject3).gw(localObject2);
        break;
      }
      if (!(localObject3 instanceof s)) {
        break label158;
      }
      if (localObject1 == null) {
        break label145;
      }
      if (!abzf.compareAndSet(localObject1, localObject2, ((s)localObject3).abzv)) {
        break;
      }
      localObject2 = localObject1;
      localObject1 = null;
    }
    label145:
    localObject2 = ((l)localObject2)._prev;
    for (;;)
    {
      localObject2 = (l)localObject2;
      break;
      label158:
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(205083);
        throw ((Throwable)localObject1);
      }
      localObject1 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public final int a(l paraml1, l paraml2, a parama)
  {
    AppMethodBeat.i(118095);
    abzg.lazySet(paraml1, this);
    abzf.lazySet(paraml1, paraml2);
    parama.abzi = paraml2;
    if (!abzf.compareAndSet(this, paraml2, parama))
    {
      AppMethodBeat.o(118095);
      return 0;
    }
    if (parama.gw(this) == null)
    {
      AppMethodBeat.o(118095);
      return 1;
    }
    AppMethodBeat.o(118095);
    return 2;
  }
  
  public final boolean a(l paraml1, l paraml2)
  {
    AppMethodBeat.i(205079);
    abzg.lazySet(paraml1, this);
    abzf.lazySet(paraml1, paraml2);
    if (!abzf.compareAndSet(this, paraml2, paraml1))
    {
      AppMethodBeat.o(205079);
      return false;
    }
    paraml1.d(paraml2);
    AppMethodBeat.o(205079);
    return true;
  }
  
  public final boolean c(l paraml)
  {
    AppMethodBeat.i(118094);
    abzg.lazySet(paraml, this);
    abzf.lazySet(paraml, this);
    do
    {
      if (iSL() != (l)this)
      {
        AppMethodBeat.o(118094);
        return false;
      }
    } while (!abzf.compareAndSet(this, this, paraml));
    paraml.d(this);
    AppMethodBeat.o(118094);
    return true;
  }
  
  public final Object iSL()
  {
    AppMethodBeat.i(118091);
    for (;;)
    {
      Object localObject = this._next;
      if (!(localObject instanceof r))
      {
        AppMethodBeat.o(118091);
        return localObject;
      }
      ((r)localObject).gw(this);
    }
  }
  
  public final l iSM()
  {
    AppMethodBeat.i(292732);
    l locall = k.gx(iSL());
    AppMethodBeat.o(292732);
    return locall;
  }
  
  public final l iSN()
  {
    AppMethodBeat.i(205077);
    l locall2 = iSR();
    l locall1 = locall2;
    if (locall2 == null) {
      locall1 = b((l)this._prev);
    }
    AppMethodBeat.o(205077);
    return locall1;
  }
  
  public final l iSO()
  {
    AppMethodBeat.i(205080);
    Object localObject;
    s locals;
    do
    {
      localObject = iSL();
      if ((localObject instanceof s))
      {
        localObject = ((s)localObject).abzv;
        AppMethodBeat.o(205080);
        return localObject;
      }
      if (localObject == (l)this)
      {
        localObject = (l)localObject;
        AppMethodBeat.o(205080);
        return localObject;
      }
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(205080);
        throw ((Throwable)localObject);
      }
      locals = ((l)localObject).iSK();
    } while (!abzf.compareAndSet(this, localObject, locals));
    ((l)localObject).iSR();
    AppMethodBeat.o(205080);
    return null;
  }
  
  public final void iSP()
  {
    AppMethodBeat.i(205081);
    Object localObject = iSL();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
      AppMethodBeat.o(205081);
      throw ((Throwable)localObject);
    }
    ((s)localObject).abzv.iSR();
    AppMethodBeat.o(205081);
  }
  
  public final void iSQ()
  {
    AppMethodBeat.i(205082);
    Object localObject;
    for (l locall = (l)this;; locall = ((s)localObject).abzv)
    {
      localObject = locall.iSL();
      if (!(localObject instanceof s)) {
        break;
      }
    }
    locall.iSR();
    AppMethodBeat.o(205082);
  }
  
  public boolean isRemoved()
  {
    AppMethodBeat.i(205074);
    boolean bool = iSL() instanceof s;
    AppMethodBeat.o(205074);
    return bool;
  }
  
  public boolean remove()
  {
    AppMethodBeat.i(118096);
    if (iSO() == null)
    {
      AppMethodBeat.o(118096);
      return true;
    }
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"})
  public static abstract class a
    extends c<l>
  {
    public l abzi;
    public final l abzj;
    
    public a(l paraml)
    {
      this.abzj = paraml;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.l
 * JD-Core Version:    0.7.0.1
 */