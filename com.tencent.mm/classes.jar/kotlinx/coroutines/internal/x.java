package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import kotlinx.coroutines.al;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"})
public class x<T extends y,  extends Comparable<? super T>>
{
  public T[] LTs;
  public volatile int _size = 0;
  
  private final void aje(int paramInt)
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
      Object localObject1 = this.LTs;
      if (localObject1 == null) {
        k.fOy();
      }
      paramInt = j;
      if (j + 1 < this._size)
      {
        localComparable = localObject1[(j + 1)];
        if (localComparable == null) {
          k.fOy();
        }
        localComparable = (Comparable)localComparable;
        Object localObject2 = localObject1[j];
        if (localObject2 == null) {
          k.fOy();
        }
        paramInt = j;
        if (localComparable.compareTo(localObject2) < 0) {
          paramInt = j + 1;
        }
      }
      Comparable localComparable = localObject1[i];
      if (localComparable == null) {
        k.fOy();
      }
      localComparable = (Comparable)localComparable;
      localObject1 = localObject1[paramInt];
      if (localObject1 == null) {
        k.fOy();
      }
      if (localComparable.compareTo(localObject1) <= 0)
      {
        AppMethodBeat.o(118069);
        return;
      }
      lg(i, paramInt);
    }
  }
  
  private final void lg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118070);
    y[] arrayOfy = this.LTs;
    if (arrayOfy == null) {
      k.fOy();
    }
    y localy1 = arrayOfy[paramInt2];
    if (localy1 == null) {
      k.fOy();
    }
    y localy2 = arrayOfy[paramInt1];
    if (localy2 == null) {
      k.fOy();
    }
    arrayOfy[paramInt1] = localy1;
    arrayOfy[paramInt2] = localy2;
    localy1.setIndex(paramInt1);
    localy2.setIndex(paramInt2);
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
        x localx = paramT.gdY();
        if (localx == null) {
          return bool;
        }
        j = paramT.getIndex();
        if (al.gdD())
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
      ajc(j);
      bool = true;
    }
  }
  
  public final T ajc(int paramInt)
  {
    AppMethodBeat.i(118067);
    int i;
    if (al.gdD())
    {
      if (this._size > 0) {}
      for (i = 1; i == 0; i = 0)
      {
        localObject1 = (Throwable)new AssertionError();
        AppMethodBeat.o(118067);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject1 = this.LTs;
    if (localObject1 == null) {
      k.fOy();
    }
    this._size -= 1;
    Comparable localComparable;
    if (paramInt < this._size)
    {
      lg(paramInt, this._size);
      i = (paramInt - 1) / 2;
      if (paramInt > 0)
      {
        localComparable = localObject1[paramInt];
        if (localComparable == null) {
          k.fOy();
        }
        localComparable = (Comparable)localComparable;
        Object localObject2 = localObject1[i];
        if (localObject2 == null) {
          k.fOy();
        }
        if (localComparable.compareTo(localObject2) < 0)
        {
          lg(paramInt, i);
          ajd(i);
        }
      }
    }
    else
    {
      localComparable = localObject1[this._size];
      if (localComparable == null) {
        k.fOy();
      }
      if (!al.gdD()) {
        break label225;
      }
      if (localComparable.gdY() != (x)this) {
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
      aje(paramInt);
      break;
    }
    label225:
    localComparable.a(null);
    localComparable.setIndex(-1);
    localObject1[this._size] = null;
    AppMethodBeat.o(118067);
    return localComparable;
  }
  
  public final void ajd(int paramInt)
  {
    AppMethodBeat.i(118068);
    for (;;)
    {
      if (paramInt <= 0)
      {
        AppMethodBeat.o(118068);
        return;
      }
      Object localObject = this.LTs;
      if (localObject == null) {
        k.fOy();
      }
      int i = (paramInt - 1) / 2;
      Comparable localComparable = localObject[i];
      if (localComparable == null) {
        k.fOy();
      }
      localComparable = (Comparable)localComparable;
      localObject = localObject[paramInt];
      if (localObject == null) {
        k.fOy();
      }
      if (localComparable.compareTo(localObject) <= 0)
      {
        AppMethodBeat.o(118068);
        return;
      }
      lg(paramInt, i);
      paramInt = i;
    }
  }
  
  public final T geK()
  {
    AppMethodBeat.i(118065);
    try
    {
      y localy = geM();
      return localy;
    }
    finally
    {
      AppMethodBeat.o(118065);
    }
  }
  
  /* Error */
  public final T geL()
  {
    // Byte code:
    //   0: ldc 145
    //   2: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 68	kotlinx/coroutines/internal/x:_size	I
    //   11: ifle +18 -> 29
    //   14: aload_0
    //   15: iconst_0
    //   16: invokevirtual 123	kotlinx/coroutines/internal/x:ajc	(I)Lkotlinx/coroutines/internal/y;
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
    //   0	44	0	this	x
    //   19	12	1	localy	y
    //   34	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	34	finally
  }
  
  public final T geM()
  {
    y[] arrayOfy = this.LTs;
    if (arrayOfy != null) {
      return arrayOfy[0];
    }
    return null;
  }
  
  public final boolean isEmpty()
  {
    return this._size == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.x
 * JD-Core Version:    0.7.0.1
 */