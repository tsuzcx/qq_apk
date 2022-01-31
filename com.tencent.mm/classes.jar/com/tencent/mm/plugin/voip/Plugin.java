package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public final o createApplication()
  {
    AppMethodBeat.i(4305);
    c localc = new c();
    AppMethodBeat.o(4305);
    return localc;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(4306);
    b localb = new b();
    AppMethodBeat.o(4306);
    return localb;
  }
  
  public final com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.Plugin
 * JD-Core Version:    0.7.0.1
 */