package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ah.k;
import com.tencent.tencentmap.mapsdk.a.cz;
import com.tencent.tencentmap.mapsdk.a.db;

public class lc
  extends kz
{
  private MapPoi a;
  private kx b;
  
  public lc(kx paramkx, MapPoi paramMapPoi)
  {
    this.a = paramMapPoi;
    this.b = paramkx;
  }
  
  public Rect a()
  {
    AppMethodBeat.i(149134);
    Object localObject = this.b.b().t().b(ka.a(new cz(this.a.getLatitude(), this.a.getLongitude())));
    localObject = new Rect((int)(((DoublePoint)localObject).x - ka.t * 20.0F), (int)(((DoublePoint)localObject).y - ka.t * 20.0F), (int)(((DoublePoint)localObject).x + ka.t * 20.0F), (int)(((DoublePoint)localObject).y + ka.t * 20.0F));
    AppMethodBeat.o(149134);
    return localObject;
  }
  
  public String b()
  {
    AppMethodBeat.i(149135);
    String str = this.a.getPoiName();
    AppMethodBeat.o(149135);
    return str;
  }
  
  public void c()
  {
    AppMethodBeat.i(149136);
    if (this.b != null)
    {
      ah.k localk = this.b.u;
      if (localk != null)
      {
        db localdb = new db();
        localdb.e = new cz(this.a.getLatitude(), this.a.getLongitude());
        localdb.d = this.a.getPoiName();
        localk.a(localdb);
      }
    }
    AppMethodBeat.o(149136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lc
 * JD-Core Version:    0.7.0.1
 */