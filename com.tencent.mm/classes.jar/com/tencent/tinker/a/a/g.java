package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class g
  extends s.a.a<g>
{
  public int IAN;
  public int IAO;
  public int IAP;
  public int IAQ;
  public short[] IAR;
  public b[] IAS;
  public a[] IAT;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfShort, b[] paramArrayOfb, a[] paramArrayOfa)
  {
    super(paramInt1);
    this.IAN = paramInt2;
    this.IAO = paramInt3;
    this.IAP = paramInt4;
    this.IAQ = paramInt5;
    this.IAR = paramArrayOfShort;
    this.IAS = paramArrayOfb;
    this.IAT = paramArrayOfa;
  }
  
  private int a(g paramg)
  {
    int i = c.kt(this.IAN, paramg.IAN);
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
              j = c.kt(this.IAO, paramg.IAO);
              i = j;
            } while (j != 0);
            j = c.kt(this.IAP, paramg.IAP);
            i = j;
          } while (j != 0);
          j = c.kt(this.IAQ, paramg.IAQ);
          i = j;
        } while (j != 0);
        j = c.a(this.IAR, paramg.IAR);
        i = j;
      } while (j != 0);
      j = c.a(this.IAS, paramg.IAS);
      i = j;
    } while (j != 0);
    return c.a(this.IAT, paramg.IAT);
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
    return e.hash(new Object[] { Integer.valueOf(this.IAN), Integer.valueOf(this.IAO), Integer.valueOf(this.IAP), Integer.valueOf(this.IAQ), this.IAR, this.IAS, this.IAT });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int[] IAU;
    public int[] IAV;
    public int IAW;
    public int offset;
    
    public a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
    {
      this.IAU = paramArrayOfInt1;
      this.IAV = paramArrayOfInt2;
      this.IAW = paramInt1;
      this.offset = paramInt2;
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int IAX;
    public int IAY;
    public int IAZ;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.IAX = paramInt1;
      this.IAY = paramInt2;
      this.IAZ = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.g
 * JD-Core Version:    0.7.0.1
 */