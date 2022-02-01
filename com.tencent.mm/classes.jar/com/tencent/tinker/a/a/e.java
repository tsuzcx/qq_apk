package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e
  extends s.a.a<e>
{
  public a[] McF;
  public a[] McG;
  public b[] McH;
  public b[] McI;
  
  public e(int paramInt, a[] paramArrayOfa1, a[] paramArrayOfa2, b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    super(paramInt);
    this.McF = paramArrayOfa1;
    this.McG = paramArrayOfa2;
    this.McH = paramArrayOfb1;
    this.McI = paramArrayOfb2;
  }
  
  private int a(e parame)
  {
    int i = c.a(this.McF, parame.McF);
    if (i != 0) {}
    int j;
    do
    {
      do
      {
        return i;
        j = c.a(this.McG, parame.McG);
        i = j;
      } while (j != 0);
      j = c.a(this.McH, parame.McH);
      i = j;
    } while (j != 0);
    return c.a(this.McI, parame.McI);
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
    return com.tencent.tinker.a.a.b.e.hash(new Object[] { this.McF, this.McG, this.McH, this.McI });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int McJ;
    public int McK;
    
    public a(int paramInt1, int paramInt2)
    {
      this.McJ = paramInt1;
      this.McK = paramInt2;
    }
    
    private int a(a parama)
    {
      int i = c.kY(this.McJ, parama.McJ);
      if (i != 0) {
        return i;
      }
      return c.kZ(this.McK, parama.McK);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.McJ), Integer.valueOf(this.McK) });
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int McK;
    public int McL;
    public int McM;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.McL = paramInt1;
      this.McK = paramInt2;
      this.McM = paramInt3;
    }
    
    private int a(b paramb)
    {
      int i = c.kY(this.McL, paramb.McL);
      if (i != 0) {}
      int j;
      do
      {
        return i;
        j = c.kZ(this.McK, paramb.McK);
        i = j;
      } while (j != 0);
      return c.kZ(this.McM, paramb.McM);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.McL), Integer.valueOf(this.McK), Integer.valueOf(this.McM) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.e
 * JD-Core Version:    0.7.0.1
 */