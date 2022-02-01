package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class f
  extends s.a.a<f>
{
  public int SfJ;
  public int SfM;
  public int SfN;
  public int SfO;
  public int SfP;
  public int SfQ;
  public int SfR;
  public int SfS;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    super(paramInt1);
    this.SfM = paramInt2;
    this.SfJ = paramInt3;
    this.SfN = paramInt4;
    this.SfO = paramInt5;
    this.SfP = paramInt6;
    this.SfQ = paramInt7;
    this.SfR = paramInt8;
    this.SfS = paramInt9;
  }
  
  private int a(f paramf)
  {
    int i = c.mD(this.SfM, paramf.SfM);
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
                j = c.mE(this.SfJ, paramf.SfJ);
                i = j;
              } while (j != 0);
              j = c.mD(this.SfN, paramf.SfN);
              i = j;
            } while (j != 0);
            j = c.mE(this.SfO, paramf.SfO);
            i = j;
          } while (j != 0);
          j = c.mD(this.SfP, paramf.SfP);
          i = j;
        } while (j != 0);
        j = c.mE(this.SfQ, paramf.SfQ);
        i = j;
      } while (j != 0);
      j = c.mE(this.SfR, paramf.SfR);
      i = j;
    } while (j != 0);
    return c.mE(this.SfS, paramf.SfS);
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
    return e.hash(new Object[] { Integer.valueOf(this.SfM), Integer.valueOf(this.SfJ), Integer.valueOf(this.SfN), Integer.valueOf(this.SfO), Integer.valueOf(this.SfP), Integer.valueOf(this.SfQ), Integer.valueOf(this.SfR), Integer.valueOf(this.SfS) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.f
 * JD-Core Version:    0.7.0.1
 */