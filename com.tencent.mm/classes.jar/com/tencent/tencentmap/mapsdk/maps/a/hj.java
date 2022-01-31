package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class hj
  implements hu
{
  private iq a;
  private if b;
  private ik c;
  
  public hj(hl paramhl)
  {
    AppMethodBeat.i(148090);
    this.c = ((ik)paramhl);
    this.a = paramhl.a().j();
    this.b = paramhl.f();
    AppMethodBeat.o(148090);
  }
  
  private Rect a(List<j> paramList, hu paramhu)
  {
    AppMethodBeat.i(148098);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(148098);
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
      localRect = ((j)paramList.next()).a(paramhu);
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
          break label247;
        }
      }
    }
    label247:
    for (j = localRect.bottom;; j = m)
    {
      m = n;
      i1 = k;
      break;
      paramList = new Rect(i, m, i1, j);
      AppMethodBeat.o(148098);
      return paramList;
    }
  }
  
  private Rect a(List<j> paramList, List<GeoPoint> paramList1, hu paramhu)
  {
    AppMethodBeat.i(148099);
    int j;
    int i2;
    int i3;
    int k;
    int m;
    int n;
    int i1;
    Object localObject;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      i = 0;
      j = 0;
      i2 = 0;
      i3 = 0;
      do
      {
        do
        {
          k = i;
          m = j;
          n = i2;
          i1 = i3;
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (j)paramList.next();
        } while (localObject == null);
        localObject = ((j)localObject).a(paramhu);
      } while (localObject == null);
      k = i3;
      if (i3 == 0) {
        k = ((Rect)localObject).left;
      }
      m = i2;
      if (i2 == 0) {
        m = ((Rect)localObject).right;
      }
      n = j;
      if (j == 0) {
        n = ((Rect)localObject).top;
      }
      j = i;
      if (i == 0) {
        j = ((Rect)localObject).bottom;
      }
      i3 = k;
      if (((Rect)localObject).left < k) {
        i3 = ((Rect)localObject).left;
      }
      i2 = m;
      if (((Rect)localObject).right > m) {
        i2 = ((Rect)localObject).right;
      }
      k = n;
      if (((Rect)localObject).top > n) {
        k = ((Rect)localObject).top;
      }
      if (((Rect)localObject).bottom >= j) {
        break label490;
      }
    }
    label483:
    label490:
    for (int i = ((Rect)localObject).bottom;; i = j)
    {
      j = k;
      break;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = k;
      i3 = m;
      int i4 = n;
      int i5 = i1;
      if (paramList1 != null)
      {
        paramList = paramList1.iterator();
        j = m;
        i = k;
        do
        {
          i2 = i;
          i3 = j;
          i4 = n;
          i5 = i1;
          if (!paramList.hasNext()) {
            break;
          }
          paramList1 = (GeoPoint)paramList.next();
        } while (paramList1 == null);
        k = i1;
        if (i1 == 0) {
          k = paramList1.getLongitudeE6();
        }
        m = n;
        if (n == 0) {
          m = paramList1.getLongitudeE6();
        }
        i2 = j;
        if (j == 0) {
          i2 = paramList1.getLatitudeE6();
        }
        j = i;
        if (i == 0) {
          j = paramList1.getLatitudeE6();
        }
        i1 = k;
        if (paramList1.getLongitudeE6() < k) {
          i1 = paramList1.getLongitudeE6();
        }
        n = m;
        if (paramList1.getLongitudeE6() > m) {
          n = paramList1.getLongitudeE6();
        }
        k = i2;
        if (paramList1.getLatitudeE6() > i2) {
          k = paramList1.getLatitudeE6();
        }
        if (paramList1.getLatitudeE6() >= j) {
          break label483;
        }
      }
      for (i = paramList1.getLatitudeE6();; i = j)
      {
        j = k;
        break;
        paramList = new Rect(i5, i3, i4, i2);
        AppMethodBeat.o(148099);
        return paramList;
      }
    }
  }
  
  private GeoPoint a(GeoPoint paramGeoPoint, Rect paramRect)
  {
    AppMethodBeat.i(148102);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(148102);
      return null;
    }
    paramGeoPoint = b(paramGeoPoint);
    if ((paramGeoPoint != null) && (paramRect != null))
    {
      paramGeoPoint = a(new DoublePoint(paramGeoPoint.x - (paramRect.left - paramRect.right) * 0.5D, paramGeoPoint.y - (paramRect.top - paramRect.bottom) * 0.5D));
      AppMethodBeat.o(148102);
      return paramGeoPoint;
    }
    AppMethodBeat.o(148102);
    return null;
  }
  
  private GeoPoint a(GeoPoint paramGeoPoint, iq.b paramb)
  {
    AppMethodBeat.i(148103);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(148103);
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
          break label195;
        }
        d2 = f2;
        d2 = d3 + j * (0.25D - d2);
      }
      for (;;)
      {
        paramGeoPoint = a(new DoublePoint(d1, d2));
        AppMethodBeat.o(148103);
        return paramGeoPoint;
        d1 = d2;
        if (f1 <= 0.75D) {
          break;
        }
        d1 = d2 - (f1 - 0.75D) * i;
        break;
        label195:
        d2 = d3;
        if (f2 > 0.75D)
        {
          d2 = f2;
          d2 = d3 - j * (d2 - 0.75D);
        }
      }
    }
    AppMethodBeat.o(148103);
    return null;
  }
  
  private boolean a()
  {
    AppMethodBeat.i(148100);
    iq.b localb = this.a.q();
    if (localb == null)
    {
      AppMethodBeat.o(148100);
      return false;
    }
    if ((localb.a() != 0.0F) || (localb.b() != 0.0F))
    {
      AppMethodBeat.o(148100);
      return true;
    }
    AppMethodBeat.o(148100);
    return false;
  }
  
  private boolean b()
  {
    AppMethodBeat.i(148101);
    iq.b localb = this.a.q();
    if (localb == null)
    {
      AppMethodBeat.o(148101);
      return false;
    }
    if ((Math.abs(localb.a()) > 0.25D) || (Math.abs(localb.b()) > 0.25D))
    {
      AppMethodBeat.o(148101);
      return true;
    }
    AppMethodBeat.o(148101);
    return false;
  }
  
  public double a(double paramDouble)
  {
    AppMethodBeat.i(148097);
    float f = this.a.j();
    double d = this.a.k();
    d = 40076000.0D / (Math.pow(2.0D, (float)(f + Math.log(d) / Math.log(2.0D))) * 256.0D);
    paramDouble = Math.cos(3.141592653589793D * paramDouble / 180.0D);
    AppMethodBeat.o(148097);
    return d * paramDouble;
  }
  
  public double a(Point paramPoint1, Point paramPoint2)
  {
    return 0.0D;
  }
  
  public GeoPoint a(DoublePoint paramDoublePoint)
  {
    AppMethodBeat.i(148095);
    byte[] arrayOfByte = this.a.r();
    float f1 = (float)paramDoublePoint.x;
    float f2 = (float)paramDoublePoint.y;
    paramDoublePoint = this.b.a(arrayOfByte, f1, f2);
    AppMethodBeat.o(148095);
    return paramDoublePoint;
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(148091);
    this.a.d(paramFloat);
    AppMethodBeat.o(148091);
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148092);
    this.a.a(paramGeoPoint);
    AppMethodBeat.o(148092);
  }
  
  public void a(List<j> paramList, Rect paramRect, hj.a parama)
  {
    AppMethodBeat.i(148093);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(148093);
      return;
    }
    Object localObject = new Rect(this.c.g());
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
    int k = ((hx)localObject).f();
    this.c.a(new hj.1(this, paramList, i, j, paramRect, k, (hx)localObject, parama));
    if (k != 60)
    {
      ((hx)localObject).e();
      ((hx)localObject).g();
    }
    AppMethodBeat.o(148093);
  }
  
  public void a(List<j> paramList, List<GeoPoint> paramList1, Rect paramRect, hj.a parama)
  {
    AppMethodBeat.i(148094);
    if (((paramList == null) || (paramList.isEmpty())) && ((paramList1 == null) || (paramList1.isEmpty())))
    {
      AppMethodBeat.o(148094);
      return;
    }
    Object localObject = new Rect(this.c.g());
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
    int k = ((hx)localObject).f();
    this.c.a(new hj.2(this, paramList, paramList1, i, j, paramRect, k, (hx)localObject, parama));
    if (k != 60)
    {
      ((hx)localObject).e();
      ((hx)localObject).g();
    }
    AppMethodBeat.o(148094);
  }
  
  public DoublePoint b(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148096);
    double d1 = paramGeoPoint.getLatitudeE6() / 1000000.0D;
    double d2 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    paramGeoPoint = this.a.r();
    paramGeoPoint = this.b.a(paramGeoPoint, d1, d2);
    paramGeoPoint = new DoublePoint(paramGeoPoint.x, paramGeoPoint.y);
    AppMethodBeat.o(148096);
    return paramGeoPoint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hj
 * JD-Core Version:    0.7.0.1
 */