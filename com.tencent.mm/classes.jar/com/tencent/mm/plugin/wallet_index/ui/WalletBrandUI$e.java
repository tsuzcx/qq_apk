package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.s;

final class WalletBrandUI$e
  implements WalletBrandUI.b
{
  private String qmm = "";
  
  WalletBrandUI$e(WalletBrandUI paramWalletBrandUI) {}
  
  public final int bXB()
  {
    return 2755;
  }
  
  public final m bXC()
  {
    WalletBrandUI.a(this.qLY, this.qLY.getIntent().getStringExtra("appId"));
    Object localObject = this.qLY.getIntent().getStringExtra("signtype");
    String str1 = this.qLY.getIntent().getStringExtra("nonceStr");
    String str2 = this.qLY.getIntent().getStringExtra("timeStamp");
    String str3 = this.qLY.getIntent().getStringExtra("packageExt");
    String str4 = this.qLY.getIntent().getStringExtra("paySignature");
    String str5 = this.qLY.getIntent().getStringExtra("url");
    String str6 = this.qLY.getIntent().getStringExtra("ext_info");
    WalletBrandUI.b(this.qLY, this.qLY.getIntent().getStringExtra("bizUsername"));
    int i = this.qLY.getIntent().getIntExtra("pay_channel", 0);
    localObject = new c(WalletBrandUI.d(this.qLY), (String)localObject, str1, str3, str4, str2, str5, WalletBrandUI.e(this.qLY), i, WalletBrandUI.f(this.qLY), str6);
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
      paramm = (c)paramm;
      String str = paramm.qLh;
      this.qmm = str;
      y.d("MicroMsg.WalletBrandUI", "req_key = " + str);
      PayInfo localPayInfo = new PayInfo();
      localPayInfo.bMX = str;
      localPayInfo.appId = WalletBrandUI.d(this.qLY);
      localPayInfo.qLi = paramm.qLi;
      localPayInfo.bUV = WalletBrandUI.f(this.qLY);
      localPayInfo.aox = paramString;
      localPayInfo.bUR = this.qLY.getIntent().getIntExtra("pay_channel", 16);
      localPayInfo.snZ = paramm.fKz;
      aa.l(localPayInfo.bUV, str, paramInt2);
      h.a(this.qLY, localPayInfo, 1);
      return;
    }
    this.qLY.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.e
 * JD-Core Version:    0.7.0.1
 */