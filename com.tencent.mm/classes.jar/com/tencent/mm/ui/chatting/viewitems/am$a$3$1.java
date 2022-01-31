package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class am$a$3$1
  implements DialogInterface.OnClickListener
{
  am$a$3$1(am.a.3 param3, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33287);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.zXb);
    paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
    paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
    d.b(this.zXc.val$context, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    h.qsU.e(17509, new Object[] { Integer.valueOf(1), this.zXb });
    AppMethodBeat.o(33287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.a.3.1
 * JD-Core Version:    0.7.0.1
 */