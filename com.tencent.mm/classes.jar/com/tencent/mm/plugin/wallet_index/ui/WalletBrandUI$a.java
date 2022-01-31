package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public final class WalletBrandUI$a
  implements WalletBrandUI.b
{
  private int qLZ = 0;
  private String qmm = "";
  
  public WalletBrandUI$a(WalletBrandUI paramWalletBrandUI) {}
  
  public final int bXB()
  {
    return 1563;
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
    this.qLZ = this.qLY.getIntent().getIntExtra("result_jump_mode", 0);
    WalletBrandUI.b(this.qLY, this.qLY.getIntent().getStringExtra("bizUsername"));
    int i = this.qLY.getIntent().getIntExtra("pay_channel", 0);
    localObject = new a(WalletBrandUI.d(this.qLY), str1, str2, str3, str4, (String)localObject, str5, WalletBrandUI.e(this.qLY), i);
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
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof a)))
    {
      paramString = ((a)paramm).jumpUrl;
      y.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", new Object[] { paramString });
      this.qmm = paramString;
      paramm = ((a)paramm).qLu;
      Intent localIntent;
      if (this.qLZ == 1)
      {
        localIntent = new Intent();
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("jsInjectCode", paramm);
        this.qLY.setResult(-1, localIntent);
      }
      for (;;)
      {
        this.qLY.finish();
        return;
        localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramString);
        localIntent.putExtra("showShare", false);
        if (!bk.bl(paramm))
        {
          localIntent.putExtra("shouldForceViewPort", true);
          localIntent.putExtra("view_port_code", paramm);
        }
        d.b(this.qLY, "webview", ".ui.tools.WebViewUI", localIntent);
        this.qLY.setResult(-1);
      }
    }
    y.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    h.a(this.qLY, paramString, "", new WalletBrandUI.a.1(this), new WalletBrandUI.a.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.a
 * JD-Core Version:    0.7.0.1
 */