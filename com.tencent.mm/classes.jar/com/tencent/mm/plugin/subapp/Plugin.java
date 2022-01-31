package com.tencent.mm.plugin.subapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class Plugin
  implements c
{
  public Plugin()
  {
    AppMethodBeat.i(25153);
    ab.i("MicroMsg.Plugin.subapp", "subapp constructor " + System.currentTimeMillis());
    AppMethodBeat.o(25153);
  }
  
  public final o createApplication()
  {
    AppMethodBeat.i(25154);
    ab.i("MicroMsg.Plugin.subapp", "subapp createApplication " + System.currentTimeMillis());
    b localb = new b();
    AppMethodBeat.o(25154);
    return localb;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(25156);
    ab.i("MicroMsg.Plugin.subapp", "subapp createSubCore " + System.currentTimeMillis());
    a locala = new a();
    AppMethodBeat.o(25156);
    return locala;
  }
  
  public final com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    AppMethodBeat.i(25155);
    ab.i("MicroMsg.Plugin.subapp", "subapp getContactWidgetFactory " + System.currentTimeMillis());
    AppMethodBeat.o(25155);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.Plugin
 * JD-Core Version:    0.7.0.1
 */