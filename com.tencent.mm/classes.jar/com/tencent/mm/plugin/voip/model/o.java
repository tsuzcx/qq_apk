package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.c.e;

public final class o
{
  public long NKQ;
  public long NKR;
  byte NNA;
  int NNB;
  public int NNC;
  public int NND;
  public int NNE;
  public int NNF;
  public int NNG;
  public int NNH;
  public int NNI;
  int NNJ;
  int NNK;
  int NNL;
  int NNM;
  int NNN;
  int NNO;
  int NNP;
  int NNQ;
  public long NNR;
  long NNS;
  long NNT;
  long NNU;
  long NNV;
  public long NNW;
  long NNX;
  long NNY;
  long NNZ;
  public int NNq;
  public int NNr;
  public int NNs;
  public int NNt;
  byte NNu;
  byte NNv;
  byte NNw;
  byte NNx;
  byte NNy;
  byte NNz;
  long NOa;
  public int NOb;
  long beginTime;
  String myn;
  
  public o()
  {
    AppMethodBeat.i(114954);
    this.beginTime = 0L;
    this.NKQ = 0L;
    this.NKR = 0L;
    this.NOb = 0;
    gzk();
    AppMethodBeat.o(114954);
  }
  
  public final void gzf()
  {
    AppMethodBeat.i(114955);
    if (this.beginTime == 0L) {}
    for (this.NNt = 0;; this.NNt = ((int)(System.currentTimeMillis() - this.beginTime)))
    {
      e.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + this.beginTime + ", CurrentTime: " + System.currentTimeMillis());
      e.Logi("MicroMsg.VoipDailReport", "devin:endDial:" + this.NNt);
      AppMethodBeat.o(114955);
      return;
    }
  }
  
  public final void gzg()
  {
    AppMethodBeat.i(114956);
    if (0L == this.NNS)
    {
      this.NNS = System.currentTimeMillis();
      e.Logi("MicroMsg.VoipDailReport", "accept received timestamp:" + this.NNS);
    }
    AppMethodBeat.o(114956);
  }
  
  public final void gzh()
  {
    AppMethodBeat.i(114957);
    if (0L == this.NNT)
    {
      this.NNT = System.currentTimeMillis();
      e.Logi("MicroMsg.VoipDailReport", "sync accept received timestamp:" + this.NNT);
    }
    AppMethodBeat.o(114957);
  }
  
  public final void gzi()
  {
    AppMethodBeat.i(114958);
    this.NNX = System.currentTimeMillis();
    e.Logd("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + this.NNX);
    AppMethodBeat.o(114958);
  }
  
  public final void gzj()
  {
    AppMethodBeat.i(114959);
    if (this.NNW == 0L) {}
    for (this.NNM = 0;; this.NNM = ((int)(System.currentTimeMillis() - this.NNW)))
    {
      e.Logi("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
      e.Logi("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.NNM);
      AppMethodBeat.o(114959);
      return;
    }
  }
  
  public final void gzk()
  {
    this.NNR = 0L;
    this.NNV = 0L;
    this.NNW = 0L;
    this.NNX = 0L;
    this.NNY = 0L;
    this.NNZ = 0L;
    this.NNS = 0L;
    this.NNT = 0L;
    this.NNU = 0L;
    this.NNC = 0;
    this.NND = 0;
    this.NNE = 0;
    this.NNF = 0;
    this.NNG = 0;
    this.NNH = 0;
    this.NNI = 0;
    this.NNJ = 0;
    this.NNK = 0;
    this.NNL = 0;
    this.NNM = 0;
    this.NNN = 0;
    this.NNO = 0;
    this.NNP = 0;
    this.NNQ = 0;
  }
  
  public final String gzl()
  {
    AppMethodBeat.i(114960);
    String str = "," + this.NNA;
    AppMethodBeat.o(114960);
    return str;
  }
  
  public final void reset()
  {
    this.beginTime = 0L;
    this.NNq = 0;
    this.NNr = 0;
    this.NNs = 0;
    this.NNt = 0;
    this.NNu = 0;
    this.NNv = 0;
    this.NNw = 0;
    this.NNx = 0;
    this.NNy = 0;
    this.NNz = 0;
    this.NNA = 0;
    this.NNB = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o
 * JD-Core Version:    0.7.0.1
 */