package com.tencent.mm.plugin.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.search.a.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public final class Plugin
  implements d
{
  public final m createApplication()
  {
    AppMethodBeat.i(28065);
    a locala = new a();
    AppMethodBeat.o(28065);
    return locala;
  }
  
  public final aw createSubCore()
  {
    AppMethodBeat.i(28066);
    b localb = new b();
    AppMethodBeat.o(28066);
    return localb;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.search.Plugin
 * JD-Core Version:    0.7.0.1
 */