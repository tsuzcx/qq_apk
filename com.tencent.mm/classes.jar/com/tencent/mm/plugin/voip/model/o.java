package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.d;

public final class o
{
  public long AAo;
  public long AAp;
  public int ACR;
  public int ACS;
  public int ACT;
  public int ACU;
  byte ACV;
  byte ACW;
  byte ACX;
  byte ACY;
  byte ACZ;
  long ADA;
  long ADB;
  public int ADC;
  byte ADa;
  byte ADb;
  int ADc;
  public int ADd;
  public int ADe;
  public int ADf;
  public int ADg;
  public int ADh;
  public int ADi;
  public int ADj;
  int ADk;
  int ADl;
  int ADm;
  int ADn;
  int ADo;
  int ADp;
  int ADq;
  int ADr;
  public long ADs;
  long ADt;
  long ADu;
  long ADv;
  long ADw;
  public long ADx;
  long ADy;
  long ADz;
  long beginTime;
  String ion;
  
  public o()
  {
    AppMethodBeat.i(114954);
    this.beginTime = 0L;
    this.AAo = 0L;
    this.AAp = 0L;
    this.ADC = 0;
    eiO();
    AppMethodBeat.o(114954);
  }
  
  public final void eiJ()
  {
    AppMethodBeat.i(114955);
    if (this.beginTime == 0L) {}
    for (this.ACU = 0;; this.ACU = ((int)(System.currentTimeMillis() - this.beginTime)))
    {
      d.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + this.beginTime + ", CurrentTime: " + System.currentTimeMillis());
      d.Logi("MicroMsg.VoipDailReport", "devin:endDial:" + this.ACU);
      AppMethodBeat.o(114955);
      return;
    }
  }
  
  public final void eiK()
  {
    AppMethodBeat.i(114956);
    if (0L == this.ADt)
    {
      this.ADt = System.currentTimeMillis();
      d.Logi("MicroMsg.VoipDailReport", "accept received timestamp:" + this.ADt);
    }
    AppMethodBeat.o(114956);
  }
  
  public final void eiL()
  {
    AppMethodBeat.i(114957);
    if (0L == this.ADu)
    {
      this.ADu = System.currentTimeMillis();
      d.Logi("MicroMsg.VoipDailReport", "sync accept received timestamp:" + this.ADu);
    }
    AppMethodBeat.o(114957);
  }
  
  public final void eiM()
  {
    AppMethodBeat.i(114958);
    this.ADy = System.currentTimeMillis();
    d.Logd("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + this.ADy);
    AppMethodBeat.o(114958);
  }
  
  public final void eiN()
  {
    AppMethodBeat.i(114959);
    if (this.ADx == 0L) {}
    for (this.ADn = 0;; this.ADn = ((int)(System.currentTimeMillis() - this.ADx)))
    {
      d.Logi("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
      d.Logi("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.ADn);
      AppMethodBeat.o(114959);
      return;
    }
  }
  
  public final void eiO()
  {
    this.ADs = 0L;
    this.ADw = 0L;
    this.ADx = 0L;
    this.ADy = 0L;
    this.ADz = 0L;
    this.ADA = 0L;
    this.ADt = 0L;
    this.ADu = 0L;
    this.ADv = 0L;
    this.ADd = 0;
    this.ADe = 0;
    this.ADf = 0;
    this.ADg = 0;
    this.ADh = 0;
    this.ADi = 0;
    this.ADj = 0;
    this.ADk = 0;
    this.ADl = 0;
    this.ADm = 0;
    this.ADn = 0;
    this.ADo = 0;
    this.ADp = 0;
    this.ADq = 0;
    this.ADr = 0;
  }
  
  public final String eiP()
  {
    AppMethodBeat.i(114960);
    String str = "," + this.ADb;
    AppMethodBeat.o(114960);
    return str;
  }
  
  public final void reset()
  {
    this.beginTime = 0L;
    this.ACR = 0;
    this.ACS = 0;
    this.ACT = 0;
    this.ACU = 0;
    this.ACV = 0;
    this.ACW = 0;
    this.ACX = 0;
    this.ACY = 0;
    this.ACZ = 0;
    this.ADa = 0;
    this.ADb = 0;
    this.ADc = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o
 * JD-Core Version:    0.7.0.1
 */