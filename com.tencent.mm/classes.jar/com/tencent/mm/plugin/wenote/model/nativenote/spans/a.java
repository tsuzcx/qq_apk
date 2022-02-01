package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final q CWO;
  public int oTt;
  public int oTu;
  
  public a(q paramq, int paramInt1, int paramInt2)
  {
    this.CWO = paramq;
    this.oTt = paramInt1;
    this.oTu = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30624);
    String str = this.CWO.name() + " - " + this.oTt + "/" + this.oTu;
    AppMethodBeat.o(30624);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */