package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.k;
import android.support.v4.app.t;
import com.google.android.gms.common.internal.d;

public final class e
  extends k
{
  private DialogInterface.OnCancelListener IV = null;
  private Dialog cm = null;
  
  public static e b(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    e locale = new e();
    paramDialog = (Dialog)d.g(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    locale.cm = paramDialog;
    if (paramOnCancelListener != null) {
      locale.IV = paramOnCancelListener;
    }
    return locale;
  }
  
  public final Dialog G()
  {
    if (this.cm == null) {
      F();
    }
    return this.cm;
  }
  
  public final void a(t paramt, String paramString)
  {
    super.a(paramt, paramString);
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.IV != null) {
      this.IV.onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.e
 * JD-Core Version:    0.7.0.1
 */