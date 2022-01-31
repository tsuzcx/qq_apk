package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;

public final class sp
  extends sn
{
  private PointF d;
  private double e;
  private double f;
  
  public sp(tn paramtn, double paramDouble, PointF paramPointF, long paramLong, uv paramuv)
  {
    super(paramtn, paramLong, paramuv);
    this.e = paramDouble;
    this.d = paramPointF;
  }
  
  protected final void a(float paramFloat)
  {
    this.b.a(this.f * paramFloat, this.d, false, null);
  }
  
  protected final void c()
  {
    double d1 = this.b.c();
    this.f = (this.e - d1);
    new StringBuilder("newZoom:").append(this.e).append(",oldZoom=").append(d1);
  }
  
  protected final void d()
  {
    this.b.a(this.e, this.d, false, 0L, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sp
 * JD-Core Version:    0.7.0.1
 */