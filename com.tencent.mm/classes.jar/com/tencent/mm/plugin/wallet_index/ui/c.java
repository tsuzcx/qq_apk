package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet_index.c.g;
import com.tencent.mm.plugin.wallet_index.c.n;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.v;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  int GJz;
  public String PjV;
  public ArrayList<String> PjY;
  public ArrayList<String> PjZ;
  public String Pjo;
  public String Pjp;
  public cky Pjy;
  public ckz Pjz;
  public String Pka;
  public int Pkb;
  List<String> Pkc;
  boolean Pkd;
  public String Pke;
  public String Pkf;
  public int mCount;
  public String ovF;
  public String uFI;
  
  public c()
  {
    AppMethodBeat.i(71861);
    this.PjY = new ArrayList();
    this.PjZ = new ArrayList();
    this.mCount = 1;
    this.Pka = null;
    this.Pkb = 0;
    this.Pjp = null;
    this.Pjo = null;
    this.PjV = null;
    this.Pkc = new ArrayList();
    this.uFI = null;
    this.Pkd = false;
    AppMethodBeat.o(71861);
  }
  
  public final q a(com.tencent.mm.plugin.wallet_index.b.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(71862);
    if (paramBoolean) {}
    for (int i = 2; this.Pkd; i = 1)
    {
      if (!gMY())
      {
        this.Pjy.TsA = paramc.mSignature;
        this.Pjy.Tsx = paramc.Pjn;
        this.Pjy.price = paramc.Pjp;
        this.Pjy.TaW = paramc.Pjo;
        this.Pjy.GTv = paramc.uFI;
        this.Pjy.Tsz = paramc.mOriginalJson;
      }
      paramc = new n(this.GJz, i, paramc.uFI, this.Pjz, this.Pjy);
      AppMethodBeat.o(71862);
      return paramc;
    }
    paramc = new v(paramc.uFI, i, this.GJz, this.mCount, paramc.Pjn, paramc.mOriginalJson, paramc.mSignature, paramc.Pjo, paramc.Pjp);
    AppMethodBeat.o(71862);
    return paramc;
  }
  
  public final boolean gMY()
  {
    return this.GJz == 2;
  }
  
  public final q h(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(273513);
    if (this.Pkd) {
      try
      {
        paramString1 = new g(paramInt, paramString2, this.Pjp, paramString3, this.mCount, this.Pjo, paramString4, this.Pke, this.Pkf, this.ovF);
        AppMethodBeat.o(273513);
        return paramString1;
      }
      catch (NumberFormatException paramString1)
      {
        Log.printErrStackTrace("MicroMsg.IapData", paramString1, "NetSceneGetAndroidIapPackage Error priceLevel:" + this.Pjp, new Object[0]);
        AppMethodBeat.o(273513);
        return null;
      }
    }
    paramString1 = new u(this.uFI, this.Pjp, this.Pjo, this.mCount, paramInt, paramString1);
    AppMethodBeat.o(273513);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.c
 * JD-Core Version:    0.7.0.1
 */