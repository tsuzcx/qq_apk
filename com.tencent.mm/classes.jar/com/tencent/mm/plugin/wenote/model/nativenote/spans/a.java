package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final q vAS;
  public int vAT;
  public int vAU;
  
  public a(q paramq, int paramInt1, int paramInt2)
  {
    this.vAS = paramq;
    this.vAT = paramInt1;
    this.vAU = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26930);
    String str = this.vAS.name() + " - " + this.vAT + "/" + this.vAU;
    AppMethodBeat.o(26930);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */