package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.j;

final class SendAppMessageWrapperUI$2
  implements DialogInterface.OnCancelListener
{
  SendAppMessageWrapperUI$2(SendAppMessageWrapperUI paramSendAppMessageWrapperUI, j paramj) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(154014);
    this.zJg.dlb();
    this.AAH.setResult(-1);
    this.AAH.finish();
    AppMethodBeat.o(154014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.2
 * JD-Core Version:    0.7.0.1
 */