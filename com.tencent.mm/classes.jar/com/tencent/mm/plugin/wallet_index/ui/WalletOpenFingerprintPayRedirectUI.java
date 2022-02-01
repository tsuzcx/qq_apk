package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.l;

public class WalletOpenFingerprintPayRedirectUI
  extends AutoLoginActivity
  implements com.tencent.mm.am.h
{
  private boolean hT = false;
  private Dialog tipDialog = null;
  
  private void c(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(71937);
    Log.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramBoolean)
    {
      k.a(this, paramString, "", false, new DialogInterface.OnClickListener()
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
    Log.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = ".concat(String.valueOf(parama)));
    switch (WalletOpenFingerprintPayRedirectUI.3.vrD[parama.ordinal()])
    {
    default: 
      Log.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
    }
    for (;;)
    {
      c(2, true, getString(a.i.wallet_app_err_system_busy_tip));
      AppMethodBeat.o(71936);
      return;
      Log.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new ae(null, 19), 0);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      this.tipDialog = l.b(this, true, new DialogInterface.OnCancelListener()
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
      Log.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      c(1, false, "");
    }
  }
  
  public final boolean ad(Intent paramIntent)
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
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(385, this);
    AppMethodBeat.o(71934);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71935);
    super.onDestroy();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(385, this);
    AppMethodBeat.o(71935);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(71939);
    if ((paramp instanceof ae))
    {
      if (!this.hT)
      {
        this.hT = true;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Log.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
          com.tencent.mm.plugin.wallet.model.p.ifO();
          paramString = com.tencent.mm.plugin.wallet.model.p.ifP();
          if ((paramString == null) || (!paramString.ijf()))
          {
            Log.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
            c(5, true, getString(a.i.wallet_fingerprint_redirect_not_open_fp_payment));
            AppMethodBeat.o(71939);
            return;
          }
          if ((!a.ihi()) || (af.lYc.lWp != 1))
          {
            Log.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
            c(6, true, getString(a.i.wallet_fingerprint_support_not_fp_pay));
            AppMethodBeat.o(71939);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("key_is_from_system", true);
          com.tencent.mm.br.c.b(this, "wallet", ".pwd.ui.WalletPasswordSettingUI", paramString);
          finish();
          AppMethodBeat.o(71939);
          return;
        }
        Log.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
        c(3, true, getString(a.i.wallet_app_err_system_busy_tip));
        AppMethodBeat.o(71939);
        return;
      }
      Log.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI
 * JD-Core Version:    0.7.0.1
 */