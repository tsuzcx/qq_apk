package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class RealnameDialogActivity$1
  implements DialogInterface.OnClickListener
{
  RealnameDialogActivity$1(RealnameDialogActivity paramRealnameDialogActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.qrz.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.RealnameDialogActivity.1
 * JD-Core Version:    0.7.0.1
 */