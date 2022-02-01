package com.tencent.mm.plugin.remittance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public final class Plugin
  implements d
{
  public final m createApplication()
  {
    return null;
  }
  
  public final aw createSubCore()
  {
    AppMethodBeat.i(67332);
    com.tencent.mm.plugin.remittance.a.c localc = new com.tencent.mm.plugin.remittance.a.c();
    AppMethodBeat.o(67332);
    return localc;
  }
  
  public final com.tencent.mm.pluginsdk.b.c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.Plugin
 * JD-Core Version:    0.7.0.1
 */