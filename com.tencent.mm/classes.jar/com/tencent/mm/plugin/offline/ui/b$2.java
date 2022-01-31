package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.wallet_core.ui.e;

final class b$2
  implements DialogInterface.OnClickListener
{
  b$2(String paramString, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.mMa);
    d.b(this.val$activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    e.Jc(3);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.b.2
 * JD-Core Version:    0.7.0.1
 */