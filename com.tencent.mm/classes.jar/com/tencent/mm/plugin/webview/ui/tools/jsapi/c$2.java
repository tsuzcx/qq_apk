package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.s;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.sdk.platformtools.ab;

final class c$2
  implements DialogInterface.OnClickListener
{
  c$2(c paramc, s params, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(8853);
    ab.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
    this.voj.uVF.a(c.a.a.voo, "cancel", null, this.val$errCode, this.voj.dbM().xmu.csV);
    AppMethodBeat.o(8853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.c.2
 * JD-Core Version:    0.7.0.1
 */