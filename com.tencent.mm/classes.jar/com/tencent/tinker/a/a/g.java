package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class g
  extends s.a.a<g>
{
  public int ahNH;
  public int ahNI;
  public int ahNJ;
  public int ahNK;
  public short[] ahNL;
  public b[] ahNM;
  public a[] ahNN;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfShort, b[] paramArrayOfb, a[] paramArrayOfa)
  {
    super(paramInt1);
    this.ahNH = paramInt2;
    this.ahNI = paramInt3;
    this.ahNJ = paramInt4;
    this.ahNK = paramInt5;
    this.ahNL = paramArrayOfShort;
    this.ahNM = paramArrayOfb;
    this.ahNN = paramArrayOfa;
  }
  
  private int a(g paramg)
  {
    int i = c.pS(this.ahNH, paramg.ahNH);
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
              j = c.pS(this.ahNI, paramg.ahNI);
              i = j;
            } while (j != 0);
            j = c.pS(this.ahNJ, paramg.ahNJ);
            i = j;
          } while (j != 0);
          j = c.pS(this.ahNK, paramg.ahNK);
          i = j;
        } while (j != 0);
        j = c.b(this.ahNL, paramg.ahNL);
        i = j;
      } while (j != 0);
      j = c.b(this.ahNM, paramg.ahNM);
      i = j;
    } while (j != 0);
    return c.b(this.ahNN, paramg.ahNN);
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
    return e.hash(new Object[] { Integer.valueOf(this.ahNH), Integer.valueOf(this.ahNI), Integer.valueOf(this.ahNJ), Integer.valueOf(this.ahNK), this.ahNL, this.ahNM, this.ahNN });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int[] ahNO;
    public int[] ahNP;
    public int ahNQ;
    public int offset;
    
    public a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
    {
      this.ahNO = paramArrayOfInt1;
      this.ahNP = paramArrayOfInt2;
      this.ahNQ = paramInt1;
      this.offset = paramInt2;
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int ahNR;
    public int ahNS;
    public int ahNT;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.ahNR = paramInt1;
      this.ahNS = paramInt2;
      this.ahNT = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.g
 * JD-Core Version:    0.7.0.1
 */