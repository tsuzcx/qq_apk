package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.Iterator;
import java.util.List;

public class ii
  implements iu
{
  private jo a;
  private jc b;
  private jh c;
  
  public ii(ik paramik)
  {
    this.c = ((jh)paramik);
    this.a = paramik.a().j();
    this.b = paramik.f();
  }
  
  private Rect a(List<kj> paramList, iu paramiu)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    paramList = paramList.iterator();
    int j = 0;
    int m = 0;
    int i1 = 0;
    int i = 0;
    Rect localRect;
    int k;
    int n;
    while (paramList.hasNext())
    {
      localRect = ((kj)paramList.next()).a(paramiu);
      if (localRect != null)
      {
        k = i;
        if (i == 0) {
          k = localRect.left;
        }
        n = i1;
        if (i1 == 0) {
          n = localRect.right;
        }
        i1 = m;
        if (m == 0) {
          i1 = localRect.top;
        }
        m = j;
        if (j == 0) {
          m = localRect.bottom;
        }
        i = k;
        if (localRect.left < k) {
          i = localRect.left;
        }
        k = n;
        if (localRect.right > n) {
          k = localRect.right;
        }
        n = i1;
        if (localRect.top < i1) {
          n = localRect.top;
        }
        if (localRect.bottom <= m) {
          break label230;
        }
      }
    }
    label230:
    for (j = localRect.bottom;; j = m)
    {
      m = n;
      i1 = k;
      break;
      return new Rect(i, m, i1, j);
    }
  }
  
  private GeoPoint a(GeoPoint paramGeoPoint, Rect paramRect)
  {
    if (paramGeoPoint == null) {}
    do
    {
      return null;
      paramGeoPoint = b(paramGeoPoint);
    } while ((paramGeoPoint == null) || (paramRect == null));
    return a(new DoublePoint(paramGeoPoint.x - (paramRect.left - paramRect.right) * 0.5D, paramGeoPoint.y - (paramRect.top - paramRect.bottom) * 0.5D));
  }
  
  private GeoPoint a(GeoPoint paramGeoPoint, jo.b paramb)
  {
    if (paramGeoPoint == null) {
      return null;
    }
    paramGeoPoint = b(paramGeoPoint);
    if ((paramGeoPoint != null) && (paramb != null))
    {
      double d2 = paramGeoPoint.x;
      double d3 = paramGeoPoint.y;
      paramGeoPoint = new Rect(this.c.g());
      int i = paramGeoPoint.width();
      int j = paramGeoPoint.height();
      float f1 = paramb.a() + 0.5F;
      float f2 = paramb.b() + 0.5F;
      double d1;
      if (f1 < 0.25D)
      {
        d1 = d2 + (0.25D - f1) * i;
        if (f2 >= 0.25D) {
          break label178;
        }
        d2 = f2;
        d2 = d3 + j * (0.25D - d2);
      }
      for (;;)
      {
        return a(new DoublePoint(d1, d2));
        d1 = d2;
        if (f1 <= 0.75D) {
          break;
        }
        d1 = d2 - (f1 - 0.75D) * i;
        break;
        label178:
        d2 = d3;
        if (f2 > 0.75D)
        {
          d2 = f2;
          d2 = d3 - j * (d2 - 0.75D);
        }
      }
    }
    return null;
  }
  
  private boolean a()
  {
    jo.b localb = this.a.p();
    if (localb == null) {}
    while ((localb.a() == 0.0F) && (localb.b() == 0.0F)) {
      return false;
    }
    return true;
  }
  
  private boolean b()
  {
    jo.b localb = this.a.p();
    if (localb == null) {}
    while ((Math.abs(localb.a()) <= 0.25D) && (Math.abs(localb.b()) <= 0.25D)) {
      return false;
    }
    return true;
  }
  
  public double a(double paramDouble)
  {
    float f = this.a.i();
    double d = this.a.j();
    return 40076000.0D / (Math.pow(2.0D, (float)(f + Math.log(d) / Math.log(2.0D))) * 256.0D) * Math.cos(3.141592653589793D * paramDouble / 180.0D);
  }
  
  public double a(Point paramPoint1, Point paramPoint2)
  {
    return 0.0D;
  }
  
  public GeoPoint a(DoublePoint paramDoublePoint)
  {
    byte[] arrayOfByte = this.a.q();
    float f1 = (float)paramDoublePoint.x;
    float f2 = (float)paramDoublePoint.y;
    return this.b.a(arrayOfByte, f1, f2);
  }
  
  public void a(float paramFloat)
  {
    this.a.d(paramFloat);
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    this.a.a(paramGeoPoint);
  }
  
  public void a(List<kj> paramList, Rect paramRect, ii.a parama)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    Object localObject;
    int k;
    do
    {
      return;
      localObject = new Rect(this.c.g());
      if (paramRect != null)
      {
        ((Rect)localObject).left += paramRect.left;
        ((Rect)localObject).right -= paramRect.right;
        ((Rect)localObject).top += paramRect.top;
        ((Rect)localObject).bottom -= paramRect.bottom;
      }
      int i = ((Rect)localObject).width();
      int j = ((Rect)localObject).height();
      localObject = this.c.a().g();
      k = ((ix)localObject).f();
      this.c.a(new ii.1(this, paramList, i, j, paramRect, k, (ix)localObject, parama));
    } while (k == 60);
    ((ix)localObject).e();
    ((ix)localObject).g();
  }
  
  public DoublePoint b(GeoPoint paramGeoPoint)
  {
    double d1 = paramGeoPoint.getLatitudeE6() / 1000000.0D;
    double d2 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    paramGeoPoint = this.a.q();
    paramGeoPoint = this.b.a(paramGeoPoint, d1, d2);
    return new DoublePoint(paramGeoPoint.x, paramGeoPoint.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ii
 * JD-Core Version:    0.7.0.1
 */