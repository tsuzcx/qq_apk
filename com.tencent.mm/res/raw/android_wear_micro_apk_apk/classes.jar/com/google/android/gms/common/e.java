package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.j;
import android.support.v4.app.s;
import com.google.android.gms.common.internal.d;

public final class e
  extends j
{
  private DialogInterface.OnCancelListener Hg = null;
  private Dialog aD = null;
  
  public static e b(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    e locale = new e();
    paramDialog = (Dialog)d.e(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    locale.aD = paramDialog;
    if (paramOnCancelListener != null) {
      locale.Hg = paramOnCancelListener;
    }
    return locale;
  }
  
  public final void a(s params, String paramString)
  {
    super.a(params, paramString);
  }
  
  public final Dialog m()
  {
    if (this.aD == null) {
      l();
    }
    return this.aD;
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.Hg != null) {
      this.Hg.onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.e
 * JD-Core Version:    0.7.0.1
 */