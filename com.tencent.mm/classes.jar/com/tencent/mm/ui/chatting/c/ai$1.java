package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.o;
import java.util.HashMap;
import java.util.LinkedList;

final class ai$1
  implements Runnable
{
  ai$1(ai paramai, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(31681);
    if (this.zHW.caz == null)
    {
      ab.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
      AppMethodBeat.o(31681);
      return;
    }
    g.Cx(20);
    if (ai.a(this.zHW))
    {
      this.zHW.caz.dJD();
      localObject = new com.tencent.mm.ap.a(this.zHW.caz.txj.field_username, this.byh);
      aw.Rc().a((m)localObject, 0);
      AppMethodBeat.o(31681);
      return;
    }
    if ((((com.tencent.mm.ui.chatting.c.b.h)this.zHW.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).getCount() == 0) && (ad.are(this.zHW.caz.getTalkerUserName()))) {
      bv.abc().c(10076, new Object[] { Integer.valueOf(1) });
    }
    String str4 = this.zHW.caz.getTalkerUserName();
    int j = com.tencent.mm.model.t.oF(str4);
    String str3 = this.byh;
    Object localObject = null;
    int i;
    try
    {
      String str1 = ((com.tencent.mm.ui.chatting.c.b.t)this.zHW.caz.ay(com.tencent.mm.ui.chatting.c.b.t.class)).atW(str4);
      localObject = str1;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ChattingUI.SendTextComponent", localNullPointerException, "", new Object[0]);
      }
      localo = (o)this.zHW.caz.ay(o.class);
      i = str3.lastIndexOf(' ');
      if (i <= 0) {
        break label568;
      }
    }
    if (bo.isNullOrNil((String)localObject))
    {
      ab.w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
      AppMethodBeat.o(31681);
      return;
    }
    o localo;
    String str2;
    if (i == str3.length() - 1)
    {
      str2 = str3.substring(0, i);
      ab.w("MicroMsg.ChattingUI.SendTextComponent", "delete @ last char! index:".concat(String.valueOf(i)));
    }
    for (;;)
    {
      ChatFooter localChatFooter = localo.dIg();
      i = this.bMJ;
      if (localChatFooter.vWk.vYg.containsKey(str4)) {
        if (((LinkedList)localChatFooter.vWk.vYg.get(str4)).size() > 0) {
          i = 291;
        }
      }
      for (;;)
      {
        localObject = new com.tencent.mm.modelmulti.h((String)localObject, str2, j, i, localo.dIg().hW(str4, str3));
        ((com.tencent.mm.ui.chatting.c.b.t)this.zHW.caz.ay(com.tencent.mm.ui.chatting.c.b.t.class)).g((com.tencent.mm.modelmulti.h)localObject);
        aw.Rc().a((m)localObject, 0);
        if (com.tencent.mm.model.t.oB(str4))
        {
          localObject = new j(q.LO(), this.byh + " key " + bs.dyO() + " local key " + bs.dyN() + "NetType:" + at.getNetTypeString(this.zHW.caz.zJz.getContext().getApplicationContext()) + " hasNeon: " + n.Lu() + " isArmv6: " + n.Lw() + " isArmv7: " + n.Lv());
          aw.Rc().a((m)localObject, 0);
        }
        AppMethodBeat.o(31681);
        return;
      }
      label568:
      str2 = str3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ai.1
 * JD-Core Version:    0.7.0.1
 */