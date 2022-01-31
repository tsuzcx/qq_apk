package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class OpenFileChooserUI$3
  implements DialogInterface.OnClickListener
{
  OpenFileChooserUI$3(OpenFileChooserUI paramOpenFileChooserUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.rlE.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.3
 * JD-Core Version:    0.7.0.1
 */