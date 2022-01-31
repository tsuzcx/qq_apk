package com.tencent.mm.plugin.radar.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.widget.a.c;

final class RadarMemberView$l
  implements DialogInterface.OnClickListener
{
  RadarMemberView$l(RadarMemberView paramRadarMemberView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = RadarMemberView.g(this.nmh);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    RadarMemberView.h(this.nmh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.l
 * JD-Core Version:    0.7.0.1
 */