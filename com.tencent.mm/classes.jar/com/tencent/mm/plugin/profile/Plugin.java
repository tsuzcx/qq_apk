package com.tencent.mm.plugin.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ae;

public final class Plugin
  implements d
{
  public Plugin()
  {
    AppMethodBeat.i(26855);
    ae.i("MicroMsg.Plugin.profile", "profile constructor " + System.currentTimeMillis());
    AppMethodBeat.o(26855);
  }
  
  public final n createApplication()
  {
    AppMethodBeat.i(26856);
    ae.i("MicroMsg.Plugin.profile", "profile createApplication " + System.currentTimeMillis());
    b localb = new b();
    AppMethodBeat.o(26856);
    return localb;
  }
  
  public final az createSubCore()
  {
    AppMethodBeat.i(26858);
    ae.i("MicroMsg.Plugin.profile", "profile createSubCore " + System.currentTimeMillis());
    c localc = new c();
    AppMethodBeat.o(26858);
    return localc;
  }
  
  public final com.tencent.mm.pluginsdk.b.c getContactWidgetFactory()
  {
    AppMethodBeat.i(26857);
    ae.i("MicroMsg.Plugin.profile", "profile getContactWidgetFactory " + System.currentTimeMillis());
    AppMethodBeat.o(26857);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.Plugin
 * JD-Core Version:    0.7.0.1
 */