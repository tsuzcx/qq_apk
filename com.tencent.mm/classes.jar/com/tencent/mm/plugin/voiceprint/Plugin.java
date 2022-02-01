package com.tencent.mm.plugin.voiceprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.voiceprint.a.a;
import com.tencent.mm.plugin.voiceprint.model.k;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(29754);
    a locala = new a();
    AppMethodBeat.o(29754);
    return locala;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(29755);
    k localk = new k();
    AppMethodBeat.o(29755);
    return localk;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.Plugin
 * JD-Core Version:    0.7.0.1
 */