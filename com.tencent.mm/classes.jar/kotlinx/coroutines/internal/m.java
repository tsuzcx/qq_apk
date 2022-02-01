package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.l;
import kotlinx.coroutines.an;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"})
public final class m<E>
{
  private static final AtomicReferenceFieldUpdater TVO;
  private static final AtomicLongFieldUpdater TVU;
  public static final u TVX;
  public static final a TVY;
  private AtomicReferenceArray TVV;
  private final boolean TVW;
  private volatile Object _next;
  volatile long _state;
  private final int bwA;
  private final int mask;
  
  static
  {
    AppMethodBeat.i(118088);
    TVY = new a((byte)0);
    TVX = new u("REMOVE_FROZEN");
    TVO = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next");
    TVU = AtomicLongFieldUpdater.newUpdater(m.class, "_state");
    AppMethodBeat.o(118088);
  }
  
  public m(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(118086);
    this.bwA = paramInt;
    this.TVW = paramBoolean;
    this.mask = (this.bwA - 1);
    this._next = null;
    this._state = 0L;
    this.TVV = new AtomicReferenceArray(this.bwA);
    if (this.mask <= 1073741823) {}
    Throwable localThrowable;
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    if ((this.bwA & this.mask) == 0) {}
    for (paramInt = i; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    AppMethodBeat.o(118086);
  }
  
  private final m<E> Pm(long paramLong)
  {
    AppMethodBeat.i(118084);
    for (;;)
    {
      m localm = (m)this._next;
      if (localm != null)
      {
        AppMethodBeat.o(118084);
        return localm;
      }
      TVO.compareAndSet(this, null, Pn(paramLong));
    }
  }
  
  private final m<E> Pn(long paramLong)
  {
    AppMethodBeat.i(118085);
    m localm = new m(this.bwA * 2, this.TVW);
    int i = (int)((0x3FFFFFFF & paramLong) >> 0);
    int j = (int)((0xC0000000 & paramLong) >> 30);
    while ((this.mask & i) != (this.mask & j))
    {
      Object localObject2 = this.TVV.get(this.mask & i);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new b(i);
      }
      localm.TVV.set(localm.mask & i, localObject1);
      i += 1;
    }
    localm._state = (0xFFFFFFFF & paramLong);
    AppMethodBeat.o(118085);
    return localm;
  }
  
  private final long hNN()
  {
    AppMethodBeat.i(118083);
    long l1;
    long l2;
    do
    {
      l1 = this._state;
      if ((l1 & 0x0) != 0L)
      {
        AppMethodBeat.o(118083);
        return l1;
      }
      l2 = l1 | 0x0;
    } while (!TVU.compareAndSet(this, l1, l2));
    AppMethodBeat.o(118083);
    return l2;
  }
  
