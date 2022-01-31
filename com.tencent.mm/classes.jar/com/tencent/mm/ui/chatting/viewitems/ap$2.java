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

final class ap$2
  implements f
{
  ap$2(ap paramap, bi parambi, String paramString, int paramInt) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33384);
    ab.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramInt1 + " errCode " + paramInt2 + "  scene " + paramm.getType());
    boolean bool = false;
    if (ao.a.flL != null) {
      bool = ao.a.flL.gv(this.zXY.field_msgId);
    }
    if ((!bool) && (paramInt1 == 0) && (paramInt2 == 0) && (((e)paramm).getMediaId().equals(this.Cq)))
    {
      paramString = bi.as(this.zXY);
      paramString.kk(this.zXY.field_reserved);
      paramString.setMsgId(-1L);
      ((aj)ap.a(this.zYa).ay(aj.class)).dJv().b(this.zXZ, paramString);
    }
    aw.Rc().b(221, ap.b(this.zYa));
    ap.a(this.zYa, null);
    AppMethodBeat.o(33384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.2
 * JD-Core Version:    0.7.0.1
 */