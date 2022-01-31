package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
public final class RadarStateView$d
  extends ak
{
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(103041);
    j.q(paramMessage, "msg");
    RadarStateView.a(this.pSd);
    this.pSd.ceX();
    AppMethodBeat.o(103041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView.d
 * JD-Core Version:    0.7.0.1
 */