package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.f;

public final class o
{
  public long CqP;
  public long CqQ;
  byte CtA;
  byte CtB;
  byte CtC;
  byte CtD;
  int CtE;
  public int CtF;
  public int CtG;
  public int CtH;
  public int CtI;
  public int CtJ;
  public int CtK;
  public int CtL;
  int CtM;
  int CtN;
  int CtO;
  int CtP;
  int CtQ;
  int CtR;
  int CtS;
  int CtT;
  public long CtU;
  long CtV;
  long CtW;
  long CtX;
  long CtY;
  public long CtZ;
  public int Ctt;
  public int Ctu;
  public int Ctv;
  public int Ctw;
  byte Ctx;
  byte Cty;
  byte Ctz;
  long Cua;
  long Cub;
  long Cuc;
  long Cud;
  public int Cue;
  long beginTime;
  String iKD;
  
  public o()
  {
    AppMethodBeat.i(114954);
    this.beginTime = 0L;
    this.CqP = 0L;
    this.CqQ = 0L;
    this.Cue = 0;
    eAg();
    AppMethodBeat.o(114954);
  }
  
  public final void eAb()
  {
    AppMethodBeat.i(114955);
    if (this.beginTime == 0L) {}
    for (this.Ctw = 0;; this.Ctw = ((int)(System.currentTimeMillis() - this.beginTime)))
    {
      f.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + this.beginTime + ", CurrentTime: " + System.currentTimeMillis());
      f.Logi("MicroMsg.VoipDailReport", "devin:endDial:" + this.Ctw);
      AppMethodBeat.o(114955);
      return;
    }
  }
  
  public final void eAc()
  {
    AppMethodBeat.i(114956);
    if (0L == this.CtV)
    {
      this.CtV = System.currentTimeMillis();
      f.Logi("MicroMsg.VoipDailReport", "accept received timestamp:" + this.CtV);
    }
    AppMethodBeat.o(114956);
  }
  
  public final void eAd()
  {
    AppMethodBeat.i(114957);
    if (0L == this.CtW)
    {
      this.CtW = System.currentTimeMillis();
      f.Logi("MicroMsg.VoipDailReport", "sync accept received timestamp:" + this.CtW);
    }
    AppMethodBeat.o(114957);
  }
  
  public final void eAe()
  {
    AppMethodBeat.i(114958);
    this.Cua = System.currentTimeMillis();
    f.Logd("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + this.Cua);
    AppMethodBeat.o(114958);
  }
  
  public final void eAf()
  {
    AppMethodBeat.i(114959);
    if (this.CtZ == 0L) {}
    for (this.CtP = 0;; this.CtP = ((int)(System.currentTimeMillis() - this.CtZ)))
    {
      f.Logi("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
      f.Logi("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.CtP);
      AppMethodBeat.o(114959);
      return;
    }
  }
  
  public final void eAg()
  {
    this.CtU = 0L;
    this.CtY = 0L;
    this.CtZ = 0L;
    this.Cua = 0L;
    this.Cub = 0L;
    this.Cuc = 0L;
    this.CtV = 0L;
    this.CtW = 0L;
    this.CtX = 0L;
    this.CtF = 0;
    this.CtG = 0;
    this.CtH = 0;
    this.CtI = 0;
    this.CtJ = 0;
    this.CtK = 0;
    this.CtL = 0;
    this.CtM = 0;
    this.CtN = 0;
    this.CtO = 0;
    this.CtP = 0;
    this.CtQ = 0;
    this.CtR = 0;
    this.CtS = 0;
    this.CtT = 0;
  }
  
  public final String eAh()
  {
    AppMethodBeat.i(114960);
    String str = "," + this.CtD;
    AppMethodBeat.o(114960);
    return str;
  }
  
  public final void reset()
  {
    this.beginTime = 0L;
    this.Ctt = 0;
    this.Ctu = 0;
    this.Ctv = 0;
    this.Ctw = 0;
    this.Ctx = 0;
    this.Cty = 0;
    this.Ctz = 0;
    this.CtA = 0;
    this.CtB = 0;
    this.CtC = 0;
    this.CtD = 0;
    this.CtE = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o
 * JD-Core Version:    0.7.0.1
 */