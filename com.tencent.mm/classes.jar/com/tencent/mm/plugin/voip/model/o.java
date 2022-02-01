package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.f;

public final class o
{
  public long BZo;
  public long BZp;
  public int CbS;
  public int CbT;
  public int CbU;
  public int CbV;
  byte CbW;
  byte CbX;
  byte CbY;
  byte CbZ;
  long CcA;
  long CcB;
  long CcC;
  public int CcD;
  byte Cca;
  byte Ccb;
  byte Ccc;
  int Ccd;
  public int Cce;
  public int Ccf;
  public int Ccg;
  public int Cch;
  public int Cci;
  public int Ccj;
  public int Cck;
  int Ccl;
  int Ccm;
  int Ccn;
  int Cco;
  int Ccp;
  int Ccq;
  int Ccr;
  int Ccs;
  public long Cct;
  long Ccu;
  long Ccv;
  long Ccw;
  long Ccx;
  public long Ccy;
  long Ccz;
  long beginTime;
  String iHK;
  
  public o()
  {
    AppMethodBeat.i(114954);
    this.beginTime = 0L;
    this.BZo = 0L;
    this.BZp = 0L;
    this.CcD = 0;
    ewz();
    AppMethodBeat.o(114954);
  }
  
  public final String ewA()
  {
    AppMethodBeat.i(114960);
    String str = "," + this.Ccc;
    AppMethodBeat.o(114960);
    return str;
  }
  
  public final void ewu()
  {
    AppMethodBeat.i(114955);
    if (this.beginTime == 0L) {}
    for (this.CbV = 0;; this.CbV = ((int)(System.currentTimeMillis() - this.beginTime)))
    {
      f.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + this.beginTime + ", CurrentTime: " + System.currentTimeMillis());
      f.Logi("MicroMsg.VoipDailReport", "devin:endDial:" + this.CbV);
      AppMethodBeat.o(114955);
      return;
    }
  }
  
  public final void ewv()
  {
    AppMethodBeat.i(114956);
    if (0L == this.Ccu)
    {
      this.Ccu = System.currentTimeMillis();
      f.Logi("MicroMsg.VoipDailReport", "accept received timestamp:" + this.Ccu);
    }
    AppMethodBeat.o(114956);
  }
  
  public final void eww()
  {
    AppMethodBeat.i(114957);
    if (0L == this.Ccv)
    {
      this.Ccv = System.currentTimeMillis();
      f.Logi("MicroMsg.VoipDailReport", "sync accept received timestamp:" + this.Ccv);
    }
    AppMethodBeat.o(114957);
  }
  
  public final void ewx()
  {
    AppMethodBeat.i(114958);
    this.Ccz = System.currentTimeMillis();
    f.Logd("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + this.Ccz);
    AppMethodBeat.o(114958);
  }
  
  public final void ewy()
  {
    AppMethodBeat.i(114959);
    if (this.Ccy == 0L) {}
    for (this.Cco = 0;; this.Cco = ((int)(System.currentTimeMillis() - this.Ccy)))
    {
      f.Logi("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
      f.Logi("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.Cco);
      AppMethodBeat.o(114959);
      return;
    }
  }
  
  public final void ewz()
  {
    this.Cct = 0L;
    this.Ccx = 0L;
    this.Ccy = 0L;
    this.Ccz = 0L;
    this.CcA = 0L;
    this.CcB = 0L;
    this.Ccu = 0L;
    this.Ccv = 0L;
    this.Ccw = 0L;
    this.Cce = 0;
    this.Ccf = 0;
    this.Ccg = 0;
    this.Cch = 0;
    this.Cci = 0;
    this.Ccj = 0;
    this.Cck = 0;
    this.Ccl = 0;
    this.Ccm = 0;
    this.Ccn = 0;
    this.Cco = 0;
    this.Ccp = 0;
    this.Ccq = 0;
    this.Ccr = 0;
    this.Ccs = 0;
  }
  
  public final void reset()
  {
    this.beginTime = 0L;
    this.CbS = 0;
    this.CbT = 0;
    this.CbU = 0;
    this.CbV = 0;
    this.CbW = 0;
    this.CbX = 0;
    this.CbY = 0;
    this.CbZ = 0;
    this.Cca = 0;
    this.Ccb = 0;
    this.Ccc = 0;
    this.Ccd = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o
 * JD-Core Version:    0.7.0.1
 */