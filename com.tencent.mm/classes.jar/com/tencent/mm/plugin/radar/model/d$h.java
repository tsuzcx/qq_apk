package com.tencent.mm.plugin.radar.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$h
  extends MMHandler
{
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(138563);
    kotlin.g.b.s.u(paramMessage, "msg");
    if (paramMessage.what == d.gFc()) {
      h.aZW().a((p)new a(), 0);
    }
    AppMethodBeat.o(138563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.model.d.h
 * JD-Core Version:    0.7.0.1
 */