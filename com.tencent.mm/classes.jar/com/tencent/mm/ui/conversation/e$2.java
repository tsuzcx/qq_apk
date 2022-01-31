package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class e$2
  implements Runnable
{
  e$2(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(34186);
    if (!aw.RG())
    {
      e.f(this.AhR).stopTimer();
      ab.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
      AppMethodBeat.o(34186);
      return;
    }
    long l = ah.aoy();
    e.g(this.AhR);
    l = ah.hl(l) * 3L;
    ab.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(e.dMt()), Boolean.valueOf(e.d(this.AhR)) });
    e.oQ((l + e.dMt()) / 2L);
    e.h(this.AhR);
    ap localap = e.f(this.AhR);
    l = e.dMt();
    localap.ag(l, l);
    AppMethodBeat.o(34186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e.2
 * JD-Core Version:    0.7.0.1
 */