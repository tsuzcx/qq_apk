package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.y;

final class WalletBrandUI$c
  implements WalletBrandUI.b
{
  private String qmm = "";
  
  WalletBrandUI$c(WalletBrandUI paramWalletBrandUI) {}
  
  public final int bXB()
  {
    return 1521;
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
    WalletBrandUI.b(this.qLY, this.qLY.getIntent().getStringExtra("bizUsername"));
    int i = this.qLY.getIntent().getIntExtra("pay_channel", 0);
    localObject = new a(WalletBrandUI.d(this.qLY), (String)localObject, str1, str3, str4, str2, str5, WalletBrandUI.e(this.qLY), i);
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
    paramm = (a)paramm;
    String str = paramm.qLh;
    y.d("MicroMsg.WalletBrandUI", "req_key = " + str);
    this.qmm = str;
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.bMX = str;
    localPayInfo.appId = WalletBrandUI.d(this.qLY);
    localPayInfo.qLi = paramm.qLi;
    localPayInfo.bUV = WalletBrandUI.f(this.qLY);
    localPayInfo.aox = paramString;
    localPayInfo.bUR = this.qLY.getIntent().getIntExtra("pay_channel", 0);
    h.a(this.qLY, localPayInfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.c
 * JD-Core Version:    0.7.0.1
 */