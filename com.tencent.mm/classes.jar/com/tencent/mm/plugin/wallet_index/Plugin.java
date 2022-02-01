package com.tencent.mm.plugin.wallet_index;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.wallet_index.a.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements d
{
  public final n createApplication()
  {
    return null;
  }
  
  public final az createSubCore()
  {
    AppMethodBeat.i(71796);
    a locala = new a();
    AppMethodBeat.o(71796);
    return locala;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.Plugin
 * JD-Core Version:    0.7.0.1
 */