package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.va;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.e;
import com.tencent.mm.plugin.wallet_index.c.i;
import com.tencent.mm.plugin.wallet_index.c.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ad;

final class WalletBrandUI$e
  implements WalletBrandUI.b
{
  private String mReqKey = "";
  
  WalletBrandUI$e(WalletBrandUI paramWalletBrandUI) {}
  
  public final int cXj()
  {
    AppMethodBeat.i(48257);
    if (com.tencent.mm.plugin.wallet_index.c.a.hd(WalletBrandUI.f(this.uBc).packageExt, "up_"))
    {
      AppMethodBeat.o(48257);
      return 2519;
    }
    if (com.tencent.mm.plugin.wallet_index.c.a.hd(WalletBrandUI.f(this.uBc).packageExt, "tax_"))
    {
      AppMethodBeat.o(48257);
      return 2923;
    }
    if (com.tencent.mm.plugin.wallet_index.c.a.hd(WalletBrandUI.f(this.uBc).packageExt, "dc_"))
    {
      AppMethodBeat.o(48257);
      return 2798;
    }
    AppMethodBeat.o(48257);
    return 398;
  }
  
  public final m cXk()
  {
    AppMethodBeat.i(48255);
    Object localObject = WalletBrandUI.f(this.uBc).appId;
    String str1 = WalletBrandUI.f(this.uBc).signType;
    String str2 = WalletBrandUI.f(this.uBc).nonceStr;
    String str3 = WalletBrandUI.f(this.uBc).packageExt;
    String str4 = WalletBrandUI.f(this.uBc).cCB;
    String str5 = WalletBrandUI.f(this.uBc).timeStamp;
    String str6 = WalletBrandUI.f(this.uBc).url;
    String str7 = WalletBrandUI.f(this.uBc).cCC;
    int i = WalletBrandUI.f(this.uBc).cqj;
    int j = WalletBrandUI.f(this.uBc).cCD;
    int k = WalletBrandUI.f(this.uBc).wgH;
    String str8 = WalletBrandUI.f(this.uBc).flC;
    if (com.tencent.mm.plugin.wallet_index.c.a.hd(str3, "up_")) {
      localObject = new j((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
    }
    for (;;)
    {
      ((e)localObject).setProcessSessionId(System.currentTimeMillis());
      ((e)localObject).setProcessName("PayProcess");
      ((e)localObject).setScene(WalletBrandUI.f(this.uBc).cCD);
      g.RM();
      g.RK().eHt.a((m)localObject, 0);
      AppMethodBeat.o(48255);
      return localObject;
      if (com.tencent.mm.plugin.wallet_index.c.a.hd(str3, "tax_")) {
        localObject = new i((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
      } else if (com.tencent.mm.plugin.wallet_index.c.a.hd(str3, "dc_")) {
        localObject = new com.tencent.mm.plugin.wallet_index.c.c((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
      } else {
        localObject = new e((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
      }
    }
  }
  
  public final String cXl()
  {
    return this.mReqKey;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48256);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e locale = (e)paramm;
      localObject1 = locale.uAd;
      ab.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(localObject1)));
      this.mReqKey = ((String)localObject1);
      com.tencent.mm.sdk.b.a.ymk.l(new va());
      Object localObject2 = ((e)paramm).uAf;
      if ((localObject2 != null) && (!bo.isNullOrNil(((cvm)localObject2).ydT)))
      {
        paramString = new Intent();
        paramString.putExtra("prepayId", (String)localObject1);
        paramString.putExtra("is_jsapi_offline_pay", false);
        paramString.putExtra("pay_gate_url", ((cvm)localObject2).ydT);
        paramString.putExtra("need_dialog", ((cvm)localObject2).ydV);
        paramString.putExtra("dialog_text", ((cvm)localObject2).ydW);
        paramString.putExtra("max_count", ((cvm)localObject2).ydU.wDy);
        paramString.putExtra("inteval_time", ((cvm)localObject2).ydU.wDx);
        paramString.putExtra("default_wording", ((cvm)localObject2).ydU.wDz);
        d.c(this.uBc, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
        AppMethodBeat.o(48256);
        return;
      }
      localObject2 = new PayInfo();
      ((PayInfo)localObject2).cnI = ((String)localObject1);
      ((PayInfo)localObject2).appId = WalletBrandUI.f(this.uBc).appId;
      ((PayInfo)localObject2).uAe = locale.uAe;
      ((PayInfo)localObject2).cCD = WalletBrandUI.f(this.uBc).cCD;
      ((PayInfo)localObject2).errMsg = paramString;
      ((PayInfo)localObject2).cCy = WalletBrandUI.f(this.uBc).cqj;
      ((PayInfo)localObject2).wgx = locale.sessionId;
      if (((PayInfo)localObject2).wgv == null) {
        ((PayInfo)localObject2).wgv = new Bundle();
      }
      ((PayInfo)localObject2).wgv.putString("extinfo_key_20", ((e)paramm).uAg);
      ((PayInfo)localObject2).wgv.putString("extinfo_key_21", WalletBrandUI.f(this.uBc).wgL);
      ((PayInfo)localObject2).wgv.putString("extinfo_key_22", WalletBrandUI.f(this.uBc).wgM);
      ad.q(((PayInfo)localObject2).cCD, (String)localObject1, paramInt2);
      com.tencent.mm.pluginsdk.wallet.h.a(this.uBc, (PayInfo)localObject2, 1);
      AppMethodBeat.o(48256);
      return;
    }
    ad.q(WalletBrandUI.f(this.uBc).cCD, "", paramInt2);
    if (WalletBrandUI.f(this.uBc).cCD == 3)
    {
      paramm = this.uBc;
      if (bo.isNullOrNil(paramString)) {
        paramString = this.uBc.getString(2131305306);
      }
      for (;;)
      {
        paramString = com.tencent.mm.ui.base.h.a(paramm, paramString, "", this.uBc.getString(2131305051), false, new WalletBrandUI.e.1(this));
        if (paramString != null) {
          paramString.setCancelable(false);
        }
        if (WalletBrandUI.d(this.uBc) != null)
        {
          WalletBrandUI.d(this.uBc).dismiss();
          WalletBrandUI.e(this.uBc);
        }
        AppMethodBeat.o(48256);
        return;
      }
    }
    Object localObject1 = new Intent();
    if (paramInt1 != 0) {
      paramInt2 = -1;
    }
    ((Intent)localObject1).putExtra("key_jsapi_pay_onActivityResult", "jsapi_pay_onActivityResult");
    ((Intent)localObject1).putExtra("key_jsapi_pay_err_code", paramInt2);
    paramm = paramString;
    if (bo.isNullOrNil(paramString)) {
      paramm = this.uBc.getString(2131305306);
    }
    ((Intent)localObject1).putExtra("key_jsapi_pay_err_msg", paramm);
    ((Intent)localObject1).putExtra("key_jsapi_pay_err_dialog_confirm", this.uBc.getString(2131305051));
    this.uBc.setResult(5, (Intent)localObject1);
    this.uBc.finish();
    AppMethodBeat.o(48256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.e
 * JD-Core Version:    0.7.0.1
 */