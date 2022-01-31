package com.tencent.mm.ui.conversation;

import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class i$2
  implements Runnable
{
  i$2(i parami) {}
  
  public final void run()
  {
    if (!au.DK())
    {
      i.c(this.vSJ).stopTimer();
      y.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
      return;
    }
    long l = ah.UY();
    i.d(this.vSJ);
    l = ah.co(l) * 3L;
    y.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(i.cIj()), Boolean.valueOf(i.a(this.vSJ)) });
    i.jdMethod_if((l + i.cIj()) / 2L);
    i.e(this.vSJ);
    am localam = i.c(this.vSJ);
    l = i.cIj();
    localam.S(l, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i.2
 * JD-Core Version:    0.7.0.1
 */