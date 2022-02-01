package com.tencent.mm.plugin.traceroute;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.traceroute.a.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements d
{
  public final n createApplication()
  {
    AppMethodBeat.i(29655);
    a locala = new a();
    AppMethodBeat.o(29655);
    return locala;
  }
  
  public final az createSubCore()
  {
    return null;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.Plugin
 * JD-Core Version:    0.7.0.1
 */