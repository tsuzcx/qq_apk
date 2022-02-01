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
  private int LPe;
  private Object LPf;
  
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(61385);
    if ((paramInt < 0) || (paramInt > this.LPe))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.LPe);
      AppMethodBeat.o(61385);
      throw paramE;
    }
    if (this.LPe == 0) {}
    for (this.LPf = paramE;; this.LPf = new Object[] { paramE, this.LPf })
    {
      this.LPe += 1;
      this.modCount += 1;
      AppMethodBeat.o(61385);
      return;
      if ((this.LPe != 1) || (paramInt != 0)) {
        break;
      }
    }
    Object[] arrayOfObject1 = new Object[this.LPe + 1];
    if (this.LPe == 1) {
      arrayOfObject1[0] = this.LPf;
    }
    for (;;)
    {
      arrayOfObject1[paramInt] = paramE;
      this.LPf = arrayOfObject1;
      break;
      Object[] arrayOfObject2 = (Object[])this.LPf;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, paramInt);
      System.arraycopy(arrayOfObject2, paramInt, arrayOfObject1, paramInt + 1, this.LPe - paramInt);
    }
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(61384);
    if (this.LPe == 0) {}
    for (this.LPf = paramE;; this.LPf = new Object[] { this.LPf, paramE })
    {
      this.LPe += 1;
      this.modCount += 1;
      AppMethodBeat.o(61384);
      return true;
      if (this.LPe != 1) {
        break;
      }
    }
    Object[] arrayOfObject2 = (Object[])this.LPf;
    int k = arrayOfObject2.length;
    Object[] arrayOfObject1 = arrayOfObject2;
    int i;
    if (this.LPe >= k)
    {
      i = k * 3 / 2 + 1;
      int j = this.LPe + 1;
      if (i >= j) {
        break label161;
      }
      i = j;
    }
    label161:
    for (;;)
    {
      arrayOfObject1 = new Object[i];
      this.LPf = arrayOfObject1;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, k);
      arrayOfObject1[this.LPe] = paramE;
      break;
    }
  }
  
  public final void clear()
  {
    this.LPf = null;
    this.LPe = 0;
    this.modCount += 1;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(61383);
    if ((paramInt < 0) || (paramInt >= this.LPe))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.LPe);
      AppMethodBeat.o(61383);
      throw ((Throwable)localObject);
    }
    if (this.LPe == 1)
    {
      localObject = this.LPf;
      AppMethodBeat.o(61383);
      return localObject;
    }
    Object localObject = ((Object[])(Object[])this.LPf)[paramInt];
    AppMethodBeat.o(61383);
    return localObject;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(61388);
    if (this.LPe == 0)
    {
      localObject = a.gcQ();
      if (localObject == null) {
        agL(2);
      }
      AppMethodBeat.o(61388);
      return localObject;
    }
    if (this.LPe == 1)
    {
      localObject = new b();
      AppMethodBeat.o(61388);
      return localObject;
    }
    Object localObject = super.iterator();
    if (localObject == null) {
      agL(3);
    }
    AppMethodBeat.o(61388);
    return localObject;
  }
  
  public final E remove(int paramInt)
  {
    AppMethodBeat.i(61387);
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.LPe))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.LPe);
      AppMethodBeat.o(61387);
      throw ((Throwable)localObject);
    }
    if (this.LPe == 1)
    {
      localObject = this.LPf;
      this.LPf = null;
    }
    for (;;)
    {
      this.LPe -= 1;
      this.modCount += 1;
      AppMethodBeat.o(61387);
      return localObject;
      Object[] arrayOfObject = (Object[])this.LPf;
      localObject = arrayOfObject[paramInt];
      if (this.LPe == 2)
      {
        this.LPf = arrayOfObject[(1 - paramInt)];
      }
      else
      {
        int i = this.LPe - paramInt - 1;
        if (i > 0) {
          System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i);
        }
        arrayOfObject[(this.LPe - 1)] = null;
      }
    }
  }
  
  public final E set(int paramInt, E paramE)
  {
    AppMethodBeat.i(61386);
    if ((paramInt < 0) || (paramInt >= this.LPe))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.LPe);
      AppMethodBeat.o(61386);
      throw paramE;
    }
    Object localObject;
    if (this.LPe == 1)
    {
      localObject = this.LPf;
      this.LPf = paramE;
    }
    for (paramE = localObject;; paramE = localObject)
    {
      AppMethodBeat.o(61386);
      return paramE;
      Object[] arrayOfObject = (Object[])this.LPf;
      localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramE;
    }
  }
  
  public final int size()
  {
    return this.LPe;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(61389);
    if (paramArrayOfT == null) {
      agL(4);
    }
    int i = paramArrayOfT.length;
    if (this.LPe == 1) {
      if (i != 0) {
        paramArrayOfT[0] = this.LPf;
      }
    }
    for (;;)
    {
      if (i > this.LPe) {
        paramArrayOfT[this.LPe] = null;
      }
      if (paramArrayOfT == null) {
        agL(7);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 1);
      paramArrayOfT[0] = this.LPf;
      if (paramArrayOfT == null) {
        agL(5);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      if (i < this.LPe)
      {
        paramArrayOfT = (Object[])Arrays.copyOf((Object[])this.LPf, this.LPe, paramArrayOfT.getClass());
        if (paramArrayOfT == null) {
          agL(6);
        }
        AppMethodBeat.o(61389);
        return paramArrayOfT;
      }
      if (this.LPe != 0) {
        System.arraycopy(this.LPf, 0, paramArrayOfT, 0, this.LPe);
      }
    }
  }
  
  static final class a<T>
    implements Iterator<T>
  {
    private static final a LPg;
    
    static
    {
      AppMethodBeat.i(61378);
      LPg = new a();
      AppMethodBeat.o(61378);
    }
    
    public static <T> a<T> gcQ()
    {
      return LPg;
    }
    
    public final boolean hasNext()
    {
      return false;
    }
    
    public final T next()
    {
      AppMethodBeat.i(61376);
      NoSuchElementException localNoSuchElementException = new NoSuchElementException();
      AppMethodBeat.o(61376);
      throw localNoSuchElementException;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(61377);
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(61377);
      throw localIllegalStateException;
    }
  }
  
  final class b
    extends h.c<E>
  {
    private final int LPh;
    
    public b()
    {
      super();
      AppMethodBeat.i(61379);
      this.LPh = h.a(h.this);
      AppMethodBeat.o(61379);
    }
    
    protected final E gcR()
    {
      AppMethodBeat.i(61380);
      Object localObject = h.b(h.this);
      AppMethodBeat.o(61380);
      return localObject;
    }
    
    protected final void gcS()
    {
      AppMethodBeat.i(61381);
      if (h.c(h.this) != this.LPh)
      {
        ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException("ModCount: " + h.d(h.this) + "; expected: " + this.LPh);
        AppMethodBeat.o(61381);
        throw localConcurrentModificationException;
      }
      AppMethodBeat.o(61381);
    }
    
    public final void remove()
    {
      AppMethodBeat.i(61382);
      gcS();
      h.this.clear();
      AppMethodBeat.o(61382);
    }
  }
  
  static abstract class c<T>
    implements Iterator<T>
  {
    private boolean LPj;
    
    protected abstract T gcR();
    
    protected abstract void gcS();
    
    public final boolean hasNext()
    {
      return !this.LPj;
    }
    
    public final T next()
    {
      if (this.LPj) {
        throw new NoSuchElementException();
      }
      this.LPj = true;
      gcS();
      return gcR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.o.h
 * JD-Core Version:    0.7.0.1
 */