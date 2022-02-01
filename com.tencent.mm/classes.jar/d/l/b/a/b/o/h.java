package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public final class h<E>
  extends AbstractList<E>
  implements RandomAccess
{
  private int KbJ;
  private Object KbK;
  
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(61385);
    if ((paramInt < 0) || (paramInt > this.KbJ))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.KbJ);
      AppMethodBeat.o(61385);
      throw paramE;
    }
    if (this.KbJ == 0) {}
    for (this.KbK = paramE;; this.KbK = new Object[] { paramE, this.KbK })
    {
      this.KbJ += 1;
      this.modCount += 1;
      AppMethodBeat.o(61385);
      return;
      if ((this.KbJ != 1) || (paramInt != 0)) {
        break;
      }
    }
    Object[] arrayOfObject1 = new Object[this.KbJ + 1];
    if (this.KbJ == 1) {
      arrayOfObject1[0] = this.KbK;
    }
    for (;;)
    {
      arrayOfObject1[paramInt] = paramE;
      this.KbK = arrayOfObject1;
      break;
      Object[] arrayOfObject2 = (Object[])this.KbK;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, paramInt);
      System.arraycopy(arrayOfObject2, paramInt, arrayOfObject1, paramInt + 1, this.KbJ - paramInt);
    }
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(61384);
    if (this.KbJ == 0) {}
    for (this.KbK = paramE;; this.KbK = new Object[] { this.KbK, paramE })
    {
      this.KbJ += 1;
      this.modCount += 1;
      AppMethodBeat.o(61384);
      return true;
      if (this.KbJ != 1) {
        break;
      }
    }
    Object[] arrayOfObject2 = (Object[])this.KbK;
    int k = arrayOfObject2.length;
    Object[] arrayOfObject1 = arrayOfObject2;
    int i;
    if (this.KbJ >= k)
    {
      i = k * 3 / 2 + 1;
      int j = this.KbJ + 1;
      if (i >= j) {
        break label161;
      }
      i = j;
    }
    label161:
    for (;;)
    {
      arrayOfObject1 = new Object[i];
      this.KbK = arrayOfObject1;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, k);
      arrayOfObject1[this.KbJ] = paramE;
      break;
    }
  }
  
  public final void clear()
  {
    this.KbK = null;
    this.KbJ = 0;
    this.modCount += 1;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(61383);
    if ((paramInt < 0) || (paramInt >= this.KbJ))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.KbJ);
      AppMethodBeat.o(61383);
      throw ((Throwable)localObject);
    }
    if (this.KbJ == 1)
    {
      localObject = this.KbK;
      AppMethodBeat.o(61383);
      return localObject;
    }
    Object localObject = ((Object[])(Object[])this.KbK)[paramInt];
    AppMethodBeat.o(61383);
    return localObject;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(61388);
    if (this.KbJ == 0)
    {
      localObject = h.a.fKn();
      if (localObject == null) {
        adP(2);
      }
      AppMethodBeat.o(61388);
      return localObject;
    }
    if (this.KbJ == 1)
    {
      localObject = new b();
      AppMethodBeat.o(61388);
      return localObject;
    }
    Object localObject = super.iterator();
    if (localObject == null) {
      adP(3);
    }
    AppMethodBeat.o(61388);
    return localObject;
  }
  
  public final E remove(int paramInt)
  {
    AppMethodBeat.i(61387);
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.KbJ))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.KbJ);
      AppMethodBeat.o(61387);
      throw ((Throwable)localObject);
    }
    if (this.KbJ == 1)
    {
      localObject = this.KbK;
      this.KbK = null;
    }
    for (;;)
    {
      this.KbJ -= 1;
      this.modCount += 1;
      AppMethodBeat.o(61387);
      return localObject;
      Object[] arrayOfObject = (Object[])this.KbK;
      localObject = arrayOfObject[paramInt];
      if (this.KbJ == 2)
      {
        this.KbK = arrayOfObject[(1 - paramInt)];
      }
      else
      {
        int i = this.KbJ - paramInt - 1;
        if (i > 0) {
          System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i);
        }
        arrayOfObject[(this.KbJ - 1)] = null;
      }
    }
  }
  
  public final E set(int paramInt, E paramE)
  {
    AppMethodBeat.i(61386);
    if ((paramInt < 0) || (paramInt >= this.KbJ))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.KbJ);
      AppMethodBeat.o(61386);
      throw paramE;
    }
    Object localObject;
    if (this.KbJ == 1)
    {
      localObject = this.KbK;
      this.KbK = paramE;
    }
    for (paramE = localObject;; paramE = localObject)
    {
      AppMethodBeat.o(61386);
      return paramE;
      Object[] arrayOfObject = (Object[])this.KbK;
      localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramE;
    }
  }
  
  public final int size()
  {
    return this.KbJ;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(61389);
    if (paramArrayOfT == null) {
      adP(4);
    }
    int i = paramArrayOfT.length;
    if (this.KbJ == 1) {
      if (i != 0) {
        paramArrayOfT[0] = this.KbK;
      }
    }
    for (;;)
    {
      if (i > this.KbJ) {
        paramArrayOfT[this.KbJ] = null;
      }
      if (paramArrayOfT == null) {
        adP(7);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 1);
      paramArrayOfT[0] = this.KbK;
      if (paramArrayOfT == null) {
        adP(5);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      if (i < this.KbJ)
      {
        paramArrayOfT = (Object[])Arrays.copyOf((Object[])this.KbK, this.KbJ, paramArrayOfT.getClass());
        if (paramArrayOfT == null) {
          adP(6);
        }
        AppMethodBeat.o(61389);
        return paramArrayOfT;
      }
      if (this.KbJ != 0) {
        System.arraycopy(this.KbK, 0, paramArrayOfT, 0, this.KbJ);
      }
    }
  }
  
  final class b
    extends h.c<E>
  {
    private final int KbM;
    
    public b()
    {
      super();
      AppMethodBeat.i(61379);
      this.KbM = h.a(h.this);
      AppMethodBeat.o(61379);
    }
    
    protected final E fKo()
    {
      AppMethodBeat.i(61380);
      Object localObject = h.b(h.this);
      AppMethodBeat.o(61380);
      return localObject;
    }
    
    protected final void fKp()
    {
      AppMethodBeat.i(61381);
      if (h.c(h.this) != this.KbM)
      {
        ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException("ModCount: " + h.d(h.this) + "; expected: " + this.KbM);
        AppMethodBeat.o(61381);
        throw localConcurrentModificationException;
      }
      AppMethodBeat.o(61381);
    }
    
    public final void remove()
    {
      AppMethodBeat.i(61382);
      fKp();
      h.this.clear();
      AppMethodBeat.o(61382);
    }
  }
  
  static abstract class c<T>
    implements Iterator<T>
  {
    private boolean KbO;
    
    protected abstract T fKo();
    
    protected abstract void fKp();
    
    public final boolean hasNext()
    {
      return !this.KbO;
    }
    
    public final T next()
    {
      if (this.KbO) {
        throw new NoSuchElementException();
      }
      this.KbO = true;
      fKp();
      return fKo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.o.h
 * JD-Core Version:    0.7.0.1
 */