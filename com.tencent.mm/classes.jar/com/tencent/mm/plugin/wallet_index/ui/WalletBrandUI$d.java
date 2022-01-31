package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.tg;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.cia;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.s;

final class WalletBrandUI$d
  implements WalletBrandUI.b
{
  private String qmm = "";
  
  WalletBrandUI$d(WalletBrandUI paramWalletBrandUI) {}
  
  public final int bXB()
  {
    if (com.tencent.mm.plugin.wallet_index.c.a.QU(this.qLY.getIntent().getStringExtra("packageExt"))) {
      return 2519;
    }
    return 398;
  }
  
  public final m bXC()
  {
    WalletBrandUI.a(this.qLY, this.qLY.getIntent().getStringExtra("appId"));
    String str1 = this.qLY.getIntent().getStringExtra("signtype");
    String str2 = this.qLY.getIntent().getStringExtra("nonceStr");
    String str3 = this.qLY.getIntent().getStringExtra("timeStamp");
    String str4 = this.qLY.getIntent().getStringExtra("packageExt");
    String str5 = this.qLY.getIntent().getStringExtra("paySignature");
    String str6 = this.qLY.getIntent().getStringExtra("url");
    WalletBrandUI.b(this.qLY, this.qLY.getIntent().getStringExtra("bizUsername"));
    int i = this.qLY.getIntent().getIntExtra("pay_channel", 0);
    int j = this.qLY.getIntent().getIntExtra("key_wx_app_scene", 0);
    String str7 = this.qLY.getIntent().getStringExtra("cookie");
    Object localObject = new com.tencent.mm.plugin.wallet_index.c.d(WalletBrandUI.d(this.qLY), str1, str2, str4, str5, str3, str6, WalletBrandUI.e(this.qLY), i, WalletBrandUI.f(this.qLY), j, str7);
    if (com.tencent.mm.plugin.wallet_index.c.a.QU(str4)) {
      localObject = new com.tencent.mm.plugin.wallet_index.c.h(WalletBrandUI.d(this.qLY), str1, str2, str4, str5, str3, str6, WalletBrandUI.e(this.qLY), i, WalletBrandUI.f(this.qLY), j, str7);
    }
    ((s)localObject).fKz = System.currentTimeMillis();
    ((s)localObject).dIA = "PayProcess";
    ((s)localObject).fzn = WalletBrandUI.f(this.qLY);
    g.DQ();
    g.DO().dJT.a((m)localObject, 0);
    return localObject;
  }
  
  public final String bXD()
  {
    return this.qmm;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.wallet_index.c.d locald = (com.tencent.mm.plugin.wallet_index.c.d)paramm;
      localObject = locald.qLh;
      y.d("MicroMsg.WalletBrandUI", "req_key = " + (String)localObject);
      this.qmm = ((String)localObject);
      com.tencent.mm.sdk.b.a.udP.m(new tg());
      paramm = ((com.tencent.mm.plugin.wallet_index.c.d)paramm).qLj;
      if ((paramm != null) && (!bk.bl(paramm.tWB)))
      {
        paramString = new Intent();
        paramString.putExtra("prepayId", (String)localObject);
        paramString.putExtra("is_jsapi_offline_pay", false);
        paramString.putExtra("pay_gate_url", paramm.tWB);
        paramString.putExtra("need_dialog", paramm.tWD);
        paramString.putExtra("dialog_text", paramm.tWE);
        paramString.putExtra("max_count", paramm.tWC.sHa);
        paramString.putExtra("inteval_time", paramm.tWC.sGZ);
        paramString.putExtra("default_wording", paramm.tWC.sHb);
        com.tencent.mm.br.d.c(this.qLY, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
        return;
      }
      paramm = new PayInfo();
      paramm.bMX = ((String)localObject);
      paramm.appId = WalletBrandUI.d(this.qLY);
      paramm.qLi = locald.qLi;
      paramm.bUV = WalletBrandUI.f(this.qLY);
      paramm.aox = paramString;
      paramm.bUR = this.qLY.getIntent().getIntExtra("pay_channel", 0);
      paramm.snZ = locald.fKz;
      aa.l(paramm.bUV, (String)localObject, paramInt2);
      com.tencent.mm.pluginsdk.wallet.h.a(this.qLY, paramm, 1);
      return;
    }
    aa.l(WalletBrandUI.f(this.qLY), "", paramInt2);
    Object localObject = new Intent();
    if (paramInt1 != 0) {
      paramInt2 = -1;
    }
    ((Intent)localObject).putExtra("key_jsapi_pay_err_code", paramInt2);
    paramm = paramString;
    if (bk.bl(paramString)) {
      paramm = this.qLY.getString(a.i.wallet_net_err);
    }
    ((Intent)localObject).putExtra("key_jsapi_pay_err_msg", paramm);
    this.qLY.setResult(5, (Intent)localObject);
    this.qLY.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.d
 * JD-Core Version:    0.7.0.1
 */