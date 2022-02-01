package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;

public class WalletOpenFingerprintPayRedirectUI
  extends AutoLoginActivity
  implements f
{
  private boolean Zo = false;
  private Dialog tipDialog = null;
  
  private void c(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(71937);
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramBoolean)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71932);
          WalletOpenFingerprintPayRedirectUI.this.finish();
          AppMethodBeat.o(71932);
        }
      });
      AppMethodBeat.o(71937);
      return;
    }
    finish();
    AppMethodBeat.o(71937);
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(71936);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = ".concat(String.valueOf(parama)));
    switch (WalletOpenFingerprintPayRedirectUI.3.nSR[parama.ordinal()])
    {
    default: 
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
    }
    for (;;)
    {
      c(2, true, getString(2131764968));
      AppMethodBeat.o(71936);
      return;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
      g.ajS();
      g.ajQ().gDv.a(new ad(null, 19), 0);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      this.tipDialog = com.tencent.mm.wallet_core.ui.h.b(this, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(71931);
          WalletOpenFingerprintPayRedirectUI.a(WalletOpenFingerprintPayRedirectUI.this);
          WalletOpenFingerprintPayRedirectUI.a(WalletOpenFingerprintPayRedirectUI.this, "");
          AppMethodBeat.o(71931);
        }
      });
      AppMethodBeat.o(71936);
      return;
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      c(1, false, "");
    }
  }
  
  public final boolean ab(Intent paramIntent)
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71934);
    super.onCreate(paramBundle);
    g.ajS();
    g.ajQ().gDv.a(385, this);
    AppMethodBeat.o(71934);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71935);
    super.onDestroy();
    g.ajS();
    g.ajQ().gDv.b(385, this);
    AppMethodBeat.o(71935);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71939);
    if ((paramn instanceof ad))
    {
      if (!this.Zo)
      {
        this.Zo = true;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
          s.eGW();
          paramString = s.eGX();
          if ((paramString == null) || (!paramString.eJH()))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
            c(5, true, getString(2131765269));
            AppMethodBeat.o(71939);
            return;
          }
          if ((!a.eIj()) || (com.tencent.mm.compatible.deviceinfo.ae.geQ.gdh != 1))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
            c(6, true, getString(2131765271));
            AppMethodBeat.o(71939);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("key_is_from_system", true);
          d.b(this, "wallet", ".pwd.ui.WalletPasswordSettingUI", paramString);
          finish();
          AppMethodBeat.o(71939);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
        c(3, true, getString(2131764968));
        AppMethodBeat.o(71939);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
    }
    AppMethodBeat.o(71939);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(71938);
    super.onStop();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(71938);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI
 * JD-Core Version:    0.7.0.1
 */