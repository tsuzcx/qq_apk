package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.u;

public class PluginAppMsg
  extends f
  implements w
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(169778);
    if (paramg.akL())
    {
      u.ap("attachment", "attachment", 19);
      u.ap("Download", "Download", 23);
    }
    AppMethodBeat.o(169778);
  }
  
  public void execute(g paramg) {}
  
  public String name()
  {
    return "plugin-appmsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.PluginAppMsg
 * JD-Core Version:    0.7.0.1
 */