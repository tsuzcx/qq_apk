package kotlinx.coroutines.a;

import a.f.b.j;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "()V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "_removedRef", "Lkotlinx/coroutines/internal/Removed;", "isRemoved", "", "()Z", "next", "getNext", "()Ljava/lang/Object;", "nextNode", "Lkotlinx/coroutines/internal/Node;", "getNextNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "prev", "getPrev", "prevNode", "getPrevNode", "addLast", "", "node", "addLastIf", "condition", "Lkotlin/Function0;", "addLastIfPrev", "predicate", "Lkotlin/Function1;", "addLastIfPrevAndIf", "addNext", "addOneIfEmpty", "correctPrev", "op", "Lkotlinx/coroutines/internal/OpDescriptor;", "describeAddLast", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "T", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeRemove", "Lkotlinx/coroutines/internal/AtomicDesc;", "describeRemoveFirst", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "findHead", "finishAdd", "finishRemove", "helpDelete", "helpRemove", "makeCondAddOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "markPrev", "remove", "removeFirstIfIsInstanceOf", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removed", "toString", "", "tryCondAddNext", "", "condAdd", "validateNode", "validateNode$kotlinx_coroutines_core", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "RemoveFirstDesc", "kotlinx-coroutines-core"})
public class h
{
  static final AtomicReferenceFieldUpdater CJd;
  static final AtomicReferenceFieldUpdater CJf;
  private static final AtomicReferenceFieldUpdater CJh;
  volatile Object CJc;
  volatile Object CJe;
  private volatile Object CJg;
  
