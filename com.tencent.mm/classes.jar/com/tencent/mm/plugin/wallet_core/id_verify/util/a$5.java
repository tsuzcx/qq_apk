package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class a$5
  implements DialogInterface.OnDismissListener
{
  a$5(Activity paramActivity) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.qsF) {
      this.eRW.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.5
 * JD-Core Version:    0.7.0.1
 */