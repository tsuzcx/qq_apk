package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum XWalkUIClient$LoadStatus
{
  static
  {
    AppMethodBeat.i(85859);
    FINISHED = new LoadStatus("FINISHED", 0);
    FAILED = new LoadStatus("FAILED", 1);
    CANCELLED = new LoadStatus("CANCELLED", 2);
    $VALUES = new LoadStatus[] { FINISHED, FAILED, CANCELLED };
    AppMethodBeat.o(85859);
  }
  
  private XWalkUIClient$LoadStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.xwalk.core.XWalkUIClient.LoadStatus
 * JD-Core Version:    0.7.0.1
 */