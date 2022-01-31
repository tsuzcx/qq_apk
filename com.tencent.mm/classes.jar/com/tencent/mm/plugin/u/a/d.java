package com.tencent.mm.plugin.u.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int cpE;
  public int cpF;
  public String pPC;
  public byte[] rawData;
  public String result;
  
  public d()
  {
    AppMethodBeat.i(80770);
    this.result = "";
    this.rawData = new byte[0];
    this.pPC = "";
    this.cpE = 0;
    this.cpF = 0;
    AppMethodBeat.o(80770);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(80771);
    String str = String.format("result: %s, codeType: %s, codeTypeName %s, codeVersion: %s", new Object[] { this.result, Integer.valueOf(this.cpE), this.pPC, Integer.valueOf(this.cpF) });
    AppMethodBeat.o(80771);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.d
 * JD-Core Version:    0.7.0.1
 */