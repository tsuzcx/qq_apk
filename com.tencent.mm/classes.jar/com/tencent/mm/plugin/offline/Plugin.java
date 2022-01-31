package com.tencent.mm.plugin.offline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    return null;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(43348);
    k localk = new k();
    AppMethodBeat.o(43348);
    return localk;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.Plugin
 * JD-Core Version:    0.7.0.1
 */