package com.tencent.mm.plugin.remittance.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.tj;
import com.tencent.mm.autogen.a.tj.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;

class MsgCheckTaskMgr$MsgCheckTask$1
  extends IListener<tj>
{
  MsgCheckTaskMgr$MsgCheckTask$1(g.a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(288848);
    this.__eventId = tj.class.getName().hashCode();
    AppMethodBeat.o(288848);
  }
  
  private boolean a(tj paramtj)
  {
    AppMethodBeat.i(288852);
    if ((paramtj.hWU.hWV == null) || (!g.a.a(this.Oik).Okt.equals(paramtj.hWU.hPj)))
    {
      AppMethodBeat.o(288852);
      return false;
    }
    cc localcc = ((n)h.ax(n.class)).gaZ().sl(paramtj.hWU.msgId);
    if ((localcc == null) || (localcc.getType() != 419430449))
    {
      AppMethodBeat.o(288852);
      return false;
    }
    int i = paramtj.hWU.hWV.nSh;
    Log.i("MicroMsg.MsgCheckTaskMgr", "MsgCheck msgID:%s transeferID:%s paySubType:%s", new Object[] { Long.valueOf(paramtj.hWU.msgId), paramtj.hWU.hPj, Integer.valueOf(i) });
    if (((i == 3) || (i == 4) || (i == 5) || (i == 6)) && (!g.a.b(this.Oik))) {
      this.Oik.stop();
    }
    AppMethodBeat.o(288852);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.MsgCheckTaskMgr.MsgCheckTask.1
 * JD-Core Version:    0.7.0.1
 */