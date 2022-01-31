package com.tencent.mm.plugin.pwdgroup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public final o createApplication()
  {
    AppMethodBeat.i(23972);
    a locala = new a();
    AppMethodBeat.o(23972);
    return locala;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(23973);
    c localc = new c();
    AppMethodBeat.o(23973);
    return localc;
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.Plugin
 * JD-Core Version:    0.7.0.1
 */