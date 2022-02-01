package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.m;

public final class Plugin
  implements com.tencent.mm.pluginsdk.b.d
{
  public final m createApplication()
  {
    AppMethodBeat.i(114797);
    d locald = new d();
    AppMethodBeat.o(114797);
    return locald;
  }
  
  public final aw createSubCore()
  {
    AppMethodBeat.i(114798);
    c localc = new c();
    AppMethodBeat.o(114798);
    return localc;
  }
  
  public final com.tencent.mm.pluginsdk.b.c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.Plugin
 * JD-Core Version:    0.7.0.1
 */