package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_index.c.j;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  String iZD = null;
  public int mCount = 1;
  int mRe;
  public String qLC = null;
  public ArrayList<String> qLF = new ArrayList();
  public ArrayList<String> qLG = new ArrayList();
  public String qLH = null;
  public int qLI = 0;
  List<String> qLJ = new ArrayList();
  boolean qLK = false;
  public String qLL;
  public String qLM;
  public String qLe = null;
  public String qLf = null;
  public aqe qLk;
  public aqf qLl;
  
  public final m a(com.tencent.mm.plugin.wallet_index.b.a.c paramc, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2; this.qLK; i = 1)
    {
      if (!bXA())
      {
        this.qLk.tmh = paramc.mSignature;
        this.qLk.tme = paramc.qLc;
        this.qLk.mQn = paramc.qLf;
        this.qLk.taz = paramc.qLe;
        this.qLk.mSq = paramc.iZD;
        this.qLk.tmg = paramc.qLd;
      }
      return new j(this.mRe, i, paramc.iZD, this.qLl, this.qLk);
    }
    return new r(paramc.iZD, i, this.mRe, this.mCount, paramc.qLc, paramc.qLd, paramc.mSignature, paramc.qLe, paramc.qLf);
  }
  
  public final boolean bXA()
  {
    return this.mRe == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.c
 * JD-Core Version:    0.7.0.1
 */