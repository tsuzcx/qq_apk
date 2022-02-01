package com.tencent.mm.plugin.soter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public byte Saa = 1;
  public String Sab = "";
  public int errCode = 0;
  public String errMsg = "OK";
  public String hZD = "";
  
  public final String toString()
  {
    AppMethodBeat.i(145971);
    String str = "SoterMpRespModel{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", resultMode=" + this.Saa + ", resultJson='" + this.hZD + '\'' + ", resultJsonSignature='" + this.Sab + '\'' + '}';
    AppMethodBeat.o(145971);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.model.h
 * JD-Core Version:    0.7.0.1
 */