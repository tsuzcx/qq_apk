package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_index.c.g;
import com.tencent.mm.plugin.wallet_index.c.n;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.v;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  int AQo;
  public String IqF;
  public String IqG;
  public ccu IqP;
  public ccv IqQ;
  public String Irm;
  public ArrayList<String> Irp;
  public ArrayList<String> Irq;
  public String Irr;
  public int Irs;
  List<String> Irt;
  boolean Iru;
  public String Irv;
  public String Irw;
  public int mCount;
  public String rcD;
  
  public c()
  {
    AppMethodBeat.i(71861);
    this.Irp = new ArrayList();
    this.Irq = new ArrayList();
    this.mCount = 1;
    this.Irr = null;
    this.Irs = 0;
    this.IqG = null;
    this.IqF = null;
    this.Irm = null;
    this.Irt = new ArrayList();
    this.rcD = null;
    this.Iru = false;
    AppMethodBeat.o(71861);
  }
  
  public final q a(com.tencent.mm.plugin.wallet_index.b.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(71862);
    if (paramBoolean) {}
    for (int i = 2; this.Iru; i = 1)
    {
      if (!fUs())
      {
        this.IqP.MiK = paramc.mSignature;
        this.IqP.MiH = paramc.IqE;
        this.IqP.price = paramc.IqG;
        this.IqP.LSm = paramc.IqF;
        this.IqP.AZx = paramc.rcD;
        this.IqP.MiJ = paramc.mOriginalJson;
      }
      paramc = new n(this.AQo, i, paramc.rcD, this.IqQ, this.IqP);
      AppMethodBeat.o(71862);
      return paramc;
    }
    paramc = new v(paramc.rcD, i, this.AQo, this.mCount, paramc.IqE, paramc.mOriginalJson, paramc.mSignature, paramc.IqF, paramc.IqG);
    AppMethodBeat.o(71862);
    return paramc;
  }
  
  public final q f(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(214277);
    if (this.Iru) {
      try
      {
        paramString1 = new g(paramInt, paramString2, this.IqG, paramString3, this.mCount, this.IqF, paramString4, this.Irv, this.Irw);
        AppMethodBeat.o(214277);
        return paramString1;
      }
      catch (NumberFormatException paramString1)
      {
        Log.printErrStackTrace("MicroMsg.IapData", paramString1, "NetSceneGetAndroidIapPackage Error priceLevel:" + this.IqG, new Object[0]);
        AppMethodBeat.o(214277);
        return null;
      }
    }
    paramString1 = new u(this.rcD, this.IqG, this.IqF, this.mCount, paramInt, paramString1);
    AppMethodBeat.o(214277);
    return paramString1;
  }
  
  public final boolean fUs()
  {
    return this.AQo == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.c
 * JD-Core Version:    0.7.0.1
 */