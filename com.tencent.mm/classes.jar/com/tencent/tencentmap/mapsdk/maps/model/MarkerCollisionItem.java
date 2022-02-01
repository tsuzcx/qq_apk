package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;

public enum MarkerCollisionItem
  implements Collision
{
  static
  {
    AppMethodBeat.i(237748);
    POI = new MarkerCollisionItem("POI", 0);
    $VALUES = new MarkerCollisionItem[] { POI };
    AppMethodBeat.o(237748);
  }
  
  private MarkerCollisionItem() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionItem
 * JD-Core Version:    0.7.0.1
 */