package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FaceItemCal
{
  private final int easeCurve;
  private final float end;
  private final float endProgress;
  private final float start;
  private final float startProgress;
  
  static
  {
    AppMethodBeat.i(83879);
    FACE_WIDTH = new FaceItemCal("FACE_WIDTH", 0, 1.1F, 0.9F);
    EYE_DIST_X = new FaceItemCal("EYE_DIST_X", 1, 0.9F, 1.1F);
    EYE_WIDTH = new FaceItemCal("EYE_WIDTH", 2, 1.2F, 0.8F);
    EYE_HEIGHT = new FaceItemCal("EYE_HEIGHT", 3, 1.2F, 0.8F);
    EYE_ANGLE = new FaceItemCal("EYE_ANGLE", 4, 0.261799F, -0.261799F);
    BROW_DIST_X = new FaceItemCal("BROW_DIST_X", 5, 0.8F, 1.2F);
    BROW_DIST_Y = new FaceItemCal("BROW_DIST_Y", 6, 0.8F, 1.2F);
    BROW_DIST_Y2 = new FaceItemCal("BROW_DIST_Y2", 7, 8.0F, -8.0F);
    BROW_ANGLE = new FaceItemCal("BROW_ANGLE", 8, 0.261799F, -0.261799F);
    NOSE_DIST_Y = new FaceItemCal("NOSE_DIST_Y", 9, 1.2F, 0.8F);
    NOSE_DIST_Y2 = new FaceItemCal("NOSE_DIST_Y2", 10, 8.0F, -8.0F);
    NOSE_WIDTH = new FaceItemCal("NOSE_WIDTH", 11, 0.88F, 1.12F);
    MOUTH_DIST_Y = new FaceItemCal("MOUTH_DIST_Y", 12, 0.8F, 1.2F);
    MOUTH_DIST_Y2 = new FaceItemCal("MOUTH_DIST_Y2", 13, -8.0F, 8.0F);
    MOUTH_WIDTH = new FaceItemCal("MOUTH_WIDTH", 14, 1.2F, 0.8F);
    MOUTH_HEIGHT = new FaceItemCal("MOUTH_HEIGHT", 15, 1.2F, 0.8F);
    FACE_V = new FaceItemCal("FACE_V", 16, 1.2F, 0.8F);
    FACE_JAW = new FaceItemCal("FACE_JAW", 17, -8.0F, 8.0F);
    $VALUES = new FaceItemCal[] { FACE_WIDTH, EYE_DIST_X, EYE_WIDTH, EYE_HEIGHT, EYE_ANGLE, BROW_DIST_X, BROW_DIST_Y, BROW_DIST_Y2, BROW_ANGLE, NOSE_DIST_Y, NOSE_DIST_Y2, NOSE_WIDTH, MOUTH_DIST_Y, MOUTH_DIST_Y2, MOUTH_WIDTH, MOUTH_HEIGHT, FACE_V, FACE_JAW };
    AppMethodBeat.o(83879);
  }
  
  private FaceItemCal(float paramFloat1, float paramFloat2)
  {
    this(100.0F, paramFloat1, -100.0F, paramFloat2, 0);
  }
  
  private FaceItemCal(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    this.start = paramFloat1;
    this.startProgress = paramFloat2;
    this.end = paramFloat3;
    this.endProgress = paramFloat4;
    this.easeCurve = paramInt;
  }
  
  private static double getValue(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    AppMethodBeat.i(83878);
    paramDouble2 = (paramDouble5 - paramDouble2) / (paramDouble4 - paramDouble2);
    switch (paramInt)
    {
    default: 
      paramDouble1 = paramDouble2 * (paramDouble3 - paramDouble1) + paramDouble1;
    }
    for (;;)
    {
      AppMethodBeat.o(83878);
      return paramDouble1;
      paramDouble1 = -(paramDouble3 - paramDouble1);
      paramDouble1 = Math.cos(paramDouble2 * 1.570796326794897D) * paramDouble1 + paramDouble3;
      continue;
      paramDouble1 = Math.sin(paramDouble2 * 1.570796326794897D) * (paramDouble3 - paramDouble1) + paramDouble1;
      continue;
      paramDouble3 = -(paramDouble3 - paramDouble1) / 2.0D;
      paramDouble1 = (Math.cos(paramDouble2 * 3.141592653589793D) - 1.0D) * paramDouble3 + paramDouble1;
    }
  }
  
  public final float getAdjustValue(float paramFloat)
  {
    AppMethodBeat.i(83877);
    paramFloat = (float)getValue(this.easeCurve, this.start, this.startProgress, this.end, this.endProgress, paramFloat);
    AppMethodBeat.o(83877);
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceItemCal
 * JD-Core Version:    0.7.0.1
 */