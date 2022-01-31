package com.tencent.mm.plugin.sport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;

public class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public com.tencent.mm.pluginsdk.o createApplication()
  {
    AppMethodBeat.i(25133);
    c localc = new c();
    AppMethodBeat.o(25133);
    return localc;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(25135);
    com.tencent.mm.plugin.sport.model.o localo = new com.tencent.mm.plugin.sport.model.o();
    AppMethodBeat.o(25135);
    return localo;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    AppMethodBeat.i(25134);
    com.tencent.mm.plugin.sport.ui.a.b localb = new com.tencent.mm.plugin.sport.ui.a.b();
    AppMethodBeat.o(25134);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.Plugin
 * JD-Core Version:    0.7.0.1
 */