  static
  {
    AppMethodBeat.i(118424);
    CJd = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "CJc");
    CJf = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "CJe");
    CJh = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "CJg");
    AppMethodBeat.o(118424);
  }
  
  public h()
  {
    AppMethodBeat.i(118422);
    this.CJc = this;
    this.CJe = this;
    this.CJg = null;
    AppMethodBeat.o(118422);
  }
  
  private final void c(h paramh)
  {
    AppMethodBeat.i(118417);
    Object localObject;
    do
    {
      localObject = paramh.CJe;
      if (((localObject instanceof l)) || (eqh() != paramh))
      {
        AppMethodBeat.o(118417);
        return;
      }
    } while (!CJf.compareAndSet(paramh, localObject, this));
    if ((eqh() instanceof l))
    {
      if (localObject == null)
      {
        paramh = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(118417);
        throw paramh;
      }
      paramh.d((h)localObject);
    }
    AppMethodBeat.o(118417);
  }
  
  private final h d(h paramh)
  {
    AppMethodBeat.i(118420);
    Object localObject1 = null;
    Object localObject3;
    do
    {
      for (;;)
      {
        Object localObject2 = paramh.CJc;
        if (localObject2 == null)
        {
          AppMethodBeat.o(118420);
          return paramh;
        }
        if ((localObject2 instanceof k))
        {
          ((k)localObject2).eg(paramh);
        }
        else if ((localObject2 instanceof l))
        {
          if (localObject1 != null)
          {
            paramh.eqk();
            CJd.compareAndSet(localObject1, paramh, ((l)localObject2).CJs);
            paramh = (h)localObject1;
            localObject1 = null;
          }
          else
          {
            paramh = g.eh(paramh.CJe);
          }
        }
        else
        {
          localObject3 = this.CJe;
          if ((localObject3 instanceof l))
          {
            AppMethodBeat.o(118420);
            return null;
          }
          if (localObject2 == (h)this) {
            break;
          }
          if (localObject2 == null)
          {
            paramh = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            AppMethodBeat.o(118420);
            throw paramh;
          }
          localObject2 = (h)localObject2;
          localObject1 = paramh;
          paramh = (h)localObject2;
        }
      }
      if (localObject3 == paramh)
      {
        AppMethodBeat.o(118420);
        return null;
      }
    } while ((!CJf.compareAndSet(this, localObject3, paramh)) || ((paramh.CJe instanceof l)));
    AppMethodBeat.o(118420);
    return null;
  }
  
  private final l eqg()
  {
    AppMethodBeat.i(118410);
    l locall2 = (l)this.CJg;
    l locall1 = locall2;
    if (locall2 == null)
    {
      locall1 = new l(this);
      CJh.lazySet(this, locall1);
    }
    AppMethodBeat.o(118410);
    return locall1;
  }
  
  private final h eqk()
  {
    AppMethodBeat.i(118418);
    Object localObject2 = this.CJe;
    if ((localObject2 instanceof l))
    {
      localObject1 = ((l)localObject2).CJs;
      AppMethodBeat.o(118418);
      return localObject1;
    }
    if (localObject2 == (h)this) {}
    for (Object localObject1 = eql();; localObject1 = (h)localObject2)
    {
      localObject1 = ((h)localObject1).eqg();
      if (!CJf.compareAndSet(this, localObject2, localObject1)) {
        break;
      }
      localObject1 = (h)localObject2;
      AppMethodBeat.o(118418);
      return localObject1;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(118418);
        throw ((Throwable)localObject1);
      }
    }
  }
  
  private final h eql()
  {
    AppMethodBeat.i(118419);
    Object localObject = (h)this;
    for (;;)
    {
      if ((localObject instanceof f))
      {
        AppMethodBeat.o(118419);
        return localObject;
      }
      localObject = g.eh(((h)localObject).eqh());
      if (localObject != (h)this) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = (Throwable)new IllegalStateException("Cannot loop to this while looking for list head".toString());
        AppMethodBeat.o(118419);
        throw ((Throwable)localObject);
      }
    }
  }
  
  public final int a(h paramh1, h paramh2, h.a parama)
  {
    AppMethodBeat.i(118415);
    j.q(paramh1, "node");
    j.q(paramh2, "next");
    j.q(parama, "condAdd");
    CJf.lazySet(paramh1, this);
    CJd.lazySet(paramh1, paramh2);
    parama.CJi = paramh2;
    if (!CJd.compareAndSet(this, paramh2, parama))
    {
      AppMethodBeat.o(118415);
      return 0;
    }
    if (parama.eg(this) == null)
    {
      AppMethodBeat.o(118415);
      return 1;
    }
    AppMethodBeat.o(118415);
    return 2;
  }
  
  public boolean aQx()
  {
    AppMethodBeat.i(118416);
    Object localObject2;
    do
    {
      localObject1 = eqh();
      if ((localObject1 instanceof l))
      {
        AppMethodBeat.o(118416);
        return false;
      }
      if (localObject1 == (h)this)
      {
        AppMethodBeat.o(118416);
        return false;
      }
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(118416);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((h)localObject1).eqg();
    } while (!CJd.compareAndSet(this, localObject1, localObject2));
    h localh1 = (h)localObject1;
    Object localObject1 = eqk();
    Object localObject3 = this.CJc;
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
      AppMethodBeat.o(118416);
      throw ((Throwable)localObject1);
    }
    for (;;)
    {
      h localh2 = ((l)localObject3).CJs;
      label250:
      do
      {
        for (;;)
        {
          localObject3 = localh2.eqh();
          if ((localObject3 instanceof l))
          {
            localh2.eqk();
            break;
          }
          localObject3 = ((h)localObject1).eqh();
          if ((localObject3 instanceof l))
          {
            if (localObject2 != null)
            {
              ((h)localObject1).eqk();
              CJd.compareAndSet(localObject2, localObject1, ((l)localObject3).CJs);
              localObject1 = localObject2;
              localObject2 = null;
            }
            else
            {
              localObject1 = g.eh(((h)localObject1).CJe);
            }
          }
          else
          {
            if (localObject3 == (h)this) {
              break label250;
            }
            if (localObject3 == null)
            {
              localObject1 = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
              AppMethodBeat.o(118416);
              throw ((Throwable)localObject1);
            }
            localObject3 = (h)localObject3;
            if (localObject3 == localh2) {
              break label263;
            }
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
      } while (!CJd.compareAndSet(localObject1, this, localh2));
      label263:
      localh1.d(g.eh(this.CJe));
      AppMethodBeat.o(118416);
      return true;
      localObject2 = null;
    }
  }
  
  public final boolean b(h paramh)
  {
    AppMethodBeat.i(118414);
    j.q(paramh, "node");
    CJf.lazySet(paramh, this);
    CJd.lazySet(paramh, this);
    do
    {
      if (eqh() != (h)this)
      {
        AppMethodBeat.o(118414);
        return false;
      }
    } while (!CJd.compareAndSet(this, this, paramh));
    paramh.c(this);
    AppMethodBeat.o(118414);
    return true;
  }
  
  public final Object eqh()
  {
    AppMethodBeat.i(118411);
    for (;;)
    {
      Object localObject = this.CJc;
      if (!(localObject instanceof k))
      {
        AppMethodBeat.o(118411);
        return localObject;
      }
      ((k)localObject).eg(this);
    }
  }
  
  public final h eqi()
  {
    AppMethodBeat.i(156746);
    h localh = g.eh(eqh());
    AppMethodBeat.o(156746);
    return localh;
  }
  
  public final Object eqj()
  {
    AppMethodBeat.i(118413);
    for (;;)
    {
      Object localObject = this.CJe;
      if ((localObject instanceof l))
      {
        AppMethodBeat.o(118413);
        return localObject;
      }
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(118413);
        throw ((Throwable)localObject);
      }
      if (((h)localObject).eqh() == (h)this)
      {
        AppMethodBeat.o(118413);
        return localObject;
      }
      d((h)localObject);
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(118421);
    String str = getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(118421);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.a.h
 * JD-Core Version:    0.7.0.1
 */