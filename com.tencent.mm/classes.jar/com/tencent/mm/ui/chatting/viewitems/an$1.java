package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;

final class an$1
  implements f
{
  an$1(an paraman) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + paramInt1 + " errCode " + paramInt2 + "  scene " + paramm.getType());
    au.Dk().b(221, an.a(this.vGK));
    an.b(this.vGK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.1
 * JD-Core Version:    0.7.0.1
 */