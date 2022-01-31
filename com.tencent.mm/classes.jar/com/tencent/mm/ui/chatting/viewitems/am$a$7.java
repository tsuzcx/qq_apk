package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class am$a$7
  implements DialogInterface.OnClickListener
{
  am$a$7(am.a parama, String paramString, a parama1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33293);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.zXb);
    paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
    paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
    d.b(this.zRK.zJz.getContext(), "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    h.qsU.e(17509, new Object[] { Integer.valueOf(1), this.zXb });
    AppMethodBeat.o(33293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.a.7
 * JD-Core Version:    0.7.0.1
 */