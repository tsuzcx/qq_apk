package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GetQRCodeInfoUI$3
  implements DialogInterface.OnClickListener
{
  GetQRCodeInfoUI$3(GetQRCodeInfoUI paramGetQRCodeInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(126904);
    this.qFv.finish();
    AppMethodBeat.o(126904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI.3
 * JD-Core Version:    0.7.0.1
 */