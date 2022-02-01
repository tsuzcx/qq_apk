package com.tencent.mm.plugin.radar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/PluginRadar;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/radar/api/IPluginRadar;", "()V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "Companion", "plugin-radar_release"})
public final class PluginRadar
  extends f
  implements a
{
  private static final String TAG = "MicroMsg.PluginRadar";
  public static final a uRA;
  
  static
  {
    AppMethodBeat.i(138492);
    uRA = new a((byte)0);
    TAG = "MicroMsg.PluginRadar";
    AppMethodBeat.o(138492);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(138490);
    k.h(paramg, "profile");
    if (paramg.agu())
    {
      ad.i(TAG, "PluginRadar configure");
      pin((com.tencent.mm.kernel.b.c)new t(b.class));
    }
    AppMethodBeat.o(138490);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(138491);
    k.h(paramg, "profile");
    com.tencent.mm.bs.c.aCW("radar");
    AppMethodBeat.o(138491);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/PluginRadar$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.PluginRadar
 * JD-Core Version:    0.7.0.1
 */