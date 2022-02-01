package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e
  extends s.a.a<e>
{
  public a[] ahNs;
  public a[] ahNt;
  public b[] ahNu;
  public b[] ahNv;
  
  public e(int paramInt, a[] paramArrayOfa1, a[] paramArrayOfa2, b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    super(paramInt);
    this.ahNs = paramArrayOfa1;
    this.ahNt = paramArrayOfa2;
    this.ahNu = paramArrayOfb1;
    this.ahNv = paramArrayOfb2;
  }
  
  private int a(e parame)
  {
    int i = c.b(this.ahNs, parame.ahNs);
    if (i != 0) {}
    int j;
    do
    {
      do
      {
        return i;
        j = c.b(this.ahNt, parame.ahNt);
        i = j;
      } while (j != 0);
      j = c.b(this.ahNu, parame.ahNu);
      i = j;
    } while (j != 0);
    return c.b(this.ahNv, parame.ahNv);
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
    return com.tencent.tinker.a.a.b.e.hash(new Object[] { this.ahNs, this.ahNt, this.ahNu, this.ahNv });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int ahNw;
    public int ahNx;
    
    public a(int paramInt1, int paramInt2)
    {
      this.ahNw = paramInt1;
      this.ahNx = paramInt2;
    }
    
    private int a(a parama)
    {
      int i = c.pR(this.ahNw, parama.ahNw);
      if (i != 0) {
        return i;
      }
      return c.pS(this.ahNx, parama.ahNx);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.ahNw), Integer.valueOf(this.ahNx) });
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int ahNx;
    public int ahNy;
    public int ahNz;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.ahNy = paramInt1;
      this.ahNx = paramInt2;
      this.ahNz = paramInt3;
    }
    
    private int a(b paramb)
    {
      int i = c.pR(this.ahNy, paramb.ahNy);
      if (i != 0) {}
      int j;
      do
      {
        return i;
        j = c.pS(this.ahNx, paramb.ahNx);
        i = j;
      } while (j != 0);
      return c.pS(this.ahNz, paramb.ahNz);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.ahNy), Integer.valueOf(this.ahNx), Integer.valueOf(this.ahNz) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.e
 * JD-Core Version:    0.7.0.1
 */