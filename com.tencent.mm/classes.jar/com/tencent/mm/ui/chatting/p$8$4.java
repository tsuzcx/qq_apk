package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.b.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.d.a;

final class p$8$4
  implements h.c
{
  p$8$4(p.8 param8) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(156116);
    Object localObject = new Intent();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(156116);
      return;
      h.qsU.e(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
      ((Intent)localObject).putExtra("key_way", 0);
      ((Intent)localObject).putExtra("key_type", 0);
      ((Intent)localObject).putExtra("key_from", 1);
      ((Intent)localObject).putExtra("key_username", this.zyW.zyT.getTalkerUserName());
      ((Intent)localObject).putExtra("pay_channel", 11);
      d.b(p.e(this.zyW.zyT).zJz.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", (Intent)localObject);
      AppMethodBeat.o(156116);
      return;
      h.qsU.e(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
      ((Intent)localObject).putExtra("key_username", this.zyW.zyT.getTalkerUserName());
      ((Intent)localObject).putExtra("key_way", 0);
      ((Intent)localObject).putExtra("pay_channel", 11);
      d.b(p.e(this.zyW.zyT).zJz.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", (Intent)localObject);
      localObject = new n();
      ((n)localObject).cRI = 1L;
      ((n)localObject).ake();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p.8.4
 * JD-Core Version:    0.7.0.1
 */