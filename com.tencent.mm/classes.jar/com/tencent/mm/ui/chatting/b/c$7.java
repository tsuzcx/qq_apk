package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.a.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

final class c$7
  implements Runnable
{
  c$7(c paramc) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    if ((this.voK.kax) && (this.voK.veo != null) && (this.voK.byx.pSb != null))
    {
      c.e(this.voK);
      com.tencent.mm.ai.z.ML();
      com.tencent.mm.ai.a.c localc = this.voK.veo;
      if (com.tencent.mm.kernel.a.hw(g.DN().dJB))
      {
        String str = String.format("%s;%s;%d", new Object[] { localc.field_brandUserName, localc.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
        com.tencent.mm.modelsimple.z.b(localc.field_brandUserName, 7, "EnterpriseChatStatus", str);
        y.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", new Object[] { str });
      }
      if (this.voK.voC)
      {
        if (this.voK.veo.MO())
        {
          com.tencent.mm.ai.z.MG();
          h.ar(this.voK.veo.field_bizChatServId, this.voK.byx.pSb.field_username);
        }
      }
      else {
        c.f(this.voK);
      }
    }
    for (;;)
    {
      y.d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      e.f(this.voK.veo);
      break;
      y.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", new Object[] { this.voK.veo, this.voK.byx.pSb });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c.7
 * JD-Core Version:    0.7.0.1
 */