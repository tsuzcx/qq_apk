package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMAppMgr$13
  implements DialogInterface.OnClickListener
{
  MMAppMgr$13(CheckBox paramCheckBox, SharedPreferences paramSharedPreferences, Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(153819);
    if (this.zbN.isChecked())
    {
      SharedPreferences.Editor localEditor = this.uEp.edit();
      localEditor.putBoolean("gprs_alert", false);
      localEditor.commit();
    }
    com.tencent.mm.sdk.platformtools.g.ymM = false;
    paramDialogInterface.dismiss();
    MMAppMgr.hK(this.gjR);
    if (this.zbO != null) {
      this.zbO.onClick(paramDialogInterface, paramInt);
    }
    AppMethodBeat.o(153819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.13
 * JD-Core Version:    0.7.0.1
 */