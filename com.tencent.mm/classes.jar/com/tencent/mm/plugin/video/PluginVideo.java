package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.t;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.plugin.video.a.a;
import com.tencent.mm.sdk.platformtools.ad;

public class PluginVideo
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(176825);
    if (paramg.agu()) {
      com.tencent.mm.vfs.o.i("video", "video", 19, false);
    }
    AppMethodBeat.o(176825);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(127139);
    ad.i("MicroMsg.PluginVideo", "plugin video execute");
    if (paramg.agu())
    {
      pin(new t(com.tencent.mm.modelvideo.o.class));
      pin(new t(d.class));
      pin(new t(n.class));
    }
    AppMethodBeat.o(127139);
  }
  
  public String name()
  {
    return "plugin-video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.video.PluginVideo
 * JD-Core Version:    0.7.0.1
 */