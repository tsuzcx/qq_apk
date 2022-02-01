package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.l;
import kotlinx.coroutines.ap;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"})
public final class n<E>
{
  private static final AtomicReferenceFieldUpdater abzf;
  private static final AtomicLongFieldUpdater abzl;
  public static final v abzo;
  public static final a abzp;
  private volatile Object _next;
  volatile long _state;
  private AtomicReferenceArray abzm;
  private final boolean abzn;
  private final int bgc;
  private final int mask;
  
  static
  {
    AppMethodBeat.i(118088);
    abzp = new a((byte)0);
    abzo = new v("REMOVE_FROZEN");
    abzf = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_next");
    abzl = AtomicLongFieldUpdater.newUpdater(n.class, "_state");
    AppMethodBeat.o(118088);
  }
  
  public n(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(118086);
    this.bgc = paramInt;
    this.abzn = paramBoolean;
    this.mask = (this.bgc - 1);
    this._next = null;
    this._state = 0L;
    this.abzm = new AtomicReferenceArray(this.bgc);
    if (this.mask <= 1073741823) {}
    Throwable localThrowable;
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    if ((this.bgc & this.mask) == 0) {}
    for (paramInt = i; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    AppMethodBeat.o(118086);
  }
  
  private final n<E> C(int paramInt, E paramE)
  {
    AppMethodBeat.i(118081);
    Object localObject = this.abzm.get(this.mask & paramInt);
    if (((localObject instanceof b)) && (((b)localObject).index == paramInt))
    {
      this.abzm.set(this.mask & paramInt, paramE);
      AppMethodBeat.o(118081);
      return this;
    }
    AppMethodBeat.o(118081);
    return null;
  }
  
  private final n<E> XC(long paramLong)
  {
    AppMethodBeat.i(118084);
    for (;;)
    {
      n localn = (n)this._next;
      if (localn != null)
      {
        AppMethodBeat.o(118084);
        return localn;
      }
      abzf.compareAndSet(this, null, XD(paramLong));
    }
  }
  
  private final n<E> XD(long paramLong)
  {
    AppMethodBeat.i(118085);
    n localn = new n(this.bgc * 2, this.abzn);
    int i = (int)((0x3FFFFFFF & paramLong) >> 0);
    int j = (int)((0xC0000000 & paramLong) >> 30);
    while ((this.mask & i) != (this.mask & j))
    {
      Object localObject2 = this.abzm.get(this.mask & i);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new b(i);
      }
      localn.abzm.set(localn.mask & i, localObject1);
      i += 1;
    }
    localn._state = (0xFFFFFFFF & paramLong);
    AppMethodBeat.o(118085);
    return localn;
  }
  
  private final long iST()
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
    } while (!abzl.compareAndSet(this, l1, l2));
    AppMethodBeat.o(118083);
    return l2;
  }
  
  private final n<E> oy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205034);
    long l;
    int j;
    do
    {
      l = this._state;
      j = (int)((0x3FFFFFFF & l) >> 0);
      Object localObject;
      if (ap.iRg())
      {
        if (j == paramInt1) {}
        for (int i = 1; i == 0; i = 0)
        {
          localObject = (Throwable)new AssertionError();
          AppMethodBeat.o(205034);
          throw ((Throwable)localObject);
        }
      }
      if ((0x0 & l) != 0L)
      {
        localObject = iSS();
        AppMethodBeat.o(205034);
        return localObject;
      }
    } while (!abzl.compareAndSet(this, l, a.aD(l, paramInt2)));
    this.abzm.set(this.mask & j, null);
    AppMethodBeat.o(205034);
    return null;
  }
  
  public final boolean close()
  {
    AppMethodBeat.i(205030);
    long l;
    do
    {
      l = this._state;
      if ((l & 0x0) != 0L)
      {
        AppMethodBeat.o(205030);
        return true;
      }
      if ((0x0 & l) != 0L)
      {
        AppMethodBeat.o(205030);
        return false;
      }
    } while (!abzl.compareAndSet(this, l, l | 0x0));
    AppMethodBeat.o(205030);
    return true;
  }
  
  public final int gz(E paramE)
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
          i = a.XE(l);
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
        if ((this.abzn) || (this.abzm.get(j & k) == null)) {
          break;
        }
      } while ((this.bgc >= 1024) && ((j - i & 0x3FFFFFFF) <= this.bgc >> 1));
      AppMethodBeat.o(118080);
      return 1;
    } while (!abzl.compareAndSet(this, l, a.aE(l, j + 1 & 0x3FFFFFFF)));
    this.abzm.set(j & k, paramE);
    Object localObject = (n)this;
    n localn;
    do
    {
      if ((((n)localObject)._state & 0x0) == 0L) {
        break;
      }
      localn = ((n)localObject).iSS().C(j, paramE);
      localObject = localn;
    } while (localn != null);
    AppMethodBeat.o(118080);
    return 0;
  }
  
  public final Object iSD()
  {
    AppMethodBeat.i(205032);
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
          localObject1 = abzo;
          AppMethodBeat.o(205032);
          return localObject1;
        }
        i = (int)((0x3FFFFFFF & l) >> 0);
        if (((int)((0xC0000000 & l) >> 30) & this.mask) == (this.mask & i))
        {
          AppMethodBeat.o(205032);
          return null;
        }
        localObject2 = this.abzm.get(this.mask & i);
        if (localObject2 != null) {
          break;
        }
      } while (!this.abzn);
      AppMethodBeat.o(205032);
      return null;
      if ((localObject2 instanceof b))
      {
        AppMethodBeat.o(205032);
        return null;
      }
      j = i + 1 & 0x3FFFFFFF;
      if (abzl.compareAndSet(this, l, a.aD(l, j)))
      {
        this.abzm.set(this.mask & i, null);
        AppMethodBeat.o(205032);
        return localObject2;
      }
    } while (!this.abzn);
    Object localObject1 = (n)this;
    n localn;
    do
    {
      localn = ((n)localObject1).oy(i, j);
      localObject1 = localn;
    } while (localn != null);
    AppMethodBeat.o(205032);
    return localObject2;
  }
  
  public final n<E> iSS()
  {
    AppMethodBeat.i(118082);
    n localn = XC(iST());
    AppMethodBeat.o(118082);
    return localn;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"})
  public static final class a
  {
    public static int XE(long paramLong)
    {
      if ((0x0 & paramLong) != 0L) {
        return 2;
      }
      return 1;
    }
    
    public static long aD(long paramLong, int paramInt)
    {
      return 0xC0000000 & paramLong | paramInt << 0;
    }
    
    public static long aE(long paramLong, int paramInt)
    {
      return 0x3FFFFFFF & paramLong | paramInt << 30;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"})
  public static final class b
  {
    public final int index;
    
    public b(int paramInt)
    {
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.n
 * JD-Core Version:    0.7.0.1
 */