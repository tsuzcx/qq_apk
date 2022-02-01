package com.tencent.mm.plugin.radar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/PluginRadar;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/radar/api/IPluginRadar;", "()V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "Companion", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginRadar
  extends f
  implements a
{
  public static final a Nqi;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(138492);
    Nqi = new a((byte)0);
    TAG = "MicroMsg.PluginRadar";
    AppMethodBeat.o(138492);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(138490);
    s.u(paramg, "profile");
    if (paramg.bbA())
    {
      Log.i(TAG, "PluginRadar configure");
      pin((com.tencent.mm.kernel.b.c)new y(c.class));
    }
    AppMethodBeat.o(138490);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(138491);
    s.u(paramg, "profile");
    b.bsa("radar");
    AppMethodBeat.o(138491);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/PluginRadar$Companion;", "", "()V", "TAG", "", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.PluginRadar
 * JD-Core Version:    0.7.0.1
 */