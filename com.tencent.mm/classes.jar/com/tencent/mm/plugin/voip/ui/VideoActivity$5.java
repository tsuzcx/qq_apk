package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class VideoActivity$5
  implements DialogInterface.OnClickListener
{
  VideoActivity$5(VideoActivity paramVideoActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.pWM.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.5
 * JD-Core Version:    0.7.0.1
 */