package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.record.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.a;

final class ar$1
  implements f
{
  ar$1(ar paramar, bi parambi, String paramString, int paramInt) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33401);
    ab.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + paramInt1 + " errCode " + paramInt2 + "  scene " + paramm.getType());
    boolean bool = false;
    if (ao.a.flL != null) {
      bool = ao.a.flL.gv(this.zYi.field_msgId);
    }
    if ((!bool) && (paramInt1 == 0) && (paramInt2 == 0) && (((e)paramm).getMediaId().equals(this.Cq))) {
      ((aj)ar.a(this.zYk).ay(aj.class)).dJv().a(this.zYj, this.zYi);
    }
    aw.Rc().b(221, ar.b(this.zYk));
    ar.c(this.zYk);
    AppMethodBeat.o(33401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar.1
 * JD-Core Version:    0.7.0.1
 */