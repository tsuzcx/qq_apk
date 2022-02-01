package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class g
  extends s.a.a<g>
{
  public int MzP;
  public int MzQ;
  public int MzR;
  public int MzS;
  public short[] MzT;
  public b[] MzU;
  public a[] MzV;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfShort, b[] paramArrayOfb, a[] paramArrayOfa)
  {
    super(paramInt1);
    this.MzP = paramInt2;
    this.MzQ = paramInt3;
    this.MzR = paramInt4;
    this.MzS = paramInt5;
    this.MzT = paramArrayOfShort;
    this.MzU = paramArrayOfb;
    this.MzV = paramArrayOfa;
  }
  
  private int a(g paramg)
  {
    int i = c.lg(this.MzP, paramg.MzP);
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
              j = c.lg(this.MzQ, paramg.MzQ);
              i = j;
            } while (j != 0);
            j = c.lg(this.MzR, paramg.MzR);
            i = j;
          } while (j != 0);
          j = c.lg(this.MzS, paramg.MzS);
          i = j;
        } while (j != 0);
        j = c.a(this.MzT, paramg.MzT);
        i = j;
      } while (j != 0);
      j = c.a(this.MzU, paramg.MzU);
      i = j;
    } while (j != 0);
    return c.a(this.MzV, paramg.MzV);
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
    return e.hash(new Object[] { Integer.valueOf(this.MzP), Integer.valueOf(this.MzQ), Integer.valueOf(this.MzR), Integer.valueOf(this.MzS), this.MzT, this.MzU, this.MzV });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int[] MzW;
    public int[] MzX;
    public int MzY;
    public int offset;
    
    public a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
    {
      this.MzW = paramArrayOfInt1;
      this.MzX = paramArrayOfInt2;
      this.MzY = paramInt1;
      this.offset = paramInt2;
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int MAa;
    public int MAb;
    public int MzZ;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.MzZ = paramInt1;
      this.MAa = paramInt2;
      this.MAb = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.g
 * JD-Core Version:    0.7.0.1
 */