package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class ScaleAnimation
  extends BaseAnimation
{
  public float mFromX;
  public float mFromY;
  public float mToX;
  public float mToY;
  
  public ScaleAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(173373);
    this.mFromX = paramFloat1;
    this.mToX = paramFloat2;
    this.mFromY = paramFloat3;
    this.mToY = paramFloat4;
    AppMethodBeat.o(173373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.ScaleAnimation
 * JD-Core Version:    0.7.0.1
 */