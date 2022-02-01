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
  private int Odf;
  private Object Odg;
  
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(61385);
    if ((paramInt < 0) || (paramInt > this.Odf))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.Odf);
      AppMethodBeat.o(61385);
      throw paramE;
    }
    if (this.Odf == 0) {}
    for (this.Odg = paramE;; this.Odg = new Object[] { paramE, this.Odg })
    {
      this.Odf += 1;
      this.modCount += 1;
      AppMethodBeat.o(61385);
      return;
      if ((this.Odf != 1) || (paramInt != 0)) {
        break;
      }
    }
    Object[] arrayOfObject1 = new Object[this.Odf + 1];
    if (this.Odf == 1) {
      arrayOfObject1[0] = this.Odg;
    }
    for (;;)
    {
      arrayOfObject1[paramInt] = paramE;
      this.Odg = arrayOfObject1;
      break;
      Object[] arrayOfObject2 = (Object[])this.Odg;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, paramInt);
      System.arraycopy(arrayOfObject2, paramInt, arrayOfObject1, paramInt + 1, this.Odf - paramInt);
    }
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(61384);
    if (this.Odf == 0) {}
    for (this.Odg = paramE;; this.Odg = new Object[] { this.Odg, paramE })
    {
      this.Odf += 1;
      this.modCount += 1;
      AppMethodBeat.o(61384);
      return true;
      if (this.Odf != 1) {
        break;
      }
    }
    Object[] arrayOfObject2 = (Object[])this.Odg;
    int k = arrayOfObject2.length;
    Object[] arrayOfObject1 = arrayOfObject2;
    int i;
    if (this.Odf >= k)
    {
      i = k * 3 / 2 + 1;
      int j = this.Odf + 1;
      if (i >= j) {
        break label161;
      }
      i = j;
    }
    label161:
    for (;;)
    {
      arrayOfObject1 = new Object[i];
      this.Odg = arrayOfObject1;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, k);
      arrayOfObject1[this.Odf] = paramE;
      break;
    }
  }
  
  public final void clear()
  {
    this.Odg = null;
    this.Odf = 0;
    this.modCount += 1;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(61383);
    if ((paramInt < 0) || (paramInt >= this.Odf))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.Odf);
      AppMethodBeat.o(61383);
      throw ((Throwable)localObject);
    }
    if (this.Odf == 1)
    {
      localObject = this.Odg;
      AppMethodBeat.o(61383);
      return localObject;
    }
    Object localObject = ((Object[])(Object[])this.Odg)[paramInt];
    AppMethodBeat.o(61383);
    return localObject;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(61388);
    if (this.Odf == 0)
    {
      localObject = a.gyT();
      if (localObject == null) {
        ajW(2);
      }
      AppMethodBeat.o(61388);
      return localObject;
    }
    if (this.Odf == 1)
    {
      localObject = new b();
      AppMethodBeat.o(61388);
      return localObject;
    }
    Object localObject = super.iterator();
    if (localObject == null) {
      ajW(3);
    }
    AppMethodBeat.o(61388);
    return localObject;
  }
  
  public final E remove(int paramInt)
  {
    AppMethodBeat.i(61387);
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.Odf))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.Odf);
      AppMethodBeat.o(61387);
      throw ((Throwable)localObject);
    }
    if (this.Odf == 1)
    {
      localObject = this.Odg;
      this.Odg = null;
    }
    for (;;)
    {
      this.Odf -= 1;
      this.modCount += 1;
      AppMethodBeat.o(61387);
      return localObject;
      Object[] arrayOfObject = (Object[])this.Odg;
      localObject = arrayOfObject[paramInt];
      if (this.Odf == 2)
      {
        this.Odg = arrayOfObject[(1 - paramInt)];
      }
      else
      {
        int i = this.Odf - paramInt - 1;
        if (i > 0) {
          System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i);
        }
        arrayOfObject[(this.Odf - 1)] = null;
      }
    }
  }
  
  public final E set(int paramInt, E paramE)
  {
    AppMethodBeat.i(61386);
    if ((paramInt < 0) || (paramInt >= this.Odf))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.Odf);
      AppMethodBeat.o(61386);
      throw paramE;
    }
    Object localObject;
    if (this.Odf == 1)
    {
      localObject = this.Odg;
      this.Odg = paramE;
    }
    for (paramE = localObject;; paramE = localObject)
    {
      AppMethodBeat.o(61386);
      return paramE;
      Object[] arrayOfObject = (Object[])this.Odg;
      localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramE;
    }
  }
  
  public final int size()
  {
    return this.Odf;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(61389);
    if (paramArrayOfT == null) {
      ajW(4);
    }
    int i = paramArrayOfT.length;
    if (this.Odf == 1) {
      if (i != 0) {
        paramArrayOfT[0] = this.Odg;
      }
    }
    for (;;)
    {
      if (i > this.Odf) {
        paramArrayOfT[this.Odf] = null;
      }
      if (paramArrayOfT == null) {
        ajW(7);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 1);
      paramArrayOfT[0] = this.Odg;
      if (paramArrayOfT == null) {
        ajW(5);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      if (i < this.Odf)
      {
        paramArrayOfT = (Object[])Arrays.copyOf((Object[])this.Odg, this.Odf, paramArrayOfT.getClass());
        if (paramArrayOfT == null) {
          ajW(6);
        }
        AppMethodBeat.o(61389);
        return paramArrayOfT;
      }
      if (this.Odf != 0) {
        System.arraycopy(this.Odg, 0, paramArrayOfT, 0, this.Odf);
      }
    }
  }
  
  static final class a<T>
    implements Iterator<T>
  {
    private static final a Odh;
    
    static
    {
      AppMethodBeat.i(61378);
      Odh = new a();
      AppMethodBeat.o(61378);
    }
    
    public static <T> a<T> gyT()
    {
      return Odh;
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
    private final int Odi;
    
    public b()
    {
      super();
      AppMethodBeat.i(61379);
      this.Odi = h.a(h.this);
      AppMethodBeat.o(61379);
    }
    
    protected final E gyU()
    {
      AppMethodBeat.i(61380);
      Object localObject = h.b(h.this);
      AppMethodBeat.o(61380);
      return localObject;
    }
    
    protected final void gyV()
    {
      AppMethodBeat.i(61381);
      if (h.c(h.this) != this.Odi)
      {
        ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException("ModCount: " + h.d(h.this) + "; expected: " + this.Odi);
        AppMethodBeat.o(61381);
        throw localConcurrentModificationException;
      }
      AppMethodBeat.o(61381);
    }
    
    public final void remove()
    {
      AppMethodBeat.i(61382);
      gyV();
      h.this.clear();
      AppMethodBeat.o(61382);
    }
  }
  
  static abstract class c<T>
    implements Iterator<T>
  {
    private boolean Odk;
    
    protected abstract T gyU();
    
    protected abstract void gyV();
    
    public final boolean hasNext()
    {
      return !this.Odk;
    }
    
    public final T next()
    {
      if (this.Odk) {
        throw new NoSuchElementException();
      }
      this.Odk = true;
      gyV();
      return gyU();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.o.h
 * JD-Core Version:    0.7.0.1
 */