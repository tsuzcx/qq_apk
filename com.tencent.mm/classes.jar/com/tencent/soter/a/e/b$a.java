package com.tencent.soter.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
{
  public int Bnc = 0;
  private String Bnd = "";
  public boolean Bne = false;
  private boolean Bnf = false;
  public a Bng = null;
  
  public final a cv(String paramString, boolean paramBoolean)
  {
    this.Bnd = paramString;
    this.Bnf = paramBoolean;
    this.Bnc |= 0x2;
    return this;
  }
  
  public final b dVz()
  {
    AppMethodBeat.i(10474);
    b localb = new b(this.Bnc, this.Bnd, this.Bne, this.Bnf, this.Bng, (byte)0);
    AppMethodBeat.o(10474);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.a.e.b.a
 * JD-Core Version:    0.7.0.1
 */