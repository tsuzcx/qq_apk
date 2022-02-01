package kotlin.l.b.a.b.o;

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
  private int abuy;
  private Object abuz;
  
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(61385);
    if ((paramInt < 0) || (paramInt > this.abuy))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.abuy);
      AppMethodBeat.o(61385);
      throw paramE;
    }
    if (this.abuy == 0) {}
    for (this.abuz = paramE;; this.abuz = new Object[] { paramE, this.abuz })
    {
      this.abuy += 1;
      this.modCount += 1;
      AppMethodBeat.o(61385);
      return;
      if ((this.abuy != 1) || (paramInt != 0)) {
        break;
      }
    }
    Object[] arrayOfObject1 = new Object[this.abuy + 1];
    if (this.abuy == 1) {
      arrayOfObject1[0] = this.abuz;
    }
    for (;;)
    {
      arrayOfObject1[paramInt] = paramE;
      this.abuz = arrayOfObject1;
      break;
      Object[] arrayOfObject2 = (Object[])this.abuz;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, paramInt);
      System.arraycopy(arrayOfObject2, paramInt, arrayOfObject1, paramInt + 1, this.abuy - paramInt);
    }
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(61384);
    if (this.abuy == 0) {}
    for (this.abuz = paramE;; this.abuz = new Object[] { this.abuz, paramE })
    {
      this.abuy += 1;
      this.modCount += 1;
      AppMethodBeat.o(61384);
      return true;
      if (this.abuy != 1) {
        break;
      }
    }
    Object[] arrayOfObject2 = (Object[])this.abuz;
    int k = arrayOfObject2.length;
    Object[] arrayOfObject1 = arrayOfObject2;
    int i;
    if (this.abuy >= k)
    {
      i = k * 3 / 2 + 1;
      int j = this.abuy + 1;
      if (i >= j) {
        break label161;
      }
      i = j;
    }
    label161:
    for (;;)
    {
      arrayOfObject1 = new Object[i];
      this.abuz = arrayOfObject1;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, k);
      arrayOfObject1[this.abuy] = paramE;
      break;
    }
  }
  
  public final void clear()
  {
    this.abuz = null;
    this.abuy = 0;
    this.modCount += 1;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(61383);
    if ((paramInt < 0) || (paramInt >= this.abuy))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.abuy);
      AppMethodBeat.o(61383);
      throw ((Throwable)localObject);
    }
    if (this.abuy == 1)
    {
      localObject = this.abuz;
      AppMethodBeat.o(61383);
      return localObject;
    }
    Object localObject = ((Object[])(Object[])this.abuz)[paramInt];
    AppMethodBeat.o(61383);
    return localObject;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(61388);
    if (this.abuy == 0)
    {
      localObject = h.a.iQn();
      if (localObject == null) {
        aDG(2);
      }
      AppMethodBeat.o(61388);
      return localObject;
    }
    if (this.abuy == 1)
    {
      localObject = new b();
      AppMethodBeat.o(61388);
      return localObject;
    }
    Object localObject = super.iterator();
    if (localObject == null) {
      aDG(3);
    }
    AppMethodBeat.o(61388);
    return localObject;
  }
  
  public final E remove(int paramInt)
  {
    AppMethodBeat.i(61387);
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.abuy))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.abuy);
      AppMethodBeat.o(61387);
      throw ((Throwable)localObject);
    }
    if (this.abuy == 1)
    {
      localObject = this.abuz;
      this.abuz = null;
    }
    for (;;)
    {
      this.abuy -= 1;
      this.modCount += 1;
      AppMethodBeat.o(61387);
      return localObject;
      Object[] arrayOfObject = (Object[])this.abuz;
      localObject = arrayOfObject[paramInt];
      if (this.abuy == 2)
      {
        this.abuz = arrayOfObject[(1 - paramInt)];
      }
      else
      {
        int i = this.abuy - paramInt - 1;
        if (i > 0) {
          System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i);
        }
        arrayOfObject[(this.abuy - 1)] = null;
      }
    }
  }
  
  public final E set(int paramInt, E paramE)
  {
    AppMethodBeat.i(61386);
    if ((paramInt < 0) || (paramInt >= this.abuy))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.abuy);
      AppMethodBeat.o(61386);
      throw paramE;
    }
    Object localObject;
    if (this.abuy == 1)
    {
      localObject = this.abuz;
      this.abuz = paramE;
    }
    for (paramE = localObject;; paramE = localObject)
    {
      AppMethodBeat.o(61386);
      return paramE;
      Object[] arrayOfObject = (Object[])this.abuz;
      localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramE;
    }
  }
  
  public final int size()
  {
    return this.abuy;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(61389);
    if (paramArrayOfT == null) {
      aDG(4);
    }
    int i = paramArrayOfT.length;
    if (this.abuy == 1) {
      if (i != 0) {
        paramArrayOfT[0] = this.abuz;
      }
    }
    for (;;)
    {
      if (i > this.abuy) {
        paramArrayOfT[this.abuy] = null;
      }
      if (paramArrayOfT == null) {
        aDG(7);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 1);
      paramArrayOfT[0] = this.abuz;
      if (paramArrayOfT == null) {
        aDG(5);
      }
      AppMethodBeat.o(61389);
      return paramArrayOfT;
      if (i < this.abuy)
      {
        paramArrayOfT = (Object[])Arrays.copyOf((Object[])this.abuz, this.abuy, paramArrayOfT.getClass());
        if (paramArrayOfT == null) {
          aDG(6);
        }
        AppMethodBeat.o(61389);
        return paramArrayOfT;
      }
      if (this.abuy != 0) {
        System.arraycopy(this.abuz, 0, paramArrayOfT, 0, this.abuy);
      }
    }
  }
  
  final class b
    extends h.c<E>
  {
    private final int abuB;
    
    public b()
    {
      super();
      AppMethodBeat.i(61379);
      this.abuB = h.a(h.this);
      AppMethodBeat.o(61379);
    }
    
    protected final E iQo()
    {
      AppMethodBeat.i(61380);
      Object localObject = h.b(h.this);
      AppMethodBeat.o(61380);
      return localObject;
    }
    
    protected final void iQp()
    {
      AppMethodBeat.i(61381);
      if (h.c(h.this) != this.abuB)
      {
        ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException("ModCount: " + h.d(h.this) + "; expected: " + this.abuB);
        AppMethodBeat.o(61381);
        throw localConcurrentModificationException;
      }
      AppMethodBeat.o(61381);
    }
    
    public final void remove()
    {
      AppMethodBeat.i(61382);
      iQp();
      h.this.clear();
      AppMethodBeat.o(61382);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.o.h
 * JD-Core Version:    0.7.0.1
 */