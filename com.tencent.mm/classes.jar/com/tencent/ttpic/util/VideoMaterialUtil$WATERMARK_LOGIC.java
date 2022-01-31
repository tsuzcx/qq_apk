package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$WATERMARK_LOGIC
{
  public String value;
  
  static
  {
    AppMethodBeat.i(84137);
    TYPE = new WATERMARK_LOGIC("TYPE", 0, "type");
    COMPARE = new WATERMARK_LOGIC("COMPARE", 1, "compare");
    DATA = new WATERMARK_LOGIC("DATA", 2, "data");
    RANGE = new WATERMARK_LOGIC("RANGE", 3, "range");
    CASE = new WATERMARK_LOGIC("CASE", 4, "case");
    $VALUES = new WATERMARK_LOGIC[] { TYPE, COMPARE, DATA, RANGE, CASE };
    AppMethodBeat.o(84137);
  }
  
  private VideoMaterialUtil$WATERMARK_LOGIC(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.WATERMARK_LOGIC
 * JD-Core Version:    0.7.0.1
 */