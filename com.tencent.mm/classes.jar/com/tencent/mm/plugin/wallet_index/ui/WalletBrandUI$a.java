package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.a.a;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public final class WalletBrandUI$a
  implements WalletBrandUI.b
{
  private String mReqKey = "";
  private int uBd = 0;
  
  public WalletBrandUI$a(WalletBrandUI paramWalletBrandUI) {}
  
  public final int cXj()
  {
    return 1563;
  }
  
  public final m cXk()
  {
    AppMethodBeat.i(48251);
    this.uBd = WalletBrandUI.f(this.uBc).wgK;
    int i = WalletBrandUI.f(this.uBc).cqj;
    a locala = new a(WalletBrandUI.f(this.uBc).appId, WalletBrandUI.f(this.uBc).nonceStr, WalletBrandUI.f(this.uBc).timeStamp, WalletBrandUI.f(this.uBc).packageExt, WalletBrandUI.f(this.uBc).cCB, WalletBrandUI.f(this.uBc).signType, WalletBrandUI.f(this.uBc).url, WalletBrandUI.f(this.uBc).cCC, i);
    g.RM();
    g.RK().eHt.a(locala, 0);
    AppMethodBeat.o(48251);
    return locala;
  }
  
  public final String cXl()
  {
    return this.mReqKey;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48252);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof a)))
    {
      paramString = ((a)paramm).jumpUrl;
      ab.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", new Object[] { paramString });
      this.mReqKey = paramString;
      paramm = ((a)paramm).uAq;
      Intent localIntent;
      if (this.uBd == 1)
      {
        localIntent = new Intent();
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("jsInjectCode", paramm);
        this.uBc.setResult(-1, localIntent);
      }
      for (;;)
      {
        this.uBc.finish();
        AppMethodBeat.o(48252);
        return;
        localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramString);
        localIntent.putExtra("showShare", false);
        if (!bo.isNullOrNil(paramm))
        {
          localIntent.putExtra("shouldForceViewPort", true);
          localIntent.putExtra("view_port_code", paramm);
        }
        d.b(this.uBc, "webview", ".ui.tools.WebViewUI", localIntent);
        this.uBc.setResult(-1);
      }
    }
    ab.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    h.a(this.uBc, paramString, "", new WalletBrandUI.a.1(this), new WalletBrandUI.a.2(this));
    AppMethodBeat.o(48252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.a
 * JD-Core Version:    0.7.0.1
 */