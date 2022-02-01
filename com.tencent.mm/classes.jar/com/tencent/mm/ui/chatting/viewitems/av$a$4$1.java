package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class av$a$4$1
  implements DialogInterface.OnClickListener
{
  av$a$4$1(av.a.4 param4, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(180026);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.GxT);
    paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
    paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
    d.b(this.GPp.val$context, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    h.vKh.f(17509, new Object[] { Integer.valueOf(1), this.GxT });
    AppMethodBeat.o(180026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.av.a.4.1
 * JD-Core Version:    0.7.0.1
 */