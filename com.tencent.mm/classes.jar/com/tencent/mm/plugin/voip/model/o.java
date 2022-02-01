package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.f.g;
import java.util.Arrays;

public final class o
{
  public long LiJ;
  public long LiK;
  int UAA;
  int UAB;
  int UAC;
  int UAD;
  int UAE;
  int UAF;
  int UAG;
  int UAH;
  public long UAI;
  long UAJ;
  long UAK;
  long UAL;
  public long UAM;
  public long UAN;
  public long UAO;
  public long UAP;
  public long UAQ;
  public long UAR;
  public long UAS;
  long UAT;
  long UAU;
  long UAV;
  long[] UAW;
  long UAX;
  public int UAY;
  public int UAh;
  public int UAi;
  public int UAj;
  public int UAk;
  byte UAl;
  byte UAm;
  byte UAn;
  byte UAo;
  byte UAp;
  byte UAq;
  byte UAr;
  int UAs;
  public int UAt;
  public int UAu;
  public int UAv;
  public int UAw;
  public int UAx;
  public int UAy;
  public int UAz;
  long beginTime;
  String psF;
  
  public o()
  {
    AppMethodBeat.i(114954);
    this.beginTime = 0L;
    this.UAW = new long[6];
    this.LiJ = 0L;
    this.LiK = 0L;
    this.UAY = 0;
    hXg();
    AppMethodBeat.o(114954);
  }
  
  public final void hXb()
  {
    AppMethodBeat.i(114955);
    if (this.beginTime == 0L) {}
    for (this.UAk = 0;; this.UAk = ((int)(System.currentTimeMillis() - this.beginTime)))
    {
      g.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + this.beginTime + ", CurrentTime: " + System.currentTimeMillis());
      g.Logi("MicroMsg.VoipDailReport", "devin:endDial:" + this.UAk);
      AppMethodBeat.o(114955);
      return;
    }
  }
  
  public final void hXc()
  {
    AppMethodBeat.i(114956);
    if (0L == this.UAJ)
    {
      this.UAJ = System.currentTimeMillis();
      g.Logi("MicroMsg.VoipDailReport", "accept received timestamp:" + this.UAJ);
    }
    AppMethodBeat.o(114956);
  }
  
  public final void hXd()
  {
    AppMethodBeat.i(114957);
    if (0L == this.UAK)
    {
      this.UAK = System.currentTimeMillis();
      g.Logi("MicroMsg.VoipDailReport", "sync accept received timestamp:" + this.UAK);
    }
    AppMethodBeat.o(114957);
  }
  
  public final void hXe()
  {
    AppMethodBeat.i(114958);
    this.UAT = System.currentTimeMillis();
    g.Logd("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + this.UAT);
    AppMethodBeat.o(114958);
  }
  
  public final void hXf()
  {
    AppMethodBeat.i(114959);
    if (this.UAN == 0L) {}
    for (this.UAD = 0;; this.UAD = ((int)(System.currentTimeMillis() - this.UAN)))
    {
      g.Logi("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
      g.Logi("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.UAD);
      AppMethodBeat.o(114959);
      return;
    }
  }
  
  public final void hXg()
  {
    AppMethodBeat.i(293305);
    this.UAI = 0L;
    this.UAM = 0L;
    this.UAN = 0L;
    this.UAT = 0L;
    this.UAU = 0L;
    this.UAV = 0L;
    this.UAJ = 0L;
    this.UAK = 0L;
    this.UAL = 0L;
    this.UAO = 0L;
    this.UAP = 0L;
    this.UAQ = 0L;
    this.UAR = 0L;
    this.UAS = 0L;
    this.UAt = 0;
    this.UAu = 0;
    this.UAv = 0;
    this.UAw = 0;
    this.UAx = 0;
    this.UAy = 0;
    this.UAz = 0;
    this.UAA = 0;
    this.UAB = 0;
    this.UAC = 0;
    this.UAD = 0;
    this.UAE = 0;
    this.UAF = 0;
    this.UAG = 0;
    this.UAH = 0;
    Arrays.fill(this.UAW, 0L);
    AppMethodBeat.o(293305);
  }
  
  public final String hXh()
  {
    AppMethodBeat.i(114960);
    String str = "," + this.UAr;
    AppMethodBeat.o(114960);
    return str;
  }
  
  public final void reset()
  {
    this.beginTime = 0L;
    this.UAh = 0;
    this.UAi = 0;
    this.UAj = 0;
    this.UAk = 0;
    this.UAl = 0;
    this.UAm = 0;
    this.UAn = 0;
    this.UAo = 0;
    this.UAp = 0;
    this.UAq = 0;
    this.UAr = 0;
    this.UAs = 0;
  }
  
  public final void wS(long paramLong)
  {
    if ((0L <= paramLong) && (paramLong <= 500L))
    {
      arrayOfLong = this.UAW;
      arrayOfLong[0] += 1L;
    }
    do
    {
      return;
      if ((500L < paramLong) && (paramLong <= 1000L))
      {
        arrayOfLong = this.UAW;
        arrayOfLong[1] += 1L;
        return;
      }
      if ((1000L < paramLong) && (paramLong <= 2000L))
      {
        arrayOfLong = this.UAW;
        arrayOfLong[2] += 1L;
        return;
      }
      if ((2000L < paramLong) && (paramLong <= 4000L))
      {
        arrayOfLong = this.UAW;
        arrayOfLong[3] += 1L;
        return;
      }
      if ((4000L < paramLong) && (paramLong <= 8000L))
      {
        arrayOfLong = this.UAW;
        arrayOfLong[4] += 1L;
        return;
      }
    } while (paramLong <= 8000L);
    long[] arrayOfLong = this.UAW;
    arrayOfLong[5] += 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o
 * JD-Core Version:    0.7.0.1
 */