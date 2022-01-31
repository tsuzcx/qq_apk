package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class g
  extends t.a.a<g>
{
  public int BoS;
  public int BoT;
  public int BoU;
  public int BoV;
  public short[] BoW;
  public g.b[] BoX;
  public g.a[] BoY;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfShort, g.b[] paramArrayOfb, g.a[] paramArrayOfa)
  {
    super(paramInt1);
    this.BoS = paramInt2;
    this.BoT = paramInt3;
    this.BoU = paramInt4;
    this.BoV = paramInt5;
    this.BoW = paramArrayOfShort;
    this.BoX = paramArrayOfb;
    this.BoY = paramArrayOfa;
  }
  
  private int a(g paramg)
  {
    int i = c.iq(this.BoS, paramg.BoS);
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
              j = c.iq(this.BoT, paramg.BoT);
              i = j;
            } while (j != 0);
            j = c.iq(this.BoU, paramg.BoU);
            i = j;
          } while (j != 0);
          j = c.iq(this.BoV, paramg.BoV);
          i = j;
        } while (j != 0);
        j = c.a(this.BoW, paramg.BoW);
        i = j;
      } while (j != 0);
      j = c.a(this.BoX, paramg.BoX);
      i = j;
    } while (j != 0);
    return c.a(this.BoY, paramg.BoY);
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
    return e.hash(new Object[] { Integer.valueOf(this.BoS), Integer.valueOf(this.BoT), Integer.valueOf(this.BoU), Integer.valueOf(this.BoV), this.BoW, this.BoX, this.BoY });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tinker.a.a.g
 * JD-Core Version:    0.7.0.1
 */