package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.subapp.c.d;

final class RemindDialog$3
  implements DialogInterface.OnClickListener
{
  RemindDialog$3(RemindDialog paramRemindDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = d.bLW();
    if (paramDialogInterface != null) {
      paramDialogInterface.iE(RemindDialog.c(this.pyj));
    }
    this.pyj.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.3
 * JD-Core Version:    0.7.0.1
 */