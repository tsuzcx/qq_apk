package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.b;

final class WalletBrandUI$c
  implements WalletBrandUI.b
{
  private String mReqKey = "";
  
  WalletBrandUI$c(WalletBrandUI paramWalletBrandUI) {}
  
  public final int cXj()
  {
    return 0;
  }
  
  public final m cXk()
  {
    AppMethodBeat.i(142594);
    WalletBrandUI.c.1 local1 = new WalletBrandUI.c.1(this);
    ((b)g.E(b.class)).startWxpayJsApiPay(this.uBc.getContext(), WalletBrandUI.f(this.uBc), local1, WalletBrandUI.g(this.uBc));
    AppMethodBeat.o(142594);
    return null;
  }
  
  public final String cXl()
  {
    return this.mReqKey;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.c
 * JD-Core Version:    0.7.0.1
 */