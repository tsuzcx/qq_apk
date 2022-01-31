package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class g$53
  implements DialogInterface.OnClickListener
{
  g$53(g paramg, String paramString1, String paramString2, String paramString3, i parami, JsapiPermissionWrapper paramJsapiPermissionWrapper) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(154977);
    h.qsU.e(14217, new Object[] { this.val$appId, Integer.valueOf(5), this.uTj, this.val$url, Integer.valueOf(3) });
    g.ex(this.vqm, this.uZa);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(154977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.53
 * JD-Core Version:    0.7.0.1
 */