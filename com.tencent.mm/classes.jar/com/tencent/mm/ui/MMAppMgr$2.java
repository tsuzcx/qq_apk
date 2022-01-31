package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;

final class MMAppMgr$2
  implements DialogInterface.OnClickListener
{
  MMAppMgr$2(CheckBox paramCheckBox, SharedPreferences paramSharedPreferences, Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.uNS.isChecked())
    {
      SharedPreferences.Editor localEditor = this.qPi.edit();
      localEditor.putBoolean("gprs_alert", false);
      localEditor.commit();
    }
    com.tencent.mm.sdk.platformtools.e.uel = false;
    paramDialogInterface.dismiss();
    MMAppMgr.gr(this.eRW);
    if (this.uNT != null) {
      this.uNT.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.2
 * JD-Core Version:    0.7.0.1
 */