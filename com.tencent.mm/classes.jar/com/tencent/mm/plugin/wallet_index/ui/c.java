package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet_index.b.a.e;
import com.tencent.mm.plugin.wallet_index.model.g;
import com.tencent.mm.plugin.wallet_index.model.n;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.u;
import com.tencent.mm.wallet_core.model.v;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  int MGo;
  public String WaY;
  public String Wag;
  public String Wah;
  public dbf Waq;
  public dbg War;
  public ArrayList<String> Wbb;
  public ArrayList<String> Wbc;
  public String Wbd;
  public int Wbe;
  List<String> Wbf;
  boolean Wbg;
  public String Wbh;
  public String Wbi;
  public int mCount;
  public String ryZ;
  public String xOk;
  
  public c()
  {
    AppMethodBeat.i(71861);
    this.Wbb = new ArrayList();
    this.Wbc = new ArrayList();
    this.mCount = 1;
    this.Wbd = null;
    this.Wbe = 0;
    this.Wah = null;
    this.Wag = null;
    this.WaY = null;
    this.Wbf = new ArrayList();
    this.xOk = null;
    this.Wbg = false;
    AppMethodBeat.o(71861);
  }
  
  public final p a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(71862);
    if (paramBoolean) {}
    for (int i = 2; this.Wbg; i = 1)
    {
      if (!imn())
      {
        this.Waq.aaGK = parame.mSignature;
        this.Waq.aaGH = parame.Waf;
        this.Waq.price = parame.Wah;
        this.Waq.aaoi = parame.Wag;
        this.Waq.MQZ = parame.xOk;
        this.Waq.aaGJ = parame.mOriginalJson;
      }
      parame = new n(this.MGo, i, parame.xOk, this.War, this.Waq);
      AppMethodBeat.o(71862);
      return parame;
    }
    parame = new v(parame.xOk, i, this.MGo, this.mCount, parame.Waf, parame.mOriginalJson, parame.mSignature, parame.Wag, parame.Wah);
    AppMethodBeat.o(71862);
    return parame;
  }
  
  public final boolean imn()
  {
    return this.MGo == 2;
  }
  
  public final p j(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(263557);
    if (this.Wbg) {
      try
      {
        paramString1 = new g(paramInt, paramString2, this.Wah, paramString3, this.mCount, this.Wag, paramString4, this.Wbh, this.Wbi, this.ryZ);
        AppMethodBeat.o(263557);
        return paramString1;
      }
      catch (NumberFormatException paramString1)
      {
        Log.printErrStackTrace("MicroMsg.IapData", paramString1, "NetSceneGetAndroidIapPackage Error priceLevel:" + this.Wah, new Object[0]);
        AppMethodBeat.o(263557);
        return null;
      }
    }
    paramString1 = new u(this.xOk, this.Wah, this.Wag, this.mCount, paramInt, paramString1);
    AppMethodBeat.o(263557);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.c
 * JD-Core Version:    0.7.0.1
 */