package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.xweb.j;

final class WebViewUI$g$10
  implements DialogInterface.OnClickListener
{
  WebViewUI$g$10(WebViewUI.g paramg, String paramString, j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7910);
    h.qsU.e(11683, new Object[] { this.val$url, Integer.valueOf(1), Integer.valueOf(WebViewUI.v(this.vgN.vgz)) });
    this.vgP.cancel();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.vgN.vgz.finish();
    AppMethodBeat.o(7910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.g.10
 * JD-Core Version:    0.7.0.1
 */