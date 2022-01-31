package com.tencent.mm.plugin.qmessage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  private b jRP;
  
  public Plugin()
  {
    AppMethodBeat.i(24064);
    this.jRP = new Plugin.1(this);
    AppMethodBeat.o(24064);
  }
  
  public o createApplication()
  {
    AppMethodBeat.i(24065);
    a locala = new a();
    AppMethodBeat.o(24065);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(24066);
    g localg = new g();
    AppMethodBeat.o(24066);
    return localg;
  }
  
  public b getContactWidgetFactory()
  {
    return this.jRP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.Plugin
 * JD-Core Version:    0.7.0.1
 */