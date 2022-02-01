package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class g
  extends s.a.a<g>
{
  public int McU;
  public int McV;
  public int McW;
  public int McX;
  public short[] McY;
  public b[] McZ;
  public a[] Mda;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfShort, b[] paramArrayOfb, a[] paramArrayOfa)
  {
    super(paramInt1);
    this.McU = paramInt2;
    this.McV = paramInt3;
    this.McW = paramInt4;
    this.McX = paramInt5;
    this.McY = paramArrayOfShort;
    this.McZ = paramArrayOfb;
    this.Mda = paramArrayOfa;
  }
  
  private int a(g paramg)
  {
    int i = c.kZ(this.McU, paramg.McU);
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
              j = c.kZ(this.McV, paramg.McV);
              i = j;
            } while (j != 0);
            j = c.kZ(this.McW, paramg.McW);
            i = j;
          } while (j != 0);
          j = c.kZ(this.McX, paramg.McX);
          i = j;
        } while (j != 0);
        j = c.a(this.McY, paramg.McY);
        i = j;
      } while (j != 0);
      j = c.a(this.McZ, paramg.McZ);
      i = j;
    } while (j != 0);
    return c.a(this.Mda, paramg.Mda);
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
    return e.hash(new Object[] { Integer.valueOf(this.McU), Integer.valueOf(this.McV), Integer.valueOf(this.McW), Integer.valueOf(this.McX), this.McY, this.McZ, this.Mda });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int[] Mdb;
    public int[] Mdc;
    public int Mdd;
    public int offset;
    
    public a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
    {
      this.Mdb = paramArrayOfInt1;
      this.Mdc = paramArrayOfInt2;
      this.Mdd = paramInt1;
      this.offset = paramInt2;
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int Mde;
    public int Mdf;
    public int Mdg;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.Mde = paramInt1;
      this.Mdf = paramInt2;
      this.Mdg = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.g
 * JD-Core Version:    0.7.0.1
 */