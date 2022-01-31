package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class f$2
  implements DialogInterface.OnClickListener
{
  f$2(WalletBaseUI paramWalletBaseUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    f.c(this.wCy);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.wCz);
    d.b(this.wCy.mController.uMN, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramDialogInterface);
    e.Jc(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.f.2
 * JD-Core Version:    0.7.0.1
 */