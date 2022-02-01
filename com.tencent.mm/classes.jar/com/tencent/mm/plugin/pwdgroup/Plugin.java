package com.tencent.mm.plugin.pwdgroup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements d
{
  public final n createApplication()
  {
    AppMethodBeat.i(27611);
    a locala = new a();
    AppMethodBeat.o(27611);
    return locala;
  }
  
  public final az createSubCore()
  {
    AppMethodBeat.i(27612);
    c localc = new c();
    AppMethodBeat.o(27612);
    return localc;
  }
  
  public final com.tencent.mm.pluginsdk.b.c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.Plugin
 * JD-Core Version:    0.7.0.1
 */