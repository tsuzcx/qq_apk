package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.wallet_core.ui.e;

final class b$2
  implements DialogInterface.OnClickListener
{
  b$2(String paramString, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43466);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.pmq);
    d.b(this.val$activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    e.RX(3);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(43466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.b.2
 * JD-Core Version:    0.7.0.1
 */