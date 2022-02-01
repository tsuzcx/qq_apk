package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ah;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"})
public final class i<E>
{
  private static final AtomicReferenceFieldUpdater Kfl;
  private static final AtomicLongFieldUpdater Kfr;
  public static final m Kfu;
  public static final a Kfv;
  private AtomicReferenceArray Kfs;
  private final boolean Kft;
  private volatile Object _next;
  volatile long _state;
  private final int blz;
  private final int mask;
  
  static
  {
    AppMethodBeat.i(118088);
    Kfv = new a((byte)0);
    Kfu = new m("REMOVE_FROZEN");
    Kfl = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_next");
    Kfr = AtomicLongFieldUpdater.newUpdater(i.class, "_state");
    AppMethodBeat.o(118088);
  }
  
  public i(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(118086);
    this.blz = paramInt;
    this.Kft = paramBoolean;
    this.mask = (this.blz - 1);
    this._next = null;
    this._state = 0L;
    this.Kfs = new AtomicReferenceArray(this.blz);
    if (this.mask <= 1073741823) {}
    Throwable localThrowable;
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    if ((this.blz & this.mask) == 0) {}
    for (paramInt = i; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    AppMethodBeat.o(118086);
  }
  
  private final long fLS()
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
    } while (!Kfr.compareAndSet(this, l1, l2));
    AppMethodBeat.o(118083);
    return l2;
  }
  
  private final i<E> kP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190081);
    long l;
    int j;
    do
    {
      l = this._state;
      j = (int)((0x3FFFFFFF & l) >> 0);
      Object localObject;
      if (ah.fKW())
      {
        if (j == paramInt1) {}
        for (int i = 1; i == 0; i = 0)
        {
          localObject = (Throwable)new AssertionError();
          AppMethodBeat.o(190081);
          throw ((Throwable)localObject);
        }
      }
      if ((0x0 & l) != 0L)
      {
        localObject = fLR();
        AppMethodBeat.o(190081);
        return localObject;
      }
    } while (!Kfr.compareAndSet(this, l, a.ai(l, paramInt2)));
    this.Kfs.set(this.mask & j, null);
    AppMethodBeat.o(190081);
    return null;
  }
  
  private final i<E> t(int paramInt, E paramE)
  {
    AppMethodBeat.i(118081);
    Object localObject = this.Kfs.get(this.mask & paramInt);
    if (((localObject instanceof b)) && (((b)localObject).index == paramInt))
    {
      this.Kfs.set(this.mask & paramInt, paramE);
      AppMethodBeat.o(118081);
      return this;
    }
    AppMethodBeat.o(118081);
    return null;
  }
  
  private final i<E> xM(long paramLong)
  {
    AppMethodBeat.i(118084);
    for (;;)
    {
      i locali = (i)this._next;
      if (locali != null)
      {
        AppMethodBeat.o(118084);
        return locali;
      }
      Kfl.compareAndSet(this, null, xN(paramLong));
    }
  }
  
  private final i<E> xN(long paramLong)
  {
    AppMethodBeat.i(118085);
    i locali = new i(this.blz * 2, this.Kft);
    int i = (int)((0x3FFFFFFF & paramLong) >> 0);
    int j = (int)((0xC0000000 & paramLong) >> 30);
    while ((this.mask & i) != (this.mask & j))
    {
      Object localObject2 = this.Kfs.get(this.mask & i);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new b(i);
      }
      locali.Kfs.set(locali.mask & i, localObject1);
      i += 1;
    }
    locali._state = (0xFFFFFFFF & paramLong);
    AppMethodBeat.o(118085);
    return locali;
  }
  
  public final Object fLJ()
  {
    AppMethodBeat.i(190080);
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
          localObject1 = Kfu;
          AppMethodBeat.o(190080);
          return localObject1;
        }
        i = (int)((0x3FFFFFFF & l) >> 0);
        if (((int)((0xC0000000 & l) >> 30) & this.mask) == (this.mask & i))
        {
          AppMethodBeat.o(190080);
          return null;
        }
        localObject2 = this.Kfs.get(this.mask & i);
        if (localObject2 != null) {
          break;
        }
      } while (!this.Kft);
      AppMethodBeat.o(190080);
      return null;
      if ((localObject2 instanceof b))
      {
        AppMethodBeat.o(190080);
        return null;
      }
      j = i + 1 & 0x3FFFFFFF;
      if (Kfr.compareAndSet(this, l, a.ai(l, j)))
      {
        this.Kfs.set(this.mask & i, null);
        AppMethodBeat.o(190080);
        return localObject2;
      }
    } while (!this.Kft);
    Object localObject1 = (i)this;
    i locali;
    do
    {
      locali = ((i)localObject1).kP(i, j);
      localObject1 = locali;
    } while (locali != null);
    AppMethodBeat.o(190080);
    return localObject2;
  }
  
  public final i<E> fLR()
  {
    AppMethodBeat.i(118082);
    i locali = xM(fLS());
    AppMethodBeat.o(118082);
    return locali;
  }
  
  public final int fO(E paramE)
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
          i = a.xO(l);
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
        if ((this.Kft) || (this.Kfs.get(j & k) == null)) {
          break;
        }
      } while ((this.blz >= 1024) && ((j - i & 0x3FFFFFFF) <= this.blz >> 1));
      AppMethodBeat.o(118080);
      return 1;
    } while (!Kfr.compareAndSet(this, l, a.aj(l, j + 1 & 0x3FFFFFFF)));
    this.Kfs.set(j & k, paramE);
    Object localObject = (i)this;
    i locali;
    do
    {
      if ((((i)localObject)._state & 0x0) == 0L) {
        break;
      }
      locali = ((i)localObject).fLR().t(j, paramE);
      localObject = locali;
    } while (locali != null);
    AppMethodBeat.o(118080);
    return 0;
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
  
  public final boolean vE()
  {
    AppMethodBeat.i(190079);
    long l;
    do
    {
      l = this._state;
      if ((l & 0x0) != 0L)
      {
        AppMethodBeat.o(190079);
        return true;
      }
      if ((0x0 & l) != 0L)
      {
        AppMethodBeat.o(190079);
        return false;
      }
    } while (!Kfr.compareAndSet(this, l, l | 0x0));
    AppMethodBeat.o(190079);
    return true;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"})
  public static final class a
  {
    public static long ai(long paramLong, int paramInt)
    {
      return 0xC0000000 & paramLong | paramInt << 0;
    }
    
    public static long aj(long paramLong, int paramInt)
    {
      return 0x3FFFFFFF & paramLong | paramInt << 30;
    }
    
    public static int xO(long paramLong)
    {
      if ((0x0 & paramLong) != 0L) {
        return 2;
      }
      return 1;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"})
  public static final class b
  {
    public final int index;
    
    public b(int paramInt)
    {
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.i
 * JD-Core Version:    0.7.0.1
 */