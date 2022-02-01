package com.tencent.mm.plugin.recordvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-recordvideo_release"})
public final class PluginVideoEditor$a
  extends o.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(75040);
    if (h.aHB())
    {
      paramString = h.aHE();
      p.j(paramString, "account()");
      if (paramString.aGN()) {
        b.aGE();
      }
    }
    AppMethodBeat.o(75040);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(75039);
    if (h.aHB())
    {
      paramString = h.aHE();
      p.j(paramString, "account()");
      if ((paramString.aGN()) && (!b.aGE()))
      {
        paramString = h.aHG();
        p.j(paramString, "storage()");
        paramString = paramString.aHp().get(ar.a.Vxy, Long.valueOf(0L));
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(75039);
          throw paramString;
        }
        if (Util.secondsToNow(Util.nullAsNil((Long)paramString)) > 86400L)
        {
          paramString = h.aHG();
          p.j(paramString, "storage()");
          paramString.aHp().set(ar.a.Vxy, Long.valueOf(Util.nowSecond()));
          paramString = e.HGz;
          e.fuY();
        }
      }
    }
    AppMethodBeat.o(75039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor.a
 * JD-Core Version:    0.7.0.1
 */