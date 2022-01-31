package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements DialogInterface.OnCancelListener
{
  a$1(Dialog paramDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(35900);
    ab.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
    if ((this.rcw != null) && (this.rcw.isShowing())) {
      this.rcw.dismiss();
    }
    AppMethodBeat.o(35900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.a.1
 * JD-Core Version:    0.7.0.1
 */