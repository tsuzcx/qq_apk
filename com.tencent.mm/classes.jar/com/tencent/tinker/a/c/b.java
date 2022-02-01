package com.tencent.tinker.a.c;

public final class b
  implements Cloneable
{
  private static final int[] bYn = new int[0];
  public int[] Pi;
  public int[] Shv;
  public int mSize;
  
  public b()
  {
    this(10);
  }
  
  public b(int paramInt)
  {
    if (paramInt == 0) {
      this.Pi = bYn;
    }
    for (this.Shv = bYn;; this.Shv = new int[this.Pi.length])
    {
      this.mSize = 0;
      return;
      this.Pi = new int[paramInt];
    }
  }
  
  private static int av(int paramInt)
  {
    if (paramInt <= 4) {
      return 8;
    }
    return (paramInt >> 1) + paramInt;
  }
  
  private static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
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
    int[] arrayOfInt = new int[av(paramInt1)];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt2);
    arrayOfInt[paramInt2] = paramInt3;
    System.arraycopy(paramArrayOfInt, paramInt2, arrayOfInt, paramInt2 + 1, paramArrayOfInt.length - paramInt2);
    return arrayOfInt;
  }
  
  private static int[] h(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramArrayOfInt.length) {
      throw new IllegalArgumentException("Bad currentSize, originalSize: " + paramArrayOfInt.length + " currentSize: " + paramInt1);
    }
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 + 1 > paramArrayOfInt.length)
    {
      arrayOfInt = new int[av(paramInt1)];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt1);
    }
    arrayOfInt[paramInt1] = paramInt2;
    return arrayOfInt;
  }
  
  private b hpa()
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
        localb.Pi = ((int[])this.Pi.clone());
        localb.Shv = ((int[])this.Shv.clone());
        return localb;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public final void append(int paramInt1, int paramInt2)
  {
    if ((this.mSize != 0) && (paramInt1 <= this.Pi[(this.mSize - 1)]))
    {
      put(paramInt1, paramInt2);
      return;
    }
    this.Pi = h(this.Pi, this.mSize, paramInt1);
    this.Shv = h(this.Shv, this.mSize, paramInt2);
    this.mSize += 1;
  }
  
  public final int ase(int paramInt)
  {
    paramInt = b(this.Pi, this.mSize, paramInt);
    if (paramInt < 0) {
      return 0;
    }
    return this.Shv[paramInt];
  }
  
  public final int get(int paramInt)
  {
    return ase(paramInt);
  }
  
  public final int indexOfKey(int paramInt)
  {
    return b(this.Pi, this.mSize, paramInt);
  }
  
  public final int keyAt(int paramInt)
  {
    return this.Pi[paramInt];
  }
  
  public final void put(int paramInt1, int paramInt2)
  {
    int i = b(this.Pi, this.mSize, paramInt1);
    if (i >= 0)
    {
      this.Shv[i] = paramInt2;
      return;
    }
    i ^= 0xFFFFFFFF;
    this.Pi = b(this.Pi, this.mSize, i, paramInt1);
    this.Shv = b(this.Shv, this.mSize, i, paramInt2);
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
      localStringBuilder.append(this.Pi[i]);
      localStringBuilder.append('=');
      localStringBuilder.append(this.Shv[i]);
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.c.b
 * JD-Core Version:    0.7.0.1
 */