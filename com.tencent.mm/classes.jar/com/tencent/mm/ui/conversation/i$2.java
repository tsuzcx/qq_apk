package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class i$2
  implements Runnable
{
  i$2(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(34398);
    if (!aw.RG())
    {
      i.c(this.AkC).stopTimer();
      ab.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
      AppMethodBeat.o(34398);
      return;
    }
    long l = ah.aoy();
    i.d(this.AkC);
    l = ah.hl(l) * 3L;
    ab.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(i.access$600()), Boolean.valueOf(i.a(this.AkC)) });
    i.oR((l + i.access$600()) / 2L);
    i.e(this.AkC);
    ap localap = i.c(this.AkC);
    l = i.access$600();
    localap.ag(l, l);
    AppMethodBeat.o(34398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i.2
 * JD-Core Version:    0.7.0.1
 */