package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final q EAK;
  public int pxd;
  public int pxe;
  
  public a(q paramq, int paramInt1, int paramInt2)
  {
    this.EAK = paramq;
    this.pxd = paramInt1;
    this.pxe = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30624);
    String str = this.EAK.name() + " - " + this.pxd + "/" + this.pxe;
    AppMethodBeat.o(30624);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */