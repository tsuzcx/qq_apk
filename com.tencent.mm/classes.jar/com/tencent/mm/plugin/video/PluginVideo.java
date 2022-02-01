package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.video.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ab;

public class PluginVideo
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(176825);
    if (paramg.aIE()) {
      ab.aE("video", "video", 17);
    }
    AppMethodBeat.o(176825);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(127139);
    Log.i("MicroMsg.PluginVideo", "plugin video execute");
    if (paramg.aIE())
    {
      pin(new y(s.class));
      pin(new y(e.class));
      pin(new y(r.class));
    }
    AppMethodBeat.o(127139);
  }
  
  public String name()
  {
    return "plugin-video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.video.PluginVideo
 * JD-Core Version:    0.7.0.1
 */