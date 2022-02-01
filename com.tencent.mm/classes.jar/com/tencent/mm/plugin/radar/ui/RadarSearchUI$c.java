package com.tencent.mm.plugin.radar.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class RadarSearchUI$c
  implements DialogInterface.OnClickListener
{
  RadarSearchUI$c(RadarSearchUI paramRadarSearchUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(138636);
    RadarSearchUI.a(this.xzV);
    this.xzV.finish();
    AppMethodBeat.o(138636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSearchUI.c
 * JD-Core Version:    0.7.0.1
 */