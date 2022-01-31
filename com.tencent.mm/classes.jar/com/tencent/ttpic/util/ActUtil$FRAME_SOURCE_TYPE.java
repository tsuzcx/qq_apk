package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ActUtil$FRAME_SOURCE_TYPE
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(83800);
    NONE = new FRAME_SOURCE_TYPE("NONE", 0, 0);
    CAMERA = new FRAME_SOURCE_TYPE("CAMERA", 1, 1);
    VIDEO = new FRAME_SOURCE_TYPE("VIDEO", 2, 2);
    TOTAL_SCORE = new FRAME_SOURCE_TYPE("TOTAL_SCORE", 3, 3);
    CAPTURE = new FRAME_SOURCE_TYPE("CAPTURE", 4, 4);
    SINGEL_SCORE = new FRAME_SOURCE_TYPE("SINGEL_SCORE", 5, 5);
    STAR_IMAGE = new FRAME_SOURCE_TYPE("STAR_IMAGE", 6, 6);
    $VALUES = new FRAME_SOURCE_TYPE[] { NONE, CAMERA, VIDEO, TOTAL_SCORE, CAPTURE, SINGEL_SCORE, STAR_IMAGE };
    AppMethodBeat.o(83800);
  }
  
  private ActUtil$FRAME_SOURCE_TYPE(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.ActUtil.FRAME_SOURCE_TYPE
 * JD-Core Version:    0.7.0.1
 */