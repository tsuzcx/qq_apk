package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class h$2
  implements DialogInterface.OnClickListener
{
  h$2(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", "https://www.payu.co.za/wechat/contact-us/");
    d.b(this.qlW, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    if ((this.qlW.aSk()) || (this.qlW.mController.contentView.getVisibility() != 0)) {
      this.qlW.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.h.2
 * JD-Core Version:    0.7.0.1
 */