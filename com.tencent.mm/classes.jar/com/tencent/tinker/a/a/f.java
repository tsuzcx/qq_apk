package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class f
  extends s.a.a<f>
{
  public int ahNA;
  public int ahNB;
  public int ahNC;
  public int ahND;
  public int ahNE;
  public int ahNF;
  public int ahNG;
  public int ahNx;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    super(paramInt1);
    this.ahNA = paramInt2;
    this.ahNx = paramInt3;
    this.ahNB = paramInt4;
    this.ahNC = paramInt5;
    this.ahND = paramInt6;
    this.ahNE = paramInt7;
    this.ahNF = paramInt8;
    this.ahNG = paramInt9;
  }
  
  private int a(f paramf)
  {
    int i = c.pR(this.ahNA, paramf.ahNA);
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
                j = c.pS(this.ahNx, paramf.ahNx);
                i = j;
              } while (j != 0);
              j = c.pR(this.ahNB, paramf.ahNB);
              i = j;
            } while (j != 0);
            j = c.pS(this.ahNC, paramf.ahNC);
            i = j;
          } while (j != 0);
          j = c.pR(this.ahND, paramf.ahND);
          i = j;
        } while (j != 0);
        j = c.pS(this.ahNE, paramf.ahNE);
        i = j;
      } while (j != 0);
      j = c.pS(this.ahNF, paramf.ahNF);
      i = j;
    } while (j != 0);
    return c.pS(this.ahNG, paramf.ahNG);
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
    return e.hash(new Object[] { Integer.valueOf(this.ahNA), Integer.valueOf(this.ahNx), Integer.valueOf(this.ahNB), Integer.valueOf(this.ahNC), Integer.valueOf(this.ahND), Integer.valueOf(this.ahNE), Integer.valueOf(this.ahNF), Integer.valueOf(this.ahNG) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.f
 * JD-Core Version:    0.7.0.1
 */