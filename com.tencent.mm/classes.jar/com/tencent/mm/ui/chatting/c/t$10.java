package com.tencent.mm.ui.chatting.c;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.LinkedList;

final class t$10
  implements View.OnClickListener
{
  t$10(t paramt, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31491);
    if (((com.tencent.mm.ui.chatting.c.b.t)this.zGC.caz.ay(com.tencent.mm.ui.chatting.c.b.t.class)).dIO())
    {
      ((com.tencent.mm.ui.chatting.c.b.t)this.zGC.caz.ay(com.tencent.mm.ui.chatting.c.b.t.class)).PH(t.j(this.zGC));
      AppMethodBeat.o(31491);
      return;
    }
    if ((int)this.zGC.caz.txj.euF == 0)
    {
      aw.aaz();
      if (c.YA().Z(this.zGC.caz.txj) != -1) {
        ab.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", new Object[] { this.zGC.caz.txj });
      }
    }
    String str;
    if (com.tencent.mm.model.t.lA(this.zGC.caz.txj.field_username))
    {
      paramView = this.zGC.caz.txj.field_username;
      aw.aaz();
      Object localObject = c.YA().arw(t.e(this.zGC));
      if (localObject == null) {
        break label360;
      }
      str = bo.bf(((aq)localObject).dra, "");
      label197:
      ab.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", new Object[] { t.e(this.zGC), paramView, str });
      if (((!TextUtils.isEmpty(paramView)) && (TextUtils.isEmpty(str))) || (ad.arf(((aq)localObject).field_username))) {
        break label366;
      }
      localObject = new com.tencent.mm.pluginsdk.ui.applet.a(this.zGC.caz.zJz.getContext(), new t.10.1(this));
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(3));
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).amg(str);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).c(t.e(this.zGC), paramView, localLinkedList);
    }
    for (;;)
    {
      h.qsU.e(11004, new Object[] { t.e(this.zGC), Integer.valueOf(3) });
      AppMethodBeat.o(31491);
      return;
      paramView = "";
      break;
      label360:
      str = "";
      break label197;
      label366:
      ao.a.flI.a(t.e(this.zGC), paramView, new t.10.2(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t.10
 * JD-Core Version:    0.7.0.1
 */