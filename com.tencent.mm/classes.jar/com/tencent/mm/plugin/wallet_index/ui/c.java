package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_index.c.f;
import com.tencent.mm.plugin.wallet_index.c.m;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.v;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  public String DpO;
  public String DpP;
  public bpk DpV;
  public bpl DpW;
  public String Dqp;
  public ArrayList<String> Dqs;
  public ArrayList<String> Dqt;
  public String Dqu;
  public int Dqv;
  List<String> Dqw;
  boolean Dqx;
  public String Dqy;
  public String Dqz;
  public int mCount;
  String pFG;
  int wEH;
  
  public c()
  {
    AppMethodBeat.i(71861);
    this.Dqs = new ArrayList();
    this.Dqt = new ArrayList();
    this.mCount = 1;
    this.Dqu = null;
    this.Dqv = 0;
    this.DpP = null;
    this.DpO = null;
    this.Dqp = null;
    this.Dqw = new ArrayList();
    this.pFG = null;
    this.Dqx = false;
    AppMethodBeat.o(71861);
  }
  
  public final n a(com.tencent.mm.plugin.wallet_index.b.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(71862);
    if (paramBoolean) {}
    for (int i = 2; this.Dqx; i = 1)
    {
      if (!eJb())
      {
        this.DpV.GKg = paramc.cff;
        this.DpV.GKd = paramc.DpM;
        this.DpV.wDS = paramc.DpP;
        this.DpV.GuI = paramc.DpO;
        this.DpV.wMh = paramc.pFG;
        this.DpV.GKf = paramc.DpN;
      }
      paramc = new m(this.wEH, i, paramc.pFG, this.DpW, this.DpV);
      AppMethodBeat.o(71862);
      return paramc;
    }
    paramc = new v(paramc.pFG, i, this.wEH, this.mCount, paramc.DpM, paramc.DpN, paramc.cff, paramc.DpO, paramc.DpP);
    AppMethodBeat.o(71862);
    return paramc;
  }
  
  public final boolean eJb()
  {
    return this.wEH == 2;
  }
  
  public final n f(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(199360);
    if (this.Dqx) {
      try
      {
        paramString1 = new f(paramInt, paramString2, this.DpP, paramString3, this.mCount, this.DpO, paramString4, this.Dqy, this.Dqz);
        AppMethodBeat.o(199360);
        return paramString1;
      }
      catch (NumberFormatException paramString1)
      {
        ad.printErrStackTrace("MicroMsg.IapData", paramString1, "NetSceneGetAndroidIapPackage Error priceLevel:" + this.DpP, new Object[0]);
        AppMethodBeat.o(199360);
        return null;
      }
    }
    paramString1 = new u(this.pFG, this.DpP, this.DpO, this.mCount, paramInt, paramString1);
    AppMethodBeat.o(199360);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.c
 * JD-Core Version:    0.7.0.1
 */