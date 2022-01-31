package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;

class nv$b
  implements nv.a
{
  private boolean b = false;
  
  public nv$b(nv paramnv, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void a()
  {
    if ((nv.a(this.a) == null) || (nv.a(this.a).D == 0) || (nv.a(this.a).E == 0)) {}
    do
    {
      return;
      nv.a(this.a).setOnSurfaceChangedListener(null);
    } while ((nv.a(this.a).w == null) || (nv.a(this.a).x == null));
    Object localObject = new GeoPoint();
    float f;
    int i;
    int j;
    if ((nv.a(this.a).z == 0) && (nv.a(this.a).A == 0) && (nv.a(this.a).B == 0) && (nv.a(this.a).C == 0))
    {
      f = this.a.a(0, 0, 0, 0, nv.a(this.a).w, nv.a(this.a).x, (GeoPoint)localObject);
      ah.a locala = nv.a(this.a).F;
      i = ((GeoPoint)localObject).getLatitudeE6();
      j = ((GeoPoint)localObject).getLongitudeE6();
      if (!this.b) {
        break label422;
      }
      localObject = new lx(10000);
      ((lx)localObject).c(0.0F);
      ((lx)localObject).d(0.0F);
      ((lx)localObject).c(i, j);
      ((lx)localObject).a(f);
      ((lx)localObject).a(nv.b(this.a));
      ((lx)localObject).a(locala);
      nv.a(this.a).getMap().a((iv)localObject);
    }
    for (;;)
    {
      nv.a(this.a).w = null;
      nv.a(this.a).x = null;
      nv.a(this.a).z = 0;
      nv.a(this.a).A = 0;
      nv.a(this.a).B = 0;
      nv.a(this.a).C = 0;
      nv.a(this.a).F = null;
      return;
      f = this.a.a(nv.a(this.a).z, nv.a(this.a).A, nv.a(this.a).B, nv.a(this.a).C, nv.a(this.a).w, nv.a(this.a).x, (GeoPoint)localObject);
      break;
      label422:
      nv.a(this.a).getMap().b(0.0F);
      nv.a(this.a).getMap().a(0.0F);
      nv.a(this.a).getMap().a(i, j);
      nv.a(this.a, f, false, 0L, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nv.b
 * JD-Core Version:    0.7.0.1
 */