package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.d.b;

final class g$65
  implements DialogInterface.OnCancelListener
{
  g$65(g paramg, d.b paramb, String paramString, i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    com.tencent.mm.plugin.webview.modeltools.g.ccK().a(this.rAc);
    com.tencent.mm.plugin.webview.modeltools.g.ccK();
    ag.Sh(this.rAb);
    g.a(this.rzi, this.rzk, "downloadImage:fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.65
 * JD-Core Version:    0.7.0.1
 */