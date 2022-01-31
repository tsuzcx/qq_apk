package com.tencent.ttpic.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum HorizontalSkewFilter$PARAM_KEY
{
  public final String value;
  
  static
  {
    AppMethodBeat.i(82604);
    ADJUST = new PARAM_KEY("ADJUST", 0, "adjust");
    $VALUES = new PARAM_KEY[] { ADJUST };
    AppMethodBeat.o(82604);
  }
  
  private HorizontalSkewFilter$PARAM_KEY(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.HorizontalSkewFilter.PARAM_KEY
 * JD-Core Version:    0.7.0.1
 */