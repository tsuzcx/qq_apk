package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum s
{
  static
  {
    AppMethodBeat.i(30666);
    BER = new s("EXACT", 0);
    BES = new s("SPAN_FLAGS", 1);
    BET = new s[] { BER, BES };
    AppMethodBeat.o(30666);
  }
  
  private s() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.s
 * JD-Core Version:    0.7.0.1
 */