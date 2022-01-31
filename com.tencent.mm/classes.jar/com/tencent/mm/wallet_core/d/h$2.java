package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class h$2
  implements DialogInterface.OnClickListener
{
  h$2(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49126);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", "https://www.payu.co.za/wechat/contact-us/");
    d.b(this.tVi, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    if ((this.tVi.isTransparent()) || (this.tVi.getContentViewVisibility() != 0)) {
      this.tVi.finish();
    }
    AppMethodBeat.o(49126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.h.2
 * JD-Core Version:    0.7.0.1
 */