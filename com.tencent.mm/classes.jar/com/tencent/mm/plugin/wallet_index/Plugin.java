package com.tencent.mm.plugin.wallet_index;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.wallet_index.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements c
{
  public final o createApplication()
  {
    return null;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(48161);
    a locala = new a();
    AppMethodBeat.o(48161);
    return locala;
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.Plugin
 * JD-Core Version:    0.7.0.1
 */