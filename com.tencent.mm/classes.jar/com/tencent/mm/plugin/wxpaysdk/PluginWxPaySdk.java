package com.tencent.mm.plugin.wxpaysdk;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.wxpaysdk.a.a;

public class PluginWxPaySdk
  extends f
  implements a
{
  public void configure(g paramg)
  {
    paramg.Ex();
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    paramg.Ex();
  }
  
  public void installed()
  {
    alias(PluginWxPaySdk.class);
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