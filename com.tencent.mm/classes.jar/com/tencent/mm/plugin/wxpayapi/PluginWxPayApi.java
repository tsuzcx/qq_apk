package com.tencent.mm.plugin.wxpayapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.pluginsdk.wallet.c;

public class PluginWxPayApi
  extends f
  implements com.tencent.mm.plugin.wxpayapi.a.a
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(55860);
    paramg.SD();
    AppMethodBeat.o(55860);
  }
  
  public void dependency() {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(55861);
    if (paramg.SD()) {
      com.tencent.mm.kernel.g.b(c.class, new com.tencent.mm.plugin.o.a());
    }
    AppMethodBeat.o(55861);
  }
  
  public void installed()
  {
    AppMethodBeat.i(55859);
    alias(PluginWxPayApi.class);
    AppMethodBeat.o(55859);
  }
  
  public String name()
  {
    return "plugin-wxpayapi";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayapi.PluginWxPayApi
 * JD-Core Version:    0.7.0.1
 */