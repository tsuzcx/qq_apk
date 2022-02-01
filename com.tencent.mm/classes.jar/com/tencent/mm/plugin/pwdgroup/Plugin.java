package com.tencent.mm.plugin.pwdgroup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.d;
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
  
  public final be createSubCore()
  {
    AppMethodBeat.i(27612);
    c localc = new c();
    AppMethodBeat.o(27612);
    return localc;
  }
  
  public final com.tencent.mm.pluginsdk.c.c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.Plugin
 * JD-Core Version:    0.7.0.1
 */