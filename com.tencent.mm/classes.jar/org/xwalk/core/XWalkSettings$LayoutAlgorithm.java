package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum XWalkSettings$LayoutAlgorithm
{
  static
  {
    AppMethodBeat.i(154861);
    NORMAL = new LayoutAlgorithm("NORMAL", 0);
    SINGLE_COLUMN = new LayoutAlgorithm("SINGLE_COLUMN", 1);
    NARROW_COLUMNS = new LayoutAlgorithm("NARROW_COLUMNS", 2);
    TEXT_AUTOSIZING = new LayoutAlgorithm("TEXT_AUTOSIZING", 3);
    $VALUES = new LayoutAlgorithm[] { NORMAL, SINGLE_COLUMN, NARROW_COLUMNS, TEXT_AUTOSIZING };
    AppMethodBeat.o(154861);
  }
  
  private XWalkSettings$LayoutAlgorithm() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.xwalk.core.XWalkSettings.LayoutAlgorithm
 * JD-Core Version:    0.7.0.1
 */