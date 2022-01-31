package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.f;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.d;

final class ao$1
  implements f
{
  ao$1(ao paramao, bi parambi, String paramString, int paramInt) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + paramInt1 + " errCode " + paramInt2 + "  scene " + paramm.getType());
    boolean bool = false;
    if (am.a.dVB != null) {
      bool = am.a.dVB.bB(this.vGM.field_msgId);
    }
    if ((!bool) && (paramInt1 == 0) && (paramInt2 == 0) && (((ac)paramm).getMediaId().equals(this.BF))) {
      ((ai)ao.a(this.vGO).ac(ai.class)).cFx().a(this.vGN, this.vGM);
    }
    au.Dk().b(221, ao.b(this.vGO));
    ao.c(this.vGO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.1
 * JD-Core Version:    0.7.0.1
 */