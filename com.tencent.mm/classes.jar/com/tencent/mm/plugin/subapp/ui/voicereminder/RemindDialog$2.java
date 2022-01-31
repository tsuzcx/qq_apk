package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.plugin.subapp.c.d;
import com.tencent.mm.pluginsdk.m;

final class RemindDialog$2
  implements DialogInterface.OnClickListener
{
  RemindDialog$2(RemindDialog paramRemindDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = d.bLW();
    if (paramDialogInterface != null) {
      paramDialogInterface.iE(RemindDialog.c(this.pyj));
    }
    if (s.hI(au.getNotification().wo()))
    {
      this.pyj.finish();
      return;
    }
    b.eUR.e(new Intent().putExtra("Chat_User", RemindDialog.c(this.pyj)), this.pyj);
    this.pyj.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.2
 * JD-Core Version:    0.7.0.1
 */