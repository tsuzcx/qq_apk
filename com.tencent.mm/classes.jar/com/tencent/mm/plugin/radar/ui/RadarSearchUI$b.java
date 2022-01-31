package com.tencent.mm.plugin.radar.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class RadarSearchUI$b
  implements DialogInterface.OnClickListener
{
  RadarSearchUI$b(RadarSearchUI paramRadarSearchUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.nmp.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    RadarSearchUI.a(this.nmp);
    this.nmp.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSearchUI.b
 * JD-Core Version:    0.7.0.1
 */