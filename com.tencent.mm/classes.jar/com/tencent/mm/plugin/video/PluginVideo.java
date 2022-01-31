package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.video.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginVideo
  extends f
  implements a
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(50969);
    ab.i("MicroMsg.PluginVideo", "plugin video execute");
    if (paramg.SD())
    {
      pin(new q(o.class));
      pin(new q(d.class));
      pin(new q(n.class));
    }
    AppMethodBeat.o(50969);
  }
  
  public String name()
  {
    return "plugin-video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.video.PluginVideo
 * JD-Core Version:    0.7.0.1
 */