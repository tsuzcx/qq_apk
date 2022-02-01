package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e
  extends s.a.a<e>
{
  public a[] ZIp;
  public a[] ZIq;
  public b[] ZIr;
  public b[] ZIs;
  
  public e(int paramInt, a[] paramArrayOfa1, a[] paramArrayOfa2, b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    super(paramInt);
    this.ZIp = paramArrayOfa1;
    this.ZIq = paramArrayOfa2;
    this.ZIr = paramArrayOfb1;
    this.ZIs = paramArrayOfb2;
  }
  
  private int a(e parame)
  {
    int i = c.a(this.ZIp, parame.ZIp);
    if (i != 0) {}
    int j;
    do
    {
      do
      {
        return i;
        j = c.a(this.ZIq, parame.ZIq);
        i = j;
      } while (j != 0);
      j = c.a(this.ZIr, parame.ZIr);
      i = j;
    } while (j != 0);
    return c.a(this.ZIs, parame.ZIs);
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
    return com.tencent.tinker.a.a.b.e.hash(new Object[] { this.ZIp, this.ZIq, this.ZIr, this.ZIs });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int ZIt;
    public int ZIu;
    
    public a(int paramInt1, int paramInt2)
    {
      this.ZIt = paramInt1;
      this.ZIu = paramInt2;
    }
    
    private int a(a parama)
    {
      int i = c.nU(this.ZIt, parama.ZIt);
      if (i != 0) {
        return i;
      }
      return c.nV(this.ZIu, parama.ZIu);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.ZIt), Integer.valueOf(this.ZIu) });
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int ZIu;
    public int ZIv;
    public int ZIw;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.ZIv = paramInt1;
      this.ZIu = paramInt2;
      this.ZIw = paramInt3;
    }
    
    private int a(b paramb)
    {
      int i = c.nU(this.ZIv, paramb.ZIv);
      if (i != 0) {}
      int j;
      do
      {
        return i;
        j = c.nV(this.ZIu, paramb.ZIu);
        i = j;
      } while (j != 0);
      return c.nV(this.ZIw, paramb.ZIw);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.ZIv), Integer.valueOf(this.ZIu), Integer.valueOf(this.ZIw) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.e
 * JD-Core Version:    0.7.0.1
 */