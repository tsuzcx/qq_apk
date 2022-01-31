package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.h.a.fo;
import com.tencent.mm.sdk.b.a;

final class g$90$1
  implements DialogInterface.OnCancelListener
{
  g$90$1(g.90 param90) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new fo();
    paramDialogInterface.bMz.bMC = 3;
    a.udP.m(paramDialogInterface);
    g.a(this.rAp.rzi, this.rAp.rzk, "translateVoice:fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.90.1
 * JD-Core Version:    0.7.0.1
 */