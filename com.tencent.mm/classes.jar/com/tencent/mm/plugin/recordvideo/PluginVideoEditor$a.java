package com.tencent.mm.plugin.recordvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginVideoEditor$a
  extends q.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(75040);
    if ((h.baz()) && (h.baC().mBZ)) {
      b.aZG();
    }
    AppMethodBeat.o(75040);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(75039);
    if ((h.baz()) && (h.baC().mBZ) && (!b.aZG()))
    {
      paramString = h.baE().ban().get(at.a.acZk, Long.valueOf(0L));
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(75039);
        throw paramString;
      }
      if (Util.secondsToNow(Util.nullAsNil(Long.valueOf(((Long)paramString).longValue()))) > 86400L)
      {
        h.baE().ban().set(at.a.acZk, Long.valueOf(Util.nowSecond()));
        paramString = e.NDU;
        e.gGO();
      }
    }
    AppMethodBeat.o(75039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor.a
 * JD-Core Version:    0.7.0.1
 */