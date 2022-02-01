package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class VisibleRegion
{
  public final LatLng farLeft;
  public final LatLng farRight;
  public final LatLngBounds latLngBounds;
  public final LatLng nearLeft;
  public final LatLng nearRight;
  
  public VisibleRegion(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this.nearLeft = paramLatLng1;
    this.nearRight = paramLatLng2;
    this.farLeft = paramLatLng3;
    this.farRight = paramLatLng4;
    this.latLngBounds = paramLatLngBounds;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(173397);
    if (this == paramObject)
    {
      AppMethodBeat.o(173397);
      return true;
    }
    if (!(paramObject instanceof VisibleRegion))
    {
      AppMethodBeat.o(173397);
      return false;
    }
    paramObject = (VisibleRegion)paramObject;
    if ((this.nearLeft.equals(paramObject.nearLeft)) && (this.nearRight.equals(paramObject.nearRight)) && (this.farLeft.equals(paramObject.farLeft)) && (this.farRight.equals(paramObject.farRight)) && (this.latLngBounds.equals(paramObject.latLngBounds)))
    {
      AppMethodBeat.o(173397);
      return true;
    }
    AppMethodBeat.o(173397);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(173398);
    String str = "nearLeft" + this.nearLeft + "nearRight" + this.nearRight + "farLeft" + this.farLeft + "farRight" + this.farRight + "latLngBounds" + this.latLngBounds;
    AppMethodBeat.o(173398);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion
 * JD-Core Version:    0.7.0.1
 */