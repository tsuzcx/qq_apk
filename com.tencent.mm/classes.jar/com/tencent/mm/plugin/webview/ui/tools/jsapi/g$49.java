package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;

final class g$49
  implements DialogInterface.OnClickListener
{
  g$49(g paramg, String paramString1, String paramString2, i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("transaction_id", this.rzS);
    paramDialogInterface.putExtra("receiver_name", this.rzT);
    d.b(g.i(this.rzi), "remittance", ".ui.RemittanceResendMsgUI", paramDialogInterface);
    g.a(this.rzi, this.rzk, "doResendRemittanceMsg:ok", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.49
 * JD-Core Version:    0.7.0.1
 */