package com.tencent.mm.plugin.xlabeffect;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.cd.a;
import com.tencent.mm.emoji.c.a;
import com.tencent.mm.emoji.c.a.a;
import com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/xlabeffect/WeVisModelResMgr$checkResUpdateCacheFileEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WeVisModelResMgr$checkResUpdateCacheFileEventListener$1
  extends IListener<cd>
{
  WeVisModelResMgr$checkResUpdateCacheFileEventListener$1(f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(261629);
    AppMethodBeat.o(261629);
  }
  
  private static boolean a(cd paramcd)
  {
    AppMethodBeat.i(261634);
    s.u(paramcd, "event");
    int i = paramcd.hCg.hCh;
    boolean bool = paramcd.hCg.hCj;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(261634);
      return false;
      if (!bool)
      {
        AppMethodBeat.o(261634);
        return false;
      }
      Log.i(h.aUw(), "config file update");
      b.iJf();
      paramcd = b.nK(i, 0);
      if (paramcd == null)
      {
        Log.w(h.aUw(), "path is null");
        AppMethodBeat.o(261634);
        return false;
      }
      Object localObject = new g();
      a.a locala = a.mhz;
      a.a.a(paramcd, (a)localObject);
      if (((g)localObject).isValid())
      {
        localObject = d.XJR;
        y.O(paramcd, d.iFR(), false);
        paramcd = d.XJR;
        d.iFQ();
        paramcd = h.XKm;
        h.iFX();
        continue;
        if (!bool)
        {
          AppMethodBeat.o(261634);
          return false;
        }
        int j = paramcd.hCg.subType;
        Log.i(h.aUw(), "model file update " + i + '.' + j);
        b.iJf();
        paramcd = b.nK(i, j);
        if (paramcd == null)
        {
          Log.w(h.aUw(), "path is null");
          AppMethodBeat.o(261634);
          return false;
        }
        localObject = h.XKm;
        h.dS(j, paramcd);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.WeVisModelResMgr.checkResUpdateCacheFileEventListener.1
 * JD-Core Version:    0.7.0.1
 */