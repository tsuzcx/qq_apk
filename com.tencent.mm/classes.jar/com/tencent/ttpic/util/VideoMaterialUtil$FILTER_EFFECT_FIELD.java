package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$FILTER_EFFECT_FIELD
{
  public String value;
  
  static
  {
    AppMethodBeat.i(84107);
    TYPE = new FILTER_EFFECT_FIELD("TYPE", 0, "type");
    ORDER = new FILTER_EFFECT_FIELD("ORDER", 1, "order");
    $VALUES = new FILTER_EFFECT_FIELD[] { TYPE, ORDER };
    AppMethodBeat.o(84107);
  }
  
  private VideoMaterialUtil$FILTER_EFFECT_FIELD(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.FILTER_EFFECT_FIELD
 * JD-Core Version:    0.7.0.1
 */