package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.video.a.a;
import com.tencent.mm.sdk.platformtools.ae;

public class PluginVideo
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(176825);
    if (paramg.akL()) {
      com.tencent.mm.vfs.u.ap("video", "video", 19);
    }
    AppMethodBeat.o(176825);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(127139);
    ae.i("MicroMsg.PluginVideo", "plugin video execute");
    if (paramg.akL())
    {
      pin(new com.tencent.mm.model.u(o.class));
      pin(new com.tencent.mm.model.u(d.class));
      pin(new com.tencent.mm.model.u(n.class));
    }
    AppMethodBeat.o(127139);
  }
  
  public String name()
  {
    return "plugin-video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.video.PluginVideo
 * JD-Core Version:    0.7.0.1
 */