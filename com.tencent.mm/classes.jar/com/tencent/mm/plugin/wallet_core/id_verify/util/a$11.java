package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.i;

final class a$11
  implements DialogInterface.OnClickListener
{
  a$11(String paramString, Activity paramActivity, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(70186);
    Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.val$url);
    localIntent.putExtra("showShare", false);
    i.aS(this.hkm, localIntent);
    paramDialogInterface.dismiss();
    if (this.VCx) {
      this.hkm.finish();
    }
    AppMethodBeat.o(70186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.11
 * JD-Core Version:    0.7.0.1
 */