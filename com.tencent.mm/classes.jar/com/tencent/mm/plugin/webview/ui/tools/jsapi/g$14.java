package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.as.c;
import com.tencent.mm.as.o;

final class g$14
  implements DialogInterface.OnCancelListener
{
  g$14(g paramg, String paramString) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    o.OI().lV(this.eoz);
    g.a(this.rzi, g.j(this.rzi), "send_app_msg:cancel", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.14
 * JD-Core Version:    0.7.0.1
 */