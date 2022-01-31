package kotlinx.coroutines.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "T", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "a", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "", "()Z", "size", "", "size$annotations", "addImpl", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "addLastIf", "cond", "Lkotlin/Function0;", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function0;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "predicate", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "siftDownFrom", "i", "siftUpFrom", "swap", "j", "kotlinx-coroutines-core"})
public final class q<T extends r,  extends Comparable<? super T>>
{
  public T[] CJF;
  public volatile int size;
  
  private final void Wk(int paramInt)
  {
    AppMethodBeat.i(118389);
    for (int i = paramInt;; i = paramInt)
    {
      int j = i * 2 + 1;
      if (j >= this.size)
      {
        AppMethodBeat.o(118389);
        return;
      }
      Object localObject1 = this.CJF;
      if (localObject1 == null) {
        j.ebi();
      }
      paramInt = j;
      if (j + 1 < this.size)
      {
        localComparable = localObject1[(j + 1)];
        if (localComparable == null) {
          j.ebi();
        }
        localComparable = (Comparable)localComparable;
        Object localObject2 = localObject1[j];
        if (localObject2 == null) {
          j.ebi();
        }
        paramInt = j;
        if (localComparable.compareTo(localObject2) < 0) {
          paramInt = j + 1;
        }
      }
      Comparable localComparable = localObject1[i];
      if (localComparable == null) {
        j.ebi();
      }
      localComparable = (Comparable)localComparable;
      localObject1 = localObject1[paramInt];
      if (localObject1 == null) {
        j.ebi();
      }
      if (localComparable.compareTo(localObject1) <= 0)
      {
        AppMethodBeat.o(118389);
        return;
      }
      iJ(i, paramInt);
    }
  }
  
  private final void iJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118390);
    r[] arrayOfr = this.CJF;
    if (arrayOfr == null) {
      j.ebi();
    }
    r localr1 = arrayOfr[paramInt2];
    if (localr1 == null) {
      j.ebi();
    }
    r localr2 = arrayOfr[paramInt1];
    if (localr2 == null) {
      j.ebi();
    }
    arrayOfr[paramInt1] = localr1;
    arrayOfr[paramInt2] = localr2;
    localr1.setIndex(paramInt1);
    localr2.setIndex(paramInt2);
    AppMethodBeat.o(118390);
  }
  
  public final T Wi(int paramInt)
  {
    AppMethodBeat.i(118387);
    if (this.size > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject1 = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118387);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = this.CJF;
    if (localObject1 == null) {
      j.ebi();
    }
    this.size -= 1;
    Comparable localComparable;
    if (paramInt < this.size)
    {
      iJ(paramInt, this.size);
      i = (paramInt - 1) / 2;
      if (paramInt > 0)
      {
        localComparable = localObject1[paramInt];
        if (localComparable == null) {
          j.ebi();
        }
        localComparable = (Comparable)localComparable;
        Object localObject2 = localObject1[i];
        if (localObject2 == null) {
          j.ebi();
        }
        if (localComparable.compareTo(localObject2) < 0)
        {
          iJ(paramInt, i);
          Wj(i);
        }
      }
    }
    else
    {
      localComparable = localObject1[this.size];
      if (localComparable == null) {
        j.ebi();
      }
      if (localComparable.epN() != (q)this) {
        break label218;
      }
    }
    label218:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label223;
      }
      localObject1 = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118387);
      throw ((Throwable)localObject1);
      Wk(paramInt);
      break;
    }
    label223:
    localComparable.a(null);
    localComparable.setIndex(-1);
    localObject1[this.size] = null;
    AppMethodBeat.o(118387);
    return localComparable;
  }
  
  public final void Wj(int paramInt)
  {
    AppMethodBeat.i(118388);
    for (;;)
    {
      if (paramInt <= 0)
      {
        AppMethodBeat.o(118388);
        return;
      }
      Object localObject = this.CJF;
      if (localObject == null) {
        j.ebi();
      }
      int i = (paramInt - 1) / 2;
      Comparable localComparable = localObject[i];
      if (localComparable == null) {
        j.ebi();
      }
      localComparable = (Comparable)localComparable;
      localObject = localObject[paramInt];
      if (localObject == null) {
        j.ebi();
      }
      if (localComparable.compareTo(localObject) <= 0)
      {
        AppMethodBeat.o(118388);
        return;
      }
      iJ(paramInt, i);
      paramInt = i;
    }
  }
  
  public final boolean a(T paramT)
  {
    int i = 0;
    boolean bool = false;
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(118386);
        j.q(paramT, "node");
        if (paramT.epN() == null)
        {
          AppMethodBeat.o(118386);
          return bool;
        }
        j = paramT.getIndex();
        if (j >= 0) {
          i = 1;
        }
        if (i == 0)
        {
          paramT = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(118386);
          throw paramT;
        }
      }
      finally {}
      Wi(j);
      AppMethodBeat.o(118386);
      bool = true;
    }
  }
  
  public final T eqp()
  {
    try
    {
      AppMethodBeat.i(118385);
      r localr = eqq();
      AppMethodBeat.o(118385);
      return localr;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final T eqq()
  {
    r[] arrayOfr = this.CJF;
    if (arrayOfr != null) {
      return arrayOfr[0];
    }
    return null;
  }
  
  public final boolean isEmpty()
  {
    return this.size == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.a.q
 * JD-Core Version:    0.7.0.1
 */