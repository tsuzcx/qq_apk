package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceMsgAlertActivity$2
  implements DialogInterface.OnDismissListener
{
  RemittanceMsgAlertActivity$2(RemittanceMsgAlertActivity paramRemittanceMsgAlertActivity) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(45082);
    this.qqQ.finish();
    AppMethodBeat.o(45082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceMsgAlertActivity.2
 * JD-Core Version:    0.7.0.1
 */