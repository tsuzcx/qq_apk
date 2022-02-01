package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.utilities.heatmap.WeightedLatLng;

public class VectorHeatAggregationUnit
{
  private LatLng mCenter;
  private double mIntensity;
  private WeightedLatLng[] mNodes;
  
  private VectorHeatAggregationUnit() {}
  
  private VectorHeatAggregationUnit(LatLng paramLatLng, double paramDouble, WeightedLatLng[] paramArrayOfWeightedLatLng)
  {
    this.mCenter = paramLatLng;
    this.mIntensity = paramDouble;
    this.mNodes = paramArrayOfWeightedLatLng;
  }
  
  public LatLng getCenter()
  {
    return this.mCenter;
  }
  
  public double getIntensity()
  {
    return this.mIntensity;
  }
  
  public WeightedLatLng[] getNodes()
  {
    return this.mNodes;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit
 * JD-Core Version:    0.7.0.1
 */