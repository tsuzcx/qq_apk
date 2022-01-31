package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(32502);
    this.zOU.cEE.setType(10002);
    v.a(ah.getContext().getString(2131298301), "", this.zOU.cEE, "");
    aw.aaz();
    c.YC().a(this.zOU.cEE.field_msgId, this.zOU.cEE);
    ab.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", new Object[] { Long.valueOf(this.zOU.cEE.field_msgId) });
    AppMethodBeat.o(32502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a.1
 * JD-Core Version:    0.7.0.1
 */