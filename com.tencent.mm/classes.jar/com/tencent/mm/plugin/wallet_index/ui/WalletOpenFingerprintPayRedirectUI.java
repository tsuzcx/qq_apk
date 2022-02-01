package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.Log;

public class WalletOpenFingerprintPayRedirectUI
  extends AutoLoginActivity
  implements com.tencent.mm.an.i
{
  private boolean gY = false;
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
  
  public final boolean Z(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(71936);
    Log.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = ".concat(String.valueOf(parama)));
    switch (3.sfH[parama.ordinal()])
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
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(new ae(null, 19), 0);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      this.tipDialog = com.tencent.mm.wallet_core.ui.i.b(this, true, new DialogInterface.OnCancelListener()
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
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71934);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(385, this);
    AppMethodBeat.o(71934);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71935);
    super.onDestroy();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(385, this);
    AppMethodBeat.o(71935);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71939);
    if ((paramq instanceof ae))
    {
      if (!this.gY)
      {
        this.gY = true;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Log.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
          s.gGL();
          paramString = s.gGM();
          if ((paramString == null) || (!paramString.gJQ()))
          {
            Log.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
            c(5, true, getString(a.i.wallet_fingerprint_redirect_not_open_fp_payment));
            AppMethodBeat.o(71939);
            return;
          }
          if ((!a.gIe()) || (af.juL.jsX != 1))
          {
            Log.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
            c(6, true, getString(a.i.wallet_fingerprint_support_not_fp_pay));
            AppMethodBeat.o(71939);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("key_is_from_system", true);
          com.tencent.mm.by.c.b(this, "wallet", ".pwd.ui.WalletPasswordSettingUI", paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI
 * JD-Core Version:    0.7.0.1
 */