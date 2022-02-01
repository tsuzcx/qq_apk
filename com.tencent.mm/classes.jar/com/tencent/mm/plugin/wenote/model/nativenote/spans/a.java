package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final q QIm;
  public int uvf;
  public int uvg;
  
  public a(q paramq, int paramInt1, int paramInt2)
  {
    this.QIm = paramq;
    this.uvf = paramInt1;
    this.uvg = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30624);
    String str = this.QIm.name() + " - " + this.uvf + "/" + this.uvg;
    AppMethodBeat.o(30624);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */