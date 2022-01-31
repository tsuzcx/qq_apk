package com.tencent.mm.plugin.video;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.video.a.a;
import com.tencent.mm.sdk.platformtools.y;

public class PluginVideo
  extends f
  implements a
{
  public void execute(g paramg)
  {
    y.i("MicroMsg.PluginVideo", "plugin video execute");
    if (paramg.Ex())
    {
      pin(new p(o.class));
      pin(new p(d.class));
      pin(new p(n.class));
    }
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