package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements c
{
  private a pIo;
  
  public Plugin()
  {
    AppMethodBeat.i(67898);
    this.pIo = new a();
    AppMethodBeat.o(67898);
  }
  
  public final o createApplication()
  {
    AppMethodBeat.i(67899);
    com.tencent.mm.plugin.qqmail.a.a locala = new com.tencent.mm.plugin.qqmail.a.a();
    AppMethodBeat.o(67899);
    return locala;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(67900);
    ac localac = new ac();
    AppMethodBeat.o(67900);
    return localac;
  }
  
  public final b getContactWidgetFactory()
  {
    return this.pIo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.Plugin
 * JD-Core Version:    0.7.0.1
 */