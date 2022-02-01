package com.tencent.tinker.a.c;

public final class b
  implements Cloneable
{
  private static final int[] bZR = new int[0];
  public int[] ZKg;
  public int mSize;
  private int[] zX;
  
  public b()
  {
    this(10);
  }
  
  public b(int paramInt)
  {
    if (paramInt == 0) {
      this.zX = bZR;
    }
    for (this.ZKg = bZR;; this.ZKg = new int[this.zX.length])
    {
      this.mSize = 0;
      return;
      this.zX = new int[paramInt];
    }
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramInt1 - 1;
    paramInt1 = 0;
    while (paramInt1 <= i)
    {
      int j = paramInt1 + i >>> 1;
      int k = paramArrayOfInt[j];
      if (k < paramInt2)
      {
        paramInt1 = j + 1;
      }
      else
      {
        i = j;
        if (k <= paramInt2) {
          return i;
        }
        i = j - 1;
      }
    }
    i = paramInt1 ^ 0xFFFFFFFF;
    return i;
  }
  
  private static int[] b(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramArrayOfInt.length) {
      throw new IllegalArgumentException("Bad currentSize, originalSize: " + paramArrayOfInt.length + " currentSize: " + paramInt1);
    }
    if (paramInt1 + 1 <= paramArrayOfInt.length)
    {
      System.arraycopy(paramArrayOfInt, paramInt2, paramArrayOfInt, paramInt2 + 1, paramInt1 - paramInt2);
      paramArrayOfInt[paramInt2] = paramInt3;
      return paramArrayOfInt;
    }
    int[] arrayOfInt = new int[bq(paramInt1)];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt2);
    arrayOfInt[paramInt2] = paramInt3;
    System.arraycopy(paramArrayOfInt, paramInt2, arrayOfInt, paramInt2 + 1, paramArrayOfInt.length - paramInt2);
    return arrayOfInt;
  }
  
  private static int bq(int paramInt)
  {
    if (paramInt <= 4) {
      return 8;
    }
    return (paramInt >> 1) + paramInt;
  }
  
  private static int[] g(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramArrayOfInt.length) {
      throw new IllegalArgumentException("Bad currentSize, originalSize: " + paramArrayOfInt.length + " currentSize: " + paramInt1);
    }
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 + 1 > paramArrayOfInt.length)
    {
      arrayOfInt = new int[bq(paramInt1)];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt1);
    }
    arrayOfInt[paramInt1] = paramInt2;
    return arrayOfInt;
  }
  
  private b isB()
  {
    try
    {
      b localb = (b)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        localb.zX = ((int[])this.zX.clone());
        localb.ZKg = ((int[])this.ZKg.clone());
        return localb;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public final int aP(int paramInt)
  {
    return this.zX[paramInt];
  }
  
  public final int aQ(int paramInt)
  {
    return a(this.zX, this.mSize, paramInt);
  }
  
  public final void clear()
  {
    this.mSize = 0;
  }
  
  public final int get(int paramInt)
  {
    paramInt = a(this.zX, this.mSize, paramInt);
    if (paramInt < 0) {
      return 0;
    }
    return this.ZKg[paramInt];
  }
  
  public final boolean iM(int paramInt)
  {
    return aQ(paramInt) >= 0;
  }
  
  public final void oa(int paramInt1, int paramInt2)
  {
    if ((this.mSize != 0) && (paramInt1 <= this.zX[(this.mSize - 1)]))
    {
      put(paramInt1, paramInt2);
      return;
    }
    this.zX = g(this.zX, this.mSize, paramInt1);
    this.ZKg = g(this.ZKg, this.mSize, paramInt2);
    this.mSize += 1;
  }
  
  public final void put(int paramInt1, int paramInt2)
  {
    int i = a(this.zX, this.mSize, paramInt1);
    if (i >= 0)
    {
      this.ZKg[i] = paramInt2;
      return;
    }
    i ^= 0xFFFFFFFF;
    this.zX = b(this.zX, this.mSize, i, paramInt1);
    this.ZKg = b(this.ZKg, this.mSize, i, paramInt2);
    this.mSize += 1;
  }
  
  public final int size()
  {
    return this.mSize;
  }
  
  public final String toString()
  {
    if (this.mSize <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.mSize * 28);
    localStringBuilder.append('{');
    int i = 0;
    while (i < this.mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(this.zX[i]);
      localStringBuilder.append('=');
      localStringBuilder.append(this.ZKg[i]);
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.c.b
 * JD-Core Version:    0.7.0.1
 */