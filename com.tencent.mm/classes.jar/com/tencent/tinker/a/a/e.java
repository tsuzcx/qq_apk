package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e
  extends s.a.a<e>
{
  public a[] SfE;
  public a[] SfF;
  public b[] SfG;
  public b[] SfH;
  
  public e(int paramInt, a[] paramArrayOfa1, a[] paramArrayOfa2, b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    super(paramInt);
    this.SfE = paramArrayOfa1;
    this.SfF = paramArrayOfa2;
    this.SfG = paramArrayOfb1;
    this.SfH = paramArrayOfb2;
  }
  
  private int a(e parame)
  {
    int i = c.a(this.SfE, parame.SfE);
    if (i != 0) {}
    int j;
    do
    {
      do
      {
        return i;
        j = c.a(this.SfF, parame.SfF);
        i = j;
      } while (j != 0);
      j = c.a(this.SfG, parame.SfG);
      i = j;
    } while (j != 0);
    return c.a(this.SfH, parame.SfH);
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
    return com.tencent.tinker.a.a.b.e.hash(new Object[] { this.SfE, this.SfF, this.SfG, this.SfH });
  }
  
  public static final class a
    implements Comparable<a>
  {
    public int SfI;
    public int SfJ;
    
    public a(int paramInt1, int paramInt2)
    {
      this.SfI = paramInt1;
      this.SfJ = paramInt2;
    }
    
    private int a(a parama)
    {
      int i = c.mD(this.SfI, parama.SfI);
      if (i != 0) {
        return i;
      }
      return c.mE(this.SfJ, parama.SfJ);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.SfI), Integer.valueOf(this.SfJ) });
    }
  }
  
  public static final class b
    implements Comparable<b>
  {
    public int SfJ;
    public int SfK;
    public int SfL;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.SfK = paramInt1;
      this.SfJ = paramInt2;
      this.SfL = paramInt3;
    }
    
    private int a(b paramb)
    {
      int i = c.mD(this.SfK, paramb.SfK);
      if (i != 0) {}
      int j;
      do
      {
        return i;
        j = c.mE(this.SfJ, paramb.SfJ);
        i = j;
      } while (j != 0);
      return c.mE(this.SfL, paramb.SfL);
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
      return com.tencent.tinker.a.a.b.e.hash(new Object[] { Integer.valueOf(this.SfK), Integer.valueOf(this.SfJ), Integer.valueOf(this.SfL) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.e
 * JD-Core Version:    0.7.0.1
 */