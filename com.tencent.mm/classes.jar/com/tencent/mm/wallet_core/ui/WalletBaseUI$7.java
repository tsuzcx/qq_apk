package com.tencent.mm.wallet_core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletBaseUI$7
  implements DialogInterface.OnCancelListener
{
  WalletBaseUI$7(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(142666);
    if ((WalletBaseUI.access$300(this.AYz) != null) && (WalletBaseUI.access$300(this.AYz).isShowing())) {
      WalletBaseUI.access$300(this.AYz).dismiss();
    }
    if ((WalletBaseUI.access$400(this.AYz).getVisibility() == 8) || (WalletBaseUI.access$500(this.AYz).getVisibility() == 4))
    {
      ab.i("MicroMsg.WalletBaseUI", "usr cancel, & visibility not visiable, so finish");
      this.AYz.finish();
    }
    this.AYz.forceCancel();
    AppMethodBeat.o(142666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.7
 * JD-Core Version:    0.7.0.1
 */