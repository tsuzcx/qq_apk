package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class TranslateAnimation
  extends BaseAnimation
{
  public LatLng mTargetLatLng;
  
  public TranslateAnimation(LatLng paramLatLng)
  {
    AppMethodBeat.i(173394);
    this.mTargetLatLng = paramLatLng;
    AppMethodBeat.o(173394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TranslateAnimation
 * JD-Core Version:    0.7.0.1
 */