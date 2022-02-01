package com.tencent.mm.plugin.recordvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-recordvideo_release"})
public final class PluginVideoEditor$a
  extends o.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(75040);
    if (g.ajM())
    {
      paramString = g.ajP();
      p.g(paramString, "account()");
      if (paramString.aja()) {
        a.aiT();
      }
    }
    AppMethodBeat.o(75040);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(75039);
    if (g.ajM())
    {
      paramString = g.ajP();
      p.g(paramString, "account()");
      if ((paramString.aja()) && (!a.aiT()))
      {
        paramString = g.ajR();
        p.g(paramString, "storage()");
        paramString = paramString.ajA().get(am.a.JaC, Long.valueOf(0L));
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(75039);
          throw paramString;
        }
        if (bu.rZ(bu.i((Long)paramString)) > 86400L)
        {
          paramString = g.ajR();
          p.g(paramString, "storage()");
          paramString.ajA().set(am.a.JaC, Long.valueOf(bu.aRi()));
          paramString = com.tencent.mm.plugin.recordvideo.background.e.xKl;
          com.tencent.mm.plugin.recordvideo.background.e.dIh();
        }
      }
    }
    AppMethodBeat.o(75039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor.a
 * JD-Core Version:    0.7.0.1
 */