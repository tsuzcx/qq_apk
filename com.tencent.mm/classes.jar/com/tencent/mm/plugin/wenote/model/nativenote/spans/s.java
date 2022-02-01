package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum s
{
  static
  {
    AppMethodBeat.i(30666);
    CWY = new s("EXACT", 0);
    CWZ = new s("SPAN_FLAGS", 1);
    CXa = new s[] { CWY, CWZ };
    AppMethodBeat.o(30666);
  }
  
  private s() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.s
 * JD-Core Version:    0.7.0.1
 */