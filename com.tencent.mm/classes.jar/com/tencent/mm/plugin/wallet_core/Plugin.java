package com.tencent.mm.plugin.wallet_core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wallet_core.a.a;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements d
{
  public m createApplication()
  {
    AppMethodBeat.i(69861);
    a locala = new a();
    AppMethodBeat.o(69861);
    return locala;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(69862);
    s locals = new s();
    AppMethodBeat.o(69862);
    return locals;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.Plugin
 * JD-Core Version:    0.7.0.1
 */