package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class h
  extends s.a.a<h>
{
  public int Sgg;
  public int[] Sgh;
  public byte[] Sgi;
  
  public h(int paramInt1, int paramInt2, int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    super(paramInt1);
    this.Sgg = paramInt2;
    this.Sgh = paramArrayOfInt;
    this.Sgi = paramArrayOfByte;
  }
  
  private int a(h paramh)
  {
    int i = this.Sgg;
    int j = paramh.Sgg;
    if (i != j)
    {
      j = i - j;
      return j;
    }
    int[] arrayOfInt1 = this.Sgh;
    int[] arrayOfInt2 = paramh.Sgh;
    int m = arrayOfInt1.length;
    i = arrayOfInt2.length;
    if (m < i) {
      i = -1;
    }
    for (;;)
    {
      j = i;
      if (i != 0) {
        break;
      }
      return c.p(this.Sgi, paramh.Sgi);
      if (m > i)
      {
        i = 1;
      }
      else
      {
        j = 0;
        for (;;)
        {
          if (j >= m) {
            break label115;
          }
          int k = c.mD(arrayOfInt1[j], arrayOfInt2[j]);
          i = k;
          if (k != 0) {
            break;
          }
          j += 1;
        }
        label115:
        i = 0;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof h)) {}
    while (a((h)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.Sgg), this.Sgh, this.Sgi });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.h
 * JD-Core Version:    0.7.0.1
 */