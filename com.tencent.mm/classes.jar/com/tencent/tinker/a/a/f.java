package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class f
  extends s.a.a<f>
{
  public int KmM;
  public int KmP;
  public int KmQ;
  public int KmR;
  public int KmS;
  public int KmT;
  public int KmU;
  public int KmV;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    super(paramInt1);
    this.KmP = paramInt2;
    this.KmM = paramInt3;
    this.KmQ = paramInt4;
    this.KmR = paramInt5;
    this.KmS = paramInt6;
    this.KmT = paramInt7;
    this.KmU = paramInt8;
    this.KmV = paramInt9;
  }
  
  private int a(f paramf)
  {
    int i = c.kJ(this.KmP, paramf.KmP);
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
              do
              {
                return i;
                j = c.kK(this.KmM, paramf.KmM);
                i = j;
              } while (j != 0);
              j = c.kJ(this.KmQ, paramf.KmQ);
              i = j;
            } while (j != 0);
            j = c.kK(this.KmR, paramf.KmR);
            i = j;
          } while (j != 0);
          j = c.kJ(this.KmS, paramf.KmS);
          i = j;
        } while (j != 0);
        j = c.kK(this.KmT, paramf.KmT);
        i = j;
      } while (j != 0);
      j = c.kK(this.KmU, paramf.KmU);
      i = j;
    } while (j != 0);
    return c.kK(this.KmV, paramf.KmV);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof f)) {}
    while (a((f)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.KmP), Integer.valueOf(this.KmM), Integer.valueOf(this.KmQ), Integer.valueOf(this.KmR), Integer.valueOf(this.KmS), Integer.valueOf(this.KmT), Integer.valueOf(this.KmU), Integer.valueOf(this.KmV) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.f
 * JD-Core Version:    0.7.0.1
 */