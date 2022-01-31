package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

class hj$2
  implements ik.a
{
  hj$2(hj paramhj, List paramList1, List paramList2, int paramInt1, int paramInt2, Rect paramRect, int paramInt3, hx paramhx, hj.a parama) {}
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148089);
    GeoPoint localGeoPoint2 = hj.a(this.i).p();
    float f2 = hj.a(this.i).i();
    paramGL10 = null;
    float f1 = 4.0F;
    float f3 = hj.a(this.i).o();
    for (;;)
    {
      Object localObject;
      GeoPoint localGeoPoint1;
      if (f1 >= f3)
      {
        this.i.a(f1);
        localObject = hj.a(this.i, this.a, this.b, this.i);
        localGeoPoint1 = new GeoPoint(((Rect)localObject).centerY(), ((Rect)localObject).centerX());
        this.i.a(localGeoPoint1);
        paramGL10 = new GeoPoint(((Rect)localObject).top, ((Rect)localObject).left);
        localObject = new GeoPoint(((Rect)localObject).bottom, ((Rect)localObject).right);
        paramGL10 = this.i.b(paramGL10);
        localObject = this.i.b((GeoPoint)localObject);
        Rect localRect = new Rect();
        localRect.left = ((int)Math.min(paramGL10.x, ((DoublePoint)localObject).x));
        localRect.right = ((int)Math.max(paramGL10.x, ((DoublePoint)localObject).x));
        localRect.top = ((int)Math.min(paramGL10.y, ((DoublePoint)localObject).y));
        localRect.bottom = ((int)Math.max(paramGL10.y, ((DoublePoint)localObject).y));
        if ((this.c < localRect.width()) || (this.d < localRect.height())) {
          break label414;
        }
        if (hj.b(this.i)) {
          break label366;
        }
        paramGL10 = hj.a(this.i, localGeoPoint1, this.e);
      }
      for (;;)
      {
        f1 = Math.max(f3, f1);
        if (this.f != 60) {
          this.g.a(this.f);
        }
        this.i.a(localGeoPoint2);
        this.i.a(f2);
        if (this.h == null) {
          break;
        }
        label366:
        try
        {
          this.h.a(f1, paramGL10, -1.0D);
          AppMethodBeat.o(148089);
          return;
        }
        catch (Exception paramGL10) {}
        paramGL10 = localGeoPoint1;
        if (hj.c(this.i))
        {
          localObject = hj.a(this.i).q();
          paramGL10 = localGeoPoint1;
          if (localObject != null) {
            paramGL10 = hj.a(this.i, localGeoPoint1, (iq.b)localObject);
          }
        }
      }
      label414:
      f1 /= 1.01F;
      paramGL10 = localGeoPoint1;
    }
    AppMethodBeat.o(148089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hj.2
 * JD-Core Version:    0.7.0.1
 */