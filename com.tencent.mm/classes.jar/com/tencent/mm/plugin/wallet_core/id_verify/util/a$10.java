package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class a$10
  implements DialogInterface.OnClickListener
{
  a$10(boolean paramBoolean, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(70185);
    ac.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
    paramDialogInterface.dismiss();
    if (this.Btx) {
      this.iuN.finish();
    }
    AppMethodBeat.o(70185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.10
 * JD-Core Version:    0.7.0.1
 */