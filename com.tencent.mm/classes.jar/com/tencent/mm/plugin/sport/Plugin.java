package com.tencent.mm.plugin.sport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.sport.model.o;
import com.tencent.mm.plugin.sport.ui.a.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements com.tencent.mm.pluginsdk.c.d
{
  public n createApplication()
  {
    AppMethodBeat.i(28808);
    d locald = new d();
    AppMethodBeat.o(28808);
    return locald;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(28810);
    o localo = new o();
    AppMethodBeat.o(28810);
    return localo;
  }
  
  public c getContactWidgetFactory()
  {
    AppMethodBeat.i(28809);
    b localb = new b();
    AppMethodBeat.o(28809);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.Plugin
 * JD-Core Version:    0.7.0.1
 */