package com.tencent.mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TmplParams$a
{
  String cSE;
  int uYM;
  int uYN;
  String uYO;
  String uYP;
  String uYQ;
  String uYR;
  long uYS;
  int uYT;
  
  public final a Kb(int paramInt)
  {
    this.uYM = paramInt;
    return this;
  }
  
  public final a Kc(int paramInt)
  {
    this.uYN = paramInt;
    return this;
  }
  
  public final a Kd(int paramInt)
  {
    this.uYT = paramInt;
    return this;
  }
  
  public final a ahE(String paramString)
  {
    this.uYO = paramString;
    return this;
  }
  
  public final a ahF(String paramString)
  {
    this.uYP = paramString;
    return this;
  }
  
  public final a ahG(String paramString)
  {
    this.cSE = paramString;
    return this;
  }
  
  public final a ahH(String paramString)
  {
    this.uYQ = paramString;
    return this;
  }
  
  public final a ahI(String paramString)
  {
    this.uYR = paramString;
    return this;
  }
  
  public final TmplParams dcR()
  {
    AppMethodBeat.i(80446);
    TmplParams localTmplParams = new TmplParams();
    localTmplParams.kbM = this.uYM;
    localTmplParams.version = this.uYN;
    localTmplParams.keN = this.uYO;
    localTmplParams.uYJ = this.uYP;
    localTmplParams.cqq = this.cSE;
    localTmplParams.uYL = this.uYT;
    localTmplParams.rjN = this.uYS;
    localTmplParams.kbP = this.uYQ;
    localTmplParams.uYK = this.uYR;
    AppMethodBeat.o(80446);
    return localTmplParams;
  }
  
  public final a no(long paramLong)
  {
    this.uYS = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.TmplParams.a
 * JD-Core Version:    0.7.0.1
 */