package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

class jz$a
  extends GeoPoint
{
  float a = 0.0F;
  int b = 0;
  
  public jz$a() {}
  
  public jz$a(GeoPoint paramGeoPoint)
  {
    super(paramGeoPoint);
  }
  
  public String toString()
  {
    AppMethodBeat.i(148876);
    String str = super.toString() + "," + this.a;
    AppMethodBeat.o(148876);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jz.a
 * JD-Core Version:    0.7.0.1
 */