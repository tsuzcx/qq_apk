package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.a.a;

public final class m
{
  long beginTime = 0L;
  String eQa;
  public int pQU;
  public int pQV;
  public int pQW;
  public int pQX;
  byte pQY;
  byte pQZ;
  public long pRA;
  long pRB;
  long pRC;
  long pRD;
  long pRE;
  public long pRF = 0L;
  public long pRG = 0L;
  public int pRH = 0;
  byte pRa;
  byte pRb;
  byte pRc;
  byte pRd;
  byte pRe;
  int pRf;
  public int pRg;
  public int pRh;
  public int pRi;
  public int pRj;
  public int pRk;
  public int pRl;
  public int pRm;
  int pRn;
  int pRo;
  int pRp;
  int pRq;
  int pRr;
  int pRs;
  int pRt;
  int pRu;
  public long pRv;
  long pRw;
  long pRx;
  long pRy;
  long pRz;
  
  public m()
  {
    reset();
    bQn();
  }
  
  public final void bQm()
  {
    if (this.pRA == 0L) {}
    for (this.pRq = 0;; this.pRq = ((int)(System.currentTimeMillis() - this.pRA)))
    {
      a.Logi("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
      a.Logi("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.pRq);
      return;
    }
  }
  
  public final void bQn()
  {
    this.pRv = 0L;
    this.pRz = 0L;
    this.pRA = 0L;
    this.pRB = 0L;
    this.pRC = 0L;
    this.pRD = 0L;
    this.pRw = 0L;
    this.pRx = 0L;
    this.pRy = 0L;
    this.pRg = 0;
    this.pRh = 0;
    this.pRi = 0;
    this.pRj = 0;
    this.pRk = 0;
    this.pRl = 0;
    this.pRm = 0;
    this.pRn = 0;
    this.pRo = 0;
    this.pRp = 0;
    this.pRq = 0;
    this.pRr = 0;
    this.pRs = 0;
    this.pRt = 0;
    this.pRu = 0;
  }
  
  public final String bQo()
  {
    return "," + this.pRe;
  }
  
  public final void reset()
  {
    this.beginTime = 0L;
    this.pQU = 0;
    this.pQV = 0;
    this.pQW = 0;
    this.pQX = 0;
    this.pQY = 0;
    this.pQZ = 0;
    this.pRa = 0;
    this.pRb = 0;
    this.pRc = 0;
    this.pRd = 0;
    this.pRe = 0;
    this.pRf = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m
 * JD-Core Version:    0.7.0.1
 */