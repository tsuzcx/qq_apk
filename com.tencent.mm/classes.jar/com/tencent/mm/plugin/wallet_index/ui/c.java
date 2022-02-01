package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_index.c.f;
import com.tencent.mm.plugin.wallet_index.c.m;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.v;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  public bqc DHB;
  public bqd DHC;
  public String DHV;
  public ArrayList<String> DHY;
  public ArrayList<String> DHZ;
  public String DHu;
  public String DHv;
  public String DIa;
  public int DIb;
  List<String> DIc;
  boolean DId;
  public String DIe;
  public String DIf;
  public int mCount;
  String pMk;
  int wUs;
  
  public c()
  {
    AppMethodBeat.i(71861);
    this.DHY = new ArrayList();
    this.DHZ = new ArrayList();
    this.mCount = 1;
    this.DIa = null;
    this.DIb = 0;
    this.DHv = null;
    this.DHu = null;
    this.DHV = null;
    this.DIc = new ArrayList();
    this.pMk = null;
    this.DId = false;
    AppMethodBeat.o(71861);
  }
  
  public final n a(com.tencent.mm.plugin.wallet_index.b.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(71862);
    if (paramBoolean) {}
    for (int i = 2; this.DId; i = 1)
    {
      if (!eMJ())
      {
        this.DHB.HdH = paramc.cff;
        this.DHB.HdE = paramc.DHs;
        this.DHB.wTD = paramc.DHv;
        this.DHB.GOh = paramc.DHu;
        this.DHB.xbV = paramc.pMk;
        this.DHB.HdG = paramc.DHt;
      }
      paramc = new m(this.wUs, i, paramc.pMk, this.DHC, this.DHB);
      AppMethodBeat.o(71862);
      return paramc;
    }
    paramc = new v(paramc.pMk, i, this.wUs, this.mCount, paramc.DHs, paramc.DHt, paramc.cff, paramc.DHu, paramc.DHv);
    AppMethodBeat.o(71862);
    return paramc;
  }
  
  public final boolean eMJ()
  {
    return this.wUs == 2;
  }
  
  public final n f(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(190244);
    if (this.DId) {
      try
      {
        paramString1 = new f(paramInt, paramString2, this.DHv, paramString3, this.mCount, this.DHu, paramString4, this.DIe, this.DIf);
        AppMethodBeat.o(190244);
        return paramString1;
      }
      catch (NumberFormatException paramString1)
      {
        ae.printErrStackTrace("MicroMsg.IapData", paramString1, "NetSceneGetAndroidIapPackage Error priceLevel:" + this.DHv, new Object[0]);
        AppMethodBeat.o(190244);
        return null;
      }
    }
    paramString1 = new u(this.pMk, this.DHv, this.DHu, this.mCount, paramInt, paramString1);
    AppMethodBeat.o(190244);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.c
 * JD-Core Version:    0.7.0.1
 */