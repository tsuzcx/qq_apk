package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.c.a;

final class q$10$4
  implements h.c
{
  q$10$4(q.10 param10) {}
  
  public final void gl(int paramInt)
  {
    Intent localIntent = new Intent();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      h.nFQ.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
      localIntent.putExtra("key_username", this.vjU.vjS.getTalkerUserName());
      localIntent.putExtra("key_way", 0);
      localIntent.putExtra("pay_channel", 11);
      d.b(q.e(this.vjU.vjS).vtz.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", localIntent);
      return;
    }
    h.nFQ.f(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
    localIntent.putExtra("key_way", 0);
    localIntent.putExtra("key_type", 0);
    localIntent.putExtra("key_from", 1);
    localIntent.putExtra("key_username", this.vjU.vjS.getTalkerUserName());
    localIntent.putExtra("pay_channel", 11);
    d.b(q.e(this.vjU.vjS).vtz.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.10.4
 * JD-Core Version:    0.7.0.1
 */