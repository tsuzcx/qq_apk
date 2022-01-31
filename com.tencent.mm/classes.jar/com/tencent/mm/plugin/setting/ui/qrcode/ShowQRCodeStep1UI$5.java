package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bb.a;
import com.tencent.mm.kernel.g;

final class ShowQRCodeStep1UI$5
  implements DialogInterface.OnCancelListener
{
  ShowQRCodeStep1UI$5(ShowQRCodeStep1UI paramShowQRCodeStep1UI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(126935);
    g.Rc().a(this.qFG);
    AppMethodBeat.o(126935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.5
 * JD-Core Version:    0.7.0.1
 */