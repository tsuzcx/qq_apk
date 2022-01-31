package com.tencent.tinker.a.c;

public final class a
  implements Cloneable
{
  private static final boolean[] Bqs = new boolean[0];
  private static final int[] bgZ = new int[0];
  private boolean[] Bqt = new boolean[10];
  private int[] Fk = new int[10];
  private int mSize = 0;
  
  public a()
  {
    this((byte)0);
  }
  
  private a(byte paramByte) {}
  
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
  
  private a dWt()
  {
    try
    {
      a locala = (a)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        locala.Fk = ((int[])this.Fk.clone());
        locala.Bqt = ((boolean[])this.Bqt.clone());
        return locala;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public final void SN(int paramInt)
  {
    int i = b(this.Fk, this.mSize, paramInt);
    if (i >= 0)
    {
      this.Bqt[i] = true;
      return;
    }
    i ^= 0xFFFFFFFF;
    Object localObject1 = this.Fk;
    int j = this.mSize;
    if (j > localObject1.length) {
      throw new IllegalArgumentException("Bad currentSize, originalSize: " + localObject1.length + " currentSize: " + j);
    }
    if (j + 1 <= localObject1.length)
    {
      System.arraycopy(localObject1, i, localObject1, i + 1, j - i);
      localObject1[i] = paramInt;
    }
    Object localObject2;
    for (;;)
    {
      this.Fk = ((int[])localObject1);
      localObject1 = this.Bqt;
      paramInt = this.mSize;
      if (paramInt <= localObject1.length) {
        break;
      }
      throw new IllegalArgumentException("Bad currentSize, originalSize: " + localObject1.length + " currentSize: " + paramInt);
      localObject2 = new int[ad(j)];
      System.arraycopy(localObject1, 0, localObject2, 0, i);
      localObject2[i] = paramInt;
      System.arraycopy(localObject1, i, localObject2, i + 1, localObject1.length - i);
      localObject1 = localObject2;
    }
    if (paramInt + 1 <= localObject1.length)
    {
      System.arraycopy(localObject1, i, localObject1, i + 1, paramInt - i);
      localObject1[i] = 1;
    }
    for (;;)
    {
      this.Bqt = ((boolean[])localObject1);
      this.mSize += 1;
      return;
      localObject2 = new boolean[ad(paramInt)];
      System.arraycopy(localObject1, 0, localObject2, 0, i);
      localObject2[i] = 1;
      System.arraycopy(localObject1, i, localObject2, i + 1, localObject1.length - i);
      localObject1 = localObject2;
    }
  }
  
  public final boolean fs(int paramInt)
  {
    return b(this.Fk, this.mSize, paramInt) >= 0;
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
      localStringBuilder.append(this.Bqt[i]);
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.a.c.a
 * JD-Core Version:    0.7.0.1
 */