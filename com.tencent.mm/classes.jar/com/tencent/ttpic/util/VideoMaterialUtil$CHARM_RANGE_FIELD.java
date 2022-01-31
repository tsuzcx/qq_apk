package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$CHARM_RANGE_FIELD
{
  public String value;
  
  static
  {
    AppMethodBeat.i(84062);
    MIN = new CHARM_RANGE_FIELD("MIN", 0, "min");
    MAX = new CHARM_RANGE_FIELD("MAX", 1, "max");
    $VALUES = new CHARM_RANGE_FIELD[] { MIN, MAX };
    AppMethodBeat.o(84062);
  }
  
  private VideoMaterialUtil$CHARM_RANGE_FIELD(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.CHARM_RANGE_FIELD
 * JD-Core Version:    0.7.0.1
 */