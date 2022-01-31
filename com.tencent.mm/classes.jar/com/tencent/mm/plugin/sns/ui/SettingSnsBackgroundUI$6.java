package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class SettingSnsBackgroundUI$6
  implements DialogInterface.OnClickListener
{
  SettingSnsBackgroundUI$6(SettingSnsBackgroundUI paramSettingSnsBackgroundUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.oTg.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI.6
 * JD-Core Version:    0.7.0.1
 */