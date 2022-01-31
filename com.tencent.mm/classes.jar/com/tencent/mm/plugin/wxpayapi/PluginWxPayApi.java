package com.tencent.mm.plugin.wxpayapi;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.pluginsdk.wallet.b;

public class PluginWxPayApi
  extends f
  implements com.tencent.mm.plugin.wxpayapi.a.a
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    paramg.Ex();
  }
  
  public void dependency() {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex()) {
      com.tencent.mm.kernel.g.a(b.class, new com.tencent.mm.plugin.v.a());
    }
  }
  
  public void installed()
  {
    alias(PluginWxPayApi.class);
  }
  
  public String name()
  {
    return "plugin-wxpayapi";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayapi.PluginWxPayApi
 * JD-Core Version:    0.7.0.1
 */