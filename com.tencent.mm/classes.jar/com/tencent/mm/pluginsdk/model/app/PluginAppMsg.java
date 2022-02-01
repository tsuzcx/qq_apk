package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.o;

public class PluginAppMsg
  extends f
  implements w
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(169778);
    if (paramg.akw())
    {
      o.an("attachment", "attachment", 19);
      o.an("Download", "Download", 23);
    }
    AppMethodBeat.o(169778);
  }
  
  public void execute(g paramg) {}
  
  public String name()
  {
    return "plugin-appmsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.PluginAppMsg
 * JD-Core Version:    0.7.0.1
 */