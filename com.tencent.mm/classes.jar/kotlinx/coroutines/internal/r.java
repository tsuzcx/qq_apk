package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.au;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class r<E>
{
  public static final a ajAC;
  public static final ac ajAG;
  private final boolean ajAD;
  private final int cZV;
  private final int mask;
  
  static
  {
    AppMethodBeat.i(118088);
    ajAC = new a((byte)0);
    ajAG = new ac("REMOVE_FROZEN");
    ajAk = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "_next");
    ajAE = AtomicLongFieldUpdater.newUpdater(r.class, "_state");
    AppMethodBeat.o(118088);
  }
  
  public r(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(118086);
    this.cZV = paramInt;
    this.ajAD = paramBoolean;
    this.mask = (this.cZV - 1);
    this._next = null;
    this._state = 0L;
    this.ajAF = new AtomicReferenceArray(this.cZV);
    if (this.mask <= 1073741823) {}
    Throwable localThrowable;
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    if ((this.cZV & this.mask) == 0) {}
    for (paramInt = i; paramInt == 0; paramInt = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118086);
      throw localThrowable;
    }
    AppMethodBeat.o(118086);
  }
  
  private final r<E> BO(long paramLong)
  {
    AppMethodBeat.i(118084);
    for (;;)
    {
      r localr = (r)this._next;
      if (localr != null)
      {
        AppMethodBeat.o(118084);
        return localr;
      }
      ajAk.compareAndSet(this, null, BP(paramLong));
    }
  }
  
  private final r<E> BP(long paramLong)
  {
    AppMethodBeat.i(118085);
    r localr = new r(this.cZV * 2, this.ajAD);
    int i = (int)((0x3FFFFFFF & paramLong) >> 0);
    int j = (int)((0xC0000000 & paramLong) >> 30);
    while ((this.mask & i) != (this.mask & j))
    {
      Object localObject2 = this.ajAF.get(this.mask & i);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new b(i);
      }
      localr.ajAF.set(localr.mask & i, localObject1);
      i += 1;
    }
    localr._state = (0xFFFFFFFF & paramLong);
    AppMethodBeat.o(118085);
    return localr;
  }
  
  private final r<E> X(int paramInt, E paramE)
  {
    AppMethodBeat.i(118081);
    Object localObject = this.ajAF.get(this.mask & paramInt);
    if (((localObject instanceof b)) && (((b)localObject).index == paramInt))
    {
      this.ajAF.set(this.mask & paramInt, paramE);
      AppMethodBeat.o(118081);
      return this;
    }
    AppMethodBeat.o(118081);
    return null;
  }
  
  private final long kEi()
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
    } while (!ajAE.compareAndSet(this, l1, l2));
    AppMethodBeat.o(118083);
    return l2;
  }
  
  private final r<E> qx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189419);
    long l;
    int j;
    do
    {
      l = this._state;
      j = (int)((0x3FFFFFFF & l) >> 0);
      Object localObject;
      if (au.ASSERTIONS_ENABLED)
      {
        if (j == paramInt1) {}
        for (int i = 1; i == 0; i = 0)
        {
          localObject = new AssertionError();
          AppMethodBeat.o(189419);
          throw ((Throwable)localObject);
        }
      }
      if ((0x0 & l) != 0L)
      {
        localObject = kEh();
        AppMethodBeat.o(189419);
        return localObject;
      }
    } while (!ajAE.compareAndSet(this, l, a.aU(l, paramInt2)));
    this.ajAF.set(this.mask & j, null);
    AppMethodBeat.o(189419);
    return null;
  }
  
  public final boolean close()
  {
    AppMethodBeat.i(189457);
    long l;
    do
    {
      l = this._state;
      if ((l & 0x0) != 0L)
      {
        AppMethodBeat.o(189457);
        return true;
      }
      if ((0x0 & l) != 0L)
      {
        AppMethodBeat.o(189457);
        return false;
      }
    } while (!ajAE.compareAndSet(this, l, l | 0x0));
    AppMethodBeat.o(189457);
    return true;
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
  
  public final int jm(E paramE)
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
          i = a.BQ(l);
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
        if ((this.ajAD) || (this.ajAF.get(j & k) == null)) {
          break;
        }
      } while ((this.cZV >= 1024) && ((j - i & 0x3FFFFFFF) <= this.cZV >> 1));
      AppMethodBeat.o(118080);
      return 1;
    } while (!ajAE.compareAndSet(this, l, a.aV(l, j + 1 & 0x3FFFFFFF)));
    this.ajAF.set(j & k, paramE);
    Object localObject = this;
    r localr;
    do
    {
      if ((((r)localObject)._state & 0x0) == 0L) {
        break;
      }
      localr = ((r)localObject).kEh().X(j, paramE);
      localObject = localr;
    } while (localr != null);
    AppMethodBeat.o(118080);
    return 0;
  }
  
  public final r<E> kEh()
  {
    AppMethodBeat.i(118082);
    r localr = BO(kEi());
    AppMethodBeat.o(118082);
    return localr;
  }
  
  public final Object kkV()
  {
    AppMethodBeat.i(189463);
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
          localObject1 = ajAG;
          AppMethodBeat.o(189463);
          return localObject1;
        }
        i = (int)((0x3FFFFFFF & l) >> 0);
        if (((int)((0xC0000000 & l) >> 30) & this.mask) == (this.mask & i))
        {
          AppMethodBeat.o(189463);
          return null;
        }
        localObject2 = this.ajAF.get(this.mask & i);
        if (localObject2 != null) {
          break;
        }
      } while (!this.ajAD);
      AppMethodBeat.o(189463);
      return null;
      if ((localObject2 instanceof b))
      {
        AppMethodBeat.o(189463);
        return null;
      }
      j = i + 1 & 0x3FFFFFFF;
      if (ajAE.compareAndSet(this, l, a.aU(l, j)))
      {
        this.ajAF.set(this.mask & i, null);
        AppMethodBeat.o(189463);
        return localObject2;
      }
    } while (!this.ajAD);
    Object localObject1 = this;
    r localr;
    do
    {
      localr = ((r)localObject1).qx(i, j);
      localObject1 = localr;
    } while (localr != null);
    AppMethodBeat.o(189463);
    return localObject2;
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int BQ(long paramLong)
    {
      if ((0x0 & paramLong) != 0L) {
        return 2;
      }
      return 1;
    }
    
    public static long aU(long paramLong, int paramInt)
    {
      return 0xC0000000 & paramLong | paramInt << 0;
    }
    
    public static long aV(long paramLong, int paramInt)
    {
      return 0x3FFFFFFF & paramLong | paramInt << 30;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
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
 * Qualified Name:     kotlinx.coroutines.internal.r
 * JD-Core Version:    0.7.0.1
 */