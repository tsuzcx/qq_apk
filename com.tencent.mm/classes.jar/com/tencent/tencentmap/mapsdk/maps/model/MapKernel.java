package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions.IMapKernel;

public enum MapKernel
  implements TencentMapOptions.IMapKernel
{
  static
  {
    AppMethodBeat.i(181077);
    Vector = new MapKernel("Vector", 0);
    $VALUES = new MapKernel[] { Vector };
    AppMethodBeat.o(181077);
  }
  
  private MapKernel() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MapKernel
 * JD-Core Version:    0.7.0.1
 */