package com.tencent.mm.plugin.traceroute;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.traceroute.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements c
{
  public final o createApplication()
  {
    AppMethodBeat.i(25971);
    a locala = new a();
    AppMethodBeat.o(25971);
    return locala;
  }
  
  public final at createSubCore()
  {
    return null;
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.Plugin
 * JD-Core Version:    0.7.0.1
 */