package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class q$b$4$1
  implements DialogInterface.OnClickListener
{
  q$b$4$1(q.b.4 param4, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(179997);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.GxT);
    paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
    paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
    d.b(this.GLN.val$context, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    AppMethodBeat.o(179997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.b.4.1
 * JD-Core Version:    0.7.0.1
 */