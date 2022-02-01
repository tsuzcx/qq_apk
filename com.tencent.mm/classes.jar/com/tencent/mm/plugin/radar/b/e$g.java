package com.tencent.mm.plugin.radar.b;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
public final class e$g
  extends MMHandler
{
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(138563);
    p.h(paramMessage, "msg");
    if (paramMessage.what == e.eHm()) {
      g.azz().b((q)new b());
    }
    AppMethodBeat.o(138563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.g
 * JD-Core Version:    0.7.0.1
 */