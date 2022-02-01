package com.tencent.tinker.a.c;

public final class b
  implements Cloneable
{
  private static final int[] bGB = new int[0];
  public int[] Koy;
  public int[] Nf;
  public int mSize;
  
  public b()
  {
    this(10);
  }
  
  public b(int paramInt)
  {
    if (paramInt == 0) {
      this.Nf = bGB;
    }
    for (this.Koy = bGB;; this.Koy = new int[this.Nf.length])
    {
      this.mSize = 0;
      return;
      this.Nf = new int[paramInt];
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
  
  private static int[] c(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
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
  
  private b fHh()
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
        localb.Nf = ((int[])this.Nf.clone());
        localb.Koy = ((int[])this.Koy.clone());
        return localb;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
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
  
  public final int afv(int paramInt)
  {
    paramInt = b(this.Nf, this.mSize, paramInt);
    if (paramInt < 0) {
      return 0;
    }
    return this.Koy[paramInt];
  }
  
  public final void append(int paramInt1, int paramInt2)
  {
    if ((this.mSize != 0) && (paramInt1 <= this.Nf[(this.mSize - 1)]))
    {
      put(paramInt1, paramInt2);
      return;
    }
    this.Nf = h(this.Nf, this.mSize, paramInt1);
    this.Koy = h(this.Koy, this.mSize, paramInt2);
    this.mSize += 1;
  }
  
  public final int get(int paramInt)
  {
    return afv(paramInt);
  }
  
  public final int indexOfKey(int paramInt)
  {
    return b(this.Nf, this.mSize, paramInt);
  }
  
  public final int keyAt(int paramInt)
  {
    return this.Nf[paramInt];
  }
  
  public final void put(int paramInt1, int paramInt2)
  {
    int i = b(this.Nf, this.mSize, paramInt1);
    if (i >= 0)
    {
      this.Koy[i] = paramInt2;
      return;
    }
    i ^= 0xFFFFFFFF;
    this.Nf = c(this.Nf, this.mSize, i, paramInt1);
    this.Koy = c(this.Koy, this.mSize, i, paramInt2);
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
      localStringBuilder.append(this.Nf[i]);
      localStringBuilder.append('=');
      localStringBuilder.append(this.Koy[i]);
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