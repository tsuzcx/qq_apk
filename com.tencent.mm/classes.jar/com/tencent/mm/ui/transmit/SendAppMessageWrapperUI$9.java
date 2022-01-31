package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.model.j;

final class SendAppMessageWrapperUI$9
  implements DialogInterface.OnCancelListener
{
  SendAppMessageWrapperUI$9(SendAppMessageWrapperUI paramSendAppMessageWrapperUI, j paramj) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.vto.ckw();
    this.whK.setResult(-1);
    this.whK.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.9
 * JD-Core Version:    0.7.0.1
 */