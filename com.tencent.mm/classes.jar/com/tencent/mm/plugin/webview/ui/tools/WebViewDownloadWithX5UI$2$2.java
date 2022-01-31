package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class WebViewDownloadWithX5UI$2$2
  implements DialogInterface.OnClickListener
{
  WebViewDownloadWithX5UI$2$2(WebViewDownloadWithX5UI.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7614);
    h.qsU.e(14217, new Object[] { "", Integer.valueOf(6), this.vcw.uTj, this.vcw.val$url, Integer.valueOf(1) });
    paramDialogInterface.dismiss();
    AppMethodBeat.o(7614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI.2.2
 * JD-Core Version:    0.7.0.1
 */