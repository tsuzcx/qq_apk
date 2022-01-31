package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.a;

public final class n
{
  long beginTime;
  String gfV;
  int twA;
  int twB;
  public long twC;
  long twD;
  long twE;
  long twF;
  long twG;
  public long twH;
  long twI;
  long twJ;
  long twK;
  long twL;
  public long twM;
  public long twN;
  public int twO;
  public int twb;
  public int twc;
  public int twd;
  public int twe;
  byte twf;
  byte twg;
  byte twh;
  byte twi;
  byte twj;
  byte twk;
  byte twl;
  int twm;
  public int twn;
  public int two;
  public int twp;
  public int twq;
  public int twr;
  public int tws;
  public int twt;
  int twu;
  int twv;
  int tww;
  int twx;
  int twy;
  int twz;
  
  public n()
  {
    AppMethodBeat.i(4448);
    this.beginTime = 0L;
    this.twM = 0L;
    this.twN = 0L;
    this.twO = 0;
    cMw();
    AppMethodBeat.o(4448);
  }
  
  public final void cMr()
  {
    AppMethodBeat.i(4449);
    if (this.beginTime == 0L) {}
    for (this.twe = 0;; this.twe = ((int)(System.currentTimeMillis() - this.beginTime)))
    {
      a.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + this.beginTime + ", CurrentTime: " + System.currentTimeMillis());
      a.Logi("MicroMsg.VoipDailReport", "devin:endDial:" + this.twe);
      AppMethodBeat.o(4449);
      return;
    }
  }
  
  public final void cMs()
  {
    AppMethodBeat.i(4450);
    if (0L == this.twD)
    {
      this.twD = System.currentTimeMillis();
      a.Logi("MicroMsg.VoipDailReport", "accept received timestamp:" + this.twD);
    }
    AppMethodBeat.o(4450);
  }
  
  public final void cMt()
  {
    AppMethodBeat.i(4451);
    if (0L == this.twE)
    {
      this.twE = System.currentTimeMillis();
      a.Logi("MicroMsg.VoipDailReport", "sync accept received timestamp:" + this.twE);
    }
    AppMethodBeat.o(4451);
  }
  
  public final void cMu()
  {
    AppMethodBeat.i(4452);
    this.twI = System.currentTimeMillis();
    a.Logd("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + this.twI);
    AppMethodBeat.o(4452);
  }
  
  public final void cMv()
  {
    AppMethodBeat.i(4453);
    if (this.twH == 0L) {}
    for (this.twx = 0;; this.twx = ((int)(System.currentTimeMillis() - this.twH)))
    {
      a.Logi("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
      a.Logi("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.twx);
      AppMethodBeat.o(4453);
      return;
    }
  }
  
  public final void cMw()
  {
    this.twC = 0L;
    this.twG = 0L;
    this.twH = 0L;
    this.twI = 0L;
    this.twJ = 0L;
    this.twK = 0L;
    this.twD = 0L;
    this.twE = 0L;
    this.twF = 0L;
    this.twn = 0;
    this.two = 0;
    this.twp = 0;
    this.twq = 0;
    this.twr = 0;
    this.tws = 0;
    this.twt = 0;
    this.twu = 0;
    this.twv = 0;
    this.tww = 0;
    this.twx = 0;
    this.twy = 0;
    this.twz = 0;
    this.twA = 0;
    this.twB = 0;
  }
  
  public final String cMx()
  {
    AppMethodBeat.i(4454);
    String str = "," + this.twl;
    AppMethodBeat.o(4454);
    return str;
  }
  
  public final void reset()
  {
    this.beginTime = 0L;
    this.twb = 0;
    this.twc = 0;
    this.twd = 0;
    this.twe = 0;
    this.twf = 0;
    this.twg = 0;
    this.twh = 0;
    this.twi = 0;
    this.twj = 0;
    this.twk = 0;
    this.twl = 0;
    this.twm = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n
 * JD-Core Version:    0.7.0.1
 */