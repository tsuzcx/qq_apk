package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class ab$b$6$1
  implements DialogInterface.OnClickListener
{
  ab$b$6$1(ab.b.6 param6, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(255096);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.aewM);
    paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    c.b(this.aeQZ.val$context, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    AppMethodBeat.o(255096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.b.6.1
 * JD-Core Version:    0.7.0.1
 */