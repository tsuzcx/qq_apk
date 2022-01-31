package kotlinx.coroutines.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "E", "", "capacity", "", "singleConsumer", "", "(IZ)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_state", "Lkotlinx/atomicfu/AtomicLong;", "array", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "isEmpty", "()Z", "mask", "size", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)I", "allocateNextCopy", "state", "", "allocateOrGetNextCopy", "close", "fillPlaceholder", "index", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "map", "", "R", "transform", "Lkotlin/Function1;", "markFrozen", "next", "removeFirstOrNull", "removeFirstOrNullIf", "predicate", "removeSlowPath", "oldHead", "newHead", "Companion", "Placeholder", "kotlinx-coroutines-core"})
public final class j<E>
{
  private static final AtomicReferenceFieldUpdater CJd;
  public static final m CJq;
  public static final j.a CJr;
  private volatile Object CJc;
  private final AtomicReferenceArray<Object> CJo;
  private final boolean CJp;
  private final int capacity;
  private final int mask;
  
  static
  {
    AppMethodBeat.i(118408);
    CJr = new j.a((byte)0);
    CJq = new m("REMOVE_FROZEN");
    CJd = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "CJc");
    CJn = AtomicLongFieldUpdater.newUpdater(j.class, "CJm");
    AppMethodBeat.o(118408);
  }
  
  public j(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(118406);
    this.capacity = paramInt;
    this.CJp = paramBoolean;
    this.mask = (this.capacity - 1);
    this.CJc = null;
    this.CJm = 0L;
    this.CJo = new AtomicReferenceArray(this.capacity);
    if (this.mask <= 1073741823) {}
    Throwable localThrowable;
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118406);
      throw localThrowable;
    }
    if ((this.capacity & this.mask) == 0) {}
    for (paramInt = i; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118406);
      throw localThrowable;
    }
    AppMethodBeat.o(118406);
  }
  
  private final long eqn()
  {
    AppMethodBeat.i(118403);
    long l1;
    long l2;
    do
    {
      l1 = this.CJm;
      if ((l1 & 0x0) != 0L)
      {
        AppMethodBeat.o(118403);
        return l1;
      }
      l2 = l1 | 0x0;
    } while (!CJn.compareAndSet(this, l1, l2));
    AppMethodBeat.o(118403);
    return l2;
  }
  
  private final j<E> pw(long paramLong)
  {
    AppMethodBeat.i(118404);
    for (;;)
    {
      j localj = (j)this.CJc;
      if (localj != null)
      {
        AppMethodBeat.o(118404);
        return localj;
      }
      CJd.compareAndSet(this, null, px(paramLong));
    }
  }
  
  private final j<E> px(long paramLong)
  {
    AppMethodBeat.i(118405);
    j localj = new j(this.capacity * 2, this.CJp);
    int i = (int)((0x3FFFFFFF & paramLong) >> 0);
    int j = (int)((0xC0000000 & paramLong) >> 30);
    while ((this.mask & i) != (this.mask & j))
    {
      AtomicReferenceArray localAtomicReferenceArray = localj.CJo;
      int k = localj.mask;
      Object localObject2 = this.CJo.get(this.mask & i);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new j.b(i);
      }
      localAtomicReferenceArray.set(i & k, localObject1);
      i += 1;
    }
    localj.CJm = (0xFFFFFFFF & paramLong);
    AppMethodBeat.o(118405);
    return localj;
  }
  
  private final j<E> v(int paramInt, E paramE)
  {
    AppMethodBeat.i(118401);
    Object localObject = this.CJo.get(this.mask & paramInt);
    if (((localObject instanceof j.b)) && (((j.b)localObject).index == paramInt))
    {
      this.CJo.set(this.mask & paramInt, paramE);
      AppMethodBeat.o(118401);
      return this;
    }
    AppMethodBeat.o(118401);
    return null;
  }
  
  public final int ej(E paramE)
  {
    AppMethodBeat.i(118400);
    a.f.b.j.q(paramE, "element");
    long l;
    int j;
    int k;
    do
    {
      int i;
      do
      {
        l = this.CJm;
        if ((0x0 & l) != 0L)
        {
          i = j.a.py(l);
          AppMethodBeat.o(118400);
          return i;
        }
        i = (int)((0x3FFFFFFF & l) >> 0);
        j = (int)((0xC0000000 & l) >> 30);
        k = this.mask;
        if ((j + 2 & k) == (i & k))
        {
          AppMethodBeat.o(118400);
          return 1;
        }
        if ((this.CJp) || (this.CJo.get(j & k) == null)) {
          break;
        }
      } while ((this.capacity >= 1024) && ((j - i & 0x3FFFFFFF) <= this.capacity >> 1));
      AppMethodBeat.o(118400);
      return 1;
    } while (!CJn.compareAndSet(this, l, j.a.O(l, j + 1 & 0x3FFFFFFF)));
    this.CJo.set(j & k, paramE);
    Object localObject = (j)this;
    j localj;
    do
    {
      if ((((j)localObject).CJm & 0x0) == 0L) {
        break;
      }
      localj = ((j)localObject).eqm().v(j, paramE);
      localObject = localj;
    } while (localj != null);
    AppMethodBeat.o(118400);
    return 0;
  }
  
  public final j<E> eqm()
  {
    AppMethodBeat.i(118402);
    j localj = pw(eqn());
    AppMethodBeat.o(118402);
    return localj;
  }
  
  public final boolean isEmpty()
  {
    boolean bool = false;
    long l = this.CJm;
    if ((int)((0x3FFFFFFF & l) >> 0) == (int)((l & 0xC0000000) >> 30)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.a.j
 * JD-Core Version:    0.7.0.1
 */