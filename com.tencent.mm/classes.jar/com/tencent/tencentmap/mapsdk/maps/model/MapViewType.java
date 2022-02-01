package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MapViewType
{
  static
  {
    AppMethodBeat.i(181084);
    SurfaceView = new MapViewType("SurfaceView", 0);
    TextureView = new MapViewType("TextureView", 1);
    RenderLayer = new MapViewType("RenderLayer", 2);
    $VALUES = new MapViewType[] { SurfaceView, TextureView, RenderLayer };
    AppMethodBeat.o(181084);
  }
  
  private MapViewType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MapViewType
 * JD-Core Version:    0.7.0.1
 */