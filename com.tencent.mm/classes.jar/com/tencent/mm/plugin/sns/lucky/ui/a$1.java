package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements DialogInterface.OnCancelListener
{
  a$1(Dialog paramDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
    if ((this.oof != null) && (this.oof.isShowing())) {
      this.oof.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.a.1
 * JD-Core Version:    0.7.0.1
 */