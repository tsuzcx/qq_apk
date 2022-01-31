package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GetQRCodeInfoUI$2
  implements DialogInterface.OnCancelListener
{
  GetQRCodeInfoUI$2(GetQRCodeInfoUI paramGetQRCodeInfoUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(126903);
    this.qFv.finish();
    AppMethodBeat.o(126903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI.2
 * JD-Core Version:    0.7.0.1
 */