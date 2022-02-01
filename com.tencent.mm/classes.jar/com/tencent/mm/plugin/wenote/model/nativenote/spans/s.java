package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum s
{
  static
  {
    AppMethodBeat.i(30666);
    XBV = new s("EXACT", 0);
    XBW = new s("SPAN_FLAGS", 1);
    XBX = new s[] { XBV, XBW };
    AppMethodBeat.o(30666);
  }
  
  private s() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.s
 * JD-Core Version:    0.7.0.1
 */