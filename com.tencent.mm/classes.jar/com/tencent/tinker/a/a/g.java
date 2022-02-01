package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class g
  extends s.a.a<g>
{
  public int SfT;
  public int SfU;
  public int SfV;
  public int SfW;
  public short[] SfX;
  public b[] SfY;
  public a[] SfZ;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfShort, b[] paramArrayOfb, a[] paramArrayOfa)
  {
    super(paramInt1);
    this.SfT = paramInt2;
    this.SfU = paramInt3;
    this.SfV = paramInt4;
    this.SfW = paramInt5;
    this.SfX = paramArrayOfShort;
    this.SfY = paramArrayOfb;
    this.SfZ = paramArrayOfa;
  }
  
  private int a(g paramg)
  {
    int i = c.mE(this.SfT, paramg.SfT);
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
              j = c.mE(this.SfU, paramg.SfU);
              i = j;
            } while (j != 0);
            j = c.mE(this.SfV, paramg.SfV);
            i = j;
          } while (j != 0);
          j = c.mE(this.SfW, paramg.SfW);
          i = j;
        } while (j != 0);
        j = c.a(this.SfX, paramg.SfX);
        i = j;
      } while (j != 0);
      j = c.a(this.SfY, paramg.SfY);
      i = j;
    } while (j != 0);
    return c.a(this.SfZ, paramg.SfZ);
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
    return e.hash(new Object[] { Integer.valueOf(this.SfT), Integer.valueOf(this.SfU), Integer.valueOf(this.SfV), Integer.valueOf(this.SfW), this.SfX, this.SfY, this.SfZ });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int[] Sga;
    public int[] Sgb;
    public int Sgc;
    public int offset;
    
    public a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
    {
      this.Sga = paramArrayOfInt1;
      this.Sgb = paramArrayOfInt2;
      this.Sgc = paramInt1;
      this.offset = paramInt2;
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int Sgd;
    public int Sge;
    public int Sgf;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.Sgd = paramInt1;
      this.Sge = paramInt2;
      this.Sgf = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.g
 * JD-Core Version:    0.7.0.1
 */