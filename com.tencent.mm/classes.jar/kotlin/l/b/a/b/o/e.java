package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public final class e<E>
  extends AbstractList<E>
  implements RandomAccess
{
  private int ajtD;
  private Object ajtE;
  
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(61385);
    if ((paramInt < 0) || (paramInt > this.ajtD))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.ajtD);
      AppMethodBeat.o(61385);
      throw paramE;
    }
    if (this.ajtD == 0) {}
    for (this.ajtE = paramE;; this.ajtE = new Object[] { paramE, this.ajtE })
    {
      this.ajtD += 1;
      this.modCount += 1;
      AppMethodBeat.o(61385);
      return;
      if ((this.ajtD != 1) || (paramInt != 0)) {
        break;
      }
    }
    Object[] arrayOfObject1 = new Object[this.ajtD + 1];
    if (this.ajtD == 1) {
      arrayOfObject1[0] = this.ajtE;
    }
    for (;;)
    {
      arrayOfObject1[paramInt] = paramE;
      this.ajtE = arrayOfObject1;
      break;
      Object[] arrayOfObject2 = (Object[])this.ajtE;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, paramInt);
      System.arraycopy(arrayOfObject2, paramInt, arrayOfObject1, paramInt + 1, this.ajtD - paramInt);
    }
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(61384);
    if (this.ajtD == 0) {}
    for (this.ajtE = paramE;; this.ajtE = new Object[] { this.ajtE, paramE })
    {
      this.ajtD += 1;
      this.modCount += 1;
      AppMethodBeat.o(61384);
      return true;
      if (this.ajtD != 1) {
        break;
      }
    }
    Object[] arrayOfObject2 = (Object[])this.ajtE;
    int k = arrayOfObject2.length;
    Object[] arrayOfObject1 = arrayOfObject2;
    int i;
    if (this.ajtD >= k)
    {
      i = k * 3 / 2 + 1;
      int j = this.ajtD + 1;
      if (i >= j) {
        break label161;
      }
      i = j;
    }
    label161:
    for (;;)
    {
      arrayOfObject1 = new Object[i];
      this.ajtE = arrayOfObject1;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, k);
      arrayOfObject1[this.ajtD] = paramE;
      break;
    }
  }
  
  public final void clear()
  {
    this.ajtE = null;
    this.ajtD = 0;
    this.modCount += 1;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(61383);
    if ((paramInt < 0) || (paramInt >= this.ajtD))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.ajtD);
      AppMethodBeat.o(61383);
      throw ((Throwable)localObject);
    }
    if (this.ajtD == 1)
    {
      localObject = this.ajtE;
      AppMethodBeat.o(61383);
      return localObject;
    }
    Object localObject = ((Object[])(Object[])this.ajtE)[paramInt];
    AppMethodBeat.o(61383);
    return localObject;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(61388);
    if (this.ajtD == 0)
    {
      localObject = a.kBb();
      if (localObject == null) {
        aKu(2);
      }
      AppMethodBeat.o(61388);
      return localObject;
    }
    if (this.ajtD == 1)
    {
      localObject = new b();
      AppMethodBeat.o(61388);
      return localObject;
    }
    Object localObject = super.iterator();
    if (localObject == null) {
      aKu(3);
    }
    AppMethodBeat.o(61388);
    return localObject;
  }
  
  public final E remove(int paramInt)
  {
    AppMethodBeat.i(61387);
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.ajtD))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.ajtD);
      AppMethodBeat.o(61387);
      throw ((Throwable)localObject);
    }
    if (this.ajtD == 1)
    {
      localObject = this.ajtE;
      this.ajtE = null;
    }
    for (;;)
    {
      this.ajtD -= 1;
      this.modCount += 1;
      AppMethodBeat.o(61387);
      return localObject;
      Object[] arrayOfObject = (Object[])this.ajtE;
      localObject = arrayOfObject[paramInt];
      if (this.ajtD == 2)
      {
        this.ajtE = arrayOfObject[(1 - paramInt)];
      }
      else
      {
        int i = this.ajtD - paramInt - 1;
        if (i > 0) {
          System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i);
        }
        arrayOfObject[(this.ajtD - 1)] = null;
      }
    }
  }
  
  public final E set(int paramInt, E paramE)
  {
    AppMethodBeat.i(61386);
    if ((paramInt < 0) || (paramInt >= this.ajtD))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.ajtD);
      AppMethodBeat.o(61386);
      throw paramE;
    }
    Object localObject;
    if (this.ajtD == 1)
    {
      localObject = this.ajtE;
      this.ajtE = paramE;
    }
    for (paramE = localObject;; paramE = localObject)
    {
      AppMethodBeat.o(61386);
      return paramE;
      Object[] arrayOfObject = (Object[])this.ajtE;
      localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramE;
    }
  }
  
  public final int size()
  {
    return this.ajtD;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(61389);
    if (paramArrayOfT == null) {
      aKu(4);
    }
    int i = paramArrayOfT.length;
    if (this.ajtD == 1) {
      if (i != 0) {
        paramArrayOfT[0] = this.ajtE;
      }
    }
    for (;;)
    {
      if (i > this.ajtD) {
        paramArrayOfT[this.ajtD] = null;
      }
      if (paramArrayOfT == null) {
        aKu(7);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 1);
      paramArrayOfT[0] = this.ajtE;
      if (paramArrayOfT == null) {
        aKu(5);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      if (i < this.ajtD)
      {
        paramArrayOfT = (Object[])Arrays.copyOf((Object[])this.ajtE, this.ajtD, paramArrayOfT.getClass());
        if (paramArrayOfT == null) {
          aKu(6);
        }
        AppMethodBeat.o(61389);
        return paramArrayOfT;
      }
      if (this.ajtD != 0) {
        System.arraycopy(this.ajtE, 0, paramArrayOfT, 0, this.ajtD);
      }
    }
  }
  
  static final class a<T>
    implements Iterator<T>
  {
    private static final a ajtF;
    
    static
    {
      AppMethodBeat.i(61378);
      ajtF = new a();
      AppMethodBeat.o(61378);
    }
    
    public static <T> a<T> kBb()
    {
      return ajtF;
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
    extends e.c<E>
  {
    private final int ajtG;
    
    public b()
    {
      super();
      AppMethodBeat.i(61379);
      this.ajtG = e.a(e.this);
      AppMethodBeat.o(61379);
    }
    
    protected final E kBc()
    {
      AppMethodBeat.i(61380);
      Object localObject = e.b(e.this);
      AppMethodBeat.o(61380);
      return localObject;
    }
    
    protected final void kBd()
    {
      AppMethodBeat.i(61381);
      if (e.c(e.this) != this.ajtG)
      {
        ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException("ModCount: " + e.d(e.this) + "; expected: " + this.ajtG);
        AppMethodBeat.o(61381);
        throw localConcurrentModificationException;
      }
      AppMethodBeat.o(61381);
    }
    
    public final void remove()
    {
      AppMethodBeat.i(61382);
      kBd();
      e.this.clear();
      AppMethodBeat.o(61382);
    }
  }
  
  static abstract class c<T>
    implements Iterator<T>
  {
    private boolean ajtI;
    
    public final boolean hasNext()
    {
      return !this.ajtI;
    }
    
    protected abstract T kBc();
    
    protected abstract void kBd();
    
    public final T next()
    {
      if (this.ajtI) {
        throw new NoSuchElementException();
      }
      this.ajtI = true;
      kBd();
      return kBc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.o.e
 * JD-Core Version:    0.7.0.1
 */