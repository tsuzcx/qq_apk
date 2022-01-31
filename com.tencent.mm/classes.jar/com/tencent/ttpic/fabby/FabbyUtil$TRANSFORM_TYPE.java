package com.tencent.ttpic.fabby;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FabbyUtil$TRANSFORM_TYPE
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(81881);
    ORIGIN = new TRANSFORM_TYPE("ORIGIN", 0, 0);
    MIRROR_TOP_BOTTOM = new TRANSFORM_TYPE("MIRROR_TOP_BOTTOM", 1, 1);
    MIRROR_LEFT_RIGHT = new TRANSFORM_TYPE("MIRROR_LEFT_RIGHT", 2, 2);
    $VALUES = new TRANSFORM_TYPE[] { ORIGIN, MIRROR_TOP_BOTTOM, MIRROR_LEFT_RIGHT };
    AppMethodBeat.o(81881);
  }
  
  private FabbyUtil$TRANSFORM_TYPE(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.fabby.FabbyUtil.TRANSFORM_TYPE
 * JD-Core Version:    0.7.0.1
 */