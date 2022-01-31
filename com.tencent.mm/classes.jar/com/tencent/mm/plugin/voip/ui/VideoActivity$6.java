package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoActivity$6
  implements DialogInterface.OnClickListener
{
  VideoActivity$6(VideoActivity paramVideoActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(140169);
    this.tCq.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(140169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.6
 * JD-Core Version:    0.7.0.1
 */