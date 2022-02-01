package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.an;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"})
public class z<T extends aa,  extends Comparable<? super T>>
{
  public T[] TWs;
  public volatile int _size = 0;
  
  private final void avY(int paramInt)
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
      Object localObject1 = this.TWs;
      if (localObject1 == null) {
        p.hyc();
      }
      paramInt = j;
      if (j + 1 < this._size)
      {
        localComparable = localObject1[(j + 1)];
        if (localComparable == null) {
          p.hyc();
        }
        localComparable = (Comparable)localComparable;
        Object localObject2 = localObject1[j];
        if (localObject2 == null) {
          p.hyc();
        }
        paramInt = j;
        if (localComparable.compareTo(localObject2) < 0) {
          paramInt = j + 1;
        }
      }
      Comparable localComparable = localObject1[i];
      if (localComparable == null) {
        p.hyc();
      }
      localComparable = (Comparable)localComparable;
      localObject1 = localObject1[paramInt];
      if (localObject1 == null) {
        p.hyc();
      }
      if (localComparable.compareTo(localObject1) <= 0)
      {
        AppMethodBeat.o(118069);
        return;
      }
      nd(i, paramInt);
    }
  }
  
  private final void nd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118070);
    aa[] arrayOfaa = this.TWs;
    if (arrayOfaa == null) {
      p.hyc();
    }
    aa localaa1 = arrayOfaa[paramInt2];
    if (localaa1 == null) {
      p.hyc();
    }
    aa localaa2 = arrayOfaa[paramInt1];
    if (localaa2 == null) {
      p.hyc();
    }
    arrayOfaa[paramInt1] = localaa1;
    arrayOfaa[paramInt2] = localaa2;
    localaa1.setIndex(paramInt1);
    localaa2.setIndex(paramInt2);
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
        z localz = paramT.hNf();
        if (localz == null) {
          return bool;
        }
        j = paramT.getIndex();
        if (an.hMK())
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
      avW(j);
      bool = true;
    }
  }
  
  public final T avW(int paramInt)
  {
    AppMethodBeat.i(118067);
    int i;
    if (an.hMK())
    {
      if (this._size > 0) {}
      for (i = 1; i == 0; i = 0)
      {
        localObject1 = (Throwable)new AssertionError();
        AppMethodBeat.o(118067);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject1 = this.TWs;
    if (localObject1 == null) {
      p.hyc();
    }
    this._size -= 1;
    Comparable localComparable;
    if (paramInt < this._size)
    {
      nd(paramInt, this._size);
      i = (paramInt - 1) / 2;
      if (paramInt > 0)
      {
        localComparable = localObject1[paramInt];
        if (localComparable == null) {
          p.hyc();
        }
        localComparable = (Comparable)localComparable;
        Object localObject2 = localObject1[i];
        if (localObject2 == null) {
          p.hyc();
        }
        if (localComparable.compareTo(localObject2) < 0)
        {
          nd(paramInt, i);
          avX(i);
        }
      }
    }
    else
    {
      localComparable = localObject1[this._size];
      if (localComparable == null) {
        p.hyc();
      }
      if (!an.hMK()) {
        break label225;
      }
      if (localComparable.hNf() != (z)this) {
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
      avY(paramInt);
      break;
    }
    label225:
    localComparable.a(null);
    localComparable.setIndex(-1);
    localObject1[this._size] = null;
    AppMethodBeat.o(118067);
    return localComparable;
  }
  
  public final void avX(int paramInt)
  {
    AppMethodBeat.i(118068);
    for (;;)
    {
      if (paramInt <= 0)
      {
        AppMethodBeat.o(118068);
        return;
      }
      Object localObject = this.TWs;
      if (localObject == null) {
        p.hyc();
      }
      int i = (paramInt - 1) / 2;
      Comparable localComparable = localObject[i];
      if (localComparable == null) {
        p.hyc();
      }
      localComparable = (Comparable)localComparable;
      localObject = localObject[paramInt];
      if (localObject == null) {
        p.hyc();
      }
      if (localComparable.compareTo(localObject) <= 0)
      {
        AppMethodBeat.o(118068);
        return;
      }
      nd(paramInt, i);
      paramInt = i;
    }
  }
  
  public final T hNS()
  {
    AppMethodBeat.i(118065);
    try
    {
      aa localaa = hNU();
      return localaa;
    }
    finally
    {
      AppMethodBeat.o(118065);
    }
  }
  
  /* Error */
  public final T hNT()
  {
    // Byte code:
    //   0: ldc 145
    //   2: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 68	kotlinx/coroutines/internal/z:_size	I
    //   11: ifle +18 -> 29
    //   14: aload_0
    //   15: iconst_0
    //   16: invokevirtual 123	kotlinx/coroutines/internal/z:avW	(I)Lkotlinx/coroutines/internal/aa;
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
    //   0	44	0	this	z
    //   19	12	1	localaa	aa
    //   34	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	34	finally
  }
  
  public final T hNU()
  {
    aa[] arrayOfaa = this.TWs;
    if (arrayOfaa != null) {
      return arrayOfaa[0];
    }
    return null;
  }
  
  public final boolean isEmpty()
  {
    return this._size == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.z
 * JD-Core Version:    0.7.0.1
 */