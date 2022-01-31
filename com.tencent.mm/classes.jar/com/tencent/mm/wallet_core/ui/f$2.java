package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class f$2
  implements DialogInterface.OnClickListener
{
  f$2(WalletBaseUI paramWalletBaseUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49330);
    f.c(this.AYK);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.AYL);
    d.b(this.AYK.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramDialogInterface);
    e.RX(3);
    AppMethodBeat.o(49330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.f.2
 * JD-Core Version:    0.7.0.1
 */