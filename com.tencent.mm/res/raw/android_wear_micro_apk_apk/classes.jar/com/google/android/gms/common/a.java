package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.d;

public final class a
  extends DialogFragment
{
  private DialogInterface.OnCancelListener IV = null;
  private Dialog cm = null;
  
  public static a a(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    a locala = new a();
    paramDialog = (Dialog)d.g(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    locala.cm = paramDialog;
    if (paramOnCancelListener != null) {
      locala.IV = paramOnCancelListener;
    }
    return locala;
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.IV != null) {
      this.IV.onCancel(paramDialogInterface);
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    if (this.cm == null) {
      setShowsDialog(false);
    }
    return this.cm;
  }
  
  public final void show(FragmentManager paramFragmentManager, String paramString)
  {
    super.show(paramFragmentManager, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.a
 * JD-Core Version:    0.7.0.1
 */