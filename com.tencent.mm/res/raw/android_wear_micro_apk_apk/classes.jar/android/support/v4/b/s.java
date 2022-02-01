package android.support.v4.b;

public final class s<E>
  implements Cloneable
{
  private static final Object lx = new Object();
  private Object[] lA;
  private boolean ly = false;
  private int[] lz;
  private int m;
  
  public s()
  {
    this(10);
  }
  
  public s(int paramInt)
  {
    if (paramInt == 0) {
      this.lz = c.kY;
    }
    for (this.lA = c.la;; this.lA = new Object[paramInt])
    {
      this.m = 0;
      return;
      paramInt = c.B(paramInt);
      this.lz = new int[paramInt];
    }
  }
  
  private s<E> bD()
  {
    try
    {
      s locals = (s)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        locals.lz = ((int[])this.lz.clone());
        locals.lA = ((Object[])this.lA.clone());
        return locals;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  private void gc()
  {
    int n = this.m;
    int[] arrayOfInt = this.lz;
    Object[] arrayOfObject = this.lA;
    int i = 0;
    int k;
    for (int j = 0; i < n; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != lx)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.ly = false;
    this.m = j;
  }
  
  public final void clear()
  {
    int j = this.m;
    Object[] arrayOfObject = this.lA;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.m = 0;
    this.ly = false;
  }
  
  public final E get(int paramInt)
  {
    paramInt = c.a(this.lz, this.m, paramInt);
    if ((paramInt < 0) || (this.lA[paramInt] == lx)) {
      return null;
    }
    return this.lA[paramInt];
  }
  
  public final int indexOfKey(int paramInt)
  {
    if (this.ly) {
      gc();
    }
    return c.a(this.lz, this.m, paramInt);
  }
  
  public final int keyAt(int paramInt)
  {
    if (this.ly) {
      gc();
    }
    return this.lz[paramInt];
  }
  
  public final void put(int paramInt, E paramE)
  {
    int i = c.a(this.lz, this.m, paramInt);
    if (i >= 0)
    {
      this.lA[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.m) && (this.lA[j] == lx))
    {
      this.lz[j] = paramInt;
      this.lA[j] = paramE;
      return;
    }
    i = j;
    if (this.ly)
    {
      i = j;
      if (this.m >= this.lz.length)
      {
        gc();
        i = c.a(this.lz, this.m, paramInt) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.m >= this.lz.length)
    {
      j = c.B(this.m + 1);
      localObject = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.lz, 0, localObject, 0, this.lz.length);
      System.arraycopy(this.lA, 0, arrayOfObject, 0, this.lA.length);
      this.lz = ((int[])localObject);
      this.lA = arrayOfObject;
    }
    if (this.m - i != 0)
    {
      localObject = this.lz;
      System.arraycopy(localObject, i, localObject, i + 1, this.m - i);
      localObject = this.lA;
      System.arraycopy(localObject, i, localObject, i + 1, this.m - i);
    }
    this.lz[i] = paramInt;
    this.lA[i] = paramE;
    this.m += 1;
  }
  
  public final void remove(int paramInt)
  {
    paramInt = c.a(this.lz, this.m, paramInt);
    if ((paramInt >= 0) && (this.lA[paramInt] != lx))
    {
      this.lA[paramInt] = lx;
      this.ly = true;
    }
  }
  
  public final int size()
  {
    if (this.ly) {
      gc();
    }
    return this.m;
  }
  
  public final String toString()
  {
    if (size() <= 0) {
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
      localStringBuilder.append(keyAt(i));
      localStringBuilder.append('=');
      Object localObject = valueAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final E valueAt(int paramInt)
  {
    if (this.ly) {
      gc();
    }
    return this.lA[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.s
 * JD-Core Version:    0.7.0.1
 */