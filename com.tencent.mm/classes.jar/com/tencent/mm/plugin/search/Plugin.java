package com.tencent.mm.plugin.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements c
{
  public final o createApplication()
  {
    AppMethodBeat.i(24398);
    a locala = new a();
    AppMethodBeat.o(24398);
    return locala;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(24399);
    com.tencent.mm.plugin.search.a.b localb = new com.tencent.mm.plugin.search.a.b();
    AppMethodBeat.o(24399);
    return localb;
  }
  
  public final com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.search.Plugin
 * JD-Core Version:    0.7.0.1
 */