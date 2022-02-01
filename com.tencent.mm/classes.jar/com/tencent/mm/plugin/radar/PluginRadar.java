package com.tencent.mm.plugin.radar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/PluginRadar;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/radar/api/IPluginRadar;", "()V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "Companion", "plugin-radar_release"})
public final class PluginRadar
  extends f
  implements a
{
  public static final a Hst;
  private static final String TAG = "MicroMsg.PluginRadar";
  
  static
  {
    AppMethodBeat.i(138492);
    Hst = new a((byte)0);
    TAG = "MicroMsg.PluginRadar";
    AppMethodBeat.o(138492);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(138490);
    p.k(paramg, "profile");
    if (paramg.aIE())
    {
      Log.i(TAG, "PluginRadar configure");
      pin((com.tencent.mm.kernel.b.c)new y(c.class));
    }
    AppMethodBeat.o(138490);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(138491);
    p.k(paramg, "profile");
    b.bsj("radar");
    AppMethodBeat.o(138491);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/PluginRadar$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.PluginRadar
 * JD-Core Version:    0.7.0.1
 */