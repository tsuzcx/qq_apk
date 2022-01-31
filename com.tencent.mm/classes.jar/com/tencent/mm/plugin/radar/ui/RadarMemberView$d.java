package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
public final class RadarMemberView$d
  extends ak
{
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(102950);
    j.q(paramMessage, "msg");
    if (paramMessage.what == RadarMemberView.ceR())
    {
      paramMessage = this.pRw;
      this.pRw.getMember();
      RadarMemberView.a(paramMessage, this.pRw.getState());
      AppMethodBeat.o(102950);
      return;
    }
    if (paramMessage.what == RadarMemberView.ceS())
    {
      this.pRw.setVisibility(4);
      RadarMemberView.j(this.pRw);
      paramMessage = RadarMemberView.k(this.pRw);
      if (paramMessage != null) {
        paramMessage.setVisibility(0);
      }
      paramMessage = RadarMemberView.a(this.pRw);
      if (paramMessage != null)
      {
        paramMessage.b(this.pRw.getMember(), this.pRw.getState());
        AppMethodBeat.o(102950);
        return;
      }
    }
    AppMethodBeat.o(102950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.d
 * JD-Core Version:    0.7.0.1
 */