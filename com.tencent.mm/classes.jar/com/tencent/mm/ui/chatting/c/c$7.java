package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.h;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.sdk.platformtools.ab;

final class c$7
  implements Runnable
{
  c$7(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(31198);
    long l = System.currentTimeMillis();
    if ((this.zEm.muT) && (this.zEm.zsO != null) && (this.zEm.caz.txj != null))
    {
      c.f(this.zEm);
      z.afv();
      com.tencent.mm.aj.a.c localc = this.zEm.zsO;
      if (com.tencent.mm.kernel.a.jM(g.RJ().eHa))
      {
        String str = String.format("%s;%s;%d", new Object[] { localc.field_brandUserName, localc.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
        aa.b(localc.field_brandUserName, 7, "EnterpriseChatStatus", str);
        ab.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", new Object[] { str });
      }
      if (this.zEm.zEd)
      {
        if (this.zEm.zsO.afy())
        {
          z.afq();
          h.aL(this.zEm.zsO.field_bizChatServId, this.zEm.caz.txj.field_username);
        }
      }
      else {
        c.g(this.zEm);
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(31198);
      return;
      e.f(this.zEm.zsO);
      break;
      ab.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", new Object[] { this.zEm.zsO, this.zEm.caz.txj });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.7
 * JD-Core Version:    0.7.0.1
 */