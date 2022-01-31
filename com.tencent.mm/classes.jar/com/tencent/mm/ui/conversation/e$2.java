package com.tencent.mm.ui.conversation;

import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements Runnable
{
  e$2(e parame) {}
  
  public final void run()
  {
    if (!au.DK())
    {
      e.f(this.vQh).stopTimer();
      y.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
      return;
    }
    long l = ah.UY();
    e.g(this.vQh);
    l = ah.co(l) * 3L;
    y.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(e.cHY()), Boolean.valueOf(e.d(this.vQh)) });
    e.ie((l + e.cHY()) / 2L);
    e.h(this.vQh);
    am localam = e.f(this.vQh);
    l = e.cHY();
    localam.S(l, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e.2
 * JD-Core Version:    0.7.0.1
 */