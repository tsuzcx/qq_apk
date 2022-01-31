package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class p
  extends t.a.a<p>
{
  public int Bpx;
  public int Bpy;
  public int Bpz;
  
  public p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.Bpx = paramInt2;
    this.Bpz = paramInt3;
    this.Bpy = paramInt4;
  }
  
  private int b(p paramp)
  {
    if (this.Bpx != paramp.Bpx) {
      return c.ip(this.Bpx, paramp.Bpx);
    }
    if (this.Bpy != paramp.Bpy) {
      return c.ip(this.Bpy, paramp.Bpy);
    }
    return c.ip(this.Bpz, paramp.Bpz);
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
    return e.hash(new Object[] { Integer.valueOf(this.Bpx), Integer.valueOf(this.Bpz), Integer.valueOf(this.Bpy) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tinker.a.a.p
 * JD-Core Version:    0.7.0.1
 */