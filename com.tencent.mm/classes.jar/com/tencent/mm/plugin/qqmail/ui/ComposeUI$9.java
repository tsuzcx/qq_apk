package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class ComposeUI$9
  implements DialogInterface.OnClickListener
{
  ComposeUI$9(ComposeUI paramComposeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.ngJ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.9
 * JD-Core Version:    0.7.0.1
 */