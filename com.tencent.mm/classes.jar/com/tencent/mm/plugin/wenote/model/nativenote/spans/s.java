package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum s
{
  static
  {
    AppMethodBeat.i(30666);
    EAU = new s("EXACT", 0);
    EAV = new s("SPAN_FLAGS", 1);
    EAW = new s[] { EAU, EAV };
    AppMethodBeat.o(30666);
  }
  
  private s() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.s
 * JD-Core Version:    0.7.0.1
 */