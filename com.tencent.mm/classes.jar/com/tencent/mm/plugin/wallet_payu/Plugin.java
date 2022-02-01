package com.tencent.mm.plugin.wallet_payu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements com.tencent.mm.pluginsdk.b.d
{
  public m createApplication()
  {
    return null;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(71960);
    com.tencent.mm.plugin.wallet_payu.a.d locald = new com.tencent.mm.plugin.wallet_payu.a.d();
    AppMethodBeat.o(71960);
    return locald;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.Plugin
 * JD-Core Version:    0.7.0.1
 */