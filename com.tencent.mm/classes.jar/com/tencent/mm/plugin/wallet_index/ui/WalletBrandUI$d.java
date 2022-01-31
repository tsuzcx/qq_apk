package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletBrandUI$d
  implements WalletBrandUI.b
{
  private String mReqKey = "";
  
  WalletBrandUI$d(WalletBrandUI paramWalletBrandUI) {}
  
  public final int cXj()
  {
    return 1521;
  }
  
  public final m cXk()
  {
    AppMethodBeat.i(48253);
    a locala = new a(WalletBrandUI.f(this.uBc).appId, WalletBrandUI.f(this.uBc).signType, WalletBrandUI.f(this.uBc).nonceStr, WalletBrandUI.f(this.uBc).packageExt, WalletBrandUI.f(this.uBc).cCB, WalletBrandUI.f(this.uBc).timeStamp, WalletBrandUI.f(this.uBc).url, WalletBrandUI.f(this.uBc).cCC, WalletBrandUI.f(this.uBc).cqj);
    g.RM();
    g.RK().eHt.a(locala, 0);
    AppMethodBeat.o(48253);
    return locala;
  }
  
  public final String cXl()
  {
    return this.mReqKey;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48254);
    paramm = (a)paramm;
    String str = paramm.uAd;
    ab.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
    this.mReqKey = str;
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.cnI = str;
    localPayInfo.appId = WalletBrandUI.f(this.uBc).appId;
    localPayInfo.uAe = paramm.uAe;
    localPayInfo.cCD = WalletBrandUI.f(this.uBc).cCD;
    localPayInfo.errMsg = paramString;
    localPayInfo.cCy = WalletBrandUI.f(this.uBc).cqj;
    h.a(this.uBc, localPayInfo, 1);
    AppMethodBeat.o(48254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.d
 * JD-Core Version:    0.7.0.1
 */