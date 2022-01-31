package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.x;

final class ShareToQQWeiboUI$2$1
  implements DialogInterface.OnCancelListener
{
  ShareToQQWeiboUI$2$1(ShareToQQWeiboUI.2 param2, x paramx) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(9841);
    g.Rc().a(this.qFC);
    AppMethodBeat.o(9841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI.2.1
 * JD-Core Version:    0.7.0.1
 */