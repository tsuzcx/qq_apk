package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

class ii$1
  implements jh.a
{
  ii$1(ii paramii, List paramList, int paramInt1, int paramInt2, Rect paramRect, int paramInt3, ix paramix, ii.a parama) {}
  
  public void a(GL10 paramGL10)
  {
    GeoPoint localGeoPoint2 = ii.a(this.h).o();
    float f2 = ii.a(this.h).h();
    paramGL10 = null;
    float f1 = 4.0F;
    float f3 = ii.a(this.h).n();
    for (;;)
    {
      Object localObject;
      GeoPoint localGeoPoint1;
      if (f1 >= f3)
      {
        this.h.a(f1);
        localObject = ii.a(this.h, this.a, this.h);
        localGeoPoint1 = new GeoPoint(((Rect)localObject).centerY(), ((Rect)localObject).centerX());
        this.h.a(localGeoPoint1);
        paramGL10 = new GeoPoint(((Rect)localObject).top, ((Rect)localObject).left);
        localObject = new GeoPoint(((Rect)localObject).bottom, ((Rect)localObject).right);
        paramGL10 = this.h.b(paramGL10);
        localObject = this.h.b((GeoPoint)localObject);
        Rect localRect = new Rect();
        localRect.left = ((int)Math.min(paramGL10.x, ((DoublePoint)localObject).x));
        localRect.right = ((int)Math.max(paramGL10.x, ((DoublePoint)localObject).x));
        localRect.top = ((int)Math.min(paramGL10.y, ((DoublePoint)localObject).y));
        localRect.bottom = ((int)Math.max(paramGL10.y, ((DoublePoint)localObject).y));
        if ((this.b < localRect.width()) || (this.c < localRect.height())) {
          break label400;
        }
        if (ii.b(this.h)) {
          break label352;
        }
        paramGL10 = ii.a(this.h, localGeoPoint1, this.d);
      }
      for (;;)
      {
        f1 = Math.max(f3, f1);
        if (this.e != 60) {
          this.f.a(this.e);
        }
        this.h.a(localGeoPoint2);
        this.h.a(f2);
        if (this.g != null) {}
        label352:
        try
        {
          this.g.a(f1, paramGL10, -1.0D);
          return;
        }
        catch (Exception paramGL10) {}
        paramGL10 = localGeoPoint1;
        if (ii.c(this.h))
        {
          localObject = ii.a(this.h).p();
          paramGL10 = localGeoPoint1;
          if (localObject != null) {
            paramGL10 = ii.a(this.h, localGeoPoint1, (jo.b)localObject);
          }
        }
      }
      label400:
      f1 /= 1.01F;
      paramGL10 = localGeoPoint1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ii.1
 * JD-Core Version:    0.7.0.1
 */