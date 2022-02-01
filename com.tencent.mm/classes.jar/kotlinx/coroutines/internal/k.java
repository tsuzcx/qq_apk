package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.al;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"})
public final class k<E>
{
  private static final AtomicReferenceFieldUpdater LSN;
  private static final AtomicLongFieldUpdater LST;
  public static final s LSW;
  public static final a LSX;
  private AtomicReferenceArray LSU;
  private final boolean LSV;
  private volatile Object _next;
  volatile long _state;
  private final int bme;
  private final int mask;
  
  static
  {
    AppMethodBeat.i(118088);
    LSX = new a((byte)0);
    LSW = new s("REMOVE_FROZEN");
    LSN = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");
    LST = AtomicLongFieldUpdater.newUpdater(k.class, "_state");
    AppMethodBeat.o(118088);
  }
  
  public k(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(118086);
    this.bme = paramInt;
    this.LSV = paramBoolean;
    this.mask = (this.bme - 1);
    this._next = null;
    this._state = 0L;
    this.LSU = new AtomicReferenceArray(this.bme);
    if (this.mask <= 1073741823) {}
    Throwable localThrowable;
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    if ((this.bme & this.mask) == 0) {}
    for (paramInt = i; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    AppMethodBeat.o(118086);
  }
  
  private final k<E> CA(long paramLong)
  {
    AppMethodBeat.i(118085);
    k localk = new k(this.bme * 2, this.LSV);
    int i = (int)((0x3FFFFFFF & paramLong) >> 0);
    int j = (int)((0xC0000000 & paramLong) >> 30);
    while ((this.mask & i) != (this.mask & j))
    {
      Object localObject2 = this.LSU.get(this.mask & i);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new b(i);
      }
      localk.LSU.set(localk.mask & i, localObject1);
      i += 1;
    }
    localk._state = (0xFFFFFFFF & paramLong);
    AppMethodBeat.o(118085);
    return localk;
  }
  
  private final k<E> Cz(long paramLong)
  {
    AppMethodBeat.i(118084);
    for (;;)
    {
      k localk = (k)this._next;
      if (localk != null)
      {
        AppMethodBeat.o(118084);
        return localk;
      }
      LSN.compareAndSet(this, null, CA(paramLong));
    }
  }
  
  private final long geF()
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
    } while (!LST.compareAndSet(this, l1, l2));
    AppMethodBeat.o(118083);
    return l2;
  }
  
  private final k<E> lf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191229);
    long l;
    int j;
    do
    {
      l = this._state;
      j = (int)((0x3FFFFFFF & l) >> 0);
      Object localObject;
      if (al.gdD())
      {
        if (j == paramInt1) {}
        for (int i = 1; i == 0; i = 0)
        {
          localObject = (Throwable)new AssertionError();
          AppMethodBeat.o(191229);
          throw ((Throwable)localObject);
        }
      }
      if ((0x0 & l) != 0L)
      {
        localObject = geE();
        AppMethodBeat.o(191229);
        return localObject;
      }
    } while (!LST.compareAndSet(this, l, a.al(l, paramInt2)));
    this.LSU.set(this.mask & j, null);
    AppMethodBeat.o(191229);
    return null;
  }
  
  private final k<E> t(int paramInt, E paramE)
  {
    AppMethodBeat.i(118081);
    Object localObject = this.LSU.get(this.mask & paramInt);
    if (((localObject instanceof b)) && (((b)localObject).index == paramInt))
    {
      this.LSU.set(this.mask & paramInt, paramE);
      AppMethodBeat.o(118081);
      return this;
    }
    AppMethodBeat.o(118081);
    return null;
  }
  
  public final boolean close()
  {
    AppMethodBeat.i(191227);
    long l;
    do
    {
      l = this._state;
      if ((l & 0x0) != 0L)
      {
        AppMethodBeat.o(191227);
        return true;
      }
      if ((0x0 & l) != 0L)
      {
        AppMethodBeat.o(191227);
        return false;
      }
    } while (!LST.compareAndSet(this, l, l | 0x0));
    AppMethodBeat.o(191227);
    return true;
  }
  
  public final int fW(E paramE)
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
          i = a.CB(l);
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
        if ((this.LSV) || (this.LSU.get(j & k) == null)) {
          break;
        }
      } while ((this.bme >= 1024) && ((j - i & 0x3FFFFFFF) <= this.bme >> 1));
      AppMethodBeat.o(118080);
      return 1;
    } while (!LST.compareAndSet(this, l, a.am(l, j + 1 & 0x3FFFFFFF)));
    this.LSU.set(j & k, paramE);
    Object localObject = (k)this;
    k localk;
    do
    {
      if ((((k)localObject)._state & 0x0) == 0L) {
        break;
      }
      localk = ((k)localObject).geE().t(j, paramE);
      localObject = localk;
    } while (localk != null);
    AppMethodBeat.o(118080);
    return 0;
  }
  
  public final k<E> geE()
  {
    AppMethodBeat.i(118082);
    k localk = Cz(geF());
    AppMethodBeat.o(118082);
    return localk;
  }
  
  public final Object geu()
  {
    AppMethodBeat.i(191228);
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
          localObject1 = LSW;
          AppMethodBeat.o(191228);
          return localObject1;
        }
        i = (int)((0x3FFFFFFF & l) >> 0);
        if (((int)((0xC0000000 & l) >> 30) & this.mask) == (this.mask & i))
        {
          AppMethodBeat.o(191228);
          return null;
        }
        localObject2 = this.LSU.get(this.mask & i);
        if (localObject2 != null) {
          break;
        }
      } while (!this.LSV);
      AppMethodBeat.o(191228);
      return null;
      if ((localObject2 instanceof b))
      {
        AppMethodBeat.o(191228);
        return null;
      }
      j = i + 1 & 0x3FFFFFFF;
      if (LST.compareAndSet(this, l, a.al(l, j)))
      {
        this.LSU.set(this.mask & i, null);
        AppMethodBeat.o(191228);
        return localObject2;
      }
    } while (!this.LSV);
    Object localObject1 = (k)this;
    k localk;
    do
    {
      localk = ((k)localObject1).lf(i, j);
      localObject1 = localk;
    } while (localk != null);
    AppMethodBeat.o(191228);
    return localObject2;
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"})
  public static final class a
  {
    public static int CB(long paramLong)
    {
      if ((0x0 & paramLong) != 0L) {
        return 2;
      }
      return 1;
    }
    
    public static long al(long paramLong, int paramInt)
    {
      return 0xC0000000 & paramLong | paramInt << 0;
    }
    
    public static long am(long paramLong, int paramInt)
    {
      return 0x3FFFFFFF & paramLong | paramInt << 30;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"})
  public static final class b
  {
    public final int index;
    
    public b(int paramInt)
    {
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.k
 * JD-Core Version:    0.7.0.1
 */