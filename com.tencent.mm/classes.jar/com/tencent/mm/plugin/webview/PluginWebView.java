package com.tencent.mm.plugin.webview;

import com.tencent.mm.plugin.webview.preload.b;

public class PluginWebView
  extends com.tencent.mm.kernel.b.f
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if ((paramg.Ex()) || (paramg.gn(":tools")) || (paramg.gn(":toolsmp"))) {
      com.tencent.mm.kernel.g.a(b.class, new com.tencent.mm.plugin.webview.ui.tools.preload.f());
    }
  }
  
  public String name()
  {
    return "plugin-webview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.PluginWebView
 * JD-Core Version:    0.7.0.1
 */