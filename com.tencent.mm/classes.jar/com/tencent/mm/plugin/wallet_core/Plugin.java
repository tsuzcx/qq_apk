package com.tencent.mm.plugin.wallet_core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.wallet_core.a.a;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(69861);
    a locala = new a();
    AppMethodBeat.o(69861);
    return locala;
  }
  
  public az createSubCore()
  {
    AppMethodBeat.i(69862);
    t localt = new t();
    AppMethodBeat.o(69862);
    return localt;
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