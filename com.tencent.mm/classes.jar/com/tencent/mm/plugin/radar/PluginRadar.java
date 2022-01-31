package com.tencent.mm.plugin.radar;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/PluginRadar;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/radar/api/IPluginRadar;", "()V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "Companion", "plugin-radar_release"})
public final class PluginRadar
  extends f
  implements a
{
  private static final String TAG = "MicroMsg.PluginRadar";
  public static final PluginRadar.a pPD;
  
  static
  {
    AppMethodBeat.i(102848);
    pPD = new PluginRadar.a((byte)0);
    TAG = "MicroMsg.PluginRadar";
    AppMethodBeat.o(102848);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(102846);
    j.q(paramg, "profile");
    if (paramg.SD())
    {
      ab.i(TAG, "PluginRadar configure");
      pin((com.tencent.mm.kernel.b.c)new q(b.class));
    }
    AppMethodBeat.o(102846);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(102847);
    j.q(paramg, "profile");
    com.tencent.mm.bq.c.anb("radar");
    AppMethodBeat.o(102847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.PluginRadar
 * JD-Core Version:    0.7.0.1
 */