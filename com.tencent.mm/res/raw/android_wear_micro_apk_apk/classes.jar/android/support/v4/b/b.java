package android.support.v4.b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E>
  implements Collection<E>, Set<E>
{
  private static final int[] iR = new int[0];
  private static final Object[] iS = new Object[0];
  static Object[] iT;
  static int iU;
  static Object[] iV;
  static int iW;
  int e = 0;
  g<E, E> iP;
  final boolean iX = false;
  int[] iY = iR;
  Object[] iZ = iS;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte) {}
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (iW < 10)
        {
          paramArrayOfObject[0] = iV;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label113;
          iV = paramArrayOfObject;
          iW += 1;
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
        if (iU < 10)
        {
          paramArrayOfObject[0] = iT;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          iT = paramArrayOfObject;
          iU += 1;
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
  
  private int bi()
  {
    int m = this.e;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = c.a(this.iY, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.iZ[j] == null);
    int k = j + 1;
    while ((k < m) && (this.iY[k] == 0))
    {
      if (this.iZ[k] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.iY[j] != 0)) {
        break label115;
      }
      i = j;
      if (this.iZ[j] == null) {
        break;
      }
      j -= 1;
    }
    label115:
    return k ^ 0xFFFFFFFF;
  }
  
  private int indexOf(Object paramObject, int paramInt)
  {
    int m = this.e;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = c.a(this.iY, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.iZ[j]));
    int k = j + 1;
    while ((k < m) && (this.iY[k] == paramInt))
    {
      if (paramObject.equals(this.iZ[k])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.iY[j] != paramInt)) {
        break label150;
      }
      i = j;
      if (paramObject.equals(this.iZ[j])) {
        break;
      }
      j -= 1;
    }
    label150:
    return k ^ 0xFFFFFFFF;
  }
  
  private void q(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (iV != null)
        {
          Object[] arrayOfObject1 = iV;
          this.iZ = arrayOfObject1;
          iV = (Object[])arrayOfObject1[0];
          this.iY = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          iW -= 1;
          return;
        }
        this.iY = new int[paramInt];
        this.iZ = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (iT != null)
          {
            Object[] arrayOfObject2 = iT;
            this.iZ = arrayOfObject2;
            iT = (Object[])arrayOfObject2[0];
            this.iY = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            iU -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  public final boolean add(E paramE)
  {
    int i;
    int j;
    if (paramE == null)
    {
      i = bi();
      j = 0;
      if (i >= 0) {
        return false;
      }
    }
    else
    {
      if (this.iX) {}
      for (i = System.identityHashCode(paramE);; i = paramE.hashCode())
      {
        k = indexOf(paramE, i);
        j = i;
        i = k;
        break;
      }
    }
    int k = i ^ 0xFFFFFFFF;
    if (this.e >= this.iY.length)
    {
      if (this.e < 8) {
        break label240;
      }
      i = this.e + (this.e >> 1);
    }
    for (;;)
    {
      int[] arrayOfInt = this.iY;
      Object[] arrayOfObject = this.iZ;
      q(i);
      if (this.iY.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.iY, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.iZ, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, this.e);
      if (k < this.e)
      {
        System.arraycopy(this.iY, k, this.iY, k + 1, this.e - k);
        System.arraycopy(this.iZ, k, this.iZ, k + 1, this.e - k);
      }
      this.iY[k] = j;
      this.iZ[k] = paramE;
      this.e += 1;
      return true;
      label240:
      if (this.e >= 4) {
        i = 8;
      } else {
        i = 4;
      }
    }
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    boolean bool = false;
    int i = this.e + paramCollection.size();
    if (this.iY.length < i)
    {
      int[] arrayOfInt = this.iY;
      Object[] arrayOfObject = this.iZ;
      q(i);
      if (this.e > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.iY, 0, this.e);
        System.arraycopy(arrayOfObject, 0, this.iZ, 0, this.e);
      }
      a(arrayOfInt, arrayOfObject, this.e);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    return bool;
  }
  
  public final void clear()
  {
    if (this.e != 0)
    {
      a(this.iY, this.iZ, this.e);
      this.iY = iR;
      this.iZ = iS;
      this.e = 0;
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
          while (i < this.e)
          {
            boolean bool = paramObject.contains(this.iZ[i]);
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
    int[] arrayOfInt = this.iY;
    int k = this.e;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = arrayOfInt[j];
      j += 1;
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (paramObject == null) {
      return bi();
    }
    if (this.iX) {}
    for (int i = System.identityHashCode(paramObject);; i = paramObject.hashCode()) {
      return indexOf(paramObject, i);
    }
  }
  
  public final boolean isEmpty()
  {
    return this.e <= 0;
  }
  
  public final Iterator<E> iterator()
  {
    if (this.iP == null) {
      this.iP = new g()
      {
        protected final E a(int paramAnonymousInt, E paramAnonymousE)
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void a(E paramAnonymousE1, E paramAnonymousE2)
        {
          b.this.add(paramAnonymousE1);
        }
        
        protected final Object b(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return b.this.iZ[paramAnonymousInt1];
        }
        
        protected final int bf()
        {
          return b.this.e;
        }
        
        protected final Map<E, E> bg()
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void bh()
        {
          b.this.clear();
        }
        
        protected final int j(Object paramAnonymousObject)
        {
          return b.this.indexOf(paramAnonymousObject);
        }
        
        protected final int k(Object paramAnonymousObject)
        {
          return b.this.indexOf(paramAnonymousObject);
        }
        
        protected final void p(int paramAnonymousInt)
        {
          b.this.removeAt(paramAnonymousInt);
        }
      };
    }
    return this.iP.bk().iterator();
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
    Object localObject = this.iZ[paramInt];
    if (this.e <= 1)
    {
      a(this.iY, this.iZ, this.e);
      this.iY = iR;
      this.iZ = iS;
      this.e = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return localObject;
      if ((this.iY.length <= 8) || (this.e >= this.iY.length / 3)) {
        break;
      }
      if (this.e > 8) {
        i = this.e + (this.e >> 1);
      }
      arrayOfInt = this.iY;
      arrayOfObject = this.iZ;
      q(i);
      this.e -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.iY, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.iZ, 0, paramInt);
      }
    } while (paramInt >= this.e);
    System.arraycopy(arrayOfInt, paramInt + 1, this.iY, paramInt, this.e - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1, this.iZ, paramInt, this.e - paramInt);
    return localObject;
    this.e -= 1;
    if (paramInt < this.e)
    {
      System.arraycopy(this.iY, paramInt + 1, this.iY, paramInt, this.e - paramInt);
      System.arraycopy(this.iZ, paramInt + 1, this.iZ, paramInt, this.e - paramInt);
    }
    this.iZ[this.e] = null;
    return localObject;
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    int i = this.e - 1;
    while (i >= 0)
    {
      if (!paramCollection.contains(this.iZ[i]))
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
    return this.e;
  }
  
  public final Object[] toArray()
  {
    Object[] arrayOfObject = new Object[this.e];
    System.arraycopy(this.iZ, 0, arrayOfObject, 0, this.e);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < this.e) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.e);
    }
    for (;;)
    {
      System.arraycopy(this.iZ, 0, paramArrayOfT, 0, this.e);
      if (paramArrayOfT.length > this.e) {
        paramArrayOfT[this.e] = null;
      }
      return paramArrayOfT;
    }
  }
  
  public final String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.e * 14);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.e)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = this.iZ[i];
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
    return this.iZ[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.b
 * JD-Core Version:    0.7.0.1
 */