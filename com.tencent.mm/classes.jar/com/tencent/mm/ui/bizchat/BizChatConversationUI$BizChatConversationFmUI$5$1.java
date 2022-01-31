package com.tencent.mm.ui.bizchat;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.g;

final class BizChatConversationUI$BizChatConversationFmUI$5$1
  implements n.c
{
  BizChatConversationUI$BizChatConversationFmUI$5$1(BizChatConversationUI.BizChatConversationFmUI.5 param5) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(30059);
    if (BizChatConversationUI.BizChatConversationFmUI.l(this.ztw.ztv) == 1)
    {
      paraml.aw(2, 2131299330, 2131230733);
      g.s(this.ztw.ztv.getContext(), BizChatConversationUI.BizChatConversationFmUI.a(this.ztw.ztv), 6);
    }
    paraml.aw(1, 2131297752, 2131230726);
    paraml.a(4, this.ztw.ztv.getResources().getString(2131297751), aj.g(this.ztw.ztv.getContext(), 2131230731, -1));
    paraml.a(3, this.ztw.ztv.getResources().getString(2131296408), aj.g(this.ztw.ztv.getContext(), 2131230759, -1));
    AppMethodBeat.o(30059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.5.1
 * JD-Core Version:    0.7.0.1
 */