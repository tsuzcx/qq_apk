package com.tencent.mm.plugin.recordvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-recordvideo_release"})
public final class PluginVideoEditor$a
  extends n.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(75040);
    if (g.afw())
    {
      paramString = g.afz();
      k.g(paramString, "account()");
      if (paramString.aeJ()) {
        a.aeC();
      }
    }
    AppMethodBeat.o(75040);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(75039);
    if (g.afw())
    {
      paramString = g.afz();
      k.g(paramString, "account()");
      if ((paramString.aeJ()) && (!a.aeC()))
      {
        paramString = g.afB();
        k.g(paramString, "storage()");
        paramString = paramString.afk().get(ae.a.FvD, Long.valueOf(0L));
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(75039);
          throw paramString;
        }
        if (bt.lZ(bt.f((Long)paramString)) > 86400L)
        {
          paramString = g.afB();
          k.g(paramString, "storage()");
          paramString.afk().set(ae.a.FvD, Long.valueOf(bt.aGK()));
          paramString = f.vdH;
          f.dgM();
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