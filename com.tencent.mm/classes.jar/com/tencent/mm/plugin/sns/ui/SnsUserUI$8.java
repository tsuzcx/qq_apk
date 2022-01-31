package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class SnsUserUI$8
  implements DialogInterface.OnClickListener
{
  SnsUserUI$8(SnsUserUI paramSnsUserUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.pjB.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.8
 * JD-Core Version:    0.7.0.1
 */