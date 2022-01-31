package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.b.a.z;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class h$4
  implements DialogInterface.OnClickListener
{
  h$4(m paramm, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "";
    if ((this.bEe instanceof k)) {
      paramDialogInterface = ((k)this.bEe).qoo;
    }
    if (!bk.bl(paramDialogInterface))
    {
      Object localObject = new z();
      ((z)localObject).ckp = 1L;
      ((z)localObject).ckq = 2L;
      ((z)localObject).QX();
      y.i("MicroMsg.WalletErrMgr", "jump to forget_url %s", new Object[] { paramDialogInterface });
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramDialogInterface);
      ((Intent)localObject).putExtra("showShare", false);
      d.b(this.qlW, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    }
    for (;;)
    {
      return;
      paramDialogInterface = new z();
      paramDialogInterface.ckp = 1L;
      paramDialogInterface.ckq = 1L;
      paramDialogInterface.QX();
      if (q.Gw()) {
        a.b(this.qlW, "PayUForgotPwdProcess", null);
      }
      while (this.qlW.aSk())
      {
        this.qlW.finish();
        return;
        a.b(this.qlW, "ForgotPwdProcess", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.h.4
 * JD-Core Version:    0.7.0.1
 */