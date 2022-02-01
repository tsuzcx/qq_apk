package com.tencent.mm.plugin.wenote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public final class Plugin
  implements d
{
  public final m createApplication()
  {
    AppMethodBeat.i(30256);
    a locala = new a();
    AppMethodBeat.o(30256);
    return locala;
  }
  
  public final aw createSubCore()
  {
    AppMethodBeat.i(30257);
    com.tencent.mm.plugin.wenote.model.c localc = new com.tencent.mm.plugin.wenote.model.c();
    AppMethodBeat.o(30257);
    return localc;
  }
  
  public final com.tencent.mm.pluginsdk.b.c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.Plugin
 * JD-Core Version:    0.7.0.1
 */