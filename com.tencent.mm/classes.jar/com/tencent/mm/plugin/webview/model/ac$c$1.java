package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class ac$c$1
  implements DialogInterface.OnCancelListener
{
  ac$c$1(ac.d paramd, ac.b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
    this.rfC.aIJ();
    this.rfD.remove(1254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac.c.1
 * JD-Core Version:    0.7.0.1
 */