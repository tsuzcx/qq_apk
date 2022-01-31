package kotlinx.coroutines.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "E", "", "singleConsumer", "", "(Z)V", "_cur", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "isEmpty", "()Z", "size", "", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)Z", "close", "", "map", "", "R", "transform", "Lkotlin/Function1;", "removeFirstOrNull", "()Ljava/lang/Object;", "removeFirstOrNullIf", "predicate", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public class i<E>
{
  static
  {
    AppMethodBeat.i(118450);
    CJl = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "CJk");
    AppMethodBeat.o(118450);
  }
  
  public i()
  {
    AppMethodBeat.i(118449);
    this.CJk = new j(8, false);
    AppMethodBeat.o(118449);
  }
  
  public final void close()
  {
    AppMethodBeat.i(118446);
    for (;;)
    {
      j localj = (j)this.CJk;
      long l = localj.CJm;
      if ((l & 0x0) == 0L) {
        if ((0x0 & l) == 0L) {}
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label74;
        }
        AppMethodBeat.o(118446);
        return;
        if (!j.CJn.compareAndSet(localj, l, l | 0x0)) {
          break;
        }
      }
      label74:
      CJl.compareAndSet(this, localj, localj.eqm());
    }
  }
  
  public final boolean ei(E paramE)
  {
    AppMethodBeat.i(118447);
    a.f.b.j.q(paramE, "element");
    for (;;)
    {
      j localj = (j)this.CJk;
      switch (localj.ej(paramE))
      {
      default: 
        break;
      case 0: 
        AppMethodBeat.o(118447);
        return true;
      case 2: 
        AppMethodBeat.o(118447);
        return false;
      case 1: 
        CJl.compareAndSet(this, localj, localj.eqm());
      }
    }
  }
  
  public final E eqc()
  {
    AppMethodBeat.i(118448);
    for (;;)
    {
      j localj = (j)this.CJk;
      long l = localj.CJm;
      Object localObject1;
      if ((0x0 & l) != 0L) {
        localObject1 = j.CJq;
      }
      for (;;)
      {
        if (localObject1 == j.CJq) {
          break label231;
        }
        AppMethodBeat.o(118448);
        return localObject1;
        localObject1 = j.CJr;
        int i = (int)((0x3FFFFFFF & l) >> 0);
        if (((int)((0xC0000000 & l) >> 30) & j.a(localj)) == (j.a(localj) & i))
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = j.b(localj).get(j.a(localj) & i);
          if (localObject1 == null)
          {
            if (!j.c(localj)) {
              break;
            }
            localObject1 = null;
            continue;
          }
          if ((localObject1 instanceof j.b))
          {
            localObject1 = null;
          }
          else
          {
            int j = i + 1 & 0x3FFFFFFF;
            Object localObject2 = j.CJn;
            Object localObject3 = j.CJr;
            if (((AtomicLongFieldUpdater)localObject2).compareAndSet(localj, l, j.a.N(l, j)))
            {
              j.b(localj).set(j.a(localj) & i, null);
            }
            else
            {
              if (!j.c(localj)) {
                break;
              }
              localObject2 = localj;
              do
              {
                localObject3 = j.a((j)localObject2, i, j);
                localObject2 = localObject3;
              } while (localObject3 != null);
            }
          }
        }
      }
      label231:
      CJl.compareAndSet(this, localj, localj.eqm());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.a.i
 * JD-Core Version:    0.7.0.1
 */