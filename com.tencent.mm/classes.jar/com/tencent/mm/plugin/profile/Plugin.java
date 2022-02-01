package com.tencent.mm.plugin.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class Plugin
  implements com.tencent.mm.pluginsdk.c.d
{
  public Plugin()
  {
    AppMethodBeat.i(26855);
    Log.i("MicroMsg.Plugin.profile", "profile constructor " + System.currentTimeMillis());
    AppMethodBeat.o(26855);
  }
  
  public final n createApplication()
  {
    AppMethodBeat.i(26856);
    Log.i("MicroMsg.Plugin.profile", "profile createApplication " + System.currentTimeMillis());
    b localb = new b();
    AppMethodBeat.o(26856);
    return localb;
  }
  
  public final be createSubCore()
  {
    AppMethodBeat.i(26858);
    Log.i("MicroMsg.Plugin.profile", "profile createSubCore " + System.currentTimeMillis());
    d locald = new d();
    AppMethodBeat.o(26858);
    return locald;
  }
  
  public final c getContactWidgetFactory()
  {
    AppMethodBeat.i(26857);
    Log.i("MicroMsg.Plugin.profile", "profile getContactWidgetFactory " + System.currentTimeMillis());
    AppMethodBeat.o(26857);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.Plugin
 * JD-Core Version:    0.7.0.1
 */