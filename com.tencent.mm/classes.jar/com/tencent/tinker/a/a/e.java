package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e
  extends s.a.a<e>
{
  public a[] MzA;
  public a[] MzB;
  public b[] MzC;
  public b[] MzD;
  
  public e(int paramInt, a[] paramArrayOfa1, a[] paramArrayOfa2, b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    super(paramInt);
    this.MzA = paramArrayOfa1;
    this.MzB = paramArrayOfa2;
    this.MzC = paramArrayOfb1;
    this.MzD = paramArrayOfb2;
  }
  
  private int a(e parame)
  {
    int i = c.a(this.MzA, parame.MzA);
    if (i != 0) {}
    int j;
    do
    {
      do
      {
        return i;
        j = c.a(this.MzB, parame.MzB);
        i = j;
      } while (j != 0);
      j = c.a(this.MzC, parame.MzC);
      i = j;
    } while (j != 0);
    return c.a(this.MzD, parame.MzD);
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
    return com.tencent.tinker.a.a.b.e.hash(new Object[] { this.MzA, this.MzB, this.MzC, this.MzD });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int MzE;
    public int MzF;
    
    public a(int paramInt1, int paramInt2)
    {
      this.MzE = paramInt1;
      this.MzF = paramInt2;
    }
    
    private int a(a parama)
    {
      int i = c.lf(this.MzE, parama.MzE);
      if (i != 0) {
        return i;
      }
      return c.lg(this.MzF, parama.MzF);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.MzE), Integer.valueOf(this.MzF) });
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int MzF;
    public int MzG;
    public int MzH;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.MzG = paramInt1;
      this.MzF = paramInt2;
      this.MzH = paramInt3;
    }
    
    private int a(b paramb)
    {
      int i = c.lf(this.MzG, paramb.MzG);
      if (i != 0) {}
      int j;
      do
      {
        return i;
        j = c.lg(this.MzF, paramb.MzF);
        i = j;
      } while (j != 0);
      return c.lg(this.MzH, paramb.MzH);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.MzG), Integer.valueOf(this.MzF), Integer.valueOf(this.MzH) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.e
 * JD-Core Version:    0.7.0.1
 */