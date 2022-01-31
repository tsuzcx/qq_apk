package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.s;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements DialogInterface.OnClickListener
{
  c$1(c paramc, s params, int paramInt, axb paramaxb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(8852);
    ab.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
    this.vol.a(this.voj, this.val$errCode, this.vok);
    AppMethodBeat.o(8852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.c.1
 * JD-Core Version:    0.7.0.1
 */