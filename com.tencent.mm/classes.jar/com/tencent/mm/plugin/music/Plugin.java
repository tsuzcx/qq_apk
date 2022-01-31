package com.tencent.mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(104807);
    com.tencent.mm.plugin.music.model.b localb = new com.tencent.mm.plugin.music.model.b();
    AppMethodBeat.o(104807);
    return localb;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(104808);
    e locale = new e();
    AppMethodBeat.o(104808);
    return locale;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.Plugin
 * JD-Core Version:    0.7.0.1
 */