package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.au;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"}, k=1, mv={1, 5, 1}, xi=48)
public class ah<T extends ai,  extends Comparable<? super T>>
{
  public T[] ajBa;
  
  private final void aMG(int paramInt)
  {
    AppMethodBeat.i(118069);
    for (int i = paramInt;; i = paramInt)
    {
      int j = i * 2 + 1;
      if (j >= this._size)
      {
        AppMethodBeat.o(118069);
        return;
      }
      Object localObject1 = this.ajBa;
      s.checkNotNull(localObject1);
      paramInt = j;
      if (j + 1 < this._size)
      {
        localObject2 = localObject1[(j + 1)];
        s.checkNotNull(localObject2);
        localObject2 = (Comparable)localObject2;
        Object localObject3 = localObject1[j];
        s.checkNotNull(localObject3);
        paramInt = j;
        if (((Comparable)localObject2).compareTo(localObject3) < 0) {
          paramInt = j + 1;
        }
      }
      Object localObject2 = localObject1[i];
      s.checkNotNull(localObject2);
      localObject2 = (Comparable)localObject2;
      localObject1 = localObject1[paramInt];
      s.checkNotNull(localObject1);
      if (((Comparable)localObject2).compareTo(localObject1) <= 0)
      {
        AppMethodBeat.o(118069);
        return;
      }
      qy(i, paramInt);
    }
  }
  
  private final void qy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118070);
    ai[] arrayOfai = this.ajBa;
    s.checkNotNull(arrayOfai);
    ai localai1 = arrayOfai[paramInt2];
    s.checkNotNull(localai1);
    ai localai2 = arrayOfai[paramInt1];
    s.checkNotNull(localai2);
    arrayOfai[paramInt1] = localai1;
    arrayOfai[paramInt2] = localai2;
    localai1.setIndex(paramInt1);
    localai2.setIndex(paramInt2);
    AppMethodBeat.o(118070);
  }
  
  public final boolean a(T paramT)
  {
    int i = 0;
    boolean bool = false;
    AppMethodBeat.i(118066);
    for (;;)
    {
      int j;
      try
      {
        ah localah = paramT.kCr();
        if (localah == null) {
          return bool;
        }
        j = paramT.getIndex();
        if (au.ASSERTIONS_ENABLED)
        {
          if (j >= 0) {
            i = 1;
          }
          if (i == 0)
          {
            paramT = new AssertionError();
            AppMethodBeat.o(118066);
            throw paramT;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(118066);
      }
      aME(j);
      bool = true;
    }
  }
  
  public final T aME(int paramInt)
  {
    AppMethodBeat.i(118067);
    int i;
    if (au.ASSERTIONS_ENABLED)
    {
      if (this._size > 0) {}
      for (i = 1; i == 0; i = 0)
      {
        localObject1 = new AssertionError();
        AppMethodBeat.o(118067);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject1 = this.ajBa;
    s.checkNotNull(localObject1);
    this._size -= 1;
    Object localObject2;
    if (paramInt < this._size)
    {
      qy(paramInt, this._size);
      i = (paramInt - 1) / 2;
      if (paramInt > 0)
      {
        localObject2 = localObject1[paramInt];
        s.checkNotNull(localObject2);
        localObject2 = (Comparable)localObject2;
        Object localObject3 = localObject1[i];
        s.checkNotNull(localObject3);
        if (((Comparable)localObject2).compareTo(localObject3) < 0)
        {
          qy(paramInt, i);
          aMF(i);
        }
      }
    }
    else
    {
      localObject2 = localObject1[this._size];
      s.checkNotNull(localObject2);
      if (!au.ASSERTIONS_ENABLED) {
        break label204;
      }
      if (((ai)localObject2).kCr() != this) {
        break label199;
      }
    }
    label199:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label204;
      }
      localObject1 = new AssertionError();
      AppMethodBeat.o(118067);
      throw ((Throwable)localObject1);
      aMG(paramInt);
      break;
    }
    label204:
    ((ai)localObject2).a(null);
    ((ai)localObject2).setIndex(-1);
    localObject1[this._size] = null;
    AppMethodBeat.o(118067);
    return localObject2;
  }
  
  public final void aMF(int paramInt)
  {
    AppMethodBeat.i(118068);
    for (;;)
    {
      if (paramInt <= 0)
      {
        AppMethodBeat.o(118068);
        return;
      }
      Object localObject1 = this.ajBa;
      s.checkNotNull(localObject1);
      int i = (paramInt - 1) / 2;
      Object localObject2 = localObject1[i];
      s.checkNotNull(localObject2);
      localObject2 = (Comparable)localObject2;
      localObject1 = localObject1[paramInt];
      s.checkNotNull(localObject1);
      if (((Comparable)localObject2).compareTo(localObject1) <= 0)
      {
        AppMethodBeat.o(118068);
        return;
      }
      qy(paramInt, i);
      paramInt = i;
    }
  }
  
  public final boolean isEmpty()
  {
    return this._size == 0;
  }
  
  public final T kEq()
  {
    AppMethodBeat.i(118065);
    try
    {
      ai localai = kEs();
      return localai;
    }
    finally
    {
      AppMethodBeat.o(118065);
    }
  }
  
  /* Error */
  public final T kEr()
  {
    // Byte code:
    //   0: ldc 148
    //   2: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 71	kotlinx/coroutines/internal/ah:_size	I
    //   11: ifle +18 -> 29
    //   14: aload_0
    //   15: iconst_0
    //   16: invokevirtual 126	kotlinx/coroutines/internal/ah:aME	(I)Lkotlinx/coroutines/internal/ai;
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: ldc 148
    //   24: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: areturn
    //   29: aconst_null
    //   30: astore_1
    //   31: goto -11 -> 20
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: ldc 148
    //   39: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ah
    //   19	12	1	localai	ai
    //   34	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	34	finally
  }
  
  public final T kEs()
  {
    ai[] arrayOfai = this.ajBa;
    if (arrayOfai == null) {
      return null;
    }
    return arrayOfai[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.ah
 * JD-Core Version:    0.7.0.1
 */