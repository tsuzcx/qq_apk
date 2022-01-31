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

final class am$2
  implements f
{
  am$2(am paramam, bi parambi, String paramString, int paramInt) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramInt1 + " errCode " + paramInt2 + "  scene " + paramm.getType());
    boolean bool = false;
    if (am.a.dVB != null) {
      bool = am.a.dVB.bB(this.vGC.field_msgId);
    }
    if ((!bool) && (paramInt1 == 0) && (paramInt2 == 0) && (((ac)paramm).getMediaId().equals(this.BF)))
    {
      paramString = bi.ak(this.vGC);
      paramString.ed(this.vGC.field_reserved);
      paramString.setMsgId(-1L);
      ((ai)am.a(this.vGE).ac(ai.class)).cFx().b(this.vGD, paramString);
    }
    au.Dk().b(221, am.b(this.vGE));
    am.a(this.vGE, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.2
 * JD-Core Version:    0.7.0.1
 */