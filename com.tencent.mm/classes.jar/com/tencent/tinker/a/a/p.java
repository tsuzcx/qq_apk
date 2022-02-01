package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class p
  extends s.a.a<p>
{
  public int MAu;
  public int MAv;
  public int MAw;
  
  public p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.MAu = paramInt2;
    this.MAw = paramInt3;
    this.MAv = paramInt4;
  }
  
  private int b(p paramp)
  {
    if (this.MAu != paramp.MAu) {
      return c.lf(this.MAu, paramp.MAu);
    }
    if (this.MAv != paramp.MAv) {
      return c.lf(this.MAv, paramp.MAv);
    }
    return c.lf(this.MAw, paramp.MAw);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof p)) {}
    while (b((p)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.MAu), Integer.valueOf(this.MAw), Integer.valueOf(this.MAv) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.p
 * JD-Core Version:    0.7.0.1
 */