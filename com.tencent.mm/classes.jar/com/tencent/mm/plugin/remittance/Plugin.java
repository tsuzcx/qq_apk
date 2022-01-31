package com.tencent.mm.plugin.remittance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public final o createApplication()
  {
    return null;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(44421);
    com.tencent.mm.plugin.remittance.a.c localc = new com.tencent.mm.plugin.remittance.a.c();
    AppMethodBeat.o(44421);
    return localc;
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.Plugin
 * JD-Core Version:    0.7.0.1
 */