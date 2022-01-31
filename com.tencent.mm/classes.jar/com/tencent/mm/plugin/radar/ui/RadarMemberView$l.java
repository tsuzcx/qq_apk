package com.tencent.mm.plugin.radar.ui;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class RadarMemberView$l
  implements DialogInterface.OnClickListener
{
  RadarMemberView$l(RadarMemberView paramRadarMemberView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(102962);
    paramDialogInterface = RadarMemberView.g(this.pRw);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    RadarMemberView.h(this.pRw);
    AppMethodBeat.o(102962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.l
 * JD-Core Version:    0.7.0.1
 */