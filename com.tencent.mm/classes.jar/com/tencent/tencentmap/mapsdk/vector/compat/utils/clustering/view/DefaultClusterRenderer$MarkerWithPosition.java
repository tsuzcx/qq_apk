package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;

class DefaultClusterRenderer$MarkerWithPosition
{
  private final Marker a;
  private LatLng b;
  
  private DefaultClusterRenderer$MarkerWithPosition(Marker paramMarker)
  {
    AppMethodBeat.i(192295);
    this.a = paramMarker;
    this.b = paramMarker.getPosition();
    AppMethodBeat.o(192295);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(192296);
    if ((paramObject instanceof MarkerWithPosition))
    {
      boolean bool = this.a.equals(((MarkerWithPosition)paramObject).a);
      AppMethodBeat.o(192296);
      return bool;
    }
    AppMethodBeat.o(192296);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(192297);
    int i = this.a.hashCode();
    AppMethodBeat.o(192297);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer.MarkerWithPosition
 * JD-Core Version:    0.7.0.1
 */