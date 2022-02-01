package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.RandomAccess;

public final class h<E>
  extends AbstractList<E>
  implements RandomAccess
{
  private int NFZ;
  private Object NGa;
  
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(61385);
    if ((paramInt < 0) || (paramInt > this.NFZ))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.NFZ);
      AppMethodBeat.o(61385);
      throw paramE;
    }
    if (this.NFZ == 0) {}
    for (this.NGa = paramE;; this.NGa = new Object[] { paramE, this.NGa })
    {
      this.NFZ += 1;
      this.modCount += 1;
      AppMethodBeat.o(61385);
      return;
      if ((this.NFZ != 1) || (paramInt != 0)) {
        break;
      }
    }
    Object[] arrayOfObject1 = new Object[this.NFZ + 1];
    if (this.NFZ == 1) {
      arrayOfObject1[0] = this.NGa;
    }
    for (;;)
    {
      arrayOfObject1[paramInt] = paramE;
      this.NGa = arrayOfObject1;
      break;
      Object[] arrayOfObject2 = (Object[])this.NGa;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, paramInt);
      System.arraycopy(arrayOfObject2, paramInt, arrayOfObject1, paramInt + 1, this.NFZ - paramInt);
    }
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(61384);
    if (this.NFZ == 0) {}
    for (this.NGa = paramE;; this.NGa = new Object[] { this.NGa, paramE })
    {
      this.NFZ += 1;
      this.modCount += 1;
      AppMethodBeat.o(61384);
      return true;
      if (this.NFZ != 1) {
        break;
      }
    }
    Object[] arrayOfObject2 = (Object[])this.NGa;
    int k = arrayOfObject2.length;
    Object[] arrayOfObject1 = arrayOfObject2;
    int i;
    if (this.NFZ >= k)
    {
      i = k * 3 / 2 + 1;
      int j = this.NFZ + 1;
      if (i >= j) {
        break label161;
      }
      i = j;
    }
    label161:
    for (;;)
    {
      arrayOfObject1 = new Object[i];
      this.NGa = arrayOfObject1;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, k);
      arrayOfObject1[this.NFZ] = paramE;
      break;
    }
  }
  
  public final void clear()
  {
    this.NGa = null;
    this.NFZ = 0;
    this.modCount += 1;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(61383);
    if ((paramInt < 0) || (paramInt >= this.NFZ))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.NFZ);
      AppMethodBeat.o(61383);
      throw ((Throwable)localObject);
    }
    if (this.NFZ == 1)
    {
      localObject = this.NGa;
      AppMethodBeat.o(61383);
      return localObject;
    }
    Object localObject = ((Object[])(Object[])this.NGa)[paramInt];
    AppMethodBeat.o(61383);
    return localObject;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(61388);
    if (this.NFZ == 0)
    {
      localObject = h.a.gur();
      if (localObject == null) {
        ajm(2);
      }
      AppMethodBeat.o(61388);
      return localObject;
    }
    if (this.NFZ == 1)
    {
      localObject = new b();
      AppMethodBeat.o(61388);
      return localObject;
    }
    Object localObject = super.iterator();
    if (localObject == null) {
      ajm(3);
    }
    AppMethodBeat.o(61388);
    return localObject;
  }
  
  public final E remove(int paramInt)
  {
    AppMethodBeat.i(61387);
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.NFZ))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.NFZ);
      AppMethodBeat.o(61387);
      throw ((Throwable)localObject);
    }
    if (this.NFZ == 1)
    {
      localObject = this.NGa;
      this.NGa = null;
    }
    for (;;)
    {
      this.NFZ -= 1;
      this.modCount += 1;
      AppMethodBeat.o(61387);
      return localObject;
      Object[] arrayOfObject = (Object[])this.NGa;
      localObject = arrayOfObject[paramInt];
      if (this.NFZ == 2)
      {
        this.NGa = arrayOfObject[(1 - paramInt)];
      }
      else
      {
        int i = this.NFZ - paramInt - 1;
        if (i > 0) {
          System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i);
        }
        arrayOfObject[(this.NFZ - 1)] = null;
      }
    }
  }
  
  public final E set(int paramInt, E paramE)
  {
    AppMethodBeat.i(61386);
    if ((paramInt < 0) || (paramInt >= this.NFZ))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.NFZ);
      AppMethodBeat.o(61386);
      throw paramE;
    }
    Object localObject;
    if (this.NFZ == 1)
    {
      localObject = this.NGa;
      this.NGa = paramE;
    }
    for (paramE = localObject;; paramE = localObject)
    {
      AppMethodBeat.o(61386);
      return paramE;
      Object[] arrayOfObject = (Object[])this.NGa;
      localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramE;
    }
  }
  
  public final int size()
  {
    return this.NFZ;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(61389);
    if (paramArrayOfT == null) {
      ajm(4);
    }
    int i = paramArrayOfT.length;
    if (this.NFZ == 1) {
      if (i != 0) {
        paramArrayOfT[0] = this.NGa;
      }
    }
    for (;;)
    {
      if (i > this.NFZ) {
        paramArrayOfT[this.NFZ] = null;
      }
      if (paramArrayOfT == null) {
        ajm(7);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 1);
      paramArrayOfT[0] = this.NGa;
      if (paramArrayOfT == null) {
        ajm(5);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      if (i < this.NFZ)
      {
        paramArrayOfT = (Object[])Arrays.copyOf((Object[])this.NGa, this.NFZ, paramArrayOfT.getClass());
        if (paramArrayOfT == null) {
          ajm(6);
        }
        AppMethodBeat.o(61389);
        return paramArrayOfT;
      }
      if (this.NFZ != 0) {
        System.arraycopy(this.NGa, 0, paramArrayOfT, 0, this.NFZ);
      }
    }
  }
  
  final class b
    extends h.c<E>
  {
    private final int NGc;
    
    public b()
    {
      super();
      AppMethodBeat.i(61379);
      this.NGc = h.a(h.this);
      AppMethodBeat.o(61379);
    }
    
    protected final E gus()
    {
      AppMethodBeat.i(61380);
      Object localObject = h.b(h.this);
      AppMethodBeat.o(61380);
      return localObject;
    }
    
    protected final void gut()
    {
      AppMethodBeat.i(61381);
      if (h.c(h.this) != this.NGc)
      {
        ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException("ModCount: " + h.d(h.this) + "; expected: " + this.NGc);
        AppMethodBeat.o(61381);
        throw localConcurrentModificationException;
      }
      AppMethodBeat.o(61381);
    }
    
    public final void remove()
    {
      AppMethodBeat.i(61382);
      gut();
      h.this.clear();
      AppMethodBeat.o(61382);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.o.h
 * JD-Core Version:    0.7.0.1
 */