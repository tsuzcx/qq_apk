package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class a$4
  implements DialogInterface.OnCancelListener
{
  a$4(Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.qsF) {
      this.eRW.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.4
 * JD-Core Version:    0.7.0.1
 */