package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;

class jj$4
  extends iv
{
  jj$4(jj paramjj, int paramInt, double[] paramArrayOfDouble, long paramLong1, long paramLong2, PointF paramPointF)
  {
    super(paramInt, paramArrayOfDouble);
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis() - this.j;
    if (l1 > this.k)
    {
      jj.a(this.m, false);
      return true;
    }
    double d;
    if (this.l.x != 0.0F)
    {
      d = ie.a(l1, this.l.x, -this.l.x, this.k);
      this.b[0] = d;
    }
    if (this.l.y != 0.0F)
    {
      d = ie.a(l1, this.l.y, -this.l.y, this.k);
      this.b[1] = d;
    }
    return false;
  }
  
  public void b()
  {
    jj.a(this.m, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jj.4
 * JD-Core Version:    0.7.0.1
 */