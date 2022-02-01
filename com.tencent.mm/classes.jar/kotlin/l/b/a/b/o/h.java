package kotlin.l.b.a.b.o;

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
  private int TRZ;
  private Object TSa;
  
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(61385);
    if ((paramInt < 0) || (paramInt > this.TRZ))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.TRZ);
      AppMethodBeat.o(61385);
      throw paramE;
    }
    if (this.TRZ == 0) {}
    for (this.TSa = paramE;; this.TSa = new Object[] { paramE, this.TSa })
    {
      this.TRZ += 1;
      this.modCount += 1;
      AppMethodBeat.o(61385);
      return;
      if ((this.TRZ != 1) || (paramInt != 0)) {
        break;
      }
    }
    Object[] arrayOfObject1 = new Object[this.TRZ + 1];
    if (this.TRZ == 1) {
      arrayOfObject1[0] = this.TSa;
    }
    for (;;)
    {
      arrayOfObject1[paramInt] = paramE;
      this.TSa = arrayOfObject1;
      break;
      Object[] arrayOfObject2 = (Object[])this.TSa;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, paramInt);
      System.arraycopy(arrayOfObject2, paramInt, arrayOfObject1, paramInt + 1, this.TRZ - paramInt);
    }
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(61384);
    if (this.TRZ == 0) {}
    for (this.TSa = paramE;; this.TSa = new Object[] { this.TSa, paramE })
    {
      this.TRZ += 1;
      this.modCount += 1;
      AppMethodBeat.o(61384);
      return true;
      if (this.TRZ != 1) {
        break;
      }
    }
    Object[] arrayOfObject2 = (Object[])this.TSa;
    int k = arrayOfObject2.length;
    Object[] arrayOfObject1 = arrayOfObject2;
    int i;
    if (this.TRZ >= k)
    {
      i = k * 3 / 2 + 1;
      int j = this.TRZ + 1;
      if (i >= j) {
        break label161;
      }
      i = j;
    }
    label161:
    for (;;)
    {
      arrayOfObject1 = new Object[i];
      this.TSa = arrayOfObject1;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, k);
      arrayOfObject1[this.TRZ] = paramE;
      break;
    }
  }
  
  public final void clear()
  {
    this.TSa = null;
    this.TRZ = 0;
    this.modCount += 1;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(61383);
    if ((paramInt < 0) || (paramInt >= this.TRZ))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.TRZ);
      AppMethodBeat.o(61383);
      throw ((Throwable)localObject);
    }
    if (this.TRZ == 1)
    {
      localObject = this.TSa;
      AppMethodBeat.o(61383);
      return localObject;
    }
    Object localObject = ((Object[])(Object[])this.TSa)[paramInt];
    AppMethodBeat.o(61383);
    return localObject;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(61388);
    if (this.TRZ == 0)
    {
      localObject = h.a.hLW();
      if (localObject == null) {
        atM(2);
      }
      AppMethodBeat.o(61388);
      return localObject;
    }
    if (this.TRZ == 1)
    {
      localObject = new b();
      AppMethodBeat.o(61388);
      return localObject;
    }
    Object localObject = super.iterator();
    if (localObject == null) {
      atM(3);
    }
    AppMethodBeat.o(61388);
    return localObject;
  }
  
  public final E remove(int paramInt)
  {
    AppMethodBeat.i(61387);
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.TRZ))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.TRZ);
      AppMethodBeat.o(61387);
      throw ((Throwable)localObject);
    }
    if (this.TRZ == 1)
    {
      localObject = this.TSa;
      this.TSa = null;
    }
    for (;;)
    {
      this.TRZ -= 1;
      this.modCount += 1;
      AppMethodBeat.o(61387);
      return localObject;
      Object[] arrayOfObject = (Object[])this.TSa;
      localObject = arrayOfObject[paramInt];
      if (this.TRZ == 2)
      {
        this.TSa = arrayOfObject[(1 - paramInt)];
      }
      else
      {
        int i = this.TRZ - paramInt - 1;
        if (i > 0) {
          System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i);
        }
        arrayOfObject[(this.TRZ - 1)] = null;
      }
    }
  }
  
  public final E set(int paramInt, E paramE)
  {
    AppMethodBeat.i(61386);
    if ((paramInt < 0) || (paramInt >= this.TRZ))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.TRZ);
      AppMethodBeat.o(61386);
      throw paramE;
    }
    Object localObject;
    if (this.TRZ == 1)
    {
      localObject = this.TSa;
      this.TSa = paramE;
    }
    for (paramE = localObject;; paramE = localObject)
    {
      AppMethodBeat.o(61386);
      return paramE;
      Object[] arrayOfObject = (Object[])this.TSa;
      localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramE;
    }
  }
  
  public final int size()
  {
    return this.TRZ;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(61389);
    if (paramArrayOfT == null) {
      atM(4);
    }
    int i = paramArrayOfT.length;
    if (this.TRZ == 1) {
      if (i != 0) {
        paramArrayOfT[0] = this.TSa;
      }
    }
    for (;;)
    {
      if (i > this.TRZ) {
        paramArrayOfT[this.TRZ] = null;
      }
      if (paramArrayOfT == null) {
        atM(7);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 1);
      paramArrayOfT[0] = this.TSa;
      if (paramArrayOfT == null) {
        atM(5);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      if (i < this.TRZ)
      {
        paramArrayOfT = (Object[])Arrays.copyOf((Object[])this.TSa, this.TRZ, paramArrayOfT.getClass());
        if (paramArrayOfT == null) {
          atM(6);
        }
        AppMethodBeat.o(61389);
        return paramArrayOfT;
      }
      if (this.TRZ != 0) {
        System.arraycopy(this.TSa, 0, paramArrayOfT, 0, this.TRZ);
      }
    }
  }
  
  final class b
    extends h.c<E>
  {
    private final int TSc;
    
    public b()
    {
      super();
      AppMethodBeat.i(61379);
      this.TSc = h.a(h.this);
      AppMethodBeat.o(61379);
    }
    
    protected final E hLX()
    {
      AppMethodBeat.i(61380);
      Object localObject = h.b(h.this);
      AppMethodBeat.o(61380);
      return localObject;
    }
    
    protected final void hLY()
    {
      AppMethodBeat.i(61381);
      if (h.c(h.this) != this.TSc)
      {
        ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException("ModCount: " + h.d(h.this) + "; expected: " + this.TSc);
        AppMethodBeat.o(61381);
        throw localConcurrentModificationException;
      }
      AppMethodBeat.o(61381);
    }
    
    public final void remove()
    {
      AppMethodBeat.i(61382);
      hLY();
      h.this.clear();
      AppMethodBeat.o(61382);
    }
  }
  
  static abstract class c<T>
    implements Iterator<T>
  {
    private boolean TSe;
    
    protected abstract T hLX();
    
    protected abstract void hLY();
    
    public final boolean hasNext()
    {
      return !this.TSe;
    }
    
    public final T next()
    {
      if (this.TSe) {
        throw new NoSuchElementException();
      }
      this.TSe = true;
      hLY();
      return hLX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.o.h
 * JD-Core Version:    0.7.0.1
 */