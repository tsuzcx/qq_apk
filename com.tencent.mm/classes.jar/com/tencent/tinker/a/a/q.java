package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class q
  extends s.a.a<q>
{
  public int ZJm;
  public int ZJn;
  public int ZJo;
  
  public q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.ZJm = paramInt2;
    this.ZJn = paramInt3;
    this.ZJo = paramInt4;
  }
  
  private int b(q paramq)
  {
    int i = c.nU(this.ZJm, paramq.ZJm);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = c.nU(this.ZJn, paramq.ZJn);
      i = j;
    } while (j != 0);
    return c.nV(this.ZJo, paramq.ZJo);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof q)) {}
    while (b((q)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.ZJm), Integer.valueOf(this.ZJn), Integer.valueOf(this.ZJo) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.q
 * JD-Core Version:    0.7.0.1
 */