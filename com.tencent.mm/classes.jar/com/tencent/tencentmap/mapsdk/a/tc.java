package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.PointF;

public final class tc
  extends sy
{
  private float d;
  private Point e;
  
  public final void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public final void a(Point paramPoint)
  {
    this.e = paramPoint;
  }
  
  public final void a(tn paramtn)
  {
    if (this.e != null)
    {
      PointF localPointF = new PointF(this.e.x, this.e.y);
      paramtn.c().a(this.d, localPointF, this.a, this.c);
      return;
    }
    paramtn.c().a(this.d, this.a, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tc
 * JD-Core Version:    0.7.0.1
 */