package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.am;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"})
public final class l<E>
{
  private static final AtomicReferenceFieldUpdater NJK;
  private static final AtomicLongFieldUpdater NJQ;
  public static final t NJT;
  public static final a NJU;
  private AtomicReferenceArray NJR;
  private final boolean NJS;
  private volatile Object _next;
  volatile long _state;
  private final int bwz;
  private final int mask;
  
  static
  {
    AppMethodBeat.i(118088);
    NJU = new a((byte)0);
    NJT = new t("REMOVE_FROZEN");
    NJK = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_next");
    NJQ = AtomicLongFieldUpdater.newUpdater(l.class, "_state");
    AppMethodBeat.o(118088);
  }
  
  public l(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(118086);
    this.bwz = paramInt;
    this.NJS = paramBoolean;
    this.mask = (this.bwz - 1);
    this._next = null;
    this._state = 0L;
    this.NJR = new AtomicReferenceArray(this.bwz);
    if (this.mask <= 1073741823) {}
    Throwable localThrowable;
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    if ((this.bwz & this.mask) == 0) {}
    for (paramInt = i; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    AppMethodBeat.o(118086);
  }
  
  private final l<E> FE(long paramLong)
  {
    AppMethodBeat.i(118084);
    for (;;)
    {
      l locall = (l)this._next;
      if (locall != null)
      {
        AppMethodBeat.o(118084);
        return locall;
      }
      NJK.compareAndSet(this, null, FF(paramLong));
    }
  }
  
  private final l<E> FF(long paramLong)
  {
    AppMethodBeat.i(118085);
    l locall = new l(this.bwz * 2, this.NJS);
    int i = (int)((0x3FFFFFFF & paramLong) >> 0);
    int j = (int)((0xC0000000 & paramLong) >> 30);
    while ((this.mask & i) != (this.mask & j))
    {
      Object localObject2 = this.NJR.get(this.mask & i);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new b(i);
      }
      locall.NJR.set(locall.mask & i, localObject1);
      i += 1;
    }
    locall._state = (0xFFFFFFFF & paramLong);
    AppMethodBeat.o(118085);
    return locall;
  }
  
  private final long gwe()
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
    } while (!NJQ.compareAndSet(this, l1, l2));
    AppMethodBeat.o(118083);
    return l2;
  }
  
  private final l<E> lu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190840);
    long l;
    int j;
    do
    {
      l = this._state;
      j = (int)((0x3FFFFFFF & l) >> 0);
      Object localObject;
      if (am.gvd())
      {
        if (j == paramInt1) {}
        for (int i = 1; i == 0; i = 0)
        {
          localObject = (Throwable)new AssertionError();
          AppMethodBeat.o(190840);
          throw ((Throwable)localObject);
        }
      }
      if ((0x0 & l) != 0L)
      {
        localObject = gwd();
        AppMethodBeat.o(190840);
        return localObject;
      }
    } while (!NJQ.compareAndSet(this, l, a.aq(l, paramInt2)));
    this.NJR.set(this.mask & j, null);
    AppMethodBeat.o(190840);
    return null;
  }
  
  private final l<E> s(int paramInt, E paramE)
  {
    AppMethodBeat.i(118081);
    Object localObject = this.NJR.get(this.mask & paramInt);
    if (((localObject instanceof b)) && (((b)localObject).index == paramInt))
    {
      this.NJR.set(this.mask & paramInt, paramE);
      AppMethodBeat.o(118081);
      return this;
    }
    AppMethodBeat.o(118081);
    return null;
  }
  
  public final boolean close()
  {
    AppMethodBeat.i(190838);
    long l;
    do
    {
      l = this._state;
      if ((l & 0x0) != 0L)
      {
        AppMethodBeat.o(190838);
        return true;
      }
      if ((0x0 & l) != 0L)
      {
        AppMethodBeat.o(190838);
        return false;
      }
    } while (!NJQ.compareAndSet(this, l, l | 0x0));
    AppMethodBeat.o(190838);
    return true;
  }
  
  public final int fZ(E paramE)
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
          i = a.FG(l);
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
        if ((this.NJS) || (this.NJR.get(j & k) == null)) {
          break;
        }
      } while ((this.bwz >= 1024) && ((j - i & 0x3FFFFFFF) <= this.bwz >> 1));
      AppMethodBeat.o(118080);
      return 1;
    } while (!NJQ.compareAndSet(this, l, a.ar(l, j + 1 & 0x3FFFFFFF)));
    this.NJR.set(j & k, paramE);
    Object localObject = (l)this;
    l locall;
    do
    {
      if ((((l)localObject)._state & 0x0) == 0L) {
        break;
      }
      locall = ((l)localObject).gwd().s(j, paramE);
      localObject = locall;
    } while (locall != null);
    AppMethodBeat.o(118080);
    return 0;
  }
  
  public final Object gvT()
  {
    AppMethodBeat.i(190839);
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
          localObject1 = NJT;
          AppMethodBeat.o(190839);
          return localObject1;
        }
        i = (int)((0x3FFFFFFF & l) >> 0);
        if (((int)((0xC0000000 & l) >> 30) & this.mask) == (this.mask & i))
        {
          AppMethodBeat.o(190839);
          return null;
        }
        localObject2 = this.NJR.get(this.mask & i);
        if (localObject2 != null) {
          break;
        }
      } while (!this.NJS);
      AppMethodBeat.o(190839);
      return null;
      if ((localObject2 instanceof b))
      {
        AppMethodBeat.o(190839);
        return null;
      }
      j = i + 1 & 0x3FFFFFFF;
      if (NJQ.compareAndSet(this, l, a.aq(l, j)))
      {
        this.NJR.set(this.mask & i, null);
        AppMethodBeat.o(190839);
        return localObject2;
      }
    } while (!this.NJS);
    Object localObject1 = (l)this;
    l locall;
    do
    {
      locall = ((l)localObject1).lu(i, j);
      localObject1 = locall;
    } while (locall != null);
    AppMethodBeat.o(190839);
    return localObject2;
  }
  
  public final l<E> gwd()
  {
    AppMethodBeat.i(118082);
    l locall = FE(gwe());
    AppMethodBeat.o(118082);
    return locall;
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"})
  public static final class a
  {
    public static int FG(long paramLong)
    {
      if ((0x0 & paramLong) != 0L) {
        return 2;
      }
      return 1;
    }
    
    public static long aq(long paramLong, int paramInt)
    {
      return 0xC0000000 & paramLong | paramInt << 0;
    }
    
    public static long ar(long paramLong, int paramInt)
    {
      return 0x3FFFFFFF & paramLong | paramInt << 30;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"})
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
 * Qualified Name:     kotlinx.coroutines.internal.l
 * JD-Core Version:    0.7.0.1
 */