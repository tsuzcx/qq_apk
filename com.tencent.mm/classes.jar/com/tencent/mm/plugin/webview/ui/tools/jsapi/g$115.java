package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;

final class g$115
  implements DialogInterface.OnCancelListener
{
  g$115(g paramg, String paramString) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    am.a.dVy.iC(this.dol);
    g.a(this.rzi, g.j(this.rzi), "profile:cancel", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.115
 * JD-Core Version:    0.7.0.1
 */