package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum WebSettings$LayoutAlgorithm
{
  static
  {
    AppMethodBeat.i(55044);
    NORMAL = new LayoutAlgorithm("NORMAL", 0);
    SINGLE_COLUMN = new LayoutAlgorithm("SINGLE_COLUMN", 1);
    NARROW_COLUMNS = new LayoutAlgorithm("NARROW_COLUMNS", 2);
    $VALUES = new LayoutAlgorithm[] { NORMAL, SINGLE_COLUMN, NARROW_COLUMNS };
    AppMethodBeat.o(55044);
  }
  
  private WebSettings$LayoutAlgorithm() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm
 * JD-Core Version:    0.7.0.1
 */