package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements DialogInterface.OnClickListener
{
  a$3(Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46668);
    ab.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
    paramDialogInterface.dismiss();
    if (this.ueR) {
      this.gjR.finish();
    }
    AppMethodBeat.o(46668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.3
 * JD-Core Version:    0.7.0.1
 */