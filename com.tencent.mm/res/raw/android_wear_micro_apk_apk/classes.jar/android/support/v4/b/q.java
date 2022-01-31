package android.support.v4.b;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class q<K, V>
{
  static Object[] jw;
  static int jx;
  static Object[] jy;
  static int jz;
  int e;
  int[] iY;
  Object[] iZ;
  
  public q()
  {
    this.iY = c.jb;
    this.iZ = c.jd;
    this.e = 0;
  }
  
  public q(int paramInt)
  {
    if (paramInt == 0)
    {
      this.iY = c.jb;
      this.iZ = c.jd;
    }
    for (;;)
    {
      this.e = 0;
      return;
      q(paramInt);
    }
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (jz < 10)
        {
          paramArrayOfObject[0] = jy;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label117;
          jy = paramArrayOfObject;
          jz += 1;
        }
        return;
      }
      finally {}
    } else {
      if (paramArrayOfInt.length != 4) {
        break label133;
      }
    }
    for (;;)
    {
      try
      {
        if (jx < 10)
        {
          paramArrayOfObject[0] = jw;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          jw = paramArrayOfObject;
          jx += 1;
        }
        return;
      }
      finally {}
      label117:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label133:
      return;
      label134:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = c.a(paramArrayOfInt, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      throw new ConcurrentModificationException();
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
        j = b(this.iY, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.iZ[(j << 1)] == null);
    int k = j + 1;
    while ((k < m) && (this.iY[k] == 0))
    {
      if (this.iZ[(k << 1)] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.iY[j] != 0)) {
        break label121;
      }
      i = j;
      if (this.iZ[(j << 1)] == null) {
        break;
      }
      j -= 1;
    }
    label121:
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
        j = b(this.iY, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.iZ[(j << 1)]));
    int k = j + 1;
    while ((k < m) && (this.iY[k] == paramInt))
    {
      if (paramObject.equals(this.iZ[(k << 1)])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.iY[j] != paramInt)) {
        break label156;
      }
      i = j;
      if (paramObject.equals(this.iZ[(j << 1)])) {
        break;
      }
      j -= 1;
    }
    label156:
    return k ^ 0xFFFFFFFF;
  }
  
  private void q(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (jy != null)
        {
          Object[] arrayOfObject1 = jy;
          this.iZ = arrayOfObject1;
          jy = (Object[])arrayOfObject1[0];
          this.iY = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          jz -= 1;
          return;
        }
        this.iY = new int[paramInt];
        this.iZ = new Object[paramInt << 1];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (jw != null)
          {
            Object[] arrayOfObject2 = jw;
            this.iZ = arrayOfObject2;
            jw = (Object[])arrayOfObject2[0];
            this.iY = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            jx -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  public final void b(q<? extends K, ? extends V> paramq)
  {
    int i = 0;
    int j = paramq.e;
    ensureCapacity(this.e + j);
    if (this.e == 0) {
      if (j > 0)
      {
        System.arraycopy(paramq.iY, 0, this.iY, 0, j);
        System.arraycopy(paramq.iZ, 0, this.iZ, 0, j << 1);
        this.e = j;
      }
    }
    for (;;)
    {
      return;
      while (i < j)
      {
        put(paramq.keyAt(i), paramq.valueAt(i));
        i += 1;
      }
    }
  }
  
  public void clear()
  {
    if (this.e > 0)
    {
      int[] arrayOfInt = this.iY;
      Object[] arrayOfObject = this.iZ;
      int i = this.e;
      this.iY = c.jb;
      this.iZ = c.jd;
      this.e = 0;
      a(arrayOfInt, arrayOfObject, i);
    }
    if (this.e > 0) {
      throw new ConcurrentModificationException();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    return indexOfKey(paramObject) >= 0;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return indexOfValue(paramObject) >= 0;
  }
  
  public final void ensureCapacity(int paramInt)
  {
    int i = this.e;
    if (this.iY.length < paramInt)
    {
      int[] arrayOfInt = this.iY;
      Object[] arrayOfObject = this.iZ;
      q(paramInt);
      if (this.e > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.iY, 0, i);
        System.arraycopy(arrayOfObject, 0, this.iZ, 0, i << 1);
      }
      a(arrayOfInt, arrayOfObject, i);
    }
    if (this.e != i) {
      throw new ConcurrentModificationException();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      int i;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      boolean bool;
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if (size() != paramObject.size()) {
          return false;
        }
        i = 0;
        try
        {
          while (i < this.e)
          {
            localObject1 = keyAt(i);
            localObject2 = valueAt(i);
            localObject3 = paramObject.get(localObject1);
            if (localObject2 == null)
            {
              if (localObject3 != null) {
                break label227;
              }
              if (!paramObject.containsKey(localObject1)) {
                break label227;
              }
            }
            else
            {
              bool = localObject2.equals(localObject3);
              if (!bool) {
                return false;
              }
            }
            i += 1;
          }
          if (!(paramObject instanceof Map)) {
            break;
          }
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
      else
      {
        paramObject = (Map)paramObject;
        if (size() != paramObject.size()) {
          return false;
        }
        i = 0;
        try
        {
          while (i < this.e)
          {
            localObject1 = keyAt(i);
            localObject2 = valueAt(i);
            localObject3 = paramObject.get(localObject1);
            if (localObject2 == null)
            {
              if (localObject3 != null) {
                break label229;
              }
              if (!paramObject.containsKey(localObject1)) {
                break label229;
              }
            }
            else
            {
              bool = localObject2.equals(localObject3);
              if (!bool) {
                return false;
              }
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
    label227:
    return false;
    label229:
    return false;
  }
  
  public V get(Object paramObject)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0) {
      return this.iZ[((i << 1) + 1)];
    }
    return null;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.iY;
    Object[] arrayOfObject = this.iZ;
    int n = this.e;
    int i = 1;
    int j = 0;
    int k = 0;
    if (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      if (localObject == null) {}
      for (int m = 0;; m = localObject.hashCode())
      {
        k += (m ^ i1);
        j += 1;
        i += 2;
        break;
      }
    }
    return k;
  }
  
  public final int indexOfKey(Object paramObject)
  {
    if (paramObject == null) {
      return bi();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  final int indexOfValue(Object paramObject)
  {
    int i = 1;
    int j = 1;
    int k = this.e * 2;
    Object[] arrayOfObject = this.iZ;
    if (paramObject == null)
    {
      i = j;
      while (i < k)
      {
        if (arrayOfObject[i] == null) {
          return i >> 1;
        }
        i += 2;
      }
    }
    do
    {
      i += 2;
      if (i >= k) {
        break;
      }
    } while (!paramObject.equals(arrayOfObject[i]));
    return i >> 1;
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.e <= 0;
  }
  
  public final K keyAt(int paramInt)
  {
    return this.iZ[(paramInt << 1)];
  }
  
  public V put(K paramK, V paramV)
  {
    int k = 8;
    int m = this.e;
    int i;
    int j;
    if (paramK == null)
    {
      i = bi();
      j = 0;
    }
    while (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.iZ[i];
      this.iZ[i] = paramV;
      return paramK;
      j = paramK.hashCode();
      i = indexOf(paramK, j);
    }
    int n = i ^ 0xFFFFFFFF;
    if (m >= this.iY.length)
    {
      if (m >= 8) {
        i = (m >> 1) + m;
      }
      int[] arrayOfInt;
      Object[] arrayOfObject;
      for (;;)
      {
        arrayOfInt = this.iY;
        arrayOfObject = this.iZ;
        q(i);
        if (m == this.e) {
          break;
        }
        throw new ConcurrentModificationException();
        i = k;
        if (m < 4) {
          i = 4;
        }
      }
      if (this.iY.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.iY, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.iZ, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, m);
    }
    if (n < m)
    {
      System.arraycopy(this.iY, n, this.iY, n + 1, m - n);
      System.arraycopy(this.iZ, n << 1, this.iZ, n + 1 << 1, this.e - n << 1);
    }
    if ((m != this.e) || (n >= this.iY.length)) {
      throw new ConcurrentModificationException();
    }
    this.iY[n] = j;
    this.iZ[(n << 1)] = paramK;
    this.iZ[((n << 1) + 1)] = paramV;
    this.e += 1;
    return null;
  }
  
  public V remove(Object paramObject)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0) {
      return removeAt(i);
    }
    return null;
  }
  
  public final V removeAt(int paramInt)
  {
    int j = 8;
    Object localObject = this.iZ[((paramInt << 1) + 1)];
    int k = this.e;
    if (k <= 1)
    {
      a(this.iY, this.iZ, k);
      this.iY = c.jb;
      this.iZ = c.jd;
      paramInt = 0;
    }
    while (k != this.e)
    {
      throw new ConcurrentModificationException();
      int i = k - 1;
      if ((this.iY.length > 8) && (this.e < this.iY.length / 3))
      {
        if (k > 8) {
          j = (k >> 1) + k;
        }
        int[] arrayOfInt = this.iY;
        Object[] arrayOfObject = this.iZ;
        q(j);
        if (k != this.e) {
          throw new ConcurrentModificationException();
        }
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.iY, 0, paramInt);
          System.arraycopy(arrayOfObject, 0, this.iZ, 0, paramInt << 1);
        }
        if (paramInt < i)
        {
          System.arraycopy(arrayOfInt, paramInt + 1, this.iY, paramInt, i - paramInt);
          System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.iZ, paramInt << 1, i - paramInt << 1);
        }
        paramInt = i;
      }
      else
      {
        if (paramInt < i)
        {
          System.arraycopy(this.iY, paramInt + 1, this.iY, paramInt, i - paramInt);
          System.arraycopy(this.iZ, paramInt + 1 << 1, this.iZ, paramInt << 1, i - paramInt << 1);
        }
        this.iZ[(i << 1)] = null;
        this.iZ[((i << 1) + 1)] = null;
        paramInt = i;
      }
    }
    this.e = paramInt;
    return localObject;
  }
  
  public int size()
  {
    return this.e;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.e * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.e)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = keyAt(i);
      if (localObject != this)
      {
        localStringBuilder.append(localObject);
        label70:
        localStringBuilder.append('=');
        localObject = valueAt(i);
        if (localObject == this) {
          break label111;
        }
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
        break label70;
        label111:
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final V valueAt(int paramInt)
  {
    return this.iZ[((paramInt << 1) + 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.q
 * JD-Core Version:    0.7.0.1
 */