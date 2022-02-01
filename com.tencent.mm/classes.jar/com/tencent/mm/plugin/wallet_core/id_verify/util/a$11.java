package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.ui.e;

final class a$11
  implements DialogInterface.OnClickListener
{
  a$11(String paramString, Activity paramActivity, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(70186);
    ac.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.val$url);
    localIntent.putExtra("showShare", false);
    e.al(this.iuN, localIntent);
    paramDialogInterface.dismiss();
    if (this.Btx) {
      this.iuN.finish();
    }
    AppMethodBeat.o(70186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.11
 * JD-Core Version:    0.7.0.1
 */