  private final m<E> nc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192475);
    long l;
    int j;
    do
    {
      l = this._state;
      j = (int)((0x3FFFFFFF & l) >> 0);
      Object localObject;
      if (an.hMK())
      {
        if (j == paramInt1) {}
        for (int i = 1; i == 0; i = 0)
        {
          localObject = (Throwable)new AssertionError();
          AppMethodBeat.o(192475);
          throw ((Throwable)localObject);
        }
      }
      if ((0x0 & l) != 0L)
      {
        localObject = hNM();
        AppMethodBeat.o(192475);
        return localObject;
      }
    } while (!TVU.compareAndSet(this, l, a.au(l, paramInt2)));
    this.TVV.set(this.mask & j, null);
    AppMethodBeat.o(192475);
    return null;
  }
  
  private final m<E> x(int paramInt, E paramE)
  {
    AppMethodBeat.i(118081);
    Object localObject = this.TVV.get(this.mask & paramInt);
    if (((localObject instanceof b)) && (((b)localObject).index == paramInt))
    {
      this.TVV.set(this.mask & paramInt, paramE);
      AppMethodBeat.o(118081);
      return this;
    }
    AppMethodBeat.o(118081);
    return null;
  }
  
  public final boolean close()
  {
    AppMethodBeat.i(192473);
    long l;
    do
    {
      l = this._state;
      if ((l & 0x0) != 0L)
      {
        AppMethodBeat.o(192473);
        return true;
      }
      if ((0x0 & l) != 0L)
      {
        AppMethodBeat.o(192473);
        return false;
      }
    } while (!TVU.compareAndSet(this, l, l | 0x0));
    AppMethodBeat.o(192473);
    return true;
  }
  
  public final int gh(E paramE)
  {
    AppMethodBeat.i(118080);
    long l;
    int j;
    int k;
    do
    {
      int i;
      do
      {
        l = this._state;
        if ((0x0 & l) != 0L)
        {
          i = a.Po(l);
          AppMethodBeat.o(118080);
          return i;
        }
        i = (int)((0x3FFFFFFF & l) >> 0);
        j = (int)((0xC0000000 & l) >> 30);
        k = this.mask;
        if ((j + 2 & k) == (i & k))
        {
          AppMethodBeat.o(118080);
          return 1;
        }
        if ((this.TVW) || (this.TVV.get(j & k) == null)) {
          break;
        }
      } while ((this.bwA >= 1024) && ((j - i & 0x3FFFFFFF) <= this.bwA >> 1));
      AppMethodBeat.o(118080);
      return 1;
    } while (!TVU.compareAndSet(this, l, a.av(l, j + 1 & 0x3FFFFFFF)));
    this.TVV.set(j & k, paramE);
    Object localObject = (m)this;
    m localm;
    do
    {
      if ((((m)localObject)._state & 0x0) == 0L) {
        break;
      }
      localm = ((m)localObject).hNM().x(j, paramE);
      localObject = localm;
    } while (localm != null);
    AppMethodBeat.o(118080);
    return 0;
  }
  
  public final Object hNC()
  {
    AppMethodBeat.i(192474);
    int i;
    Object localObject2;
    int j;
    do
    {
      long l;
      do
      {
        l = this._state;
        if ((0x0 & l) != 0L)
        {
          localObject1 = TVX;
          AppMethodBeat.o(192474);
          return localObject1;
        }
        i = (int)((0x3FFFFFFF & l) >> 0);
        if (((int)((0xC0000000 & l) >> 30) & this.mask) == (this.mask & i))
        {
          AppMethodBeat.o(192474);
          return null;
        }
        localObject2 = this.TVV.get(this.mask & i);
        if (localObject2 != null) {
          break;
        }
      } while (!this.TVW);
      AppMethodBeat.o(192474);
      return null;
      if ((localObject2 instanceof b))
      {
        AppMethodBeat.o(192474);
        return null;
      }
      j = i + 1 & 0x3FFFFFFF;
      if (TVU.compareAndSet(this, l, a.au(l, j)))
      {
        this.TVV.set(this.mask & i, null);
        AppMethodBeat.o(192474);
        return localObject2;
      }
    } while (!this.TVW);
    Object localObject1 = (m)this;
    m localm;
    do
    {
      localm = ((m)localObject1).nc(i, j);
      localObject1 = localm;
    } while (localm != null);
    AppMethodBeat.o(192474);
    return localObject2;
  }
  
  public final m<E> hNM()
  {
    AppMethodBeat.i(118082);
    m localm = Pm(hNN());
    AppMethodBeat.o(118082);
    return localm;
  }
  
  public final boolean isEmpty()
  {
    boolean bool = false;
    long l = this._state;
    if ((int)((0x3FFFFFFF & l) >> 0) == (int)((l & 0xC0000000) >> 30)) {
      bool = true;
    }
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"})
  public static final class a
  {
    public static int Po(long paramLong)
    {
      if ((0x0 & paramLong) != 0L) {
        return 2;
      }
      return 1;
    }
    
    public static long au(long paramLong, int paramInt)
    {
      return 0xC0000000 & paramLong | paramInt << 0;
    }
    
    public static long av(long paramLong, int paramInt)
    {
      return 0x3FFFFFFF & paramLong | paramInt << 30;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"})
  public static final class b
  {
    public final int index;
    
    public b(int paramInt)
    {
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.m
 * JD-Core Version:    0.7.0.1
 */