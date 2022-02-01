package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.ap;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"})
public class aa<T extends ab,  extends Comparable<? super T>>
{
  public volatile int _size = 0;
  public T[] abzJ;
  
  private final void aFT(int paramInt)
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
      Object localObject1 = this.abzJ;
      if (localObject1 == null) {
        p.iCn();
      }
      paramInt = j;
      if (j + 1 < this._size)
      {
        localComparable = localObject1[(j + 1)];
        if (localComparable == null) {
          p.iCn();
        }
        localComparable = (Comparable)localComparable;
        Object localObject2 = localObject1[j];
        if (localObject2 == null) {
          p.iCn();
        }
        paramInt = j;
        if (localComparable.compareTo(localObject2) < 0) {
          paramInt = j + 1;
        }
      }
      Comparable localComparable = localObject1[i];
      if (localComparable == null) {
        p.iCn();
      }
      localComparable = (Comparable)localComparable;
      localObject1 = localObject1[paramInt];
      if (localObject1 == null) {
        p.iCn();
      }
      if (localComparable.compareTo(localObject1) <= 0)
      {
        AppMethodBeat.o(118069);
        return;
      }
      oz(i, paramInt);
    }
  }
  
  private final void oz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118070);
    ab[] arrayOfab = this.abzJ;
    if (arrayOfab == null) {
      p.iCn();
    }
    ab localab1 = arrayOfab[paramInt2];
    if (localab1 == null) {
      p.iCn();
    }
    ab localab2 = arrayOfab[paramInt1];
    if (localab2 == null) {
      p.iCn();
    }
    arrayOfab[paramInt1] = localab1;
    arrayOfab[paramInt2] = localab2;
    localab1.setIndex(paramInt1);
    localab2.setIndex(paramInt2);
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
        aa localaa = paramT.iRA();
        if (localaa == null) {
          return bool;
        }
        j = paramT.getIndex();
        if (ap.iRg())
        {
          if (j >= 0) {
            i = 1;
          }
          if (i == 0)
          {
            paramT = (Throwable)new AssertionError();
            AppMethodBeat.o(118066);
            throw paramT;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(118066);
      }
      aFR(j);
      bool = true;
    }
  }
  
  public final T aFR(int paramInt)
  {
    AppMethodBeat.i(118067);
    int i;
    if (ap.iRg())
    {
      if (this._size > 0) {}
      for (i = 1; i == 0; i = 0)
      {
        localObject1 = (Throwable)new AssertionError();
        AppMethodBeat.o(118067);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject1 = this.abzJ;
    if (localObject1 == null) {
      p.iCn();
    }
    this._size -= 1;
    Comparable localComparable;
    if (paramInt < this._size)
    {
      oz(paramInt, this._size);
      i = (paramInt - 1) / 2;
      if (paramInt > 0)
      {
        localComparable = localObject1[paramInt];
        if (localComparable == null) {
          p.iCn();
        }
        localComparable = (Comparable)localComparable;
        Object localObject2 = localObject1[i];
        if (localObject2 == null) {
          p.iCn();
        }
        if (localComparable.compareTo(localObject2) < 0)
        {
          oz(paramInt, i);
          aFS(i);
        }
      }
    }
    else
    {
      localComparable = localObject1[this._size];
      if (localComparable == null) {
        p.iCn();
      }
      if (!ap.iRg()) {
        break label225;
      }
      if (localComparable.iRA() != (aa)this) {
        break label220;
      }
    }
    label220:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label225;
      }
      localObject1 = (Throwable)new AssertionError();
      AppMethodBeat.o(118067);
      throw ((Throwable)localObject1);
      aFT(paramInt);
      break;
    }
    label225:
    localComparable.a(null);
    localComparable.setIndex(-1);
    localObject1[this._size] = null;
    AppMethodBeat.o(118067);
    return localComparable;
  }
  
  public final void aFS(int paramInt)
  {
    AppMethodBeat.i(118068);
    for (;;)
    {
      if (paramInt <= 0)
      {
        AppMethodBeat.o(118068);
        return;
      }
      Object localObject = this.abzJ;
      if (localObject == null) {
        p.iCn();
      }
      int i = (paramInt - 1) / 2;
      Comparable localComparable = localObject[i];
      if (localComparable == null) {
        p.iCn();
      }
      localComparable = (Comparable)localComparable;
      localObject = localObject[paramInt];
      if (localObject == null) {
        p.iCn();
      }
      if (localComparable.compareTo(localObject) <= 0)
      {
        AppMethodBeat.o(118068);
        return;
      }
      oz(paramInt, i);
      paramInt = i;
    }
  }
  
  public final T iSY()
  {
    AppMethodBeat.i(118065);
    try
    {
      ab localab = iTa();
      return localab;
    }
    finally
    {
      AppMethodBeat.o(118065);
    }
  }
  
  /* Error */
  public final T iSZ()
  {
    // Byte code:
    //   0: ldc 145
    //   2: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 68	kotlinx/coroutines/internal/aa:_size	I
    //   11: ifle +18 -> 29
    //   14: aload_0
    //   15: iconst_0
    //   16: invokevirtual 123	kotlinx/coroutines/internal/aa:aFR	(I)Lkotlinx/coroutines/internal/ab;
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: ldc 145
    //   24: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: areturn
    //   29: aconst_null
    //   30: astore_1
    //   31: goto -11 -> 20
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: ldc 145
    //   39: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	aa
    //   19	12	1	localab	ab
    //   34	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	34	finally
  }
  
  public final T iTa()
  {
    ab[] arrayOfab = this.abzJ;
    if (arrayOfab != null) {
      return arrayOfab[0];
    }
    return null;
  }
  
  public final boolean isEmpty()
  {
    return this._size == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.aa
 * JD-Core Version:    0.7.0.1
 */