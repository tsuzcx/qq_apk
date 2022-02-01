package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class e$d$2
  implements DialogInterface.OnClickListener
{
  e$d$2(e.d paramd, String paramString, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(36772);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.aewM);
    paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    c.b(this.XSz.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    h.OAn.b(17509, new Object[] { Integer.valueOf(1), this.aewM });
    AppMethodBeat.o(36772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.d.2
 * JD-Core Version:    0.7.0.1
 */