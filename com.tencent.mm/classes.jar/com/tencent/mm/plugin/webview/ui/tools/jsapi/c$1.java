package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.model.p;
import com.tencent.mm.protocal.c.aqw;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements DialogInterface.OnClickListener
{
  c$1(c paramc, p paramp, int paramInt, aqw paramaqw) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
    this.rxs.a(this.rxq, this.bEg, this.rxr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.c.1
 * JD-Core Version:    0.7.0.1
 */