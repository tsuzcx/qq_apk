package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.ad;

final class WalletBrandUI$f
  implements WalletBrandUI.b
{
  private String mReqKey = "";
  
  WalletBrandUI$f(WalletBrandUI paramWalletBrandUI) {}
  
  public final int cXj()
  {
    return 2755;
  }
  
  public final m cXk()
  {
    AppMethodBeat.i(48258);
    d locald = new d(WalletBrandUI.f(this.uBc).appId, WalletBrandUI.f(this.uBc).signType, WalletBrandUI.f(this.uBc).nonceStr, WalletBrandUI.f(this.uBc).packageExt, WalletBrandUI.f(this.uBc).cCB, WalletBrandUI.f(this.uBc).timeStamp, WalletBrandUI.f(this.uBc).url, WalletBrandUI.f(this.uBc).cCC, WalletBrandUI.f(this.uBc).cqj, WalletBrandUI.f(this.uBc).cCD, WalletBrandUI.f(this.uBc).extInfo);
    locald.setProcessSessionId(System.currentTimeMillis());
    locald.setProcessName("PayProcess");
    locald.setScene(WalletBrandUI.f(this.uBc).cCD);
    g.RM();
    g.RK().eHt.a(locald, 0);
    AppMethodBeat.o(48258);
    return locald;
  }
  
  public final String cXl()
  {
    return this.mReqKey;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48259);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (d)paramm;
      String str = paramm.uAd;
      this.mReqKey = str;
      ab.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
      PayInfo localPayInfo = new PayInfo();
      localPayInfo.cnI = str;
      localPayInfo.appId = WalletBrandUI.f(this.uBc).appId;
      localPayInfo.uAe = paramm.uAe;
      localPayInfo.cCD = WalletBrandUI.f(this.uBc).cCD;
      localPayInfo.errMsg = paramString;
      localPayInfo.cCy = WalletBrandUI.f(this.uBc).cqj;
      localPayInfo.wgx = paramm.sessionId;
      ad.q(localPayInfo.cCD, str, paramInt2);
      h.a(this.uBc, localPayInfo, 1);
      AppMethodBeat.o(48259);
      return;
    }
    this.uBc.finish();
    AppMethodBeat.o(48259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.f
 * JD-Core Version:    0.7.0.1
 */