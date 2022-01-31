package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class j$2
  implements DialogInterface.OnClickListener
{
  j$2(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.setClassName(j.a(this.vTn), "com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI");
    j.a(this.vTn).startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.2
 * JD-Core Version:    0.7.0.1
 */