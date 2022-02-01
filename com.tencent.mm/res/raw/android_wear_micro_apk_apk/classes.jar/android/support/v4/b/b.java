package android.support.v4.b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E>
  implements Collection<E>, Set<E>
{
  private static final int[] kP = new int[0];
  private static final Object[] kQ = new Object[0];
  private static Object[] kR;
  private static int kS;
  private static Object[] kT;
  private static int kU;
  private g<E, E> kN;
  private int[] kV = kP;
  private Object[] kW = kQ;
  private int m = 0;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte) {}
  
  private void A(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (kT != null)
        {
          Object[] arrayOfObject1 = kT;
          this.kW = arrayOfObject1;
          kT = (Object[])arrayOfObject1[0];
          this.kV = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          kU -= 1;
          return;
        }
        this.kV = new int[paramInt];
        this.kW = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (kR != null)
          {
            Object[] arrayOfObject2 = kR;
            this.kW = arrayOfObject2;
            kR = (Object[])arrayOfObject2[0];
            this.kV = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            kS -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (kU < 10)
        {
          paramArrayOfObject[0] = kT;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label113;
          kT = paramArrayOfObject;
          kU += 1;
        }
        return;
      }
      finally {}
    } else {
      if (paramArrayOfInt.length != 4) {
        break label129;
      }
    }
    for (;;)
    {
      try
      {
        if (kS < 10)
        {
          paramArrayOfObject[0] = kR;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          kR = paramArrayOfObject;
          kS += 1;
        }
        return;
      }
      finally {}
      label113:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label129:
      return;
      label130:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private int bz()
  {
    int n = this.m;
    int i;
    if (n == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = c.a(this.kV, n, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.kW[j] == null);
    int k = j + 1;
    while ((k < n) && (this.kV[k] == 0))
    {
      if (this.kW[k] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.kV[j] != 0)) {
        break label115;
      }
      i = j;
      if (this.kW[j] == null) {
        break;
      }
      j -= 1;
    }
    label115:
    return k ^ 0xFFFFFFFF;
  }
  
  private int indexOf(Object paramObject, int paramInt)
  {
    int n = this.m;
    int i;
    if (n == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = c.a(this.kV, n, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.kW[j]));
    int k = j + 1;
    while ((k < n) && (this.kV[k] == paramInt))
    {
      if (paramObject.equals(this.kW[k])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.kV[j] != paramInt)) {
        break label150;
      }
      i = j;
      if (paramObject.equals(this.kW[j])) {
        break;
      }
      j -= 1;
    }
    label150:
    return k ^ 0xFFFFFFFF;
  }
  
  public final boolean add(E paramE)
  {
    int k = 8;
    int i;
    int j;
    if (paramE == null)
    {
      i = bz();
      j = 0;
    }
    while (i >= 0)
    {
      return false;
      j = paramE.hashCode();
      i = indexOf(paramE, j);
    }
    int n = i ^ 0xFFFFFFFF;
    if (this.m >= this.kV.length)
    {
      if (this.m < 8) {
        break label227;
      }
      i = this.m + (this.m >> 1);
    }
    for (;;)
    {
      Object localObject = this.kV;
      Object[] arrayOfObject = this.kW;
      A(i);
      if (this.kV.length > 0)
      {
        System.arraycopy(localObject, 0, this.kV, 0, localObject.length);
        System.arraycopy(arrayOfObject, 0, this.kW, 0, arrayOfObject.length);
      }
      a((int[])localObject, arrayOfObject, this.m);
      if (n < this.m)
      {
        localObject = this.kV;
        System.arraycopy(localObject, n, localObject, n + 1, this.m - n);
        localObject = this.kW;
        System.arraycopy(localObject, n, localObject, n + 1, this.m - n);
      }
      this.kV[n] = j;
      this.kW[n] = paramE;
      this.m += 1;
      return true;
      label227:
      i = k;
      if (this.m < 4) {
        i = 4;
      }
    }
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    boolean bool = false;
    int i = this.m + paramCollection.size();
    if (this.kV.length < i)
    {
      int[] arrayOfInt = this.kV;
      Object[] arrayOfObject = this.kW;
      A(i);
      if (this.m > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.kV, 0, this.m);
        System.arraycopy(arrayOfObject, 0, this.kW, 0, this.m);
      }
      a(arrayOfInt, arrayOfObject, this.m);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    return bool;
  }
  
  public final void clear()
  {
    if (this.m != 0)
    {
      a(this.kV, this.kW, this.m);
      this.kV = kP;
      this.kW = kQ;
      this.m = 0;
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public final boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof Set))
      {
        paramObject = (Set)paramObject;
        if (size() != paramObject.size()) {
          return false;
        }
        int i = 0;
        try
        {
          while (i < this.m)
          {
            boolean bool = paramObject.contains(this.kW[i]);
            if (!bool) {
              return false;
            }
            i += 1;
          }
          return false;
        }
        catch (NullPointerException paramObject)
        {
          return false;
        }
        catch (ClassCastException paramObject)
        {
          return false;
        }
      }
    }
  }
  
  public final int hashCode()
  {
    int[] arrayOfInt = this.kV;
    int k = this.m;
    int j = 0;
    int n;
    for (int i = 0; j < k; i = n + i)
    {
      n = arrayOfInt[j];
      j += 1;
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (paramObject == null) {
      return bz();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  public final boolean isEmpty()
  {
    return this.m <= 0;
  }
  
  public final Iterator<E> iterator()
  {
    if (this.kN == null) {
      this.kN = new g()
      {
        protected final E a(int paramAnonymousInt, E paramAnonymousE)
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final Object b(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return b.d(b.this)[paramAnonymousInt1];
        }
        
        protected final void b(E paramAnonymousE1, E paramAnonymousE2)
        {
          b.this.add(paramAnonymousE1);
        }
        
        protected final int bw()
        {
          return b.c(b.this);
        }
        
        protected final Map<E, E> bx()
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void by()
        {
          b.this.clear();
        }
        
        protected final int q(Object paramAnonymousObject)
        {
          return b.this.indexOf(paramAnonymousObject);
        }
        
        protected final int r(Object paramAnonymousObject)
        {
          return b.this.indexOf(paramAnonymousObject);
        }
        
        protected final void z(int paramAnonymousInt)
        {
          b.this.removeAt(paramAnonymousInt);
        }
      };
    }
    return this.kN.bB().iterator();
  }
  
  public final boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      removeAt(i);
      return true;
    }
    return false;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    return bool;
  }
  
  public final E removeAt(int paramInt)
  {
    int i = 8;
    Object localObject = this.kW[paramInt];
    if (this.m <= 1)
    {
      a(this.kV, this.kW, this.m);
      this.kV = kP;
      this.kW = kQ;
      this.m = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return localObject;
      if ((this.kV.length <= 8) || (this.m >= this.kV.length / 3)) {
        break;
      }
      if (this.m > 8) {
        i = this.m + (this.m >> 1);
      }
      arrayOfInt = this.kV;
      arrayOfObject = this.kW;
      A(i);
      this.m -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.kV, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.kW, 0, paramInt);
      }
    } while (paramInt >= this.m);
    System.arraycopy(arrayOfInt, paramInt + 1, this.kV, paramInt, this.m - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1, this.kW, paramInt, this.m - paramInt);
    return localObject;
    this.m -= 1;
    if (paramInt < this.m)
    {
      System.arraycopy(this.kV, paramInt + 1, this.kV, paramInt, this.m - paramInt);
      System.arraycopy(this.kW, paramInt + 1, this.kW, paramInt, this.m - paramInt);
    }
    this.kW[this.m] = null;
    return localObject;
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    int i = this.m - 1;
    while (i >= 0)
    {
      if (!paramCollection.contains(this.kW[i]))
      {
        removeAt(i);
        bool = true;
      }
      i -= 1;
    }
    return bool;
  }
  
  public final int size()
  {
    return this.m;
  }
  
  public final Object[] toArray()
  {
    Object[] arrayOfObject = new Object[this.m];
    System.arraycopy(this.kW, 0, arrayOfObject, 0, this.m);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < this.m) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.m);
    }
    for (;;)
    {
      System.arraycopy(this.kW, 0, paramArrayOfT, 0, this.m);
      if (paramArrayOfT.length > this.m) {
        paramArrayOfT[this.m] = null;
      }
      return paramArrayOfT;
    }
  }
  
  public final String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.m * 14);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.m)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = this.kW[i];
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Set)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final E valueAt(int paramInt)
  {
    return this.kW[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.b
 * JD-Core Version:    0.7.0.1
 */