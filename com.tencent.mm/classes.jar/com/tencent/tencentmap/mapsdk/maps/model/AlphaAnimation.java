package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AlphaAnimation
  extends BaseAnimation
{
  public float mFromAlpha;
  public float mToAlpha;
  
  public AlphaAnimation(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(173072);
    this.mFromAlpha = paramFloat1;
    this.mToAlpha = paramFloat2;
    AppMethodBeat.o(173072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.AlphaAnimation
 * JD-Core Version:    0.7.0.1
 */