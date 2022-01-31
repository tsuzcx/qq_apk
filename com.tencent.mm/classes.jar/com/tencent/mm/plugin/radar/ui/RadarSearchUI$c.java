package com.tencent.mm.plugin.radar.ui;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class RadarSearchUI$c
  implements DialogInterface.OnClickListener
{
  RadarSearchUI$c(RadarSearchUI paramRadarSearchUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(102990);
    RadarSearchUI.a(this.pRE);
    this.pRE.finish();
    AppMethodBeat.o(102990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSearchUI.c
 * JD-Core Version:    0.7.0.1
 */