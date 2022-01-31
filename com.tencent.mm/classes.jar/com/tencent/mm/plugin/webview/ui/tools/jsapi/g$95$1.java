package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class g$95$1
  implements DialogInterface.OnClickListener
{
  g$95$1(g.95 param95) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    g.i(this.rAs.rzi).startActivity(new Intent("android.settings.NFC_SETTINGS"));
    g.a(this.rAs.rzi, this.rAs.rzk, "nfcCheckState:nfc_off", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.95.1
 * JD-Core Version:    0.7.0.1
 */