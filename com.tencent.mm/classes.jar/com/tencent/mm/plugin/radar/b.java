package com.tencent.mm.plugin.radar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/RadarApplication;", "Lcom/tencent/mm/pluginsdk/IPluginApplication;", "()V", "regitMMModelCallback", "", "callback", "Lcom/tencent/mm/pluginsdk/IMMModelCallback;", "regitMMUICallback", "Lcom/tencent/mm/pluginsdk/IMMUICallback;", "Companion", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements n
{
  public static final a Nrn;
  private static m pFn;
  private static l pFo;
  
  static
  {
    AppMethodBeat.i(138495);
    Nrn = new a((byte)0);
    AppMethodBeat.o(138495);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(138494);
    s.u(paraml, "callback");
    pFo = paraml;
    AppMethodBeat.o(138494);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(138493);
    s.u(paramm, "callback");
    pFn = paramm;
    AppMethodBeat.o(138493);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/RadarApplication$Companion;", "", "()V", "modelCallback", "Lcom/tencent/mm/pluginsdk/IMMModelCallback;", "getModelCallback", "()Lcom/tencent/mm/pluginsdk/IMMModelCallback;", "setModelCallback", "(Lcom/tencent/mm/pluginsdk/IMMModelCallback;)V", "uiCallback", "Lcom/tencent/mm/pluginsdk/IMMUICallback;", "getUiCallback", "()Lcom/tencent/mm/pluginsdk/IMMUICallback;", "setUiCallback", "(Lcom/tencent/mm/pluginsdk/IMMUICallback;)V", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b
 * JD-Core Version:    0.7.0.1
 */