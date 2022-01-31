package com.tencent.mm.plugin.webwx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.webwx.a.g;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements c
{
  public final o createApplication()
  {
    AppMethodBeat.i(26478);
    a locala = new a();
    AppMethodBeat.o(26478);
    return locala;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(26479);
    g localg = new g();
    AppMethodBeat.o(26479);
    return localg;
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.Plugin
 * JD-Core Version:    0.7.0.1
 */