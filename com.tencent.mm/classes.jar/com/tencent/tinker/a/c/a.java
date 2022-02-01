package com.tencent.tinker.a.c;

public final class a
  implements Cloneable
{
  private static final boolean[] ahPg = new boolean[0];
  private static final int[] dTZ = new int[0];
  private int[] Sk = new int[10];
  private boolean[] ahPh = new boolean[10];
  private int mSize = 0;
  
  public a()
  {
    this((byte)0);
  }
  
  private a(byte paramByte) {}
  
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
  
  private static int ef(int paramInt)
  {
    if (paramInt <= 4) {
      return 8;
    }
    return (paramInt >> 1) + paramInt;
  }
  
  private a kca()
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
        locala.Sk = ((int[])this.Sk.clone());
        locala.ahPh = ((boolean[])this.ahPh.clone());
        return locala;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public final void aIE(int paramInt)
  {
    int i = a(this.Sk, this.mSize, paramInt);
    if (i >= 0)
    {
      this.ahPh[i] = true;
      return;
    }
    i ^= 0xFFFFFFFF;
    Object localObject1 = this.Sk;
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
      this.Sk = ((int[])localObject1);
      localObject1 = this.ahPh;
      paramInt = this.mSize;
      if (paramInt <= localObject1.length) {
        break;
      }
      throw new IllegalArgumentException("Bad currentSize, originalSize: " + localObject1.length + " currentSize: " + paramInt);
      localObject2 = new int[ef(j)];
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
      this.ahPh = ((boolean[])localObject1);
      this.mSize += 1;
      return;
      localObject2 = new boolean[ef(paramInt)];
      System.arraycopy(localObject1, 0, localObject2, 0, i);
      localObject2[i] = 1;
      System.arraycopy(localObject1, i, localObject2, i + 1, localObject1.length - i);
      localObject1 = localObject2;
    }
  }
  
  public final boolean bp(int paramInt)
  {
    return a(this.Sk, this.mSize, paramInt) >= 0;
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
      localStringBuilder.append(this.Sk[i]);
      localStringBuilder.append('=');
      localStringBuilder.append(this.ahPh[i]);
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.c.a
 * JD-Core Version:    0.7.0.1
 */