package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aj$2
  implements DialogInterface.OnClickListener
{
  aj$2(aj paramaj, aw.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.iRM.e("fail_network_not_wifi", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aj.2
 * JD-Core Version:    0.7.0.1
 */