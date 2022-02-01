package com.tencent.mm.plugin.radar.b;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
public final class e$g
  extends ao
{
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(138563);
    k.h(paramMessage, "msg");
    if (paramMessage.what == e.dsK()) {
      g.agi().b((n)new b());
    }
    AppMethodBeat.o(138563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.g
 * JD-Core Version:    0.7.0.1
 */