package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class g
  extends s.a.a<g>
{
  public int ZIE;
  public int ZIF;
  public int ZIG;
  public int ZIH;
  public short[] ZII;
  public b[] ZIJ;
  public a[] ZIK;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfShort, b[] paramArrayOfb, a[] paramArrayOfa)
  {
    super(paramInt1);
    this.ZIE = paramInt2;
    this.ZIF = paramInt3;
    this.ZIG = paramInt4;
    this.ZIH = paramInt5;
    this.ZII = paramArrayOfShort;
    this.ZIJ = paramArrayOfb;
    this.ZIK = paramArrayOfa;
  }
  
  private int a(g paramg)
  {
    int i = c.nV(this.ZIE, paramg.ZIE);
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
              j = c.nV(this.ZIF, paramg.ZIF);
              i = j;
            } while (j != 0);
            j = c.nV(this.ZIG, paramg.ZIG);
            i = j;
          } while (j != 0);
          j = c.nV(this.ZIH, paramg.ZIH);
          i = j;
        } while (j != 0);
        j = c.a(this.ZII, paramg.ZII);
        i = j;
      } while (j != 0);
      j = c.a(this.ZIJ, paramg.ZIJ);
      i = j;
    } while (j != 0);
    return c.a(this.ZIK, paramg.ZIK);
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
    return e.hash(new Object[] { Integer.valueOf(this.ZIE), Integer.valueOf(this.ZIF), Integer.valueOf(this.ZIG), Integer.valueOf(this.ZIH), this.ZII, this.ZIJ, this.ZIK });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int[] ZIL;
    public int[] ZIM;
    public int ZIN;
    public int offset;
    
    public a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
    {
      this.ZIL = paramArrayOfInt1;
      this.ZIM = paramArrayOfInt2;
      this.ZIN = paramInt1;
      this.offset = paramInt2;
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int ZIO;
    public int ZIQ;
    public int ZIR;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.ZIO = paramInt1;
      this.ZIQ = paramInt2;
      this.ZIR = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.g
 * JD-Core Version:    0.7.0.1
 */