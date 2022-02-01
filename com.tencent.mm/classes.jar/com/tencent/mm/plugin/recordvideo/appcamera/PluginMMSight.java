package com.tencent.mm.plugin.recordvideo.appcamera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.api.d.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.b;
import com.tencent.mm.plugin.mmsight.api.a.b;
import com.tencent.mm.plugin.mmsight.api.b.a;
import com.tencent.mm.plugin.mmsight.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/appcamera/PluginMMSight;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/appcamera/IPluginMMSight;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "name", "", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginMMSight
  extends f
  implements d
{
  public static final PluginMMSight.a NDL;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(75153);
    NDL = new PluginMMSight.a((byte)0);
    TAG = "MicroMsg.PluginMMSight";
    AppMethodBeat.o(75153);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(75152);
    if (paramg != null) {
      Log.i(TAG, "execute, process: %s", new Object[] { paramg.mProcessName });
    }
    com.tencent.mm.plugin.mmsight.api.b.KUm = (b.a)new d.a();
    com.tencent.mm.plugin.mmsight.api.MMSightRecordView.KUl = (MMSightRecordView.b)new b();
    com.tencent.mm.plugin.mmsight.api.a.KUj = (a.b)new com.tencent.mm.plugin.api.c();
    if ((paramg != null) && (paramg.bbA() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        pin((com.tencent.mm.kernel.b.c)new y(e.class));
      }
      AppMethodBeat.o(75152);
      return;
    }
  }
  
  public final String name()
  {
    return "plugin-recordvideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight
 * JD-Core Version:    0.7.0.1
 */