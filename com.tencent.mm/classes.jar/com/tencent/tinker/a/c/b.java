package com.tencent.tinker.a.c;

public final class b
  implements Cloneable
{
  private static final int[] bgZ = new int[0];
  public int[] Bqu = new int[this.Fk.length];
  public int[] Fk = new int[10];
  public int mSize = 0;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte) {}
  
  private static int ad(int paramInt)
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
    int[] arrayOfInt = new int[ad(paramInt1)];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt2);
    arrayOfInt[paramInt2] = paramInt3;
    System.arraycopy(paramArrayOfInt, paramInt2, arrayOfInt, paramInt2 + 1, paramArrayOfInt.length - paramInt2);
    return arrayOfInt;
  }
  
  private b dWu()
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
        localb.Fk = ((int[])this.Fk.clone());
        localb.Bqu = ((int[])this.Bqu.clone());
        return localb;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public static int[] h(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramArrayOfInt.length) {
      throw new IllegalArgumentException("Bad currentSize, originalSize: " + paramArrayOfInt.length + " currentSize: " + paramInt1);
    }
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 + 1 > paramArrayOfInt.length)
    {
      arrayOfInt = new int[ad(paramInt1)];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt1);
    }
    arrayOfInt[paramInt1] = paramInt2;
    return arrayOfInt;
  }
  
  public final int indexOfKey(int paramInt)
  {
    return b(this.Fk, this.mSize, paramInt);
  }
  
  public final void put(int paramInt1, int paramInt2)
  {
    int i = b(this.Fk, this.mSize, paramInt1);
    if (i >= 0)
    {
      this.Bqu[i] = paramInt2;
      return;
    }
    i ^= 0xFFFFFFFF;
    this.Fk = c(this.Fk, this.mSize, i, paramInt1);
    this.Bqu = c(this.Bqu, this.mSize, i, paramInt2);
    this.mSize += 1;
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
      localStringBuilder.append(this.Fk[i]);
      localStringBuilder.append('=');
      localStringBuilder.append(this.Bqu[i]);
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.a.c.b
 * JD-Core Version:    0.7.0.1
 */