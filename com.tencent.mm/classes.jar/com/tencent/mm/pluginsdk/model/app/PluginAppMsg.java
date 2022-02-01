package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.an;
import com.tencent.mm.vfs.af;

public class PluginAppMsg
  extends f
  implements aa
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(169778);
    if (paramg.bbA())
    {
      af.aR("attachment", "attachment", 17);
      af.aR("Download", "Download", 21);
    }
    AppMethodBeat.o(169778);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(244936);
    if (paramg.bbA()) {
      h.b(an.class, new m());
    }
    AppMethodBeat.o(244936);
  }
  
  public String name()
  {
    return "plugin-appmsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.PluginAppMsg
 * JD-Core Version:    0.7.0.1
 */