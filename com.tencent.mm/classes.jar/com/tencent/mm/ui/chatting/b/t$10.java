package com.tencent.mm.ui.chatting.b;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.e;
import java.util.LinkedList;

final class t$10
  implements View.OnClickListener
{
  t$10(t paramt, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    if (((com.tencent.mm.ui.chatting.b.b.s)this.vqY.byx.ac(com.tencent.mm.ui.chatting.b.b.s.class)).cEW())
    {
      ((com.tencent.mm.ui.chatting.b.b.s)this.vqY.byx.ac(com.tencent.mm.ui.chatting.b.b.s.class)).Hd(t.i(this.vqY));
      return;
    }
    if ((int)this.vqY.byx.pSb.dBe == 0)
    {
      au.Hx();
      if (c.Fw().W(this.vqY.byx.pSb) != -1) {
        y.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", new Object[] { this.vqY.byx.pSb });
      }
    }
    String str;
    if (com.tencent.mm.model.s.fn(this.vqY.byx.pSb.field_username))
    {
      paramView = this.vqY.byx.pSb.field_username;
      au.Hx();
      Object localObject = c.Fw().abl(t.d(this.vqY));
      if (localObject == null) {
        break label342;
      }
      str = bk.aM(((ao)localObject).cCQ, "");
      label185:
      y.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", new Object[] { t.d(this.vqY), paramView, str });
      if (((!TextUtils.isEmpty(paramView)) && (TextUtils.isEmpty(str))) || (ad.aaU(((ao)localObject).field_username))) {
        break label348;
      }
      localObject = new com.tencent.mm.pluginsdk.ui.applet.a(this.vqY.byx.vtz.getContext(), new t.10.1(this));
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(3));
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).WA(str);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).b(t.d(this.vqY), paramView, localLinkedList);
    }
    for (;;)
    {
      h.nFQ.f(11004, new Object[] { t.d(this.vqY), Integer.valueOf(3) });
      return;
      paramView = "";
      break;
      label342:
      str = "";
      break label185;
      label348:
      am.a.dVy.a(t.d(this.vqY), paramView, new t.10.2(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.t.10
 * JD-Core Version:    0.7.0.1
 */