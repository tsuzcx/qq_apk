package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$ITEM_SOURCE_TYPE
{
  static
  {
    AppMethodBeat.i(84113);
    IMAGE = new ITEM_SOURCE_TYPE("IMAGE", 0);
    VIDEO_UP_DOWN = new ITEM_SOURCE_TYPE("VIDEO_UP_DOWN", 1);
    VIDEO_LEFT_RIGHT = new ITEM_SOURCE_TYPE("VIDEO_LEFT_RIGHT", 2);
    VIDEO_NORMAL = new ITEM_SOURCE_TYPE("VIDEO_NORMAL", 3);
    $VALUES = new ITEM_SOURCE_TYPE[] { IMAGE, VIDEO_UP_DOWN, VIDEO_LEFT_RIGHT, VIDEO_NORMAL };
    AppMethodBeat.o(84113);
  }
  
  private VideoMaterialUtil$ITEM_SOURCE_TYPE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE
 * JD-Core Version:    0.7.0.1
 */