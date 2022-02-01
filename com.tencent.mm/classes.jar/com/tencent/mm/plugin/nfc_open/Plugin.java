package com.tencent.mm.plugin.nfc_open;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements d
{
  public m createApplication()
  {
    return null;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(26679);
    a locala = new a();
    AppMethodBeat.o(26679);
    return locala;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.Plugin
 * JD-Core Version:    0.7.0.1
 */