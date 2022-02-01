package com.tencent.mm.plugin.wear;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.pluginsdk.b.c;
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
    AppMethodBeat.i(29949);
    a locala = new a();
    AppMethodBeat.o(29949);
    return locala;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.Plugin
 * JD-Core Version:    0.7.0.1
 */