package com.tencent.mm.plugin.radar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/RadarApplication;", "Lcom/tencent/mm/pluginsdk/IPluginApplication;", "()V", "regitMMModelCallback", "", "callback", "Lcom/tencent/mm/pluginsdk/IMMModelCallback;", "regitMMUICallback", "Lcom/tencent/mm/pluginsdk/IMMUICallback;", "Companion", "plugin-radar_release"})
public final class a
  implements m
{
  private static com.tencent.mm.pluginsdk.l iyx;
  private static com.tencent.mm.pluginsdk.k iyy;
  public static final a waq;
  
  static
  {
    AppMethodBeat.i(138495);
    waq = new a((byte)0);
    AppMethodBeat.o(138495);
  }
  
  public final void a(com.tencent.mm.pluginsdk.k paramk)
  {
    AppMethodBeat.i(138494);
    d.g.b.k.h(paramk, "callback");
    iyy = paramk;
    AppMethodBeat.o(138494);
  }
  
  public final void a(com.tencent.mm.pluginsdk.l paraml)
  {
    AppMethodBeat.i(138493);
    d.g.b.k.h(paraml, "callback");
    iyx = paraml;
    AppMethodBeat.o(138493);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/RadarApplication$Companion;", "", "()V", "modelCallback", "Lcom/tencent/mm/pluginsdk/IMMModelCallback;", "getModelCallback", "()Lcom/tencent/mm/pluginsdk/IMMModelCallback;", "setModelCallback", "(Lcom/tencent/mm/pluginsdk/IMMModelCallback;)V", "uiCallback", "Lcom/tencent/mm/pluginsdk/IMMUICallback;", "getUiCallback", "()Lcom/tencent/mm/pluginsdk/IMMUICallback;", "setUiCallback", "(Lcom/tencent/mm/pluginsdk/IMMUICallback;)V", "plugin-radar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.a
 * JD-Core Version:    0.7.0.1
 */