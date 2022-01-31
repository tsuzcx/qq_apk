package com.tencent.mm.plugin.radar.b;

import a.f.b.j;
import a.l;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
public final class e$g
  extends ak
{
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(102918);
    j.q(paramMessage, "msg");
    if (paramMessage.what == e.ceP()) {
      g.Rc().b((m)new b());
    }
    AppMethodBeat.o(102918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.g
 * JD-Core Version:    0.7.0.1
 */