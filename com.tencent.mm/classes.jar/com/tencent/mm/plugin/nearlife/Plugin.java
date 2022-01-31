package com.tencent.mm.plugin.nearlife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.nearlife.a.a;
import com.tencent.mm.plugin.nearlife.b.d;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(22921);
    a locala = new a();
    AppMethodBeat.o(22921);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(22922);
    d locald = new d();
    AppMethodBeat.o(22922);
    return locald;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.Plugin
 * JD-Core Version:    0.7.0.1
 */