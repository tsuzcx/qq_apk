package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e
  extends s.a.a<e>
{
  public b[] IAA;
  public b[] IAB;
  public a[] IAy;
  public a[] IAz;
  
  public e(int paramInt, a[] paramArrayOfa1, a[] paramArrayOfa2, b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    super(paramInt);
    this.IAy = paramArrayOfa1;
    this.IAz = paramArrayOfa2;
    this.IAA = paramArrayOfb1;
    this.IAB = paramArrayOfb2;
  }
  
  private int a(e parame)
  {
    int i = c.a(this.IAy, parame.IAy);
    if (i != 0) {}
    int j;
    do
    {
      do
      {
        return i;
        j = c.a(this.IAz, parame.IAz);
        i = j;
      } while (j != 0);
      j = c.a(this.IAA, parame.IAA);
      i = j;
    } while (j != 0);
    return c.a(this.IAB, parame.IAB);
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
    return com.tencent.tinker.a.a.b.e.hash(new Object[] { this.IAy, this.IAz, this.IAA, this.IAB });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int IAC;
    public int IAD;
    
    public a(int paramInt1, int paramInt2)
    {
      this.IAC = paramInt1;
      this.IAD = paramInt2;
    }
    
    private int a(a parama)
    {
      int i = c.ks(this.IAC, parama.IAC);
      if (i != 0) {
        return i;
      }
      return c.kt(this.IAD, parama.IAD);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.IAC), Integer.valueOf(this.IAD) });
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int IAD;
    public int IAE;
    public int IAF;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.IAE = paramInt1;
      this.IAD = paramInt2;
      this.IAF = paramInt3;
    }
    
    private int a(b paramb)
    {
      int i = c.ks(this.IAE, paramb.IAE);
      if (i != 0) {}
      int j;
      do
      {
        return i;
        j = c.kt(this.IAD, paramb.IAD);
        i = j;
      } while (j != 0);
      return c.kt(this.IAF, paramb.IAF);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.IAE), Integer.valueOf(this.IAD), Integer.valueOf(this.IAF) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.e
 * JD-Core Version:    0.7.0.1
 */