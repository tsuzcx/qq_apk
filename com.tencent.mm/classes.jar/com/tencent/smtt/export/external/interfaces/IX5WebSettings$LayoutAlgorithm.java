package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum IX5WebSettings$LayoutAlgorithm
{
  static
  {
    AppMethodBeat.i(63803);
    NORMAL = new LayoutAlgorithm("NORMAL", 0);
    SINGLE_COLUMN = new LayoutAlgorithm("SINGLE_COLUMN", 1);
    NARROW_COLUMNS = new LayoutAlgorithm("NARROW_COLUMNS", 2);
    $VALUES = new LayoutAlgorithm[] { NORMAL, SINGLE_COLUMN, NARROW_COLUMNS };
    AppMethodBeat.o(63803);
  }
  
  private IX5WebSettings$LayoutAlgorithm() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm
 * JD-Core Version:    0.7.0.1
 */