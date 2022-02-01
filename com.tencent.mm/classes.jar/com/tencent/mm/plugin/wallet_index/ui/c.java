package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_index.c.f;
import com.tencent.mm.plugin.wallet_index.c.m;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.v;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  public bla BPD;
  public blb BPE;
  public String BPX;
  public String BPw;
  public String BPx;
  public ArrayList<String> BQa;
  public ArrayList<String> BQb;
  public String BQc;
  public int BQd;
  List<String> BQe;
  boolean BQf;
  public String BQg;
  public String BQh;
  public int mCount;
  String pbW;
  int vzn;
  
  public c()
  {
    AppMethodBeat.i(71861);
    this.BQa = new ArrayList();
    this.BQb = new ArrayList();
    this.mCount = 1;
    this.BQc = null;
    this.BQd = 0;
    this.BPx = null;
    this.BPw = null;
    this.BPX = null;
    this.BQe = new ArrayList();
    this.pbW = null;
    this.BQf = false;
    AppMethodBeat.o(71861);
  }
  
  public final n a(com.tencent.mm.plugin.wallet_index.b.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(71862);
    if (paramBoolean) {}
    for (int i = 2; this.BQf; i = 1)
    {
      if (!euV())
      {
        this.BPD.FaH = paramc.bUS;
        this.BPD.FaE = paramc.BPu;
        this.BPD.vyy = paramc.BPx;
        this.BPD.ELE = paramc.BPw;
        this.BPD.vFb = paramc.pbW;
        this.BPD.FaG = paramc.BPv;
      }
      paramc = new m(this.vzn, i, paramc.pbW, this.BPE, this.BPD);
      AppMethodBeat.o(71862);
      return paramc;
    }
    paramc = new v(paramc.pbW, i, this.vzn, this.mCount, paramc.BPu, paramc.BPv, paramc.bUS, paramc.BPw, paramc.BPx);
    AppMethodBeat.o(71862);
    return paramc;
  }
  
  public final boolean euV()
  {
    return this.vzn == 2;
  }
  
  public final n f(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(207318);
    if (this.BQf) {
      try
      {
        paramString1 = new f(paramInt, paramString2, this.BPx, paramString3, this.mCount, this.BPw, paramString4, this.BQg, this.BQh);
        AppMethodBeat.o(207318);
        return paramString1;
      }
      catch (NumberFormatException paramString1)
      {
        ac.printErrStackTrace("MicroMsg.IapData", paramString1, "NetSceneGetAndroidIapPackage Error priceLevel:" + this.BPx, new Object[0]);
        AppMethodBeat.o(207318);
        return null;
      }
    }
    paramString1 = new u(this.pbW, this.BPx, this.BPw, this.mCount, paramInt, paramString1);
    AppMethodBeat.o(207318);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.c
 * JD-Core Version:    0.7.0.1
 */