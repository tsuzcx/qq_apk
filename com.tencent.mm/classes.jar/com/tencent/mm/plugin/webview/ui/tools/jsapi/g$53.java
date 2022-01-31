package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class g$53
  implements DialogInterface.OnClickListener
{
  g$53(g paramg, String paramString1, String paramString2, String paramString3, i parami, JsapiPermissionWrapper paramJsapiPermissionWrapper) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14217, new Object[] { this.val$appId, Integer.valueOf(5), this.rmF, this.val$url, Integer.valueOf(3) });
    g.ec(this.rzi, this.rzk);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.53
 * JD-Core Version:    0.7.0.1
 */