package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareToQQUI$4
  implements DialogInterface.OnDismissListener
{
  ShareToQQUI$4(ShareToQQUI paramShareToQQUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(126922);
    this.qFA.finish();
    AppMethodBeat.o(126922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.4
 * JD-Core Version:    0.7.0.1
 */