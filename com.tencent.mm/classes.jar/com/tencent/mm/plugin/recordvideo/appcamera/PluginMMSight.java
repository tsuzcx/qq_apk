package com.tencent.mm.plugin.recordvideo.appcamera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.api.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.b;
import com.tencent.mm.plugin.mmsight.api.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/appcamera/PluginMMSight;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/appcamera/IPluginMMSight;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "name", "", "Companion", "plugin-recordvideo_release"})
public final class PluginMMSight
  extends f
  implements e
{
  private static final String TAG = "MicroMsg.PluginMMSight";
  public static final PluginMMSight.a wmd;
  
  static
  {
    AppMethodBeat.i(75153);
    wmd = new PluginMMSight.a((byte)0);
    TAG = "MicroMsg.PluginMMSight";
    AppMethodBeat.o(75153);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(75152);
    if (paramg != null) {
      ac.i(TAG, "execute, process: %s", new Object[] { paramg.getProcessName() });
    }
    com.tencent.mm.plugin.mmsight.api.b.uJO = (com.tencent.mm.plugin.mmsight.api.b.a)new com.tencent.mm.plugin.api.b.a();
    com.tencent.mm.plugin.mmsight.api.MMSightRecordView.uJN = (MMSightRecordView.b)new c();
    com.tencent.mm.plugin.mmsight.api.a.uJL = (a.b)new a();
    if (paramg != null)
    {
      if (paramg.ahL() == true) {
        pin((com.tencent.mm.kernel.b.c)new t(com.tencent.mm.plugin.mmsight.e.class));
      }
      AppMethodBeat.o(75152);
      return;
    }
    AppMethodBeat.o(75152);
  }
  
  public final String name()
  {
    return "plugin-recordvideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight
 * JD-Core Version:    0.7.0.1
 */