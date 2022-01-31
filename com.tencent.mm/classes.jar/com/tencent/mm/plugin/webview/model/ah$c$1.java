package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ah$c$1
  implements DialogInterface.OnCancelListener
{
  ah$c$1(ah.d paramd, ah.b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(6660);
    ab.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
    this.uVP.bmh();
    this.uVQ.remove(1254);
    AppMethodBeat.o(6660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah.c.1
 * JD-Core Version:    0.7.0.1
 */