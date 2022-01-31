package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.chatting.e;
import java.util.HashMap;
import java.util.LinkedList;

final class ah$1
  implements Runnable
{
  ah$1(ah paramah, String paramString, int paramInt) {}
  
  public final void run()
  {
    if (this.vsp.byx == null)
    {
      y.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
      return;
    }
    com.tencent.mm.plugin.report.service.g.wI(20);
    if (ah.a(this.vsp))
    {
      this.vsp.byx.cFB();
      localObject1 = new com.tencent.mm.ao.a(this.vsp.byx.pSb.field_username, this.bhH);
      au.Dk().a((m)localObject1, 0);
      return;
    }
    if ((((com.tencent.mm.ui.chatting.b.b.g)this.vsp.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).getCount() == 0) && (ad.aaT(this.vsp.byx.getTalkerUserName()))) {
      bt.If().d(10076, new Object[] { Integer.valueOf(1) });
    }
    String str1 = this.vsp.byx.getTalkerUserName();
    int j = com.tencent.mm.model.s.hW(str1);
    Object localObject2 = this.bhH;
    String str2 = ((com.tencent.mm.ui.chatting.b.b.s)this.vsp.byx.ac(com.tencent.mm.ui.chatting.b.b.s.class)).adu(str1);
    if (bk.bl(str2))
    {
      y.w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
      return;
    }
    com.tencent.mm.ui.chatting.b.b.n localn = (com.tencent.mm.ui.chatting.b.b.n)this.vsp.byx.ac(com.tencent.mm.ui.chatting.b.b.n.class);
    int i = ((String)localObject2).lastIndexOf(' ');
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject1 = localObject2;
      if (i == ((String)localObject2).length() - 1)
      {
        localObject1 = ((String)localObject2).substring(0, i);
        y.w("MicroMsg.ChattingUI.SendTextComponent", "delete @ last char! index:" + i);
      }
    }
    localObject2 = localn.cEq();
    i = this.bnk;
    if (((ChatFooter)localObject2).sff.sgl.containsKey(str1)) {
      if (((LinkedList)((ChatFooter)localObject2).sff.sgl.get(str1)).size() > 0) {
        i = 291;
      }
    }
    for (;;)
    {
      localObject1 = new h(str2, (String)localObject1, j, i, localn.cEq().fU(str1, (String)localObject1));
      ((com.tencent.mm.ui.chatting.b.b.s)this.vsp.byx.ac(com.tencent.mm.ui.chatting.b.b.s.class)).g((h)localObject1);
      au.Dk().a((m)localObject1, 0);
      if (!com.tencent.mm.model.s.hS(str1)) {
        break;
      }
      localObject1 = new j(q.zv(), this.bhH + " key " + bs.cwc() + " local key " + bs.cwb() + "NetType:" + aq.getNetTypeString(this.vsp.byx.vtz.getContext().getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.e.n.yX() + " isArmv6: " + com.tencent.mm.compatible.e.n.yZ() + " isArmv7: " + com.tencent.mm.compatible.e.n.yY());
      au.Dk().a((m)localObject1, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ah.1
 * JD-Core Version:    0.7.0.1
 */