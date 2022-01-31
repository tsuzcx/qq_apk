package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e
  extends t.a.a<e>
{
  public a[] BoD;
  public a[] BoE;
  public b[] BoF;
  public b[] BoG;
  
  public e(int paramInt, a[] paramArrayOfa1, a[] paramArrayOfa2, b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    super(paramInt);
    this.BoD = paramArrayOfa1;
    this.BoE = paramArrayOfa2;
    this.BoF = paramArrayOfb1;
    this.BoG = paramArrayOfb2;
  }
  
  private int a(e parame)
  {
    int i = c.a(this.BoD, parame.BoD);
    if (i != 0) {}
    int j;
    do
    {
      do
      {
        return i;
        j = c.a(this.BoE, parame.BoE);
        i = j;
      } while (j != 0);
      j = c.a(this.BoF, parame.BoF);
      i = j;
    } while (j != 0);
    return c.a(this.BoG, parame.BoG);
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
    return com.tencent.tinker.a.a.b.e.hash(new Object[] { this.BoD, this.BoE, this.BoF, this.BoG });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int BoH;
    public int BoI;
    
    public a(int paramInt1, int paramInt2)
    {
      this.BoH = paramInt1;
      this.BoI = paramInt2;
    }
    
    private int a(a parama)
    {
      int i = c.ip(this.BoH, parama.BoH);
      if (i != 0) {
        return i;
      }
      return c.iq(this.BoI, parama.BoI);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.BoH), Integer.valueOf(this.BoI) });
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int BoI;
    public int BoJ;
    public int BoK;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.BoJ = paramInt1;
      this.BoI = paramInt2;
      this.BoK = paramInt3;
    }
    
    private int a(b paramb)
    {
      int i = c.ip(this.BoJ, paramb.BoJ);
      if (i != 0) {}
      int j;
      do
      {
        return i;
        j = c.iq(this.BoI, paramb.BoI);
        i = j;
      } while (j != 0);
      return c.iq(this.BoK, paramb.BoK);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.BoJ), Integer.valueOf(this.BoI), Integer.valueOf(this.BoK) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.e
 * JD-Core Version:    0.7.0.1
 */