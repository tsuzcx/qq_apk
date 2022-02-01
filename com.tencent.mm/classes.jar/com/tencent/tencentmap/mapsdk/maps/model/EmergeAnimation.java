package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class EmergeAnimation
  extends BaseAnimation
{
  public LatLng mStartPoint;
  
  public EmergeAnimation(LatLng paramLatLng)
  {
    AppMethodBeat.i(173136);
    this.mStartPoint = paramLatLng;
    AppMethodBeat.o(173136);
  }
  
  public LatLng getStartPoint()
  {
    return this.mStartPoint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.EmergeAnimation
 * JD-Core Version:    0.7.0.1
 */