package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class ShareImageRedirectUI$2
  implements DialogInterface.OnClickListener
{
  ShareImageRedirectUI$2(ShareImageRedirectUI paramShareImageRedirectUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.weF.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    this.weF.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImageRedirectUI.2
 * JD-Core Version:    0.7.0.1
 */