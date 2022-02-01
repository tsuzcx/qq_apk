package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public class p
{
  static
  {
    AppMethodBeat.i(118104);
    ajAk = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_next");
    ajAl = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_prev");
    ajAy = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_removedRef");
    AppMethodBeat.o(118104);
  }
  
  public p()
  {
    AppMethodBeat.i(118102);
    this._next = this;
    this._prev = this;
    this._removedRef = null;
    AppMethodBeat.o(118102);
  }
  
  private static p b(p paramp)
  {
    AppMethodBeat.i(189429);
    for (;;)
    {
      if (!paramp.isRemoved())
      {
        AppMethodBeat.o(189429);
        return paramp;
      }
      paramp = (p)paramp._prev;
    }
  }
  
  private final void e(p paramp)
  {
    AppMethodBeat.i(118097);
    p localp;
    do
    {
      localp = (p)paramp._prev;
      if (kDZ() != paramp)
      {
        AppMethodBeat.o(118097);
        return;
      }
    } while (!ajAl.compareAndSet(paramp, localp, this));
    if (isRemoved()) {
      paramp.kEg();
    }
    AppMethodBeat.o(118097);
  }
  
  private final x kDY()
  {
    AppMethodBeat.i(118090);
    x localx = (x)this._removedRef;
    if (localx == null)
    {
      localx = new x(this);
      ajAy.lazySet(this, localx);
      AppMethodBeat.o(118090);
      return localx;
    }
    AppMethodBeat.o(118090);
    return localx;
  }
  
  private final p kEg()
  {
    AppMethodBeat.i(189447);
    p localp = (p)this._prev;
    Object localObject2 = null;
    Object localObject1 = localp;
    for (;;)
    {
      Object localObject3 = ((p)localObject1)._next;
      if (localObject3 == this)
      {
        if (localp == localObject1)
        {
          AppMethodBeat.o(189447);
          return localObject1;
        }
        if (!ajAl.compareAndSet(this, localp, localObject1)) {
          break;
        }
        AppMethodBeat.o(189447);
        return localObject1;
      }
      if (isRemoved())
      {
        AppMethodBeat.o(189447);
        return null;
      }
      if (localObject3 == null)
      {
        AppMethodBeat.o(189447);
        return localObject1;
      }
      if ((localObject3 instanceof w))
      {
        ((w)localObject3).jj(localObject1);
        break;
      }
      if ((localObject3 instanceof x))
      {
        if (localObject2 != null)
        {
          if (!ajAk.compareAndSet(localObject2, localObject1, ((x)localObject3).ajAO)) {
            break;
          }
          localObject1 = localObject2;
          localObject2 = null;
          continue;
        }
        localObject1 = (p)((p)localObject1)._prev;
        continue;
      }
      localObject3 = (p)localObject3;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public final int a(p paramp1, p paramp2, a parama)
  {
    AppMethodBeat.i(118095);
    ajAl.lazySet(paramp1, this);
    ajAk.lazySet(paramp1, paramp2);
    parama.ajAA = paramp2;
    if (!ajAk.compareAndSet(this, paramp2, parama))
    {
      AppMethodBeat.o(118095);
      return 0;
    }
    if (parama.jj(this) == null)
    {
      AppMethodBeat.o(118095);
      return 1;
    }
    AppMethodBeat.o(118095);
    return 2;
  }
  
  public final boolean a(p paramp1, p paramp2)
  {
    AppMethodBeat.i(189500);
    ajAl.lazySet(paramp1, this);
    ajAk.lazySet(paramp1, paramp2);
    if (!ajAk.compareAndSet(this, paramp2, paramp1))
    {
      AppMethodBeat.o(189500);
      return false;
    }
    paramp1.e(paramp2);
    AppMethodBeat.o(189500);
    return true;
  }
  
  public final boolean c(p paramp)
  {
    AppMethodBeat.i(118094);
    ajAl.lazySet(paramp, this);
    ajAk.lazySet(paramp, this);
    do
    {
      if (kDZ() != this)
      {
        AppMethodBeat.o(118094);
        return false;
      }
    } while (!ajAk.compareAndSet(this, this, paramp));
    paramp.e(this);
    AppMethodBeat.o(118094);
    return true;
  }
  
  public final void d(p paramp)
  {
    AppMethodBeat.i(189489);
    while (!kEb().a(paramp, this)) {}
    AppMethodBeat.o(189489);
  }
  
  public boolean isRemoved()
  {
    AppMethodBeat.i(189461);
    boolean bool = kDZ() instanceof x;
    AppMethodBeat.o(189461);
    return bool;
  }
  
  public final Object kDZ()
  {
    AppMethodBeat.i(118091);
    for (;;)
    {
      Object localObject = this._next;
      if (!(localObject instanceof w))
      {
        AppMethodBeat.o(118091);
        return localObject;
      }
      ((w)localObject).jj(this);
    }
  }
  
  public final p kEa()
  {
    AppMethodBeat.i(369484);
    p localp = o.jk(kDZ());
    AppMethodBeat.o(369484);
    return localp;
  }
  
  public final p kEb()
  {
    AppMethodBeat.i(189473);
    p localp = kEg();
    if (localp == null)
    {
      localp = b((p)this._prev);
      AppMethodBeat.o(189473);
      return localp;
    }
    AppMethodBeat.o(189473);
    return localp;
  }
  
  public final p kEc()
  {
    AppMethodBeat.i(189525);
    Object localObject;
    x localx;
    do
    {
      localObject = kDZ();
      if ((localObject instanceof x))
      {
        localObject = ((x)localObject).ajAO;
        AppMethodBeat.o(189525);
        return localObject;
      }
      if (localObject == this)
      {
        localObject = (p)localObject;
        AppMethodBeat.o(189525);
        return localObject;
      }
      localx = ((p)localObject).kDY();
    } while (!ajAk.compareAndSet(this, localObject, localx));
    ((p)localObject).kEg();
    AppMethodBeat.o(189525);
    return null;
  }
  
  public final void kEd()
  {
    AppMethodBeat.i(189534);
    ((x)kDZ()).ajAO.kEe();
    AppMethodBeat.o(189534);
  }
  
  public final void kEe()
  {
    AppMethodBeat.i(189547);
    Object localObject;
    for (p localp = this;; localp = ((x)localObject).ajAO)
    {
      localObject = localp.kDZ();
      if (!(localObject instanceof x)) {
        break;
      }
    }
    localp.kEg();
    AppMethodBeat.o(189547);
  }
  
  public final p kEf()
  {
    AppMethodBeat.i(189555);
    for (;;)
    {
      p localp = (p)kDZ();
      if (localp == this)
      {
        AppMethodBeat.o(189555);
        return null;
      }
      if (localp.remove())
      {
        AppMethodBeat.o(189555);
        return localp;
      }
      localp.kEd();
    }
  }
  
  public boolean remove()
  {
    AppMethodBeat.i(118096);
    if (kEc() == null)
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
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a
    extends c<p>
  {
    public p ajAA;
    public final p ajAz;
    
    public a(p paramp)
    {
      this.ajAz = paramp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.p
 * JD-Core Version:    0.7.0.1
 */