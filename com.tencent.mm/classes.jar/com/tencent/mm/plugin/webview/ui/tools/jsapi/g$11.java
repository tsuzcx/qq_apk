package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.as.c;
import com.tencent.mm.as.o;

final class g$11
  implements DialogInterface.OnCancelListener
{
  g$11(g paramg, String paramString, i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    o.OI().lV(this.eoz);
    g.a(this.rzi, this.rzk, "send_service_app_msg:fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.11
 * JD-Core Version:    0.7.0.1
 */