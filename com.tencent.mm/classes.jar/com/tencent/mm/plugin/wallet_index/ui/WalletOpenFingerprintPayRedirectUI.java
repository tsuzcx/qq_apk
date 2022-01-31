package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.s;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.ui.base.h;

public class WalletOpenFingerprintPayRedirectUI
  extends AutoLoginActivity
  implements f
{
  private boolean PU = false;
  private Dialog ftk = null;
  
  private void b(int paramInt, boolean paramBoolean, String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.ftk != null) && (this.ftk.isShowing()))
    {
      this.ftk.dismiss();
      this.ftk = null;
    }
    if (paramBoolean)
    {
      h.a(this, paramString, "", false, new WalletOpenFingerprintPayRedirectUI.2(this));
      return;
    }
    finish();
  }
  
  protected final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = " + parama);
    switch (3.hSj[parama.ordinal()])
    {
    default: 
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = " + parama);
    }
    for (;;)
    {
      b(2, true, getString(a.i.wallet_app_err_system_busy_tip));
      return;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.plugin.wallet_core.c.y(null, 19), 0);
      if (this.ftk != null)
      {
        this.ftk.dismiss();
        this.ftk = null;
      }
      this.ftk = com.tencent.mm.wallet_core.ui.g.e(this, new WalletOpenFingerprintPayRedirectUI.1(this));
      return;
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = " + parama);
      b(1, false, "");
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(385, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(385, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))
    {
      if (this.PU) {
        break label164;
      }
      this.PU = true;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label143;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
      com.tencent.mm.plugin.wallet.a.p.bTK();
      paramString = com.tencent.mm.plugin.wallet.a.p.bTL();
      if ((paramString == null) || (!paramString.bVN()))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
        b(5, true, getString(a.i.wallet_fingerprint_redirect_not_open_fp_payment));
      }
    }
    else
    {
      return;
    }
    if ((!a.bUE()) || (q.dyh.dyr != 1))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
      b(6, true, getString(a.i.wallet_fingerprint_support_not_fp_pay));
      return;
    }
    paramString = new Intent();
    paramString.putExtra("key_is_from_system", true);
    d.b(this, "wallet", ".pwd.ui.WalletPasswordSettingUI", paramString);
    finish();
    return;
    label143:
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
    b(3, true, getString(a.i.wallet_app_err_system_busy_tip));
    return;
    label164:
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
  }
  
  protected void onStop()
  {
    super.onStop();
    if ((this.ftk != null) && (this.ftk.isShowing()))
    {
      this.ftk.dismiss();
      this.ftk = null;
    }
  }
  
  protected final boolean w(Intent paramIntent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI
 * JD-Core Version:    0.7.0.1
 */