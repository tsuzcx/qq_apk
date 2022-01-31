package com.tencent.mm.plugin.nfc_open;

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
    AppMethodBeat.i(23052);
    a locala = new a();
    AppMethodBeat.o(23052);
    return locala;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.Plugin
 * JD-Core Version:    0.7.0.1
 */