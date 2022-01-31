package com.tencent.mm.plugin.voip_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public o createApplication()
  {
    return null;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(135281);
    com.tencent.mm.plugin.voip_cs.b.c localc = new com.tencent.mm.plugin.voip_cs.b.c();
    AppMethodBeat.o(135281);
    return localc;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.Plugin
 * JD-Core Version:    0.7.0.1
 */