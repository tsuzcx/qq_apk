package com.tencent.mm.plugin.voiceprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.voiceprint.a.a;
import com.tencent.mm.plugin.voiceprint.model.k;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements d
{
  public m createApplication()
  {
    AppMethodBeat.i(29754);
    a locala = new a();
    AppMethodBeat.o(29754);
    return locala;
  }
  
  public aw createSubCore()
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