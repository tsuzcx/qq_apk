package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.ui.base.h;

public class WalletOpenFingerprintPayRedirectUI
  extends AutoLoginActivity
  implements f
{
  private boolean PA = false;
  private Dialog gKM = null;
  
  private void a(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(48296);
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.gKM != null) && (this.gKM.isShowing()))
    {
      this.gKM.dismiss();
      this.gKM = null;
    }
    if (paramBoolean)
    {
      h.a(this, paramString, "", false, new WalletOpenFingerprintPayRedirectUI.2(this));
      AppMethodBeat.o(48296);
      return;
    }
    finish();
    AppMethodBeat.o(48296);
  }
  
  public final boolean O(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(48295);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = ".concat(String.valueOf(parama)));
    switch (3.jLR[parama.ordinal()])
    {
    default: 
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
    }
    for (;;)
    {
      a(2, true, getString(2131304785));
      AppMethodBeat.o(48295);
      return;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.plugin.wallet_core.c.ab(null, 19), 0);
      if (this.gKM != null)
      {
        this.gKM.dismiss();
        this.gKM = null;
      }
      this.gKM = com.tencent.mm.wallet_core.ui.g.b(this, true, new WalletOpenFingerprintPayRedirectUI.1(this));
      AppMethodBeat.o(48295);
      return;
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      a(1, false, "");
    }
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48293);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(385, this);
    AppMethodBeat.o(48293);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48294);
    super.onDestroy();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(385, this);
    AppMethodBeat.o(48294);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48298);
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
    {
      if (!this.PA)
      {
        this.PA = true;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
          s.cRG();
          paramString = s.cRH();
          if ((paramString == null) || (!paramString.cUl()))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
            a(5, true, getString(2131305077));
            AppMethodBeat.o(48298);
            return;
          }
          if ((!a.cST()) || (ac.ery.eqC != 1))
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
            a(6, true, getString(2131305079));
            AppMethodBeat.o(48298);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("key_is_from_system", true);
          d.b(this, "wallet", ".pwd.ui.WalletPasswordSettingUI", paramString);
          finish();
          AppMethodBeat.o(48298);
          return;
        }
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
        a(3, true, getString(2131304785));
        AppMethodBeat.o(48298);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
    }
    AppMethodBeat.o(48298);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(48297);
    super.onStop();
    if ((this.gKM != null) && (this.gKM.isShowing()))
    {
      this.gKM.dismiss();
      this.gKM = null;
    }
    AppMethodBeat.o(48297);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI
 * JD-Core Version:    0.7.0.1
 */