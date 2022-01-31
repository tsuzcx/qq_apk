package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.q;
import com.tencent.mm.ui.widget.MMWebView;

public class PluginWebView
  extends f
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5615);
    if ((paramg.SD()) || (paramg.mI(":tools")) || (paramg.mI(":toolsmp"))) {
      pin(new q(com.tencent.mm.plugin.webview.modeltools.g.class));
    }
    AppMethodBeat.o(5615);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5614);
    if ((!paramg.SD()) && (!paramg.mI(":tools"))) {
      paramg.mI(":toolsmp");
    }
    if (paramg.mI(":toolsmp"))
    {
      paramg = new PluginWebView.1(this);
      d.a(MMWebView.ADX, paramg);
    }
    AppMethodBeat.o(5614);
  }
  
  public String name()
  {
    return "plugin-webview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.PluginWebView
 * JD-Core Version:    0.7.0.1
 */