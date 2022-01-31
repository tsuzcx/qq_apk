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
    AppMethodBeat.i(56664);
    paramg.SD();
    AppMethodBeat.o(56664);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(56665);
    paramg.SD();
    AppMethodBeat.o(56665);
  }
  
  public void installed()
  {
    AppMethodBeat.i(56663);
    alias(PluginWxPaySdk.class);
    AppMethodBeat.o(56663);
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