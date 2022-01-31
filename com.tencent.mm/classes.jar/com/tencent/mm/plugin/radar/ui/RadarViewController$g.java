package com.tencent.mm.plugin.radar.ui;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
final class RadarViewController$g
  implements DialogInterface.OnClickListener
{
  RadarViewController$g(RadarViewController paramRadarViewController) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(103098);
    d.cc(this.pTd.getContext());
    AppMethodBeat.o(103098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.g
 * JD-Core Version:    0.7.0.1
 */