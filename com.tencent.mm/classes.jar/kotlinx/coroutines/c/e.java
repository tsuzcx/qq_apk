package kotlinx.coroutines.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.a.j;
import kotlinx.coroutines.a.j.a;
import kotlinx.coroutines.a.j.b;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/scheduling/GlobalQueue;", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Lkotlinx/coroutines/scheduling/Task;", "()V", "removeFirstBlockingModeOrNull", "kotlinx-coroutines-core"})
public final class e
  extends kotlinx.coroutines.a.i<i>
{
  public final i eqG()
  {
    AppMethodBeat.i(118356);
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
          break label269;
        }
        localObject1 = (i)localObject1;
        AppMethodBeat.o(118356);
        return localObject1;
        localObject1 = j.CJr;
        int j = (int)((0x3FFFFFFF & l) >> 0);
        if (((int)((0xC0000000 & l) >> 30) & j.a(localj)) == (j.a(localj) & j))
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = j.b(localj).get(j.a(localj) & j);
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
            if (((i)localObject1).eqJ() == l.CKD) {}
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label184;
              }
              localObject1 = null;
              break;
            }
            label184:
            i = j + 1 & 0x3FFFFFFF;
            Object localObject2 = j.CJn;
            Object localObject3 = j.CJr;
            if (((AtomicLongFieldUpdater)localObject2).compareAndSet(localj, l, j.a.N(l, i)))
            {
              j.b(localj).set(j.a(localj) & j, null);
            }
            else
            {
              if (!j.c(localj)) {
                break;
              }
              localObject2 = localj;
              do
              {
                localObject3 = j.a((j)localObject2, j, i);
                localObject2 = localObject3;
              } while (localObject3 != null);
            }
          }
        }
      }
      label269:
      kotlinx.coroutines.a.i.CJl.compareAndSet(this, localj, localj.eqm());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.c.e
 * JD-Core Version:    0.7.0.1
 */