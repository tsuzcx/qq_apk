package com.tencent.mm.plugin.wxpaysdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.wxpaysdk.api.a;

public class PluginWxPaySdk
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(91307);
    paramg.agu();
    AppMethodBeat.o(91307);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(91308);
    paramg.agu();
    AppMethodBeat.o(91308);
  }
  
  public void installed()
  {
    AppMethodBeat.i(91306);
    alias(PluginWxPaySdk.class);
    AppMethodBeat.o(91306);
  }
  
  public String name()
  {
    return "plugin-wxpaysdk";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk
 * JD-Core Version:    0.7.0.1
 */