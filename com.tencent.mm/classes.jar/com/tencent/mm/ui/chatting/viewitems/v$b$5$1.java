package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class v$b$5$1
  implements DialogInterface.OnClickListener
{
  v$b$5$1(v.b.5 param5, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(180011);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.KhN);
    paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
    paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
    d.b(this.KyS.val$context, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    AppMethodBeat.o(180011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.b.5.1
 * JD-Core Version:    0.7.0.1
 */