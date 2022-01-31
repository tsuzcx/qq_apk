package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.PointF;

public class va
{
  private tn a;
  private tk b;
  
  public va(tn paramtn)
  {
    this.a = paramtn;
    this.b = paramtn.b();
  }
  
  public double a(ry paramry1, ry paramry2)
  {
    return sx.a(paramry1, paramry2);
  }
  
  public float a(double paramDouble1, double paramDouble2)
  {
    return this.b.a(paramDouble1, paramDouble2);
  }
  
  public float a(float paramFloat)
  {
    return this.b.a(paramFloat);
  }
  
  public Point a(ry paramry)
  {
    paramry = this.b.a(paramry);
    return new Point((int)paramry.x, (int)paramry.y);
  }
  
  public ry a(Point paramPoint)
  {
    return this.b.a(paramPoint.x, paramPoint.y);
  }
  
  public sl a()
  {
    int i = this.a.c().getWidth();
    int j = this.a.c().getHeight();
    ry localry1 = a(new Point(0, 0));
    ry localry2 = a(new Point(i, 0));
    ry localry3 = a(new Point(0, j));
    ry localry4 = a(new Point(i, j));
    return new sl(localry3, localry4, localry1, localry2, rz.a().a(localry3).a(localry4).a(localry1).a(localry2).a());
  }
  
  public int b()
  {
    rz localrz = a().e();
    ry localry = localrz.b();
    return (int)(localrz.c().b() * 1000000.0D - localry.b() * 1000000.0D);
  }
  
  public int c()
  {
    rz localrz = a().e();
    ry localry = localrz.b();
    return (int)(localrz.c().c() * 1000000.0D - localry.c() * 1000000.0D);
  }
  
  public float d()
  {
    return this.b.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.va
 * JD-Core Version:    0.7.0.1
 */