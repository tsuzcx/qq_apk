package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class x$9
  implements View.OnClickListener
{
  x$9(x paramx, int paramInt, Map paramMap) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33136);
    if (this.val$index == 1)
    {
      String str = (String)this.bQD.get(".msg.appmsg.mmreader.category.item.schedule_username");
      long l = bo.getLong((String)this.bQD.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
      x.b(paramView.getContext(), str, l);
      h.qsU.idkeyStat(795L, 2L, 1L, false);
      ab.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { str, Long.valueOf(l) });
      AppMethodBeat.o(33136);
      return;
    }
    if (this.val$index == 2) {
      d.f(paramView.getContext(), ".ui.AllRemindMsgUI", new Intent());
    }
    AppMethodBeat.o(33136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.9
 * JD-Core Version:    0.7.0.1
 */