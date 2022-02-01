package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.record.b.t;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public final class Plugin
  implements d
{
  public final m createApplication()
  {
    AppMethodBeat.i(27798);
    a locala = new a();
    AppMethodBeat.o(27798);
    return locala;
  }
  
  public final aw createSubCore()
  {
    AppMethodBeat.i(27799);
    t localt = new t();
    AppMethodBeat.o(27799);
    return localt;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.Plugin
 * JD-Core Version:    0.7.0.1
 */