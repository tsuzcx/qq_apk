package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.b.a.bs;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class h$4
  implements DialogInterface.OnClickListener
{
  h$4(m paramm, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49128);
    paramDialogInterface = "";
    if ((this.ckS instanceof n)) {
      paramDialogInterface = ((n)this.ckS).tYb;
    }
    if (!bo.isNullOrNil(paramDialogInterface))
    {
      Object localObject = new bs();
      ((bs)localObject).cYR = 1L;
      ((bs)localObject).cYS = 2L;
      ((bs)localObject).ake();
      ab.i("MicroMsg.WalletErrMgr", "jump to forget_url %s", new Object[] { paramDialogInterface });
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramDialogInterface);
      ((Intent)localObject).putExtra("showShare", false);
      d.b(this.tVi, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      AppMethodBeat.o(49128);
      return;
    }
    paramDialogInterface = new bs();
    paramDialogInterface.cYR = 1L;
    paramDialogInterface.cYS = 1L;
    paramDialogInterface.ake();
    if (r.ZB()) {
      a.b(this.tVi, "PayUForgotPwdProcess", null);
    }
    for (;;)
    {
      if (this.tVi.isTransparent()) {
        this.tVi.finish();
      }
      AppMethodBeat.o(49128);
      return;
      a.b(this.tVi, "ForgotPwdProcess", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.h.4
 * JD-Core Version:    0.7.0.1
 */