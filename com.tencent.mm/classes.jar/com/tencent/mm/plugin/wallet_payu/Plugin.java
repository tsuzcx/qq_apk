package com.tencent.mm.plugin.wallet_payu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements com.tencent.mm.pluginsdk.b.d
{
  public n createApplication()
  {
    return null;
  }
  
  public az createSubCore()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.Plugin
 * JD-Core Version:    0.7.0.1
 */