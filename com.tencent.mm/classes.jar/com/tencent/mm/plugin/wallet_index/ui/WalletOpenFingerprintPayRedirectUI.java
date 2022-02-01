package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;

public class WalletOpenFingerprintPayRedirectUI
  extends AutoLoginActivity
  implements com.tencent.mm.ak.g
{
  private boolean Xz = false;
  private Dialog tipDialog = null;
  
  private void c(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(71937);
    ac.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramBoolean)
    {
      h.a(this, paramString, "", false, new DialogInterface.OnClickListener()
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
    ac.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = ".concat(String.valueOf(parama)));
    switch (WalletOpenFingerprintPayRedirectUI.3.nmN[parama.ordinal()])
    {
    default: 
      ac.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
    }
    for (;;)
    {
      c(2, true, getString(2131764968));
      AppMethodBeat.o(71936);
      return;
      ac.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(new ad(null, 19), 0);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      this.tipDialog = com.tencent.mm.wallet_core.ui.g.b(this, true, new DialogInterface.OnCancelListener()
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
      ac.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
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
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
    AppMethodBeat.o(71934);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71935);
    super.onDestroy();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
    AppMethodBeat.o(71935);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71939);
    if ((paramn instanceof ad))
    {
      if (!this.Xz)
      {
        this.Xz = true;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ac.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
          s.epp();
          paramString = s.epq();
          if ((paramString == null) || (!paramString.esa()))
          {
            ac.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
            c(5, true, getString(2131765269));
            AppMethodBeat.o(71939);
            return;
          }
          if ((!a.eqC()) || (ae.fJh.fHz != 1))
          {
            ac.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
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
        ac.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
        c(3, true, getString(2131764968));
        AppMethodBeat.o(71939);
        return;
      }
      ac.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI
 * JD-Core Version:    0.7.0.1
 */