package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.h;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.sdk.platformtools.Log;

final class c$8
  implements Runnable
{
  c$8(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(35090);
    long l = System.currentTimeMillis();
    if ((this.PmV.tca) && (this.PmV.Pag != null) && (this.PmV.dom.GUe != null))
    {
      c.f(this.PmV);
      ag.bav();
      com.tencent.mm.al.a.c localc = this.PmV.Pag;
      if (com.tencent.mm.kernel.a.qd(g.aAf().hpS))
      {
        String str = String.format("%s;%s;%d", new Object[] { localc.field_brandUserName, localc.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
        ab.b(localc.field_brandUserName, 7, "EnterpriseChatStatus", str);
        Log.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", new Object[] { str });
      }
      if (this.PmV.PmM)
      {
        if (this.PmV.Pag.bay())
        {
          ag.baq();
          h.bn(this.PmV.Pag.field_bizChatServId, this.PmV.dom.GUe.field_username);
        }
      }
      else {
        c.g(this.PmV);
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(35090);
      return;
      e.f(this.PmV.Pag);
      break;
      Log.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", new Object[] { this.PmV.Pag, this.PmV.dom.GUe });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.8
 * JD-Core Version:    0.7.0.1
 */