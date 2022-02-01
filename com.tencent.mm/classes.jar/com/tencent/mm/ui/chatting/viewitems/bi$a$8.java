package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

final class bi$a$8
  implements DialogInterface.OnClickListener
{
  bi$a$8(bi.a parama, String paramString, a parama1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(37392);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.WOl);
    paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    c.b(this.QWD.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    h.IzE.a(17509, new Object[] { Integer.valueOf(1), this.WOl });
    AppMethodBeat.o(37392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bi.a.8
 * JD-Core Version:    0.7.0.1
 */