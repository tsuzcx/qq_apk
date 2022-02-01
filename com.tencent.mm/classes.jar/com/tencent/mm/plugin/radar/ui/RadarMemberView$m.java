package com.tencent.mm.plugin.radar.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class RadarMemberView$m
  implements DialogInterface.OnClickListener
{
  RadarMemberView$m(RadarMemberView paramRadarMemberView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(138608);
    if (RadarMemberView.g(this.xzN) != null)
    {
      paramDialogInterface = RadarMemberView.g(this.xzN);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      RadarMemberView.h(this.xzN);
    }
    RadarMemberView.i(this.xzN);
    AppMethodBeat.o(138608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.m
 * JD-Core Version:    0.7.0.1
 */