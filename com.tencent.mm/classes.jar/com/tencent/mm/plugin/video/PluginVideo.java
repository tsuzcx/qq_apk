package com.tencent.mm.plugin.video;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dc;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import com.tencent.mm.vfs.af;

public class PluginVideo
  extends com.tencent.mm.kernel.b.f
  implements a
{
  IListener<dc> lsH;
  
  public PluginVideo()
  {
    AppMethodBeat.i(260809);
    this.lsH = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(260809);
  }
  
  private void initSetVCodecEncode()
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(260819);
    boolean bool;
    int k;
    if (((c)h.ax(c.class)).a(c.a.zxc, 1) == 1)
    {
      bool = true;
      i locali = i.agtt;
      k = i.a(b.a.agrI, 0);
      Log.i("MicroMsg.PluginVideo", "initSetVCodecEncode, exptConfig:%s, repairerConfig:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(k) });
      if (k != 0) {
        break label102;
      }
      if (!bool) {
        break label97;
      }
    }
    for (;;)
    {
      SightVideoJNI.setEnableVCodecEncode(i);
      AppMethodBeat.o(260819);
      return;
      bool = false;
      break;
      label97:
      i = 0;
    }
    label102:
    if (k == 1) {}
    for (i = j;; i = 0)
    {
      SightVideoJNI.setEnableVCodecEncode(i);
      AppMethodBeat.o(260819);
      return;
    }
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(176825);
    if (paramg.bbA())
    {
      af.aR("video", "video", 17);
      this.lsH.alive();
    }
    AppMethodBeat.o(176825);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(127139);
    Log.i("MicroMsg.PluginVideo", "plugin video execute");
    if (paramg.bbA())
    {
      pin(new y(v.class));
      pin(new y(e.class));
      pin(new y(u.class));
    }
    AppMethodBeat.o(127139);
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