package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class RotateAnimation
  extends BaseAnimation
{
  public float mFromDegree;
  public float mPivoteX;
  public float mPivoteY;
  public float mPivoteZ;
  public float mToDegree;
  
  public RotateAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    AppMethodBeat.i(173370);
    this.mFromDegree = paramFloat1;
    this.mToDegree = paramFloat2;
    this.mPivoteX = paramFloat3;
    this.mPivoteY = paramFloat4;
    this.mPivoteZ = paramFloat5;
    AppMethodBeat.o(173370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.RotateAnimation
 * JD-Core Version:    0.7.0.1
 */