package com.tencent.mm.plugin.radar.b;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
public final class e$g
  extends ap
{
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(138563);
    k.h(paramMessage, "msg");
    if (paramMessage.what == e.dfd()) {
      g.aeS().b((n)new b());
    }
    AppMethodBeat.o(138563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.g
 * JD-Core Version:    0.7.0.1
 */