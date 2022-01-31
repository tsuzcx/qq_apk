package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

class hj$1
  implements ik.a
{
  hj$1(hj paramhj, List paramList, int paramInt1, int paramInt2, Rect paramRect, int paramInt3, hx paramhx, hj.a parama) {}
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148088);
    GeoPoint localGeoPoint2 = hj.a(this.h).p();
    float f2 = hj.a(this.h).i();
    paramGL10 = null;
    float f1 = 4.0F;
    float f3 = hj.a(this.h).o();
    for (;;)
    {
      Object localObject;
      GeoPoint localGeoPoint1;
      if (f1 >= f3)
      {
        this.h.a(f1);
        localObject = hj.a(this.h, this.a, this.h);
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
          break label410;
        }
        if (hj.b(this.h)) {
          break label362;
        }
        paramGL10 = hj.a(this.h, localGeoPoint1, this.d);
      }
      for (;;)
      {
        f1 = Math.max(f3, f1);
        if (this.e != 60) {
          this.f.a(this.e);
        }
        this.h.a(localGeoPoint2);
        this.h.a(f2);
        if (this.g == null) {
          break;
        }
        label362:
        try
        {
          this.g.a(f1, paramGL10, -1.0D);
          AppMethodBeat.o(148088);
          return;
        }
        catch (Exception paramGL10) {}
        paramGL10 = localGeoPoint1;
        if (hj.c(this.h))
        {
          localObject = hj.a(this.h).q();
          paramGL10 = localGeoPoint1;
          if (localObject != null) {
            paramGL10 = hj.a(this.h, localGeoPoint1, (iq.b)localObject);
          }
        }
      }
      label410:
      f1 /= 1.01F;
      paramGL10 = localGeoPoint1;
    }
    AppMethodBeat.o(148088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hj.1
 * JD-Core Version:    0.7.0.1
 */