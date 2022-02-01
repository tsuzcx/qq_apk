package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final q ETg;
  public int pDH;
  public int pDI;
  
  public a(q paramq, int paramInt1, int paramInt2)
  {
    this.ETg = paramq;
    this.pDH = paramInt1;
    this.pDI = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30624);
    String str = this.ETg.name() + " - " + this.pDH + "/" + this.pDI;
    AppMethodBeat.o(30624);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */