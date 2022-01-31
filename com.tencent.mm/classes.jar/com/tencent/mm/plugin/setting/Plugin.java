package com.tencent.mm.plugin.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public Plugin()
  {
    AppMethodBeat.i(126820);
    ab.i("MicroMsg.Plugin.setting", "setting constructor " + System.currentTimeMillis());
    AppMethodBeat.o(126820);
  }
  
  public final o createApplication()
  {
    AppMethodBeat.i(126821);
    ab.i("MicroMsg.Plugin.setting", "setting createApplication " + System.currentTimeMillis());
    b localb = new b();
    AppMethodBeat.o(126821);
    return localb;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(126823);
    ab.i("MicroMsg.Plugin.setting", "setting createSubCore " + System.currentTimeMillis());
    c localc = new c();
    AppMethodBeat.o(126823);
    return localc;
  }
  
  public final com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    AppMethodBeat.i(126822);
    ab.i("MicroMsg.Plugin.setting", "setting getContactWidgetFactory " + System.currentTimeMillis());
    AppMethodBeat.o(126822);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.Plugin
 * JD-Core Version:    0.7.0.1
 */