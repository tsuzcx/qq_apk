package com.tencent.mm.plugin.readerapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements c
{
  private b jRP;
  
  public Plugin()
  {
    AppMethodBeat.i(76737);
    this.jRP = new Plugin.1(this);
    AppMethodBeat.o(76737);
  }
  
  public final o createApplication()
  {
    AppMethodBeat.i(76738);
    a locala = new a();
    AppMethodBeat.o(76738);
    return locala;
  }
  
  public final at createSubCore()
  {
    return null;
  }
  
  public final b getContactWidgetFactory()
  {
    return this.jRP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.Plugin
 * JD-Core Version:    0.7.0.1
 */