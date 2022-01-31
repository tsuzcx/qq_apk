package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.v.a;

final class WalletIbgAdapterUI$1
  implements DialogInterface.OnClickListener
{
  WalletIbgAdapterUI$1(WalletIbgAdapterUI paramWalletIbgAdapterUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    v.a.eP(this.qHr);
    Toast.makeText(this.qHr, this.qHr.getString(a.i.webview_tbs_download_start), 1).show();
    this.qHr.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgAdapterUI.1
 * JD-Core Version:    0.7.0.1
 */