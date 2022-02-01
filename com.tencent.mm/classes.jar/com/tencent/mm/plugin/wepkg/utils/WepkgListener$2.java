package com.tencent.mm.plugin.wepkg.utils;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wn;
import com.tencent.mm.autogen.a.wn.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

class WepkgListener$2
  extends IListener<wn>
{
  WepkgListener$2(c paramc, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(278663);
    this.__eventId = wn.class.getName().hashCode();
    AppMethodBeat.o(278663);
  }
  
  private boolean a(wn paramwn)
  {
    AppMethodBeat.i(110788);
    boolean bool = paramwn.iai.hNd;
    Log.i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (Util.secondsToNow(Util.nullAsNil((Long)h.baE().ban().get(at.a.acSC, Long.valueOf(0L)))) > 60L))
    {
      h.baE().ban().set(at.a.acSC, Long.valueOf(Util.nowSecond()));
      c.a(this.XGY, 2);
    }
    AppMethodBeat.o(110788);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgListener.2
 * JD-Core Version:    0.7.0.1
 */