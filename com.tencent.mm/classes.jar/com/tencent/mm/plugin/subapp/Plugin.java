package com.tencent.mm.plugin.subapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ac;

public final class Plugin
  implements d
{
  public Plugin()
  {
    AppMethodBeat.i(28828);
    ac.i("MicroMsg.Plugin.subapp", "subapp constructor " + System.currentTimeMillis());
    AppMethodBeat.o(28828);
  }
  
  public final m createApplication()
  {
    AppMethodBeat.i(28829);
    ac.i("MicroMsg.Plugin.subapp", "subapp createApplication " + System.currentTimeMillis());
    b localb = new b();
    AppMethodBeat.o(28829);
    return localb;
  }
  
  public final aw createSubCore()
  {
    AppMethodBeat.i(28831);
    ac.i("MicroMsg.Plugin.subapp", "subapp createSubCore " + System.currentTimeMillis());
    a locala = new a();
    AppMethodBeat.o(28831);
    return locala;
  }
  
  public final c getContactWidgetFactory()
  {
    AppMethodBeat.i(28830);
    ac.i("MicroMsg.Plugin.subapp", "subapp getContactWidgetFactory " + System.currentTimeMillis());
    AppMethodBeat.o(28830);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.Plugin
 * JD-Core Version:    0.7.0.1
 */