package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final q XBL;
  public int xBC;
  public int xBD;
  
  public a(q paramq, int paramInt1, int paramInt2)
  {
    this.XBL = paramq;
    this.xBC = paramInt1;
    this.xBD = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30624);
    String str = this.XBL.name() + " - " + this.xBC + "/" + this.xBD;
    AppMethodBeat.o(30624);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */