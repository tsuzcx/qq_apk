package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class n
  extends t.a.a<n>
{
  public int BoL;
  public int Bpx;
  public int Bpy;
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.Bpx = paramInt2;
    this.BoL = paramInt3;
    this.Bpy = paramInt4;
  }
  
  private int b(n paramn)
  {
    if (this.Bpx != paramn.Bpx) {
      return c.ip(this.Bpx, paramn.Bpx);
    }
    if (this.Bpy != paramn.Bpy) {
      return c.ip(this.Bpy, paramn.Bpy);
    }
    return c.ip(this.BoL, paramn.BoL);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof n)) {}
    while (b((n)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.Bpx), Integer.valueOf(this.BoL), Integer.valueOf(this.Bpy) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tinker.a.a.n
 * JD-Core Version:    0.7.0.1
 */