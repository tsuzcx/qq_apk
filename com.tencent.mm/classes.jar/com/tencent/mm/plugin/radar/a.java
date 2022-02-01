package com.tencent.mm.plugin.radar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/RadarApplication;", "Lcom/tencent/mm/pluginsdk/IPluginApplication;", "()V", "regitMMModelCallback", "", "callback", "Lcom/tencent/mm/pluginsdk/IMMModelCallback;", "regitMMUICallback", "Lcom/tencent/mm/pluginsdk/IMMUICallback;", "Companion", "plugin-radar_release"})
public final class a
  implements n
{
  private static com.tencent.mm.pluginsdk.l iUA;
  private static m iUz;
  public static final a xxW;
  
  static
  {
    AppMethodBeat.i(138495);
    xxW = new a((byte)0);
    AppMethodBeat.o(138495);
  }
  
  public final void a(com.tencent.mm.pluginsdk.l paraml)
  {
    AppMethodBeat.i(138494);
    p.h(paraml, "callback");
    iUA = paraml;
    AppMethodBeat.o(138494);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(138493);
    p.h(paramm, "callback");
    iUz = paramm;
    AppMethodBeat.o(138493);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/RadarApplication$Companion;", "", "()V", "modelCallback", "Lcom/tencent/mm/pluginsdk/IMMModelCallback;", "getModelCallback", "()Lcom/tencent/mm/pluginsdk/IMMModelCallback;", "setModelCallback", "(Lcom/tencent/mm/pluginsdk/IMMModelCallback;)V", "uiCallback", "Lcom/tencent/mm/pluginsdk/IMMUICallback;", "getUiCallback", "()Lcom/tencent/mm/pluginsdk/IMMUICallback;", "setUiCallback", "(Lcom/tencent/mm/pluginsdk/IMMUICallback;)V", "plugin-radar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.a
 * JD-Core Version:    0.7.0.1
 */