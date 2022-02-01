package android.support.v4.b;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class r<K, V>
{
  static Object[] lt;
  static int lu;
  static Object[] lv;
  static int lw;
  int[] kV;
  Object[] kW;
  int m;
  
  public r()
  {
    this.kV = c.kY;
    this.kW = c.la;
    this.m = 0;
  }
  
  public r(int paramInt)
  {
    if (paramInt == 0)
    {
      this.kV = c.kY;
      this.kW = c.la;
    }
    for (;;)
    {
      this.m = 0;
      return;
      A(paramInt);
    }
  }
  
  private void A(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (lv != null)
        {
          Object[] arrayOfObject1 = lv;
          this.kW = arrayOfObject1;
          lv = (Object[])arrayOfObject1[0];
          this.kV = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          lw -= 1;
          return;
        }
        this.kV = new int[paramInt];
        this.kW = new Object[paramInt << 1];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (lt != null)
          {
            Object[] arrayOfObject2 = lt;
            this.kW = arrayOfObject2;
            lt = (Object[])arrayOfObject2[0];
            this.kV = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            lu -= 1;
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
        if (lw < 10)
        {
          paramArrayOfObject[0] = lv;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label117;
          lv = paramArrayOfObject;
          lw += 1;
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
        if (lu < 10)
        {
          paramArrayOfObject[0] = lt;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          lt = paramArrayOfObject;
          lu += 1;
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
        j = b(this.kV, n, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.kW[(j << 1)] == null);
    int k = j + 1;
    while ((k < n) && (this.kV[k] == 0))
    {
      if (this.kW[(k << 1)] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.kV[j] != 0)) {
        break label121;
      }
      i = j;
      if (this.kW[(j << 1)] == null) {
        break;
      }
      j -= 1;
    }
    label121:
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
        j = b(this.kV, n, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.kW[(j << 1)]));
    int k = j + 1;
    while ((k < n) && (this.kV[k] == paramInt))
    {
      if (paramObject.equals(this.kW[(k << 1)])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.kV[j] != paramInt)) {
        break label156;
      }
      i = j;
      if (paramObject.equals(this.kW[(j << 1)])) {
        break;
      }
      j -= 1;
    }
    label156:
    return k ^ 0xFFFFFFFF;
  }
  
  public final void a(r<? extends K, ? extends V> paramr)
  {
    int i = 0;
    int j = paramr.m;
    ensureCapacity(this.m + j);
    if (this.m == 0) {
      if (j > 0)
      {
        System.arraycopy(paramr.kV, 0, this.kV, 0, j);
        System.arraycopy(paramr.kW, 0, this.kW, 0, j << 1);
        this.m = j;
      }
    }
    for (;;)
    {
      return;
      while (i < j)
      {
        put(paramr.keyAt(i), paramr.valueAt(i));
        i += 1;
      }
    }
  }
  
  public void clear()
  {
    if (this.m > 0)
    {
      int[] arrayOfInt = this.kV;
      Object[] arrayOfObject = this.kW;
      int i = this.m;
      this.kV = c.kY;
      this.kW = c.la;
      this.m = 0;
      a(arrayOfInt, arrayOfObject, i);
    }
    if (this.m > 0) {
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
    int i = this.m;
    if (this.kV.length < paramInt)
    {
      int[] arrayOfInt = this.kV;
      Object[] arrayOfObject = this.kW;
      A(paramInt);
      if (this.m > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.kV, 0, i);
        System.arraycopy(arrayOfObject, 0, this.kW, 0, i << 1);
      }
      a(arrayOfInt, arrayOfObject, i);
    }
    if (this.m != i) {
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
      if ((paramObject instanceof r))
      {
        paramObject = (r)paramObject;
        if (size() != paramObject.size()) {
          return false;
        }
        i = 0;
        try
        {
          while (i < this.m)
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
          while (i < this.m)
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
      return this.kW[((i << 1) + 1)];
    }
    return null;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.kV;
    Object[] arrayOfObject = this.kW;
    int i1 = this.m;
    int i = 1;
    int j = 0;
    int k = 0;
    if (j < i1)
    {
      Object localObject = arrayOfObject[i];
      int i2 = arrayOfInt[j];
      if (localObject == null) {}
      for (int n = 0;; n = localObject.hashCode())
      {
        k += (n ^ i2);
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
      return bz();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  final int indexOfValue(Object paramObject)
  {
    int i = 1;
    int j = 1;
    int k = this.m * 2;
    Object[] arrayOfObject = this.kW;
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
    return this.m <= 0;
  }
  
  public final K keyAt(int paramInt)
  {
    return this.kW[(paramInt << 1)];
  }
  
  public V put(K paramK, V paramV)
  {
    int k = 8;
    int n = this.m;
    int i;
    int j;
    if (paramK == null)
    {
      i = bz();
      j = 0;
    }
    while (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.kW[i];
      this.kW[i] = paramV;
      return paramK;
      j = paramK.hashCode();
      i = indexOf(paramK, j);
    }
    int i1 = i ^ 0xFFFFFFFF;
    int[] arrayOfInt;
    if (n >= this.kV.length)
    {
      if (n >= 8) {
        i = (n >> 1) + n;
      }
      Object[] arrayOfObject;
      for (;;)
      {
        arrayOfInt = this.kV;
        arrayOfObject = this.kW;
        A(i);
        if (n == this.m) {
          break;
        }
        throw new ConcurrentModificationException();
        i = k;
        if (n < 4) {
          i = 4;
        }
      }
      if (this.kV.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.kV, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.kW, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, n);
    }
    if (i1 < n)
    {
      arrayOfInt = this.kV;
      System.arraycopy(arrayOfInt, i1, arrayOfInt, i1 + 1, n - i1);
      System.arraycopy(this.kW, i1 << 1, this.kW, i1 + 1 << 1, this.m - i1 << 1);
    }
    if ((n != this.m) || (i1 >= this.kV.length)) {
      throw new ConcurrentModificationException();
    }
    this.kV[i1] = j;
    this.kW[(i1 << 1)] = paramK;
    this.kW[((i1 << 1) + 1)] = paramV;
    this.m += 1;
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
    Object localObject = this.kW[((paramInt << 1) + 1)];
    int k = this.m;
    if (k <= 1)
    {
      a(this.kV, this.kW, k);
      this.kV = c.kY;
      this.kW = c.la;
      paramInt = 0;
    }
    while (k != this.m)
    {
      throw new ConcurrentModificationException();
      int i = k - 1;
      if ((this.kV.length > 8) && (this.m < this.kV.length / 3))
      {
        if (k > 8) {
          j = (k >> 1) + k;
        }
        int[] arrayOfInt = this.kV;
        Object[] arrayOfObject = this.kW;
        A(j);
        if (k != this.m) {
          throw new ConcurrentModificationException();
        }
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.kV, 0, paramInt);
          System.arraycopy(arrayOfObject, 0, this.kW, 0, paramInt << 1);
        }
        if (paramInt < i)
        {
          System.arraycopy(arrayOfInt, paramInt + 1, this.kV, paramInt, i - paramInt);
          System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.kW, paramInt << 1, i - paramInt << 1);
        }
        paramInt = i;
      }
      else
      {
        if (paramInt < i)
        {
          System.arraycopy(this.kV, paramInt + 1, this.kV, paramInt, i - paramInt);
          System.arraycopy(this.kW, paramInt + 1 << 1, this.kW, paramInt << 1, i - paramInt << 1);
        }
        this.kW[(i << 1)] = null;
        this.kW[((i << 1) + 1)] = null;
        paramInt = i;
      }
    }
    this.m = paramInt;
    return localObject;
  }
  
  public int size()
  {
    return this.m;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.m * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.m)
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
    return this.kW[((paramInt << 1) + 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.r
 * JD-Core Version:    0.7.0.1
 */