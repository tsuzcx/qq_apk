package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FILL_STYLE
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(50232);
    CUT = new FILL_STYLE("CUT", 0, 0);
    STRETCH = new FILL_STYLE("STRETCH", 1, 1);
    SPACE = new FILL_STYLE("SPACE", 2, 2);
    FRAME_STYLE_CUT = new FILL_STYLE("FRAME_STYLE_CUT", 3, 3);
    $VALUES = new FILL_STYLE[] { CUT, STRETCH, SPACE, FRAME_STYLE_CUT };
    AppMethodBeat.o(50232);
  }
  
  private FILL_STYLE(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.model.FILL_STYLE
 * JD-Core Version:    0.7.0.1
 */