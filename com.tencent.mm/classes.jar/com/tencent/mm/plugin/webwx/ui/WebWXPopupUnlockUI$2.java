package com.tencent.mm.plugin.webwx.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebWXPopupUnlockUI$2
  implements DialogInterface.OnDismissListener
{
  WebWXPopupUnlockUI$2(WebWXPopupUnlockUI paramWebWXPopupUnlockUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(26569);
    this.vuM.finish();
    AppMethodBeat.o(26569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI.2
 * JD-Core Version:    0.7.0.1
 */