package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$CANVAS_ITEM_FILED
{
  public String value;
  
  static
  {
    AppMethodBeat.i(84059);
    TYPE = new CANVAS_ITEM_FILED("TYPE", 0, "type");
    INDEX = new CANVAS_ITEM_FILED("INDEX", 1, "index");
    START_TIME = new CANVAS_ITEM_FILED("START_TIME", 2, "startTime");
    END_TIME = new CANVAS_ITEM_FILED("END_TIME", 3, "endTime");
    Z_INDEX = new CANVAS_ITEM_FILED("Z_INDEX", 4, "zIndex");
    ITEM_RECT = new CANVAS_ITEM_FILED("ITEM_RECT", 5, "itemRect");
    ITEM_RESIZE_MODE = new CANVAS_ITEM_FILED("ITEM_RESIZE_MODE", 6, "itemResizeMode");
    $VALUES = new CANVAS_ITEM_FILED[] { TYPE, INDEX, START_TIME, END_TIME, Z_INDEX, ITEM_RECT, ITEM_RESIZE_MODE };
    AppMethodBeat.o(84059);
  }
  
  private VideoMaterialUtil$CANVAS_ITEM_FILED(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.CANVAS_ITEM_FILED
 * JD-Core Version:    0.7.0.1
 */