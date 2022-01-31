package android.support.v4.b;

public final class r<E>
  implements Cloneable
{
  private static final Object jA = new Object();
  private int e;
  private boolean jB = false;
  private int[] jC;
  private Object[] jD;
  
  public r()
  {
    this(10);
  }
  
  public r(int paramInt)
  {
    if (paramInt == 0) {
      this.jC = c.jb;
    }
    for (this.jD = c.jd;; this.jD = new Object[paramInt])
    {
      this.e = 0;
      return;
      paramInt = c.r(paramInt);
      this.jC = new int[paramInt];
    }
  }
  
  private r<E> bm()
  {
    try
    {
      r localr = (r)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        localr.jC = ((int[])this.jC.clone());
        localr.jD = ((Object[])this.jD.clone());
        return localr;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  private void gc()
  {
    int m = this.e;
    int[] arrayOfInt = this.jC;
    Object[] arrayOfObject = this.jD;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != jA)
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
    this.jB = false;
    this.e = j;
  }
  
  public final void clear()
  {
    int j = this.e;
    Object[] arrayOfObject = this.jD;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.e = 0;
    this.jB = false;
  }
  
  public final E get(int paramInt)
  {
    paramInt = c.a(this.jC, this.e, paramInt);
    if ((paramInt < 0) || (this.jD[paramInt] == jA)) {
      return null;
    }
    return this.jD[paramInt];
  }
  
  public final int indexOfKey(int paramInt)
  {
    if (this.jB) {
      gc();
    }
    return c.a(this.jC, this.e, paramInt);
  }
  
  public final int keyAt(int paramInt)
  {
    if (this.jB) {
      gc();
    }
    return this.jC[paramInt];
  }
  
  public final void put(int paramInt, E paramE)
  {
    int i = c.a(this.jC, this.e, paramInt);
    if (i >= 0)
    {
      this.jD[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.e) && (this.jD[j] == jA))
    {
      this.jC[j] = paramInt;
      this.jD[j] = paramE;
      return;
    }
    i = j;
    if (this.jB)
    {
      i = j;
      if (this.e >= this.jC.length)
      {
        gc();
        i = c.a(this.jC, this.e, paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (this.e >= this.jC.length)
    {
      j = c.r(this.e + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.jC, 0, arrayOfInt, 0, this.jC.length);
      System.arraycopy(this.jD, 0, arrayOfObject, 0, this.jD.length);
      this.jC = arrayOfInt;
      this.jD = arrayOfObject;
    }
    if (this.e - i != 0)
    {
      System.arraycopy(this.jC, i, this.jC, i + 1, this.e - i);
      System.arraycopy(this.jD, i, this.jD, i + 1, this.e - i);
    }
    this.jC[i] = paramInt;
    this.jD[i] = paramE;
    this.e += 1;
  }
  
  public final void remove(int paramInt)
  {
    paramInt = c.a(this.jC, this.e, paramInt);
    if ((paramInt >= 0) && (this.jD[paramInt] != jA))
    {
      this.jD[paramInt] = jA;
      this.jB = true;
    }
  }
  
  public final int size()
  {
    if (this.jB) {
      gc();
    }
    return this.e;
  }
  
  public final String toString()
  {
    if (size() <= 0) {
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
    if (this.jB) {
      gc();
    }
    return this.jD[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.r
 * JD-Core Version:    0.7.0.1
 */