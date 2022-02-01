package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class f
  extends s.a.a<f>
{
  public int IAD;
  public int IAG;
  public int IAH;
  public int IAI;
  public int IAJ;
  public int IAK;
  public int IAL;
  public int IAM;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    super(paramInt1);
    this.IAG = paramInt2;
    this.IAD = paramInt3;
    this.IAH = paramInt4;
    this.IAI = paramInt5;
    this.IAJ = paramInt6;
    this.IAK = paramInt7;
    this.IAL = paramInt8;
    this.IAM = paramInt9;
  }
  
  private int a(f paramf)
  {
    int i = c.ks(this.IAG, paramf.IAG);
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
                j = c.kt(this.IAD, paramf.IAD);
                i = j;
              } while (j != 0);
              j = c.ks(this.IAH, paramf.IAH);
              i = j;
            } while (j != 0);
            j = c.kt(this.IAI, paramf.IAI);
            i = j;
          } while (j != 0);
          j = c.ks(this.IAJ, paramf.IAJ);
          i = j;
        } while (j != 0);
        j = c.kt(this.IAK, paramf.IAK);
        i = j;
      } while (j != 0);
      j = c.kt(this.IAL, paramf.IAL);
      i = j;
    } while (j != 0);
    return c.kt(this.IAM, paramf.IAM);
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
    return e.hash(new Object[] { Integer.valueOf(this.IAG), Integer.valueOf(this.IAD), Integer.valueOf(this.IAH), Integer.valueOf(this.IAI), Integer.valueOf(this.IAJ), Integer.valueOf(this.IAK), Integer.valueOf(this.IAL), Integer.valueOf(this.IAM) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.f
 * JD-Core Version:    0.7.0.1
 */