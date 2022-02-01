package com.tencent.tencentmap.mapsdk.maps.model;

public abstract interface VectorHeatOverlay
{
  public abstract VectorHeatAggregationUnit getUnit(LatLng paramLatLng);
  
  public abstract void remove();
  
  public abstract void setOpacity(float paramFloat);
  
  public abstract void setVisibility(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay
 * JD-Core Version:    0.7.0.1
 */