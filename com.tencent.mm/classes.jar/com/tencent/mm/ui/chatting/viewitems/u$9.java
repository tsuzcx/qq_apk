package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class u$9
  implements View.OnClickListener
{
  u$9(u paramu, int paramInt, Map paramMap) {}
  
  public final void onClick(View paramView)
  {
    if (this.val$index == 1)
    {
      str = (String)this.qyI.get(".msg.appmsg.mmreader.category.item.schedule_username");
      l = bk.getLong((String)this.qyI.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
      u.b(paramView.getContext(), str, l);
      h.nFQ.a(795L, 2L, 1L, false);
      y.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { str, Long.valueOf(l) });
    }
    while (this.val$index != 2)
    {
      String str;
      long l;
      return;
    }
    d.e(paramView.getContext(), ".ui.AllRemindMsgUI", new Intent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.9
 * JD-Core Version:    0.7.0.1
 */