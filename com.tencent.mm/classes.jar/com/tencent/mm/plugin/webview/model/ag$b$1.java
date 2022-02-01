package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ag$b$1
  implements DialogInterface.OnCancelListener
{
  ag$b$1(ag.c paramc) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(78944);
    Log.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
    this.PUu.cVG();
    AppMethodBeat.o(78944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag.b.1
 * JD-Core Version:    0.7.0.1
 */