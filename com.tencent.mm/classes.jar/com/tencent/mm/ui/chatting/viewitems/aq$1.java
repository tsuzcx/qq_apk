package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;

final class aq$1
  implements f
{
  aq$1(aq paramaq) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33394);
    ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + paramInt1 + " errCode " + paramInt2 + "  scene " + paramm.getType());
    aw.Rc().b(221, aq.a(this.zYg));
    aq.b(this.zYg);
    AppMethodBeat.o(33394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.1
 * JD-Core Version:    0.7.0.1
 */