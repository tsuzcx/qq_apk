package com.tencent.mm.plugin.radar.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.brg;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class RadarMemberView$e
  implements View.OnClickListener
{
  RadarMemberView$e(RadarMemberView paramRadarMemberView, brg parambrg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(102951);
    if ((this.pRw.getState() == null) || (RadarMemberView.a(this.pRw) == null))
    {
      AppMethodBeat.o(102951);
      return;
    }
    paramView = RadarMemberView.a(this.pRw);
    if (paramView != null) {
      paramView.a(this.pRx, this.pRw.getState());
    }
    this.pRw.dismiss();
    AppMethodBeat.o(102951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.e
 * JD-Core Version:    0.7.0.1
 */