package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e
  extends s.a.a<e>
{
  public a[] KmH;
  public a[] KmI;
  public b[] KmJ;
  public b[] KmK;
  
  public e(int paramInt, a[] paramArrayOfa1, a[] paramArrayOfa2, b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    super(paramInt);
    this.KmH = paramArrayOfa1;
    this.KmI = paramArrayOfa2;
    this.KmJ = paramArrayOfb1;
    this.KmK = paramArrayOfb2;
  }
  
  private int a(e parame)
  {
    int i = c.a(this.KmH, parame.KmH);
    if (i != 0) {}
    int j;
    do
    {
      do
      {
        return i;
        j = c.a(this.KmI, parame.KmI);
        i = j;
      } while (j != 0);
      j = c.a(this.KmJ, parame.KmJ);
      i = j;
    } while (j != 0);
    return c.a(this.KmK, parame.KmK);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof e)) {}
    while (a((e)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return com.tencent.tinker.a.a.b.e.hash(new Object[] { this.KmH, this.KmI, this.KmJ, this.KmK });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int KmL;
    public int KmM;
    
    public a(int paramInt1, int paramInt2)
    {
      this.KmL = paramInt1;
      this.KmM = paramInt2;
    }
    
    private int a(a parama)
    {
      int i = c.kJ(this.KmL, parama.KmL);
      if (i != 0) {
        return i;
      }
      return c.kK(this.KmM, parama.KmM);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      while (a((a)paramObject) != 0) {
        return false;
      }
      return true;
    }
    
    public final int hashCode()
    {
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.KmL), Integer.valueOf(this.KmM) });
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int KmM;
    public int KmN;
    public int KmO;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.KmN = paramInt1;
      this.KmM = paramInt2;
      this.KmO = paramInt3;
    }
    
    private int a(b paramb)
    {
      int i = c.kJ(this.KmN, paramb.KmN);
      if (i != 0) {}
      int j;
      do
      {
        return i;
        j = c.kK(this.KmM, paramb.KmM);
        i = j;
      } while (j != 0);
      return c.kK(this.KmO, paramb.KmO);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof b)) {}
      while (a((b)paramObject) != 0) {
        return false;
      }
      return true;
    }
    
    public final int hashCode()
    {
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.KmN), Integer.valueOf(this.KmM), Integer.valueOf(this.KmO) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.e
 * JD-Core Version:    0.7.0.1
 */