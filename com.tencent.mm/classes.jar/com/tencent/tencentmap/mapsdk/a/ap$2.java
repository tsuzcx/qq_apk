package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.kk.a;
import com.tencent.tencentmap.mapsdk.maps.a.kx;

class ap$2
  implements kk.a
{
  ap$2(ap paramap) {}
  
  public float a()
  {
    AppMethodBeat.i(149641);
    if (ap.a(this.a) == null)
    {
      AppMethodBeat.o(149641);
      return 0.0F;
    }
    float f = this.a.r();
    AppMethodBeat.o(149641);
    return f;
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(149644);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(149644);
      return;
    }
    if ((ap.a(this.a) == null) || (ap.a(this.a).I == null))
    {
      AppMethodBeat.o(149644);
      return;
    }
    ap.a(this.a).I.postDelayed(paramRunnable, 100L);
    AppMethodBeat.o(149644);
  }
  
  public int b()
  {
    AppMethodBeat.i(149637);
    if (ap.a(this.a) == null)
    {
      AppMethodBeat.o(149637);
      return 0;
    }
    int i = ap.a(this.a).b().c();
    AppMethodBeat.o(149637);
    return i;
  }
  
  public GeoPoint c()
  {
    AppMethodBeat.i(149638);
    if (ap.a(this.a) == null)
    {
      AppMethodBeat.o(149638);
      return null;
    }
    GeoPoint localGeoPoint = ap.a(this.a).b().f();
    AppMethodBeat.o(149638);
    return localGeoPoint;
  }
  
  public float d()
  {
    AppMethodBeat.i(149639);
    if (ap.a(this.a) == null)
    {
      AppMethodBeat.o(149639);
      return 0.0F;
    }
    float f = ap.a(this.a).b().q();
    AppMethodBeat.o(149639);
    return f;
  }
  
  public float e()
  {
    AppMethodBeat.i(149640);
    if (ap.a(this.a) == null)
    {
      AppMethodBeat.o(149640);
      return 0.0F;
    }
    float f = ap.a(this.a).b().r();
    AppMethodBeat.o(149640);
    return f;
  }
  
  public GeoPoint f()
  {
    AppMethodBeat.i(149642);
    if (ap.a(this.a) == null)
    {
      AppMethodBeat.o(149642);
      return null;
    }
    GeoPoint localGeoPoint = ap.a(this.a).I();
    AppMethodBeat.o(149642);
    return localGeoPoint;
  }
  
  public boolean g()
  {
    AppMethodBeat.i(149643);
    if (ap.a(this.a) == null)
    {
      AppMethodBeat.o(149643);
      return false;
    }
    boolean bool = ap.a(this.a).H().c();
    AppMethodBeat.o(149643);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ap.2
 * JD-Core Version:    0.7.0.1
 */