package com.tencent.mm.plugin.radar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/Plugin;", "Lcom/tencent/mm/pluginsdk/deprecated/IPlugin;", "()V", "createApplication", "Lcom/tencent/mm/pluginsdk/IPluginApplication;", "createSubCore", "Lcom/tencent/mm/model/ISubCore;", "getContactWidgetFactory", "Lcom/tencent/mm/pluginsdk/deprecated/IContactWidgetFactory;", "plugin-radar_release"})
public final class Plugin
  implements d
{
  public final n createApplication()
  {
    AppMethodBeat.i(138488);
    n localn = (n)new a();
    AppMethodBeat.o(138488);
    return localn;
  }
  
  public final az createSubCore()
  {
    AppMethodBeat.i(138489);
    az localaz = (az)new b();
    AppMethodBeat.o(138489);
    return localaz;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.Plugin
 * JD-Core Version:    0.7.0.1
 */