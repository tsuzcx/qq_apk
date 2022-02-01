package com.tencent.mm.plugin.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class Plugin
  implements com.tencent.mm.pluginsdk.c.d
{
  public Plugin()
  {
    AppMethodBeat.i(73741);
    Log.i("MicroMsg.Plugin.setting", "setting constructor " + System.currentTimeMillis());
    AppMethodBeat.o(73741);
  }
  
  public final n createApplication()
  {
    AppMethodBeat.i(73742);
    Log.i("MicroMsg.Plugin.setting", "setting createApplication " + System.currentTimeMillis());
    c localc = new c();
    AppMethodBeat.o(73742);
    return localc;
  }
  
  public final be createSubCore()
  {
    AppMethodBeat.i(73744);
    Log.i("MicroMsg.Plugin.setting", "setting createSubCore " + System.currentTimeMillis());
    d locald = new d();
    AppMethodBeat.o(73744);
    return locald;
  }
  
  public final com.tencent.mm.pluginsdk.c.c getContactWidgetFactory()
  {
    AppMethodBeat.i(73743);
    Log.i("MicroMsg.Plugin.setting", "setting getContactWidgetFactory " + System.currentTimeMillis());
    AppMethodBeat.o(73743);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.Plugin
 * JD-Core Version:    0.7.0.1
 */