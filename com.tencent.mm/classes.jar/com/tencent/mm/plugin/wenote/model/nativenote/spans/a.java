package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final q JIU;
  public int qSZ;
  public int qTa;
  
  public a(q paramq, int paramInt1, int paramInt2)
  {
    this.JIU = paramq;
    this.qSZ = paramInt1;
    this.qTa = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30624);
    String str = this.JIU.name() + " - " + this.qSZ + "/" + this.qTa;
    AppMethodBeat.o(30624);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */