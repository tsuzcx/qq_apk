package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class ax$a$4$1
  implements DialogInterface.OnClickListener
{
  ax$a$4$1(ax.a.4 param4, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(180026);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.KhN);
    paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
    paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
    d.b(this.KCk.val$context, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    g.yxI.f(17509, new Object[] { Integer.valueOf(1), this.KhN });
    AppMethodBeat.o(180026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.a.4.1
 * JD-Core Version:    0.7.0.1
 */