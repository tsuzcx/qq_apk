package com.tencent.mm.ui.bizchat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.ag;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.q;

final class BizChatConversationUI$BizChatConversationFmUI$7
  implements bp.a
{
  BizChatConversationUI$BizChatConversationFmUI$7(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI, long paramLong) {}
  
  public final boolean amG()
  {
    AppMethodBeat.i(232777);
    boolean bool = BizChatConversationUI.BizChatConversationFmUI.l(this.PaS);
    AppMethodBeat.o(232777);
    return bool;
  }
  
  public final void amH()
  {
    AppMethodBeat.i(232778);
    if (BizChatConversationUI.BizChatConversationFmUI.m(this.PaS) != null)
    {
      ag.baj().Am(this.iBR);
      ag.bak().Am(this.iBR);
      if (ag.bak().Nz(BizChatConversationUI.BizChatConversationFmUI.a(this.PaS)) <= 0)
      {
        bg.aVF();
        c.aST().bjW(BizChatConversationUI.BizChatConversationFmUI.a(this.PaS));
      }
      BizChatConversationUI.BizChatConversationFmUI.m(this.PaS).dismiss();
    }
    AppMethodBeat.o(232778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.7
 * JD-Core Version:    0.7.0.1
 */