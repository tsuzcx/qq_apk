package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class g
  extends s.a.a<g>
{
  public int KmW;
  public int KmX;
  public int KmY;
  public int KmZ;
  public short[] Kna;
  public b[] Knb;
  public a[] Knc;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfShort, b[] paramArrayOfb, a[] paramArrayOfa)
  {
    super(paramInt1);
    this.KmW = paramInt2;
    this.KmX = paramInt3;
    this.KmY = paramInt4;
    this.KmZ = paramInt5;
    this.Kna = paramArrayOfShort;
    this.Knb = paramArrayOfb;
    this.Knc = paramArrayOfa;
  }
  
  private int a(g paramg)
  {
    int i = c.kK(this.KmW, paramg.KmW);
    if (i != 0) {}
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              j = c.kK(this.KmX, paramg.KmX);
              i = j;
            } while (j != 0);
            j = c.kK(this.KmY, paramg.KmY);
            i = j;
          } while (j != 0);
          j = c.kK(this.KmZ, paramg.KmZ);
          i = j;
        } while (j != 0);
        j = c.a(this.Kna, paramg.Kna);
        i = j;
      } while (j != 0);
      j = c.a(this.Knb, paramg.Knb);
      i = j;
    } while (j != 0);
    return c.a(this.Knc, paramg.Knc);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof g)) {}
    while (a((g)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.KmW), Integer.valueOf(this.KmX), Integer.valueOf(this.KmY), Integer.valueOf(this.KmZ), this.Kna, this.Knb, this.Knc });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int[] Knd;
    public int[] Kne;
    public int Knf;
    public int offset;
    
    public a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
    {
      this.Knd = paramArrayOfInt1;
      this.Kne = paramArrayOfInt2;
      this.Knf = paramInt1;
      this.offset = paramInt2;
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int Kng;
    public int Knh;
    public int Kni;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.Kng = paramInt1;
      this.Knh = paramInt2;
      this.Kni = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.g
 * JD-Core Version:    0.7.0.1
 */