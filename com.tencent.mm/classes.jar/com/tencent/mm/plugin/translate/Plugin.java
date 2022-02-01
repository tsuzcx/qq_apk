package com.tencent.mm.plugin.translate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(29728);
    b localb = new b();
    AppMethodBeat.o(29728);
    return localb;
  }
  
  public ax createSubCore()
  {
    AppMethodBeat.i(29729);
    a locala = new a();
    AppMethodBeat.o(29729);
    return locala;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.Plugin
 * JD-Core Version:    0.7.0.1
 */