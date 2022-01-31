package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.x;

final class ShareToQQUI$2$2
  implements DialogInterface.OnCancelListener
{
  ShareToQQUI$2$2(ShareToQQUI.2 param2, x paramx) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(126919);
    g.Rc().a(this.qFC);
    AppMethodBeat.o(126919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.2.2
 * JD-Core Version:    0.7.0.1
 */