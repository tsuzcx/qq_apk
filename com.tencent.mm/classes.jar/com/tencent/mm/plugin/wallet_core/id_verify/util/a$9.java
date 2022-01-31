package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.y;

final class a$9
  implements DialogInterface.OnClickListener
{
  a$9(String paramString, Activity paramActivity, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.val$url);
    localIntent.putExtra("showShare", false);
    d.b(this.eRW, "webview", ".ui.tools.WebViewUI", localIntent);
    paramDialogInterface.dismiss();
    if (this.qsF) {
      this.eRW.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.9
 * JD-Core Version:    0.7.0.1
 */