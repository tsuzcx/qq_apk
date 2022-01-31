package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class g$61
  implements DialogInterface.OnClickListener
{
  g$61(g paramg, a parama, String paramString1, String paramString2, i parami, JsapiPermissionWrapper paramJsapiPermissionWrapper) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(154983);
    h.qsU.e(14217, new Object[] { this.kYh.field_appId, Integer.valueOf(5), this.uTj, this.val$url, Integer.valueOf(3) });
    g.ey(this.vqm, this.uZa);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(154983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.61
 * JD-Core Version:    0.7.0.1
 */