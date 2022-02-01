package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  public byte AFB = 1;
  public String AFC = "";
  public String dGT = "";
  public int errCode = 0;
  public String errMsg = "OK";
  
  public final String toString()
  {
    AppMethodBeat.i(145971);
    String str = "SoterMpRespModel{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", resultMode=" + this.AFB + ", resultJson='" + this.dGT + '\'' + ", resultJsonSignature='" + this.AFC + '\'' + '}';
    AppMethodBeat.o(145971);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.k
 * JD-Core Version:    0.7.0.1
 */