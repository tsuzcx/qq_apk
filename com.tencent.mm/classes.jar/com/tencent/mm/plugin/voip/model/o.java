package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.c;

public final class o
{
  long beginTime;
  String hNR;
  public long zhF;
  public long zhG;
  int zkA;
  int zkB;
  int zkC;
  int zkD;
  int zkE;
  int zkF;
  int zkG;
  int zkH;
  public long zkI;
  long zkJ;
  long zkK;
  long zkL;
  long zkM;
  public long zkN;
  long zkO;
  long zkP;
  long zkQ;
  long zkR;
  public int zkS;
  public int zkh;
  public int zki;
  public int zkj;
  public int zkk;
  byte zkl;
  byte zkm;
  byte zkn;
  byte zko;
  byte zkp;
  byte zkq;
  byte zkr;
  int zks;
  public int zkt;
  public int zku;
  public int zkv;
  public int zkw;
  public int zkx;
  public int zky;
  public int zkz;
  
  public o()
  {
    AppMethodBeat.i(114954);
    this.beginTime = 0L;
    this.zhF = 0L;
    this.zhG = 0L;
    this.zkS = 0;
    dTC();
    AppMethodBeat.o(114954);
  }
  
  public final void dTA()
  {
    AppMethodBeat.i(114958);
    this.zkO = System.currentTimeMillis();
    c.Logd("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + this.zkO);
    AppMethodBeat.o(114958);
  }
  
  public final void dTB()
  {
    AppMethodBeat.i(114959);
    if (this.zkN == 0L) {}
    for (this.zkD = 0;; this.zkD = ((int)(System.currentTimeMillis() - this.zkN)))
    {
      c.Logi("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
      c.Logi("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.zkD);
      AppMethodBeat.o(114959);
      return;
    }
  }
  
  public final void dTC()
  {
    this.zkI = 0L;
    this.zkM = 0L;
    this.zkN = 0L;
    this.zkO = 0L;
    this.zkP = 0L;
    this.zkQ = 0L;
    this.zkJ = 0L;
    this.zkK = 0L;
    this.zkL = 0L;
    this.zkt = 0;
    this.zku = 0;
    this.zkv = 0;
    this.zkw = 0;
    this.zkx = 0;
    this.zky = 0;
    this.zkz = 0;
    this.zkA = 0;
    this.zkB = 0;
    this.zkC = 0;
    this.zkD = 0;
    this.zkE = 0;
    this.zkF = 0;
    this.zkG = 0;
    this.zkH = 0;
  }
  
  public final String dTD()
  {
    AppMethodBeat.i(114960);
    String str = "," + this.zkr;
    AppMethodBeat.o(114960);
    return str;
  }
  
  public final void dTx()
  {
    AppMethodBeat.i(114955);
    if (this.beginTime == 0L) {}
    for (this.zkk = 0;; this.zkk = ((int)(System.currentTimeMillis() - this.beginTime)))
    {
      c.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + this.beginTime + ", CurrentTime: " + System.currentTimeMillis());
      c.Logi("MicroMsg.VoipDailReport", "devin:endDial:" + this.zkk);
      AppMethodBeat.o(114955);
      return;
    }
  }
  
  public final void dTy()
  {
    AppMethodBeat.i(114956);
    if (0L == this.zkJ)
    {
      this.zkJ = System.currentTimeMillis();
      c.Logi("MicroMsg.VoipDailReport", "accept received timestamp:" + this.zkJ);
    }
    AppMethodBeat.o(114956);
  }
  
  public final void dTz()
  {
    AppMethodBeat.i(114957);
    if (0L == this.zkK)
    {
      this.zkK = System.currentTimeMillis();
      c.Logi("MicroMsg.VoipDailReport", "sync accept received timestamp:" + this.zkK);
    }
    AppMethodBeat.o(114957);
  }
  
  public final void reset()
  {
    this.beginTime = 0L;
    this.zkh = 0;
    this.zki = 0;
    this.zkj = 0;
    this.zkk = 0;
    this.zkl = 0;
    this.zkm = 0;
    this.zkn = 0;
    this.zko = 0;
    this.zkp = 0;
    this.zkq = 0;
    this.zkr = 0;
    this.zks = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o
 * JD-Core Version:    0.7.0.1
 */