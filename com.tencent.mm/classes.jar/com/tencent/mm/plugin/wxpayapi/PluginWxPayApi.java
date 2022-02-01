package com.tencent.mm.plugin.wxpayapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.wallet.b;

public class PluginWxPayApi
  extends f
  implements com.tencent.mm.plugin.wxpayapi.a.a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(106597);
    paramg.aIE();
    AppMethodBeat.o(106597);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(106598);
    if (paramg.aIE()) {
      h.b(b.class, new com.tencent.mm.plugin.x.a());
    }
    AppMethodBeat.o(106598);
  }
  
  public void installed()
  {
    AppMethodBeat.i(106596);
    alias(PluginWxPayApi.class);
    AppMethodBeat.o(106596);
  }
  
  public String name()
  {
    return "plugin-wxpayapi";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayapi.PluginWxPayApi
 * JD-Core Version:    0.7.0.1
 */