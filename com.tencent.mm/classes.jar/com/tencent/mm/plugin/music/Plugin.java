package com.tencent.mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(62933);
    com.tencent.mm.plugin.music.model.c localc = new com.tencent.mm.plugin.music.model.c();
    AppMethodBeat.o(62933);
    return localc;
  }
  
  public ax createSubCore()
  {
    AppMethodBeat.i(62934);
    f localf = new f();
    AppMethodBeat.o(62934);
    return localf;
  }
  
  public com.tencent.mm.pluginsdk.b.c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.Plugin
 * JD-Core Version:    0.7.0.1
 */