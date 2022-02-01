package com.tencent.mm.plugin.radar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/Plugin;", "Lcom/tencent/mm/pluginsdk/deprecated/IPlugin;", "()V", "createApplication", "Lcom/tencent/mm/pluginsdk/IPluginApplication;", "createSubCore", "Lcom/tencent/mm/model/ISubCore;", "getContactWidgetFactory", "Lcom/tencent/mm/pluginsdk/deprecated/IContactWidgetFactory;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Plugin
  implements d
{
  public final n createApplication()
  {
    AppMethodBeat.i(138488);
    n localn = (n)new b();
    AppMethodBeat.o(138488);
    return localn;
  }
  
  public final be createSubCore()
  {
    AppMethodBeat.i(138489);
    be localbe = (be)new c();
    AppMethodBeat.o(138489);
    return localbe;
  }
  
  public final com.tencent.mm.pluginsdk.c.c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.Plugin
 * JD-Core Version:    0.7.0.1
 */