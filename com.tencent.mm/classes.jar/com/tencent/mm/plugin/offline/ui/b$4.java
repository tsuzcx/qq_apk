package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$4
  implements DialogInterface.OnClickListener
{
  b$4(Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43468);
    if ((this.val$activity instanceof WalletOfflineCoinPurseUI)) {
      ((WalletOfflineCoinPurseUI)this.val$activity).pnu = false;
    }
    paramDialogInterface.dismiss();
    AppMethodBeat.o(43468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.b.4
 * JD-Core Version:    0.7.0.1
 */