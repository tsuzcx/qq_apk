package com.tencent.mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(62933);
    f localf = new f();
    AppMethodBeat.o(62933);
    return localf;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(62934);
    o localo = new o();
    AppMethodBeat.o(62934);
    return localo;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.Plugin
 * JD-Core Version:    0.7.0.1
 */