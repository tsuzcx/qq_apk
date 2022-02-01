package com.tencent.mm.plugin.sport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.sport.ui.a.b;
import com.tencent.mm.pluginsdk.b.d;

public class Plugin
  implements d
{
  public com.tencent.mm.pluginsdk.m createApplication()
  {
    AppMethodBeat.i(28808);
    c localc = new c();
    AppMethodBeat.o(28808);
    return localc;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(28810);
    com.tencent.mm.plugin.sport.model.m localm = new com.tencent.mm.plugin.sport.model.m();
    AppMethodBeat.o(28810);
    return localm;
  }
  
  public com.tencent.mm.pluginsdk.b.c getContactWidgetFactory()
  {
    AppMethodBeat.i(28809);
    b localb = new b();
    AppMethodBeat.o(28809);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.Plugin
 * JD-Core Version:    0.7.0.1
 */