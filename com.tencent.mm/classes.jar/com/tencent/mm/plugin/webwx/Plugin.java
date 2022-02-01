package com.tencent.mm.plugin.webwx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.webwx.a.g;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public final class Plugin
  implements d
{
  public final m createApplication()
  {
    AppMethodBeat.i(30153);
    a locala = new a();
    AppMethodBeat.o(30153);
    return locala;
  }
  
  public final aw createSubCore()
  {
    AppMethodBeat.i(30154);
    g localg = new g();
    AppMethodBeat.o(30154);
    return localg;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.Plugin
 * JD-Core Version:    0.7.0.1
 */