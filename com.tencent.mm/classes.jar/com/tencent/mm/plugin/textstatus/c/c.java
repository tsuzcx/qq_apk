package com.tencent.mm.plugin.textstatus.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/jump/LiveSingleton;", "Lcom/tencent/mm/plugin/textstatus/jump/ITextStatusJumpSingleton;", "()V", "doJump", "", "textStatusID", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "plugin-textstatus_release"})
public final class c
  implements b
{
  public final boolean F(String paramString, List<? extends r> paramList)
  {
    AppMethodBeat.i(258410);
    p.h(paramString, "textStatusID");
    p.h(paramList, "jumpInfos");
    boolean bool = false;
    long l = -1L;
    paramString = ((Iterable)paramList).iterator();
    if (paramString.hasNext())
    {
      paramList = (r)paramString.next();
      l += 1L;
      String str = paramList.GaO;
      if (str == null) {}
      do
      {
        for (;;)
        {
          bool = false;
          break;
          switch (str.hashCode())
          {
          }
        }
      } while (!str.equals("2"));
      paramList = XmlParser.parseXml(paramList.GaQ, "finderLive", null);
      if (paramList != null)
      {
        paramList = com.tencent.mm.plugin.i.a.l.v("", paramList);
        k.vkd.a(d.Ga(paramList.feedId), d.Ga(paramList.hJs), paramList.username, -1L, l, s.p.voF, s.j.vob.scene);
        if (!Util.isEqual(z.aUg(), paramList.username)) {
          break label236;
        }
        ((aj)g.ah(aj.class)).enterFinderLiveAnchorUI(MMApplicationContext.getContext(), d.Ga(paramList.feedId), Long.valueOf(d.Ga(paramList.hJs)), paramList.objectNonceId, paramList.desc, "", "");
      }
      for (;;)
      {
        bool = true;
        break;
        label236:
        ((aj)g.ah(aj.class)).enterFinderLiveVisitorUI(MMApplicationContext.getContext(), d.Ga(paramList.feedId), Long.valueOf(d.Ga(paramList.hJs)), paramList.username, paramList.objectNonceId, paramList.desc, "", "");
      }
    }
    AppMethodBeat.o(258410);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.c.c
 * JD-Core Version:    0.7.0.1
 */