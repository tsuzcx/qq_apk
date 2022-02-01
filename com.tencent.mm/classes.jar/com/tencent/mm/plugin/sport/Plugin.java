package com.tencent.mm.plugin.sport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.plugin.sport.ui.a.b;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(28808);
    c localc = new c();
    AppMethodBeat.o(28808);
    return localc;
  }
  
  public bd createSubCore()
  {
    AppMethodBeat.i(28810);
    l locall = new l();
    AppMethodBeat.o(28810);
    return locall;
  }
  
  public com.tencent.mm.pluginsdk.b.c getContactWidgetFactory()
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