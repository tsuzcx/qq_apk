package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final q BEH;
  public int opT;
  public int opU;
  
  public a(q paramq, int paramInt1, int paramInt2)
  {
    this.BEH = paramq;
    this.opT = paramInt1;
    this.opU = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30624);
    String str = this.BEH.name() + " - " + this.opT + "/" + this.opU;
    AppMethodBeat.o(30624);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */