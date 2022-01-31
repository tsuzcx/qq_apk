package com.tencent.mm.plugin.wear;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements c
{
  public final o createApplication()
  {
    return null;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(26264);
    a locala = new a();
    AppMethodBeat.o(26264);
    return locala;
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.Plugin
 * JD-Core Version:    0.7.0.1
 */