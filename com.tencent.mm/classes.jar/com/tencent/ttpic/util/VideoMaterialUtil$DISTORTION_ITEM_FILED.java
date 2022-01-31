package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$DISTORTION_ITEM_FILED
{
  public String value;
  
  static
  {
    AppMethodBeat.i(84068);
    POSITION = new DISTORTION_ITEM_FILED("POSITION", 0, "position");
    DISTORTION = new DISTORTION_ITEM_FILED("DISTORTION", 1, "distortion");
    DIRECTION = new DISTORTION_ITEM_FILED("DIRECTION", 2, "direction");
    RADIUS = new DISTORTION_ITEM_FILED("RADIUS", 3, "radius");
    STRENGH = new DISTORTION_ITEM_FILED("STRENGH", 4, "strength");
    X = new DISTORTION_ITEM_FILED("X", 5, "dx");
    Y = new DISTORTION_ITEM_FILED("Y", 6, "dy");
    TARGETDX = new DISTORTION_ITEM_FILED("TARGETDX", 7, "targetDx");
    TARGETDY = new DISTORTION_ITEM_FILED("TARGETDY", 8, "targetDy");
    $VALUES = new DISTORTION_ITEM_FILED[] { POSITION, DISTORTION, DIRECTION, RADIUS, STRENGH, X, Y, TARGETDX, TARGETDY };
    AppMethodBeat.o(84068);
  }
  
  private VideoMaterialUtil$DISTORTION_ITEM_FILED(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.DISTORTION_ITEM_FILED
 * JD-Core Version:    0.7.0.1
 */