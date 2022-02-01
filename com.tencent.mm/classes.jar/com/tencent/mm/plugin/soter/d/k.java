package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  public byte LwB = 1;
  public String LwC = "";
  public int errCode = 0;
  public String errMsg = "OK";
  public String fTF = "";
  
  public final String toString()
  {
    AppMethodBeat.i(145971);
    String str = "SoterMpRespModel{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", resultMode=" + this.LwB + ", resultJson='" + this.fTF + '\'' + ", resultJsonSignature='" + this.LwC + '\'' + '}';
    AppMethodBeat.o(145971);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.k
 * JD-Core Version:    0.7.0.1
 */